import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class View extends JFrame{
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
                grid = new GridLayout(20,20,1,1);
                setLayout(grid);
                setPreferredSize(new Dimension(200,200));
                setVisible(true);
                pack();

            }
        });

    }

    private void refresh()
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int x,y;
                for (int i = 0; i < buttons.size(); i++) {
                    x = i / Model.WIDTH;
                    y = i % Model.HEIGHT;
                    if (model.getField()[y][x]) buttons.get(i).setBackground(Color.black);
                }
            }
        });
    }

    void init()
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                model.init();
                for (int i = 0; i < model.getField().length; i++) {
                    for (int j = 0; j < model.getField()[0].length; j++) {
                        JButton b = new JButton();
                        buttons.add(b);
                        add(b);
                        b.setBackground(Color.GRAY);
                    }
                }
                refresh();

            }
        });
    }

}
