package tema;

import java.io.Serializable;
import java.util.List;
/**
 * Clasa reprezinta un produs de ingrijire personala derivat din @see Produs
 * @author adelin
 *
 */
public class ProdusIngrijire extends Produs implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProdusIngrijire() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 *
	 */
	public ProdusIngrijire(String nume, Furnizor furnizor, int cantitate, float pret,
			List<Client> clienti) {
		super(nume, furnizor, cantitate, pret, clienti);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProdusIngrijire " + nume + "furnizor" + furnizor + "cantitate" + cantitate + "pret" + pret + "clienti" + clienti;
	}
	
	
	
	
}
