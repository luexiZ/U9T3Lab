import java.awt.Graphics;
public class Arc extends Shape{

    private int startAngle;
    private int arcAngle;
    public Arc(){
        super();
        startAngle = 70;
        arcAngle = 30;
    }

    public void draw(Graphics g)
    {
        // set the color
        g.setColor(getColor());

        // draw the rectangle given the top left point and width and height
        g.drawArc(getMinX(), getMinY(), getWidth(), getHeight(), startAngle, arcAngle); // the getter methods here are INHERITED FROM SHAPE!
    }
}
