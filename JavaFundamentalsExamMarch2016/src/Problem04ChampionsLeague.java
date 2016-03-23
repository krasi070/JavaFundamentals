import java.util.*;
import java.util.stream.Collectors;

public class Problem04ChampionsLeague {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        HashMap<String, HashMap<String, Integer>> matchResults = new HashMap<>();

        String match = scan.nextLine();
        while (!match.equals("stop")) {
            String[] matchArgs = match.split("[|]");
            String firstTeam = matchArgs[0].trim();
            String secondTeam = matchArgs[1].trim();

            String firstMatchScore = matchArgs[2].trim();
            int firstMatchHomeScore = Integer.parseInt(firstMatchScore.split(":")[0]);
            int firstMatchAwayScore = Integer.parseInt(firstMatchScore.split(":")[1]);

            String secondMatchScore = matchArgs[3].trim();
            int secondMatchHomeScore = Integer.parseInt(secondMatchScore.split(":")[0]);
            int secondMatchAwayScore = Integer.parseInt(secondMatchScore.split(":")[1]);

            int firstTeamScore = firstMatchHomeScore + secondMatchAwayScore;
            int secondTeamScore = firstMatchAwayScore + secondMatchHomeScore;

            boolean firstTeamWon = false;
            if (firstTeamScore > secondTeamScore) {
                firstTeamWon = true;
            } else if (firstTeamScore < secondTeamScore) {
                firstTeamWon = false;
            } else {
                if (secondMatchAwayScore > firstMatchAwayScore) {
                    firstTeamWon = true;
                } else {
                    firstTeamWon = false;
                }
            }

            if (!matchResults.containsKey(firstTeam)) {
                matchResults.put(firstTeam, new HashMap<>());
            }

            if (!matchResults.get(firstTeam).containsKey(secondTeam)) {
                matchResults.get(firstTeam).put(secondTeam, 0);
            }

            if (firstTeamWon) {
                matchResults.get(firstTeam).put(secondTeam, matchResults.get(firstTeam).get(secondTeam) + 1);
            }

            if (!matchResults.containsKey(secondTeam)) {
                matchResults.put(secondTeam, new HashMap<>());
            }

            if (!matchResults.get(secondTeam).containsKey(firstTeam)) {
                matchResults.get(secondTeam).put(firstTeam, 0);
            }

            if (!firstTeamWon) {
                matchResults.get(secondTeam).put(firstTeam, matchResults.get(secondTeam).get(firstTeam) + 1);
            }

            match = scan.nextLine();
        }

        ArrayList<String> orderedTeams = new ArrayList<>();
        for (String team : matchResults.keySet()) {
            int wins = 0;
            for (String opponent : matchResults.get(team).keySet()) {
                wins += matchResults.get(team).get(opponent);
            }

            orderedTeams.add(team + "|" + wins);
        }

        Comparator<String> teamComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String firstTeam = o1.split("[|]")[0];
                String secondTeam = o2.split("[|]")[0];
                int firstTeamWins = Integer.parseInt(o1.split("[|]")[1]);
                int secondTeamWins = Integer.parseInt(o2.split("[|]")[1]);

                int comparator = Integer.compare(secondTeamWins, firstTeamWins);
                if (comparator != 0) {
                    return comparator;
                }

                return firstTeam.compareTo(secondTeam);
            }
        };

        Comparator<String> opponentComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        List<String> list = orderedTeams.stream().sorted(teamComparator).map(t -> t.toString()).collect(Collectors.toList());

        for (String teamArgs : list) {
            String team = teamArgs.split("[|]")[0];
            int wins = Integer.parseInt(teamArgs.split("[|]")[1]);
            System.out.println(team);
            System.out.println("- Wins: " + wins);
            List<String> opponents = matchResults.get(team).keySet().stream().sorted().map(t -> t.toString()).collect(Collectors.toList());
            System.out.println("- Opponents: " + String.join(", ", opponents));
        }
    }
}
