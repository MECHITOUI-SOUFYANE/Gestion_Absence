package ma.projet.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class EtudiantDto {
	private long id;
	private Long numeroApogee;
	private String cne;
	private String nom;
	private String prenom;
	private List<ModuleDto> modules = new ArrayList<>();
	private List<AbsenceDto> absences = new ArrayList<>();
}
