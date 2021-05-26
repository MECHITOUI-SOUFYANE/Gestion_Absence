package ma.projet.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.projet.entities.Module;
@RepositoryRestResource
public interface ModuleRepository extends JpaRepository<Module, Long> {

}
