import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB6Bis {

	private static final String T4 [] = { "0101011", "011011", "101011", "01011", "010101"};
	public static void main(String[] args) throws IOException {
	
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_bis_B6.sql") , 1024 * 1024)) {
			
			// Bahr B6-B6 الهزج
			genereB6keys(T4, chaineBahr, fw);
	
			// Bahr B6-U1					
			genereB6majzueKeys(T4, chaineBahr, fw);
          		
		} 
		Set<String> dChaine = new HashSet<>(chaineBahr);
        System.out.println("Nbr Ryhtmes Bahr B6 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B6 sans redondance : " + (dChaine.size()));
		
		
	}

	private static void genereB6majzueKeys(String[] t4, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t4.length; i1++) {
			for (int i2 = 0; i2 < t4.length; i2++) {
				
						
						
				chaine = t4[i2].concat(t4[i1]);
				taille =  t4[i1].length() + t4[i2].length()  ;
		
					fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
					fw.write("('B6', ' " + taille + "' , '" +  chaine + " '); \n");
					
				chaineBahr.add(chaine) ;
					
			}
		}
	}

	private static void genereB6keys(String[] t4, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t4.length; i1++) {
			for (int i2 = 0; i2 < t4.length; i2++) {
				for (int i3 = 0; i3 < t4.length; i3++) {
					
						
						
								chaine = t4[i3].concat(t4[i2].concat(t4[i1]));
								taille =  t4[i1].length() + t4[i2].length() + t4[i3].length() ;
						
									fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B6', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
								
				}
			}
		}
	}

}
