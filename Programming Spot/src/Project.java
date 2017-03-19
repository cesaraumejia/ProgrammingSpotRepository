import java.util.ArrayList;

public class Project {
    
    private ArrayList<Worker> workers = new ArrayList<>();
    private String name;
    private float totalPrice;
    private String programmingType;
    

	public Project() {
	
	}


	public Project(ArrayList<Worker> workers, String name, float totalPrice, String programmingType) {
		super();
		this.workers = workers;
		this.name = name;
		this.totalPrice = totalPrice;
		this.programmingType = programmingType;
	}


	public ArrayList<Worker> getWorkers() {
		return workers;
	}


	public void setWorkers(ArrayList<Worker> workers) {
		this.workers = workers;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getProgrammingType() {
		return programmingType;
	}


	public void setProgrammingType(String programmingType) {
		this.programmingType = programmingType;
	}

}
