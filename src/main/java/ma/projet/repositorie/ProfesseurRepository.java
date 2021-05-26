package ma.projet.repositorie;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.projet.entities.Professeur;
@RepositoryRestResource
public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {

	   Optional<Professeur> findById(Long id);
}
