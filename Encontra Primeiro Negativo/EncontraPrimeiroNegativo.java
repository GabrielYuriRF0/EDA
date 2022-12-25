import java.util.Scanner;
class EncontraPrimeiroNegativo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] sequenciaString = scanner.nextLine().split(" ");
        int[] sequenciaInt = gerarArrayInteiro(sequenciaString);

        int out = econtraPrimeiroNegativo(sequenciaInt, 0);

        if(out == 0){
            System.out.println("-");
        }
        
        else{
            System.out.println(out);
        }
    }

    private static int[] gerarArrayInteiro(String[] arrayString){
        int[] arrayInteiro = new int[arrayString.length];

        for(int i = 0; i < arrayString.length; i++){
            arrayInteiro[i] = Integer.parseInt(arrayString[i]);
        }

        return arrayInteiro;
    }

    private static int econtraPrimeiroNegativo(int[] array, int index){
        if(index == array.length){
            return 0;
        }

        if(array[index] < 0){
            return array[index];
        }

        return econtraPrimeiroNegativo(array, ++index);
    }
    
    
}
