
package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


public class Gamepanel extends JPanel implements Runnable{
    
    final int originalTileSize = 16; //16x16 pixels
    final int scale = 3;
    final int tileSize = (originalTileSize*scale);
    final int columns = 16;
    final int rows = 12;
    final int WIDTH = tileSize * columns;
    final int HEIGHT = tileSize * rows;
    
    int FPS =60;
    
    Thread gameThread;
    Keys key = new Keys();
    int playerX = 100, playerY=100, playerSpeed=4;
    public Gamepanel()
    
    {
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key);
        this.setFocusable(true);
    }

     public void start()
     {
         gameThread = new Thread(this);
         gameThread.start();
         
     }
    @Override
    public void run() {
        
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null)
        {
            
            
            update();
            repaint();
            
           try
           {
               double remainingTime = nextDrawTime - System.nanoTime();
               remainingTime =remainingTime/1000000000;
               if (remainingTime < 0)
               {
                   remainingTime =0;
               }
               Thread.sleep((long)remainingTime);
               nextDrawTime+=drawInterval;
               
           } catch (InterruptedException e)
           {
               e.printStackTrace();
           }
        }
    }
    
    public void update()
    {
        if (key.up == true)
        {
            playerY -=playerSpeed;
         
        } else if(key.down ==true)
        {
             playerY +=playerSpeed;
        
        }else if(key.right ==true)
        {
            playerX+=playerSpeed;
            
        }else if(key.left ==true)
        {
            playerX-=playerSpeed;
            
        }
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        
       g2.fillRect(playerX, playerY, tileSize, tileSize);
       g2.dispose();
       
    }
}
