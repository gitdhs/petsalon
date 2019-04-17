package njuics.demos.petsalon.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;

import njuics.demos.petsalon.model.Owner;
import njuics.demos.petsalon.repository.OwnerRepository;
import njuics.demos.petsalon.resource.OwnerResource;

@RestController
public class OwnerController {
	private OwnerRepository repository;
	
  	//OwnerController(OwnerRepository repository) {
    //	this.repository = repository;
  	//}
	
	@PostMapping("/owners")
	Owner addNewOwner (@RequestBody Owner newowner) {
		newowner=repository.save(newowner);
		return newowner;
	}
	
	@GetMapping(path="/owners")
	List<OwnerResource> getAllOwners() {
		Iterable<Owner> ownersIt = repository.findAll();
		List<Owner> ownersLs = new ArrayList<>();
		ownersIt.forEach(i -> { ownersLs.add(i); });
		
		List<OwnerResource> owners = ownersLs.stream().map(
				owner -> new OwnerResource(owner)
				).collect(Collectors.toList());
		
		return owners;
	}
	
	@GetMapping("/owners/{id}")
	Resource<Owner> getOneOwner(@PathVariable Integer id) {
		Owner owner = repository.findById(id)
				.orElseThrow(() -> new RuntimeException());

		return ownwer;
	}
	
	@PutMapping("/owners/{id}")
	Owner replaceOwner(@RequestBody Owner newOwner, @PathVariable Integer id) {
		
		return repository.findById(id)
			.map(owner -> {
				owner.setName(newOwner.getName());
				return repository.save(owner);
			})
			.orElseGet(() -> {
				newOwner.setId(id);
				return repository.save(newOwner);
			});
	}

	@DeleteMapping("/owners/{id}")
	void deleteOwner(@PathVariable int id) {
    	repository.deleteById(id);
  	}
}