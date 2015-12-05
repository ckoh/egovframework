package tx;

import java.util.Iterator;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import user.dao.UserDAO;
import user.vo.UserVO;

@Service("tx")
public class TxService {
	
	@Resource(name="mybatis")
	UserDAO dao;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void addUser(UserVO userVO, boolean flag){
		
		
		int row1 = dao.addUser(userVO);
		System.out.println(row1);
		
		if(flag){
			throw new RuntimeException();
		}
		
		userVO.setUserid(userVO.getUserid()+"*");
		int row2 = dao.addUser(userVO);
		System.out.println(row2);
	}
	
	public void print() {
		System.out.println("UserList");
		for (Iterator<UserVO> iterator = dao.getUserList().iterator(); iterator.hasNext();) {
			System.out.println((UserVO) iterator.next());
		}
	}
}
