package ma.projet.reponse;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class ProfesseurResponse {
	
	private Long som;
	private String nom;
	private String prenom;
	private String email;
	private String chefDeFiliere;
	private List<FiliereResponse> filiereResponses = new ArrayList<>();
	private List<MatiereResponse> matiereResponses = new ArrayList<>();
}
