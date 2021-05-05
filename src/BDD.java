public class BDD {

    private int pocetPremennych;//kolko riadkov
    private int velkostBDD;//pocet uzlov
    Node root;


//    public BDD(Node node, int pocetPremennych, int velkostBDD){//
//        this.root = node;
//        this.pocetPremennych = pocetPremennych;
//        this.velkostBDD = velkostBDD;
//
//
//    }





    public BDD BDD_create(String input){//argument moze byt string
        int cisloSize = input.length();

        root = new Node(input);

        createNode(root, input);


        return null;

    }


    private Node createNode(Node node, String input) {

        if(node == null){
            //node.left = createNode(new Node(input), input);
            System.out.println("splnila sa podmienka left");
            return new Node(input);

        }

        //System.out.println("splnila sa podmienka left");

        else{
            node.left = createNode(node.left, rozdelitStringLava(input));
            node.right = createNode(node.right, rozdelitStringPrava(input));

        }
        return node;


    }

    private String rozdelitStringPrava(String aktString) {
        int length = aktString.length();
        StringBuilder pravaCast = new StringBuilder();


        for(int i = length / 2; i < length; i++){
            pravaCast.append(aktString.charAt(i));

        }

        return pravaCast.toString();



    }


    /**
     * vrati lavu cast stringu
     * @param aktString
     * @return
     */
    private String rozdelitStringLava(String aktString) {
        int length = aktString.length();
        //String lavaCast;
        StringBuilder lavaCast = new StringBuilder();

        for(int i = 0; i < length / 2; i++){
            lavaCast.append(aktString.charAt(i));

        }

        return lavaCast.toString();





    }


    public void BDD_use(){

    }

}
