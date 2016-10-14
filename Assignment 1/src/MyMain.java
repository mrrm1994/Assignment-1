import javax.swing.JFrame;

public class MyMain {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Mine Sweeper");
        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myFrame.setLocation(0, 0);
        myFrame.setSize(800, 800);

        MyPanel myPanel = new MyPanel();
        myFrame.add(myPanel);

        MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
        myFrame.addMouseListener(myMouseAdapter);

        myFrame.setVisible(true);
    }
  
} 