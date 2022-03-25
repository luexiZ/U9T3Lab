import java.awt.Graphics;

public class Line extends Shape{

    public Line(){
        super();
    }

    public void draw(Graphics g)
    {
        // set the color
        g.setColor(getColor());

        // draw the rectangle given the top left point and width and height
        g.drawLine(pt1().x, pt1().y, pt2().x, pt2().y); // the getter methods here are INHERITED FROM SHAPE!
    }
}
