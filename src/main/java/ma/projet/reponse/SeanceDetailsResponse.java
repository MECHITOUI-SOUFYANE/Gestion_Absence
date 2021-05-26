package ma.projet.reponse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class SeanceDetailsResponse {
	
	private List<EtudiantResponse> etudiantResponses = new ArrayList<>();
	private String professeurName;
	private String moduleName;
	private Date jour;
	private Long idSeance;
	private String notFoundMessage;
	

}
