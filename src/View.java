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
        int x, y;
        for (int i = 0; i < buttons.size(); i++) {
            x = i / Model.WIDTH;
            y = i % Model.HEIGHT;
            if (model.getField()[x][y]) {
                buttons.get(i).setBackground(Color.black);
            }
            else {
                buttons.get(i).setBackground(Color.white);
            }

        }
    }

    void init() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                model.init();
                for (int i = 0; i < model.getField().length; i++) {
                    for (int j = 0; j < model.getField()[0].length; j++) {
                        JButton b = new JButton();
                        buttons.add(b);
                        add(b);
                    }
                }
                refresh();

            }
        });
    }

}
