
package Kermo_Evolution;

import java.awt.*;
import javax.swing.*;

public class RasterDisplay 
{
    public static void main (String [] args)
    {
        JFrame window = new JFrame();
        window.setSize(500,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        Display d = new Display();
        window.add(d);
        window.setVisible(true);
       // d.repaint();
        
        
    }
    
    static class Display extends JPanel
    {
        Display()
        {
        }
        public void paintComponent (Graphics g)
        {
            g.setColor(Color.RED);
            for (int y = 0; y < 450; ++y)
                for (int x = 0; x < 450; ++x)
                    g.fillRect(x, y, 1, 1);
        }
    }
}