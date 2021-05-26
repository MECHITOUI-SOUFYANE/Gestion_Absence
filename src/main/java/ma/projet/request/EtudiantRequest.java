package ma.projet.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class EtudiantRequest {
	
	private Long idEtudiant;
	
	private boolean absence;

}
