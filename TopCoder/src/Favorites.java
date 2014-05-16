import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Favorites {
	Map<Class<?>,Object> map;
	Favorites(){
		map=new HashMap();
	}
	public <T>void putFavorite(Class <T>type,T value){
		if(null==type)
			throw new NullPointerException("Type is null");
		map.put(type, value);
		 
	}
	public <T>T getFavorite(Class <T>type){
		return type.cast( map.get(type));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Favorites f=new Favorites();
		Class type;
		try {
			type = Class.forName("java.lang.String");
			f.putFavorite(type,type.cast("hello world"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		f.putFavorite(Integer.class, 12);
		f.putFavorite(Class.class, String.class);
		List<String> list;
		//List.class;
		//Set<String>.;
		for(Class c:f.map.keySet()){
			System.out.println(c.getName()+"\t"+f.map.get(c));
		}

	}

}
