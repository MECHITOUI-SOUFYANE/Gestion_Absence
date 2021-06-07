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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Etudiant implements Serializable {

	private static final long serialVersionUID = 9152228159060586245L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numeroApogee;
	@Column(length = 20)
	private String cne;
	@Column(length = 30)
	private String nom;
	@Column(length = 30)
	private String prenom;
	@ManyToMany(mappedBy = "etudiants")
	@JsonIgnore
	private List<Module> modules = new ArrayList<>();
	@OneToMany(mappedBy="etudiant")
	@JsonIgnore
	private List<Absence> absences = new ArrayList<>();

}
