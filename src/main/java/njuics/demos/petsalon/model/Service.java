package njuics.demos.petsalon.model;

import java.util.Date;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.*;

@Entity 
public class Service {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    
  	@Column(name = "service_fee")
  	private Double fee;

  	@Column(name = "service_category")
  	private ServiceCategory category;

  	@ManyToOne
  	@JoinColumn(name = "pet")
  	private Pet pet;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public ServiceCategory getCategory() {
		return category;
	}
	public void setCategory(ServiceCategory category) {
		this.category = category;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
}
