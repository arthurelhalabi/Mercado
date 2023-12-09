package Interface;


import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Frame {
    public static void main(String[] args) {
        JFrame miJFrame = new JFrame("Exemplo - Java Swing");
        miJFrame.setSize(500,300);

        Button botao = new Button();
        botao.setSize(20, 90);

        JPanel miJPanel = new JPanel();
        miJPanel.setSize(300, 300);

        miJPanel.setLayout(new GridBagLayout());

        JLabel miJLabel = new JLabel();
        miJLabel.setText("Digite com poucas atual:   ");

        JTextArea miJtextArea = new JTextArea(20, 20);

        miJPanel.add(miJLabel);
        miJPanel.add(miJtextArea);

        miJPanel.add(botao);
        miJFrame.add(miJPanel);

        miJFrame.setVisible(true);
    }
}
