package njuics.demos.petsalon.model;

public enum ServiceCategory {
	// 清洗，剪毛，染色，装扮，购物
	Bathing("Bathing"),
	Cutting("Cutting"),
	curing("Curing");

	private String name;
  	private ServiceCategory(String name)
  	{
    	this.name = name;
  	}
  	public String getName() {
    	return name;
  	}
}
