import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BahrB3 {
	
	private static String T1[] = { "01101", "0111", "0101101", "0101" };
	private static String T5[] = { "0110101", "011011", "011101", "01111", "010110101", "010101", "01011" };

	public static void main(String[] args) throws IOException {

		List<String> chaineBahr = new ArrayList<>();
		try (Writer fw = new BufferedWriter(new FileWriter("bahr_combine_B3.sql"), 1024 * 1024)) {

			// Bahr B3-B3 البسيط

			genereB3(T1, T5, chaineBahr, fw , "01101" , "01101");

			// Bahr B3-W1

			genereB3(T1, T5, chaineBahr, fw , "0111" , "0111");

			// Bahr B3-W2

			genereB3(T1, T5, chaineBahr, fw , "0111" , "0101");

			// Bahr B3-U1

			genereB3majzue(T1, T5, chaineBahr, fw , "0110101" , "0110101");

			// Bahr B3-U2

			genereB3majzue(T1, T5, chaineBahr, fw , "0110101" , "010101");

			// Bahr B3-U3

			genereB3majzue(T1, T5, chaineBahr, fw , "0110101" , "01011");

			// Bahr B3-U5

			genereB3majzue(T1, T5, chaineBahr, fw , "010101" , "010101");

			// Bahr B3-U6 مخلع

			genereB3majzue(T1, T5, chaineBahr, fw , "01011" , "01011");


		} 
		Set<String> dChaine = new HashSet<>(chaineBahr);
		System.out.println("Nbr Ryhtmes Bahr B3 avec redondance : " + (chaineBahr.size()));
		System.out.println("Nbr Ryhtmes Bahr B3 sans redondance : " + (dChaine.size()));

	}
	
	private static void genereB3majzue(String[] t1, String[] t5, List<String> chaineBahr, Writer fw , String aroud , String darb)
			throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t5.length; i1++) {
			for (int i2 = 0; i2 < t1.length; i2++) {

				for (int i4 = 0; i4 < t5.length; i4++) {
					for (int i5 = 0; i5 < t1.length; i5++) {

						chaine = darb.concat(t1[i5].concat(t5[i4].concat(aroud.concat(t1[i2].concat(t5[i1])))));
						taille = t5[i1].length() + t1[i2].length() + t5[i4].length() + t1[i5].length() + darb.length() + aroud.length();

						fw.write(" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
						fw.write("('B3', ' " + taille + "' , '" + chaine + " '); \n");

						chaineBahr.add(chaine);
					}
				}
			}
		}
	}
	
	private static void genereB3(String[] t1, String[] t5, List<String> chaineBahr, Writer fw , String aroud , String darb) throws IOException {
		int taille;
		String chaine;
		for (int i1 = 0; i1 < t5.length; i1++) {
			for (int i2 = 0; i2 < t1.length; i2++) {
				for (int i3 = 0; i3 < t5.length; i3++) {
					for (int i5 = 0; i5 < t5.length; i5++) {
						for (int i6 = 0; i6 < t1.length; i6++) {
							for (int i7 = 0; i7 < t5.length; i7++) {

								chaine = darb.concat(t5[i7].concat(t1[i6]
										.concat(t5[i5].concat(aroud.concat(t5[i3].concat(t1[i2].concat(t5[i1])))))));
								taille = t5[i1].length() + t1[i2].length() + t5[i3].length() + t5[i5].length()
										+ t1[i6].length() + t5[i7].length() + darb.length() + aroud.length();

								fw.write(
										" INSERT INTO metarab.bahr_combine (`code_bahr`, `taille`, `valeur_rhythm`) VALUES  ");
								fw.write("('B3', ' " + taille + "' , '" + chaine + " '); \n");

								chaineBahr.add(chaine);
							}
						}
					}
				}
			}
		}
	}

}
