package ma.projet.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class NIVEAU {
	private @Id @GeneratedValue Long id_niveau;
	private long id_filiere;
	
	
	 @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof MODULE))
	      return false;
	    NIVEAU niveau = (NIVEAU) o;
	    return Objects.equals(this.id_niveau, niveau.id_niveau) && Objects.equals(this.id_filiere, niveau.id_filiere); 
	      
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id_niveau, this.id_filiere);
	  }

	  @Override
	  public String toString() {
	    return "niveau{" + "id=" + this.id_niveau + " a filier "+this.id_filiere+ '\'' + '}';
	  }
	  
	
}
