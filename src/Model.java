import java.io.*;

class Model {
    final static int WIDTH = 30;
    final static int HEIGHT = 20;
    boolean isStopped = false;

    static int getHeight() {
        return HEIGHT;
    }

    private File level = new File("src" + File.separator + "initField1");

    boolean[][] getField() {
        return field;
    }


    private static volatile boolean[][] field = new boolean[WIDTH][HEIGHT];

    void init() {
        try (BufferedReader reader = new BufferedReader(new FileReader(level))) {
            String line;
            char[] lineOfChar;
            int lineNum = 0;
            while ((line = reader.readLine()) != null) {
                lineOfChar = line.toCharArray();
                for (int i = 0; i < lineOfChar.length; i++) {
                    if (lineOfChar[i] == 'x') field[i][lineNum] = true;
                    else field[i][lineNum] = false;

                }
                lineNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doStep() {


        boolean[][] newField = new boolean[WIDTH][HEIGHT];
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {

                int neighbourNum = countNeghbour(field,i, j);
                if (field[i][j]){
                    if (neighbourNum > 3 || neighbourNum < 2) newField[i][j]=false;
                    else newField[i][j]=true;
                }
                else {
                    if (neighbourNum == 3) newField[i][j]=true;
                    else newField[i][j]=false;
                }


            }
        }
        field = newField;
    }

    int countNeghbour(boolean[][] fieldOld,int x, int y) {
        int count = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if ((i != x || j != y) && i >= 0 && i < WIDTH && j >= 0 && j < HEIGHT) {
                    if (fieldOld[i][j]) count++;
                }

            }
        }
        return count;
    }


}
