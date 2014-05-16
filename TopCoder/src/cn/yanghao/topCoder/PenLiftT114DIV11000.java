package cn.yanghao.topCoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PenLiftT114DIV11000 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList();
		list.add("hello");
		list.add("world");
		Iterator<String> itr=list.iterator();
		while(itr.hasNext()){
			String value=itr.next();
			if(value.equals("hello"))
				itr.remove();
		}
		for(String value:list){
			System.out.println(value);
		}
	}

}
