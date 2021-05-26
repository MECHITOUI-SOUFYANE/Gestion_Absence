package ma.projet.service;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ma.projet.dto.EtudiantDto;
import ma.projet.dto.ProfesseurDto;
import ma.projet.entities.Absence;
import ma.projet.entities.AppUser;
import ma.projet.entities.Etudiant;
import ma.projet.entities.Module;
import ma.projet.entities.Professeur;
import ma.projet.entities.Seance;
import ma.projet.reponse.EtudiantResponse;
import ma.projet.reponse.SeanceDetailsResponse;
import ma.projet.repositorie.AbsenceRepository;
import ma.projet.repositorie.AppUserRepository;
import ma.projet.repositorie.EtudiantRepository;
import ma.projet.repositorie.MatiereRepository;
import ma.projet.repositorie.ModuleRepository;
import ma.projet.repositorie.ProfesseurRepository;
import ma.projet.repositorie.SeanceRepository;
import ma.projet.request.EtudiantRequest;
@Service
@Transactional
public class AbsenceMangementServiceImpl implements AbsenceMangementService {


	@Autowired
	private ProfesseurRepository professeurRepository;
	@Autowired
	private AbsenceRepository absenceRepository;
	@Autowired
	private MatiereRepository matiereRepository;
	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private SeanceRepository seanceRepository;
	@Autowired
	AppUserRepository appUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	

	@Override
	public Professeur createProfesseur(ProfesseurDto user) {
//		Professeur professeur = professeurRepository.findByUsername(user.getUsername());
//		if(professeur != null) throw new RuntimeException("teacher already exist");
//		professeur = new Professeur();
//		BeanUtils.copyProperties(user, professeur);
//		professeur.setPassword(passwordEncoder.encode(user.getPassword()));
//		return professeurRepository.save(professeur);
		return null;
	}


	@Override
	public void setAbsence(List<EtudiantRequest> etudiants,Long idSeance) {
		
		
		Optional<Seance> OptionalSeance =seanceRepository.findById(idSeance);
		Seance seance = OptionalSeance.get();	
		// Ajouter 7 jours(une semaine) dans la date de la seance prochaine
//		Date seanceDate = seance.getDate();
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(seanceDate);
//		calendar.add(Calendar.DATE, 7);
//		seanceDate = calendar.getTime();
//		seanceRepository.
		
		List<Long> ids = new ArrayList<>();	
		for (EtudiantRequest etudiant : etudiants) {
			ids.add(etudiant.getIdEtudiant());
		}
		List<Etudiant> etudiants2 = etudiantRepository.findAllById(ids);
 		Collection<Absence> absences = new ArrayList<Absence>();
		for (Etudiant etudiant : etudiants2) {
			Absence absence = new Absence();
			absence.setEtudiant(etudiant);
			absence.setSeance(seance);
			absence.setDate(seance.getDate());
			absence.setJustifie(false);	
			absences.add(absence);
		}
		
	
	}
	

	@Override
	public SeanceDetailsResponse getEtudiantsByProf(String username) throws ParseException{
		Optional<AppUser> appUser = appUserRepository.findByUsername(username);
		Optional<Professeur> professeur = professeurRepository.findById(appUser.get().getId());
		//seance 

		Date currentHeure = new SimpleDateFormat("HH:mm:ss").parse(LocalTime.now().format(DateTimeFormatter.ISO_TIME));
		Date currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
		
		Long idSeance = seanceRepository.findIdSeance(currentHeure, currentDate, appUser.get().getId());
		
		//module
		Long idModule = matiereRepository.findIdModuleByProfesseurAndSeance( currentHeure, currentDate, professeur.get().getId());
		SeanceDetailsResponse seanceDetailsResponse = new SeanceDetailsResponse();
		if(idModule!=null) {
			Optional<Module> opModule = moduleRepository.findById(idModule);
			System.out.println(opModule.get().getNom());
			//etudiants	
			List<Etudiant> etudiants = etudiantRepository.findByIdModule(idModule);
			/*List<Etudiant> to List<EtudiantDto>*/
			Type listType = new TypeToken<List<EtudiantDto>>() {
			}.getType();	
			List<EtudiantDto> etudiantDtos = new ModelMapper().map(etudiants, listType);
			/*List<EtudiantDto> to List<EtudiantResponse>*/
			Type listType2 = new TypeToken<List<EtudiantResponse>>() {
			}.getType();	
			List<EtudiantResponse> etudiantResponses = new ModelMapper().map(etudiantDtos, listType2);
			
			seanceDetailsResponse.setEtudiantResponses(etudiantResponses);
			seanceDetailsResponse.setJour(currentDate);
			seanceDetailsResponse.setModuleName(opModule.get().getNom());
			seanceDetailsResponse.setIdSeance(idSeance);
			seanceDetailsResponse.setProfesseurName(professeur.get().getNom());
		
		}else {
			seanceDetailsResponse.setNotFoundMessage("vous n/'avez pas une seance actuellement ");
	}
		
		return seanceDetailsResponse;
		
	}

	
}
