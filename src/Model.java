import java.io.*;

class Model {
    final static int WIDTH = 20;
    final static int HEIGHT = 15;
    boolean isStopped = false;


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
                for (int charPosInLine = 0; charPosInLine < lineOfChar.length; charPosInLine++) {
                    field[charPosInLine][lineNum] = (lineOfChar[charPosInLine]== 'x');
                }
                lineNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doStep() {


        boolean[][] newField = new boolean[WIDTH][HEIGHT];
        for (int row = 0; row < field[0].length; row++) {
            for (int column = 0; column < field.length; column++) {

                int neighbourNum = countNeghbour(field,column, row);
                if (field[column][row]){
                    if (neighbourNum > 3 || neighbourNum < 2) newField[column][row]=false;
                    else newField[column][row]=true;
                }
                else {
                    if (neighbourNum == 3) newField[column][row]=true;
                    else newField[column][row]=false;
                }


            }
        }
        field = newField;
    }

    int countNeghbour(boolean[][] fieldOld,int currentColumn, int currentRow) {
        int count = 0;
        for (int row = currentRow - 1; row <= currentRow + 1; row++) {
            for (int column = currentColumn - 1; column <= currentColumn + 1; column++) {
                if ((row != currentRow || column != currentColumn) && row >= 0 && row < HEIGHT && column >= 0 && column < WIDTH) {
                    if (fieldOld[column][row]) count++;
                }

            }
        }
        return count;
    }


}
