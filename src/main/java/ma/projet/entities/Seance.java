package ma.projet.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Seance implements Serializable {

	private static final long serialVersionUID = -8600385042823214686L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	@Temporal(TemporalType.TIME)
	private Date heureDebut;
	@Temporal(TemporalType.TIME)
	private Date heureFin;
	@Column(length = 10)
	private String nature;
	@OneToOne
	@JsonIgnore
	private Matiere matiere;
	@OneToMany(mappedBy="seance",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Absence> absences = new ArrayList<>();
	@OneToOne(fetch = FetchType.EAGER)
	private Salle salle;
	@OneToOne
	private Niveau niveau ;
	@OneToOne
	private Filiere filiere;
	private boolean passe ;
}
