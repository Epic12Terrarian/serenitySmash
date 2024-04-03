import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameFrame extends JFrame implements ActionListener {

    public GameFrame() {

        this.setTitle("Smashing Serenity");
        this.setSize(800, 600); //size of frame
        this.setResizable(false); //no resize
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes application
        this.setLayout(null);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==App.StartMenuButton) {
            App.startMenu();
        }
    }
}