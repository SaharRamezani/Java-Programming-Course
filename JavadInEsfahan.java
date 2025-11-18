import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreasureChest {
    private final List<String> clues = new ArrayList<>();
    private final Map<String, Integer> locationMap = new HashMap<>();

    public void addClue(String clue, int steps) {
        // Implement logic to add clue and steps
        locationMap.put(clue, steps);
        clues.add(clue);
    }

    public void removeClue(String clue) {
        // Implement logic to remove clue
        locationMap.remove(clue);
        int i = 0;
        for (String cluee : clues)
        {
            if (cluee == clue)
            {
                break;
            }
            i++;
        }
        clues.remove(i);
    }

    public List<String> getAllClue() {
        // Implement logic to return all clues
        return clues;
    }

    public int totalSteps(String targetClue) {
        // Implement logic to get total steps for a specific clue
        int totalSteps = 0;
        for (String clue : clues)
        {
            totalSteps += locationMap.get(clue);
            if (targetClue == clue)
            {
                break;
            }
        }
        return totalSteps;
    }

    public String decipherMap() {
        // Implement logic to decipher the map
        int i = 0;
        StringBuilder res = new StringBuilder("");
        
        for (String clue : clues)
        {
            res.append("Index: " + i + " , Clue: " + clue + " , Step: " + locationMap.get(clue) + "\n");
            i++;
        }
        return res.toString();
    }
}
