import java.util.Scanner;

class WarmUp{
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        String[] numbersString = scanner.nextLine().split(" ");
        String out = "";

        for(int i = 0; i < numbersString.length; i++){
            out += Integer.toString(Integer.parseInt(numbersString[i]) * number) + " ";
        }
        System.out.println(out.trim());


    }
}