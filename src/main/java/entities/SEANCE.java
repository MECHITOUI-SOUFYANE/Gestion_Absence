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
			private @Id @GeneratedValue Long id_seance;
			  private Long ID_mat;
			  private Long ID_salle;
			  private String HEURE_DEBUT;
			  private String HEURE_FIN;
			  private String nature;
			  
			 
			@Override
			  public boolean equals(Object o) {

			    if (this == o)
			      return true;
			    if (!(o instanceof SEANCE))
			      return false;
			    SEANCE seance = (SEANCE) o;
			    return Objects.equals(this.ID_mat, seance.ID_mat) && Objects.equals(this.nature, seance.nature) &&Objects.equals(this.HEURE_DEBUT, seance.HEURE_DEBUT); 
			      
			  }

			  @Override
			  public int hashCode() {
			    return Objects.hash(this.id_seance, this.nature, this.ID_salle,this.ID_mat,this.HEURE_FIN,this.HEURE_DEBUT);
			  }
			  
			  @Override
			  public String toString() {
			    return "seance{" + "id=" + this.id_seance + ", nature='" + this.nature + '\'' + '}';
			  }
}
