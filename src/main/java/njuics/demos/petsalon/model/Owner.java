package njuics.demos.petsalon.model;

import java.util.Set;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Owner {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String name;

    @OneToMany(targetEntity=Pet.class, cascade=CascadeType.ALL)
	@JoinColumn(name="owner", referencedColumnName = "id")
    private Set<Pet> petSet; 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Pet> getPetSet() {
		return petSet;
	}
	public void setPetSet(Set<Pet> petSet) {
		this.petSet = petSet;
	}
}
