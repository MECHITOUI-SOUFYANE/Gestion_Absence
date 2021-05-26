package ma.projet.request;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class DeparetmentRequest {

	
	private String nom;
	private List<ProfesseurRequest> professeurs = new ArrayList<>();	
	private List<ModuleRequest> modules = new ArrayList<>();

	
}
