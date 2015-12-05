package validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import user.vo.UserVO;
/**
 * Validator
 * @author student
 *
 */
public class UserValidater implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		/*return false;*/
		return true;
	}
	
	/**
	 * 
	 */
	@Override
	public void validate(Object target, Errors errors) {
		
		UserVO userVO = (UserVO) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userid", "required"/*, "필수"*/);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "required"/*, "필수"*/);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required"/*, "필수"*/);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "required"/*, "필수"*/);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required"/*, "필수"*/);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userpwd", "required"/*, "필수"*/);
		/*
		if(userVO.getUserid() == null || userVO.getUserid().trim().isEmpty()){
			errors.reject("userid", "required");
		}
		if(userVO.getAddress() == null || userVO.getAddress().trim().isEmpty()){
			errors.reject("address", "required");
		}
		if(userVO.getEmail() == null || userVO.getEmail().trim().isEmpty()){
			errors.reject("email", "required");
		}
		if(userVO.getPhone() == null || userVO.getPhone().trim().isEmpty()){
			errors.reject("phone", "required");
		}
		if(userVO.getUsername() == null || userVO.getUsername().trim().isEmpty()){
			errors.reject("username", "required");
		}
		if(userVO.getUserpwd() == null || userVO.getUserpwd().trim().isEmpty()){
			errors.reject("userpwd", "required");
		}*/
	}

}
