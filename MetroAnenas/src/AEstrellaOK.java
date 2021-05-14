
import java.util.*;

public class AEstrellaOK {
	
	//Distancia minima entre estaciones
	final static double DISTANCIA_MINIMA = 0.47;
	final static double TIEMPO_MINIMO = 1;
	final int TIEMPOTRANSBORDO = 5;
    private static String paradaInicialString, paradaMetaString;
    private static Estacion paradaInicialEstacion, paradaMetaEstacion = null;
	
	/* [0] -> Attiki L1 - L2
	 * [1] -> Omonia L1 - L2
	 * [2] -> Monastiraki L1 - L3
	 * [3] -> Syntagma L2 - L3
	 */
	private static boolean[] transbordo;
	private static boolean hayTransbordo;
	
	private static int criterio;
	private static double distancia;
	private static int tiempo;
	
	private static int tTransbordo;
	
	private static ArrayList <Estacion> recorridas;
	
	private static ArrayList <Estacion> caminoEstaciones;
	private static ArrayList <Arista> caminoAristas;

    //Criterio + Datos + Comienzo
	/*
	 * Minimizar: 
	 * 1-> Transbordos
	 * 2-> Distancia
	 * 3-> Tiempo
	 */
    public static void AEstrella (String origen, String destino, int minimizar, double hora, int diaSem) {
    	tTransbordo = 5;
    	distancia=0;
    	tiempo=0;
    	//caminoAristas=new ArrayList<Arista>();
    	transbordo=new boolean[] {false,false,false,false};
    	//Horas
    	if (hora >= 500 && hora < 600) {
			tTransbordo += 5;
		}else if (hora >= 2030 && hora < 2200) {
			tTransbordo += 2;
		}else if (hora >= 2200 && hora < 30) {
			tTransbordo += 5;
		}else if ((diaSem == 6 || diaSem == 7) && (hora >= 30 && hora < 200)) {
			tTransbordo += 10;
		}
    	
    	hayTransbordo= false;
    	
    	recorridas = new ArrayList <Estacion>();

    	paradaMetaString = destino;
    	
    	
    	proximidad(); 
    	
    	//Estaciones que nos importa 
    	paradaInicialString = origen;
    	paradaInicialEstacion = inicio(origen);
    	if (criterio==1) paradaMetaEstacion = destino(destino);
    	criterio = minimizar;
    	
    	System.out.println("Estación Incial: "+paradaInicialEstacion.getEstacion());
    	recorridas.add(paradaInicialEstacion);
    	
    	
    	boolean fin = false;
    	while(!fin) fin = moverEstacion(recorridas);
        
        transbordos (recorridas);
                
        caminoEstaciones = recorridas;
    }
    
    private static Estacion destino(String destino) {
    	Estacion res;
    	
    	if(destino.equals("Omonia")) {
    		if(1 == paradaInicialEstacion.getLinea()) res = Atenas.paradas.get("Omonia L1");
    		else res = Atenas.paradas.get("Omonia L2");
    		
		}
		else if(destino.equals("Attiki")) {
			if(1 == paradaInicialEstacion.getLinea()) res = Atenas.paradas.get("Attiki L1");
    		else res = Atenas.paradas.get("Attiki L2");
		}
			
		else if(destino.equals("Monastiraki")) {
			if(1 == paradaInicialEstacion.getLinea()) res = Atenas.paradas.get("Monastiraki L1");
			else res = Atenas.paradas.get("Monastiraki L3");
		}
		
		else if(destino.equals("Syntagma")) {
			if(3 == paradaInicialEstacion.getLinea()) res = Atenas.paradas.get("Syntagma L3");
			else res = Atenas.paradas.get("Syntagma L2");
		}
		
		else res = Atenas.paradas.get(destino);
		
		if(res == null) System.out.println("ERROR: No se ha obtenido la estación inicial");
    	return res;
    }
    
