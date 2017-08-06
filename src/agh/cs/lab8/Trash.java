package agh.cs.lab8;

public class Trash {
	private boolean test;
	private String line;

	public Trash(String linia) {

		trashing(linia);
	}

	public boolean trashing(String linia) {
		if (linia.equals(new String("©Kancelaria Sejmu"))
				|| linia.equals(new String("2009-11-16"))) {
			test = true;
		} else
			test = false;
		return test;
	}

	public boolean getTest(){
		return test;
	}
	
	public String getLinia(){
		return line;
	}
}
