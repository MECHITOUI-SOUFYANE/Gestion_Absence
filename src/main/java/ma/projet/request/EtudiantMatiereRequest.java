package ma.projet.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class EtudiantMatiereRequest {

	private long idEtudiant;
	private long idMatiere;
}
