package cn.yanghao.topCoder.SRMS3;

import java.util.List;

public class VendingMachine {
	public static class Point {
		public int row;
		public int col;
		public int time;

		/*
		 * demo:"0,2:35"
		 */
		void init(String s) {
			row = Integer.parseInt(s.substring(0, s.indexOf(",")));
			col = Integer.parseInt(s.substring(s.indexOf(",") + 1,
					s.indexOf(":") ));
			time = Integer.parseInt(s.substring(s.indexOf(":") + 1));
		}
		void init(Point p){
			row=p.row;
			col=p.col;
			time=p.time;
		}

	}

	int ROW;
	int COL;
	int[][] price;
	int time=0;
	int currentCol=0;

	public void initPrice(String[] prices) {
		int row, col, p;
		ROW = prices.length;
		COL = prices[0].split(" ").length;
		// 存储当前的价位，最后一行保存有当前列的总数；
		price = new int[ROW + 1][COL];
		for (col = 0; col < COL; col++)
			price[ROW][col] = 0;
		for (row = 0; row < ROW; row++) {
			String[] currentRow = prices[row].split(" ");
			for (col = 0; col < COL; col++) {
				p = Integer.parseInt(currentRow[col]);
				price[row][col] = p;
				price[ROW][col] += p;
			}
		}
	}

	int calDistance(int a, int b) {
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		return Math.min(max - min, COL - max + min);
	}

	int getMaxColIndex() {
		int maxIndex = 0;
		int max = price[ROW][0];
		for (int i = 1; i < COL; i++) {
			if (price[ROW][i] > max) {
				maxIndex = i;
				max = price[ROW][i];
			}
		}
		return maxIndex;
	}

	void moveTo(int end) {
		time += calDistance(currentCol, end);
		currentCol= end;
	}

	/*
	 * demo: {"100 200 300", "600 500 400"} {"0,0:0", "1,1:10", "1,2:20",
	 * "0,1:21", "1,0:22", "0,2:35"}
	 */
	public int motorUse(String[] prices, String[] purchases) {
 		Point currentPoint = new Point();
		Point lastPoint = new Point();
		int maxIndex;
		initPrice(prices);

		// 移动到最大的位置
		maxIndex = getMaxColIndex();
		moveTo(maxIndex);
		//第一步
		currentPoint.init(purchases[0]);
		
		moveTo(currentPoint.col);
		price[ROW][currentPoint.col]-=price[currentPoint.row][currentPoint.col];
		price[currentPoint.row][currentPoint.col]=0;
		lastPoint.init(currentPoint);
		
		for (int i =1; i < purchases.length; i++) {
			currentPoint.init(purchases[i]);
			if(0==price[currentPoint.row][currentPoint.col])
				return -1;
			if(5<=currentPoint.time-lastPoint.time){
				maxIndex=getMaxColIndex();
				moveTo(maxIndex);
			}
			
			moveTo(currentPoint.col);
			price[ROW][currentPoint.col]-=price[currentPoint.row][currentPoint.col];
			price[currentPoint.row][currentPoint.col]=0;
			lastPoint.init(currentPoint);
		}
		maxIndex=getMaxColIndex();
		moveTo(maxIndex);
		return time;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine ven=new VendingMachine();
		String []prices={"100 200 300",
		 "600 500 400"};
		String []purchase={"0,0:0", "1,1:10", "1,2:20",
				 "0,1:21", "1,0:22", "0,2:35"};
		System.out.println(ven.motorUse(prices,purchase));

	}

}
