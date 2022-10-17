package model;

public class Utente {
	String CF;
	String email;
	String password;
	String nome;
	String cognome;
	int isAdmin;
	
	public Utente() {
		
	}

	public Utente(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
    public Utente(String CF, String email, String password, String nome, String cognome, int isAdmin) {
        this.CF = CF;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.cognome = cognome;
        this.isAdmin = isAdmin;
    }
    
    public Utente(String CF, String nome, String cognome) {
        this.CF = CF;
        this.nome = nome;
        this.cognome = cognome;
    }

	public String getCF() {
		return CF;
	}

	public void setCF(String cF) {
		CF = cF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	public int getisAdmin() {
		return isAdmin;
	}

	public void setisAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Utente [CF=" + CF + ", email=" + email + ", password=" + password + ", nome=" + nome + ", cognome="
				+ cognome + ", isAdmin=" + isAdmin + "]";
	}
	
}
