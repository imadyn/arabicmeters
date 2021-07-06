import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB1 {
	private static final String T2 [] = { "01011", "1011", "011", "01", "0111" };
	private static final String T4 [] = { "0101011", "011011", "101011", "01011", "010101"};

	public static void main(String[] args) throws IOException {
		
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_combine_B1.sql") , 1024 * 1024)) {
			
			// Bahr B1-B1 الطويل
			genereB1(T2, T4, chaineBahr, fw , "0101011" , "0101011");
		
			// Bahr B1-W1
			genereB1(T2, T4, chaineBahr, fw , "0101011" , "011011");
		
			// Bahr B1-W2
			genereB1(T2, T4, chaineBahr, fw , "011011" , "011011");			
	
           // Bahr B1-W3
			genereB1(T2, T4, chaineBahr, fw , "01011" , "011011");				
						
		} 
		
		  Set<String> dChaine = new HashSet<>(chaineBahr);
		  System.out.println("Nbr Ryhtmes Bahr B1 avec redondance : " + (chaineBahr.size()));
		  System.out.println("Nbr Ryhtmes Bahr B1 sans redondance : " + (dChaine.size()));
		 
	}

	private static void genereB1(String[] t2, String[] t4, List<String> chaineBahr, Writer fw , String aroud , String darb) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t2.length; i1++) {
			for (int i2 = 0; i2 < t4.length; i2++) {
				for (int i3 = 0; i3 < t2.length; i3++) {
					for (int i5 = 0; i5 < t2.length; i5++) {
						for (int i6 = 0; i6 < t4.length; i6++) {
							for (int i7 = 0; i7 < t2.length; i7++) {
						
								chaine = darb.concat(t2[i7].concat(t4[i6].concat(t2[i5].concat(aroud.concat(t2[i3].concat(t4[i2].concat(t2[i1])))))));
								taille =  t2[i1].length() + t4[i2].length() + t2[i3].length() + t2[i5].length() + t4[i6].length() + t2[i7].length() + darb.length() + aroud.length();
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B1', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;						
						 }
					   }
					}
				}
			}
		}
	}

}
