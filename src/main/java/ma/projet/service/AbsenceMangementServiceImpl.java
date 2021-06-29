package ma.projet.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.projet.dto.ProfesseurDto;
import ma.projet.entities.Absence;
import ma.projet.entities.AppUser;
import ma.projet.entities.Etudiant;
import ma.projet.entities.Matiere;
import ma.projet.entities.Module;
import ma.projet.entities.Professeur;
import ma.projet.entities.Seance;
import ma.projet.reponse.AbsenceParMatiere;
import ma.projet.reponse.EtudiantAbsenceResponse;
import ma.projet.reponse.EtudiantResponse;
import ma.projet.reponse.SeanceDetailsResponse;
import ma.projet.repositorie.AbsenceRepository;
import ma.projet.repositorie.AppUserRepository;
import ma.projet.repositorie.EtudiantRepository;
import ma.projet.repositorie.MatiereRepository;
import ma.projet.repositorie.ProfesseurRepository;
import ma.projet.repositorie.SeanceRepository;
import ma.projet.request.EtudiantMatiereRequest;
import ma.projet.request.EtudiantRequest;
@Service
@org.springframework.transaction.annotation.Transactional
public class AbsenceMangementServiceImpl implements AbsenceMangementService {


	@Autowired
	private ProfesseurRepository professeurRepository;
	@Autowired
	private AbsenceRepository absenceRepository;
	@Autowired
	private MatiereRepository matiereRepository;
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private SeanceRepository seanceRepository;
	@Autowired
	private AppUserRepository appUserRepository;
	
	
	
	

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

