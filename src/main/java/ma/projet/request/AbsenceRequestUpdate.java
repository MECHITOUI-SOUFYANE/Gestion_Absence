package ma.projet.request;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@JsonDeserialize
public class AbsenceRequestUpdate {

	private Long id;
}
