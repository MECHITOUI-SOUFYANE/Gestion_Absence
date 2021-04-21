package ma.projet.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Setter;
import lombok.Data;
import lombok.ToString

@Entity
@Data
@NoArgsConstructor
public class ETUDIANT {
	private @Id  Long numApogee;
	//pourquoi on besoin d un id module si lid de niveau
	  private Long idNiveau;
	  private String cne;
	  private String nom;
	  private String prenom;
	  
	
	 @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof ETUDIANT))
	      return false;
	    ETUDIANT etudiant = (ETUDIANT) o;
	    return Objects.equals(this.numApogee, etudiant.numApogee); 
	      
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.numApogee, this.nom, this.prenom,this.cne,this.idNiveau);
	  }

	  @Override
	  public String toString() {
	    return "ETUDIANT{" + "apogee=" + this.numApogee + ", name='" + this.nom +" " +this.prenom +" cne: " +this.cne +" a niveau "+this.idNiveau+ '\'' + '}';
	  }
}
