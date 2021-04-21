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
	private @Id  Long NUM_APOGEE;
	//pourquoi on besoin d un id module si lid de niveau
	  private Long ID_niveau;
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
	    return Objects.equals(this.NUM_APOGEE, etudiant.NUM_APOGEE); 
	      
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.NUM_APOGEE, this.nom, this.prenom,this.cne,this.ID_niveau);
	  }

	  @Override
	  public String toString() {
	    return "ETUDIANT{" + "apogee=" + this.NUM_APOGEE + ", name='" + this.nom +" " +this.prenom +" cne: " +this.cne +" a niveau "+this.ID_niveau+ '\'' + '}';
	  }
}
