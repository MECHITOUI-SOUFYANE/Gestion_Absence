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
public class MODULE {
//i think id de module est auto increment
	private @Id @GeneratedValue Long idModule;
	  private Long idDepartement;
	  private Long som;
	  private Long idNiveau;
	  private String nomModule;
	  
	  
	
	 @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof MODULE))
	      return false;
	    MODULE module = (MODULE) o;
	    return Objects.equals(this.idNiveau, module.idNiveau) && Objects.equals(this.nomModule, module.nomModule); 
	      
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.idModule, this.nomModule, this.idNiveau,this.som,this.idDepartement);
	  }

	  @Override
	  public String toString() {
	    return "module{" + "id=" + this.idModule + ", name='" + this.nomModule +" " +" a le chef: " +this.som +" a niveau "+this.idNiveau+ '\'' + '}';
	  }
	  
	  
	
}
