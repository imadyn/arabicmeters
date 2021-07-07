import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB7Bis {
	
	private static final String T5 [] = { "0110101", "011011", "011101", "01111", "010110101", "010101", "01011"};

	public static void main(String[] args) throws IOException {
	
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_bis_B7.sql") , 1024 * 1024)) {
			
			// Bahr B7-B7  الرجز
			genereB7keys(T5, chaineBahr, fw);
	
			// Bahr B7-U1		
			genereB7majzueKeys(T5, chaineBahr, fw);
		
		} 
		Set<String> dChaine = new HashSet<>(chaineBahr);
        System.out.println("Nbr Ryhtmes Bahr B7 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B7 sans redondance : " + (dChaine.size()));
		
		
	}

	private static void genereB7majzueKeys(String[] t5, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t5.length; i1++) {
			for (int i2 = 0; i2 < t5.length; i2++) {
				
				chaine = t5[i2].concat(t5[i1]);
				taille =  t5[i1].length() + t5[i2].length() ;
		
					fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
					fw.write("('B7', ' " + taille + "' , '" +  chaine + " '); \n");
					
				chaineBahr.add(chaine) ;
				
			}
		}
	}

	private static void genereB7keys(String[] t5, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t5.length; i1++) {
			for (int i2 = 0; i2 < t5.length; i2++) {
				for (int i3 = 0; i3 < t5.length; i3++) {
					
						
								chaine = t5[i3].concat(t5[i2].concat(t5[i1]));
								taille =  t5[i1].length() + t5[i2].length() + t5[i3].length() ;
						
									fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B7', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
								
				}
			}
		}
	}

}
