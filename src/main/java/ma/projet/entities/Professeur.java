package ma.projet.entities;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	@OneToOne
	private Filiere chefDeFiliere;
	@ManyToOne
	@JsonIgnore
	private Departement departement;
	@ManyToMany(mappedBy = "professeurs",cascade = CascadeType.ALL)
	@JsonIgnore
	private java.util.List<Filiere>  filieres = new ArrayList<>();
	@OneToMany(mappedBy="professeur",cascade = CascadeType.ALL)
	@JsonIgnore
	private java.util.List<Matiere> matiere = new ArrayList<>();
	@OneToOne(mappedBy = "professeur",cascade = CascadeType.ALL)
	@JsonIgnore
	private Module module;
	private String image;
	public String toString() {
		return "id : "+id+"  nom : "+nom;
	}

}
