import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Top10 {
    FileReader fileReader;
    String line;
    List<Score> scores = new ArrayList<>();
        BufferedReader bufferedReader;
        BufferedWriter bufferedWriter;


    {
        File F = new File("top10.txt");
        if(!F.exists() ){
            try {
                F.createNewFile();
            } catch (IOException e) {
                System.out.println("Cant create the file");
                System.exit(1);
            }
        }
    }


    {
        try {
            bufferedReader = new BufferedReader(new FileReader("top10.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void ReadTextAndSort( ) throws IOException {
        while ((line = bufferedReader.readLine()) != null ){
            String[] parts = line.split(",");
            String name = parts[0];
            int score = Integer.parseInt(parts[1]);

            scores.add(new Score(name, score));
        }
        Collections.sort(scores, new Comparator<Score>() {
            @Override
            public int compare(Score o1, Score o2) {
                return o2.getScore() - o1.getScore();
            }
        });

    }
    public void writeTop10() throws IOException {
        FileWriter fileWriter = new FileWriter("top10.txt");
        for (int i = 0; i < 10 && i < scores.size(); i++) {
            Score player = scores.get(i);
            String line = player.getName() + "," + player.getScore() + "\n";
            System.out.println(line);
            fileWriter.write(line);
        }
        fileWriter.close();
    }
    public static class Score{
        private String name;
        private int  score;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public Score(String name, int score){
            this.name = name;
            this.score = score;
        }
    }
}
