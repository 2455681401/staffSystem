package entity;

public class Employee extends baseEntity{
	private String IdCard;
	private String address;
	
	
	public Employee(){
		super();
	}
	public Employee(
			long id,
			String name, 
			String sex,
			Department depart){
		super(id, name, sex, depart);
	}
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(" ID:" + getId()).append(" 姓名:" + getName())
		.append(" 性别：" + getSex());
		return str.toString();
	}
	public String getIdCard() {
		return IdCard;
	}
	public void setIdCard(String idCard) {
		IdCard = idCard;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
