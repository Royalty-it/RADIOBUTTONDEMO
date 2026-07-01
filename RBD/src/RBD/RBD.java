package RBD;

import javax.swing.*;
import java.awt.*;

public class RBD extends JFrame {
    String[] pets = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};
    JLabel img = new JLabel();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RBD().setVisible(true));
    }

    RBD() {
        setTitle("RadioButtonDemo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel p = new JPanel(new GridLayout(5,1));
        ButtonGroup g = new ButtonGroup();
        JRadioButton last = null;

        for (String s : pets) {
            JRadioButton rb = new JRadioButton(s);
            g.add(rb);
            rb.addActionListener(e -> {
                img.setIcon(getImg(s));
                JOptionPane.showMessageDialog(this, "You selected: " + s);
            });
            p.add(rb);
            last = rb;
        }

        add(p, BorderLayout.WEST);
        add(img, BorderLayout.CENTER);
        setSize(350, 250);
        
       
    }

    ImageIcon getImg(String name) {
        try {
            String path = "/RBD/images/" + name.toLowerCase() + ".jpeg";
            java.net.URL url = getClass().getResource(path);
            if (url != null)
                return new ImageIcon(new ImageIcon(url).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        } catch (Exception e) {}
        return null;
    }
}