   /**
    * Dado el nombre de origen nos devuelve la estacion origen
    * @param origen
    * @return
    */
    private static Estacion inicio (String origen) {
		Estacion res = null;
		
		if(origen.equals("Omonia")) {
			if (Atenas.paradas.get("Omonia L1").getProximidad()<=Atenas.paradas.get("Omonia L2").getProximidad())res = Atenas.paradas.get("Omonia L1");
			else res = Atenas.paradas.get("Omonia L2");
		}
		
		else if(origen.equals("Attiki")) {
			if (Atenas.paradas.get("Attiki L1").getProximidad()<=Atenas.paradas.get("Attiki L2").getProximidad()) res = Atenas.paradas.get("Attiki L1");
			else if(origen.equals("Attiki")) res = Atenas.paradas.get("Attiki L2");
		}
			
		else if(origen.equals("Monastiraki")) {
			if (Atenas.paradas.get("Monastiraki L1").getProximidad()<=Atenas.paradas.get("Monastiraki L3").getProximidad()) res = Atenas.paradas.get("Monastiraki L1");
			else if(origen.equals("Monastiraki")) res = Atenas.paradas.get("Monastiraki L3");
		}
		
		else if(origen.equals("Syntagma")) {
			if (Atenas.paradas.get("Syntagma L3").getProximidad()<=Atenas.paradas.get("Syntagma L2").getProximidad()) res = Atenas.paradas.get("Syntagma L3");
			else if(origen.equals("Syntagma")) res = Atenas.paradas.get("Syntagma L2");
		}
		
		else res = Atenas.paradas.get(origen);
		
		if(res == null) System.out.println("ERROR: No se ha obtenido la estación inicial");
		
		return res;
	}
	
    //Obtener siguiente parada
    private static boolean moverEstacion(ArrayList <Estacion> recorridas) {    	
    	
    	//Varibles
    	boolean fin =false;
    	Estacion ultimaRecorrida = recorridas.get(recorridas.size()-1);
    	
    	//ArrayList <Estacion> accesibles = new ArrayList <Estacion> ();
    	ArrayList<Estacion> accesibles = new ArrayList<Estacion>();
    	Iterator <Estacion> itRecorridas = recorridas.iterator();
    	
    	//Auxiliar
    	Estacion auxEstacion = null;
    	ArrayList<Estacion> auxLista = new ArrayList<Estacion>();
    	Iterator<Estacion> auxIterator;
    	
    	while(itRecorridas.hasNext()){
    		auxEstacion = itRecorridas.next();
    		auxLista = aristasNodo(auxEstacion);
    		auxIterator = auxLista.iterator();
    		while(auxIterator.hasNext()) {
    			auxEstacion = auxIterator.next();
    			if(ultimaRecorrida.getProximidad()>=auxEstacion.getProximidad()) accesibles.add(auxEstacion);
    		}
    	}
    	
    	Estacion costeMin = estacionCosteMin(accesibles, ultimaRecorrida);
    	
    	if(costeMin == null) System.out.println("ERROR: Siguiente estación no encontrada \nUltima encontrada: "+recorridas.get(recorridas.size()-1).getEstacion());
    	
    	else {
    		recorridas.add(costeMin); 
    		distancia = distancia + obtenerArista(ultimaRecorrida,costeMin).getDistancia();
    		tiempo = tiempo + obtenerArista(ultimaRecorrida,costeMin).getTiempo();
    		
    		//Dep
    		if(costeMin.getProximidad()==0) {
    			fin=true; 
    		}
    			
    	}
    	
    	return fin;
    }
    
   
    
    private static Estacion estacionCosteMin(ArrayList<Estacion> accesibles, Estacion ultimaRecorrida) {
    	Iterator <Estacion> itAccesibles = accesibles.iterator();
    	
    	Estacion costeMin = null;
    	Estacion estacion;
    	double distancia = 0;
    	int tiempo = 0;
    	
    	while(itAccesibles.hasNext()) {
    		estacion = itAccesibles.next();
    		
    		if(costeMin == null && criterio!=1) costeMin = estacion;
    		else {
    			if (criterio == 1) {
    				if(costeMin == null && (ultimaRecorrida.getLinea()==estacion.getLinea())) costeMin = estacion;
    				if((estacion.getProximidad()<costeMin.getProximidad()) && estacion.getLinea()==ultimaRecorrida.getLinea()) costeMin = estacion;
    				else if ((estacion.getProximidad()<costeMin.getProximidad()) && !hayTransbordo) {costeMin = estacion; hayTransbordo = true;}
    			}
    			if(criterio == 2) {
    				if (((costeMin.getProximidad()*DISTANCIA_MINIMA)+distancia+obtenerArista(ultimaRecorrida,costeMin).getDistancia()) > ((estacion.getProximidad()*DISTANCIA_MINIMA)+distancia+obtenerArista(ultimaRecorrida,estacion).getDistancia())) costeMin = estacion;
    			}
    			
    			else if(criterio == 3) 
            		if (((costeMin.getProximidad()*TIEMPO_MINIMO)+tiempo+obtenerArista(ultimaRecorrida,costeMin).getTiempo()) > ((estacion.getProximidad()*TIEMPO_MINIMO)+tiempo)+obtenerArista(ultimaRecorrida,estacion).getTiempo()) costeMin = estacion;
    		}    		
    		
    	}
    	
    	return costeMin;
    }
    
