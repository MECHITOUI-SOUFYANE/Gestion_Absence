package ma.projet.controller;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.projet.dto.ProfesseurDto;
import ma.projet.entities.Absence;
import ma.projet.reponse.ProfesseurResponse;
import ma.projet.reponse.SeanceDetailsResponse;
import ma.projet.request.EtudiantSeanceRequest;
import ma.projet.request.ProfesseurRequest;
import ma.projet.service.AbsenceMangementService;

@RestController
@CrossOrigin(origins = "*")
public class ProfesseurController {
	
	@Autowired
	private AbsenceMangementService absenceMangementService;
	
	@PostMapping("/professeur/absence" )
	public ResponseEntity<List<Absence>> absence (@RequestBody EtudiantSeanceRequest etudiantSeanceRequest) {
		
		absenceMangementService.setAbsence(etudiantSeanceRequest.getEtudiantRequests(), etudiantSeanceRequest.getIdSeance());
		
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	
	}
	@PostMapping(path = "/admin/create" , produces =  {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
		     consumes =  {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ProfesseurResponse> createProfesseur(@RequestBody ProfesseurRequest professeurRequest){
		ProfesseurDto professeurDto = new ModelMapper().map(professeurRequest, ProfesseurDto.class);
	    absenceMangementService.createProfesseur(professeurDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping(path="/professeur/etudiants")
	public ResponseEntity<SeanceDetailsResponse> getEtudiants(Principal principal) throws ParseException {
		SeanceDetailsResponse seanceDetailsResponse = absenceMangementService.getEtudiantsByProf(principal.getName());
		return new ResponseEntity<>(seanceDetailsResponse,HttpStatus.ACCEPTED);
	}
}
