package ma.projet.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class DepartementDto {

	private long id;
	private String nom;
	private List<ProfesseurDto> professeurs = new ArrayList<>();	
	private List<ModuleDto> modules = new ArrayList<>();
}
