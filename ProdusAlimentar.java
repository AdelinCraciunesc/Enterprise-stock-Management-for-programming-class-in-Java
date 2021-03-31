package tema;

import java.io.Serializable;
import java.util.List;
/**
 * Clasa denota un Produs alimentar derivat din @see Produs
 * @author adelin
 * @version 1.0
 * @date 2.12.2020
 */
public class ProdusAlimentar extends Produs implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProdusAlimentar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdusAlimentar(String nume, Furnizor furnizor, int cantitate, float pret,List<Client> clienti) {
		super(nume, furnizor, cantitate, pret, clienti);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Metoda de printare
	 */
	public String toString() {
		return "ProdusAlimentar []" + nume +"furnizor" + furnizor + "cantitate" + cantitate + "pret" + pret + "clienti" + clienti;
	}
}
