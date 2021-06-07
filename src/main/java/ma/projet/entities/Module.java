package ma.projet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Module implements Serializable {

	private static final long serialVersionUID = -3411483627620774866L;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 40)
	private String nom;
	@ManyToOne
	@JsonIgnore
	private Departement departement;
	@OneToOne
	@JsonIgnore
	private Professeur professeur;
	@ManyToOne
	@JsonIgnore // 7aliyan
	private Niveau niveau;
	@ManyToMany
	private List<Etudiant> etudiants = new ArrayList<>();

}
