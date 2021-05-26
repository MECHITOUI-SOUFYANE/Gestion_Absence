package ma.projet.request;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor
public class NiveauRequest {

	private String nomDeNiveau;	
	private List<FiliereRequest> filieres = new ArrayList<>();
}
