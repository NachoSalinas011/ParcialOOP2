package datos;

public class Aula {
	protected int idAula;
	protected int numero;
	protected Edificio edificio;
	
	public Aula() {}
	
	
	
	public Aula(int numero, Edificio edificio) {
		super();
		this.numero = numero;
		this.edificio = edificio;
	}

	public int getIdAula() {
		return idAula;
	}
	protected void setIdAula(int idAula) {
		this.idAula = idAula;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Edificio getEdificio() {
		return edificio;
	}
	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	@Override
	public String toString() {
		return "Aula [idAula=" + idAula + ", numero=" + numero + "]";
	}
}
