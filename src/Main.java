import java.util.Random;

public class Main {


    public static void main(String[] args) {

        long startTime = System.nanoTime();//start casovac

        BDD bdd = new BDD();

        //mensiVstup(bdd);
        //testovane vstupy:  10100101, //1010010110100101  //1110000101101000101100101010100011101111110101101111010010110011011111101111000101101000110011101011110010110100000001010111111000100100010101100000001101001111000110100011110100000110100011001110000111001110100010101100000001001110100001100010011101100101011100111101001010100101010101000100001011001000001100011010010001011011111111110100110000000000010111000100110111100000101010000110101001101010101110011001111101010000001100100110011101010010101000100101000000100100010001111001010110010010011111000110110000100010010001010011101011100100111000010110010101100010001010101000111110010111001111101011111011111011001111011000010110001111001001001000001010110000101110111111111100110000110100001100110110101111010111000110011100001110110001011111011011101100001111101011000001011100011011011111100001011110000000110101100000100001110101011100001010111001101000100011001101001100010001101001000000010111101001100001101101111110110100101111111111100111000000011100111110001101101010100100000101111001000110110101101011111001001101000011011000000111000000010101001011101100101000111110000111010101010111010010101101111111110110111101111100010010100110001101111110101110110111011110110001011001100011011001111100111110010101110001111001110100011110101101110011011111100111001010011101111011000001101010100100001001110101011011101101010001110010110110111100110111010001111100010010100001101100010011010000111110101001111000101101000011100000100111000110111001101000001111100101010100001101101101110000110000011111111100111000111011001000101101111000100001001101101000011101010011111001011101001111111110111010001100010101000011000011101001110101110100000110100010111101100110010001011000100100101000001111110110101111100110000110000101010000010011111011001010110011101101001110000000001101001010100010100000101000000011000110100000111100000101110001100001100001110100111011000100100100010110101001001001010000100001111010100111101111110100000110110010100111010100101111110011101001000011010100011100001001111001101100111011110100110011100111010010001100011010001100010110010111000010001001111001111111001001111011000111101101111110100101110101001111010010000001001011011111110000000011010011010111001000011001110010011101011100111111101001010001110000100110110101110011100101001111101000100110001011010100101110001000000111110011011001101110010110010001100000101010101010101010000000010110011001011100111000111101111101101010101111010010110010110010011101101101101001101100001000000101100101011110101011001100010011001010011011000001100110011110011000111101010111010101001011100011011111011100110001101100110010101000100000100011001001110110011111001101110000010000001000001000101010110101000000100110110010000100001010010100001010100001011100001100011001010001100100000101011101011100010001111010011001011111000110010000011000110111010011010111001001000001111010010001000110010110101101100001100101011110000111001000011001011100111001001101010010011010111010111111011101001011011110111010110110111101000100101111011111010000011010011101011000010100011001111101010010001100100101100100000100010001000101010110100101000110101111001011111010110111001110110100100011100111000010100101101001011101010100100010111011001010000011011001110001010001100010110111000101111011101110001000011110100000010110001011010100001010110101100111011101100100000000110110010010101010001010011111101000110111011000010101101011100111101100110001110010011001100101001101110010011011000001000110001111010111111001100000110011000011001100100101101110010110011001100001001010101010110010011110110001010100001000111100010001110100101001000000011000000110100101000011101011010000111111100100110111010110000100101110111111000000100001110111100110111101011101100010010011000000111010001110110101101001101011110010101010011100001000101010100001011101011010000110010110001010011111100110000101010001100000110011100000000000010000000110110010001100000001111011010010001010101001100110110000101111110011100111000110011101000011111010100111001011011001110111101000110101111110000011010000000011110111001110011001000101001100000100000100


       // mensiVstup(bdd);//vstup 01100110

        //test1(bdd);//vstup 2^12
        //test2(bdd);//2^13

        test3(bdd);//2^15


        long endTime = System.nanoTime();//koniec
        long timeElapsed = endTime - startTime;

        System.out.println("Execution time in nanoseconds: " + timeElapsed);
        System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);


