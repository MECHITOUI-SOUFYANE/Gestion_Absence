package ma.projet.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDto {

	private long id;
	private String nom;

	private DepartementDto departement;

	private ProfesseurDto professeur;

	private NiveauDto niveau;

	private List<EtudiantDto> etudiants = new ArrayList<>();
}
