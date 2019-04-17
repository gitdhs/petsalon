package njuics.demos.petsalon.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;

import njuics.demos.petsalon.model.Pet;
import njuics.demos.petsalon.repository.PetRepository;
import njuics.demos.petsalon.resource.Pet;

@RestController
public class PetController {
	private PetRepository repository;

	//PetController(PetRepository repository, OwnerRepository ownerRepository) {
    //	this.repository = repository;
    //	this.ownerRepository = ownerRepository;
  	//}
  	
	@GetMapping("/pets")
  	List<Pet> all() {
    	return repository.findAll();
  	}
  	
	@PostMapping("/pets")
  	Pet newPet(@RequestBody Pet newPet) {
    	newPet=repository.save(newPet);
		return newPet;
  	}


	@GetMapping("/pets/{id}")
	Pet getOnePet(@PathVariable Integer id) {
		return  repository.findById(id)
			.orElseThrow(() -> new RuntimeException());
	}
	
	@PutMapping("/pets/{id}")
	public Pet replacePet(@RequestBody Pet newPet, @PathVariable Integer id) {
		
		return repository.findById(id)
			.map(pet -> {
				pet.setName(newPet.getName());
				pet.setType(newPet.getType());
				return repository.save(pet);
			})
			.orElseGet(() -> {
				newPet.setId(id);
				return repository.save(newPet);
			});
	}

	@DeleteMapping("/{id}")
	void deletePet(@PathVariable int id) {
    	repository.deleteById(id);
  	}
	/*  
	@ModelAttribute("owner")
  	@RequestMapping("/owners/{ownerId}")
  	@Transactional(readOnly = true)
  	public Owner findOwner(@PathVariable("ownerId") int ownerId) {
    	System.out.println(ownerId);
    	return ownerRepository.findById(ownerId).get();
  	} */
}
