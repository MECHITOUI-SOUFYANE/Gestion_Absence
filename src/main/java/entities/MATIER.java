package ma.projet.entities;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor

public class MATIER {
	//i think id de matier est auto increment
		private @Id @GeneratedValue Long id_matier;
		  private Long ID_mod;
		  private Long som;
		  private String INTITULE;
		  
	
		  
		 @Override
		  public boolean equals(Object o) {

		    if (this == o)
		      return true;
		    if (!(o instanceof MATIER))
		      return false;
		    MATIER matier = (MATIER) o;
		    return Objects.equals(this.ID_mod, matier.ID_mod) && Objects.equals(this.INTITULE, matier.INTITULE) ; 
		      
		  }

		  @Override
		  public int hashCode() {
		    return Objects.hash(this.id_matier, this.ID_mod, this.INTITULE,this.som);
		  }

		  @Override
		  public String toString() {
		    return "matier{" + "id=" + this.id_matier + ", name='" + this.INTITULE +" " +" ensieg: " +this.som +" a module "+this.ID_mod+ '\'' + '}';
		  }
}
