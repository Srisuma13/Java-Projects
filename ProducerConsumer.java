class Thread1
{
	//available false... consumer thread must wait
    int num;
    boolean available=false;
    synchronized int get()
    {
        if (!available)
            try
            {
                wait();
            }
            catch (Exception e)
            {
                System.out.println("Excepton occurs at : "+e);
            }
        System.out.println("get" +num);
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Excepton occurs at : "+e);
        }
        available=false;
        notify();
        return num;
    }
    synchronized int put(int num)
    {
		//available true...ie producer thread must wait
        if (available)
            try
            {
                wait();
            }
            catch (Exception e)
            {
                System.out.println("Excepton occur at : "+e);
            }
        this.num=num;
        available=true;
        System.out.println("put"+num);
        try
        {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            System.out.println("Excepton occur at : "+e);
        }
        notify();
        return num;
    }
}
class Producer implements Runnable
{
    Thread1 t;String s;
    Producer(Thread1 t,String s)
    {
        this.t=t;
        this.s=s;
    }
    public void run()
    {
        int x=0;
        int i = 0;
        while (x<10)
        {
            t.put(i++);
            x++;
        }
    }
}
class Consumer implements Runnable
{
    Thread1 t;String s;
    Consumer(Thread1 t,String s)
    {
        this.t=t;
        this.s=s;
    }
    public void run()
    {
        int x=0;
        while (x<10)
        {
            t.get();
            x++;
        }
    }
}
class  ProducerConsumer
{
    public static void main(String[] args)
    {
        Thread1 t=new Thread1();
        Producer p=new Producer(t,"Producer");
        Consumer c=new Consumer(t,"consumer");
		Thread t1=new Thread(p);
		Thread t2=new Thread(c);
		t1.start();
		t2.start();
    }
}