package main;

import javax.swing.JFrame;

public class Main {
    
    public static void main (String[] args)
    {
        JFrame w = new JFrame();
        
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setResizable(false);
        w.setTitle("Bomberman");
        
        Gamepanel panel = new Gamepanel();
        w.add(panel);
        w.pack();
        w.setLocationRelativeTo(null);
        w.setVisible(true);
      
        panel.start();
        
    }
}
