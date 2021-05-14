
import java.util.ArrayList;
import java.util.Iterator;

public class Prueba {
	
	public static void main (String [] args) {
		
		/*
		ArrayList<Par> prueba = new ArrayList<Par>();
		
		Par nuevo1 = new Par (null, 68);
		Par nuevo2 = new Par (null, 69);
		Par nuevo3 = new Par (null, 70);
		Par nuevo4 = new Par (null, 71);
		Par nuevo5 = new Par (null, 72);
		
		prueba.add(nuevo1);
		prueba.add(nuevo2);
		prueba.add(nuevo3);
		prueba.add(nuevo4);
		prueba.add(nuevo5);
		
		Iterator<Par> it = prueba.iterator();
		
		Par menor = null;
		//System.out.println(menor);
		
		Par i = null;
		
		while(it.hasNext()) {
			
			i= it.next();
			
			System.out.println("Voy a comparar: "+i.getValor());
			
			if(menor == null) menor = i;
			else if(i.getValor()<menor.getValor()) menor = i;
			
			//prueba.remove(i); 
			
		}
		
		System.out.println("El menor valor es: "+menor.getValor());
		
		System.out.println("¿Es el último? -> "+prueba.get(prueba.size()-1).getValor());
		
		System.out.println("El número de paradas del metro es: "+Atenas.paradas.size());
		
		//prueba.clear();
		
		prueba.remove(nuevo3);
		
		if(prueba.isEmpty()) System.out.println("La lista está vacia");
		if(prueba.contains(nuevo3)) System.out.println("El elemento no ha sido borrado");
		else System.out.println("Ha sido borrado");
		
		*/
		
		AEstrellaOK.AEstrella("Attiki","Kallithea",1,600,3);
		Auxiliar.mostrar(AEstrellaOK.getCaminoEstaciones());
		
		//System.out.println("Calculo el recorrido de "+Atenas.paradas.get("Monastiraki").getEstacion());
		//ArrayList<Estacion> res = AEstrellaOK.AEstrella(Atenas.paradas.get("Perissos"),Atenas.paradas.get("Faliro"));
	
		
		
		
		//Saco la distancia minima
		// int tiempo = 100;
		// Iterator <Arista> it = Atenas.aristas.iterator();
		// Arista arista = null;
		
		/*                           SACAR EL MENOS TIEMPO
		while(it.hasNext()) {
			arista = (Arista) it.next();
			if(tiempo > arista.getTiempo() && !arista.isTransbordo()) {
				tiempo = arista.getTiempo();
				System.out.println("He cambiado el tiempo en la arista: "+arista.getOrigen()+" - "+arista.getDestino());
			}
		}
		*/
		
		// System.out.println("La tiempo minimo es: "+tiempo);
		
		/*
		if(res.isEmpty()) System.out.println("Esta vacia!!");
		
		Iterator <Estacion> itSolucion = res.iterator();
		while(itSolucion.hasNext()) {
			System.out.println(" - "+itSolucion.next().getEstacion());
		}
		
		System.out.println("La distancia del recorrido es: "+AEstrellaOK.getDistancia());
		
		boolean transbordos [] = AEstrellaOK.getTRansbordos();
		for (int i = 0; i<transbordos.length ; i++) System.out.println("Transbordo "+(i+1)+" : "+transbordos[i]);
		*/
	}
	
}
