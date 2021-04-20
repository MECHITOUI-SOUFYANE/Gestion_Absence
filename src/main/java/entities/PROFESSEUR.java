package ma.projet.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity


public class PROFESSEUR {
	//SOM n est pas auto increment;
	  private @Id @GeneratedValue Long SOM;
	  private Long ID_DEP;
	  private String nom;
	  private String prenom;
	  private String password;
	  //constructeur
	  PROFESSEUR(){}
	  PROFESSEUR(String nom,String prenom,Long id_dep,String password){
		  this.nom=nom;this.prenom=prenom;this.ID_DEP=id_dep;this.password=password;
	  }
	  
	  //getters and setters
	public Long getID_DEP() {
		return ID_DEP;
	}
	public void setID_DEP(Long iD_DEP) {
		ID_DEP = iD_DEP;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getSOM() {
		return SOM;
	}
	 public void setSOM(Long sOM) {
		SOM = sOM;
	}
	 
	@Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof PROFESSEUR))
	      return false;
	    PROFESSEUR professeur = (PROFESSEUR) o;
	    return Objects.equals(this.SOM, professeur.SOM); 
	      
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.SOM, this.nom, this.prenom,this.password);
	  }

	  @Override
	  public String toString() {
	    return "Professeur{" + "SOM=" + this.SOM + ", name='" + this.nom +" " +this.prenom + '\'' + '}';
	  }
	  
}
