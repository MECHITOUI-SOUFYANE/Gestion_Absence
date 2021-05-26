package ma.projet.repositorie;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ma.projet.entities.Matiere;
import ma.projet.entities.Professeur;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {
	List<Matiere> findByProfesseur(Professeur professeur);
	
	@Query(value="SELECT matiere.intitule FROM matiere WHERE matiere.id = :idMatiere", nativeQuery = true)
	String findByIdModule(@Param("idMatiere") Long idMatiere);
	
	@Query(value="SELECT matiere.module_id FROM matiere"
			+ "   LEFT JOIN seance ON matiere.id = seance.matiere_id"
			+ "   WHERE (seance.heure_debut <=  :currentHeure AND :currentHeure <= seance.heure_fin AND seance.date = :currentJour) "
			+ "   AND matiere.professeur_id = :id_professeur", nativeQuery = true)
	Long findIdModuleByProfesseurAndSeance(@Param("currentHeure") Date currentHour,@Param("currentJour") Date currentJour,@Param("id_professeur") Long id_professeur
);
}

