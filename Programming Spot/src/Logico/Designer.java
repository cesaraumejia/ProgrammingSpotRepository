package Logico;

import java.util.ArrayList;

public class Designer extends Worker {
	private String designerField;
	private String designingSoftware;

	public Designer() {  
		// TODO Auto-generated constructor stub
	}

	public Designer(String idNumber, String firstName, String lastName, String address, String sex, String birthday,
			String projetName, String anualEvaluation, int hourlyPayment, int workedHours, int projectsQuant, String telefono, ArrayList<Contract> contract, String designerField, String designingSoftware) {
		super(idNumber, firstName, lastName, address, sex, birthday, projetName, anualEvaluation, hourlyPayment, workedHours, projectsQuant, telefono, contract);
		this.designingSoftware = designingSoftware;
		this.designerField = designerField;
	}
	
	public float computeSalary(){
		return super.computeSalary();
	}

	public String getDesignerField() {
		return designerField;
	}

	public void setDesignerField(String designerField) {
		this.designerField = designerField;
	}

	public String getDesigningSoftware() {
		return designingSoftware;
	}

	public void setDesigningSoftware(String designingSoftware) {
		this.designingSoftware = designingSoftware;
	}

}
