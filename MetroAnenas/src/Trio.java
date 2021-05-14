
public class Trio {
	private static Estacion estacion;
	private static double valor;
	private static Estacion anterior;



	public Trio(Estacion estacion, double valor, Estacion anterior) {
		this.estacion=estacion;
		this.valor=valor;
		this.anterior=anterior;
	}
	
	public Estacion getEstacion() {
		return estacion;
	}
	
	public double getValor() {
		return valor;
	}
	
	public Estacion getAnterior() {
		return anterior;
	}
	
	public static void setEstacion(Estacion a) {
		estacion = a;
	}
	
	public static void setValor(double a) {
		valor = a;
	}
	
	public static void setAnterior(Estacion a) {
		anterior = a;
	}
	
}
