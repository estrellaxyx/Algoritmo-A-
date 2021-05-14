
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.*;

public class Imagen extends JPanel{

	private static final long serialVersionUID = 1L;
	private ArrayList<Point> puntosRecorrido;
	private ArrayList<Estacion> estaciones;
	private ArrayList<Arista> aristas;
	private final static int RADIUS = 10;

	public Imagen(){
		puntosRecorrido = new ArrayList<Point>();
		estaciones = new ArrayList<Estacion>();
		aristas=new ArrayList<Arista>();
		setBackground(Color.yellow);
		
		/*
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				System.out.println("x: "+x+"    y: "+y);
				puntosRecorrido.add(new Point(x, y));
				repaint();
			}
		});*/
	}

	public void paint(Graphics g) {
		super.paint(g);
		Image imagen = new ImageIcon("MetroAtenas.png").getImage();
		//Pintamos desde 0 ,0  hasta la maxima logitud y anchura del panel
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(7));
		g2.setColor(Color.BLACK);
		
		// Pintar las aristas
		ArrayList<Point> listaPuntos;
		Point p1, p2;
		for (Arista arista : aristas) {
			listaPuntos = arista.getPuntosRecta();
			for (int i = 1; i < listaPuntos.size(); i++) {
				p1 = listaPuntos.get(i-1);
				p2 = listaPuntos.get(i);
				g2.draw(new Line2D.Double(p1.x, p1.y, p2.x, p2.y));
			}
		}
		// Pintar las estaciones
		for (Estacion i : estaciones){
			if (i==null)
				continue;
			g.setColor(Color.BLACK);

			g.fillOval(i.getxPos()-(RADIUS/2), i.getyPos()-(RADIUS/2), RADIUS, RADIUS);

		}
	}

	public void dibujarCamino(){
		estaciones = AEstrellaOK.getCaminoEstaciones();
		//aristas=AEstrellaOK.getCaminoAristas();
		/*for(int i=0;i<estaciones.size()-1;i++) {
			aristas.add(AEstrellaOK.obtenerArista(estaciones.get(i),estaciones.get(i+1)));
		}*/
		repaint();
	}
}