package ma.projet.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.text.ParseException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.dto.ProfesseurDto;
import ma.projet.entities.Absence;
import ma.projet.reponse.AbsenceParMatiere;
import ma.projet.reponse.ProfesseurResponse;
import ma.projet.reponse.SeanceDetailsResponse;
import ma.projet.repositorie.AppUserRepository;
import ma.projet.repositorie.ProfesseurRepository;
import ma.projet.request.AbsenceRequestUpdate;
import ma.projet.request.EtudiantMatiereRequest;
import ma.projet.request.EtudiantSeanceRequest;
import ma.projet.request.ProfesseurRequest;
import ma.projet.service.AbsenceMangementService;
import ma.projet.service.AccountService;

@RestController
public class ProfesseurController {

	@Autowired
	private AbsenceMangementService absenceMangementService;
	@Autowired
	private ProfesseurRepository professeurRepository;
	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private AccountService accountService;

	@PostMapping("/professeur/absence")
	public ResponseEntity<List<Absence>> absence(@RequestBody EtudiantSeanceRequest etudiantSeanceRequest) {

		System.out.println(etudiantSeanceRequest.getEtudiantRequests());
		System.out.println(etudiantSeanceRequest.getIdSeance());

		absenceMangementService.setAbsence(etudiantSeanceRequest.getEtudiantRequests(),
				etudiantSeanceRequest.getIdSeance());

		return new ResponseEntity<>(HttpStatus.OK);

	}
	@GetMapping(path="/professeur/image",produces = { MediaType.IMAGE_JPEG_VALUE })
	public byte[] getImage (Principal principale) throws Exception {
		String image = professeurRepository.findById(appUserRepository.findByUsername(principale.getName()).get().getId()).get().getImage();	
		File file = new File(System.getProperty("user.home")+"/Desktop/"+image);
		Path path = Paths.get(file.toURI());
		System.out.println(path.toString());
		return Files.readAllBytes(path);
	}
	@GetMapping(path = "/professeur/information")
	public ResponseEntity<ProfesseurResponse> getCurrentProfesseurInformation(Principal principal){
		return new ResponseEntity<>(accountService.getCurrentProfesseur(principal.getName()),HttpStatus.OK);
	}
	@PostMapping(path = "/admin/create", produces = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
					MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ProfesseurResponse> createProfesseur(@RequestBody ProfesseurRequest professeurRequest) {
		ProfesseurDto professeurDto = new ModelMapper().map(professeurRequest, ProfesseurDto.class);
		absenceMangementService.createProfesseur(professeurDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(path = "/professeur/etudiants", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<SeanceDetailsResponse> getEtudiants(Principal principal) throws Exception {
		SeanceDetailsResponse seanceDetailsResponse = absenceMangementService.getEtudiantsByProf(principal.getName());
		return new ResponseEntity<>(seanceDetailsResponse, HttpStatus.OK);
	}

	@GetMapping(path = "/professeur/matieres/absences", produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<AbsenceParMatiere>> getEtudiantsAbsencesByMatiere(Principal principal) {

		return new ResponseEntity<List<AbsenceParMatiere>>(
				absenceMangementService.getAbsencesEtudiant(principal.getName()), HttpStatus.OK);

	}

	@GetMapping(path="/professeur/etudiants/absences",produces =  {MediaType.APPLICATION_JSON_VALUE},
		     consumes =  {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<AbsenceParMatiere> getEtudiantsByMatiere(Principal principal) throws ParseException{
		
		return new ResponseEntity<AbsenceParMatiere>(absenceMangementService.getEtudiant(principal.getName()),HttpStatus.OK) ;
		
	}
	@PostMapping(path="/matiere/etudiant/absence/detaills")
	public ResponseEntity<List<Absence>> getAbsenceAndSeanceOfEtudiant(@RequestBody	EtudiantMatiereRequest etudiantMatiereRequest,Principal principal){
		return new ResponseEntity<List<Absence>>(absenceMangementService.getAbsencesInSeanceOfEtudiant(etudiantMatiereRequest,principal.getName()),HttpStatus.OK);
		
	}
																	
	@PostMapping(path="/absence/update")
	public ResponseEntity<Absence> updateAbsence(@RequestBody AbsenceRequestUpdate idAbsence,Principal principal){
		return new ResponseEntity<Absence>(absenceMangementService.updateAbsence(idAbsence.getId(),principal.getName()), HttpStatus.ACCEPTED);
	}
	
}
