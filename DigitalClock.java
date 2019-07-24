import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.*;
import java.io.*;
import java.lang.*;
class DigitalClock extends Frame implements Runnable
{
	private static int FrameHeight=1600,FrameWidth=1600;
	int hour,min,sec;
	int flag=0;
	DigitalClock()
	{
	    this.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){System.exit(0);}});
	}
	public void run()
	{
		try
		{
			while(true)
			{
			getCurrentTime();
			repaint();
			Thread.sleep(500);
			}
		}
		catch(InterruptedException e)
		{
		}
	}
	void getCurrentTime()
	{
		OffsetTime o=OffsetTime.now();
		hour=o.getHour();
		if(hour>12)
		{hour-=12; flag=1;}
		min=o.getMinute();
		sec=o.getSecond();
	}
	public void paint(Graphics g)
	{
		g.setFont(new Font("Georgia", Font.PLAIN, 100));
		g.drawString("DIGITAL  CLOCK",300,150);
		//for hours
		if(hour==1)
		{
			g.drawLine(100,300,200,300);
			g.drawLine(100,400,200,400);
			g.drawLine(100,300,100,400);
			g.drawLine(200,300,200,400);
			g.drawLine(300,300,300,400);
		}
		else if(hour==2)
		{
			g.drawLine(100,300,200,400);
			g.drawLine(100,400,200,400);
			g.drawLine(100,300,100,400);
			g.drawLine(200,300,200,400);
			g.drawLine(250,300,350,300);
			g.drawLine(350,300,350,350);
			g.drawLine(250,350,350,350);
			g.drawLine(250,350,250,400);
			g.drawLine(250,400,350,400);
		}
		else if(hour==3)
		{
			g.drawLine(100,300,200,300);
			g.drawLine(100,400,200,400);
			g.drawLine(100,300,100,400);
			g.drawLine(200,300,200,400);
			g.drawLine(250,300,350,400);
			g.drawLine(350,300,350,450);
			g.drawLine(250,450,350,450);
			g.drawLine(350,450,350,400);
			g.drawLine(250,400,350,400);
		}
		else if(hour==4)
		{
			g.drawLine(100,300,200,300);
			g.drawLine(100,400,200,400);
			g.drawLine(100,300,100,400);
			g.drawLine(200,300,200,400);
			g.drawLine(250,300,350,350);
			g.drawLine(350,300,350,400);
			g.drawLine(250,350,350,350);
			
		}else if(hour==5)
		{
			g.drawLine(100,300,200,300);
			g.drawLine(100,400,200,400);
			g.drawLine(100,400,100,400);
			g.drawLine(200,300,200,400);
			g.drawLine(250,300,350,350);
			g.drawLine(250,300,350,300);
			g.drawLine(250,350,350,350);
			g.drawLine(350,350,350,400);
			g.drawLine(250,400,350,400);
		}else if(hour==6)
		{
			g.drawLine(100,300,200,300);
			g.drawLine(100,400,200,400);
			g.drawLine(100,300,100,400);
			g.drawLine(200,300,200,400);
			g.drawLine(250,300,250,400);
			g.drawLine(250,300,350,300);
			g.drawLine(250,350,350,350);
			g.drawLine(350,350,350,400);
			g.drawLine(250,400,350,400);
		}
		else if(hour==7)
		{
			g.drawLine(100,300,200,300);
			g.drawLine(100,400,200,400);
			g.drawLine(100,300,100,400);
			g.drawLine(200,300,200,400);
			g.drawLine(250,300,350,300);
			g.drawLine(350,300,350,400);
			
		}else if(hour==8)
		{
			g.drawLine(100,300,200,300);
			g.drawLine(100,400,200,400);
			g.drawLine(100,300,100,400);
			g.drawLine(200,300,200,400);
			g.drawLine(250,300,350,300);
			g.drawLine(250,300,250,400);
			g.drawLine(250,350,350,350);
			g.drawLine(350,300,350,400);
			g.drawLine(250,400,350,400);
		}
		else if(hour==9)
		{
			g.drawLine(100,300,200,300);
			g.drawLine(100,400,200,400);
			g.drawLine(100,300,100,400);
			g.drawLine(200,300,200,400);
			g.drawLine(250,300,350,300);
			g.drawLine(250,300,250,350);
			g.drawLine(250,350,350,350);
			g.drawLine(350,300,350,400);
			g.drawLine(250,400,350,400);
		}else if(hour==10)
		{
			g.drawLine(150,300,150,400);
			g.drawLine(250,300,350,300);
			g.drawLine(250,300,250,400);
			g.drawLine(350,300,350,400);
			g.drawLine(250,400,350,400);
		}
		else if(hour==11)
		{
			g.drawLine(150,300,150,400);
			g.drawLine(300,300,300,400);
		}
		else if(hour==12)
		{
			g.drawLine(150,300,150,400);
			g.drawLine(250,300,350,300);
			g.drawLine(350,300,350,350);
			g.drawLine(250,350,350,350);
			g.drawLine(250,350,250,400);
			g.drawLine(250,400,350,400);
			
		}
		//minutes 
		g.fillOval(400,320,10,10);
		g.fillOval(400,370,10,10);
		if(min/10==0)
		{
			g.drawLine(450,300,550,300);
			g.drawLine(450,300,450,400);
			g.drawLine(550,300,550,400);
			g.drawLine(450,400,550,400);
		}
		if(min%10==0)
		{
			g.drawLine(600,300,600,400);
			g.drawLine(700,300,700,400);
			g.drawLine(600,300,700,300);
			g.drawLine(600,400,700,400);
		}
		
		if(min%10==1)
		{
			g.drawLine(650,300,650,400);
		}
		if(min/10==1)
		{
			g.drawLine(500,300,500,400);
		}
		if(min%10==2)
		{
			g.drawLine(600,300,700,300);
			g.drawLine(600,400,700,400);
			g.drawLine(600,350,700,350);
			g.drawLine(600,350,600,400);
			g.drawLine(700,300,700,350);
			
		}if(min/10==2)
		{
			g.drawLine(450,300,550,300);
			g.drawLine(450,400,550,400);
			g.drawLine(450,350,550,350);
			g.drawLine(450,350,450,400);
			g.drawLine(550,300,550,350);
		}
		if(min/10==3)
		{
			g.drawLine(450,300,550,300);
			g.drawLine(450,400,550,400);
			g.drawLine(450,350,550,350);
			g.drawLine(550,300,550,400);
		}
		if(min%10==3)
		{
			g.drawLine(600,300,700,300);
			g.drawLine(600,400,700,400);
			g.drawLine(600,350,700,350);
			g.drawLine(700,300,700,400);
		}
		if(min/10==4)
		{
			g.drawLine(450,350,550,350);
			g.drawLine(450,300,450,350);
			g.drawLine(550,300,550,400);
		}
		
		if(min%10==4)
		{
			g.drawLine(600,350,700,350);
			g.drawLine(600,300,600,350);
			g.drawLine(700,300,700,400);
		}
		if(min%10==5)
		{
			g.drawLine(600,300,700,300);
			g.drawLine(600,400,700,400);
			g.drawLine(600,350,700,350);
			g.drawLine(700,350,700,400);
			g.drawLine(600,300,600,350);
		}
		if(min/10==5)
		{
			g.drawLine(450,300,550,300);
			g.drawLine(450,400,550,400);
			g.drawLine(450,350,550,350);
			g.drawLine(550,350,550,400);
			g.drawLine(450,300,450,350);
		}
		if(min%10==6)
		{
			g.drawLine(600,300,700,300);
			g.drawLine(600,400,700,400);
			g.drawLine(600,350,700,350);
			g.drawLine(700,350,700,400);
			g.drawLine(600,300,600,400);
		}
		if(min/10==6)
		{
			g.drawLine(450,300,550,300);
			g.drawLine(450,400,550,400);
			g.drawLine(450,350,550,350);
			g.drawLine(550,350,550,400);
			g.drawLine(450,300,450,400);
		}
		if(min%10==7)
		{
			g.drawLine(600,300,700,300);
			g.drawLine(700,300,700,400);
		}
		
		if(min%10==8)
		{
			g.drawLine(600,300,700,300);
			g.drawLine(600,400,700,400);
			g.drawLine(600,350,700,350);
			g.drawLine(700,300,700,400);
			g.drawLine(600,300,600,400);
		}
		
		if(min%10==9)
		{
			g.drawLine(600,300,700,300);
			g.drawLine(600,400,700,400);
			g.drawLine(600,350,700,350);
			g.drawLine(700,300,700,400);
			g.drawLine(600,300,600,350);
		}
		
		
		g.fillOval(750,320,10,10);
		g.fillOval(750,370,10,10);
		
		//seconds
		
		if(sec/10==0)
		{
			g.drawLine(800,300,900,300);
			g.drawLine(800,300,800,400);
			g.drawLine(900,300,900,400);
			g.drawLine(800,400,900,400);
		}
		if(sec%10==0)
		{
			g.drawLine(950,300,950,400);
			g.drawLine(1050,300,1050,400);
			g.drawLine(950,300,1050,300);
			g.drawLine(950,400,1050,400);
		}
		
		if(sec%10==1)
		{
			g.drawLine(1000,300,1000,400);
		}
		if(sec/10==1)
		{
			g.drawLine(850,300,850,400);
		}
		if(sec%10==2)
		{
			g.drawLine(950,300,1050,300);
			g.drawLine(950,400,1050,400);
			g.drawLine(950,350,1050,350);
			g.drawLine(950,350,950,400);
			g.drawLine(1050,300,1050,350);
			
		}if(sec/10==2)
		{
			g.drawLine(800,300,900,300);
			g.drawLine(800,400,900,400);
			g.drawLine(800,350,900,350);
			g.drawLine(800,350,800,400);
			g.drawLine(900,300,900,350);
		}
		if(sec/10==3)
		{
			g.drawLine(800,300,900,300);
			g.drawLine(800,400,900,400);
			g.drawLine(800,350,900,350);
			g.drawLine(900,300,900,400);
		}
		if(sec%10==3)
		{
			g.drawLine(950,300,1050,300);
			g.drawLine(950,400,1050,400);
			g.drawLine(950,350,1050,350);
			g.drawLine(1050,300,1050,400);
		}
		if(sec/10==4)
		{
			g.drawLine(800,350,900,350);
			g.drawLine(800,300,800,350);
			g.drawLine(900,300,900,400);
		}
		
		if(sec%10==4)
		{
			g.drawLine(950,350,1050,350);
			g.drawLine(950,300,950,350);
			g.drawLine(1050,300,1050,400);
		}
		if(sec%10==5)
		{
			g.drawLine(950,300,1050,300);
			g.drawLine(950,400,1050,400);
			g.drawLine(950,350,1050,350);
			g.drawLine(1050,350,1050,400);
			g.drawLine(950,300,950,350);
		}
		if(sec/10==5)
		{
			g.drawLine(800,300,900,300);
			g.drawLine(800,400,900,400);
			g.drawLine(800,350,900,350);
			g.drawLine(900,350,900,400);
			g.drawLine(800,300,800,350);
		}
		if(sec%10==6)
		{
			g.drawLine(950,300,1050,300);
			g.drawLine(950,400,1050,400);
			g.drawLine(950,300,950,400);
			g.drawLine(1050,350,1050,400);
			g.drawLine(950,350,1050,350);
		}
		if(sec/10==6)
		{
			g.drawLine(800,300,900,300);
			g.drawLine(800,400,900,400);
			g.drawLine(800,350,900,350);
			g.drawLine(900,350,900,400);
			g.drawLine(800,300,800,400);
		}
		
		if(sec%10==7)
		{
			g.drawLine(950,300,1050,300);
			g.drawLine(1050,300,1050,400);
		}
		
		if(sec%10==8)
		{
			g.drawLine(950,300,1050,300);
			g.drawLine(950,400,1050,400);
			g.drawLine(950,350,1050,350);
			g.drawLine(1050,300,1050,400);
			g.drawLine(950,300,950,400);
		}
		if(sec%10==9)
		{
			g.drawLine(950,300,1050,300);
			g.drawLine(950,400,1050,400);
			g.drawLine(950,350,1050,350);
			g.drawLine(1050,300,1050,400);
			g.drawLine(950,300,950,350);
		}
		if(flag==0)
		{
			g.drawLine(1100,400,1150,300);
			g.drawLine(1150,300,1200,400);
			g.drawLine(1125,350,1175,350);
			g.drawLine(1225,300,1225,400);
			g.drawLine(1325,300,1325,400);
			g.drawLine(1225,300,1275,400);
			g.drawLine(1275,400,1325,300);
			
		}
		else
		{
			g.drawLine(1125,400,1125,300);
			g.drawArc(1075,300,100,50,90,-180);
			g.drawLine(1225,300,1225,400);
			g.drawLine(1325,300,1325,400);
			g.drawLine(1225,300,1275,400);
			g.drawLine(1275,400,1325,300);
		}

	}
	public static void main(String args[])
	{
		DigitalClock d=new DigitalClock();
		Thread t=new Thread(d);
		t.start();
		d.setTitle("DIGITAL CLOCK");
		d.setBackground(Color.pink);
		d.setSize(FrameWidth,FrameHeight);
		d.setVisible(true);
	}
}
	
