
public class Estacion {
    private String estacion, padre;
    private int linea;
    private boolean hayTransbordo;
    private double tiempo, distancia, gCoste, hCoste;
    private int xPos, yPos; //Posicion en el mapa
    private int proximidad;
    
    public Estacion(String estacion, int linea, boolean hayTransbordo, double tiempo, double distancia, double gCoste, double hCoste, int xPos, int yPos) {
        this.estacion = estacion;
        this.linea = linea;
        this.hayTransbordo = hayTransbordo;
        this.tiempo = tiempo;
        this.distancia = distancia;
        this.gCoste=gCoste;
        this.hCoste=hCoste;
        this.xPos = xPos;
        this.yPos = yPos;
        this.proximidad=0;
    }
	
	public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public boolean hayTransbordo() {
        return hayTransbordo;
    }

    public void setHayTransbordo(boolean hayTransbordo) {
        this.hayTransbordo = hayTransbordo;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    public double getgCoste() {
		return gCoste;
	}

    public void setgCoste(double gCoste) {
		this.gCoste = gCoste;
	}

	public double gethCoste() {
		return hCoste;
	}

	public void sethCoste(double hCoste) {
		this.hCoste = hCoste;
	}

    public double getTotalCost(){
        return gCoste + hCoste;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }
    
    public void setProximidad(int valor) {
    	this.proximidad=valor;
    }
    
    public int getProximidad() {
    	return proximidad;
    }

}
