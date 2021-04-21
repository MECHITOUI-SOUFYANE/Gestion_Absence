package ma.projet.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor


public class PROFESSEUR {
	//SOM n est pas auto increment;
	  private @Id @GeneratedValue Long SOM;
	  private Long ID_DEP;
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
	    return Objects.equals(this.SOM, professeur.SOM); 
	      
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.SOM, this.nom, this.prenom,this.password);
	  }

	  @Override
	  public String toString() {
	    return "Professeur{" + "SOM=" + this.SOM + ", name='" + this.nom +" " +this.prenom + '\'' + '}';
	  }
	  
}
