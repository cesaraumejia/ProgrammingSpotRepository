package Visual;

import java.util.Comparator;

import Logico.Worker;

public class DaysComparator implements Comparator<Worker>{

	public DaysComparator() {
		// TODO Auto-generated constructor stub
	}

	public int compare(Worker w1, Worker w2) {
		int aux = 0;
		if (w1.getDaysLeft()>w2.getDaysLeft())
			aux = 1;
		else if (w1.getDaysLeft()==w2.getDaysLeft())
		   aux = 0;
		else
			aux = -1;
		return aux;
	}

}
