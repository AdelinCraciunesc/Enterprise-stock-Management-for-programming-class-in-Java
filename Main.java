package tema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Aplicatie pentru gestiunea unei inteprinderi
 * @author adelin
 * @version 1.5
 */
public class Main {
	
	public static void adaugareDepozit(List<Depozit> d) {
		Scanner in1 = new Scanner(System.in);
		System.out.println("Id");
		int id = Integer.parseInt(in1.nextLine());
		System.out.println("Locatie");
		String locatie = in1.nextLine();
		List<Produs> listaProduse = new ArrayList<Produs>();
		System.out.println("Cate exceptii de produse are depozitul? (1-3)");
		int nrExceptii = Integer.parseInt(in1.nextLine());
		List<String> exceptii = new ArrayList<>();
		for(int i = 0 ; i<nrExceptii;i++)
		{
			System.out.println("Adaugare Exceptie:(ProdusAlimentar,ProdusVestimentar,ProdusElectronic,ProdusIngrijire)");
			String exceptie = in1.nextLine();
			exceptii.add(exceptie);
		}
		//in1.close();
		d.add(new Depozit(id,locatie,listaProduse,exceptii));
	}
	
	public static void stergereDepozit(List<Depozit> d,int k) {
		int poz = 0,ok = 0;
		for(Depozit i : d) {
			poz++;
			if(i.getId()==k) {
				d.remove(poz);
				ok = 1;
			}
		}
		if(ok == 0) {
			System.out.println("Depozitul cu id-ul" + k + "nu a fost gasit");
		}
		else if(ok == 1) {
			System.out.println("Operatiunea a fost efectuata cu succes");
		}
	}
	public static void afisareDepozite(List<Depozit> d) {
		for(Depozit i : d) {
			i.toString();
		}
	}
	public static void modificareDepozit(List<Depozit> d) {
		System.out.println("Inserati Optiunea dorita: \n");
		System.out.println("1.Modificare Locatie\n2.Adaugare Exceptie\n3.Stergere Exceptie");
		Scanner in = new Scanner(System.in);
		int choice = Integer.parseInt(in.nextLine());
		System.out.println("Id depozit");
		int id = Integer.parseInt(in.nextLine());
		if(choice==1)
		{
			for(Depozit i : d) {
				if(i.getId()==id) {
					System.out.println("Locatie:");
					String s = in.nextLine();
					i.setLocatie(s);
				}
			}
		}
		else if(choice==2)
		{
			for(Depozit i:d) {
				if(i.getId()==id) {
					System.out.println("Adaugare Exceptie:(ProdusAlimentar,ProdusVestimentar,ProdusElectronic,ProdusIngrijire)");
					String ex = in.nextLine();
					i.getExceptii().add(ex);
				}
			}
		}
		else if(choice==3) {
			for(Depozit i : d) {
				System.out.println("Stergere Exceptie:(ProdusAlimentar,ProdusVestimentar,ProdusElectronic,ProdusIngrijire)");
				String ex =in.nextLine();
				i.getExceptii().remove(ex);
			}
		}
		else
		{
			System.out.println("Optiune Invalida Incercati din nou");
		}
		in.close();
	}
	
	public static void profit(List<Produs> l) {
		Map<String, Double> m = new HashMap<>();
		for(Produs i : l) {
			double sc = 0;
			for(Client c : i.getClienti()) {
				sc += c.getProdA()*i.getPret();
			}
			if(m.containsKey(i.getNume())) {
				m.put(i.getNume(), m.get(i.getNume())-i.getFurnizor().getProdL()*i.getPret());
			}
			else {
				m.put(i.getNume(), sc);
			}
		}
		
		for(Map.Entry<String, Double> i : m.entrySet()) {
			System.out.println("Pentru produsul " + i.getKey() + " s-a obtinut un profitul " + i.getValue());
		}
	}