      //  System.out.println(bdd.root.right.right.right.left.key);

    }



    /**
     *PRVY TEST - MENSI VSTUP
     * @param bdd
     */
    private static void mensiVstup(BDD bdd) {
        System.out.println("Funckia create vracia: ");

        bdd = bdd.BDD_create("01100110");//01100110

        System.out.println("Pocet premennych: " + bdd.pocetPremennych);
        System.out.println("Pocet uzlov: " + bdd.pocetUzlov);

        System.out.println();



//        builder.append(bdd.BDD_use(bdd, "000" ));
//        builder.append(bdd.BDD_use(bdd, "001" ));
//        builder.append(bdd.BDD_use(bdd, "010" ));
//        builder.append(bdd.BDD_use(bdd, "011" ));
//        builder.append(bdd.BDD_use(bdd, "100" ));
//        builder.append(bdd.BDD_use(bdd, "101" ));
//        builder.append(bdd.BDD_use(bdd, "110" ));
//        builder.append(bdd.BDD_use(bdd, "111" ));

        StringBuilder postupnost = new StringBuilder();

        //KOD NA CYKLUS
        StringBuilder stringBuilder = new StringBuilder();
        String docasnyString;
        for(int i = 0; i < Math.pow(2, 3); i++) {
            stringBuilder.delete(0, stringBuilder.length());//reset String
            docasnyString = "";//reset String

            docasnyString = Integer.toBinaryString(i);

            if(docasnyString.length() < 3){
                for(int j = 0; j < (3 - docasnyString.length()); j++){
                    stringBuilder.append(0);
                }
                stringBuilder.append(docasnyString);

            }else{
                stringBuilder.append(docasnyString);
            }
            System.out.println(stringBuilder.toString());
            postupnost.append(bdd.BDD_use(bdd, stringBuilder.toString()));

        }

        System.out.println("VO FUNKCII CREATE: " + "01100110" );
        System.out.println("PO VOLANI USE: " + postupnost);

        System.out.println("Pocet Premennych " + bdd.pocetPremennych);
        System.out.println("Pocet Uzlov " + bdd.pocetUzlov);

        if(postupnost.toString().equals("01100110")){
            System.out.println("**Stringy sa rovnaju**");

        }else{
            System.out.println("Stringy sa nerovnaju");
        }

        //System.out.println(bdd.BDD_use(bdd, "101" ));//13 cisel pri funkcii use()
        //System.out.println(bdd.root.left.right.left.key);


    }


    /**
     * testuje sa vstup 2^12
     * @param bdd
     */
    public static void test1(BDD bdd){

        String vstup;

        //FUNKCIA CREATE SA ZAVOLA 2000 krat, pri kazdom volani je vygenerovane nova hodnota
        for(int k = 0; k < 2000; k++) {

            vstup = generateSequence12();//vygeneruje string s 2^12 cislami
            bdd = bdd.BDD_create(vstup);//vytvori sa rozhodovaci diagram


            StringBuilder postupnost = new StringBuilder();//sklada sa z mnoziny vystupnych charov pri volani funkcii use()

            //KOD NA CYKLUS - POMOCOU FUNKCII USE() VYSKLADA STRING NA POROVNANIE
            StringBuilder stringBuilder = new StringBuilder();
            String docasnyString;

            for (int i = 0; i < Math.pow(2, 12); i++) {//funkcia use sa zavola 2^12 krat

                stringBuilder.delete(0, stringBuilder.length());//reset String
                docasnyString = "";//reset String

                docasnyString = Integer.toBinaryString(i);

                if (docasnyString.length() < 12) {
                    for (int j = 0; j < (12 - docasnyString.length()); j++) {
                        stringBuilder.append(0);
                    }
                    stringBuilder.append(docasnyString);

                } else {
                    stringBuilder.append(docasnyString);
                }
                //System.out.println(stringBuilder.toString());
                postupnost.append(bdd.BDD_use(bdd, stringBuilder.toString()));

            }


            System.out.println(k + " POSTUPNOST");
            System.out.println("Pocet Premennych " + bdd.pocetPremennych);
            System.out.println("Pocet Uzlov " + bdd.pocetUzlov);

            //STRINGY SA ROVNAJU AK CREATE A USE FUNKCIA FUNGUJU SPRAVNE
            if (postupnost.toString().equals(vstup)) {//POROVNA STRINGY
                System.out.println("**Stringy sa rovnaju**");

            } else{
                System.out.println("**Stringy sa nerovnaju**");
            }





        }
    }



















    /**
     * TEST- vstup 2 ^13
     * @param bdd
     */
    private static void test2(BDD bdd) {


        String vstup;

        //FUNKCIA CREATE SA ZAVOLA 2000 krat, pri kazdom volani je vygenerovane nova hodnota
        for(int k = 0; k < 2000; k++) {

            vstup = generateSequence13();//vygeneruje string s 2^13 cislami
            bdd = bdd.BDD_create(vstup);//vytvori sa rozhodovaci diagram


            StringBuilder postupnost = new StringBuilder();//sklada sa z mnoziny vystupnych charov pri volani funkcii use()

            //KOD NA CYKLUS - POMOCOU FUNKCII USE() VYSKLADA STRING NA POROVNANIE
            StringBuilder stringBuilder = new StringBuilder();
            String docasnyString;

            for (int i = 0; i < Math.pow(2, 13); i++) {//funkcia use sa zavola 2^13 krat

                stringBuilder.delete(0, stringBuilder.length());//reset String
                docasnyString = "";//reset String

                docasnyString = Integer.toBinaryString(i);

                if (docasnyString.length() < 13) {
                    for (int j = 0; j < (13 - docasnyString.length()); j++) {
                        stringBuilder.append(0);
                    }
                    stringBuilder.append(docasnyString);

                } else {
                    stringBuilder.append(docasnyString);
                }
                //System.out.println(stringBuilder.toString());
                postupnost.append(bdd.BDD_use(bdd, stringBuilder.toString()));

            }


            System.out.println(k + " POSTUPNOST");
            System.out.println("Pocet Premennych " + bdd.pocetPremennych);
            System.out.println("Pocet Uzlov " + bdd.pocetUzlov);

            //STRINGY SA ROVNAJU AK CREATE A USE FUNKCIA FUNGUJU SPRAVNE
            if (postupnost.toString().equals(vstup)) {//POROVNA STRINGY
                System.out.println("**Stringy sa rovnaju**");

            } else{
                System.out.println("**Stringy sa nerovnaju**");
            }




        }



    }


    /**
     * 2^15
     * @param bdd
     */
    private static void test3(BDD bdd){
        String vstup;

        //FUNKCIA CREATE SA ZAVOLA 2000 krat, pri kazdom volani je vygenerovane nova hodnota
        for(int k = 0; k < 2000; k++) {

            vstup = generateSequence15();//vygeneruje string s 2^13 cislami
            bdd = bdd.BDD_create(vstup);//vytvori sa rozhodovaci diagram


            StringBuilder postupnost = new StringBuilder();//sklada sa z mnoziny vystupnych charov pri volani funkcii use()

            //KOD NA CYKLUS - POMOCOU FUNKCII USE() VYSKLADA STRING NA POROVNANIE
            StringBuilder stringBuilder = new StringBuilder();
            String docasnyString;

            for (int i = 0; i < Math.pow(2, 15); i++) {//funkcia use sa zavola 2^13 krat

                stringBuilder.delete(0, stringBuilder.length());//reset String
                docasnyString = "";//reset String

                docasnyString = Integer.toBinaryString(i);

                if (docasnyString.length() < 15) {
                    for (int j = 0; j < (15 - docasnyString.length()); j++) {
                        stringBuilder.append(0);
                    }
                    stringBuilder.append(docasnyString);

                } else {
                    stringBuilder.append(docasnyString);
                }
                //System.out.println(stringBuilder.toString());
                postupnost.append(bdd.BDD_use(bdd, stringBuilder.toString()));

            }


            System.out.println(k + " POSTUPNOST");
            System.out.println("Pocet Premennych " + bdd.pocetPremennych);
            System.out.println("Pocet Uzlov " + bdd.pocetUzlov);

            //STRINGY SA ROVNAJU AK CREATE A USE FUNKCIA FUNGUJU SPRAVNE
            if (postupnost.toString().equals(vstup)) {//POROVNA STRINGY
                System.out.println("**Stringy sa rovnaju**");

            } else{
                System.out.println("**Stringy sa nerovnaju**");
            }




        }





    }









    /**
     * zavolat 2000 krat pri vytvarani
     * @return
     */
    public static String generateSequence12(){
        System.out.println();
        Random r = new Random();
        int low = 0;
        int high = 2;
        int result;

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < (int) Math.pow(2, 12); i++){
            result = r.nextInt(high-low) + low;

            if(result == 1)
                builder.append("1");

            else if(result == 0)
                builder.append("0");


        }

        return builder.toString();

    }










    /**
     * zavolat 2000 krat pri vytvarani
     * @return
     */
    public static String generateSequence13(){
        System.out.println();
        Random r = new Random();
        int low = 0;
        int high = 2;
        int result;

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < (int) Math.pow(2, 13); i++){
            result = r.nextInt(high-low) + low;

            if(result == 1)
                builder.append("1");

            else if(result == 0)
                builder.append("0");


        }

        return builder.toString();

    }








    public static String generateSequence15(){
        System.out.println();
        Random r = new Random();
        int low = 0;
        int high = 2;
        int result;

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < (int) Math.pow(2, 15); i++){
            result = r.nextInt(high-low) + low;

            if(result == 1)
                builder.append("1");

            else if(result == 0)
                builder.append("0");


        }

        return builder.toString();

    }






}
