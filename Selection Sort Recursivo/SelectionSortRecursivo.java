import java.util.Arrays;
import java.util.Scanner;
class SelectionSortRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split(" ");
        int[] arrayInt = gerarArrayInteiro(array);

        selectionSort(arrayInt, 0);
    }

    private static int[] gerarArrayInteiro(String[] arrayString){

        int[] arrayInteiro = new int[arrayString.length];

        for(int i = 0; i < arrayString.length; i++){
            arrayInteiro[i] = Integer.parseInt(arrayString[i]);
        }

        return arrayInteiro;
    }

    private static int[] selectionSort(int[] array, int index){
        int menor = index;

        if(index == array.length - 1){
            
            return array;
        }

        for(int i = index + 1; i <= array.length - 1; i++){
            if(array[i] < array[menor]){
                menor = i;
            }
        }
        int aux = array[menor];
        array[menor] = array[index];
        array[index] = aux;
        System.out.println(Arrays.toString(array));

        return selectionSort(array, ++index);

    }
    

}