	public static void transfer(Depozit d,Depozit d1,Produs p) {
		System.out.println("");
		//cautare produs in depozit
		for(Produs i : d.getListaProduse()) {
			if(i.getNume().equals(p.getNume()))
			{
				d1.getListaProduse().add(i);
				d.getListaProduse().remove(i);
			}
		}
	}
	
	public static void sumaTotalaClienti(List<Produs> lp) {
		double suma = 0;
		for(Produs i : lp) {
			for(Client j : i.getClienti()) {
				suma = j.getProdA()*i.getPret();
			}
		}
		System.out.println("Suma datorata de toti clientii:"+suma);
	}
	public static void sumaClient(List<Produs> lp){
		Map<String,Double> m = new HashMap<String,Double>();
		for(Produs i : lp) {
			double suma = 0;
			for(Client j : i.getClienti()) {
				suma += j.getProdA() * i.getPret();
				if(m.containsKey(j.getNume())){	
					m.put(j.getNume(), m.get(j.getNume()) + suma);
				}
				else {
					m.put(j.getNume(), suma);
				}
			}
		}
		for(Map.Entry<String, Double> k : m.entrySet()) {
			System.out.println("Clientul" + k.getKey() + " datoreaza suma de: " + k.getValue());
		}
	}
	public static void sumaTotalaFurnizor(List<Produs> lp){
		double suma = 0;
		for(Produs i : lp) {
			suma += i.getFurnizor().getProdL() * i.pret;
		}
		System.out.println("Suma totala datorata furnizorilor"+suma);
	}
	
	public static void sumaFurnizor(List<Produs> lp){
		Map<String,Double> m = new HashMap<String,Double>();
		double suma = 0;
		for(Produs i : lp) {
			if(m.containsKey(i.getFurnizor().getNume())){
				suma += i.getFurnizor().getProdL() * i.getPret();
				m.put(i.getFurnizor().getNume(), m.get(i.getFurnizor().getNume()) + suma);
			}
			else {
				m.put(i.getFurnizor().getNume(), suma);
			}
		}
		for(Map.Entry<String, Double> k : m.entrySet()) {
			System.out.println("Furnizorul" + k.getKey() + " trebuie sa primeasca suma de: " + k.getValue());
		}
	}
	
