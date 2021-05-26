package ma.projet.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.projet.entities.Filiere;
@RepositoryRestResource
public interface FiliereRepository extends JpaRepository<Filiere, Long> {

}
