import java.util.*;

public class Productions {
    private Character start;

    private Map<Character, Character> terminals;
    private Map<CharPair, Character> nonTerminals;
    public Productions(Character start) {
        this.start = start;
        terminals = new HashMap<>();
        nonTerminals = new HashMap<>();
    }

    //TODO MAPS sollten nicht gehen weil eine Production nicht immer eindeutig zugeordnet werden kann
    public void addTerminalProd(Character start, Character end) {
        terminals.put(end, start);
    }
    public void addNonTerminalProd(Character start, Character end1, Character end2) {
        nonTerminals.put(new CharPair(end1, end2), start);
    }

    public Character get(Character nonTerminal1, Character nonTerminal2) {
        return nonTerminals.get(new CharPair(nonTerminal1, nonTerminal2));
    }

    public Character get(Character terminal) {
        return terminals.get(terminal);
    }

    public Character getStart() {
        return start;
    }
}
