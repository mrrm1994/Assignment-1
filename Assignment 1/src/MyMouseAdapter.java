import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JFrame;
public class MyMouseAdapter extends MouseAdapter {
    private Random generator = new Random();
  
  
    public void mousePressed(MouseEvent e) {
      
        switch (e.getButton()) {
        case 1:        //Left mouse button
            Component c = e.getComponent();
            while (!(c instanceof JFrame)) {
                c = c.getParent();
                if (c == null) {
                    return;
                }
            }
           
            JFrame myFrame = (JFrame) c;
            MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
            Insets myInsets = myFrame.getInsets();
            int x1 = myInsets.left;
            int y1 = myInsets.top;
            e.translatePoint(-x1, -y1);
            int x = e.getX();
            int y = e.getY();
            myPanel.x = x;
            myPanel.y = y;
            myPanel.mouseDownGridX = myPanel.getGridX(x, y);
            myPanel.mouseDownGridY = myPanel.getGridY(x, y);
            myPanel.repaint();
            break;
        case 3:        //Right mouse button
            Component d = e.getComponent();
            while (!(d instanceof JFrame)) {
                d = d.getParent();
                if (d == null) {
                    return;
                }
            }
           
            JFrame myFrame2 = (JFrame) d;
            MyPanel myPanel2 = (MyPanel) myFrame2.getContentPane().getComponent(0);
            Insets myInsets2 = myFrame2.getInsets();
            int x3 = myInsets2.left;
            int y3 = myInsets2.top;
            e.translatePoint(-x3, -y3);
            int x2 = e.getX();
            int y2 = e.getY();
            myPanel2.x = x2;
            myPanel2.y = y2;
            myPanel2.mouseDownGridX = myPanel2.getGridX(x2, y2);
            myPanel2.mouseDownGridY = myPanel2.getGridY(x2, y2);
            myPanel2.repaint();
            break;
        default:    //Some other button (2 = Middle mouse button, etc.)
            //Do nothing
            break;
        }
    }
  
  
    public void mouseReleased(MouseEvent e) {
        switch (e.getButton()) {
        case 1:        //Left mouse button
            Component c = e.getComponent();
            while (!(c instanceof JFrame)) {
                c = c.getParent();
                if (c == null) {
                    return;
                }
            }
          
          
            JFrame myFrame = (JFrame)c;
            MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
            Insets myInsets = myFrame.getInsets();
            int x1 = myInsets.left;
            int y1 = myInsets.top;
            e.translatePoint(-x1, -y1);
            int x = e.getX();
            int y = e.getY();
            myPanel.x = x;
            myPanel.y = y;
            int gridX = myPanel.getGridX(x, y);
            int gridY = myPanel.getGridY(x, y);
         
          
            if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
                //Had pressed outside
                //Do nothing
               
            } else {
                if ((gridX == -1) || (gridY == -1)) {
                    //Is releasing outside
                    //Do nothing
                } else {
                  
                  
                    /* if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
                        //Released the mouse button on a different cell where it was pressed
                        //Do nothing
                    } else {
                        //Released the mouse button on the same cell where it was pressed */
                  
                  
                    // LAB QUESTION 6 CODED BELOW.
                  
                    if(gridY == 10){
                      
                        for (int i = 4; i <= 7 - 1; i++) {
                            for (int j = 4; j <= 7 - 1; j++) {
                          
                            Color newColor = null;
                            switch (generator.nextInt(5)) {
                            case 0:
                                newColor = Color.YELLOW;
                                break;
                            case 1:
                                newColor = Color.MAGENTA;
                                break;
                            case 2:
                                newColor = Color.BLACK;
                                break;
                            case 3:
                                newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
                                break;
                            case 4:
                                newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
                                break;
                            }
                          
                            if(!myPanel.colorArray[i][j].equals(newColor)){
                                myPanel.colorArray[i][j] = newColor;
                                myPanel.repaint();}
                          
                                }
                            }
                        }
                  
                    // LAB QUESTION 6 CODE ENDS HERE.
                  
                    else
                  
                    // LAB QUESTION 3 CODED BELOW.
                  
                        if(gridX == 0 && gridY > 0){
                          
                            for (int i = 1; i <= 10 - 1; i++) {
                              
                                Color newColor = null;
                                switch (generator.nextInt(5)) {
                                case 0:
                                    newColor = Color.YELLOW;
                                    break;
                                case 1:
                                    newColor = Color.MAGENTA;
                                    break;
                                case 2:
                                    newColor = Color.BLACK;
                                    break;
                                case 3:
                                    newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
                                    break;
                                case 4:
                                    newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
                                    break;
                                }
                              
                                if(!myPanel.colorArray[i][myPanel.mouseDownGridY].equals(newColor)){
                                    myPanel.colorArray[i][myPanel.mouseDownGridY] = newColor;
                                    myPanel.repaint();}
                              
                            }
                        }
                      
                        // LAB QUESTION 3 ENDS HERE.
                      
                        else
                          
                        // LAB QUESTION 4 CODED BELOW.  
                          
                        if(gridY == 0 && gridX > 0){
                          
                            for (int j = 1; j <= 10 - 1; j++) {
                              
                                Color newColor = null;
                                switch (generator.nextInt(5)) {
                                case 0:
                                    newColor = Color.YELLOW;
                                    break;
                                case 1:
                                    newColor = Color.MAGENTA;
                                    break;
                                case 2:
                                    newColor = Color.BLACK;
                                    break;
                                case 3:
                                    newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
                                    break;
                                case 4:
                                    newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
                                    break;
                                }
                              
                                if(!myPanel.colorArray[myPanel.mouseDownGridX][j].equals(newColor)){
                                    myPanel.colorArray[myPanel.mouseDownGridX][j] = newColor;
                                    myPanel.repaint();}
                              
                            }
                        }
                      
                        // LAB QUESTION 4 ENDS HERE.
                      
                        else
                          
                        // LAB QUESTION 5 CODED BELOW.
                          
                            if(gridY == 0 && gridX == 0){
                              
                                for (int i = 1; i <= 10 - 1; i++) {
                                    for (int j = 1; j <= 10 - 1; j++) {
                                  
                                    Color newColor = null;
                                    switch (generator.nextInt(5)) {
                                    case 0:
                                        newColor = Color.YELLOW;
                                        break;
                                    case 1:
                                        newColor = Color.MAGENTA;
                                        break;
                                    case 2:
                                        newColor = Color.BLACK;
                                        break;
                                    case 3:
                                        newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
                                        break;
                                    case 4:
                                        newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
                                        break;
                                    }
                                  
                                    if(!myPanel.colorArray[i][j].equals(newColor)){
                                        myPanel.colorArray[i][j] = newColor;
                                        myPanel.repaint();}
                                  
                                        }
                                    }
                                }
                      
                        // LAB QUESTION 5 CODE ENDS HERE.
                      
                            else      
                              
                        if ((gridX == 0) || (gridY == 0)) {
                            //On the left column and on the top row... do nothing
                        }
                      
                      
                        else {
                            //On the grid other than on the left column and on the top row:
                            Color newColor = null;
                            switch (generator.nextInt(5)) {
                            case 0:
                                newColor = Color.YELLOW;
                                break;
                            case 1:
                                newColor = Color.MAGENTA;
                                break;
                            case 2:
                                newColor = Color.BLACK;
                                break;
                            case 3:
                                newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
                                break;
                            case 4:
                                newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
                                break;
                            }
                          
                            // LAB QUESTION 2, CELL WILL NEVER BE REPAINTED WITH THE SAME COLOR NOW.
                          
                            if(!myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(newColor)){
                            myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
                            myPanel.repaint();}
                          
                          
                        }
                    }
                }
            //}
            myPanel.repaint();
            break;
           
        // LAB QUESTION 7 CODED BELOW.
           
        case 3:        //Right mouse button
            Component d = e.getComponent();
            while (!(d instanceof JFrame)) {
                d = d.getParent();
                if (d == null) {
                    return;
                }
            }
           
            JFrame myFrame2 = (JFrame) d;
            MyPanel myPanel2 = (MyPanel) myFrame2.getContentPane().getComponent(0);
            Insets myInsets2 = myFrame2.getInsets();
            int x3 = myInsets2.left;
            int y3 = myInsets2.top;
            e.translatePoint(-x3, -y3);
            int x2 = e.getX();
            int y2 = e.getY();
            myPanel2.x = x2;
            myPanel2.y = y2;
            myPanel2.mouseDownGridX = myPanel2.getGridX(x2, y2);
            myPanel2.mouseDownGridY = myPanel2.getGridY(x2, y2);
            myPanel2.repaint();
           
            if ((myPanel2.mouseDownGridX == -1) || (myPanel2.mouseDownGridY == -1)) {
                //Had pressed outside
                     for (int i = 1; i <= 10 - 1; i++) {
                       for (int j = 1; j <= 10 - 1; j++) {
                     
                       Color newColor = null;
                       switch (generator.nextInt(3)) {
                       case 0:
                           newColor = Color.RED;
                           break;
                       case 1:
                           newColor = Color.BLUE;
                           break;
                       case 2:
                           newColor = Color.GREEN;
                           break;}
                 
                   if(!myPanel2.colorArray[i][j].equals(newColor)){
                       myPanel2.colorArray[i][j] = newColor;
                       myPanel2.repaint();}
                 
                       }
                   }
            }
           
            break;
           
            // LAB QUESTION 7 CODE ENDS HERE.
           
        default:    //Some other button (2 = Middle mouse button, etc.)
            //Do nothing
            break;
        }
    }
}
//