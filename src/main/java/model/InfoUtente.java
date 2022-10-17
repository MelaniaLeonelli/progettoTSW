package model;

public class InfoUtente {
	String CF;
	String indirizzo;
	String citta;
	String CAP;
	String phone;
	int punti;
	
	public InfoUtente() {
		
	}
	
	public InfoUtente(String CF) {
		this.CF = CF;
	}
	
	
	public InfoUtente(String CF, String indirizzo, String citta, String CAP, String phone, int punti) {
		this.CF = CF;
		this.indirizzo = indirizzo;
		this.citta = citta;
		this.CAP = CAP;
		this.phone = phone;
		this.punti = punti;
	}
	
	public String getCF() {
		return CF;
	}
	public void setCF(String cF) {
		CF = cF;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getCAP() {
		return CAP;
	}
	public void setCAP(String cAP) {
		CAP = cAP;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	@Override
	public String toString() {
		return "InfoUtente [CF=" + CF + ", indirizzo=" + indirizzo + ", citta=" + citta + ", CAP=" + CAP + ", phone="
				+ phone + ", punti=" + punti + "]";
	}
	
}
