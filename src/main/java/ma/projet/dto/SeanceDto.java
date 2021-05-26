package ma.projet.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeanceDto {

	private Long id;
	private Date heureDebut;
	private Date heureFin;
	private String nature;
	private MatiereDto matiere;
	private List<AbsenceDto> absences = new ArrayList<>();
}
