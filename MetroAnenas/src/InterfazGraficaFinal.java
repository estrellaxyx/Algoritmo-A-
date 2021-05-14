

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.DateFormatter;

import org.jdesktop.swingx.JXDatePicker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map.Entry;

public class InterfazGraficaFinal {
	private JFrame ventana;
	private Imagen mapa = new Imagen();
	

	public InterfazGraficaFinal() {
		inicializarInterfaz();
	}

	public static void main(String[] args) {
		InterfazGraficaFinal interfaz = new InterfazGraficaFinal();
		
		interfaz.ventana.setVisible(true);

		// Al cerrar la pantalla se acaba el programa
		interfaz.ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void inicializarInterfaz() {

		ventana = new JFrame();

		// Tamaño 1000,700 en 100,20
		ventana.setBounds(100, 20, 1200, 720);
		ventana.setTitle("Metro de Atenas");

		// Para poder colocar las cosas donde me dé la gana desactivo el layout
		ventana.setLayout(null);

		ventana.setVisible(true);

		// Al cerrar la pantalla se acaba el programa
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Para poner el icono en la ventana
		Image icono = new ImageIcon("iconoMetro.png").getImage();
		ventana.setIconImage(icono);

		Image imagen = new ImageIcon("MetroAtenas.png").getImage();
		ventana.add(mapa);
		mapa.setBounds(30, 50, imagen.getWidth(mapa), imagen.getHeight(mapa));
		
		
		Botones panelBot = new Botones(mapa);
		ventana.add(panelBot);
		panelBot.setBounds(750, 0, 440, 720);
		panelBot.setVisible(true);
		
	}
	
}

class Botones extends JPanel implements ActionListener {
	private Imagen mapa;
	private HashMap<String, Estacion> estUnicas = new HashMap<String, Estacion>();
	
	private JLabel orig = new JLabel("Origen:");
	private JLabel dest = new JLabel("Destino:");
	private JLabel pref = new JLabel("Escoger para minimizar:");
	
	private JButton calc = new JButton("Calcular recorrido");
	
	// Tiene constructor a partir de array
	private JComboBox desplOrig;
	private JComboBox desplDest;
	
	private ButtonGroup prefBut = new ButtonGroup();
	private JRadioButton transb = new JRadioButton("Transbordos", true);
	private JRadioButton dist = new JRadioButton("Distancia", false);
	private JRadioButton tiempo = new JRadioButton("Tiempo", false);
	
	// 1:transbordos, 2:distancia, 3:tiempo
	private int minimizar = 1;
	
	// 1:Dom, 7:Sab
	private int diaSem;
	
	// Hora del dia HHMM
	private double hora;
	
	public Botones(Imagen im) {
		this.mapa=im;
		setLayout(null);
		inicializarDespl();
		add(orig);
		add(dest);
		add(calc);
		add(desplDest);
		add(desplOrig);
		
		desplDest.addActionListener(this);
		desplOrig.addActionListener(this);
		calc.addActionListener(this);
		
		add(pref);
		
		//Los meto en el grupo (que solo se seleccione 1)
		prefBut.add(transb);
		prefBut.add(dist);
		prefBut.add(tiempo);
		
		add(transb);
		add(dist);
		add(tiempo);
		
		transb.addActionListener(this);
		dist.addActionListener(this);
		tiempo.addActionListener(this);
		
		addCalendario();
		
	}
	
	private void inicializarDespl() {
		String nombre;
		for (Entry<String, Estacion> entry : Atenas.paradas.entrySet()) {
			nombre = entry.getKey();
			if(nombre.equals("Attiki L1") || nombre.equals("Attiki L2")) {
				//Como solo voy a usar las keys, pongo null al valor
				estUnicas.put("Attiki", null);
			}else if(nombre.equals("Omonia L1") || nombre.equals("Omonia L2")) {
				estUnicas.put("Omonia", null);
			}else if(nombre.equals("Monastiraki L1") || nombre.equals("Monastiraki L3")) {
				estUnicas.put("Monastiraki", null);
			}else if(nombre.equals("Syntagma L2") || nombre.equals("Syntagma L3")) {
				estUnicas.put("Syntagma", null);
			}else {
				estUnicas.put(nombre, null);
			}
		}
		//Ordenamos por orden alfabetico
		Object[] alfabetico =estUnicas.keySet().toArray();
		Arrays.sort(alfabetico);
		desplOrig = new JComboBox(alfabetico);
		desplDest = new JComboBox(alfabetico);
	}
	
	
	private void addCalendario() {
		JLabel labelDia = new JLabel("Fecha:");
		labelDia.setFont(new Font("Arial", Font.PLAIN, 15));
		labelDia.setBounds(50, 225, 200, 25);
		add(labelDia);
		
		//Pongo el calendario y le doy el formato
		JXDatePicker picker = new JXDatePicker();
		picker.setBounds(50, 250, 150, 30);
		Calendar cal = Calendar.getInstance();
	    picker.setDate(cal.getTime());
	    picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
	    
		diaSem = cal.get(Calendar.DAY_OF_WEEK);
		
		ActionListener listenerCal = new ActionListener ()
	       {
			@Override
			public void actionPerformed(ActionEvent e) {
				cal.setTime(picker.getDate());
				diaSem = cal.get(Calendar.DAY_OF_WEEK);
			}
	       };
	    picker.addActionListener(listenerCal);
	    
	    add(picker);
	
	    // La parte de la hora
		JLabel labelHora = new JLabel("Hora:");
		labelHora.setFont(new Font("Arial", Font.PLAIN, 15));
	    labelHora.setBounds(250, 225, 150, 25);
	    add(labelHora);
	    
	    Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 0);
        
