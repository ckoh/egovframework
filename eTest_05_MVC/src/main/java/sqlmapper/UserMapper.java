package sqlmapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import user.vo.UserVO;

public interface UserMapper {
//	<select id="list" resultType="user.vo.UserVO">
//	   select * from userinfo
//    </select>
	
	@Select("select * from userinfo")
	List<UserVO> list();
	
}
