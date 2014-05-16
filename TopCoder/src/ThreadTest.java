import java.util.Vector;
import java.util.concurrent.CountDownLatch;


public class ThreadTest {
	final Vector <String>vector=new Vector(10000);
	ThreadTest(){
		for(int i=0;i<vector.capacity();i++)
			vector.add(""+i);
	}
	void method1(){
		while(vector.size()>0){
			System.out.println(vector.get(0));
			vector.remove(0);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	public  class RemoveThread extends Thread{
		CountDownLatch count;
		RemoveThread(CountDownLatch count){
			this.count=count;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(vector.size()>0)
			{
				System.out.println(vector.get(0));
				vector.remove(0);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			count.countDown();
		}
		
	}
	public void method2(){
		CountDownLatch count=new CountDownLatch(10);
		for(int i=0;i<count.getCount();i++)
			this.new RemoveThread(count).start();
		try {
			count.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadTest test=new ThreadTest();
		long start=System.currentTimeMillis();
		test.method2();
		long end=System.currentTimeMillis();
		System.out.println("time:"+(end-start)+"ms");

	}

}
