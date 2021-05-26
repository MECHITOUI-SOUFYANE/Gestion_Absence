package ma.projet.request;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ModuleRequest {
	private String nom;
	
	private NiveauRequest niveau;
	
	private List<EtudiantRequest> etudiants = new ArrayList<>();

}
