package ma.projet.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor

public class SALLE {
	private @Id @GeneratedValue Long id_salle;
	  private String Bloc;
	  private String nom_salle;
	  
	
	@Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof SALLE))
	      return false;
	    SALLE salle = (SALLE) o;
	    return Objects.equals(this.Bloc,salle.Bloc) && Objects.equals(this.nom_salle,salle.nom_salle); 
	      
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id_salle, this.nom_salle, this.Bloc);
	  }
	  
	 @Override
	  public String toString() {
	    return "salle{" + "id=" + this.id_salle + ", nom='" + this.nom_salle +"a le bloc "+this.Bloc+'\'' + '}';
	  }
}