    /**
     * ALGORITMO DE ETIQUETADO DE PROXIMIDAD:
     * 
     * ArrayList = 3
     * 			Reconocidas -> Guardamos las que vamos recorriendo
     * 			Etiquetadas -> Guardamos el último nivel repasado
     * 			Auxiliar -> Guardamos de forma provisional las adyacentes a cada una de las ultimas etiquetadas
     * 
     * Cuando acabamos de recorrer todas las etiquetadas -> Sumamos i
     * 
     * En reconocidas vamos a ir metiendo aquellas que ya hemos etiquetado
     * 
     * Recorremos las etiquetadas -> Una por una
     * 			Metemos adyacentes asignandolas i+1 (Si no estaban ya en la lista reconocida) ->Lista auxiliar
     * 			Sacamos la etiquetada
     * 			Hacemos la auxiliar la adyacente
     * 
     * Fin -> Cuando no tengamos nuevas aristas adyacentes
     * 
     */
    private static void proximidad() {
    	//Auxiliares
    	ArrayList <Estacion> reconocidas = new ArrayList<Estacion>();
    	ArrayList <Estacion> etiquetadas = new ArrayList<Estacion>();
    	ArrayList <Estacion> auxiliar = new ArrayList<Estacion>();
    	
    	if(paradaMetaString.equals("Attiki")) {
    		Atenas.paradas.get("Attiki L1").setProximidad(0);
    		Atenas.paradas.get("Attiki L2").setProximidad(0);
    		reconocidas.add(Atenas.paradas.get("Attiki L1"));
    		reconocidas.add(Atenas.paradas.get("Attiki L2"));
        	etiquetadas.add(Atenas.paradas.get("Attiki L1"));
        	etiquetadas.add(Atenas.paradas.get("Attiki L2"));
    	}
    	else if(paradaMetaString.equals("Omonia")) {
    		Atenas.paradas.get("Omonia L1").setProximidad(0);
    		Atenas.paradas.get("Omonia L2").setProximidad(0);
    		reconocidas.add(Atenas.paradas.get("Omonia L1"));
    		reconocidas.add(Atenas.paradas.get("Omonia L2"));
        	etiquetadas.add(Atenas.paradas.get("Omonia L1"));
        	etiquetadas.add(Atenas.paradas.get("Omonia L2"));
		}
    	else if(paradaMetaString.equals("Monastiraki")) {
    		Atenas.paradas.get("Monastiraki L1").setProximidad(0);
    		Atenas.paradas.get("Monastiraki L3").setProximidad(0);
    		reconocidas.add(Atenas.paradas.get("Monastiraki L1"));
    		reconocidas.add(Atenas.paradas.get("Monastiraki L3"));
        	etiquetadas.add(Atenas.paradas.get("Monastiraki L1"));
        	etiquetadas.add(Atenas.paradas.get("Monastiraki L3"));
			
		}
    	
    	else if(paradaMetaString.equals("Syntagma")) {
    		Atenas.paradas.get("Syntagma L3").setProximidad(0);
    		Atenas.paradas.get("Syntagma L2").setProximidad(0);
    		reconocidas.add(Atenas.paradas.get("Syntagma L3"));
    		reconocidas.add(Atenas.paradas.get("Syntagma L2"));
        	etiquetadas.add(Atenas.paradas.get("Syntagma L3"));
        	etiquetadas.add(Atenas.paradas.get("Syntagma L2"));	
		}
    	
    	else {
    		Atenas.paradas.get(paradaMetaString).setProximidad(0);
        	reconocidas.add(Atenas.paradas.get(paradaMetaString));
        	etiquetadas.add(Atenas.paradas.get(paradaMetaString));
    	}
    	//Configuración Inicial
    	int proximidad = 1;
    	
    	//Creo los iteradores
    	Iterator <Estacion> itEtiquetadas;
    	Iterator <Estacion> itAuxiliar;
    	
    	//Estaciones Auxiliares
    	Estacion aux1 =null;
    	
    	
    	while(!etiquetadas.isEmpty()) {
    		
    		itEtiquetadas = etiquetadas.iterator();
    		
        	while(itEtiquetadas.hasNext()) {
        		aux1 = itEtiquetadas.next();
        		auxiliar.addAll(aristasNodo(aux1));
        	}
        	
        	etiquetadas.clear();
        	
        	itAuxiliar = auxiliar.iterator(); 
        	        	
        	while (itAuxiliar.hasNext()) {
        		aux1 = itAuxiliar.next();
        		
        		if(!reconocidas.contains(aux1)) {
        			        			
        			aux1.setProximidad(proximidad);
        			reconocidas.add(aux1);
        			etiquetadas.add(aux1);
        		}
        		
        	}
        	auxiliar.clear();
        	
        	proximidad++;
    	}
    }