        // Pongo las flechas para modificar la hora
        SpinnerDateModel model = new SpinnerDateModel();
        model.setValue(calendar.getTime());
        
        JSpinner spinner = new JSpinner(model);
        spinner.setBounds(250, 250, 150, 30);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinner, "HH:mm");
        DateFormatter formatter = (DateFormatter)editor.getTextField().getFormatter();
        formatter.setAllowsInvalid(false);
        formatter.setOverwriteMode(true);

        spinner.setEditor(editor);

        Calendar cal1 = Calendar.getInstance();
        
        ChangeListener cl = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Date tiempo = (Date) spinner.getValue();
				cal1.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), tiempo.getHours(), tiempo.getMinutes());
				hora = (cal1.get(Calendar.HOUR_OF_DAY)*100) + cal1.get(Calendar.MINUTE);
			}
        
        };
        spinner.addChangeListener(cl);
	       
        add(spinner);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		setLayout(null);
		orig.setFont(new Font("Arial", Font.BOLD, 15));
		orig.setBounds(50, 50, 100, 50);
		dest.setFont(new Font("Arial", Font.BOLD, 15));
		dest.setBounds(250, 50, 100, 50);
		
		desplOrig.setBounds(50, 100, 150, 30);
		desplDest.setBounds(250, 100, 150, 30);
		
		calc.setBounds(130, 600, 200, 30);
		
		pref.setFont(new Font("Arial", Font.BOLD, 15));
		pref.setBounds(50, 400, 200, 30);
		
		transb.setBounds(50, 430, 200, 30);
		dist.setBounds(50, 460, 200, 30);
		tiempo.setBounds(50, 490, 200, 30);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object pulsado = arg0.getSource();
		if(pulsado.equals(transb)) {
			minimizar = 1;
			System.out.println(minimizar);
		}else if (pulsado.equals(dist)) {
			minimizar = 2;
			System.out.println(minimizar);
		}else if (pulsado.equals(tiempo)) {
			minimizar = 3;
			System.out.println(minimizar);
		}else if(pulsado.equals(calc)) {
			String res = "";
            if (desplOrig.getSelectedItem().toString().equals(desplDest.getSelectedItem().toString())) {
                res = "No se puede elegir la misma parada como origen y destino";
                JOptionPane.showMessageDialog(this, res, "Error", JOptionPane.PLAIN_MESSAGE, new ImageIcon("iconoMetro.png"));
            }else {
                if(((diaSem >= 0 && diaSem <= 5) && (hora >= 30 && hora < 500)) ||
                        ((diaSem == 6 || diaSem == 7) && (hora >= 200 && hora < 500))) {
                    res = "No hay servicio de metro en el dia indicado y a la hora elegida";
                    JOptionPane.showMessageDialog(this, res, "Error", JOptionPane.PLAIN_MESSAGE, new ImageIcon("iconoMetro.png"));
                }else {
                    AEstrellaOK.AEstrella(desplOrig.getSelectedItem().toString(),desplDest.getSelectedItem().toString(),minimizar,hora,diaSem);
                   
                    //Calcular camimno minimo
                    ArrayList <Estacion> recorrido = new ArrayList <Estacion>();
                    recorrido = AEstrellaOK.getCaminoEstaciones();
                    mapa.dibujarCamino();
                   
                    //Sacamos cosas
                    res = Auxiliar.imprimirBonito(recorrido);
                    mapa.dibujarCamino();
                    JOptionPane.showMessageDialog(this, res, "Recorrido", JOptionPane.PLAIN_MESSAGE, new ImageIcon("iconoMetro.png"));
                }
            }
		}
	}
}