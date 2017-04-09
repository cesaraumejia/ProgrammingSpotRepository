package Logico;
import java.util.ArrayList;

public class Project {
    
    private ArrayList<Worker> workers = new ArrayList<>();
    private String name;
    private float totalPrice;			//Este campo deberia solo en contratos
    private String programmingType;		
    private String state;
    private String programmingLanguage;    

	public Project() {
	
	}


	public Project(ArrayList<Worker> workers, String name, String programmingType, String state,String programmingLanguage) {
		super();
		this.workers = workers;
		this.name = name;
		this.programmingType = programmingType;
		this.programmingLanguage=programmingLanguage;
		this.state = state;
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
	


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	
	
	
	
	public String getProgrammingLanguage() {
	    return programmingLanguage;
	}


	public void setProgrammingLanguage(String programmingLanguage) {
	    this.programmingLanguage = programmingLanguage;
	}


	public float calculateBasePrice() {
		float aux = 0f;
		for (Worker i: workers)
			aux += i.getSalary();
		return aux*1.15f;
	}
	
	
	
	

}
