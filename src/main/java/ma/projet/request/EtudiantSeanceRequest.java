package ma.projet.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class EtudiantSeanceRequest {
	
	private List<EtudiantRequest> etudiantRequests ;
	private Long idSeance;

}
