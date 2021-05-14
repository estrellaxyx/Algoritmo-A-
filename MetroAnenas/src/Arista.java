
import java.awt.Point;
import java.util.ArrayList;

public class Arista {
	private String origen;
	private String destino;
	private ArrayList<Point> puntosRecta;
	private boolean transbordo;
	private double distancia;	//Lo pongo en float??
	private int tiempo;
	private Arista anterior;
	
	public Arista(String origen, String destino, ArrayList<Point> puntosRecta, boolean transbordo, double distancia, int tiempo) {
		this.origen = origen;
		this.destino = destino;
		this.puntosRecta = puntosRecta;
		this.transbordo = transbordo;
		this.distancia = distancia;
		this.tiempo = tiempo;
	}

	public ArrayList<Point> getPuntosRecta() {
		return puntosRecta;
	}

	public void setPuntosRecta(ArrayList<Point> puntosRecta) {
		this.puntosRecta = puntosRecta;
	}

	public Arista getAnterior() {
		return anterior;
	}

	public void setAnterior(Arista anterior) {
		this.anterior = anterior;
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public boolean isTransbordo() {
		return transbordo;
	}

	public double getDistancia() {
		return distancia;
	}
	
	public int getTiempo () {
		return this.tiempo;
	}
	
}
