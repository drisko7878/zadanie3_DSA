public class BDD {

    int pocetPremennych;//kolko riadkov
    int pocetUzlov;//pocet uzlov
    Node root;


    public BDD(){
        pocetPremennych = 0;
        pocetUzlov = 0;
        root = null;
    }



    public BDD BDD_create(String input){//argument moze byt string
        int cisloSize = input.length();

        root = new Node(input);

        createNode(root, input);
        pocetUzlov++;


        return null;

    }


    private Node createNode(Node node, String input) {

        if(node == null){
            return new Node(input);

        }

        if(node.left == null && input.length() != 1) {
            node.left = createNode(node.left, rozdelitStringLava(input));
            node.right = createNode(node.right, rozdelitStringPrava(input));
            pocetUzlov++;

        } if(node.right != null && input.length() != 1){
            node.left = createNode(node.left, rozdelitStringLava(input));
            node.right = createNode(node.right, rozdelitStringPrava(input));
            pocetUzlov++;
        }





        return node;


    }


    /**
     * Vrati pravu cast Stringu
     * @param aktString
     * @return
     */
    private String rozdelitStringPrava(String aktString) {
        int length = aktString.length();

        pocetPremennych++;
//        StringBuilder pravaCast = new StringBuilder();
//
//
//        for(int i = length / 2; i < length; i++){
//            pravaCast.append(aktString.charAt(i));
//
//        }

        return aktString.substring(length / 2, length );



    }


    /**
     * vrati lavu cast stringu
     * @param aktString
     * @return
     */
    private String rozdelitStringLava(String aktString) {
        int length = aktString.length();
        //String lavaCast;
        //StringBuilder lavaCast = new StringBuilder();

//        for(int i = 0; i < length / 2; i++){
//            lavaCast.append(aktString.charAt(i));
//
//        }

        return aktString.substring(0, length / 2);





    }


    public char BDD_use(BDD bdd, String vstup){

       int vstupLength = vstup.length();
       int i = 0;
       char aktChar;//reprezentuje akt char vstupu
       Node aktNode = bdd.root;

       while(i < vstupLength){
            aktChar = vstup.charAt(i);//akt char vo vstupe
            if(aktChar == '1'){
               aktNode =  aktNode.right;

            }else if(aktChar == '0'){
                aktNode = aktNode.left;
            }
           i++;
       }


        return aktNode.key.charAt(0);
    }





}
