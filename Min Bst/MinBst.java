import java.util.Scanner;
import java.util.ArrayList;
class MinBst {
    private static class BST {
        private Node root;
    
        public boolean isEmpty(){
            return root == null;
        }
    
        public void add(int value){
            if(isEmpty()){
                this.root = new Node(value);
            }
    
            else{
                recursiveAdd(this.root, value);
            }
        }   
    
    
        private void recursiveAdd(Node current, int value){
            if(value < current.value){
                if(current.left == null){
                    current.left = new Node(value);
                    current.left.parent = current;
                }
                
                else{
                    recursiveAdd(current.left, value);
                }
               
            }
            else if (value > current.value){
                if(current.right == null){
                    current.right = new Node(value);
                    current.right.parent = current;
                }
    
                else{
                    recursiveAdd(current.right, value);
                }
                
            }
        }
    
        public ArrayList<Integer> min(){
            ArrayList results = new ArrayList<Integer>();
            
            
            return recursiveMin(this.root, results);
            
    
        }
    
        private ArrayList<Integer> recursiveMin(Node current, ArrayList<Integer> array){
            array.add(current.value);
            if(current.left == null){
                return array;
            }
            else{
                return recursiveMin(current.left, array);
            }
    
        }
    }
    private static class Node {
        protected Node left;
        protected Node right;
        protected Node parent;
        protected int value;
    
        public Node(int value){
            this.value = value;
        }
    
        public boolean isLeaf(){
            return left == null && right == null && parent != null;
        }
    
        public boolean isRoot(){
            return parent == null;
        }
    
        public boolean hasOnlyLeftChild(){
            return left != null && right == null;
        }
    
        public boolean hasOnlyRightChild(){
            return right != null & left == null;
        }
    
    
        
    }
    
    public static void main(String[] args) {
        BST tree = new BST();
        Scanner scanner = new Scanner(System.in);
        String[] valuesStr = scanner.nextLine().split(" ");
        int[] valuesInt = makeIntArray(valuesStr);

        addElementsInBst(tree, valuesInt);
        ArrayList<Integer> result = tree.min();

        String out = "";
        for(int i = 0; i < result.size(); i++){
            out += result.get(i) + " ";
        }
        out = out.substring(0, out.length() - 1);
        System.out.println(out);
    }
    

    private static int[] makeIntArray(String[] sequence){
        int[] sequenceInt = new int[sequence.length];

        for(int i = 0; i < sequence.length; i++){
            sequenceInt[i] = Integer.parseInt(sequence[i]);
        }

        return sequenceInt;
    }

    private static void addElementsInBst(BST tree,int[] values){
        for(int value: values){
            tree.add(value);
        }
    }

}




