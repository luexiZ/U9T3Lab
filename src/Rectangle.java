import java.awt.Graphics;

/**
 * Class Rectangle:  inherits from Shape and draws a rectangle
 * @author Barb Ericson
 */
public class Rectangle extends Shape
{
  /** Constructor */
  public Rectangle()
  {
    super();  // call parent constructor (note the parent's constructor has no parameters)
  }

  /** Draw the shape
   * @param g   the graphics context on which to draw
   */
  @Override
  public void draw(Graphics g)
  {
    // set the color
    g.setColor(getColor());
    
    // draw the rectangle given the top left point and width and height
    g.drawRect(getMinX(), getMinY(), getWidth(), getHeight()); // the getter methods here are INHERITED FROM SHAPE!
  }
}


