package ma.projet.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ma.projet.entities.AppRole;
import ma.projet.entities.AppUser;
import ma.projet.entities.Professeur;
import ma.projet.reponse.ProfesseurResponse;
import ma.projet.repositorie.AppRoleRepository;
import ma.projet.repositorie.AppUserRepository;
import ma.projet.repositorie.ProfesseurRepository;
@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AppUserRepository appUserRepository;
	@Autowired
	AppRoleRepository appRoleRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired 
	ProfesseurRepository  professeurRepository;
	@Override
	public AppUser saveUser(AppUser user) {
		String hashPW = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hashPW);
		return appUserRepository.save(user);
	}

	@Override
	public AppRole saveRole(AppRole role) {
		return appRoleRepository.save(role);
	}

	@Override
	@Transactional
	public void addRoleToUser(String username, String rolename) {
		Optional<AppUser> user = appUserRepository.findByUsername(username);
		user.get().getRoles().add(appRoleRepository.findByRolename(rolename));
		
	}

	public Optional<AppUser> findUserByUserName(String username) {
		return appUserRepository.findByUsername(username);
	}

	@Override
	public ProfesseurResponse getCurrentProfesseur(String username) {
		Optional<AppUser> appUser = appUserRepository.findByUsername(username);
		Professeur professeur = professeurRepository.findById(appUser.get().getId()).get();
		
		return null;
	}

}
