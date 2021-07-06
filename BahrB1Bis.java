import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB1Bis {

	private static final String T2 [] = { "01011", "1011", "011", "01", "0111" };
	private static final String T4 [] = { "0101011", "011011", "101011", "01011", "010101"};
	
	public static void main(String[] args) throws IOException {
		
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_bis_B1.sql") , 1024 * 1024)) {
			
			// Bahr B1-Keys الطويل
			generateB1keys(chaineBahr, fw);	
		
		}
		Set<String> dChaine = new HashSet<>(chaineBahr);
        	System.out.println("Nbr Ryhtmes Bahr B1 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B1 sans redondance : " + (dChaine.size()));
	}

	private static void generateB1keys(List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < T2.length; i1++) {
			for (int i2 = 0; i2 < T4.length; i2++) {
				for (int i3 = 0; i3 < T2.length; i3++) {
					for (int i4 = 0; i4 < T2.length; i4++) {
						
						
								chaine = T4[i4].concat(T2[i3].concat(T4[i2].concat(T2[i1])));
								taille =  T2[i1].length() + T4[i2].length() + T2[i3].length() + T4[i4].length() ;
						
									fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B1', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
					}
				}
			}
		}
	}

}
