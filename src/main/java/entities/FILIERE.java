package ma.projet.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class FILIERE {
	
	private @Id @GeneratedValue Long ID_filier;
	  private Long ID_CHEF_fil;
	  private String nom_fil;
	  
//constructure
	  
	  FILIERE(){}
	  FILIERE(String nom,Long id){
		  this.nom_fil=nom;this.ID_CHEF_fil=id;
	  }
	  
	  //getters and setters
	public Long getID_CHEF_fil() {
		return ID_CHEF_fil;
	}
	public void setID_CHEF_fil(Long iD_CHEF_fil) {
		ID_CHEF_fil = iD_CHEF_fil;
	}
	public String getNom_fil() {
		return nom_fil;
	}
	public void setNom_fil(String nom_fil) {
		this.nom_fil = nom_fil;
	}
	public Long getID_filier() {
		return ID_filier;
	}
	  
	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof FILIERE))
	      return false;
	    FILIERE filiere = (FILIERE) o;
	    return Objects.equals(this.nom_fil, filiere.nom_fil);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.ID_filier, this.nom_fil, this.ID_CHEF_fil);
	  }

	  @Override
	  public String toString() {
	    return "FILIERE{" + "id=" + this.ID_filier + ", name='" + this.nom_fil + '\'' + ", a chef de code som='" + this.ID_CHEF_fil + '\'' + '}';
	  }
	

}
