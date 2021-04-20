package ma.projet.entities;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class SEANCE {
	//i think id de matier est auto increment
			private @Id @GeneratedValue Long id_seance;
			  private Long ID_mat;
			  private Long ID_salle;
			  private String HEURE_DEBUT;
			  private String HEURE_FIN;
			  private String nature;
			  
			  //constructeur
			  SEANCE(){}
			  SEANCE(Long id_mat,Long id_salle,String h_debut,String h_fin,String nature){
				  this.ID_mat=id_mat;this.ID_salle=id_salle;this.HEURE_DEBUT= h_debut;this.HEURE_FIN=h_fin;this.nature=nature;
			  }
			  
			  
			//getters and setters
			public Long getID_mat() {
				return ID_mat;
			}
			public void setID_mat(Long iD_mat) {
				ID_mat = iD_mat;
			}
			public Long getID_salle() {
				return ID_salle;
			}
			public void setID_salle(Long iD_salle) {
				ID_salle = iD_salle;
			}
			public String getHEURE_DEBUT() {
				return HEURE_DEBUT;
			}
			public void setHEURE_DEBUT(String hEURE_DEBUT) {
				HEURE_DEBUT = hEURE_DEBUT;
			}
			public String getHEURE_FIN() {
				return HEURE_FIN;
			}
			public void setHEURE_FIN(String hEURE_FIN) {
				HEURE_FIN = hEURE_FIN;
			}
			public String getNature() {
				return nature;
			}
			public void setNature(String nature) {
				this.nature = nature;
			}
			public Long getId_seance() {
				return id_seance;
			}
			
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
