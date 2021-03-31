package tema;

import java.util.List;
/**
 * Reprezinta un produs vestimentar derivat din @see Produs
 * @author adelin
 * @since 2.12.2020
 * @version 1.0
 */
public class ProdusVestimentar extends Produs{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProdusVestimentar() {
		super();
	}
	public ProdusVestimentar(String nume, Furnizor furnizor, int cantitate, float pret,
			List<Client> clienti) {
		super(nume, furnizor, cantitate, pret, clienti);
	}
	@Override
	public String toString() {
		return "ProdusVestimentar " + nume + "furnizor" + furnizor + "cantitate" + cantitate + "pret" + pret + "clienti" + clienti;
	}
	
	
	
}
