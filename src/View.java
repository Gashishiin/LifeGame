import javax.swing.*;
import java.awt.*;

/**
 * Created by gashi_000 on 27.09.2016.
 */
public class View extends JFrame{
    private Model model;
    private int cellSize;
    private JTable table;
    public View() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                setTitle("Field");
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setLayout(new GridLayout());
                setPreferredSize(new Dimension(200,200));
                setVisible(true);
                table = new JTable(20,20);
                table.setRowHeight(10);
                add(table);
                pack();

            }
        });

    }

    public void refresh()
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                char[][] field = model.getField();
                
            }
        });
    }

}
