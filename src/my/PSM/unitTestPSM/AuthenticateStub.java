package my.PSM.unitTestPSM;

import my.PSM.PSM_Logic.Authenticate;

public class AuthenticateStub extends Authenticate {

	private String correctUser;
	private String correctPw;
	
	public AuthenticateStub(String user, String pw) {
		super(user, pw);
		correctUser = user;
		correctPw = pw;
	}
	public void setCorrectUser(String correctUser) {
		this.correctUser = correctUser;
	}

	public void setCorrectPw(String correctPw) {
		this.correctPw = correctPw;
	}

	@Override
	public boolean validate_Login() {
		return (correctUser.equals(username)) && (correctPw.equals(password));
	}

	@Override
	public boolean logout() {
		return true;
	}
	
	
}
