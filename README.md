# arabicmeters
* Data of 16 Arabic meters with meters keys generating rhythms.
* Java file BahrB_$x$ and BahrB_$x$Bis when compiled will generate Sql files.  
* You must create a DataBase with name metarab  with two table bahr_combine (`id_increment`,`code_bahr`, `taille`, `valeur_rhythm`) and bahr_combine_bis (`id_increment`,`code_bahr`, `taille`, `valeur_rhythm`) or change the names in the java files.
* Execute the Sql file to generate Data.
* bahr_combine contains : 'id_increment' incremental ID ;  'code_bahr' the meter identifier (B1 ... B16) ; 'valeur_rhythm' Rhythmic value is a String of {0,1} , 'taille' lenght of the rhythmic value.
* Each meter B_$x$ called "Bahr" (بحر) is a set of rhythms formed by the combination of one or two rhythmic patterns, applying to each rhythmic pattern some transformations which are recommended to it.
* The rhythmic patterns used for generating meters  are :
  * t1 = { "01101", "0111", "0101101", "0101"};
  * t2 = { "01011", "1011", "011", "01", "0111" };
  * t3 = { "0101101", "010111", "101101", "10111", "01101", "0101", "010101"};
  * t4 = { "0101011", "011011", "101011", "01011", "010101"};
  * t5 = { "0110101", "011011", "011101", "01111", "010110101", "010101", "01011"};
  * t6 = { "1010101", "010101" , "101011", "101101", "10111", "0111"};
  * t7 = { "0111011", "011011", "0101011", "101011", "01011"};
  * t8 = { "0110111", "011011", "0110101", "011101", "010110111", "010111", "0111"};
