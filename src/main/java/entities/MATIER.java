package ma.projet.entities;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class MATIER {
	//i think id de matier est auto increment
		private @Id @GeneratedValue Long id_matier;
		  private Long ID_mod;
		  private Long som;
		  private String INTITULE;
		  
		  //constructeur
		  MATIER(){}
		  MATIER(String nom,Long id_mod,Long som){
			  this.INTITULE=nom;this.ID_mod=id_mod;this.som=som;
		  }
		  
		  //getters and setters
		public Long getID_mod() {
			return ID_mod;
		}
		public void setID_mod(Long iD_mod) {
			ID_mod = iD_mod;
		}
		public Long getSom() {
			return som;
		}
		public void setSom(Long som) {
			this.som = som;
		}
		public String getINTITULE() {
			return INTITULE;
		}
		public void setINTITULE(String iNTITULE) {
			INTITULE = iNTITULE;
		}
		public Long getId_matier() {
			return id_matier;
		}
		  
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
