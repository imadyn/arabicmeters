import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB3Bis {

	private static final String t1 [] = { "01101", "0111", "0101101", "0101"};
	private static final String t5 [] = { "0110101", "011011", "011101", "01111", "010110101", "010101", "01011"};
	
	public static void main(String[] args) throws IOException {
	
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_bis_B3.sql") , 1024 * 1024)) {
			
			// Bahr B3-Keys البسيط
			genereB3keys(t1, t5, chaineBahr, fw);
			
			// Bahr B3-U1	
			genereB3majzuekeys(t1, t5, chaineBahr, fw);
		
		} 
		Set<String> dChaine = new HashSet<>(chaineBahr);
        	System.out.println("Nbr Ryhtmes Bahr B3 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B3 sans redondance : " + (dChaine.size()));

	}

	private static void genereB3majzuekeys(String[] t1, String[] t5, List<String> chaineBahr, Writer fw)
			throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t5.length; i1++) {
			for (int i2 = 0; i2 < t1.length; i2++) {
				for (int i3 = 0; i3 < t5.length; i3++) {
					
						
						
								chaine = t5[i3].concat(t1[i2].concat(t5[i1]));
								taille =  t5[i1].length() + t1[i2].length() + t5[i3].length() ;
						
									fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B3', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
				}
			}
		}
	}

	private static void genereB3keys(String[] t1, String[] t5, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t5.length; i1++) {
			for (int i2 = 0; i2 < t1.length; i2++) {
				for (int i3 = 0; i3 < t5.length; i3++) {
					for (int i4 = 0; i4 < t1.length; i4++) {
						
						
								chaine = t1[i4].concat(t5[i3].concat(t1[i2].concat(t5[i1])));
								taille =  t5[i1].length() + t1[i2].length() + t5[i3].length() + t1[i4].length();
						
									fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B3', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
					}
				}
			}
		}
	}

}
