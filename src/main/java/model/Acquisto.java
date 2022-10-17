package model;

public class Acquisto {

	String codProdotto;
	int codOrdine;
	double costo;
	
	public Acquisto() {
		
	}
	
	public Acquisto(String codProdotto, int CodOrdine) {
		this.codProdotto = codProdotto;
		this.codOrdine = codOrdine;
	}
	
	public Acquisto(String codProdotto, int CodOrdine, double costo) {
		this.codProdotto = codProdotto;
		this.codOrdine = codOrdine;
		this.costo = costo;
	}
	
	public String getCodProdotto() {
		return codProdotto;
	}
	public void setCodProdotto(String codProdotto) {
		this.codProdotto = codProdotto;
	}
	public int getCodOrdine() {
		return codOrdine;
	}
	public void setCodOrdine(int codOrdine) {
		this.codOrdine = codOrdine;
	}
	
	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String toString() {
		return "AcquistoDAO [codProdotto=" + codProdotto + ", codOrdine=" + codOrdine + "]";
	}
	
	
}
