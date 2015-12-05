package user.service;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import user.dao.UserDAO;
import user.vo.UserVO;

//@Component("service")
@Service("service")
public class UserServiceImpl implements UserService,
                                        ApplicationContextAware{

	//@Autowired
	//@Qualifier("ibatis")
	@Resource(name="mybatis")
	UserDAO dao ;
	
	//@Autowired
	ApplicationContext applicationContext;
	
	public UserServiceImpl() {	}
	public UserServiceImpl(UserDAO dao) {
		System.out.println("생성자()  ");
		this.dao = dao;
	}
	public UserDAO getDao() {
		return dao;
	}
	public void setDao(UserDAO dao) {
		System.out.println("setDao call : "+dao);
		this.dao = dao;
	}
	@Override
	public UserVO login(String id, String pw) {
		UserVO vo =  dao.login(id, pw);
		String msg = "";
		if(vo != null){
			msg = 
			applicationContext.getMessage("login.success",
				                       new Object[]{id}, 
				                       Locale.getDefault());
		}else{
			msg = 
			applicationContext.getMessage("login.failed",
					                       new Object[]{id}, 
					                       Locale.getDefault());
		}
		System.out.println(msg);
		return vo;
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	@Override
	public int addUser(UserVO user) {
		// TODO Auto-generated method stub
		return dao.addUser(user);
	}
	@Override
	public int updateUser(UserVO user) {
		return dao.updateUser(user);
	}
	@Override
	public UserVO getUser(String id) {
		return dao.getUser(id);
	}
	@Override
	public List<UserVO> getUserList() {
		return dao.getUserList();
	}
	@Override
	public int removeUser(String id) {
		return dao.removeUser(id);
	}
}















