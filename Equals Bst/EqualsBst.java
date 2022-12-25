import java.util.Scanner;
import java.util.ArrayList;
class EqualsBst {
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

        public ArrayList<Integer> postOrder() {
        
            ArrayList<Integer> out = new ArrayList<Integer>();
            postOrder(this.root, out);
            return out;
    
            
        }
    
        private void postOrder(Node current, ArrayList<Integer> array){
            if(current.left != null){
                postOrder(current.left, array);
            }
    
            if(current.right != null){
                postOrder(current.right, array);
            }
    
            array.add(current.value);
    
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
        BST tree2 = new BST();
        Scanner scanner = new Scanner(System.in);
        String[] valuesStr1 = scanner.nextLine().split(" ");
        int[] valuesInt1 = makeIntArray(valuesStr1);

        String[] valuesStr2 = scanner.nextLine().split(" ");
        int[] valuesInt2 = makeIntArray(valuesStr2);

        addElementsInBst(tree, valuesInt1);
        addElementsInBst(tree2, valuesInt2);

        if(tree.postOrder().equals(tree2.postOrder())){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }

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




