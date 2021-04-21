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

public class MATIER {
	//i think id de matier est auto increment
		private @Id @GeneratedValue Long idMatier;
		  private Long idMatier;
		  private Long som;
		  private String intitule;
		  
	
		  
		 @Override
		  public boolean equals(Object o) {

		    if (this == o)
		      return true;
		    if (!(o instanceof MATIER))
		      return false;
		    MATIER matier = (MATIER) o;
		    return Objects.equals(this.idMatier, matier.idMatier) && Objects.equals(this.intitule, matier.intitule) ; 
		      
		  }

		  @Override
		  public int hashCode() {
		    return Objects.hash(this.idMatier, this.idMatier, this.intitule,this.som);
		  }

		  @Override
		  public String toString() {
		    return "matier{" + "id=" + this.idMatier + ", name='" + this.intitule +" " +" ensieg: " +this.som +" a module "+this.idMatier+ '\'' + '}';
		  }
}
