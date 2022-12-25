import java.util.Scanner;
class VetorCircularDois {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] numbersStr = scanner.nextLine().split(" ");
        int n = scanner.nextInt();

        int[] numbers = makeIntArray(numbersStr);

        System.out.println(circularVector(numbers, n));
    }

    private static int[] makeIntArray(String[] sequence){
        int[] sequenceInt = new int[sequence.length];

        for(int i = 0; i < sequence.length; i++){
            sequenceInt[i] = Integer.parseInt(sequence[i]);
        }

        return sequenceInt;
    }
    private static String circularVector(int[] array, int elements){
        String out = "";
        int controller = 0;

        while(controller < elements){
            for(int i = 0; i < array.length; i++){
                if(controller == elements){
                    return out.trim();
                }
                out += array[i] + " ";
                controller++;
            }
        }
        return out.trim();
    }  
}

/*
 * Análise
 * - Independente dos casos, sempre vai ser executado o mesmo conjunto de 
 * instruções.
 * 
 * 1.Identificação das primitivas:
 * c1 - String out = ""
 * c2 - int controller = 0
 * c3 - controller != elements
 * c4 - int i = 0
 * c5 - i < array.length
 * c6 - i++
 * c7 - controller == elements
 * c8 - return out.trim()
 * c9 - out += array[i] + " "
 * c10 - controller++
 * c11 - return out.trim()
 *
 * 2.Identificar quantas vezes cada primitiva se repete:
 * c1 - 1
 * c2 - 1
 * c3 - n1
 * c4 - n1
 * c5 - n1 * (n2+1)
 * c6 - n2
 * c7 - n1*n2
 * c8 - 1
 * c9 - n1*n2
 * c10 - n1*n2
 * c11 - 0
 * 
 * 3.Definir custo total
 * f(n) = c1 + c2 + c3 + c8 + (c3 + c4) * n1 + c5 * (n1 * (n2 + 1)) + c6 * n2 + (c9 + c10) * (n1 * n2)
 * 
 * 4.Simplificar fórmula do custo total
 * f(n) = (n1 **5) * (n2 ** 5)
 * 
 * f(n) = n
 * 
 * 5. A função que descreve essa função é da classe linear => Theta(N)
 * 
 */
