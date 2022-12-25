import java.util.Arrays;
import java.util.Scanner;;
class InsertionSortRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] array = sc.nextLine().split(" ");
        int[] arrayInt = gerarArrayInteiro(array);

        insertionSort(arrayInt, 1);
    }

    private static int[] gerarArrayInteiro(String[] arrayString){
        int[] arrayInteiro = new int[arrayString.length];

        for(int i = 0; i < arrayString.length; i++){
            arrayInteiro[i] = Integer.parseInt(arrayString[i]);
        }

        return arrayInteiro;
    }

    private static int[] insertionSort(int[] array, int index){
        int cont = index;

        if(index == array.length){
            return array;
        }

        while(cont > 0 && array[cont] < array[cont - 1]){
            int aux = array[cont];
            array[cont] = array[cont-1];
            array[cont - 1] = aux;
            cont--; 
        }
        System.out.println(Arrays.toString(array));
        
        return insertionSort(array, ++index);
    





    }
    
}
