package ma.projet.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ETUDIANT {
	private @Id  Long NUM_APOGEE;
	//pourquoi on besoin d un id module si lid de niveau
	  private Long ID_niveau;
	  private String cne;
	  private String nom;
	  private String prenom;
	  
	  //constructeur
	  ETUDIANT(){}
	  ETUDIANT(Long apogee,String cne,String nom,String prenom,Long niveau){
		  this.nom=nom;this.prenom=prenom;this.cne=cne;this.NUM_APOGEE=apogee;this.ID_niveau=niveau;
	  }
	  
	  //getters and setters
	public Long getNUM_APOGEE() {
		return NUM_APOGEE;
	}
	public void setNUM_APOGEE(Long nUM_APOGEE) {
		NUM_APOGEE = nUM_APOGEE;
	}
	public Long getID_niveau() {
		return ID_niveau;
	}
	public void setID_niveau(Long iD_niveau) {
		ID_niveau = iD_niveau;
	}
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
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
	  
	  
	
	 @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof ETUDIANT))
	      return false;
	    ETUDIANT etudiant = (ETUDIANT) o;
	    return Objects.equals(this.NUM_APOGEE, etudiant.NUM_APOGEE); 
	      
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.NUM_APOGEE, this.nom, this.prenom,this.cne,this.ID_niveau);
	  }

	  @Override
	  public String toString() {
	    return "ETUDIANT{" + "apogee=" + this.NUM_APOGEE + ", name='" + this.nom +" " +this.prenom +" cne: " +this.cne +" a niveau "+this.ID_niveau+ '\'' + '}';
	  }
}
