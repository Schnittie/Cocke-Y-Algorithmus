import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CockAlgorithm {
    private Productions prod;

    public CockAlgorithm(Productions prod) {
        this.prod = prod;
    }

    public boolean runCockAlgorithm(String input) {
        int n = input.length();

        List<Character>[][] matrix = new List[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= n; i++) {
            //I assume that every char in the input is a valid terminal and that every terminal has a production
            for (char c : prod.get(input.charAt(i - 1))) {
                matrix[i][i].add(c);
            }
        }
        for (int d = 1; d <= n - 1; d++) {
            for (int i = 1; i <= n - d; i++) {
                int j = i + d;
                for (int k = i; k <= j - 1; k++) {
                    for (Character char1 : matrix[i][k]) {
                        for (Character char2 : matrix[k + 1][j]) {
                            if (null == prod.get(char1, char2)) {
                                continue;
                            }
                            for (Character c : prod.get(char1, char2))
                                matrix[i][j].add(c);
                        }
                    }
                }
            }
        }
        return matrix[1][n].contains(prod.getStart());
    }
}
