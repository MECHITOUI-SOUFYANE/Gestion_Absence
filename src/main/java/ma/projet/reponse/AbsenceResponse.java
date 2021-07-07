package ma.projet.reponse;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.projet.entities.Etudiant;
@Data @AllArgsConstructor @NoArgsConstructor
public class AbsenceResponse {
	
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date date;
	private  boolean justifie;
	private Etudiant etudiant;

}
