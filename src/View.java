import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class View extends JFrame {
    private Model model = new Model();
    private int cellSize;
    private GridLayout grid;
    private java.util.List<JButton> buttons = new ArrayList<>();

    View() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Field");
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                grid = new GridLayout(Model.HEIGHT, Model.WIDTH, 0, 0);
                setLayout(grid);
                setPreferredSize(new Dimension(Model.WIDTH*10, Model.HEIGHT*10));
                setVisible(true);
                pack();

            }
        });

    }

     void refresh() {
        int row, column;
        for (int i = 0; i < buttons.size(); i++) {
            row = i / Model.WIDTH;
            column = i % Model.WIDTH;
            if (model.getField()[column][row]) {
                buttons.get(i).setBackground(Color.black);
            }
            else {
                buttons.get(i).setBackground(Color.white);
            }

        }
    }

    void init() {
        SwingUtilities.invokeLater(() -> {
            model.init();
            for (int row = 0; row < model.getField()[0].length; row++) {
                for (int column = 0; column < model.getField().length; column++) {
                    JButton b = new JButton();
                    buttons.add(b);
                    add(b);
                }
            }

            refresh();

        });
    }

}
