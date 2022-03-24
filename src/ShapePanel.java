import javax.swing.JPanel;
import java.awt.BorderLayout;

/**
 * Class ShapePanel:  holds a ShapeComponent and a ButtonPanel for drawing shapes
 * @author Barb Ericson
 */
public class ShapePanel extends JPanel
{
  private ShapeIComponent shapeComponent;
  private ButtonPanel buttonPanel;

  /** A constructor that takes no arguments */
  public ShapePanel ()
  {
    shapeComponent = new ShapeIComponent(500, 500);
    buttonPanel = new ButtonPanel(shapeComponent);
    init(); // call helper method
  }

  /* private helper method to initialize the panel */
  private void init()
  {
    // set layout to use a border layout
    setLayout(new BorderLayout()); // INHERITED METHOD from a class in JPanel's inheritance hierarchy!
    
    // add the button panel to the north section of the border layout
    add("North", buttonPanel); // INHERITED METHOD from a class in JPanel's inheritance hierarchy!
    
    // add the shape canvas to the center section of the border layout
    add("Center", shapeComponent); // INHERITED METHOD from a class in JPanel's inheritance hierarchy!
  } 
}