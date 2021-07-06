import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB4Bis {

	private static final String T7 [] = { "0111011", "011011", "0101011", "101011", "01011"};
	
	public static void main(String[] args) throws IOException {
	
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_bis_B4.sql") , 1024 * 1024)) {
			
			// Bahr B4-B4 الوافر			
			genereB4keys(T7, chaineBahr, fw);
			
						
			// Bahr B4-U1
			genereB4majzueKeys(T7, chaineBahr, fw);
			
		} 
		Set<String> dChaine = new HashSet<>(chaineBahr);
        System.out.println("Nbr Ryhtmes Bahr B4 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B4 sans redondance : " + (dChaine.size()));

	}

	private static void genereB4majzueKeys(String[] t7, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t7.length; i1++) {
			for (int i2 = 0; i2 < t7.length; i2++) {
				
				chaine = t7[i2].concat(t7[i1]);
				taille =  t7[i1].length() + t7[i2].length() ;
		
					fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
					fw.write("('B4', ' " + taille + "' , '" +  chaine + " '); \n");
					
				chaineBahr.add(chaine) ;
					
			}
		}
	}

	private static void genereB4keys(String[] t7, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t7.length; i1++) {
			for (int i2 = 0; i2 < t7.length; i2++) {
				for (int i3 = 0; i3 < t7.length; i3++) {
				
								chaine = t7[i3].concat(t7[i2].concat(t7[i1]));
								taille =  t7[i1].length() + t7[i2].length() + t7[i3].length();
						
									fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B4', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
								
				}
			}
		}
	}

}
