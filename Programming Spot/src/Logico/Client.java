package Logico;
import java.io.Serializable;
import java.util.ArrayList;

public class Client implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6774095944917232907L;
	private String idNumber;
	private String name;
	private String lastName;
	private String phone;  
	private String email;
	private ArrayList<Contract> contracts;
	private String address;
	private int activeProjects;
	

	public Client() {
		this.contracts=new ArrayList<>();
	}



	public Client(String idNumber, String name,String address,String lastName,String email, String phone) {
		super();
		this.idNumber = idNumber;
		this.name = name;
		this.address = address;
		this.contracts=new ArrayList<>();
		this.lastName=lastName;
		this.email=email;
		this.phone = phone;
	
	}

	

	
	public void addContract(Contract contract){
	    if(contracts.contains(contract)){
		contracts.add(contract);
	    }
	}
	
	////////////////////////////Setters And Getters////////////////////////////


	public String getIdNumber() {
		return idNumber;
	}



	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	


	public String getPhone() {
	    return phone;
	}



	public void setPhone(String phone) {
	    this.phone = phone;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public ArrayList<Contract> getContracts() {
		return contracts;
	}


	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getActiveProjects() {
	    return activeProjects;
	}



	public void setActiveProjects(int activeProjects) {
	    this.activeProjects = activeProjects;
	}



	public String getLastName() {
	    return lastName;
	}



	public void setLastName(String lastName) {
	    this.lastName = lastName;
	}



	public String getEmail() {
	    return email;
	}



	public void setEmail(String email) {
	    this.email = email;
	}
	
	
	

	

}
