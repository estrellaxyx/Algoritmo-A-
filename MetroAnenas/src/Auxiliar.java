
import java.util.*;

public class Auxiliar {

	//Depuracion
	public static void mostrar(ArrayList <Estacion> lista) {
		Iterator <Estacion> itLista = lista.iterator();
		
		while(itLista.hasNext()) {
			System.out.println(" - "+itLista.next().getEstacion());
		}
	}
	
	public static String imprimirBonito (ArrayList <Estacion> lista) {
		
		boolean[]transbordos = AEstrellaOK.getTRansbordos();/*
		if(transbordos[0]) lista.remove(Atenas.paradas.get("Attiki L2"));
		if(transbordos[1]) lista.remove(Atenas.paradas.get("Omonia L2"));
		if(transbordos[2]) lista.remove(Atenas.paradas.get("Monastiraki L3"));
		if(transbordos[3]) lista.remove(Atenas.paradas.get("Syntagma L3"));
		*/
		
		String res = "";
		
		ArrayList <String> copia = new ArrayList<String>();
    	Iterator <Estacion> itLista = lista.iterator();
    	Estacion next;
    	
    	while(itLista.hasNext()) {
    		next = itLista.next();
    		if(next.getEstacion().equals("Attiki L1")) { copia.add("Attiki"); if(transbordos[0]) copia.add("\nRealiza transbordo a la linea "+elegir(1)+"\n");}
    		else if (next.getEstacion().equals("Omonia L1")) {copia.add("Omonia"); if(transbordos[1]) copia.add("\nRealiza transbordo a  la linea "+elegir(2)+"\n");}
    		else if (next.getEstacion().equals("Monastiraki L1")) {copia.add("Monastiraki"); if(transbordos[2]) copia.add("\nRealiza transbordo a la linea "+elegir(3)+"\n");}
    		else if (next.getEstacion().equals("Syntagma L2")) {copia.add("Syntagma"); if(transbordos[3]) copia.add("\nRealiza transbordo a la linea "+elegir(4)+"\n");}
    		else if(next.getEstacion().equals("Attiki L2") || next.getEstacion().equals("Omonia L2") || next.getEstacion().equals("Monastiraki L3") || next.getEstacion().equals("Syntagma L3")) {}
    		else copia.add(next.getEstacion());
    	}
    	
    	Iterator <String> itCopia = copia.iterator();
    	String origen = copia.get(0), destino = copia.get(copia.size()-1);
    	
    	res+= "Toma el metro en: "+origen+" , linea: "+ lista.get(0).getLinea()+ "\n\n";
		
		while(itCopia.hasNext()) {
			res+= itCopia.next()+"\n";
		}
		res+= "\nHa llegado a su destino\n";
    	
		res+= "\nDistancia del trayecto: "+ String.format("%.2f", AEstrellaOK.getDistancia())+" Km";
		res+= "\nTiempo del trayecto: "+ AEstrellaOK.getTiempo()+" Min";
		res+= "\nNumero de transbordos: "+ AEstrellaOK.getNumTransbordos();
    	
		return res;
	}
	
	//Dirección de transbordo
	private static String elegir (int numero) {
		String res = "";
		Estacion a = null, b = null;
		if(numero == 1) { a = Atenas.paradas.get("Attiki L1"); b = Atenas.paradas.get("Attiki L2");}
		else if(numero == 2) { a = Atenas.paradas.get("Omonia L1"); b = Atenas.paradas.get("Omonia L2");}
		else if(numero == 3) { a = Atenas.paradas.get("Monastiraki L1"); b = Atenas.paradas.get("Monastiraki L3");}
		else if(numero == 4) { a = Atenas.paradas.get("Syntagma L2"); b = Atenas.paradas.get("Syntagma L3");}
		
		if (a.getProximidad()<b.getProximidad()) res+= a.getLinea();
		else res+= b.getLinea();
			
		return res;
	}
}