	static Arista obtenerArista (Estacion origen, Estacion destino) {
    	ArrayList <Arista> aristas = Atenas.aristas;
    	Iterator <Arista>  itAristas = aristas.iterator();
    	Arista res = null;
    	boolean encontrado = false;
    	while (itAristas.hasNext() && !encontrado) {
    		res = itAristas.next();
    		if(res.getDestino().equals(destino.getEstacion()) && res.getOrigen().equals(origen.getEstacion())) {
    			encontrado = true;
    		}
    	}
    	
    	if (res == null) System.out.println("ERROR: Arista no encontrada");

    	return res;
    }
   
    
    /**
     * Dado un Par -> Estacion + Distancia 
     * Devolvemos un ArrayList con las estaciones accesibles 
     * @param par
     */
    private static ArrayList <Estacion> aristasNodo(Estacion estacion) {
    	
    	Iterator <Arista> itAristas = Atenas.aristas.iterator();
    	
    	ArrayList<Estacion> estaciones = new ArrayList<Estacion>();
    	String nombre = estacion.getEstacion();
    	
    	Arista i = null;
    	
    	//Buscamos las estaciones
    	while(itAristas.hasNext()) {
    		i = itAristas.next();
    		if(i.getDestino().equals(nombre) || i.getOrigen().equals(nombre)) {
    			//System.out.println("He encontrado una parada que coincide con la buscada -> ORIGEN: "+i.getOrigen()+" DESTINO: "+i.getDestino());
    			if (i.getDestino().equals(nombre)) estaciones.add(Atenas.paradas.get(i.getOrigen())); 
    			else estaciones.add(Atenas.paradas.get(i.getDestino())); 
    		}
    	}
    	
    	return estaciones;
    }
    
    public static double getDistancia() {
    	return distancia;
    }

    private static void transbordos(ArrayList <Estacion> lista) {
    	if(lista.contains(Atenas.paradas.get("Attiki L1")) && lista.contains(Atenas.paradas.get("Attiki L2"))) transbordo[0] = true;
    	if(lista.contains(Atenas.paradas.get("Omonia L1")) && lista.contains(Atenas.paradas.get("Omonia L2"))) transbordo[1] = true;
    	if(lista.contains(Atenas.paradas.get("Monastiraki L1")) && lista.contains(Atenas.paradas.get("Monastiraki L3"))) transbordo[2] = true;
    	if(lista.contains(Atenas.paradas.get("Syntagma L2")) && lista.contains(Atenas.paradas.get("Syntagma L3"))) transbordo[3] = true;
    }

    public static boolean[] getTRansbordos() {
    	return transbordo;
    }
    
    public static int getNumTransbordos() {
    	int res=0;
    	for (int i=0;i<4;i++) if(transbordo[i]==true) res++;
    	return res;
    }
    
    public static int getTiempo() {
    	return tiempo + (getNumTransbordos()*tTransbordo);
    }
    
    public static ArrayList <Estacion> getCaminoEstaciones () {
    	return caminoEstaciones;
    }
    
    public static ArrayList <Arista> getCaminoAristas () {
    	/*for(int i=0;i<recorridas.size()-1;i++) {
    		caminoAristas.add(AEstrellaOK.obtenerArista(recorridas.get(i),recorridas.get(i+1)));
		}*/
    	return caminoAristas;
    }
}