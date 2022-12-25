import java.util.Scanner;

class MaxPilhaIndex {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String values[] = sc.nextLine().split(" ");
        int limit = Integer.parseInt(sc.nextLine());
        Stack stack = new Stack(values.length); 

        pushInStack(values, stack);
        System.out.println(getMax(stack,limit));
    
    }

    private static void pushInStack(String[] values, Stack stack){
        for(int i = 0; i < values.length; i++){
            stack.push(Integer.parseInt(values[i]));
        }
    }

    private static int getMax(Stack stack, int limit){
        int max = Integer.MIN_VALUE;
        int cont = 0;
        Stack aux1 = new Stack(limit + 1);
        Stack aux2 = new Stack(limit + 1);
        while(cont <= limit){
            if(stack.head() > max){
                max = stack.head();
            }
            aux1.push(stack.pop());
            cont++;
        }

        while(!aux1.isEmpty()){
            aux2.push(aux1.pop());
        }

        while(!aux2.isEmpty()){
            stack.push(aux2.pop());
        }

        return max;
    }


    
}

class Stack{
    private int top;
    private int[] array;
    private static final int DEFAULT_CAPACITY = 10;
    
    public Stack(int capacity){
        this.top = -1;
        this.array = new int[capacity];
    }

    public Stack(){
        this.top = - 1;
        this.array = new int[DEFAULT_CAPACITY];
    }

    public void push(int element){
        if(isFull()){
            throw new StackOverflowError("This stack is full!");
        }
        else{
            this.top++;
            array[top] = element;
        }
        

    }

    public int pop(){
        if(isEmpty()){
            throw new Error("This stack is empty!");
        }
        return array[top--];

    }

    public int head(){
        if(isEmpty()){
           throw new Error("Head not exist, because this stack is empty!");
        }
        return this.array[this.top];
    }

    public boolean isFull(){
        return this.top == array.length - 1;

    }

    public boolean isEmpty(){
        return this.top == -1;

    }

    public boolean contains(int element){
        boolean result = false;
        if(isEmpty()){
            return false;
        }
        Stack aux = new Stack(this.array.length);

        while(!isEmpty()){
            if(head() == element){
                result = true;
                break;
            }
            else{
                aux.push(pop());

            }
            
        }

        while(!aux.isEmpty()){
            push(aux.pop());
        }
        return result;


    }

    /*public int getMax(int limit){
        if(isEmpty()){
            throw new Error("This stack is empty!");
        }

        int max = Integer.MIN_VALUE;
        Stack aux = new Stack(this.array.length);
        int cont = 0;

        while(!isEmpty() && cont <=limit){
            if(head() > max){
                max = head();
            }
            aux.push(pop());
            cont++;
        }

        while(!aux.isEmpty()){
            push(aux.pop());
        }

        return max;

    }
    */

   
    
}
