import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leaderboard {
        // HashMap allows fast updates and lookups of scores
    private HashMap<String, Integer> scores = new HashMap<>();

    public void addScore(String name, int score) {
        scores.put(name, score);
    }

    public int getScore(String name) {
        return scores.getOrDefault(name, 0);
    }

    public void printLeaderboard() {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(scores.entrySet());

        // Sort descending by score
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).getValue() < list.get(j + 1).getValue()) {
                    Map.Entry<String, Integer> temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

        System.out.println("+============================+");
        System.out.println("|      LEADERBOARD           |");
        System.out.println("+============================+");

        for (int i = 0; i < list.size(); i++) {
            System.out.println("|  " + (i + 1) + ".  " + list.get(i).getKey() + " -> " + list.get(i).getValue() + "  |");
        }

        System.out.println("+============================+");
    }
}
