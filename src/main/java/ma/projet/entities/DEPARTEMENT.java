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

public class DEPARTEMENT {
	  private @Id @GeneratedValue Long ID_DEP;
	  private Long ID_CHEF_DEP;
	  private String Nom;
	  
	
	  
	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof DEPARTEMENT))
	      return false;
	    DEPARTEMENT departement = (DEPARTEMENT) o;
	    return Objects.equals(this.Nom, departement.Nom);
	  }

	  @Override
	  public int hashCode() {	    return Objects.hash(this.ID_DEP, this.Nom, this.ID_CHEF_DEP);
	  }

	  @Override
	  public String toString() {
	    return "departement{" + "id=" + this.ID_DEP + ", name='" + this.Nom + '\'' + ", a chef de code som='" + this.ID_CHEF_DEP + '\'' + '}';
	  }

}
