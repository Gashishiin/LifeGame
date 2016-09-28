import com.sun.org.apache.xpath.internal.operations.Mod;

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
                grid = new GridLayout(20, 20, 0, 0);
                setLayout(grid);
                setPreferredSize(new Dimension(200, 200));
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
            System.out.print(model.countNeghbour(model.getField(), x,y) + (model.getField()[x][y] ? "*" : "-"));
      //      if (x == 0) System.out.println();
            if (model.getField()[x][y]) {
                buttons.get(i).setBackground(Color.black);
            }
            else {
                buttons.get(i).setBackground(Color.white);
            }

     //       buttons.get(i).setText(model.countNeghbour(x, y) + "");
            if (y + 1 == Model.HEIGHT) System.out.println();
        }
         System.out.println();
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
