import java.util.Scanner;
class BuscaLinearRecursiva {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        String[] sequenciaString = scanner.nextLine().split(" ");
        int n = scanner.nextInt(); 
        int[] sequenciaInt = gerarArrayInteiro(sequenciaString);
        System.out.println(buscaLinear(sequenciaInt, n, 0));

    }

    private static int[] gerarArrayInteiro(String[] arrayString){
        int[] arrayInteiro = new int[arrayString.length];

        for(int i = 0; i < arrayString.length; i++){
            arrayInteiro[i] = Integer.parseInt(arrayString[i]);
        }

        return arrayInteiro;
    }

    private static int buscaLinear(int[] array, int n, int index){
        if(index == array.length){
            return -1;
        }

        else if(array[index] == n){
            return index;
        }
        
        return buscaLinear(array, n, ++index);


    }
}