	public static void serializare(File f,List<Depozit> listad) throws IOException{
		FileOutputStream fout = new FileOutputStream(f);
		ObjectOutputStream obj = new ObjectOutputStream(fout);
		
		listad.stream().forEach(e->{
			try {
				obj.writeObject(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		
		obj.close();
		fout.close();
	}
	
	public static void deserializare(File f,List<Depozit> listaD) throws IOException,ClassNotFoundException
	{
		try {
			FileInputStream fileIn = new FileInputStream(f);
			ObjectInputStream depIn = new ObjectInputStream(fileIn);
			
			while(depIn.available()!=0) {
				Object obj = depIn.readObject();
				listaD.add((Depozit) obj);
			}
			fileIn.close();
			depIn.close();
		}
		catch(IOException|ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void meniuDepozite(List<Depozit> d,List<Produs> p)
	{
		boolean meniu = true;
		Scanner in = new Scanner(System.in);
		while(meniu) {
			System.out.println("Inserati Optiunea dorita: \n");
			System.out.println("1.Adaugare Depozit\n2.Stergere Depozit\n3.Modificare Depozit\n4.Afisare Depozite\n5.Transfer\n6.Exit\n");
			int choice = in.nextInt();
			in.nextLine();
			switch(choice) {
			case 1:{
				adaugareDepozit(d);
				break;}
			case 2:{
				System.out.println("Id depozit\n");
				int id = Integer.parseInt(in.nextLine());
				stergereDepozit(d,id);
				break;}
			case 3:{
				modificareDepozit(d);
				break;}
			case 4:{
				afisareDepozite(d);
				break;}
			case 5:{
				int id1,id2;
				id1=Integer.parseInt(in.nextLine());
				id2=Integer.parseInt(in.nextLine());
				Depozit d1 = new Depozit();
				Depozit d2 = new Depozit();
				for(Depozit i : d) {
					if(i.getId()==id1) {
						d1=i;
					}
					if(i.getId()==id2) {
						d2=i;
					}
				}
				String numep = in.nextLine();
				Produs p1 = new Produs();
				for(Produs j : p) {
					if(j.getNume().equals(numep)) {
						p1 = j;
					}
				}
				transfer(d1,d2,p1);
				break;}
			case 6:{
				meniu=false;
				break;}
			default:{
				System.out.println("Optiune Invalida Incercati din nou\n");
				break;}
			}
		}
		in.close();
	}
		
	public static void meniuProduse(List<Produs> p,List<Depozit> d){
		boolean meniu = true;
		Scanner in = new Scanner(System.in);
		while(meniu) {
			System.out.println("Inserati Optiunea dorita: \n");
			System.out.println("1.Adaugare Produs\n2.Stergere Produs\n3.Detalii Produs\n4.Afisare Produse\n5.Detalii Categorie Produs\n6.Achizitare Produse\n7.Gasire Produs intr-un depozit\n8.Exit");
			System.out.println("\n");
			int choice = Integer.parseInt(in.nextLine());
			switch(choice) {
				case 1:{
					System.out.println("Nume Produs:");
					String nume = in.nextLine();
					System.out.println("Nume furnizor:");
					String fnume = in.nextLine();
					System.out.println("Produse Livrate pe luna:");
					int prodL = Integer.parseInt(in.nextLine());
					System.out.println("Cantitate Produs:");
					int cantitate = Integer.parseInt(in.nextLine());
					Furnizor f = new Furnizor(fnume,prodL);
					System.out.println("Pret Produs:");
					float pret = Float.parseFloat(in.nextLine());
					System.out.println("Numar Clienti Produs:");
					int nrClienti = Integer.parseInt(in.nextLine());
					List<Client> clienti = new ArrayList<Client>();
					for(int i=0;i<nrClienti;i++){
						System.out.println("Nume Client:");
						String cnume = in.nextLine();
						System.out.println("Numar Produse Achizitionate:");
						int proda = Integer.parseInt(in.nextLine());
						clienti.add(new Client(cnume,proda));
					}
					System.out.println("Tipul Produsului:(ProdusAlimentar/ProdusElectronic/ProdusIngrijire/ProdusVestimentar)");
					String tip = in.nextLine();
					if(tip.equals("ProdusAlimentar")) {
						ProdusAlimentar p1 = new ProdusAlimentar(nume,f,cantitate,pret,clienti);
						p.add(p1);
					}
					if(tip.equals("ProdusElectronic")) {
						ProdusElectronic p1 = new ProdusElectronic(nume,f,cantitate,pret,clienti);
						p.add(p1);
					}
					if(tip.equals("ProdusIngrijire")) {
						ProdusIngrijire p1 = new ProdusIngrijire(nume,f,cantitate,pret,clienti);
						p.add(p1);
					}
					if(tip.equals("ProdusVestimentar")) {
						ProdusVestimentar p1 = new ProdusVestimentar(nume,f,cantitate,pret,clienti);
						p.add(p1);
					}
					
					System.out.println("Id-ul depozitului pentru adaugarea produsului in aceasta:");
					int id = Integer.parseInt(in.nextLine());
					for(Depozit x : d){
						if(x.getId()==id){
							for(String y : x.getExceptii()) {
								if(p.get(p.size()-1).getClass().getSimpleName().equals(y)!=true)
								{
									x.getListaProduse().add(p.get(p.size()-1));
								}
							}
						}
					}
					break;
				}
				case 2:{
					System.out.println("Nume Produs de sters din stoc:");
					String numep = in.nextLine();
					for(Produs i : p){
						if(i.getNume().equals(numep)) {
							p.remove(i);
						}
					}
					break;
				}
			case 3:{
					System.out.println("Nume Produs pentru afisare");
					String numep = in.nextLine();
					for(Produs i : p) {
						if(i.getNume().equals(numep)) {
							System.out.println(i);
							break;
						}
					}
					break;
				}
			case 4:{
				for(Produs i : p) {
					System.out.println(i);
				}
				break;
			}
			case 5: {
				System.out.println("Categorie Produs:(ProdusAlimentar/ProdusElectronic/ProdusIngrijire/ProdusVestimentar)");
				String numeC = in.nextLine();
				if(numeC.equals("ProdusAlimentar") || numeC.equals("ProdusElectronic") || numeC.equals("ProdusVestimentar") || numeC.equals("ProdusIngrijire")) {
					for(Produs i : p) {
						if(i.getClass().getSimpleName().equals(numeC)) {
							System.out.println(i.getClass().getSimpleName() + " ");
							System.out.println(i);
						}
					}
				}
				else {
					System.out.println("Alegere Invalida incercati din nou");
				}
				break;
			}
			case 6: {
				System.out.println("Nume produs:");
				String nume=in.nextLine();
				for(Produs i : p) {
					if(i.getNume().equals(nume)) {
						System.out.println("Cate produse au fost achizitate?:");
						int pa=in.nextInt();
						i.setCantitate(i.getCantitate()+pa);
						break;
					}
				}
				break;
			}
			case 7:{
				System.out.println("Nume produs:");
				String numep = in.nextLine();
				for(Depozit i : d) {
					for(Produs j : i.getListaProduse()) {
						if(j.getNume().equals(numep)==true) {
							System.out.println("Produsul"+j+"se afla in depozitul"+i);
							break;
						}
					}
				}
				break;
			}
			case 8:{
				meniu=false;
				break;
			}
			default:System.out.println("Optiune Invalida Incercati din nou");
			}
		}
		in.close();
	}

	public static void main(String[] args) {
		List<Depozit> d = new ArrayList<Depozit>();
		File f = new File("Folder/produse.txt");
		try { 
			deserializare(f,d); 
			} 
		catch(IOException|ClassNotFoundException e) 
		{
		  e.printStackTrace(); 
		}
		List<Produs> l1 = new ArrayList<Produs>();
		List<String> e1 = new ArrayList<>();
		e1.add("ProdusAlimentar");
		Depozit d1 = new Depozit(1,"Locatie1",l1,e1);
		List<Produs> l2 = new ArrayList<Produs>();
		List<String> e2 = new ArrayList<>();
		e2.add("ProdusVestimentar");
		e2.add("ProdusElectronic");
		Depozit d2 = new Depozit(2,"Locatie2",l2,e2);
		d.add(d1);
		d.add(d2);
		List<Produs> lp = new ArrayList<Produs>();
		for(Depozit x : d) {
			for(Produs y : x.getListaProduse()) {
				lp.add(y);
			}
		}
		
		boolean meniu=true;
		Scanner in = new Scanner(System.in);
		while(meniu) {
			System.out.println("Inserati operatiunea dorita\n");
			System.out.println("1.Meniu manipulare Produse\n2.Meniu manipulare depozite(Da eroare)\n3.Profit\n4.Suma datorata Client\n5.Suma datorata Furnizor\n6.Suma Totala datorata Clienti\n7.Suma Totala datorata Furnizori\n8.Exit\n");
			int choice=Integer.parseInt(in.nextLine());
			
			switch(choice) {
			case 1:{
				meniuProduse(lp,d);
				break;
			}
			case 2:{
				meniuDepozite(d,lp);
				break;
			}
			case 3:{
				profit(lp);
				break;
			}
			case 4:{
				sumaClient(lp);
				break;
			}
			case 5:{
				sumaFurnizor(lp);
				break;
			}
			case 6:{
				sumaTotalaClienti(lp);
				break;
			}
			case 7:{
				sumaTotalaFurnizor(lp);
				break;
			}
			case 8:{
				meniu=false;
				break;
			}
			default:{
				System.out.println("Try again");
				break;
			}
			}
		}
		
		in.close();
		try {
			serializare(f,d);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
