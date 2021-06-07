package ma.projet.reponse;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class AbsenceParMatiere implements Serializable {

	private static final long serialVersionUID = 8362983736904645964L;
	
	private String matiere;
	private List<EtudiantAbsenceResponse> etudiantAbsenceResponses = new ArrayList<>();
	

}
