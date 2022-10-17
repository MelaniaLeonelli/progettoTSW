package model;

public class Prodotto {
	
	private static String IMGPATH = "/WahWah_Shop/images/";
	private String codprodotto, nome, categoria, marca, immagine, genere;
	private int quantita;
	private double costo;
	  
	public String getCodprodotto() {
		return codprodotto;
	}
	public void setCodprodotto(String codprodotto) {
		this.codprodotto = codprodotto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	@Override
	public String toString() {
		return "Prodotto [codprodotto=" + codprodotto + ", nome=" + nome + ", categoria=" + categoria + ", marca="
				+ marca + ", immagine=<html><body><img src = " + '"' + immagine + '"' + " ></body></html>, genere=" + genere + ", quantita=" + quantita + ", costo="
				+ costo + "]";
	
	}
}
