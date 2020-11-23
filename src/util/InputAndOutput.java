package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import entity.Administrator;
import entity.Employee;

public class InputAndOutput {
	private static final String AdminFilePath = "src/util/admin.txt";
	private static final String EmployeeFilePath = "src/util/employee.txt";
	
	public InputAndOutput(){}
//	public static void main(String[] args) {
////		new InputAndOutput().EmployeeInput();
//		new InputAndOutput().AdministratorInput();
//	}
	/**
	 * 序列化输入Employee对象
	 */
	public void EmployeeInput(){
		try {
			ObjectInputStream oise = new ObjectInputStream(new FileInputStream(EmployeeFilePath));
			Employee emp = null;
			while((emp = (Employee) oise.readObject()) != null)
			{
				DataStore.EmpMap.put(emp.getId(), emp);
			}
//			//测试是否有值
//			Employee[] emp = (Employee[]) oise.readObject();
//			for (Employee employee : emp) {
//				System.out.println(employee);
//			}
//			for (Employee employee : emp) {
//				DataStore.EmpMap.put(employee.getId(), employee);
//			}
			oise.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 序列化输出Employee对象
	 */
	public void EmployeeOutput(){
		try {			
			ObjectOutputStream oose = new ObjectOutputStream(new FileOutputStream(EmployeeFilePath));
//			Iterator<Entry<Long, Employee>> it = DataStore.EmpMap.entrySet().iterator();
//			while(it.hasNext())
//			{
//				//将从entry对象里面取出的key序列化输出到文件
//				oose.writeObject(it.next().getValue());				
//			}	
			Set<Long> keys = DataStore.EmpMap.keySet();
			for (Long key : keys) {
				oose.writeObject(DataStore.EmpMap.get(key));
			}
			
			oose.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 序列化输入AdminFilePath对象
	 */
	public void AdministratorInput(){
		try {
			ObjectInputStream oisa = new ObjectInputStream(new FileInputStream(AdminFilePath));
			Administrator admin = null;
//			System.out.println(2222);
			while((admin = (Administrator) oisa.readObject()) != null)
			{
//				System.out.println(4444);
//				System.out.println((Administrator) oisa.readObject());
				DataStore.AdminMap.put(admin.getLoginName(), admin);
//				System.out.println(3333);
//				System.out.println(admin);
//				System.out.println(1111);
			}
			
//			Administrator[] admin = (Administrator[]) oisa.readObject();
//			for (Administrator administrator : admin) {
//				DataStore.AdminMap.put(administrator.getLoginName(), administrator);
//				
//			}
			oisa.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 序列化输出Administrator对象
	 */
	public void AdministratorOutput(){
		try {			
			ObjectOutputStream oosa = new ObjectOutputStream(new FileOutputStream(AdminFilePath));
//			Iterator<Entry<String, Administrator>> it = DataStore.AdminMap.entrySet().iterator();
//			while(it.hasNext())
//			{
//				//将从entry对象里面取出的key序列化输出到文件
//				oosa.writeObject(it.next().getValue());				
//			}	
			Set<String> keys = DataStore.AdminMap.keySet();
			for (String key : keys) {
				oosa.writeObject(DataStore.AdminMap.get(key));
			}
			oosa.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
