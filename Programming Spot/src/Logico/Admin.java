package Logico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;



public class Admin implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3625912224765621615L;
	private ArrayList<Client> clients = new ArrayList<>();
	private ArrayList<Contract> contracts  = new ArrayList<>();
	private ArrayList<Worker> workers = new ArrayList<>();
	private ArrayList<Project> projects = new ArrayList<>();
	public static int IDContractGenerator = 0;
	private static Admin miAdmin;

	private Admin() {
	    this.clients=new ArrayList<>();
	    this.contracts=new ArrayList<>();
	    this.workers=new ArrayList<>();
	    this.projects = new ArrayList<>();
	}
///////////////////////////Setters And Getters////////////////////////
	public ArrayList<Client> getClients(){
		return clients;
	}

	public ArrayList<Contract> getContracts() {
		return contracts;
	}

	public ArrayList<Worker> getWorkers() {
		return workers;
	}
	public static Admin getInstance() {
		if (miAdmin==null)
			miAdmin = new Admin();
		return miAdmin;
	}
	

	public ArrayList<Project> getProjects() {
		return projects;
	}
	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
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

	public void addClient(Client client){
	    if(!clients.contains(client)){
		clients.add(client);
	    }
	}
	
	public Client searchClientByID(String id) {
	    Client foundClient = null;
	    for (Client ct : clients) {
		if(ct.getIdNumber().equalsIgnoreCase(id)){
		    foundClient=ct;
		    break;
		}
	    }
	    return foundClient;
	}
		
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////////////Metodos Referentes a los TRABAJADORES///////////////////////////////////////
	
	public void addWorker(Worker worker){
	    if(!workers.contains(worker)){
		workers.add(worker);
	    }
	}
	

	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////Metodos Referentes a los Proyectos y Contratos//////////////////////////////////////////////

	public void addContract(Contract contract){
	    if(!contracts.contains(contract)){
		contracts.add(contract);
	    }
	}
	
	public void addProject(Project project){
	    if(!projects.contains(project)){
		projects.add(project);
	    }
	}

	
	//TODO terminar este metodo.
	
	public boolean createContract(String initialDate, String finalDate,String contractID, Client client,Project project,double finalPrice){
	    boolean contractCreated=false;
	    Contract myNewContract=new Contract(initialDate, finalDate, contractID, client, project, finalPrice);
	    if(!client.getContracts().contains(myNewContract) && client.getActiveProjects()<5){
	    	contracts.add(myNewContract);	  
	    	this.clients.get(this.clients.indexOf(client)).getContracts().add(myNewContract);
	    	contractCreated=true;
	    }
	    if (contractCreated) {
			for (Worker i: project.getWorkers()) {
				int index = Admin.getInstance().getWorkers().indexOf(i);
				Admin.getInstance().getWorkers().get(index).getContract().add(myNewContract);
			}
	    }
	    return contractCreated;
	}
	
	private boolean workersAvailable(ProjectBoss boss,Programmer pr1,Programmer pr2){
	    boolean workersAvailable = false;
	    if((workers.get(workers.indexOf(boss)).getAvailable() < 2) && (workers.get(workers.indexOf(pr1)).getAvailable() < 1) && (workers.get(workers.indexOf(pr2)).getAvailable() < 1)){
	    	workersAvailable=true;
	    }
	    return workersAvailable;
	}
	
	
	public Project createProject(String name,String programmingType,String programmingLanguage,String state,ProjectBoss boss, Planner planner, Designer designer,SoftwareTester tester, Programmer pr1,Programmer pr2){
	   Project createdProject = null;
	   ArrayList<Worker>projectWorkers=new ArrayList<>();
	   if(workersAvailable(boss, pr1, pr2)){
	       projectWorkers.add(boss);
	       projectWorkers.add(pr1);
	       projectWorkers.add(pr2);
	       if(planner!=null){
	    	   if(planner.getAvailable() < 3)
	    		   projectWorkers.add(planner);
		       
		   }
		   if(designer!=null){
			   if(designer.getAvailable() < 2)
				   projectWorkers.add(designer);
		   }
		   if(tester!=null){
			   if(tester.getAvailable() < 3)
				   projectWorkers.add(tester);
		   }
		   createdProject = new Project(projectWorkers, name, programmingType,state, programmingLanguage);
		   
	    }
	
	    return createdProject;
	}
	
	///////////////////////////////////Dar el premio al mas destacado///////////////////////////////////////////////////////////////////
	private Worker findBestWorker() {
		setEficiency();
		Worker aux = workers.get(0);
		for (Worker i: workers) {
			if (i.getAnualEvaluation().equals("Destacado"))
				aux = i;
		}
		return aux;
	}
	public float givePrize() {
		float aux = 0f;
		for (Contract i: contracts) {
			for (Worker j: i.getProject().getWorkers()) {
				if (j==findBestWorker())
					aux += i.getProject().getTotalPrice()*0.1f;
			}
		}
		return aux;
	}
	////////////////////////////////////////Metodo para saber cuales projectos generaron perdidas////////////////////////////////////////
	/*public boolean findProject(Project project) {
		boolean aux = false;
		for (Contract i: contracts) {
			if (i.getProject()==project)
				aux = true;
		}
		return aux;
	}*/

	/////////////////////////////////////////Determinación del orden de Plataformas utilizadas (Mayor a menor)/////////////////
	
	/*
	 * ReturnableGraphic class is used to return the appropiate platform with name and times used
	 * */
	
	private ArrayList<String> getPlatforms(){
	    ArrayList<String> platformList = new ArrayList<>();
	    for (Contract ct : contracts) {
		String platform= ct.getProject().getProgrammingType();
		platformList.add(platform);
	    }
	    return platformList;
	}
	
	public ReturnableGraphic getMostUsedPlatform(ArrayList<String>existingPlatforms){
	    ArrayList<String>everyPlatform=getPlatforms();
	    int timesUsed=0;
	    int aux=0;
	    int mostUsedIndex=0;
	    for(int i=0; i<existingPlatforms.size();i++){
		    timesUsed=Collections.frequency(everyPlatform, existingPlatforms.get(i));
		    if(timesUsed>aux){
			aux=timesUsed;
			mostUsedIndex=i;
		    }
	    }
	    String name=existingPlatforms.get(mostUsedIndex);
	    int ocurrences=aux;
	    ReturnableGraphic mostUsedPlatform=new ReturnableGraphic(name, ocurrences);
	    return mostUsedPlatform;
	}
	
	public ReturnableGraphic getLessUsedPlatform(ArrayList<String>existingPlatforms){
	    ArrayList<String>everyPlatform=getPlatforms();
	    int timesUsed=0;
	    int aux=50;
	    int lessUsedIndex=0;
	    for(int i=0; i<existingPlatforms.size();i++){
		    timesUsed=Collections.frequency(everyPlatform, existingPlatforms.get(i));
		    if(timesUsed<aux){
			aux=timesUsed;
			lessUsedIndex=i;
		    }
	    }
	    String name=existingPlatforms.get(lessUsedIndex);
	    int ocurrences=aux;
	    ReturnableGraphic lessUsedPlatform=new ReturnableGraphic(name, ocurrences);
	    return lessUsedPlatform;
	    
	}
	
	///////////////////////////////////Determinacion de programadores cumplidores e incumplidores y el destacado////////////////////////////////
	public void setEficiency() {
		int index = -1;
		float best =0f;
		for (Worker i: Admin.getInstance().getWorkers()){
			float counter=0;
			for (Contract j: Admin.getInstance().getContracts()){
				if (j.getProject().getWorkers().contains(i)){
					if (j.getLostMoney()==0)
						counter++;
				}
			}
			float eficiency = (counter/(i.getContract().size()+1));
			i.setEficiency(eficiency);
			if (eficiency>70)
				i.setAnualEvaluation("Cumplidor");
			else
				i.setAnualEvaluation("Incumplidor");	
		}
		for (Worker i: Admin.getInstance().getWorkers()){
			if (i.getEficiency()>best){
				best = i.getEficiency();
				index = Admin.getInstance().getWorkers().indexOf(i);
			}
		}
		Admin.getInstance().getWorkers().get(index).setAnualEvaluation("Destacado");
	}
	
	public ProjectBoss bossByName(String name){
		ProjectBoss boss = null;
		int i = 0;
		while(i < workers.size()){
			if(workers.get(i) instanceof ProjectBoss){
				String completeName = workers.get(i).getFirstName() + " " +  workers.get(i).getLastName();
				if(completeName.equalsIgnoreCase(name)){
					boss = (ProjectBoss) workers.get(i);
				}
			}
			i++;
		}
		return boss;
	}
	
	public Programmer programmerByName(String name){
		Programmer programmer = null;
		int i = 0;
		while(i < workers.size()){
			if(workers.get(i) instanceof Programmer){
				String completeName = workers.get(i).getFirstName() + " " +  workers.get(i).getLastName();
				if(completeName.equalsIgnoreCase(name)){
					programmer = (Programmer) workers.get(i);
				}
			}
			i++;
		}
		return programmer;
	}
	
	public Planner plannerByName(String name){
		Planner planner = null;
		int i = 0;
		while(i < workers.size()){
			if(workers.get(i) instanceof Planner){
				String completeName = workers.get(i).getFirstName() + " " +  workers.get(i).getLastName();
				if(completeName.equals(name)){
					planner = (Planner) workers.get(i);
				}
			}
			i++;
		}
		return planner;
	}
	
	public Designer designerByName(String name){
		Designer designer = null;
		int i = 0;
		while(i < workers.size()){
			if(workers.get(i) instanceof Designer){
				String completeName = workers.get(i).getFirstName() + " " +  workers.get(i).getLastName();
				if(completeName.equalsIgnoreCase(name)){
					designer = (Designer) workers.get(i);
				}
			}
			i++;
		}
		return designer;
	}
	
	public SoftwareTester testerByName(String name){
		SoftwareTester tester = null;
		int i = 0;
		while(i < workers.size()){
			if(workers.get(i) instanceof SoftwareTester){
				String completeName = workers.get(i).getFirstName() + " " +  workers.get(i).getLastName();
				if(completeName.equalsIgnoreCase(name)){
					tester = (SoftwareTester) workers.get(i);
				}
			}
			i++;
		}
		return tester;
	}
	public static Admin getMiAdmin() {
		return miAdmin;
	}
	public static void setMiAdmin(Admin miAdmin) {
		Admin.miAdmin = miAdmin;
	}
	
	public float contractsEarning(){
		float earn = 0;
		
		return earn;
	}

	
}

