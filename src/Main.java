import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int LENGTH = 6;
    public static void main(String[] args) throws IOException {
        File file = new File("text.TXT");
        Text text = new Text();

        // Чтение из файла text.txt
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);

            String allText = "";
            List<String> bigWords = new ArrayList<>();

            for (byte b: buffer) {
                char c = Character.toLowerCase((char) b);
                if (c >= 'a' && c <= 'z')
                    allText += c;
                else if (c == ' ' || c == '\n' || c == '\t')
                    allText += " ";
                else
                    continue;
            }

            for (String s: allText.split("\\s"))
                if (s.length() > 6)
                    bigWords.add(s);

            text.setText(allText);
            text.setBigWords(bigWords);

        } catch (IOException e) {
            System.out.println(e);
        }

        // Запись в файл out.txt
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("out.txt");
            fileWriter.write(text.getText());
            fileWriter.write("\n");
            for (String s: text.getBigWords())
                fileWriter.write(s + " ");
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (fileWriter != null)
                fileWriter.close();
        }

    }
}
