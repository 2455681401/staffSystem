package entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 封装员工基础信息
 * @author Administrator
 *
 */
public abstract class baseEntity implements Serializable,Comparable<baseEntity>{

	private static final long serialVersionUID = 8603903931798239060L;
	private long id;
	private String name;
	private String sex;
	private int departId;//部门编号3
	private Department depart;
	private String workLevel;
	private Date joinDate;
	private Date quitDate;
	private String quitCause;
	
	
	
	public baseEntity() {	}
	public baseEntity(
			long id,
			String name, 
			String sex,
			Department depart){	
		setId(id);
		setName(name);
		setSex(sex);
		setDepart(depart);
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getDepartId() {
		return departId;
	}

	public void setDepartId(int departId) {
		this.departId = departId;
	}

	public Department getDepart() {
		return depart;
	}

	public void setDepart(Department depart) {
		this.depart = depart;
	}

	public String getWorkLevel() {
		return workLevel;
	}

	public void setWorkLevel(String workLevel) {
		this.workLevel = workLevel;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getQuitDate() {
		return quitDate;
	}

	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}

	public String getQuitCause() {
		return quitCause;
	}

	public void setQuitCause(String quitCause) {
		this.quitCause = quitCause;
	}

	@Override
	public int compareTo(baseEntity o) {		
		return (int) (id - o.id);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(!(obj instanceof baseEntity))
			return false;
		baseEntity emp = (baseEntity) obj;
		return compareTo(emp) == 0;
	}
}
