import java.awt.Graphics;

/**
 * Class Oval:  inherits from Shape and handles oval shapes
 * @author Barb Ericson
 */
public class Oval extends Shape
{
  /** Constructor */
  public Oval()
  {
    super();  // call parent constructor (note the parent's constructor has no parameters)
  }

  /**
   * Draw the shape
   * @param g   the graphics context to draw to
   */
  @Override
  public void draw(Graphics g)
  {
    // set the color to draw the shape in
    g.setColor(getColor());
    
    // draw the oval given the top left corner of the enclosing
    // rectangle and the width and height
    g.drawOval(getMinX(), getMinY(), getWidth(), getHeight()); // the getter methods here are INHERITED FROM SHAPE!
  }
}


