package Logico;
import java.util.ArrayList;


public class Admin {
	private ArrayList<Client> clients = new ArrayList<>();
	private ArrayList<Contract> contracts  = new ArrayList<>();
	private ArrayList<Worker> workers = new ArrayList<>();

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	public Admin(ArrayList<Client> clients, ArrayList<Contract> contracts, ArrayList<Worker> workers) {
		super();
		this.clients = clients;
		this.contracts = contracts;
		this.workers = workers;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public ArrayList<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(ArrayList<Contract> contracts) {
		this.contracts = contracts;
	}

	public ArrayList<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(ArrayList<Worker> workers) {
		this.workers = workers;
	}

}
