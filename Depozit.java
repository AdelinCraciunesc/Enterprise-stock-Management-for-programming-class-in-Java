package tema;

import java.io.Serializable;
import java.util.List;
/**
 * Class Depozit reprezinta un depozit al intreprinderii
 * @author adelin
 * @version 1.2
 */
public class Depozit implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String locatie;
	protected List<Produs> listaProduse;
	protected List<String> exceptii;
	
	/**
	 * Constructor implicit
	 */
	public Depozit() {
		super();
	}
	/**
	 * Constructor Explicit
	 * @param id Reprezinta id-ul depozitului
	 * @param locatie Reprezinta locatia depozitului
	 * @param listaProduse Reprezinta Produsele care se afla in depozit
	 * @param exceptii Denota care produse nu se pot afla in depozit
	 */
	public Depozit(int id, String locatie, List<Produs> listaProduse, List<String> exceptii) {
		super();
		this.id = id;
		this.locatie = locatie;
		this.listaProduse = listaProduse;
		this.exceptii = exceptii;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocatie() {
		return locatie;
	}

	public void setLocatie(String locatie) {
		this.locatie = locatie;
	}

	public List<Produs> getListaProduse() {
		return listaProduse;
	}

	public void setListaProduse(List<Produs> listaProduse) {
		this.listaProduse = listaProduse;
	}

	public List<String> getExceptii() {
		return exceptii;
	}

	public void setExceptii(List<String> exceptii) {
		this.exceptii = exceptii;
	}
	
	public <T> void adaugare(T t) {
		listaProduse.add((Produs) t);
	}
	public void stergere(int k) {
		listaProduse.remove(k);
	}
	public void afisareProduse() {
		for(Produs i : listaProduse) {
			System.out.println(i);
		}
	}
	public void afisareProdus(String s) {
		for(Produs i : listaProduse) {
			if(i.nume.equals(s))
				System.out.println(i);
		}
	}

	@Override
	public String toString() {
		return "Depozit [id=" + id + ", locatie=" + locatie + ", listaProduse=" + listaProduse + ", exceptii="
				+ exceptii + "]";
	}
	
}
