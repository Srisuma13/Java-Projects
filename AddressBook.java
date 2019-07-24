import java.util.*;
import java.io.*;
class Ab
{
String name,street,city,state,pincode;
void add()throws IOException,FileNotFoundException
{
Scanner sc = new Scanner(System.in);
System.out.println("enter name");
name=sc.nextLine();
System.out.println("enter street");
street=sc.nextLine();
System.out.println("enter city");
city=sc.nextLine();
System.out.println("enter state");
state=sc.nextLine();
System.out.println("enter pincode");
pincode=sc.nextLine();
FileOutputStream fout = new FileOutputStream("addressbook.txt",true);
PrintStream ps = new PrintStream(fout);
ps.println(name+"|"+street+"|"+city+"|"+state+"|"+pincode);
fout.close();
}
void getFirst()throws IOException,FileNotFoundException
{
File file = new File("addressbook.txt");
RandomAccessFile raf = new RandomAccessFile(file,"rw");
raf.seek(0);
String str=raf.readLine();
System.out.println(str);
raf.close();
}
void getNext()throws IOException,FileNotFoundException
{
File file = new File("addressbook.txt");
RandomAccessFile raf = new RandomAccessFile(file,"rw");
String str=raf.readLine();
System.out.println(str);
raf.close();
}
void getLast()throws IOException,FileNotFoundException
{
File file = new File("addressbook.txt");
RandomAccessFile raf = new RandomAccessFile(file,"rw");
long pos,pos1;String str,str2;
while((pos=raf.getFilePointer())>=0&&(str=raf.readLine())!=null)
{
}
raf.seek(0);
while((str2=raf.readLine())!=null&&(pos1=raf.getFilePointer())>=0)
{
if(pos1==pos)
break;
}

System.out.println(str2);
}
void getPre()throws IOException,FileNotFoundException
{
File file = new File("addressbook.txt");
RandomAccessFile raf = new RandomAccessFile(file,"rw");
long pos;String str;pos=raf.getFilePointer();
long p;
raf.seek(0);
while((str=raf.readLine())!=null)
{
p=raf.getFilePointer();
if(p==pos)
{
break;
}
}
System.out.println(str);
}
}
class AddressBook
{
public static void main(String args[])throws IOException,FileNotFoundException
{
int ch;Ab a = new Ab();
while(true)
{
System.out.println("enter 1.add address 2.retrieve first address 3.next 4.last 5.previous 6.exit");
Scanner sc = new Scanner(System.in);
ch=sc.nextInt();
switch(ch)
{
case 1:a.add();break;
case 2:a.getFirst();break;
case 3:a.getNext();break;
case 4:a.getLast();break;
case 5:a.getPre();break;
case 6:System.exit(0);
}
}
}
}

/*OUTPUT


enter 1.add address 2.retrieve first address 3.next 4.last 5.previous 6.exit
1
enter name
banner
enter street
geor
enter city
nikndd
enter state
sfsfsg
enter pincode
35645
enter 1.add address 2.retrieve first address 3.next 4.last 5.previous 6.exit
2
anuhya|gandhi|hyderabad|andhra|34567
enter 1.add address 2.retrieve first address 3.next 4.last 5.previous 6.exit
4
banner|geor|nikndd|sfsfsg|35645
enter 1.add address 2.retrieve first address 3.next 4.last 5.previous 6.exit
5
null
enter 1.add address 2.retrieve first address 3.next 4.last 5.previous 6.exit
3
anuhya|gandhi|hyderabad|andhra|34567
enter 1.add address 2.retrieve first address 3.next 4.last 5.previous 6.exit
4
banner|geor|nikndd|sfsfsg|35645
enter 1.add address 2.retrieve first address 3.next 4.last 5.previous 6.exit
6*/