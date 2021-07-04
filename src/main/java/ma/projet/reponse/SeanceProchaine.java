package ma.projet.reponse;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
@Data 
public class SeanceProchaine implements Serializable {

	private static final long serialVersionUID = 7731729699230487318L;

	private final String str ;
	private Date jour;
	private Date heure;
	private String salleBlock;
	private String filliereNiveau;
	private String matiere;
	
	
	public SeanceProchaine(){
		this.str="vous ne reste pas une seance";
	}


	public SeanceProchaine( Date jour, Date heure, String salleBlock, String filliereNiveau,
			String matiere) {
		this.str="vous n'avez pas une seance actuellement , la seance prochaine : ";
		this.jour = jour;
		this.heure = heure;
		this.salleBlock = salleBlock;
		this.filliereNiveau = filliereNiveau;
		this.matiere = matiere;
	}
	
	
}
