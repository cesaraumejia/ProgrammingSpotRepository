package Logico;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	       int index = Admin.getInstance().getWorkers().indexOf(boss);
	       Admin.getInstance().getWorkers().get(index).setAvailable(Admin.getInstance().getWorkers().get(index).getAvailable()+1);
	       projectWorkers.add(pr1);
	       index = Admin.getInstance().getWorkers().indexOf(pr1);
	       Admin.getInstance().getWorkers().get(index).setAvailable(Admin.getInstance().getWorkers().get(index).getAvailable()+1);
	       projectWorkers.add(pr2);
	       index = Admin.getInstance().getWorkers().indexOf(pr2);
	       Admin.getInstance().getWorkers().get(index).setAvailable(Admin.getInstance().getWorkers().get(index).getAvailable()+1);
	       if(planner!=null){
	    	   if(planner.getAvailable() < 3) {
	    		   projectWorkers.add(planner);
	    	       index = Admin.getInstance().getWorkers().indexOf(planner);
	    	       Admin.getInstance().getWorkers().get(index).setAvailable(Admin.getInstance().getWorkers().get(index).getAvailable()+1);  
	    	   }
		   }
		   if(designer!=null){
			   if(designer.getAvailable() < 2) {
				   projectWorkers.add(designer);
			       index = Admin.getInstance().getWorkers().indexOf(designer);
			       Admin.getInstance().getWorkers().get(index).setAvailable(Admin.getInstance().getWorkers().get(index).getAvailable()+1);
			   }
		   }
		   if(tester!=null){
			   if(tester.getAvailable() < 3) {
				   projectWorkers.add(tester);
			       index = Admin.getInstance().getWorkers().indexOf(tester);
			       Admin.getInstance().getWorkers().get(index).setAvailable(Admin.getInstance().getWorkers().get(index).getAvailable()+1);
			   }
		   }
		   createdProject = new Project(projectWorkers, name, programmingType,state, programmingLanguage);
		   
	    }
	
	    return createdProject;
	}
	
	public void removeProject(Project project){
	    if(projects.contains(project)){
		this.projects.remove(project);
	    }
	    for (Worker worker : project.getWorkers()) {
		
		this.workers.get(this.workers.indexOf(worker)).beAvailable();;
		
	    }
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
	
	private ArrayList<String> getLanguages(){
	    ArrayList<String> languageList = new ArrayList<>();
	    for (Contract ct : contracts) {
		String platform= ct.getProject().getProgrammingType();
		languageList.add(platform);
	    }
	    return languageList;
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
	public ReturnableGraphic getMostUsedLanguage(ArrayList<String>existingLanguages){
	    ArrayList<String>everyLanguage=getLanguages();
	    int timesUsed=0;
	    int aux=0;
	    int mostUsedIndex=0;
	    for(int i=0; i<existingLanguages.size();i++){
		    timesUsed=Collections.frequency(everyLanguage, existingLanguages.get(i));
		    if(timesUsed>aux){
			aux=timesUsed;
			mostUsedIndex=i;
		    }
	    }
	    String name=existingLanguages.get(mostUsedIndex);
	    int ocurrences=aux;
	    ReturnableGraphic mostUsedLanguage=new ReturnableGraphic(name, ocurrences);
	    return mostUsedLanguage;
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
	
	public ReturnableGraphic getLessUsedLanguage(ArrayList<String>existingLanguages){
	    ArrayList<String>everyLanguage=getLanguages();
	    int timesUsed=0;
	    int aux=0;
	    int lessUsedIndex=0;
	    for(int i=0; i<existingLanguages.size();i++){
		    timesUsed=Collections.frequency(everyLanguage, existingLanguages.get(i));
		    if(timesUsed<aux){
			aux=timesUsed;
			lessUsedIndex=i;
		    }
	    }
	    String name=existingLanguages.get(lessUsedIndex);
	    int ocurrences=aux;
	    ReturnableGraphic mostUsedLanguage=new ReturnableGraphic(name, ocurrences);
	    return mostUsedLanguage;
	}
	

	
	///////////////////////////////////Determinacion de programadores cumplidores e incumplidores y el destacado////////////////////////////////
	public void setEficiency() {
		int index = -1;
		float best =0f;
		for (Worker i: Admin.getInstance().getWorkers()){
			float counter=0;
			for (Contract j: Admin.getInstance().getContracts()){
				if (j.getProject().getWorkers().contains(i) && j.getProject().getState().equals("Finalizado")){
					if (j.getLostMoney()==0)
						counter++;
				}
			}
			float eficiency = 0f;
			if (i.getContract().size()>0)
				eficiency = (counter/(i.getContract().size()))*100;
			
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
		if (index != -1)
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
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////Métodos de Ficheros/////////////////////////////////////////
	
	public void saveContracts(){
	    try {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/contracts.dat"));
		oos.writeObject(this.contracts);
		oos.close();
	    } catch (IOException e) {
		
	    }
	}
	
	@SuppressWarnings("unchecked")
	public void loadContracts(){
	    try {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/contracts.dat"));
		this.contracts=(ArrayList<Contract>) ois.readObject();
		ois.close();
	    } catch (IOException e) {
		saveContracts();
	    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	
	public void saveWorkers(){
	    try {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/workers.dat"));
		oos.writeObject(this.workers);
		oos.close();
	    } catch (IOException e) {
		
	    }
	}
	
	@SuppressWarnings("unchecked")
	public void loadWorkers(){
	    try {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/workers.dat"));
		this.workers=(ArrayList<Worker>) ois.readObject();
		ois.close();
	    } catch (IOException e) {
		saveWorkers();
	    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	
	public void saveClients(){
	    try {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/clients.dat"));
		oos.writeObject(this.clients);
		oos.close();
	    } catch (IOException e) {
		
	    }
	}
	
	@SuppressWarnings("unchecked")
	public void loadClients(){
	    try {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/clients.dat"));
		this.clients=(ArrayList<Client>) ois.readObject();
		ois.close();
	    } catch (IOException e) {
		saveClients();
	    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	
	public void saveProjects(){
	    try {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/projects.dat"));
		oos.writeObject(this.projects);
		oos.close();
	    } catch (IOException e) {
		
		
	    }
	}
	
	@SuppressWarnings("unchecked")
	public void loadProjects(){
	    try {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/projects.dat"));
		this.projects=(ArrayList<Project>) ois.readObject();
		ois.close();
	    } catch (IOException e) {
		saveProjects();
	    } catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	
	public void saveContractID (){
	    try {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("files/contractID.dat"));
	 	oos.writeInt(Contract.IDnumber);
	 	oos.close();
	 	} catch (IOException e) {
	    }
	}
	
	public void loadContractID(){
	    try {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("files/contractID.dat"));
		Contract.IDnumber=(int) ois.readInt();
		ois.close();
	    } catch (IOException e) {
		saveContractID();
	    }
	}
	
	
	
	
	public void saveEverything(){
	    saveProjects();
	    saveClients();
	    saveContracts();
	    saveWorkers();
	    saveContractID();
	}
	
	public void loadEverything(){
	    loadProjects();
	    loadClients();
	    loadContracts();
	    loadWorkers();
	    loadContractID();
	    
	}
	
	
	
	
	
	
		
	

	
}

