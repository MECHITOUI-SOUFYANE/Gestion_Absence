package ma.projet.reponse;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class SeanceProchaine implements Serializable {

	private static final long serialVersionUID = 7731729699230487318L;

	private final String str ="vous n'avez pas une seance actuellement , la seance prochaine : ";
	private Date jour;
	private Date heure;
	private String salleBlock;
	private String filliereNiveau;
	private String matiere;
	
}
