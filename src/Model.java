import java.io.*;

/**
 * Created by gashi_000 on 27.09.2016.
 */
public class Model {
    private final static int width = 20;
    private final static int height = 20;

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    private File level = new File("src\\initField1");

    public char[][] getField() {
        return field;
    }

    char[][] field = new char[width][height];

    public void init() {
        try (BufferedReader reader = new BufferedReader(new FileReader(level))) {
            String line;
            char[] lineOfChar;
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                lineOfChar = line.toCharArray();
                for (int i = 0; i < lineOfChar.length; i++) {
                    field[i][lineNum] = lineOfChar[i];
                }
                lineNum++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
