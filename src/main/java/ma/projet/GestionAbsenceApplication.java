package ma.projet;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ma.projet.entities.AppRole;
import ma.projet.entities.AppUser;
import ma.projet.repositorie.AppRoleRepository;
import ma.projet.repositorie.AppUserRepository;
import ma.projet.service.AccountService;

@SpringBootApplication
public class GestionAbsenceApplication{

	public static void main(String[] args) {
		SpringApplication.run(GestionAbsenceApplication.class, args);
	}

}
