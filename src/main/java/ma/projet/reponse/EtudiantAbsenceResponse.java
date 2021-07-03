package ma.projet.reponse;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class EtudiantAbsenceResponse implements Serializable {

	private static final long serialVersionUID = -3185953771715311186L;
	private long id;
	private String nom ;
	private String prenom;
	private String cne;
	private Long nombreAbsence;

}
