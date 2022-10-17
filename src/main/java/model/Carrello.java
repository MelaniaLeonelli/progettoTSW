package model;

public class Carrello {

	String CF;
	
	public Carrello(String CF) {
		this.CF = CF;
	}

	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		this.CF = cF;
	}
	@Override
	public String toString() {
		return "Carrello [CF=" + CF + "]";
	}
	
}
