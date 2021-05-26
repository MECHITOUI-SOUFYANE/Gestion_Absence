package ma.projet.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class AbsenceRequest {

	private int semain;
	private boolean justifie;
}
