import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB5 {
	
	private static final String T8 [] = { "0110111", "011011", "0110101", "011101", "010110111", "010111", "0111"};

	public static void main(String[] args) throws IOException {
	
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_combine_B5.sql") , 1024 * 1024)) {
			
			// Bahr B5-B5 الكامل
			genereB5(T8, chaineBahr, fw , "0110111" , "0110111");
			
			// Bahr B5-W1
			genereB5(T8, chaineBahr, fw , "0110111" , "010111");
			
			// Bahr B5-W2
			genereB5(T8, chaineBahr, fw , "0110111" , "0101");
						
				// Bahr B5-W3
			genereB5(T8, chaineBahr, fw , "0111" , "0111");
						
			  // Bahr B5-W4
			genereB5(T8, chaineBahr, fw , "0111" , "0101");
						
						
			// Bahr B5-U1			
			genereB5majzue(T8, chaineBahr, fw , "0110111" , "0110111" );
			
			
			// Bahr B5-U2
			genereB5majzue(T8, chaineBahr, fw , "0110111" , "010111" );
						
			// Bahr B5-U3
			genereB5majzue(T8, chaineBahr, fw , "0110111" , "010110111" );
					
		} 
		Set<String> dChaine = new HashSet<>(chaineBahr);
        System.out.println("Nbr Ryhtmes Bahr B5 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B5 sans redondance : " + (dChaine.size()));
		
		
	}

	private static void genereB5majzue(String[] t8, List<String> chaineBahr, Writer fw , String aroud , String darb) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t8.length; i1++) {
			for (int i2 = 0; i2 < t8.length; i2++) {
				
						
						
								chaine = darb.concat(t8[i2].concat(aroud.concat(t8[i1])));
								taille =  t8[i1].length() + t8[i2].length() + darb.length() + aroud.length();
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B5', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
								
			}
		}
	}

	private static void genereB5(String[] t8, List<String> chaineBahr, Writer fw , String aroud , String darb) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t8.length; i1++) {
			for (int i2 = 0; i2 < t8.length; i2++) {
				for (int i4 = 0; i4 < t8.length; i4++) {
					for (int i5 = 0; i5 < t8.length; i5++) {
						
						
								chaine = darb.concat(t8[i5].concat(t8[i4].concat(aroud.concat(t8[i2].concat(t8[i1])))));
								taille =  t8[i1].length() + t8[i2].length() + t8[i4].length() + t8[i5].length() + darb.length() + aroud.length();
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B5', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
								
					}
				}
			}
		}
	}

}
