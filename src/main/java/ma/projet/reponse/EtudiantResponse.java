package ma.projet.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class EtudiantResponse {

	private long id;
	private Long numeroApogee;
	private String cne;
	private String nom;
	private String prenom;
}
