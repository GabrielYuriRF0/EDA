import java.util.Scanner;

class MaxHeap{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sequenceStr = sc.nextLine().split(" ");
        int[] sequenceInt = makeIntArray(sequenceStr);

        System.out.println(isMaxHeap(sequenceInt));
    }

    private static boolean isMaxHeap(int[] sequence){
        boolean result = true;
        

        for(int i = 0; i < sequence.length; i++){
            // Caso o nó tenha 2 filhos
            if(left(i) <= sequence.length - 1 && right(i) <= sequence.length - 1){
                if(sequence[i] < sequence[left(i)] || sequence[i] < sequence[right(i)]){
                    result = false;
                    break;
                }
            }

            // Caso o nó só tenha um filho a esquerda
            if(left(i) <= sequence.length - 1 && right(i) > sequence.length -1){
                if(sequence[i] < sequence[left(i)]){
                    result = false;
                    break;
                }

            }

            //
           
        }
        return result;

    }

    private static int[] makeIntArray(String[] sequence){
        int[] sequenceInt = new int[sequence.length];

        for(int i = 0; i < sequence.length; i++){
            sequenceInt[i] = Integer.parseInt(sequence[i]);
        }

        return sequenceInt;
    }

    private static int left(int index){
        return 2 * index + 1;

    }

    private static int right(int index){
        return 2 * (index + 1);

    }
}