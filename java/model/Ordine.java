package model;

public class Ordine {
	int codOrdine;
	String data;
	String ora;
	Double importoTotale;
	String CF;
	
	public int getCodOrdine() {
		return codOrdine;
	}
	public void setCodOrdine(int CodOrdine) {
		this.codOrdine = CodOrdine;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getOra() {
		return ora;
	}
	public void setOra(String ora) {
		this.ora = ora;
	}
	public Double getImportoTotale() {
		return importoTotale;
	}
	public void setImportoTotale(Double importoTotale) {
		this.importoTotale = importoTotale;
	}
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	@Override
	public String toString() {
		return "Ordine [codOrdine=" + codOrdine + ", data=" + data + ", ora=" + ora + ", importoTotale=" + importoTotale
				+ ", CF=" + CF + "]";
	}
	
	
}
