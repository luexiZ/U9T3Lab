import javax.swing.JFrame;

public class ShapeRunner
{
  public static void main (String args[])
  {
    // create a frame (main application window)
    JFrame frame = new JFrame();
    
    // create a Shape Panel
    ShapePanel shapePanel = new ShapePanel();
    
    // add the shapePanel to the frame
    frame.add(shapePanel);
    frame.pack();         // shrink to fit preferred size
    frame.setVisible(true); // show the frame

    // set the frame so that when the user closes the window
    // using the X button in the top right, the program stops
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
}