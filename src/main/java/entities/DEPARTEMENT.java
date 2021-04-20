package ma.projet.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class DEPARTEMENT {
	  private @Id @GeneratedValue Long ID_DEP;
	  private Long ID_CHEF_DEP;
	  private String nom_dep;
	  
	  //constructure
	  
	  DEPARTEMENT(){}
	  DEPARTEMENT(String nom,Long id){
		  this.nom_dep=nom;this.ID_CHEF_DEP=id;
	  }
	  
	  
	  //getters and setters
	public Long getID_CHEF_DEP() {
		return ID_CHEF_DEP;
	}
	public void setID_CHEF_DEP(Long iD_CHEF_DEP) {
		ID_CHEF_DEP = iD_CHEF_DEP;
	}
	public String getNom_dep() {
		return nom_dep;
	}
	public void setNom_dep(String nom_dep) {
		this.nom_dep = nom_dep;
	}
	public Long getID_DEP() {
		return ID_DEP;
	}
	  
	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof DEPARTEMENT))
	      return false;
	    DEPARTEMENT departement = (DEPARTEMENT) o;
	    return Objects.equals(this.nom_dep, departement.nom_dep);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.ID_DEP, this.nom_dep, this.ID_CHEF_DEP);
	  }

	  @Override
	  public String toString() {
	    return "departement{" + "id=" + this.ID_DEP + ", name='" + this.nom_dep + '\'' + ", a chef de code som='" + this.ID_CHEF_DEP + '\'' + '}';
	  }

}
