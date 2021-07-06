import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB2 {
	
	private static final String T1 [] = { "01101", "0111", "0101101", "0101"};
	private static final String T3 [] = { "0101101", "010111", "101101", "10111", "01101", "0101", "010101"};
	public static void main(String[] args) throws IOException {
		
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_combine_B2.sql") , 1024 * 1024)) {
			
			// Bahr B2-B2 المديد
			genereB2(chaineBahr, fw , "01101" , "01101" );
		
			// Bahr B2-U1
			genereB2majzue(chaineBahr, fw , "0101101" , "0101101");		
						
			// Bahr B2-U2
			genereB2majzue(chaineBahr, fw , "01101" , "01101");

           		// Bahr B2-U4
			genereB2majzue(chaineBahr, fw , "0101" , "01101");
						
			 // Bahr B2-U5
			genereB2majzue(chaineBahr, fw , "0111" , "0111");
						
			 // Bahr B2-U6
			genereB2majzue(chaineBahr, fw , "0101" , "0111");
			
			}
		Set<String> dChaine = new HashSet<>(chaineBahr);
        	System.out.println("Nbr Ryhtmes Bahr B2 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B2 sans redondance : " + (dChaine.size()));

	}
	private static void genereB2majzue(List<String> chaineBahr, Writer fw , String aroud , String darb) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < T3.length; i1++) {
			for (int i2 = 0; i2 < T1.length; i2++) {
				
					for (int i4 = 0; i4 < T3.length; i4++) {
						for (int i5 = 0; i5 < T1.length; i5++) {
							
						
								chaine = darb.concat(T1[i5].concat(T3[i4].concat(aroud.concat(T1[i2].concat(T3[i1])))));
								taille =  T3[i1].length() + T1[i2].length() + T3[i4].length() + T1[i5].length() + darb.length() + aroud.length();
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B2', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;					
						 }
					   }
					}
				}
	}
	private static void genereB2(List<String> chaineBahr, Writer fw , String aroud , String darb) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < T3.length; i1++) {
			for (int i2 = 0; i2 < T1.length; i2++) {
				for (int i3 = 0; i3 < T3.length; i3++) {
					for (int i5 = 0; i5 < T3.length; i5++) {
						for (int i6 = 0; i6 < T1.length; i6++) {
							for (int i7 = 0; i7 < T3.length; i7++) {
						
								chaine = darb.concat(T3[i7].concat(T1[i6].concat(T3[i5].concat(aroud.concat(T3[i3].concat(T1[i2].concat(T3[i1])))))));
								taille =  T3[i1].length() + T1[i2].length() + T3[i3].length() + T3[i5].length() + T1[i6].length()+ T3[i7].length() + darb.length() + aroud.length();
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B2', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;					
						 }
					   }
					}
				}
			}
		}
	}

}
