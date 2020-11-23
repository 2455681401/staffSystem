package entity;

import java.io.Serializable;

/**
 * 部门类
 * @author Administrator
 *
 */
public class Department implements Serializable{
	private int id;
	private String name;
	private Department hostDepart;//上级部门对象
	public Department(){
		
	}
	public Department(int id, String name, Department hostDepart){
		setId(id);
		setName(name);
		setHostDepart(hostDepart);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getHostDepart() {
		return hostDepart;
	}
	public void setHostDepart(Department hostDepart) {
		this.hostDepart = hostDepart;
	}
	
	
}
