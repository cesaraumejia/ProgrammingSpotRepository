package Logico;
import java.util.ArrayList;


public class Admin {
	private ArrayList<Client> clients = new ArrayList<>();
	private ArrayList<Contract> contracts  = new ArrayList<>();
	private ArrayList<Worker> workers = new ArrayList<>();
	public static int IDContractGenerator = 0;

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
	private boolean availability() {
		boolean aux = false;
		int counter1 = 0;
    	int counter = 0;
		for (Worker i: workers) {
    		if (i instanceof ProjectBoss)
    			counter++;
    		else if (i instanceof Programmer)
    			counter1++;
    	}
		if (counter>=1 && counter1>=2)
			aux = true;
		return aux;
	}
	private int getBossIndex() {
		int aux = -1;
		if (availability()) {
		for (Worker i: workers) {
			if (i instanceof ProjectBoss)
				aux = workers.indexOf(i);
		}
		}
		return aux;
	}
	private int getProgrammerIndex1() {
		int aux = -1;
		if (availability()) {
		for (Worker i: workers) {
			if (i instanceof Programmer)
				aux = workers.indexOf(i);
		}
		}
		return aux;
	}
	private int getProgrammerIndex2() {
		int aux = -1;
		if (availability()) {
		for (Worker i: workers) {
			if (i instanceof Programmer)
				aux = workers.indexOf(i);
		}
		}
		return aux;
	}
	private int getTesterIndex() {
		int aux = -1;
		if (availability()) {
		for (Worker i: workers) {
			if (i instanceof SoftwareTester)
				aux = workers.indexOf(i);
		}
		}
		return aux;
	}
	private int getPlannerIndex() {
		int aux = -1;
		if (availability()) {
		for (Worker i: workers) {
			if (i instanceof Planner)
				aux = workers.indexOf(i);
		}
		}
		return aux;
	}
	private int getDesignerIndex() {
		int aux = -1;
		if (availability()) {
		for (Worker i: workers) {
			if (i instanceof Designer)
				aux = workers.indexOf(i);
		}
		}
		return aux;
	}
	private boolean clientRegistered(Client client) {
		boolean aux = false;
		for (Client i: clients) {
			if (i == client)
				aux = true;
		}
		return aux;
	}
    public boolean createProject(String name, String programmingType, Client client, int initialDate, int finalDate, boolean planner, boolean designer, boolean tester) {
    	boolean aux = false;
    	Project project = new Project(null, name, programmingType, null);
    	Contract contract = new Contract(initialDate, finalDate, IDContractGenerator++, client, null);
    	ArrayList<Worker> pWorker = new ArrayList<>();
    	if (availability() && clientRegistered(client)) {
    		pWorker.add(workers.get(getBossIndex()));
    		workers.remove(getBossIndex());
    		pWorker.add(workers.get(getProgrammerIndex1()));
    		workers.remove(getProgrammerIndex1());
    		pWorker.add(workers.get(getProgrammerIndex2()));
    		workers.remove(getProgrammerIndex2());
    		if (planner && getPlannerIndex()!=-1) {
    			pWorker.add(workers.get(getPlannerIndex()));
    			workers.remove(getPlannerIndex());
    		}
    		if (designer && getDesignerIndex()!=-1) {
    			pWorker.add(workers.get(getDesignerIndex()));
    			workers.remove(getDesignerIndex());
    		}
    		if (tester && getTesterIndex()!=-1) {
    			pWorker.add(workers.get(getTesterIndex()));
    			workers.remove(getTesterIndex());
    		}
    		project.setWorkers(pWorker);
    		project.setState("En proceso");
    		aux = true;
    		contract.setProject(project);
    		contracts.add(contract);
    	}
    	return aux;
    }

}
