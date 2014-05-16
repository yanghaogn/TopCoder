package org.yanghao.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
  enum Apple{
	FUJI,PIPPIN;
	int a;
	Apple(){
		
	}
	private static enum Time{
		
	} 
	int price;
}
public abstract class DEMO {
	  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Apple.FUJI.a=3;;
		System.out.printf("%d ", Apple.FUJI.a);
		 
		 
	}

}
