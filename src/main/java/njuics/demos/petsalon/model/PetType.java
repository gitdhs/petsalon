package njuics.demos.petsalon.model;

public enum PetType {
	Dog("Dog"),
	Cat("Cat");
	
	private String name;

 	private PetType(String name)
  	{
    	this.name = name;
  	}
  	public String getName() {
    	return name;
  	}
}
