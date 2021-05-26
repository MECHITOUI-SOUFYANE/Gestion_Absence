package ma.projet.entities;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Absence implements Serializable {

	private static final long serialVersionUID = -6422401645517333857L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Temporal(TemporalType.DATE)
	Date date;
	private boolean justifie;
	@ManyToOne
	private Etudiant etudiant;
	@ManyToOne
	private Seance seance;
}
