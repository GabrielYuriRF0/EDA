import java.util.Scanner;

class PotenciaRecursiva {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int sequencia = 1;

        System.out.println(potenciaRecursiva(i, j, sequencia));
    }

    private static int potenciaRecursiva(int base, int expoente, int sequencia){
        expoente -= 1;

        if(expoente == -1 && sequencia == 1){
            sequencia++;
            return 1;
        }  

        else if(expoente == 0 && sequencia == 1){
            return base;
        }
        else if (expoente == 0 && sequencia != 1){
            return base;
        }

        sequencia++;
        return base * potenciaRecursiva(base, expoente, sequencia);
    }
    
}
