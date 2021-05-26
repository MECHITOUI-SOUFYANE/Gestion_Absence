package ma.projet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Departement implements Serializable {

	private static final long serialVersionUID = -8467868169617762036L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 80)
	private String nom;
	@OneToMany(mappedBy = "departement" , cascade = CascadeType.ALL)
	private List<Professeur> professeurs = new ArrayList<>();
	@OneToMany(mappedBy = "departement")
	private List<Module> modules = new ArrayList<>();

}
