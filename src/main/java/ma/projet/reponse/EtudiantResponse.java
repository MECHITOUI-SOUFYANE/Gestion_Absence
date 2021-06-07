package ma.projet.reponse;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class EtudiantResponse implements Serializable{
	private static final long serialVersionUID = 4510656509291095488L;
	private long id;
	private Long numeroApogee;
	private String cne;
	private String nom;
	private String prenom;
}
