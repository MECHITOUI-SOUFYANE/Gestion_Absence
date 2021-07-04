package ma.projet.service;

import java.util.Optional;

import ma.projet.entities.AppRole;
import ma.projet.entities.AppUser;
import ma.projet.reponse.ProfesseurResponse;


public interface AccountService {

	public  AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username, String rolename);
	public Optional<AppUser> findUserByUserName(String username);
	public ProfesseurResponse getCurrentProfesseur(String username);
}
