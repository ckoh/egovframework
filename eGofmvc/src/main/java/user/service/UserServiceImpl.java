package user.service;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import user.dao.UserDAO;
import user.vo.UserVO;

// crud/aop/message/login

/*@Component("service")*/
@Service("service")
public class UserServiceImpl implements UserService, InitializingBean , ApplicationContextAware {
	
	/**
	 * autowire="byName" :  <bean id="dao" class="user.dao.UserDAO_JDBC"></bean>
	 */
	// @Autowired	/* 기본은 타입임. 여러개 이면 문제 발생 */
	// @Qualifier("jdbc")	/* byName */
	// @Resource(name="jdbc")
	// @Resource(name="spring")
	// @Resource(name="ibatis")
	 @Resource(name="mybatis")
	UserDAO dao;
	
	@Autowired
	ResourceBundleMessageSource messageSource;
	
	/*@Autowired*/ //ApplicationContextAware
	ApplicationContext applicationContext;

	public UserServiceImpl() {
		super();
		System.out.println("1.create UserServiceImpl super");
	}

	public UserServiceImpl(UserDAO dao) {
		super();
		this.dao = dao;
		System.out.println("1.create UserServiceImpl arg1:UserDAO");

	}
	
	/*
	@Autowired
	@Qualifier("jdbc")*/
	public void setDao(UserDAO dao) {
		this.dao = dao;
		System.out.println("2.set dao");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("3.afterPropertiesSet UserServiceImpl");
	}

	public void init() {
		System.out.println("4.init");
	}

	@Override
	public UserVO login(String id, String pw) {
		
		/*
		System.out.println( "start login: " + id );
		System.out.println( "messageSource : " + messageSource);
		System.out.println( "applicationContext : " + applicationContext);
		*/
		/*System.out.println(0/6);*/
		
		// 컨트롤러 처리.
		UserVO login = dao.login(id, pw);
		if (login != null) {
			System.out.println(messageSource.getMessage("login.success", new Object[]{"amdin"}, Locale.KOREA));
		}else{
			System.out.println(messageSource.getMessage("login.failed", new Object[]{"amdin"}, Locale.KOREA));
		}
		
		return login;
	}

	public UserVO login(UserVO userVO) {
		System.out.println("login ovrride");
		return dao.login(userVO);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		this.applicationContext = applicationContext;
		System.out.println("2.setApplicationContext UserServiceImpl");
		
	}

	@Override
	public int addUser(UserVO userVO) {
		// TODO Auto-generated method stub
		return dao.addUser(userVO);
	}

	@Override
	public int updateUser(UserVO userVO) {
		// TODO Auto-generated method stub
		return dao.updateUser(userVO);
	}

	@Override
	public UserVO getUser(String id) {
		// TODO Auto-generated method stub
		return dao.getUser(id);
	}

	@Override
	public List<UserVO> getUserList() {
		// TODO Auto-generated method stub
		return dao.getUserList();
	}

	@Override
	public int removeUser(String id) {
		// TODO Auto-generated method stub
		return dao.removeUser(id);
	}
}