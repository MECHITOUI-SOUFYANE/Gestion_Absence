package ma.projet.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ma.projet.entities.AppUser;
import ma.projet.repositorie.AppUserRepository;

public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	AppUserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(username);
		Optional<AppUser> user = userRepository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("No User Found"));
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		user.get().getRoles().forEach((role) -> authorities.add(new SimpleGrantedAuthority(role.getRolename())));
		return new User(username, user.get().getPassword(), authorities);
	}

}
