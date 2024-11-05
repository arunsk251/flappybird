import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Difficulty
{

    private JPanel panel1;
    private JButton EASYButton;
    private JButton MEDIUMButton;
    private JButton HARDButton;

    public Difficulty() {

        EASYButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null,"Gravity 1");
            }
        });
        MEDIUMButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null,"Gravity 2");
            }
        });
        HARDButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null,"Gravity 3");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Difficulty");
        frame.setContentPane(new Difficulty().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
