package ma.projet.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.projet.entities.Departement;
@RepositoryRestResource
public interface DepartementRepository extends JpaRepository<Departement, Long> {

}
