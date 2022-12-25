import java.util.Scanner;
class FilaComArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());

        CircularQueue queue = new CircularQueue(size);
        CircularQueue aux = new CircularQueue(size);

        String[] command = new String[2];
        command[0] = "";
        command[1] = "";

        while(!command[0].equals("end")){
            if(command[0].equals("print")){
                System.out.println(print(queue, aux));
            }

            else if (command[0].equals("add")){
                int element = Integer.parseInt(command[1]);
                add(queue, element);
            }

            else if(command[0].equals("element")){
                System.out.println(element(queue));

            }

            else if (command[0].equals("remove")){
                remove(queue);
            }

            command = sc.nextLine().split(" ");

        }
    }

    private static String print(CircularQueue queue, CircularQueue aux){
        if(queue.isEmpty()){
            return "empty";
        }

        String out = "";

        while(!queue.isEmpty()){
            out += queue.oldest() + " ";
            aux.enqueue(queue.dequeue());
        }

        while(!aux.isEmpty()){
            queue.enqueue(aux.dequeue());
        }
        out = out.substring(0, out.length()-1);
        return out;
    }

    private static void add(CircularQueue queue, int element){
        if(queue.isFull()){
            System.out.println("full");
        }
        else{
            queue.enqueue(element);
        }
    }

    private static String element(CircularQueue queue){
        if(queue.isEmpty()){
            return "empty";
        }

        return "" + queue.oldest();
    }

    private static void remove(CircularQueue queue){
        if(queue.isEmpty()){
            System.out.println("empty");
        }

        else{
            queue.dequeue();
        }
    }
    
}

class CircularQueue{
    private int head;
    private int tail;
    private int elements;
    private int[] array;
    private static final int DEFAULT_CAPACITY = 10;

    public CircularQueue(int capacity){
        this.head = -1;
        this.tail = -1;
        this.elements = 0;
        this.array = new int[capacity];
    }

    public CircularQueue(){
        this.head = -1;
        this.tail = -1;
        this.elements = 0;
        this.array = new int[DEFAULT_CAPACITY];
    }

    public void enqueue(int element){
        if(isFull()){
            throw new Error("This queue is full!");
        }

        if(isEmpty()){
            head++;
            tail++;
            array[head] = element;
            elements++;
        }

        else{
            if(head > 0 && tail == array.length-1){
                tail = 0;
                array[tail] = element;
            }
            else{
                tail++;
                array[tail] = element;

            }
            elements++;
            
        }

    }

    public int dequeue(){
        if(isEmpty()){
            throw new Error("Dequeue is not conclude, because this queue is empty");

        }
        int element = 0;
        if(elements == 1){
            element = array[head];
            head = -1;
            tail = -1;
            elements--;
        }

        else{
            if(head == array.length -1 && elements > 1){
                element = array[head];
                head = 0;
            }
            else{
                element = array[head];
                head++;
            }
            elements--;

        }
        return element;
            
        
    }

    public boolean isEmpty(){
        return elements == 0;

    }

    public boolean isFull(){
        return elements == this.array.length;

    }

    public int oldest(){
        if(isEmpty()){
            throw new Error("Oldest not exist, because this queue is empty!");
        }

        return array[head];
    }

}
