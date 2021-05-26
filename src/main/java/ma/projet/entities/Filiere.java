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
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Filiere implements Serializable {

	private static final long serialVersionUID = -1069637275020783041L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 80)
	private String nom;
	@OneToOne
	private Professeur professeur; //chef de filiere
	@ManyToMany
	private List<Niveau> niveaus = new ArrayList<>() ;
}
