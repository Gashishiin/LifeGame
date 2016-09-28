import java.io.*;

class Model {
    final static int WIDTH = 20;
    final static int HEIGHT = 20;


    static int getHeight() {
        return HEIGHT;
    }

    private File level = new File("src"+File.separator + "initField1");

    boolean[][] getField() {
        return field;
    }

    private boolean[][] field = new boolean[WIDTH][HEIGHT];

    void init() {
        try (BufferedReader reader = new BufferedReader(new FileReader(level))) {
            String line;
            char[] lineOfChar;
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                lineOfChar = line.toCharArray();
                for (int i = 0; i < lineOfChar.length; i++) {
                    if (lineOfChar[i]=='x') field[i][lineNum] = true;
                    else field[i][lineNum] = false;

                }
                lineNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doStep() {


    }





}
