package ma.projet.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class ProfesseurResponse {
	
	private Long som;
	private String nom;
	private String prenom;
	private String username;
	private boolean chefDeFiliere;
}
