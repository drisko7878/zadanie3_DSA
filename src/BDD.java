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

        int height = -1;

        BDD bdd = new BDD();
        // bdd.root = new Node(input);

        bdd.root = createNode(root = new Node(input), input, bdd, height);
        bdd.pocetUzlov++;


        return bdd;

    }


    private Node createNode(Node node, String input, BDD bdd, int height) {

        height++;
        if(bdd.pocetPremennych < height){
            bdd.pocetPremennych = height;
        }


        if(node == null){
            bdd.pocetUzlov++;
            return new Node(input);

        }

        if(node.left == null && input.length() != 1) {
            node.left = createNode(node.left, rozdelitStringLava(input), bdd, height);
            node.right = createNode(node.right, rozdelitStringPrava(input), bdd,height);
            //pocetUzlov++;

        } if(node.right != null && input.length() != 1){
            //System.out.println("splenene");
            node.left = createNode(node.left, rozdelitStringLava(input), bdd, height);
            node.right = createNode(node.right, rozdelitStringPrava(input), bdd, height);
            //pocetUzlov++;
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

        return aktString.substring(length / 2, length );

    }


    /**
     * vrati lavu cast stringu
     * @param aktString
     * @return
     */
    private String rozdelitStringLava(String aktString) {
        int length = aktString.length();

        return aktString.substring(0, length / 2);

    }


    public String BDD_use(BDD bdd, String vstup){

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


        if(aktNode == null){
            return "-1";
        }

        return aktNode.key;//aktNode.key.charAt(0)
    }





}