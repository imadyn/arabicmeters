import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB2Bis {
	private static final String T1 [] = { "01101", "0111", "0101101", "0101"};
	private static final String T3 [] = { "0101101", "010111", "101101", "10111", "01101", "0101", "010101"};

	public static void main(String[] args) throws IOException {
	
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_bis_B2.sql") , 1024 * 1024)) {
			
			// Bahr B2-B2 المديد
			genereB2keys(T1, T3, chaineBahr, fw);
		
			// Bahr B2-U1	
			genereB2majzuekeys(T1, T3, chaineBahr, fw);
		
		} 
		Set<String> dChaine = new HashSet<>(chaineBahr);
        	System.out.println("Nbr Ryhtmes Bahr B2 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B2 sans redondance : " + (dChaine.size()));

	}

	private static void genereB2majzuekeys(String[] t1, String[] t3, List<String> chaineBahr, Writer fw)
			throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t3.length; i1++) {
			for (int i2 = 0; i2 < t1.length; i2++) {
				for (int i3 = 0; i3 < t3.length; i3++) {
					
						
						
								chaine = t3[i3].concat(t1[i2].concat(t3[i1]));
								taille =  t3[i1].length() + t1[i2].length() + t3[i3].length();
						
									fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B2', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
						
					}
				}
			}
	}

	private static void genereB2keys(String[] t1, String[] t3, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t3.length; i1++) {
			for (int i2 = 0; i2 < t1.length; i2++) {
				for (int i3 = 0; i3 < t3.length; i3++) {
					for (int i4 = 0; i4 < t1.length; i4++) {
						
						
								chaine = t1[i4].concat(t3[i3].concat(t1[i2].concat(t3[i1])));
								taille =  t3[i1].length() + t1[i2].length() + t3[i3].length() + t1[i4].length();
						
									fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B2', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
						
					}
				}
			}
		}
	}

}
