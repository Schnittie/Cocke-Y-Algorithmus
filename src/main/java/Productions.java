import java.util.*;

public class Productions {
    private Character start;

    private Map<Character, List<Character>> terminals;
    private Map<CharPair, List<Character>> nonTerminals;

    public Productions(Character start) {
        this.start = start;
        terminals = new HashMap<>();
        nonTerminals = new HashMap<>();
    }

    public void addTerminalProd(Character start, Character end) {
        if (terminals.containsKey(end)) {
            terminals.get(end).add(start);
            return;
        }
        terminals.put(end, new ArrayList<>());
        terminals.get(end).add(start);
    }

    public void addNonTerminalProd(Character start, Character end1, Character end2) {
        CharPair charPair = new CharPair(end1, end2);
        if (nonTerminals.containsKey(charPair)) {
            nonTerminals.get(charPair).add(start);
            return;
        }
        nonTerminals.put(charPair, new ArrayList<>());
        nonTerminals.get(charPair).add(start);
    }

    public List<Character> get(Character nonTerminal1, Character nonTerminal2) {
        return nonTerminals.get(new CharPair(nonTerminal1, nonTerminal2));
    }

    public List<Character> get(Character terminal) {
        return terminals.get(terminal);
    }

    public Character getStart() {
        return start;
    }
}
