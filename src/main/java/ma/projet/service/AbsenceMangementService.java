package ma.projet.service;

import java.text.ParseException;
import java.util.List;

import ma.projet.dto.ProfesseurDto;
import ma.projet.entities.Absence;
import ma.projet.entities.Professeur;
import ma.projet.reponse.AbsenceParMatiere;
import ma.projet.reponse.SeanceDetailsResponse;
import ma.projet.request.EtudiantMatiereRequest;
import ma.projet.request.EtudiantRequest;

public interface AbsenceMangementService {

	Professeur createProfesseur(ProfesseurDto user);
	SeanceDetailsResponse getEtudiantsByProf(String email)  throws ParseException;
	List<AbsenceParMatiere> getAbsencesEtudiant(String username);
	void  setAbsence(List<EtudiantRequest> etudiants , Long idSeance);
	AbsenceParMatiere getEtudiant(String username) throws ParseException;
	List<Absence> getAbsencesInSeanceOfEtudiant(EtudiantMatiereRequest etudiantMatiereRequest);
	Absence updateAbsence(Long id);
}
