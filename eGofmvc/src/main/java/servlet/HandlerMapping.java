package servlet;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {

	Map<String, Controller> map = new HashMap<String, Controller>();
	
	public HandlerMapping() {
		
		System.out.println("create HandlerMapping");
		map.put("/list.do", new ListController());
		map.put("/login.do", new LoginController());
	}
	
	public Controller getMapping(String url) {
		return map.get(url);
	}
}
