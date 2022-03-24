import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
 * Class ShapeIComponent:  holds shapes in a custom drawn area and handles the shape interface
 * Copyright Georgia Institute of Technology 2007
 * @author Barb Ericson ericson@cc.gatech.edu
 */
public class ShapeIComponent extends JComponent
{
  private ArrayList<Shape> shapes; // list of shapes
  private Shape currentShape; // current shape being dragged
  private String currShapeType; // default shape type
  private int width;
  private int height;
  private Color backgroundColor;
  private Graphics backgroundG;   // graphics context of background image

  /**
   * A constructor that takes the width and height
   * @param width   the width of the canvas
   * @param height  the height of the canvas
   */
  public ShapeIComponent(int width, int height)
  {
    this.width = width;
    this.height = height;
    shapes = new ArrayList<Shape>();
    currShapeType = Shape.RECTANGLE;
    backgroundColor = Color.YELLOW;
    
    init();  // call helper method to do rest of setup
  }

  /* private helper method to initialize the shape component size and set the mouse listeners */
  private void init()
  {
    // !!! THESE ARE ALL CALLS TO METHODS INHERITED FROM JComponent !!!

    // set the size of the component to the current width and height
    setSize(new Dimension(width, height));
    setMinimumSize(new Dimension(width, height));
    setPreferredSize(new Dimension(width, height));
    
    // add the mouse listener and mouse motion listener
    addMouseListener(new MyMouseAdapter());
    addMouseMotionListener(new MyMouseMotionAdapter());
  }
  
  /**
   * Method to add a shape to the shape list
   * @param shape   the shape to add
   */
  public void add(Shape shape)
  {
    // add the shape to the list of shapes
    shapes.add(shape);
    
    // force a repaint to show the new shape
    repaint(); // repaint is an INHERITED METHOD from JComponent!
  }
  
  /**
   * Method to remove a shape given the index
   * @param index   the index of the shape in the shape list that you
   *                wish to remove
   */
  @Override
  public void remove(int index)
  {
    // remove the shape at the given index
    shapes.remove(index);
    
    // force a repaint to show it is gone
    repaint();  // repaint is an INHERITED METHOD from JComponent!
  }
  
  /**
   * Update normally clears the background and calls paint
   * override it here to just call paint
   * @param g   the graphics context on which to draw
   */
  @Override
  public void update(Graphics g)
  {
    paint(g);  // paint is an INHERITED METHOD from JComponent!
  }
  
  /**
   * Method to paint the shape canvas and all objects in it
   * @param g   the graphic context on which to paint
   */
  @Override
  public void paintComponent (Graphics g)
  {
    Shape currShape;
    height = getHeight();
    int width = getWidth();
    
    // clear using the background color
    g.setColor(backgroundColor);
    g.fillRect(0, 0, width, height);
     
    // loop through the shape objects and draw each one
    for (Shape shape : shapes)
    {
      currShape = shape; // update currShape to reference the specific Shape object
      currShape.draw(g); // call draw method on it, passing in g, which is the "graphics context"
                             // that is provided in the parameter of the paintComponent method
    }
  }
  
  /**
   * Set the type of the shape that will be created when the user
   * clicks in the shape canvas.
   * @param shapeType the name of the shape
   */
  public void setShape(String shapeType)
  {
    currShapeType = shapeType;
  }
  
  /** method to move all shapes from the list of shapes
    */
  public void clearShapes()
  {
    shapes.clear();
    repaint(); //repaint is an INHERITED METHOD from JComponent!
  }


  // ------------ "INNER" CLASSES -------------------
  // "inner classes" are an advanced topic beyond the scope of this course!
  // but here an interesting example of having classes nested inside
  // another class; if you are curious, look up inner classes on Oracle's website

  // An inner class for handling the mouse listener interface
  class MyMouseAdapter extends MouseAdapter
  {
    // Method to handle when the user presses down the button
    public void mousePressed(MouseEvent e)
    {
      int currX = e.getX();
      int currY = e.getY();
      
      // create an object of the current shape type
      if (currShapeType.equals(Shape.RECTANGLE))
      {
        currentShape = new Rectangle();
      }
      else if (currShapeType.equals(Shape.OVAL))
      {
        currentShape = new Oval();
      }
      else if (currShapeType.equals(Shape.ARC))
      {
        currentShape = new Arc();
      }
      
      // fill in point1 and point2 in the new shape
      currentShape.setPoint1Values(currX,currY);
      currentShape.setPoint2Values(currX + 1, currY + 1);
      
      // add the shape to the list of shapes
      add(currentShape);
      
      // repaint all
      repaint();
    }
    
    // Method to handle when the user releases the mouse
    public void mouseReleased(MouseEvent e)
    {
      int currX = e.getX();
      int currY = e.getY();
      
      // update the point 2 values
      currentShape.setPoint2Values(currX, currY);
      
      // no current shape being dragged
      currentShape = null;
      
      // repaint
      repaint();
    }
  }

  /** An inner class for handling the mouse motion listener */
  class MyMouseMotionAdapter extends MouseMotionAdapter
  {
    /** Method to handle the drag of a mouse */
    public void mouseDragged(MouseEvent e)
    {
      int currX = e.getX();
      int currY = e.getY();
      
      // set the point 2 values
      currentShape.setPoint2Values(currX, currY);
      
      // repaint
      repaint();
    }
  }
}


