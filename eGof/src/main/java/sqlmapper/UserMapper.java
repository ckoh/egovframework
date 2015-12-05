package sqlmapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import user.vo.UserVO;

public interface UserMapper {

	@Select("select * from userinfo")
	List<UserVO> list();
}
