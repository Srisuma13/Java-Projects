import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class  PinBallGame extends Frame
{
 public static void main(String args[])
 {
  world = new PinBallGame();
  world.show();
 }
 
 public static final int FrameWidth = 400;
 public static final int FrameHeight = 400;
 public static PinBallGame world;
 private Vector balls;
 private Vector targets;
 private int score;
 private Label scoreLabel;
 
 public PinBallGame()
 {
   setTitle("PinBall Constructing Kit");
   setSize(FrameWidth,FrameHeight);
   balls = new Vector();
   score =0;
   scoreLabel = new Label("Score = 0");
   add("North",scoreLabel);
   targets = new Vector();
   targets.addElement(new Hole(25,80));
   targets.addElement(new Peg(25,120,100));
   targets.addElement(new Peg(25,160,200));
   targets.addElement(new ScorePad(25,200,100));
   targets.addElement(new ScorePad(25,240,200));
   targets.addElement(new Spring(18,280));
   targets.addElement(new Wall(25,320,2,15));
   targets.addElement(new Wall(50,50,2,350));
   targets.addElement(new Wall(50,50,330,7));
   targets.addElement(new Wall(380,50,2,380));
   targets.addElement(new Hole(100,100));
   targets.addElement(new ScorePad(150,220,100));
   targets.addElement(new Peg(300,140,200));
   targets.addElement(new Spring(120,350));
   addMouseListener(new MouseKeeper());
   addWindowListener(new WindowAdapter()
   {
     public void windowClosing(WindowEvent e)
     {
       System.exit(0);
      }
    });
 }
 synchronized public void addScore(int v)
 {  
  score = score+v;
  scoreLabel.setText("Score = "+score);
 }

 private class  MouseKeeper extends MouseAdapter
 {
  private PinBallTarget element;
  public void mousePressed(MouseEvent e)
  {
   element = null;
   int x = e.getX();
   int y = e.getY(); // Retrives coordinates where mouse is pressed.
   if((x>FrameWidth-50)&&(y>FrameHeight-50))
   {
    PinBall aBall = new PinBall(x,y);
    balls.addElement(aBall);
    Thread th = new PinBallThread(aBall);
    th.start();
   }
   if(x<40)
   {
    switch(y/40)
    {
     case 2: element = new Hole(0,0); break;
     case 3: element = new Peg(0,0,100); break;    
     case 4: element = new Peg(0,0,200); break;
     case 5: element = new ScorePad(0,0,100); break;
     case 6: element = new ScorePad(0,0,200); break;
     case 7: element = new Spring(0,0); break;
     case 8: element = new Wall(0,0,2,15); break;
    }
   }
  }
  public void mouseReleased(MouseEvent e)
  {
   int x = e.getX();
   int y = e.getY();
   if((element != null)&&(x>50))
   {
   element.moveTo(x,y);
   targets.addElement(element);
   repaint();
   }
  }
 }

 private class PinBallThread extends Thread
 {
   private PinBall ball;
  public PinBallThread(PinBall aBall)
  {
   ball = aBall;
  }
  public void run()
  {
   while(ball.y()<FrameHeight)
   {
    ball.move();
    for(int j=0;j<targets.size();j++)
    {
     PinBallTarget target= (PinBallTarget) targets.elementAt(j);
     if(target.intersects(ball))
         target.hitBy(ball);
    }
    repaint();
    try
    {
     sleep(50);
    }
    catch(InterruptedException e){System.exit(0);}
   }
  }
 }

public void paint(Graphics g)
{
  g.setColor(Color.white); // white rectangle for firing balls
 g.fillRect(FrameWidth-50,FrameHeight-50,30,30);
 g.setColor(Color.red);
 g.fillOval(FrameWidth-50,FrameHeight-50,30,30); // Balls
 //System.out.println("No.of Balls "+balls.size());
 for(int i=0; i<balls.size(); i++)
 {
  PinBall aBall = (PinBall) balls.elementAt(i);
      aBall.paint(g);
  if(aBall.y()>FrameHeight)
     balls.removeElementAt(i);
 }
 for(int j=0;j<targets.size();j++)
 {
  PinBallTarget target= (PinBallTarget) targets.elementAt(j);
  target.paint(g);
 }
}
} 

