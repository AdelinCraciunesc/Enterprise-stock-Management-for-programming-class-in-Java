package tema;

import java.io.Serializable;
/**
 * Clasa client reprezinta un client al intreprinderii
 * @Date 2.12.2020
 * @author adelin
 * @version 1.2
 */
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * @param nume Numele clientului
	 * @param prodA Cate produse achizitioneaza pe luna
	 */
	private String nume;
	private int prodA;
	
	
	public Client(String nume, int prodA) {
		super();
		this.nume = nume;
		this.prodA = prodA;
	}

	@Override
	public String toString() {
		return "Client [nume=" + nume + ", prodA=" + prodA + "]";
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getProdA() {
		return prodA;
	}

	public void setProdA(int prodA) {
		this.prodA = prodA;
	}
	
	
}
