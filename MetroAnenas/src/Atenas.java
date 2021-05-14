
import java.util.Map;
import java.awt.Point;
import java.io.ObjectOutputStream.PutField;
import java.util.ArrayList;
import java.util.HashMap;

public class Atenas {
	public static HashMap<String, Estacion> paradas = new HashMap<String, Estacion>(){{
        //Linea 1
        put("Kifisia", new Estacion("Kifisia",1,false,0,0,0,0,530,14));
        put("KAT", new Estacion("KAT",1,false,0,0,0,0,512,32));
        put("Marousi", new Estacion("Marousi",1,false,0,0,0,0,497,48));
        put("Nerantziotissa", new Estacion("Nerantziotissa",1,false,0,0,0,0,459,86));
        put("Erini", new Estacion("Erini",1,false,0,0,0,0,442,102));
        put("Irakleio", new Estacion("Irakleio",1,false,0,0,0,0,426,120));
        put("Nea Ionia", new Estacion("Nea Ionia",1,false,0,0,0,0,410,136));
        put("Pefkakia", new Estacion("Pefkakia",1,false,0,0,0,0,394,151));
        put("Perissos", new Estacion("Perissos",1,false,0,0,0,0,377,169));
        put("Ano Patisia", new Estacion("Ano Patisia",1,false,0,0,0,0,360,183));
        put("Agios Eleftherios", new Estacion("Agios Eleftherios",1,false,0,0,0,0,345,200));
        put("Kato Patisia", new Estacion("Kato Patisia",1,false,0,0,0,0,328,215));
        put("Agios Nikolaos", new Estacion("Agios Nikolaos",1,false,0,0,0,0,312,233));
        put("Attiki L1", new Estacion("Attiki L1",1,true,0,0,0,0,301,259));
        put("Victoria", new Estacion("Victoria",1,false,0,0,0,0,361,293));
        put("Omonia L1", new Estacion("Omonia L1",1,true,0,0,0,0,361,311));
        put("Monastiraki L1", new Estacion("Monastiraki L1",1,true,0,0,0,0,360,348));
        put("Thiseio", new Estacion("Thiseio",1,false,0,0,0,0,361,387));
        put("Petralona", new Estacion("Petralona",1,false,0,0,0,0,360,404));
        put("Tavros", new Estacion("Tavros",1,false,0,0,0,0,360,421));
        put("Kallithea", new Estacion("Kallithea",1,false,0,0,0,0,360,436));
        put("Moschato", new Estacion("Moschato",1,false,0,0,0,0,338,466));
        put("Faliro", new Estacion("Faliro",1,false,0,0,0,0,283,465));
        put("Piraeus", new Estacion("Piraeus",1,false,0,0,0,0,155,466));
        
        //Linea 2
        put("Anthoupoli", new Estacion("Anthoupoli",2,false,0,0,0,0,122,245));
        put("Peristeri", new Estacion("Peristeri",2,false,0,0,0,0,163,245));
        put("Agios Antonios", new Estacion("Agios Antonios",2,false,0,0,0,0,203,243));
        put("Sepolia", new Estacion("Sepolia",2,false,0,0,0,0,244,244));
        put("Attiki L2", new Estacion("Attiki L2",2,true,0,0,0,0,291,260));
        put("Larissa Station", new Estacion("Larissa Station",2,false,0,0,0,0,289,297));
        put("Metaxourghio", new Estacion("Metaxourghia",2,false,0,0,0,0,320,319));
        put("Omonia L2", new Estacion("Omonia L2",2,true,0,0,0,0,369,319));
        put("Panepistimio", new Estacion("Panepistimio",2,false,0,0,0,0,394,341));
        put("Syntagma L2", new Estacion("Syntagma L2",2,true,0,0,0,0,393,366));
        put("Akropoli", new Estacion("Akropoli",2,false,0,0,0,0,393,388));
        put("Syngrou Fix", new Estacion("Syngrou Fix",2,false,0,0,0,0,393,403));
        put("Neos Kosmos", new Estacion("Neos Kosmos",2,false,0,0,0,0,393,420));
        put("Agios Ioannis", new Estacion("Agios Ioannis",2,false,0,0,0,0,393,438));
        put("Dafni", new Estacion("Dafni",2,false,0,0,0,0,393,452));
        put("Agios Dimitrios", new Estacion("Agios Dimitrios",2,false,0,0,0,0,393,470));
        put("Ilioupoli", new Estacion("Ilioupoli",2,false,0,0,0,0,393,485));
        put("Alimos", new Estacion("Alimos",2,false,0,0,0,0,393,501));
        put("Argyroupoli", new Estacion("Argyroupoli",2,false,0,0,0,0,393,518));
        put("Elliniko", new Estacion("Elliniko",2,false,0,0,0,0,393,535));
        
        //Linea 3
        put("Athens International Airport", new Estacion("Athens International Airport",3,false,0,0,0,0,594,309));
        put("Koropi", new Estacion("Koropi",3,false,0,0,0,0,595,216));
        put("Paiania-Kantza", new Estacion("Paiania-Kantza",3,false,0,0,0,0,595,200));
        put("Pallini", new Estacion("Pallini",3,false,0,0,0,0,595,184));
        put("Doukissis Plakentias", new Estacion("Doukissis Plakentias",3,false,0,0,0,0,540,137));
        put("Chalandri", new Estacion("Chalandri",3,false,0,0,0,0,486,184));
        put("Agia Paraskevi", new Estacion("Agia Paraskevi",3,false,0,0,0,0,486,200));
        put("Nomismatokopio", new Estacion("Nomismatokopio",3,false,0,0,0,0,486,217));
        put("Holargos", new Estacion("Holargos",3,false,0,0,0,0,486,233));
        put("Ethniki Amyna", new Estacion("Ethniki Amyna",3,false,0,0,0,0,486,249));
        put("Katehaki", new Estacion("Katehaki",3,false,0,0,0,0,486,265));
        put("Panormou", new Estacion("Panormou",3,false,0,0,0,0,486,281));
        put("Ambelokipi", new Estacion("Ambelokipi",3,false,0,0,0,0,486,298));
        put("Megaro Moussikis", new Estacion("Megaro Moussikis",3,false,0,0,0,0,485,321));
        put("Evangelismos", new Estacion("Evangelismos",3,false,0,0,0,0,486,342));
        put("Syntagma L3", new Estacion("Syntagma L3",3,true,0,0,0,0,386,357));
        put("Monastiraki L3", new Estacion("Monastiraki L3",3,true,0,0,0,0,353,358));
        put("Kerameikos", new Estacion("Kerameikos",3,false,0,0,0,0,244,357));
        put("Eleonas", new Estacion("Eleonas",3,false,0,0,0,0,203,358));
        put("Egaleo", new Estacion("Egaleo",3,false,0,0,0,0,162,356));
        put("Agia Marina", new Estacion("Agia Marina",3,false,0,0,0,0,145,375));
        
}};

//0.96
	public static ArrayList<Arista> aristas = new ArrayList<Arista>() {{

		//Linea 1
		add(new Arista("Kifisia","KAT",new ArrayList<Point>() {{add(new Point(530,14));add(new Point(512,32));}}, false, 1.05,2));
        add(new Arista("KAT","Marousi",new ArrayList<Point>() {{add(new Point(512,32));add(new Point(497,48));}}, false, 1.18,3));
        add(new Arista("Marousi","Nerantziotissa",new ArrayList<Point>() {{add(new Point(497,48));add(new Point(459,86));}}, false, 1.64,3));
        add(new Arista("Nerantziotissa","Erini",new ArrayList<Point>() {{add(new Point(459,86));add(new Point(442,102));}}, false, 1.06,2));
        add(new Arista("Erini","Irakleio",new ArrayList<Point>() {{add(new Point(442,102));add(new Point(426,120));}}, false, 1.54,2));
        add(new Arista("Irakleio","Nea Ionia",new ArrayList<Point>() {{add(new Point(426,120));add(new Point(410,136));}}, false, 1.30,3));
        add(new Arista("Nea Ionia","Pefkakia",new ArrayList<Point>() {{add(new Point(410,136));add(new Point(394,151));}}, false, 0.71,1));
        add(new Arista("Pefkakia","Perissos",new ArrayList<Point>() {{add(new Point(394,151));add(new Point(377,169));}}, false, 0.66,2));
        add(new Arista("Perissos","Ano Patisia",new ArrayList<Point>() {{add(new Point(377,169));add(new Point(360,183));}}, false, 1.34,2));
        add(new Arista("Ano Patisia","Agios Eleftherios",new ArrayList<Point>() {{add(new Point(360,183));add(new Point(345,200));}}, false, 0.55,2));
        add(new Arista("Agios Eleftherios","Kato Patisia",new ArrayList<Point>() {{add(new Point(345,200));add(new Point(328,215));}}, false, 1.01,2));
        add(new Arista("Kato Patisia","Agios Nikolaos",new ArrayList<Point>() {{add(new Point(328,215));add(new Point(312,233));}}, false, 0.53,1));
        add(new Arista("Agios Nikolaos","Attiki L1",new ArrayList<Point>() {{add(new Point(312,233));add(new Point(300,243));add(new Point(301,259));}}, false, 0.96,2));
        add(new Arista("Attiki L1","Victoria",new ArrayList<Point>() {{add(new Point(301,259));add(new Point(302,274));add(new Point(355,277));add(new Point(361,293));}}, false, 1.10,3));
        add(new Arista("Victoria","Omonia L1",new ArrayList<Point>() {{add(new Point(361,293));add(new Point(361,311));}}, false, 1.01,2));
        add(new Arista("Omonia L1","Monastiraki L1",new ArrayList<Point>() {{add(new Point(361,311));add(new Point(360,348));}}, false, 0.96,3));
        add(new Arista("Monastiraki L1","Thiseio",new ArrayList<Point>() {{add(new Point(360,348));add(new Point(361,387));}}, false, 0.47,1));
        add(new Arista("Thiseio","Petralona",new ArrayList<Point>() {{add(new Point(361,387));add(new Point(360,404));}}, false, 1.59,3));
        add(new Arista("Petralona","Tavros",new ArrayList<Point>() {{add(new Point(360,404));add(new Point(360,421));}}, false, 0.88,2));
        add(new Arista("Tavros","Kallithea",new ArrayList<Point>() {{add(new Point(360,421));add(new Point(360,436));}}, false, 0.58,1));
        add(new Arista("Kallithea","Moschato",new ArrayList<Point>() {{add(new Point(360,436));add(new Point(359,462));add(new Point(338,466));}}, false, 1.67,3));
        add(new Arista("Moschato","Faliro",new ArrayList<Point>() {{add(new Point(338,466));add(new Point(283,465));}}, false, 1.80,3));
        add(new Arista("Faliro","Piraeus",new ArrayList<Point>() {{add(new Point(283,465));add(new Point(155,466));}}, false, 2.10,3));
        
		//Linea 2 con transbordos
		add(new Arista("Anthoupoli", "Peristeri", new ArrayList<Point>() {{add(new Point(122, 245)); add(new Point(163, 245));}} , false, 0.59, 1));
		add(new Arista("Peristeri", "Agios Antonios", new ArrayList<Point>() {{add(new Point(163, 245)); add(new Point(203, 243));}} , false, 0.81, 1));
		add(new Arista("Agios Antonios", "Sepolia", new ArrayList<Point>() {{add(new Point(203, 243)); add(new Point(244, 244));}} , false, 1.33, 2));
		add(new Arista("Sepolia", "Attiki L2", new ArrayList<Point>() {{add(new Point(244, 244)); add(new Point(288, 246)); add(new Point(291, 260));}} , false, 0.89, 2));
		add(new Arista("Attiki L1", "Attiki L2", new ArrayList<Point>() {{add(new Point(301,259)); add(new Point(291, 260));}} , true, 0, 0));
		add(new Arista("Attiki L2", "Larissa Station", new ArrayList<Point>() {{add(new Point(291,260)); add(new Point(289,297));}} , false, 0.85, 1));
		add(new Arista("Larissa Station", "Metaxourghio", new ArrayList<Point>() {{add(new Point(289,297)); add(new Point(291, 317)); add(new Point(320,319));}} , false, 0.64, 1));
		add(new Arista("Metaxourghio", "Omonia L2", new ArrayList<Point>() {{add(new Point(320,319)); add(new Point(369,319));}} , false, 0.74, 2));
		add(new Arista("Omonia L1", "Omonia L2", new ArrayList<Point>() {{add(new Point(361,311)); add(new Point(369,319));}} , true, 0, 0));
		add(new Arista("Omonia L2", "Panepistimio", new ArrayList<Point>() {{add(new Point(369,319)); add(new Point(392,322)); add(new Point(394,341));}} , false, 0.57, 1));
		add(new Arista("Panepistimio", "Syntagma L2", new ArrayList<Point>() {{add(new Point(394,341)); add(new Point(393,366));}} , false, 0.65, 4));
		add(new Arista("Syntagma L3", "Syntagma L2", new ArrayList<Point>() {{add(new Point(386,357)); add(new Point(393,366));}} , true, 0, 0));
		add(new Arista("Syntagma L2", "Akropoli", new ArrayList<Point>() {{add(new Point(393,366)); add(new Point(393,388));}} , false, 0.90, 1));
		add(new Arista("Akropoli", "Syngrou Fix", new ArrayList<Point>() {{add(new Point(393,388)); add(new Point(393,403));}} , false, 0.57, 2));
		add(new Arista("Syngrou Fix", "Neos Kosmos", new ArrayList<Point>() {{add(new Point(393,403)); add(new Point(393,420));}} , false, 0.79, 1));
		add(new Arista("Neos Kosmos", "Agios Ioannis", new ArrayList<Point>() {{add(new Point(393,420)); add(new Point(393,438));}} , false, 0.56, 1));
		add(new Arista("Agios Ioannis", "Dafni", new ArrayList<Point>() {{add(new Point(393,438)); add(new Point(393,452));}} , false, 0.88, 2));
		add(new Arista("Dafni", "Agios Dimitrios", new ArrayList<Point>() {{add(new Point(393,452)); add(new Point(393,470));}} , false, 1.01, 2));
		add(new Arista("Agios Dimitrios", "Ilioupoli", new ArrayList<Point>() {{add(new Point(393,470)); add(new Point(393,485));}} , false, 1.26, 1));
		add(new Arista("Ilioupoli", "Alimos", new ArrayList<Point>() {{add(new Point(393,485)); add(new Point(393,501));}} , false, 1.30, 2));
		add(new Arista("Alimos", "Argyroupoli", new ArrayList<Point>() {{add(new Point(393,501)); add(new Point(393,518));}} , false, 1.68, 2));
		add(new Arista("Argyroupoli", "Elliniko", new ArrayList<Point>() {{add(new Point(393,518)); add(new Point(393,535));}} , false, 1.17, 2));
		
		// Linea 3
		add(new Arista("Athens International Airport","Koropi",new ArrayList<Point>() {{add(new Point(594,309));add(new Point(595,216));}}, false, 5.86,6));
        add(new Arista("Koropi","Paiania-Kantza",new ArrayList<Point>() {{add(new Point(595,216));add(new Point(595,200));}}, false, 8.54,6));
        add(new Arista("Paiania-Kantza","Pallini",new ArrayList<Point>() {{add(new Point(595,200));add(new Point(595,184));}}, false, 2.52,2));
        add(new Arista("Pallini","Doukissis Plakentias",new ArrayList<Point>() {{add(new Point(595,184));add(new Point(592,139));add(new Point(540,137));}}, false, 4.29,3));
        add(new Arista("Doukissis Plakentias","Chalandri",new ArrayList<Point>() {{add(new Point(540,137));add(new Point(486,140));add(new Point(486,184));}}, false, 1.12,2));
        add(new Arista("Chalandri","Agia Paraskevi",new ArrayList<Point>() {{add(new Point(486,184));add(new Point(486,200));}}, false, 0.92,2));
        add(new Arista("Agia Paraskevi","Nomismatokopio",new ArrayList<Point>() {{add(new Point(486,200));add(new Point(486,217));}}, false, 1.06,2));
        add(new Arista("Nomismatokopio","Holargos",new ArrayList<Point>() {{add(new Point(486,217));add(new Point(486,233));}}, false, 1.13,1));
        add(new Arista("Holargos","Ethniki Amyna",new ArrayList<Point>() {{add(new Point(486,233));add(new Point(486,249));}}, false, 0.93,2));
        add(new Arista("Ethniki Amyna","Katehaki",new ArrayList<Point>() {{add(new Point(486,249));add(new Point(486,265));}}, false, 1.15,2));
        add(new Arista("Katehaki","Panormou",new ArrayList<Point>() {{add(new Point(486,265));add(new Point(486,281));}}, false, 1.12,2));
        add(new Arista("Panormou","Ambelokipi",new ArrayList<Point>() {{add(new Point(486,281));add(new Point(486,298));}}, false, 0.91,1));
        add(new Arista("Ambelokipi","Megaro Moussikis",new ArrayList<Point>() {{add(new Point(486,298));add(new Point(485,321));}}, false, 0.98,2));
        add(new Arista("Megaro Moussikis","Evangelismos",new ArrayList<Point>() {{add(new Point(485,321));add(new Point(486,342));}}, false, 0.64,1));
        add(new Arista("Evangelismos","Syntagma L3",new ArrayList<Point>() {{add(new Point(486,342));add(new Point(484,355));add(new Point(386,357));}}, false, 1.01,1));
        add(new Arista("Syntagma L3","Monastiraki L3",new ArrayList<Point>() {{add(new Point(386,357));add(new Point(353,358));}}, false, 0.89,5));
        add(new Arista("Monastiraki L3","Monastiraki L1",new ArrayList<Point>() {{add(new Point(353,358));add(new Point(360,348));}}, true, 0,0));
        add(new Arista("Monastiraki L3","Kerameikos",new ArrayList<Point>() {{add(new Point(353,358));add(new Point(244,357));}}, false, 1.30,2));
        add(new Arista("Kerameikos","Eleonas",new ArrayList<Point>() {{add(new Point(244,357));add(new Point(203,358));}}, false, 1.86,2));
        add(new Arista("Eleonas","Egaleo",new ArrayList<Point>() {{add(new Point(203,358));add(new Point(162,356));}}, false, 1.16,1));
        add(new Arista("Egaleo","Agia Marina",new ArrayList<Point>() {{add(new Point(162,356));add(new Point(148,361));add(new Point(145,375));}}, false, 1.41,1));
	}};	
}
