package ma.projet.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private boolean chefDeFiliere=false;
	@ManyToOne
	@JsonIgnore
	private Departement departement;
	@OneToOne(mappedBy = "professeur")
	@JsonIgnore
	private Filiere filiere ;
	@OneToMany(mappedBy="professeur")
	@JsonIgnore
	private java.util.List<Matiere> matiere = new ArrayList<>();
	@OneToOne(mappedBy = "professeur")
	@JsonIgnore
	private Module module;	
	public String toString() {
		return "id : "+id+"  nom : "+nom;
	}

}
