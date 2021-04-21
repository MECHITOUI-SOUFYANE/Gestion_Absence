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

public class SALLE {
	private @Id @GeneratedValue Long idSalle;
	  private String bloc;
	  private String nomSalle;
	  
	
	@Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof SALLE))
	      return false;
	    SALLE salle = (SALLE) o;
	    return Objects.equals(this.bloc,salle.bloc) && Objects.equals(this.nomSalle,salle.nomSalle); 
	      
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.idSalle, this.nomSalle, this.bloc);
	  }
	  
	 @Override
	  public String toString() {
	    return "salle{" + "id=" + this.idSalle + ", nom='" + this.nomSalle +"a le bloc "+this.bloc+'\'' + '}';
	  }
}
