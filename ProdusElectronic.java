package tema;

import java.io.Serializable;
import java.util.List;
/**
 * Clasa reprezinta un produs de tipul electronic derivat din @see Produs
 * @author adelin
 * @since 2.10.2020
 * @version 1.0
 */
public class ProdusElectronic extends Produs implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProdusElectronic() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 */
	public ProdusElectronic(String nume, Furnizor furnizor, int cantitate, float pret,
			List<Client> clienti) {
		super(nume, furnizor, cantitate, pret, clienti);
		
	}
	@Override
	public String toString() {
		return "ProdusElectronic :" + nume +"furnizor" + furnizor + "cantitate" + cantitate + "pret" + pret + "clienti" + clienti;
	}
	
	
}
