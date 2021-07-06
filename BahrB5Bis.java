import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB5Bis {
	private static final String T8 [] = { "0110111", "011011", "0110101", "011101", "010110111", "010111", "0111"};

	public static void main(String[] args) throws IOException {
	
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_bis_B5.sql") , 1024 * 1024)) {
			
			// Bahr B5-B5 الكامل	
			genereB5keys(T8, chaineBahr, fw);
			
			// Bahr B5-U1			
			genereB5majzueKeys(T8, chaineBahr, fw);
			
		} 
		Set<String> dChaine = new HashSet<>(chaineBahr);
        System.out.println("Nbr Ryhtmes Bahr B5 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B5 sans redondance : " + (dChaine.size()));
		
		
	}

	private static void genereB5majzueKeys(String[] t8, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t8.length; i1++) {
			for (int i2 = 0; i2 < t8.length; i2++) {
				
						
						
				chaine = t8[i2].concat(t8[i1]);
				taille =  t8[i1].length() + t8[i2].length()  ;
		
					fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
					fw.write("('B5', ' " + taille + "' , '" +  chaine + " '); \n");
					
				chaineBahr.add(chaine) ;
			}
		}
	}

	private static void genereB5keys(String[] t8, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t8.length; i1++) {
			for (int i2 = 0; i2 < t8.length; i2++) {
				for (int i3 = 0; i3 < t8.length; i3++) {
					
						
						
								chaine = t8[i3].concat(t8[i2].concat(t8[i1]));
								taille =  t8[i1].length() + t8[i2].length() + t8[i3].length() ;
						
									fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B5', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
				}
			}
		}
	}

}
