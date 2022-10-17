package model;

public class Contiene {

	String CF;
	String codProdotto;
	int quantita;
	double importoTotale;
	
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	public String getCodProdotto() {
		return codProdotto;
	}
	public void setCodProdotto(String codProdotto) {
		this.codProdotto = codProdotto;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public double getimportoTotale() {
		return importoTotale;
	}
	public void setimportoTotale(double importoTotale) {
		this.importoTotale = importoTotale;
	}
	
	@Override
	public String toString() {
		return "Contiene [CF=" + CF + ", codProdotto=" + codProdotto + ", quantita=" + quantita + "totale= " + importoTotale + "]";
	}
	
	
	
}
