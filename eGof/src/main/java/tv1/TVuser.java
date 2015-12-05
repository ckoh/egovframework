package tv1;

public class TVuser {
	public static void main(String[] args) {

		TV tvuser = null;
		tvuser = new SamaungTV();
		tvuser.powerOn();
		tvuser.powerOff();
		
		tvuser = new LgTV();
		tvuser.powerOn();
		tvuser.powerOff();
		
	}
}
