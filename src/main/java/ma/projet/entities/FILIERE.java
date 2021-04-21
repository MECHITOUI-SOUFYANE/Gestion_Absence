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

public class FILIERE {
	
	private @Id @GeneratedValue Long idFilier;
	  private Long idChefFilier;
	  private String nomFilier;
	  

	  
	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof FILIERE))
	      return false;
	    FILIERE filiere = (FILIERE) o;
	    return Objects.equals(this.nomFilier, filiere.nomFilier);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.idFilier, this.nomFilier, this.idChefFilier);
	  }

	  @Override
	  public String toString() {
	    return "FILIERE{" + "id=" + this.idFilier + ", name='" + this.nomFilier + '\'' + ", a chef de code som='" + this.idChefFilier + '\'' + '}';
	  }
	

}
