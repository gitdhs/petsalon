package njuics.demos.petsalon.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.*;

import njuics.demos.petsalon.model.Service;
import njuics.demos.petsalon.repository.ServiceRepository;
import njuics.demos.petsalon.resource.ServiceResource;

@RestController
public class ServiceController {
	private ServiceRepository repository;
  	
	//ServiceController(ServiceRepository repository) {
   // 	this.repository = repository;
  //	}
	@PostMapping("/services")
	Service newService(@RequestBody Service newService) {
    	newService=repository.save(newService);
		return newService;
  	}
	@GetMapping("/services")
  	List<Service> all() {
    	return repository.findAll();
  	}
	
	@GetMapping("/service/{id}")
	ServiceResource getOneService(@PathVariable Integer id) {
		Service service = repository.findById(id)
				.orElseThrow(() -> new RuntimeException());

		return new ServiceResource(service);
	}
	
	@PutMapping("/service/{id}")
	public Service replaceService(@RequestBody Service newService, @PathVariable Integer id) {
		
		return repository.findById(id)
			.map(service -> {
				service.setDate(newService.getDate());
				service.setFee(newService.getFee());
				service.setCategory(newService.getCategory());
				return repository.save(service);
			})
			.orElseGet(() -> {
				newService.setId(id);
				return repository.save(newService);
			});
	}

	@DeleteMapping("/services/{id}")
  	void deleteService(@PathVariable int id) {
    	repository.deleteById(id);
  	}
}