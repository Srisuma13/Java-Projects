package applets;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class TicTac extends Applet implements ActionListener{
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
	int xcount[],ocount[],flagx=0,flago=0;
	TextField t1,t0;Label l1,l0;
	GridLayout g;
	Panel p;
	int flag=0;
	public void init() {
		//this.setFont(new Font("SansSerif",Font.BOLD,50));
		setLayout(null);
		setBackground(Color.black);
		setForeground(Color.WHITE);
		xcount=new int[9];
		ocount=new int[9];
		for(int i=0;i<9;i++)
		{
			xcount[i]=0;ocount[i]=0;
		}
		b10=new Button("START");
		b10.setForeground(Color.black);
		b10.setBounds(400,50,200,50);
		b11=new Button("RESET");
		b11.setForeground(Color.black);
		b11.setBounds(700,50,200,50);
		add(b10);add(b11);
		b10.addActionListener(this);
		b11.addActionListener(this);
		l1=new Label("WINNER");
		l1.setFont(new Font("SansSerif",Font.BOLD,50));
		l1.setBounds(1000,300,200,50);
		t1=new TextField(100);
		t1.setFont(new Font("SansSerif",Font.BOLD,50));
		t1.setEditable(false);
		t1.setBounds(1100,400,100,50);
		add(l1);add(t1);
		b1 = new Button("1");
		b1.addActionListener(this);
		b2 = new Button("2");
		b2.addActionListener(this);
		b3 = new Button("3");
		b3.addActionListener(this);
		b4 = new Button("4");
		b4.addActionListener(this);
		b5 = new Button("5");
		b5.addActionListener(this);
		b6 = new Button("6");
		b6.addActionListener(this);
		b7 = new Button("7");
		b7.addActionListener(this);
		b8 = new Button("8");
		b8.addActionListener(this);
		b9 = new Button("9");
		b9.addActionListener(this);

		p=new Panel();
		p.setForeground(Color.black);
		p.setFont(new Font("SansSerif",Font.BOLD,50));
		g = new GridLayout(4,4,5,5);
		p.setLayout(g);
		p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);p.add(b6);p.add(b7);p.add(b8);p.add(b9);
		p.setBounds(400,200,500,500);
		this.add(p);
		
	}
	public void check()
	{
		for(int i=0;i<9;i=i+3)
			if((xcount[i]==1)&&(xcount[i+1]==1)&&(xcount[i+2]==1))
				flagx=1;
		for(int i=0;i<3;i++)
			if((xcount[i]==1)&&(xcount[i+3]==1)&&(xcount[i+6]==1))
				flagx=1;
	    if(((xcount[0]==1)&&(xcount[4]==1)&&(xcount[8]==1))||((xcount[2]==1)&&(xcount[4]==1)&&(xcount[6]==1)))
	    	flagx=1;
	    //ocount
	    for(int i=0;i<9;i=i+3)
			if((ocount[i]==1)&&(ocount[i+1]==1)&&(ocount[i+2]==1))
				flago=1;
		for(int i=0;i<3;i++)
			if((ocount[i]==1)&&(ocount[i+3]==1)&&(ocount[i+6]==1))
				flago=1;
	    if(((ocount[0]==1)&&(ocount[4]==1)&&(ocount[8]==1))||((ocount[2]==1)&&(ocount[4]==1)&&(ocount[6]==1)))
	    	flago=1;
	    
	}
	public void actionPerformed(ActionEvent e)
	{
		if(b10==e.getSource())
		{
		if(e.getSource()==b1 || e.getSource()==b2 ||e.getSource()==b3 ||e.getSource()==b4 ||e.getSource()==b5 ||e.getSource()==b6 ||e.getSource()==b7 ||e.getSource()==b8 ||e.getSource()==b9 )
		{
			if(flag==0)
				{flag=1; t0.setText("X");}
			else
				{flag=0;t0.setText("O");}
			
		}
		if(e.getSource()==b1)
		{
			if(flag==0)
				{
					b1.setLabel("O");
					ocount[0]=1;
				}
			else
				{
				b1.setLabel("X");
				xcount[0]=1;
				}
			check();
			if(flagx==1)
			{
				t1.setText("X");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			if(flago==1)
			{
				t1.setText("Y");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			
		}
		if(e.getSource()==b2)
		{
			if(flag==0)
				{b2.setLabel("O");ocount[1]=1;}
			else
				{b2.setLabel("X");xcount[1]=1;}
			check();
			if(flagx==1)
			{
				t1.setText("X");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			if(flago==1)
			{
				t1.setText("Y");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			
		}if(e.getSource()==b3)
		{
			if(flag==0)
				{b3.setLabel("O");ocount[2]=1;}
			else
				{b3.setLabel("X");xcount[2]=1;}
			check();
			if(flagx==1)
			{
				t1.setText("X");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			if(flago==1)
			{
				t1.setText("Y");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			
		}if(e.getSource()==b4)
		{
			if(flag==0)
				{b4.setLabel("O");ocount[3]=1;}
			else
				{b4.setLabel("X");xcount[3]=1;}
			check();
			if(flagx==1)
			{
				t1.setText("X");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			if(flago==1)
			{
				t1.setText("Y");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			
		}if(e.getSource()==b5)
		{
			if(flag==0)
				{b5.setLabel("O");ocount[4]=1;}
			else
				{b5.setLabel("X");xcount[4]=1;}
			check();
			if(flagx==1)
			{
				t1.setText("X");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			if(flago==1)
			{
				t1.setText("Y");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			
		}if(e.getSource()==b6)
		{
			if(flag==0)
				{b6.setLabel("O");ocount[5]=1;}
			else
				{b6.setLabel("X");xcount[5]=1;}
			check();
			if(flagx==1)
			{
				t1.setText("X");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			if(flago==1)
			{
				t1.setText("Y");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			
		}if(e.getSource()==b7)
		{
			if(flag==0)
				{b7.setLabel("O");ocount[6]=1;}
			else
				{b7.setLabel("X");xcount[6]=1;}
			check();
			if(flagx==1)
			{
				t1.setText("X");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			if(flago==1)
			{
				t1.setText("Y");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			
		}if(e.getSource()==b8)
		{
			if(flag==0)
				{b8.setLabel("O");ocount[7]=1;}
			else
				{b8.setLabel("X");xcount[7]=1;}
			check();
			if(flagx==1)
			{
				t1.setText("X");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			if(flago==1)
			{
				t1.setText("Y");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			
		}
		if(e.getSource()==b9)
		{
			if(flag==0)
				{b9.setLabel("O");ocount[8]=1;}
			else
				{b9.setLabel("X");xcount[8]=1;}
			check();
			if(flagx==1)
			{
				t1.setText("X");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			if(flago==1)
			{
				t1.setText("Y");
				b1.setLabel(" ");
				b2.setLabel(" ");
				b3.setLabel(" ");
				b4.setLabel(" ");
				b5.setLabel(" ");
				b6.setLabel(" ");
				b7.setLabel(" ");
				b8.setLabel(" ");
				b9.setLabel(" ");
			}
			
		}
		
	}
		else if(b11==e.getSource())
		{
			b1.setLabel(" ");
			b2.setLabel(" ");
			b3.setLabel(" ");
			b4.setLabel(" ");
			b5.setLabel(" ");
			b6.setLabel(" ");
			b7.setLabel(" ");
			b8.setLabel(" ");
			b9.setLabel(" ");
		}
	}

}
