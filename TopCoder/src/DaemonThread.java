import java.io.IOException;


public class DaemonThread extends Thread{
	int k=0;
	public DaemonThread(String name){
		this.setName(name);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			try {
				yield();
				System.out.println(Thread.currentThread().getName()+" "+k++);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		DaemonThread t1;
		DaemonThread t2=new DaemonThread("t2");
		 
		t2.start();
	 
 
	 
	//	System.exit(12);
	 

	}

}
