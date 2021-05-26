package ma.projet.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, Long>{

	AppRole findByRolename(String rolename);
}
