package Logico;

public class ReturnableGraphic {
    private String returnType;
    private int ocurrences;

    public ReturnableGraphic() {
	// TODO Auto-generated constructor stub
    }
    

    public ReturnableGraphic(String returnType, int ocurrences) {
	super();
	this.returnType = returnType;
	this.ocurrences = ocurrences;
    }


    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String programmingType) {
        this.returnType = programmingType;
    }

    public int getOcurrences() {
        return ocurrences;
    }

    public void setOcurrences(int ocurrences) {
        this.ocurrences = ocurrences;
    }
    
    

}