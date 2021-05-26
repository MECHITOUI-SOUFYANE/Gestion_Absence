package ma.projet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class AbsenceDto {

	private long id;
	private int semain;
	private boolean justifie;
	private EtudiantDto etudiant;
	private SeanceDto seance;
}
