package ma.projet.repositorie;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import ma.projet.entities.Etudiant;
@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	@Query(value = "select * from etudiant "
			     + "left join module_etudiants on etudiant.id = module_etudiants.etudiants_id "
			     + "WHERE (module_etudiants.modules_id = :idModule) " , nativeQuery = true)
	List<Etudiant> findByIdModule(@Param("idModule")Long idModule);
}
