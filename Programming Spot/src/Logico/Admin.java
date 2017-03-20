package Logico;
import java.util.ArrayList;


public class Admin {
	private ArrayList<Client> clients = new ArrayList<>();
	private ArrayList<Contract> contracts  = new ArrayList<>();
	private ArrayList<Worker> workers = new ArrayList<>();
	public static int IDContractGenerator = 0;

	public Admin() {
	    this.clients=new ArrayList<>();
	    this.contracts=new ArrayList<>();
	    this.workers=new ArrayList<>();
	}
///////////////////////////Setters And Getters////////////////////////
	public ArrayList<Client> getClients() {
		return clients;
	}



	public ArrayList<Contract> getContracts() {
		return contracts;
	}


	public ArrayList<Worker> getWorkers() {
		return workers;
	}
	
///////////////////////////////////////////////////////////////////////////	

///////////////////////////////Support Methods/////////////////////////////
	
	/*private boolean availability() {
		boolean available = false;
		int counterProgrammer = 0;
		int counterBoss = 0;
		for (Worker wrk: workers) {
        		if (wrk instanceof ProjectBoss && wrk.isAvailable()){
        		    counterBoss++;
        		}else if (wrk instanceof Programmer && wrk.isAvailable()){
        		    counterProgrammer++;
        		}
		}
		if (counterBoss>=1 && counterProgrammer>=2){
		    available = true;
		}
		return available;
	}*/
	
	/*private int getAnyWorkerIndex(Worker pWorker){
	    int index=-1;
	    if(availability()){
		for(Worker wrk:workers){
		    if(wrk.getClass()==pWorker.getClass()){
			index=workers.indexOf(wrk);
		    }
		}
	    }
	    return index;  
	}*/
	
//////////////////////////////////////Metodos Referentes a los CLIENTES///////////////////////////////////////
	private Client searchClient(Client client) {
		Client foundClient = null;
		for (Client clt: clients) {
		    if (clt == client){
			foundClient = clt; 
		    }
		}
		return foundClient;
	}
	
	public void addClient(Client client){
	    if(searchClient(client)==null){
		clients.add(client);
	    }
	}

	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////////////Metodos Referentes a los TRABAJADORES///////////////////////////////////////
	private Worker searchWorker(Worker worker){
	    Worker foundWorker=null;
	    for(Worker wrk:workers){
		if(worker==wrk){
		    foundWorker=wrk;
		}   
	    }
	    return foundWorker;
	}
	
	public void addWorker(Worker worker){
	    if(searchWorker(worker)==null){
		workers.add(worker);
	    }
	}
	

	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////Metodos Referentes a los Proyectos y Contratos//////////////////////////////////////////////
	private Contract searchContract(Contract contract){
	    Contract foundContract=null;
	    for(Contract crt:contracts){
		if(contract==crt){
		    foundContract=crt;
		}   
	    }
	    return foundContract;
	}
	public void addContract(Contract contract){
	    if(searchContract(contract)==null){
		contracts.add(contract);
	    }
	}

	//TODO terminar este metodo.
	
	public boolean createContract(Client client,Project project,double finalPrice){
	    boolean contractCreated=false;
		
		
		
		
		contractCreated=false;
	    
	    
	    return contractCreated;
	    
	}
	
	public boolean workersAvailable(ProjectBoss boss,Programmer pr1,Programmer pr2){
	    boolean workersAvailable=false;
	    if(workers.get(workers.indexOf(boss)).isAvailable() && workers.get(workers.indexOf(pr1)).isAvailable() && workers.get(workers.indexOf(pr2)).isAvailable()){
		workersAvailable=true;
	    }
	    return workersAvailable;
	}
	
	//TODO comprobar este.
	
	public Project createProject(String name,String programmingType,String state,ProjectBoss boss, Planner planner, Designer designer,SoftwareTester tester, Programmer pr1,Programmer pr2){
	   Project createdProject=null;
	   ArrayList<Worker>projectWorkers=new ArrayList<>();
	   if(workersAvailable(boss, pr1, pr2)){
	       projectWorkers.add(boss);
	       projectWorkers.add(pr1);
	       projectWorkers.add(pr2);
	       if(planner!=null){
		       projectWorkers.add(planner);
		   }
		   if(designer!=null){
		       projectWorkers.add(designer);
		   }
		   if(tester!=null){
		       projectWorkers.add(tester);
		   }
		   
		   createdProject=new Project(workers, name, programmingType, state);
	    }
	
	    return createdProject;
	}
	
}

