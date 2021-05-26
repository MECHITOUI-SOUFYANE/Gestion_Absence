package ma.projet.entities;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy.Definition.Undefined;

@Data
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "user")
public class AppUser {
	
	@Id 
	Long id;
	@Column(unique = true)
	String username;
	String password;
	@ManyToMany(fetch = FetchType.EAGER)
	List<AppRole> roles = new ArrayList<AppRole>();
	

}
