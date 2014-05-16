import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class constructHouZhuiArray {
	static boolean  cmp(int []r,int a,int b,int l)
    {
    	return r[a]==r[b]&&r[a+l]==r[b+l];
    }

 /*
  * 根据原始数组r,计算sa
  * suffix[sa[0]]<suffix[sa[1]]<suffix[sa[2]]<...<suffix[sa[n-1]]
  * n=r.length;
  */
 static  void   da(int []r,int []sa,int n,int m)
    {
        int i,j,p;
    	int []wv=new int[n];
    	int []ws=new int[n];
        int []x=new int[n];
        int []y=new int[n];
        int []t;
     
        for(i=0;i<m;i++) ws[i]=0; 
        for(i=0;i<n;i++){
        	ws[x[i]=r[i]]++;
        } 
        for(i=1;i<m;i++){ 
        	ws[i]+=ws[i-1];
        	 
        } 
   
    
        for(i=n-1;i>=0;i--){ 
        	sa[--ws[x[i]]]=i;
        }
        
   
        for(j=1,p=1;p<n;j*=2,m=p) 
        { 
            for(p=0,i=n-j;i<n;i++) y[p++]=i; 
            for(i=0;i<n;i++) if(sa[i]>=j) y[p++]=sa[i]-j; 
            for(i=0;i<n;i++) wv[i]=x[y[i]]; 
            for(i=0;i<m;i++) ws[i]=0; 
            for(i=0;i<n;i++) ws[wv[i]]++; 
            for(i=1;i<m;i++) ws[i]+=ws[i-1]; 
            for(i=n-1;i>=0;i--) sa[--ws[wv[i]]]=y[i]; 
            for(t=x,x=y,y=t,p=1,x[sa[0]]=0,i=1;i<n;i++) 
                x[sa[i]]=cmp(y,sa[i-1],sa[i],j)?p-1:p++; 
           
        } 
        return; 
    }

 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="aabaaaab";
		Set<String>  set = new HashSet<String> ();
		for(int i=0;i<a.length();i++){
			set.add(""+a.charAt(i));
		}
		Object []t=set.toArray();
		char[]tmp= new char[t.length];
		for(int i=0;i<t.length;i++)
			tmp[i]=t[i].toString().charAt(0);
		StringBuilder sB=new StringBuilder();
		for(int i=0;i<tmp.length;i++){
			for(int j=i+1;j<tmp.length;j++){
				if(tmp[j]<tmp[i]){
					char c=tmp[j];
					tmp[j]=tmp[i];
					tmp[i]=c;
				}
			}
			sB.append(tmp[i]);
		}
		
		 
		System.out.println(sB);
		int []r=new int[a.length()+1];
		int []sa=new int[r.length];
		for(int i=0;i<a.length();i++)
		{
			r[i]=sB.indexOf(""+a.charAt(i))+1;
			 
		}
		r[a.length()]=0;
		System.out.print("r=:");
		 for(int i=0;i<r.length;i++)
			 System.out.print(r[i]);
		 System.out.println();
		 da(r,sa,r.length,tmp.length+1);
		 for(int i=0;i<r.length;i++)
			 System.out.print(sa[i]);
  

	}

}
