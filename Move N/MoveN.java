import java.util.Arrays;
import java.util.Scanner;

class MovenN{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] arrayString = sc.nextLine().split(" ");
        sort(gerarArrayInteiro(arrayString));
       
    }

    private static void sort(int[] array){
        for(int i = 1; i < array.length; i++){
            if(array[i] < array[i - 1]){
                int index = i;
                while(array[index] < array[index]){
                    int aux = array[index];
                    array[index] = array[index-1];
                    array[index-1] = aux;
                    System.out.println(Arrays.toString(array));

                }
                break;
            }

        }
    }

    private static int[] gerarArrayInteiro(String[] arrayString){
        int[] arrayInteiro = new int[arrayString.length];

        for(int i = 0; i < arrayString.length; i++){
            arrayInteiro[i] = Integer.parseInt(arrayString[i]);
        }

        return arrayInteiro;
    }


}