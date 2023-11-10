import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Productions prod = new Productions('S');
        List<Character> characters = new ArrayList<>();
        prod.addTerminalProd('A','a');
        prod.addTerminalProd('B','b');
        prod.addTerminalProd('C','c');
        prod.addNonTerminalProd('S','A','B');
        prod.addNonTerminalProd('A','A','A');
        prod.addNonTerminalProd('B','B','C');
        prod.addNonTerminalProd('B','B','B');
        prod.addNonTerminalProd('C','C','C');

        CockAlgorithm cock = new CockAlgorithm(prod);
        System.out.println(cock.runCockAlgorithm("abcc"));


    }
}