interface PinBallTarget
{
 public boolean intersects(Ball aBall);
 public void moveTo(int x,int y);
 public void paint(Graphics g);
 public void hitBy(Ball aBall);
}

class Spring implements PinBallTarget
{
 private Rectangle bench;
 private int  state =1;
 public Spring(int x,int y)
 {
  bench = new Rectangle(x,y,30,3);
 }
 public void moveTo(int x,int y)
 {
  bench.setLocation(x,y);
 }
 public void paint(Graphics g)
 {
  int x = bench.x; 
  int y = bench.y;
  g.setColor(Color.black);
  if(state==1)
  {
   g.fillRect(x,y,bench.width,bench.height);
   g.drawLine(x,y+3,x+30,y+5);
   g.drawLine(x+30,y+5,x,y+7);
   g.drawLine(x,y+7,x+30,y+9);
   g.drawLine(x+30,y+9,x,y+11);
  }
  else
  {
   g.fillRect(x,y-8,bench.width,bench.height);
   g.drawLine(x,y+5,x+30,y-1);
   g.drawLine(x+30,y-1,x,y+3);
   g.drawLine(x,y+3,x+30,y+7);
   g.drawLine(x+30,y+7,x,y+11);
   state=1;
  }
 }
public boolean intersects(Ball aBall)
{
 return bench.intersects(aBall.location);
}
public void hitBy(Ball aBall)
{
 if(aBall.dy>0)
   aBall.dy = -aBall.dy;
 aBall.dy = aBall.dy-.5;
 state = 2;
}
}

class Wall implements PinBallTarget
{
 public Rectangle location;
 public Wall(int x,int y, int width,int height)
 {
  location = new Rectangle(x,y,width,height);
 }
 public void moveTo(int x,int y)
 {
  location.setLocation(x,y);
 }
 public void paint(Graphics g)
 {
  g.setColor(Color.black);
  g.fillRect(location.x,location.y,location.width,location.height);
 }
 public boolean intersects(Ball aBall)
 {
  return location.intersects(aBall.location);
 }
 public void hitBy(Ball aBall)
 {
  if((aBall.y()<location.y)||(aBall.y()>(location.y+location.height)))
    aBall.dy = -aBall.dy;
  else
    aBall.dx = -aBall.dx;
 }
}

class Hole extends Ball implements PinBallTarget
{
 public Hole(int x,int y)
 {
  super(x,y,12);
//  setColor(Color.black);
 }
 public boolean intersects(Ball aBall)
 {
  return location.intersects(aBall.location);
 }
 public void hitBy(Ball aBall)
 {
  aBall.moveTo(0,PinBallGame.FrameHeight+30);
  aBall.setMotion(0,0);
 }
}

class ScorePad extends Hole
{
 protected int value;
 public ScorePad(int x,int y,int v)
 {
  super(x,y);
  value = v;
 // setColor(Color.red);
 }
 public void hitBy(Ball aBall)
 {
  PinBallGame.world.addScore(value);
 }
 public void paint(Graphics g)
 {
  g.setColor(color);
  g.drawOval(location.x,location.y,location.width,location.height);
  String s = " "+value;
  g.drawString(s,location.x,y()+2);
 }
}

class Peg extends ScorePad
{
 private int state = 1;
 public Peg(int x,int y,int v)
 {
  super(x,y,v);
 }
 public void paint(Graphics g)
 {
  super.paint(g);
  if(state==2)
  {
   g.drawOval(location.x-3,location.y-3,location.width+6,location.height+6);
   state =1;
  }
  else
   g.drawOval(location.x-2,location.y-2,location.width+4,location.height+4);
 }
 public void hitBy(Ball aBall) 
 {
  super.hitBy(aBall);
  aBall.setMotion(-aBall.dy,-aBall.dx);
  while(intersects(aBall))
   aBall.move();
  state = 2;
 }
}