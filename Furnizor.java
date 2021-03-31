package tema;

import java.io.Serializable;
/**
 * @since 2.10.2020
 * @author adelin
 * @version 1.0 
 */
public class Furnizor implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nume;
	private int prodL;
	
	/**
	 * Constructor explicit
	 * @param nume numele furnizorului
	 * @param prodL cate produse livreaza pe luna
	 */
	public Furnizor(String nume, int prodL) {
		super();
		this.nume = nume;
		this.prodL = prodL;
	}

	@Override
	public String toString() {
		return "Furnizor [nume=" + nume + ", prodL=" + prodL + "]";
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getProdL() {
		return prodL;
	}

	public void setProdL(int prodL) {
		this.prodL = prodL;
	}
	
	
	
}
