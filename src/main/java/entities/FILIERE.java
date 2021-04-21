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
	
	private @Id @GeneratedValue Long ID_filier;
	  private Long ID_CHEF_fil;
	  private String nom_fil;
	  

	  
	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof FILIERE))
	      return false;
	    FILIERE filiere = (FILIERE) o;
	    return Objects.equals(this.nom_fil, filiere.nom_fil);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.ID_filier, this.nom_fil, this.ID_CHEF_fil);
	  }

	  @Override
	  public String toString() {
	    return "FILIERE{" + "id=" + this.ID_filier + ", name='" + this.nom_fil + '\'' + ", a chef de code som='" + this.ID_CHEF_fil + '\'' + '}';
	  }
	

}
