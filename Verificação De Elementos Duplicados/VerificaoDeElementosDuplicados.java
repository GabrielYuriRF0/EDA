import java.util.Scanner;
class VerificaoDeElementosDuplicados {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        //Read a line
        //FIXTO: Modify regex expression!
        String[] numbers = scanner.nextLine().split(" ");

        boolean searchNumber = false;

       
        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length - 1; j++){
                //checking if it has elements before the current one
                if(i != 0){
                    //scan all elements before the current one
                    for(int k = 0; k < i; k++){
                        if(numbers[i].equals(numbers[k])){
                            searchNumber = true;
                            break;
                        }
                    }
                }

                if(numbers[i].equals(numbers[j])){
                    searchNumber = true;
                    break;
                }

                

            }

        }
        
        System.out.println(searchNumber);

    }
    
}
