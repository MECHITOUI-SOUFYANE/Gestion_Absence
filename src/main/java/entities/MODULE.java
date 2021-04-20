package ma.projet.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MODULE {
//i think id de module est auto increment
	private @Id @GeneratedValue Long id_module;
	  private Long ID_dep;
	  private Long som;
	  private Long id_niveau;
	  private String nom_mod;
	  
	  //constructeur
	  MODULE(){}
	  MODULE(String nom,Long id_dep,Long som,Long niveau){
		  this.nom_mod=nom;this.ID_dep=id_dep;this.id_niveau=niveau;this.som=som;
	  }
	  
	  //getters and setters
	public Long getID_dep() {
		return ID_dep;
	}
	public void setID_dep(Long iD_dep) {
		ID_dep = iD_dep;
	}
	public Long getSom() {
		return som;
	}
	public void setSom(Long som) {
		this.som = som;
	}
	public Long getId_niveau() {
		return id_niveau;
	}
	public void setId_niveau(Long id_niveau) {
		this.id_niveau = id_niveau;
	}
	public String getNom_mod() {
		return nom_mod;
	}
	public void setNom_mod(String nom_mod) {
		this.nom_mod = nom_mod;
	}
	public Long getId_module() {
		return id_module;
	}
	  
	  
	
	 @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof MODULE))
	      return false;
	    MODULE module = (MODULE) o;
	    return Objects.equals(this.id_niveau, module.id_niveau) && Objects.equals(this.nom_mod, module.nom_mod); 
	      
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id_module, this.nom_mod, this.id_niveau,this.som,this.ID_dep);
	  }

	  @Override
	  public String toString() {
	    return "module{" + "id=" + this.id_module + ", name='" + this.nom_mod +" " +" a le chef: " +this.som +" a niveau "+this.id_niveau+ '\'' + '}';
	  }
	  
	  
	
}
