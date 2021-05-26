package ma.projet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class ProfesseurDto {

	private long id;
	private Long som;	
	private String nom;
	private String prenom;
	private String username;
	private String password;
	private boolean chefDeFiliere;
	private FiliereDto filiere ;
	private MatiereDto matiere;
	private ModuleDto module;

}
