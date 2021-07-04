package ma.projet.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ma.projet.entities.AppRole;
import ma.projet.entities.AppUser;
import ma.projet.entities.Professeur;
import ma.projet.reponse.FiliereResponse;
import ma.projet.reponse.MatiereResponse;
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
		ProfesseurResponse professeurResponse = new ProfesseurResponse();
		professeurResponse.setSom(professeur.getSom());
		professeurResponse.setEmail(appUser.get().getUsername());
		professeurResponse.setNom(professeur.getNom());
		professeurResponse.setPrenom(professeur.getPrenom());
		List<FiliereResponse> filiereResponses = new ArrayList<>();
		professeur.getFilieres().forEach(filiere->{
			FiliereResponse filiereResponse = new FiliereResponse();
			filiereResponse.setId(filiere.getId());
			filiereResponse.setNomFiliere(filiere.getNom());
			filiereResponses.add(filiereResponse);
			});
		List<MatiereResponse> matiereResponses = new ArrayList<>();
		professeur.getMatiere().forEach(matiere->{
			MatiereResponse matiereResponse = new MatiereResponse();
			matiereResponse.setIntitule(matiere.getIntitule());
			matiereResponses.add(matiereResponse);
		});
		professeurResponse.setFiliereResponses(filiereResponses);
		professeurResponse.setMatiereResponses(matiereResponses);
		return professeurResponse;
	}

}
