import java.util.Scanner;

	public class BinaryCode{

		String getOriginal(int []encrypt,int len,int start){
			if(start<0||start>1) return "NONE";
			int[]original=new int[len];
			original[0]=start;
			if(1==len)
			{
				if(0==start-encrypt[0])
					return ""+start;
				return "NONE";
			}
			if(1<len){
				original[1]=encrypt[0]-original[0];
				if(original[1]<0||original[1]>1)
					return "NONE";
			}
			for(int i=2;i<len;i++){
				original[i]=encrypt[i-1]-original[i-1]-original[i-2];
				if(original[i]<0||original[i]>1)
					return "NONE";
			}
			if(0!=original[len-1]+original[len-2]-encrypt[len-1])
				return "NONE";
			StringBuilder o=new StringBuilder(len);
			for(int i=0;i<len;i++)
				o.append(original[i]);
			return o.toString();
		}
		public String[] decode(String s){
			String[] ret=new String[2];
			int len=s.trim().length(),i;
			int []original=new int[len];
			for(i=0;i<len;i++)
				original[i]=Integer.parseInt(s.substring(i, i+1));
			ret[0]=getOriginal(original,len,0);
			ret[1]=getOriginal(original,len,1);
			return ret;
		}
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub

			BinaryCode b=new BinaryCode();
			Scanner in=new Scanner(System.in);
			while(in.hasNext()){
				String []ret=b.decode(in.nextLine());
				System.out.println(ret[0]+","+ret[1]);
			}
		}

	}
