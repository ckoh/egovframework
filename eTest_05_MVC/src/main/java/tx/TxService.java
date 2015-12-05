package tx;

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
	public void addUser(UserVO vo, boolean flag) {
		dao.addUser(vo);
		System.out.println(vo.getUserid()+"  => insert ok....");
		if(flag) { throw new RuntimeException("== 문제 발생 ==");}
		vo.setUserid(vo.getUserid()+"*");
		dao.addUser(vo);
		System.out.println(vo.getUserid()+"  => insert ok....");
	}
	
	public void print() {
		System.out.println("==== UserList ====");
		for( UserVO data :dao.getUserList()){
			System.out.println(data);
		}
	}

}
