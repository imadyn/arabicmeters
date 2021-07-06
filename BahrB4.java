import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB4 {
	private static final String T7 [] = { "0111011", "011011", "0101011", "101011", "01011"};

	public static void main(String[] args) throws IOException {
	
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_combine_B4.sql") , 1024 * 1024)) {
			
			// Bahr B4-B4 الوافر
			genereB4(T7, chaineBahr, fw , "0111011" , "0111011");
			
			// Bahr B4-W1
			genereB4(T7, chaineBahr, fw , "01011" , "01011");		
						
			// Bahr B4-U1			
			genereB4majzue(T7, chaineBahr, fw , "0111011" , "0111011");			
			
			// Bahr B4-U2
			genereB4majzue(T7, chaineBahr, fw , "0111011" , "0101011");
					
			// Bahr B4-U3
			genereB4majzue(T7, chaineBahr, fw , "0101011" , "0101011");
						
           // Bahr B4-U4
			genereB4majzue(T7, chaineBahr, fw , "0101011" , "0111011");
						
		} 
		Set<String> dChaine = new HashSet<>(chaineBahr);
        System.out.println("Nbr Ryhtmes Bahr B4 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B4 sans redondance : " + (dChaine.size()));

	}

	private static void genereB4majzue(String[] t7, List<String> chaineBahr, Writer fw , String aroud , String darb) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t7.length; i1++) {
			for (int i2 = 0; i2 < t7.length; i2++) {
				
						
						
								chaine = darb.concat(t7[i2].concat(aroud.concat(t7[i1])));
								taille =  t7[i1].length() + t7[i2].length() + darb.length() + aroud.length();
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B4', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
														
			}
		}
	}

	private static void genereB4(String[] t7, List<String> chaineBahr, Writer fw , String aroud , String darb) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t7.length; i1++) {
			for (int i2 = 0; i2 < t7.length; i2++) {
				for (int i4 = 0; i4 < t7.length; i4++) {
					for (int i5 = 0; i5 < t7.length; i5++) {
						
						
								chaine = darb.concat(t7[i5].concat(t7[i4].concat(aroud.concat(t7[i2].concat(t7[i1])))));
								taille =  t7[i1].length() + t7[i2].length() + t7[i4].length() + t7[i5].length() + darb.length() + aroud.length();
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B4', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
							
					}
				}
			}
		}
	}

}
