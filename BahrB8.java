import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB8 {
	
	private static final String T3 [] = { "0101101", "010111", "101101", "10111", "01101", "0101", "010101"};

	public static void main(String[] args) throws IOException {
	
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_combine_B8.sql") , 1024 * 1024)) {
			
			// Bahr B8-B8  الرمل
		// مع التصريع	DARB = AROUD	
			genereB8tassrie(T3, chaineBahr, fw);
		
			// Bahr B8-W2
			genereB8(T3, chaineBahr, fw , "01101" , "0101101");
						
			// Bahr B8-U1
			// مع التصريع	DARB = AROUD
			genereB8majzueTassrie(T3, chaineBahr, fw);
			
			// Bahr B8-U3						
			genereB8majzue(T3, chaineBahr, fw , "0101101" , "01101");
							
		} 
		
		Set<String> dChaine = new HashSet<>(chaineBahr);
        System.out.println("Nbr Ryhtmes Bahr B8 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B8 sans redondance : " + (dChaine.size()));
		
		
	}

	private static void genereB8majzue(String[] t3, List<String> chaineBahr, Writer fw , String aroud , String darb) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t3.length; i1++) {
			for (int i2 = 0; i2 < t3.length; i2++) {
				
								chaine = darb.concat(t3[i2].concat(aroud.concat(t3[i1])));
								taille =  t3[i1].length() + t3[i2].length() + darb.length() + aroud.length() ;
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B8', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
								
			}
		}
	}

	private static void genereB8majzueTassrie(String[] t3, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t3.length; i1++) {
			for (int i2 = 0; i2 < t3.length; i2++) {
				
					for (int i3 = 0; i3 < t3.length; i3++) {	
						
								chaine = t3[i3].concat(t3[i2].concat(t3[i3].concat(t3[i1])));
								taille =  t3[i1].length() + t3[i2].length() +  t3[i3].length() + t3[i3].length() ;
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B8', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
													
			    }			
					
			}
		}
	}

	private static void genereB8(String[] t3, List<String> chaineBahr, Writer fw , String aroud , String darb) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t3.length; i1++) {
			for (int i2 = 0; i2 < t3.length; i2++) {
				for (int i4 = 0; i4 < t3.length; i4++) {
					for (int i5 = 0; i5 < t3.length; i5++) {
						
								chaine = darb.concat(t3[i5].concat(t3[i4].concat(aroud.concat(t3[i2].concat(t3[i1])))));
								taille =  t3[i1].length() + t3[i2].length() + t3[i4].length() + t3[i5].length() + darb.length() + aroud.length();
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B8', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
								
					}
				}
			}
		}
	}

	private static void genereB8tassrie(String[] t3, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t3.length; i1++) {
			for (int i2 = 0; i2 < t3.length; i2++) {
				for (int i4 = 0; i4 < t3.length; i4++) {
					for (int i5 = 0; i5 < t3.length; i5++) {
						for (int i6 = 0; i6 < t3.length; i6++) {	
						
								chaine = t3[i6].concat(t3[i5].concat(t3[i4].concat(t3[i6].concat(t3[i2].concat(t3[i1])))));
								taille =  t3[i1].length() + t3[i2].length() + t3[i4].length() + t3[i5].length() + t3[i6].length() + t3[i6].length();
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B8', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
											
						}	
					}
				}
			}
		}
	}

}
