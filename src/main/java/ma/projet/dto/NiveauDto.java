package ma.projet.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class NiveauDto {

	private long id;
	private String nomDeNiveau;
	private List<FiliereDto> filieres = new ArrayList<>();
}
