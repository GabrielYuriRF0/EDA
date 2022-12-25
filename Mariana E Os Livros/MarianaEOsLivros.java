import java.util.Arrays;
import java.util.Scanner;


class MarianaEOsLivros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] livros = sc.nextLine().split(",");

        insertionSort(livros);

    }


    public static void insertionSort(String[] livros) {
        for (int i = 0; i < livros.length; i++) { 
            String out = "";
            int j = i;
            while (j > 0 && livros[j].compareTo(livros[j-1]) < 0 ) {
                String aux = livros[j];
                livros[j] = livros[j - 1];
                livros[j - 1] = aux;
                j -= 1;
            }
            
            
            for(String livro: livros){
                out += livro +", ";
            }
            out = out.replaceFirst(".$","") ;
            out = out.replaceFirst(".$","") ;
            System.out.println(out);
        
        }	
    }
    
    
}
