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
public class NIVEAU {
	private @Id @GeneratedValue Long idNiveau;
	private long idFiliere;
	
	
	 @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof MODULE))
	      return false;
	    NIVEAU niveau = (NIVEAU) o;
	    return Objects.equals(this.idNiveau, niveau.idNiveau) && Objects.equals(this.idFiliere, niveau.idFiliere); 
	      
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.idNiveau, this.idFiliere);
	  }

	  @Override
	  public String toString() {
	    return "niveau{" + "id=" + this.idNiveau + " a filier "+this.idFiliere+ '\'' + '}';
	  }
	  
	
}
