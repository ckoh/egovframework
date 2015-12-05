package tv1;

public class BeanFactory {
   public Object getBean(String name){
	   if(name.equals("s")){
		   return new SamaungTV();
	   }else if (name.equals("l")) {
		   return new LgTV();
	   }
	   return null;
   }
}
