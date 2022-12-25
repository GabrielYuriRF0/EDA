import java.util.Scanner;

class EncontraElemento {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        String[] numbers = scanner.nextLine().split(" ");

        System.out.println(findNumber(n, numbers).trim());
    }

    private static String findNumber(String n, String[] numbers){
        String out = "nao";

        for(String number: numbers){
            if(number.equals(n)){
                out = "sim";
                break;

            }
        }
        return out;
    }

    
}
