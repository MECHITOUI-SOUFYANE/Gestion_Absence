package ma.projet.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class NIVEAU {
	private @Id @GeneratedValue Long id_niveau;
	private long id_filiere;
	
	//construct
	NIVEAU(){}
	NIVEAU(Long id_fil){this.id_filiere=id_fil;}
	
	
	 //getters and setters
	public long getId_filiere() {
		return id_filiere;
	}
	public void setId_filiere(long id_filiere) {
		this.id_filiere = id_filiere;
	}
	public Long getId_niveau() {
		return id_niveau;
	}
	
	 @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof MODULE))
	      return false;
	    NIVEAU niveau = (NIVEAU) o;
	    return Objects.equals(this.id_niveau, niveau.id_niveau) && Objects.equals(this.id_filiere, niveau.id_filiere); 
	      
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id_niveau, this.id_filiere);
	  }

	  @Override
	  public String toString() {
	    return "niveau{" + "id=" + this.id_niveau + " a filier "+this.id_filiere+ '\'' + '}';
	  }
	  
	
}
