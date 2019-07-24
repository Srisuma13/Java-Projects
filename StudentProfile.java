import java.awt.*;
import java.awt.event.*;
import java.io.*;
class StudentProfile extends Frame implements ActionListener,ItemListener
{
	Label l1,l2,l3,l4,l5,l6,l7,l8;
	TextField t1,t2,t3,t4,t5,t6,t7,t8;
	List lt;
	Checkbox c1,c2;
	CheckboxGroup c;
	Button b1;
	Panel p1;
	StudentProfile()
	{
		setLayout(null);
		l1=new Label("First Name");
		l8=new Label("Last Name");
		l2=new Label("Student-id");
		l3=new Label("Gender");
		l4=new Label("Email-Id");
		l5=new Label("Contact-No");
		l6=new Label("Address");
		l7=new Label("State");
		lt=new List(20,true);
		t1=new TextField(30);t2=new TextField(30);t3=new TextField(30);
		t4=new TextField(30);t5=new TextField(30);t6=new TextField(30);
		t7=new TextField(30);t8=new TextField(30);
		b1=new Button("submit");
		c=new CheckboxGroup();
		c1=new Checkbox("Male",false,c);
		c2=new Checkbox("Female",false,c);
		lt.add("Telangana");
		lt.add("AndhraPradesh");
		lt.add("Kerala");
		lt.add("TamilNadu");
		lt.add("Orissa");
		lt.add("Jammu & Kashmir");
		lt.add("UttarPradesh");
		lt.add("Bihar");
		lt.add("Gujarath");
		lt.add("Maharastra");
		lt.add("Assam");
		lt.add("Delhi");
		lt.add("Rajasthan");
		lt.add("Karnataka");
		lt.add("UttarPradesh");
		lt.add("MadyaPradesh");
		lt.add("Sikkim");
		lt.add("WestBengal");
		lt.add("himachal Pradesh");
		lt.add("Goa");
		p1=new Panel(new GridLayout(8,2,2,2));
		p1.add(l1);p1.add(t1);p1.add(l8);p1.add(t8);p1.add(l2);p1.add(t2);p1.add(l3);p1.add(t3);p1.add(l4);p1.add(t4);
		p1.add(l5);
		p1.add(t5);p1.add(l6);p1.add(t6);p1.add(l7);p1.add(t7);
		p1.setBounds(100,100,400,400);
		add(p1);
		lt.setBounds(520,450,200,200);
		add(lt);
		c1.setBounds(550,270,80,20);
		c2.setBounds(650,270,80,20);
		add(c1);add(c2);
		b1.setBounds(300,550,100,40);
		add(b1);
		b1.addActionListener(this);
		lt.addActionListener(this);
		c1.addItemListener(this);
		c2.addItemListener(this);
		this.addWindowListener(new WindowAdapter()
		{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
		});
	}
	public void actionPerformed(ActionEvent e)
	{
	if(lt==e.getSource())
	{
		String s=lt.getSelectedItem();
		t7.setText(s);
	}
	if(b1==e.getSource())
	{
		String s1,s2,s3,s4,s5,s6,s7;
		s1=t1.getText();s2=t2.getText();s3=t3.getText();
		s4=t4.getText();s5=t5.getText();s6=t6.getText();s7=t7.getText();
		String j=s1+"|"+s2+"|"+s3+"|"+s4+"|"+s5+"|"+s6+"|"+s7;
		try
		{
			RandomAccessFile br=new RandomAccessFile("student.txt","rw");
			br.writeBytes(j+"\n");
			br.close();
		} 
		catch(IOException k)
		{
			System.out.println(k);
		}
	}
	}
	public void itemStateChanged(ItemEvent e)
	{
	if(c1==c.getSelectedCheckbox())
	{
		t3.setText(c1.getLabel());
	}
	else if(c2==c.getSelectedCheckbox())
	{
		t3.setText(c2.getLabel());
	}
	}
	public static void main(String args[])throws IOException
	{
		StudentProfile s=new StudentProfile();
		s.setSize(2000,2000);
		s.setVisible(true);
		s.setTitle("Student Profile");
	}
}

