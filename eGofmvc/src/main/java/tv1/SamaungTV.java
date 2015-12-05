package tv1;

import org.springframework.beans.factory.InitializingBean;

public class SamaungTV implements TV , InitializingBean{
	
	public void init(){
		System.out.println("SamaungTV init() ~~~~~~~");
	}
	
	public SamaungTV() {
		System.out.println("SamaungTV() 생성");
	}
	
	@Override
	public void powerOn() {
		System.out.println("SamaungTV powerOn");
	}
	@Override
	public void powerOff() {
		System.out.println("SamaungTV powerOff");
	}
	@Override
	public void volumeUp() {
		System.out.println("SamaungTV volumeUp");
	}
	@Override
	public void volumeDown() {
		System.out.println("SamaungTV volumeDown");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() 이용한 초기화");
	}
}
