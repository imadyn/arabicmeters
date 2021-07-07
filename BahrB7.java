import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB7 {
	
	private static final String T5 [] = { "0110101", "011011", "011101", "01111", "010110101", "010101", "01011"};

	public static void main(String[] args) throws IOException {
	
		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_combine_B7.sql") , 1024 * 1024)) {
			
			// Bahr B7-B7  الرجز
		// مع التصريع	DARB = AROUD
			genereB7tassrie(T5, chaineBahr, fw);
		
			// Bahr B7-W1		
			genereB7(T5, chaineBahr, fw , "0110101" , "010101");
						
			// Bahr B7-U1
			// مع التصريع	DARB = AROUD
			genereB7majzueTassrie(T5, chaineBahr, fw);
				
			// Bahr B7-M1
						
			genereB7machtor(T5, chaineBahr, fw , "0110101");
			
			// Bahr B7-N1
						
			genereB7manhok(T5, chaineBahr, fw , "0110101");
								
		} 
		Set<String> dChaine = new HashSet<>(chaineBahr);
        System.out.println("Nbr Ryhtmes Bahr B7 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B7 sans redondance : " + (dChaine.size()));
		
		
	}

	private static void genereB7manhok(String[] t5, List<String> chaineBahr, Writer fw , String aroud) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t5.length; i1++) {
			
								chaine = aroud.concat(t5[i1]);
								taille =  t5[i1].length() + aroud.length();
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B7', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
								
					}
	}

	private static void genereB7machtor(String[] t5, List<String> chaineBahr, Writer fw , String aroud) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t5.length; i1++) {
			for (int i2 = 0; i2 < t5.length; i2++) {
				
						
						
								chaine = aroud.concat(t5[i2].concat(t5[i1]));
								taille =  t5[i1].length() + t5[i2].length() + aroud.length();
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B7', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
								
			}
		}
	}

	private static void genereB7majzueTassrie(String[] t5, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t5.length; i1++) {
			for (int i2 = 0; i2 < t5.length; i2++) {
				
					for (int i3 = 0; i3 < t5.length; i3++) {	
						
								chaine = t5[i3].concat(t5[i2].concat(t5[i3].concat(t5[i1])));
								taille =  t5[i1].length() + t5[i2].length() +  t5[i3].length() + t5[i3].length() ;
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B7', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
								
			    }			
					
			}
		}
	}

	private static void genereB7(String[] t5, List<String> chaineBahr, Writer fw , String aroud , String darb) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t5.length; i1++) {
			for (int i2 = 0; i2 < t5.length; i2++) {
				for (int i4 = 0; i4 < t5.length; i4++) {
					for (int i5 = 0; i5 < t5.length; i5++) {
						
						
								chaine = darb.concat(t5[i5].concat(t5[i4].concat(aroud.concat(t5[i2].concat(t5[i1])))));
								taille =  t5[i1].length() + t5[i2].length() + t5[i4].length() + t5[i5].length() + darb.length() + aroud.length();
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B7', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
								
					}
				}
			}
		}
	}

	private static void genereB7tassrie(String[] t5, List<String> chaineBahr, Writer fw) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t5.length; i1++) {
			for (int i2 = 0; i2 < t5.length; i2++) {
				for (int i4 = 0; i4 < t5.length; i4++) {
					for (int i5 = 0; i5 < t5.length; i5++) {
						for (int i6 = 0; i6 < t5.length; i6++) {	
						
								chaine = t5[i6].concat(t5[i5].concat(t5[i4].concat(t5[i6].concat(t5[i2].concat(t5[i1])))));
								taille =  t5[i1].length() + t5[i2].length() + t5[i4].length() + t5[i5].length() + t5[i6].length() + t5[i6].length();
						
									fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
									fw.write("('B7', ' " + taille + "' , '" +  chaine + " '); \n");
									
								chaineBahr.add(chaine) ;
												
						}	
					}
				}
			}
		}
	}

}
