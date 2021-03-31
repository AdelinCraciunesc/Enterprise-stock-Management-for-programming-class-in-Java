package tema;

import java.io.Serializable;
import java.util.List;
/**
 * Clasa denota un produs al intreprinderii
 * @since 2.12.2020
 * @author adelin
 * @version 1.0
 * 
 */
public class Produs implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String nume;
	protected Furnizor furnizor;
	protected int cantitate;
	protected float pret;
	protected List<Client> clienti;
	
	public Produs() {
		super();
	}
	/**
	 * 
	 * @param nume numele produsului
	 * @param furnizor Furnizorul acestuia @see Furnizor
	 * @param cantitate cantitatea produsului
	 * @param pret pretul produsului
	 * @param clienti Clientul/Clientii produsului @see Client
	 */
	public Produs(String nume, Furnizor furnizor, int cantitate, float pret, List<Client> clienti) {
		super();
		this.nume = nume;
		this.furnizor = furnizor;
		this.cantitate = cantitate;
		this.pret = pret;
		this.clienti = clienti;
	}
	
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public Furnizor getFurnizor() {
		return furnizor;
	}
	public void setFurnizor(Furnizor furnizor) {
		this.furnizor = furnizor;
	}
	public int getCantitate() {
		return cantitate;
	}
	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}
	public float getPret() {
		return pret;
	}
	public void setPret(float pret) {
		this.pret = pret;
	}
	public List<Client> getClienti() {
		return clienti;
	}
	public void setClienti(List<Client> clienti) {
		this.clienti = clienti;
	}
	@Override
	public String toString() {
		return "Produs [nume=" + nume + ", furnizor=" + furnizor + ", cantitate=" + cantitate
				+ ", pret=" + pret + ", clienti=" + clienti + "]";
	}
}
