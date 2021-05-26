package ma.projet.repositorie;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.projet.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{

	Optional<AppUser> findByUsername(String username);

}
