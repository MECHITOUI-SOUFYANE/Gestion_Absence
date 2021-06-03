package ma.projet.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Professeur implements Serializable {
	
	private static final long serialVersionUID = -7321424198321007533L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long som;
	@Column(length = 40)
	private String nom;
	@Column(length = 40)
	private String prenom;
//	@Column(length = 80)
//	private String username;
//	private String password;
	private boolean chefDeFiliere=false;
	@ManyToOne
	private Departement departement;
	@OneToOne(mappedBy = "professeur")
	private Filiere filiere ;
	@OneToOne(mappedBy="professeur" , fetch = FetchType.EAGER)
	private Matiere matiere;
	@OneToOne(mappedBy = "professeur")
	private Module module;
	
	public String toString() {
		return "id : "+id+"  nom : "+nom;
	}

}
