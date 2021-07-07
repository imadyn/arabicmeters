import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB9 {
	
	private static final String T5 [] = { "0110101", "011011", "011101", "01111", "010110101", "010101", "01011"};

	public static void main(String[] args) throws IOException {
		
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_combine_B9.sql") , 1024 * 1024)) {
			
			// Bahr B9-B9  السريع
			genereB9(T5, chaineBahr, fw , "1010101" , "1010101" );
		
			// Bahr B9-W1
			genereB9(T5, chaineBahr, fw , "01101" , "01101" );
			
			// Bahr B9-W3
			genereB9(T5, chaineBahr, fw , "01101" , "0101" );
		
			// Bahr B9-W4
			genereB9(T5, chaineBahr, fw , "0111" , "0111" );
			
			// Bahr B9-W5
			genereB9(T5, chaineBahr, fw , "0111" , "0101" );
			
			// Bahr B9-M2			
			genereB9machtor(T5, chaineBahr, fw , "010101");
			
		} 
		Set<String> dChaine = new HashSet<>(chaineBahr);
        System.out.println("Nbr Ryhtmes Bahr B9 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B9 sans redondance : " + (dChaine.size()));
		
		
	}

	private static void genereB9machtor(String[] t5, List<String> chaineBahr, Writer fw , String aroud) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t5.length; i1++) {
			for (int i2 = 0; i2 < t5.length; i2++) {
				
						
						
								chaine = aroud.concat(t5[i2].concat(t5[i1]));
								taille =  t5[i1].length() + t5[i2].length() + aroud.length();
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B9', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
								
			}
		}
	}

	private static void genereB9(String[] t5, List<String> chaineBahr, Writer fw , String aroud , String darb) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t5.length; i1++) {
			for (int i2 = 0; i2 < t5.length; i2++) {
				for (int i4 = 0; i4 < t5.length; i4++) {
					for (int i5 = 0; i5 < t5.length; i5++) {
						
						
								chaine = darb.concat(t5[i5].concat(t5[i4].concat(aroud.concat(t5[i2].concat(t5[i1])))));
								taille =  t5[i1].length() + t5[i2].length() + t5[i4].length() + t5[i5].length() + darb.length() + aroud.length() ;
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B9', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
					}
				}
			}
		}
	}

}
