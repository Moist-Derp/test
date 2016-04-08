package test;

import java.applet.*;
import java.awt.*;

public class GUI extends Applet 
{
   public void paint(Graphics g) {
      g.setColor(Color.red);
      g.drawRect(10,10, 100,50);
   }
}