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


public class PROFESSEUR {
	//som n est pas auto increment;
	  private @Id @GeneratedValue Long som;
	  private Long idDepartement;
	  private String nom;
	  private String prenom;
	  private String password;
	 
	 
	@Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof PROFESSEUR))
	      return false;
	    PROFESSEUR professeur = (PROFESSEUR) o;
	    return Objects.equals(this.som, professeur.som); 
	      
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.som, this.nom, this.prenom,this.password);
	  }

	  @Override
	  public String toString() {
	    return "Professeur{" + "som=" + this.som + ", name='" + this.nom +" " +this.prenom + '\'' + '}';
	  }
	  
}
