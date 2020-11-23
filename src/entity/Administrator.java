package entity;

public class Administrator extends baseEntity{
	private String loginName;
	private String loginPwd;
	
	public Administrator(){
		
	}
	public Administrator(long id,
			String name, 
			String sex,
			Department depart, 
			String lgoinName, 
			String loginPwd){
		setId(id);
		setName(name);
		setSex(sex);
		setDepart(depart);
		setLoginName(lgoinName);
		setLoginPwd(loginPwd);
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	
	
}
