import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB8Bis {
	
	private static final String T3 [] = { "0101101", "010111", "101101", "10111", "01101", "0101", "010101"};

	public static void main(String[] args) throws IOException {
	
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_bis_B8.sql") , 1024 * 1024)) {
			
			// Bahr B8-B8  الرمل
			genereB8keys(T3, chaineBahr, fw);
		
			// Bahr B8-U1
			genereB8majzueKeys(T3, chaineBahr, fw);
			
		}
		
		Set<String> dChaine = new HashSet<>(chaineBahr);
        System.out.println("Nbr Ryhtmes Bahr B8 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B8 sans redondance : " + (dChaine.size()));
		
		
	}

	private static void genereB8majzueKeys(String[] t3, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t3.length; i1++) {
			for (int i2 = 0; i2 < t3.length; i2++) {
				
				chaine = t3[i2].concat(t3[i1]);
				taille =  t3[i1].length() + t3[i2].length() ;
		
					fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
					fw.write("('B8', ' " + taille + "' , '" +  chaine + " '); \n");
					
				chaineBahr.add(chaine) ;
		
			}
		}
	}

	private static void genereB8keys(String[] t3, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t3.length; i1++) {
			for (int i2 = 0; i2 < t3.length; i2++) {
				for (int i3 = 0; i3 < t3.length; i3++) {
					
						
								chaine = t3[i3].concat(t3[i2].concat(t3[i1]));
								taille =  t3[i1].length() + t3[i2].length() + t3[i3].length() ;
						
									fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B8', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
													
						
				}
			}
		}
	}

}
