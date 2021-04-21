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
	  private @Id @GeneratedValue Long idDepartement;
	  private Long idChefDepartement;
	  private String nom;
	  
	
	  
	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof DEPARTEMENT))
	      return false;
	    DEPARTEMENT departement = (DEPARTEMENT) o;
	    return Objects.equals(this.nom, departement.nom);
	  }

	  @Override
	  public int hashCode() {	    return Objects.hash(this.idDepartement, this.nom, this.idChefDepartement);
	  }

	  @Override
	  public String toString() {
	    return "departement{" + "id=" + this.idDepartement + ", name='" + this.nom + '\'' + ", a chef de code som='" + this.idChefDepartement + '\'' + '}';
	  }

}
