package ma.projet.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class ProfesseurRequest {
	//appliquer la validation
	private Long som;	
	private String nom;
	private String prenom;
	private String username;
	private String password;
	private boolean chefDeFiliere;
	private FiliereRequest filiere ;
	private MatiereRequest matiere;
	private ModuleRequest module;

}
