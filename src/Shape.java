import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

/**
 * Class Shape:  class for shapes that can be represented with 2 points
 * @author Barb Ericson
 */
public class Shape
{
  // public constants
  public static final String RECTANGLE = "Rectangle"; // constant for rectangle
  public static final String OVAL = "Oval";           // constant for oval
  public static final String ARC = "Acr";
  public static final String LINE = "Line";

  // private instance variables
  private Color color; // color to draw shape in
  private Point p1; // first point; a Point object has an x and y attribute, e.g. p1.x and p1.y
  private Point p2; // second point; a Point object has an x and y attribute, e.g. p2.x and p2.y

  /** Constructor */
  public Shape()
  {
    color = Color.black;
    p1 = new Point();
    p2 = new Point();
  }
  
  public Color getColor()
  {
    return color;
  }

  /**
   * Method to get minimum x value of the bounding rectangle
   * @return  the minimum x value of the two points that define the shape
   */
  public int getMinX()
  {
    return Math.min(p1.x, p2.x);
  }
  
  /**
   *  Method to get the minimum y value of the bounding rectangle
   *  @return   the minimum y value of the two points that define the shape
   */
  public int getMinY()
  {
    return Math.min(p1.y, p2.y);
  }
  
  /**
   * Method to get the width of the bounding rectangle
   * @return    the width of the bounding rectangle
   */
  public int getWidth()
  {
    return Math.max(p1.x, p2.x) - getMinX() + 1;
  }
  
  /**
   * Method to get the height of the bounding rectangle
   * @return    the height of the bounding rectangle
   */
  public int getHeight()
  {
    return Math.max(p1.y, p2.y) - getMinY() + 1;
  }
  
  /**
   * Method to set the point values for point1 that defines the shape
   * @param newX    the new x value for point 1
   * @param newY    the new y value for point 1
   */
  public void setPoint1Values(int newX, int newY)
  {
    p1.x = newX;
    p1.y = newY;
  }

  public Point pt1()
  {
      return p1;
  }
  public Point pt2()
  {
      return p2;
  }
  
  /**
   * Method to set the point values for point2 that defines the shape
   * @param newX    the new x value for point 2
   * @param newY    the new y value for point 2
   */
  public void setPoint2Values(int newX, int newY)
  {
    p2.x = newX;
    p2.y = newY;
  }
  
  /** Method to draw the shape given the graphics context
   *  NOTE!!!!  This method does NOT do anything in its current implementation;
   *  IT SHOULD BE OVERWRITTEN by each subclass with a class specific implementation!!!
   *
   *  @param g   the graphics context to draw the shape on
   */
  public void draw(Graphics g)
  {
    System.out.println("This method should be overridden by subclasses because");
    System.out.println("a generic Shape object does not know how to draw itself!");
  }
}


