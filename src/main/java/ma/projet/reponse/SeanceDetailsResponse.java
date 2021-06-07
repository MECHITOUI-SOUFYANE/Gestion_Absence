package ma.projet.reponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.projet.entities.Seance;
@Data @AllArgsConstructor @NoArgsConstructor
public class SeanceDetailsResponse implements Serializable {
	private static final long serialVersionUID = 2754966290518962824L;	
	private String professeurName;
	private String moduleName;
	private Date jour;
	private Seance seance;
	private List<EtudiantResponse> etudiantResponses = new ArrayList<>();
	private String notFoundMessage;

}
