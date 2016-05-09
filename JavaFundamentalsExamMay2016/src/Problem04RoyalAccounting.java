import java.math.BigDecimal;
import java.util.*;

public class Problem04RoyalAccounting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, String[]>> teams = new LinkedHashMap<>();
        String regex = "^([A-Za-z]+);([0-9]+);([0-9]+\\.*[0-9]*);([A-Za-z]+)$";

        String line = scan.nextLine();
        while (!line.equals("Pishi kuf i da si hodim")) {
            if (line.matches(regex)) {
                String[] employeeArgs = line.split(";");
                String employeeName = employeeArgs[0];
                String workHoursPerDay = employeeArgs[1];
                String dailyPayment = employeeArgs[2];
                String team = employeeArgs[3];

                if (!teams.containsKey(team)) {
                    teams.put(team, new TreeMap<>());
                }

                if (!teams.get(team).containsKey(employeeName)) {
                    teams.get(team).put(employeeName, new String[3]);
                }

                teams.get(team).get(employeeName)[0] = workHoursPerDay;
                teams.get(team).get(employeeName)[1] = dailyPayment;
                double workHours = Double.parseDouble(workHoursPerDay);
                double dailyPay = Double.parseDouble(dailyPayment);
                double dailyIncome = (workHours * dailyPay) / 24.0;
                teams.get(team).get(employeeName)[2] = dailyIncome + "";
            }

            line = scan.nextLine();
        }

        Comparator<Map.Entry<String, TreeMap<String, String[]>>> teamComparator =
                new Comparator<Map.Entry<String, TreeMap<String, String[]>>>() {
            @Override
            public int compare(
                    Map.Entry<String, TreeMap<String, String[]>> o1,
                    Map.Entry<String, TreeMap<String, String[]>> o2) {
                BigDecimal money1 = new BigDecimal(0);
                BigDecimal money2 = new BigDecimal(0);

                for (Map.Entry<String, String[]> currEmployee : o1.getValue().entrySet()) {
                    BigDecimal dailyIncome = new BigDecimal(currEmployee.getValue()[2]);
                    money1 = money1.add(dailyIncome.multiply(BigDecimal.valueOf(30)));
                }

                for (Map.Entry<String, String[]> currEmployee : o2.getValue().entrySet()) {
                    BigDecimal dailyIncome = new BigDecimal(currEmployee.getValue()[2]);
                    money2 = money2.add(dailyIncome.multiply(BigDecimal.valueOf(30)));
                }

                return money2.compareTo(money1);
            }
        };

        Comparator<Map.Entry<String, String[]>> employeeComparator =
                new Comparator<Map.Entry<String, String[]>>() {
                    @Override
                    public int compare(Map.Entry<String, String[]> o1, Map.Entry<String, String[]> o2) {
                        int workHours1 = Integer.parseInt(o1.getValue()[0]);
                        int workHours2 = Integer.parseInt(o2.getValue()[0]);
                        int compareWorkHours = Integer.compare(workHours2, workHours1);
                        if (compareWorkHours == 0) {
                            BigDecimal dailyIncome1 = new BigDecimal(o1.getValue()[2]);
                            BigDecimal dailyIncome2 = new BigDecimal(o2.getValue()[2]);

                            return dailyIncome2.compareTo(dailyIncome1);
                        }

                        return compareWorkHours;
                    }
                };

        ArrayList<String> orderedTeams = new ArrayList<>();
        teams.entrySet().stream().sorted(teamComparator).forEach(e -> orderedTeams.add(e.getKey()));

        for (String currTeam : orderedTeams) {
            System.out.println("Team - " + currTeam);
            ArrayList<String> orderedEmployees = new ArrayList<>();
            teams.get(currTeam).entrySet().stream().sorted(employeeComparator).forEach(e -> orderedEmployees.add(e.getKey()));
            for (String currEmployee : orderedEmployees) {
                BigDecimal dailyIncome = new BigDecimal(teams.get(currTeam).get(currEmployee)[2]);
                System.out.printf(
                        "$$$%s - %s - %.6f\n",
                        currEmployee,
                        teams.get(currTeam).get(currEmployee)[0],
                        dailyIncome);
            }
        }
    }
}
