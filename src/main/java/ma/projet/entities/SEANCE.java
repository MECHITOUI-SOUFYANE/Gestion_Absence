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

public class SEANCE {
	//i think id de matier est auto increment
			private @Id @GeneratedValue Long idSeance;
			  private Long idMatier;
			  private Long idSalle;
			  private String heureDebut;
			  private String heureFin;
			  private String nature;
			  
			 
			@Override
			  public boolean equals(Object o) {

			    if (this == o)
			      return true;
			    if (!(o instanceof SEANCE))
			      return false;
			    SEANCE seance = (SEANCE) o;
			    return Objects.equals(this.idMatier, seance.idMatier) && Objects.equals(this.nature, seance.nature) &&Objects.equals(this.heureDebut, seance.heureDebut); 
			      
			  }

			  @Override
			  public int hashCode() {
			    return Objects.hash(this.idSeance, this.nature, this.idSalle,this.idMatier,this.heureFin,this.heureDebut);
			  }
			  
			  @Override
			  public String toString() {
			    return "seance{" + "id=" + this.idSeance + ", nature='" + this.nature + '\'' + '}';
			  }
}
