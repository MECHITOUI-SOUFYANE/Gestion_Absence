package ma.projet.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor

public class ABSENCE {
	//i think l absence a un id
	private @Id @GeneratedValue Long id_abs;
	  private Long apogee;
	  private Long ID_seance;
	  private int semain;
	  private  boolean JUSTIFIE;
	  
	 
	
	  @Override
	  
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof ABSENCE))
	      return false;
	    ABSENCE absence = (ABSENCE) o;
	    return Objects.equals(this.ID_seance, absence.ID_seance) && Objects.equals(this.semain, absence.semain) && Objects.equals(this.apogee, absence.apogee);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id_abs, this.apogee, this.ID_seance,this.JUSTIFIE,this.semain);
	  }
	  
	@Override
	  public String toString() {
	    return "absence{" + "id=" + this.id_abs + ", de l etudianr='" + this.apogee +"a la sence "+this.ID_seance+'\'' + '}';
	  }
}
