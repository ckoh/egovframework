package servlet;

import java.util.HashMap;

public class HandlerMaping {
    HashMap<String, Controller> mapping =
    		   new HashMap<String, Controller>();
    public HandlerMaping(){
    	mapping.put("/list.do",new ListController() );
    	mapping.put("/login.do",new LoginController());
    }
    public Controller getMapping(String key) {
		return mapping.get(key);
	}
}
