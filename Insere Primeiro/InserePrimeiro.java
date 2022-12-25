import java.util.Arrays;
import java.util.Scanner;
class InserePrimeiro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split(" ");
        int[] arrayInt = gerarArrayInteiro(array);

        System.out.println(Arrays.toString(insercaoOrdenada(arrayInt)));
        
    }

    private static int[] gerarArrayInteiro(String[] arrayString){
        int[] arrayInteiro = new int[arrayString.length];

        for(int i = 0; i < arrayString.length; i++){
            arrayInteiro[i] = Integer.parseInt(arrayString[i]);
        }

        return arrayInteiro;
    }

    private static int[] insercaoOrdenada(int[] array){
        int i = 0;
        while(i < array.length - 1 && array[i] > array[i+1]  ){
            int aux = array[i];
            array[i] = array[i+1];
            array[i+1] = aux;
            i++;
        }
        return array;
    }
    
}
