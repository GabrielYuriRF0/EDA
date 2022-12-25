import java.util.Arrays;
import java.util.Scanner;
class SelectionSortPassoAPasso{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split(" ");
        int[] arrayInt = gerarArrayInteiro(array);

        selectionSort(arrayInt);

    }
    
    private static int[] gerarArrayInteiro(String[] arrayString){
        int[] arrayInteiro = new int[arrayString.length];

        for(int i = 0; i < arrayString.length; i++){
            arrayInteiro[i] = Integer.parseInt(arrayString[i]);
        }

        return arrayInteiro;
    }

    private static void selectionSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int indiceMenor = i;
            boolean ordenado = true;
            
            
            for(int j = i+1 ; j < array.length; j++){
                if(array[j] < array[indiceMenor]){
                    indiceMenor = j;
                    ordenado = false;
                    
                }
            }
            
            int aux = array[i];
            array[i] = array[indiceMenor];
            array[indiceMenor] = aux;
            if(ordenado == false){
                System.out.println(Arrays.toString(array));

            }
            
        }
        
        
    }
}