import java.awt.*;
public class PinBall extends Ball
{
 public PinBall(int sx,int sy)
 {
  super(sx,sy,10); //starts moving vertically
  setMotion(-2+Math.random()/4,-15);
 }
 private static final double gravityEffect = 0.3;
 public void move()
 {
  dy = dy+gravityEffect;
  super.move();
 }
}

class Ball
{
  protected Rectangle location;
  public double dx,dy;
  protected Color color;
  public Ball(int x,int y,int r)
  {
    location = new Rectangle(x-r,y-r,2*r,2*r);
     dx=0;
     dy=0;
     color = Color.blue;
  }
  public void setMotion(double ndx,double ndy)
  {
   dx=ndx;
   dy = ndy;
  }
  public int x()
  {
   return location.x+radious(); 
  }
  public int y()
  {
   return location.y+radious(); 
  }
  public int radious()
  {
    return location.width/2;
  }
  public double xMotion()
  {
   return dx;
  }
  public double yMotion()
  {
    return dy;
  }
  public void moveTo(int x,int y)
  {
   location.setLocation(x,y);
  }
  public void move()
  {
    location.translate((int)dx,(int)dy);
  }
  public void paint(Graphics g)
  {
    g.setColor(color);
    g.fillOval(location.x,location.y,location.width,location.height);
  }
 }
  
