package ma.projet.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class SeanceRequest {

	private Date heureDebut;
	private Date heureFin;
	private String nature;
	private List<AbsenceRequest> absences = new ArrayList<>();
}
