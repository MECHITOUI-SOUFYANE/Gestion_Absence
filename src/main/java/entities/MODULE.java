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
	private @Id @GeneratedValue Long id_module;
	  private Long ID_dep;
	  private Long som;
	  private Long id_niveau;
	  private String nom_mod;
	  
	  
	
	 @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof MODULE))
	      return false;
	    MODULE module = (MODULE) o;
	    return Objects.equals(this.id_niveau, module.id_niveau) && Objects.equals(this.nom_mod, module.nom_mod); 
	      
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id_module, this.nom_mod, this.id_niveau,this.som,this.ID_dep);
	  }

	  @Override
	  public String toString() {
	    return "module{" + "id=" + this.id_module + ", name='" + this.nom_mod +" " +" a le chef: " +this.som +" a niveau "+this.id_niveau+ '\'' + '}';
	  }
	  
	  
	
}