		 {

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
			
			absenceRepository.saveAll(absences);
		}	
	
	}
	

	@Override
	public SeanceDetailsResponse getEtudiantsByProf(String username) throws ParseException{
		Optional<AppUser> appUser = appUserRepository.findByUsername(username);
		Optional<Professeur> professeur = professeurRepository.findById(appUser.get().getId());
		//seance 

		Date currentHeure = new SimpleDateFormat("HH:mm:ss").parse(LocalTime.now().format(DateTimeFormatter.ISO_TIME));
		Date currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
		

		List<Matiere> matieres = matiereRepository.findByProfesseur(professeur.get());
		Seance seance  = new Seance();
		Matiere imatiere = new Matiere();
		for (Matiere matiere : matieres) {
			seance = matiere.getSeance().stream().filter(s -> s.getDate().equals(currentDate)
					&&s.getHeureDebut().before(currentHeure)&&
					s.getHeureFin().after(currentHeure)).findFirst().orElse(null);
			
			if(seance!=null) {
				imatiere = matiere;
				break;
			}
		}
		
	
		SeanceDetailsResponse seanceDetailsResponse = new SeanceDetailsResponse();
		if(seance!=null) {
			Module module = imatiere.getModule();
			List<Etudiant>etudiants = module.getEtudiants();	
			List<EtudiantResponse> etudiantResponses = new ArrayList<>();
			etudiants
				.forEach(etudiant->{
				    EtudiantResponse etudiantResponse = new EtudiantResponse(); 
				    etudiantResponse.setCne(etudiant.getCne());
				    etudiantResponse.setId(etudiant.getId());
				    etudiantResponse.setNom(etudiant.getNom());
				    etudiantResponse.setPrenom(etudiant.getPrenom());
				    etudiantResponse.setNumeroApogee(etudiant.getNumeroApogee());
				    etudiantResponses.add(etudiantResponse);});
			
			
			seanceDetailsResponse.setEtudiantResponses(etudiantResponses);
			seanceDetailsResponse.setJour(currentDate);
			seanceDetailsResponse.setMatiereName(imatiere.getIntitule());
			seanceDetailsResponse.setSeance(seance);
			seanceDetailsResponse.setProfesseurName(professeur.get().getNom());
			seanceDetailsResponse.setNotFoundMessage("");
		
		}else {
			
			seanceDetailsResponse.setNotFoundMessage("vous n/'avez pas une seance actuellement ");
	}
		
		return seanceDetailsResponse;
		
	}


	@Override
	public List<AbsenceParMatiere> getAbsencesEtudiant(String username) {
		Optional<AppUser> appUser = appUserRepository.findByUsername(username);
		Optional<Professeur> professeur = professeurRepository.findById(appUser.get().getId());
		List<Matiere> matieres = matiereRepository.findByProfesseur(professeur.get());
		List<AbsenceParMatiere> absenceParMatiere = new ArrayList<>();
		matieres.stream().forEach(matiere->{
			List<EtudiantAbsenceResponse> etudiantAbsenceResponses = new ArrayList<>();
			matiere.getModule()
					.getEtudiants()
						.stream()
							.filter(etudiants->etudiants.getAbsences().size()>0)
							.forEach(etudiant->{
								 int nbr = etudiant.getAbsences().stream().filter(absence -> absence.getSeance().getMatiere().equals(matiere)).collect(Collectors.toList()).size();
								 if(nbr>0) {
								 EtudiantAbsenceResponse etudiantResponse = new EtudiantAbsenceResponse(); 
								 etudiantResponse.setCne(etudiant.getCne());   
								 etudiantResponse.setNom(etudiant.getNom());
								 etudiantResponse.setPrenom(etudiant.getPrenom());
								 etudiantResponse.setNombreAbsence((long)nbr);
								 etudiantAbsenceResponses.add(etudiantResponse);
								 }
							});
			
			absenceParMatiere.add(new AbsenceParMatiere(matiere.getIntitule(), matiere.getId(), etudiantAbsenceResponses));
		});
		
		System.out.println("fin");
		
		return absenceParMatiere;
	}
	@Override
	public AbsenceParMatiere getEtudiant(String username) throws ParseException {
		Optional<AppUser> appUser = appUserRepository.findByUsername(username);
		Optional<Professeur> professeur = professeurRepository.findById(appUser.get().getId());
		List<Matiere> matieres = matiereRepository.findByProfesseur(professeur.get());
		Date currentHeure = new SimpleDateFormat("HH:mm:ss").parse(LocalTime.now().format(DateTimeFormatter.ISO_TIME));
		Date currentDate = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
		AbsenceParMatiere absenceParMatiere = new AbsenceParMatiere();
		List<EtudiantAbsenceResponse> list = new ArrayList<>();

		
		Seance seance  = new Seance();
		Matiere imatiere = new Matiere();
		for (Matiere matiere : matieres) {
			seance = matiere.getSeance().stream().filter(s -> s.getDate().equals(currentDate)
					&&s.getHeureDebut().before(currentHeure)&&
					s.getHeureFin().after(currentHeure)).findFirst().orElse(null);
			if(seance!=null) {
				imatiere = matiere;
				break;
			}
		}
		if(seance!=null) {
			final Seance s= seance;
			Module module = imatiere.getModule();
			List<Etudiant>etudiants = module.getEtudiants();
			etudiants
				.stream()
					.forEach(etudiant->{
				    EtudiantAbsenceResponse etudiantResponse = new EtudiantAbsenceResponse(); 
				    etudiantResponse.setCne(etudiant.getCne());
				    
				    etudiantResponse.setNom(etudiant.getNom());
				    etudiantResponse.setPrenom(etudiant.getPrenom());
				    etudiantResponse.setNombreAbsence( etudiant.getAbsences().stream()
							.filter(absence->absence.getSeance().equals(s)).count());
				    list.add(etudiantResponse);
				    });
			
			absenceParMatiere.setEtudiantAbsenceResponses(list);
			absenceParMatiere.setMatiere(imatiere.getIntitule());
			absenceParMatiere.setIdMatiere(imatiere.getId());
			
		}
		System.out.println(list);
		return absenceParMatiere;
		
	}
	@Override
	public List<Absence> getAbsencesInSeanceOfEtudiant(EtudiantMatiereRequest etudiantMatiereRequest) {
		
		Etudiant etudiant=etudiantRepository.findById(etudiantMatiereRequest.getIdEtudiant()).get();		
		Matiere matiere = matiereRepository.findById(etudiantMatiereRequest.getIdMatiere()).get();
		
	    return etudiant.getAbsences().stream().filter(absence -> absence.getSeance().getMatiere().equals(matiere)).collect(Collectors.toList());
		
	}


	
}
