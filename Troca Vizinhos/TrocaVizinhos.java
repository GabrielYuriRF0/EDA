import java.util.Arrays;
import java.util.Scanner;

class TrocaVizinhos{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbersStr = scanner.nextLine().split(" ");
        int [] numbers = makeIntArray(numbersStr);
        trocaVizinhos(numbers);

    }
    private static int[] makeIntArray(String[] sequence){
        int[] sequenceInt = new int[sequence.length];

        for(int i = 0; i < sequence.length; i++){
            sequenceInt[i] = Integer.parseInt(sequence[i]);
        }

        return sequenceInt;
    }

    public static void trocaVizinhos(int[] numbers){
        int arraySize = numbers.length;

         //if the number of elements is even
         if(arraySize % 2 == 0){
            for(int i = 0; i <= arraySize - 1; i+=2){
                int aux = numbers[i];
                numbers[i] = numbers[i+1];
                numbers[i+1] = aux;
            }
    }
    //if the number of element is unpaired
    else{
        for(int i = 0; i <= arraySize; i+=2){
            if(i == arraySize - 1){
                break;
            }
            int aux = numbers[i];
            numbers[i] = numbers[i+1];
            numbers[i+1] = aux;
        }
    }
    System.out.println(Arrays.toString(numbers));
}
}
