import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB2Bis {

	public static void main(String[] args) {
		
		String t1 [] = { "01101", "0111", "0101101", "0101"};
	//	String t2 [] = { "01011", "1011", "011", "01", "0111" };
		String t3 [] = { "0101101", "010111", "101101", "10111", "01101", "0101", "010101"};
	//	String t4 [] = { "0101011", "011011", "101011", "01011", "010101"};
		
	//	String t5 [] = { "0110101", "011011", "011101", "01111", "010110101", "010101", "01011"};
	//	String t6 [] = { "1010101", "101011", "101101", "10111", "0111", "010101"};
	//	String t7 [] = { "0111011", "011011", "0101011", "101011", "01011"};
	//	String t8 [] = { "0110111", "011011", "0110101", "011101", "010110111", "010111", "0111"};
		
	
		int taille = 0;
		String chaine = null;
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_bis_B2.sql") , 1024 * 1024)) {
			
			// Bahr B2-B2 المديد
		
			for (int i1 = 0; i1 < t3.length; i1++) {
				for (int i2 = 0; i2 < t1.length; i2++) {
					for (int i3 = 0; i3 < t3.length; i3++) {
						for (int i4 = 0; i4 < t1.length; i4++) {
							
							
									chaine = t1[i4].concat(t3[i3].concat(t1[i2].concat(t3[i1])));
									taille =  t3[i1].length() + t1[i2].length() + t3[i3].length() + t1[i4].length();
							
										fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
										fw.write("('B2', ' " + taille + "' , '" +  chaine + " '); \n");
										
									chaineBahr.add(chaine) ;
									taille = 0;
							
						}
					}
				}
			}
		
			// Bahr B2-U1
			
			for (int i1 = 0; i1 < t3.length; i1++) {
				for (int i2 = 0; i2 < t1.length; i2++) {
					for (int i3 = 0; i3 < t3.length; i3++) {
						
							
							
									chaine = t3[i3].concat(t1[i2].concat(t3[i1]));
									taille =  t3[i1].length() + t1[i2].length() + t3[i3].length();
							
										fw.write(" INSERT INTO metarab.bahr_combine_bis (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
										fw.write("('B2', ' " + taille + "' , '" +  chaine + " '); \n");
										
									chaineBahr.add(chaine) ;
									taille = 0;
							
						}
					}
				}
		
						
			
			/*
		
		
		
		
		
		
		
		
		*/
		
		
		
		
		
		
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
Set<String> dChaine = new HashSet<>(chaineBahr);
        System.out.println("Nbr Ryhtmes Bahr B2 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B2 sans redondance : " + (dChaine.size()));

	}

}
