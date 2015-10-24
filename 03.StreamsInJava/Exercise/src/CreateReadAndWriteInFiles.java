import java.io.*;

public class CreateReadAndWriteInFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("users.txt");
        File outputFile = new File("total-time.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        FileWriter fw = new FileWriter(outputFile, true);
        PrintWriter writer = new PrintWriter(fw, true);
        String line = reader.readLine();
        while (line != null) {
            String[] userAndTimePlayed = line.split(" ");
            String user = userAndTimePlayed[0];
            int timePlayed = 0;
            String result = "";
            for (int i = 1; i < userAndTimePlayed.length; i++) {
                String[] hoursAndMinutes = userAndTimePlayed[i].split(":");
                int hours = Integer.parseInt(hoursAndMinutes[0]);
                int minutes = Integer.parseInt(hoursAndMinutes[1]);
                timePlayed += hours * 60 + minutes;
                int daysPlayed = timePlayed / (24 * 60);
                int hoursPlayed = (timePlayed - daysPlayed * 24 * 60) / 60;
                int minutesPlayed = timePlayed - 60 * (daysPlayed * 24 + hoursPlayed);
                result = user + " " + timePlayed + " (" + daysPlayed + " days, " + hoursPlayed +
                        " hours, " + minutesPlayed + " minutes)";
            }
            writer.println(result);
            line = reader.readLine();
        }
        reader.close();
        writer.close();
    }

}
