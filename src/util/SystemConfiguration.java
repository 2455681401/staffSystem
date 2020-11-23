package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map;

import entity.Administrator;
import entity.Department;
import entity.Employee;



public class SystemConfiguration {
	private static ResourceBundle resource = null;
	private static String baseName = "i18n/language";
	public static final String Welcom = "welcom";
	public static final String Menu_Login = "menu_login";
	public static final String Menu_Main_Admin = "menu_main_admin";
	public static final String Menu_Main_Normal	= "menu_main_normal";
	public static final String Dialog_Box_Prompt_Information = "dialog_box_prompt_information";
	public static InputAndOutput iando =  new InputAndOutput();
	
//	private static final String AdminFilePath = "src/util/admin.txt";
//	private static final String EmployeeFilePath = "src/util/employee.txt";
	
	//静态代码块：在main方法执行前就会首先执行，一般用来书写系统初始代码
	static{
		//设置当前默认语言包
		setCurrLanguage(Locale.getDefault());
		
		//数据初始化
		DataStore.EmpMap = new TreeMap<>();
		DataStore.AdminMap = new TreeMap<>();
		
		iando.EmployeeInput();
		if(DataStore.EmpMap.isEmpty())
		{
			Employee[] emp = {
					new Employee(1, "石丹", "女", new Department(1, "第一任", null)),
					new Employee(2, "周洲", "女", new Department(1, "第二任", new Department(1, "不想分", null))),
					new Employee(3, "叶晓梅", "女", new Department(1, "第三任", null))	
			};
			for (Employee employee : emp) {
				DataStore.EmpMap.put(employee.getId(), employee);
			}
			iando.EmployeeOutput();
		}
		
		
		
//		//将map中的对象序列化到文件中
//		try {
//			ObjectOutputStream oosa = new ObjectOutputStream(new FileOutputStream(EmployeeFilePath));
//			oosa.writeObject(emp);
//			oosa.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
//		Set<Long> keyse = DataStore.EmpMap.keySet();
//		for (Long long1 : keyse) {
//			System.out.println(DataStore.EmpMap.get(long1));
//		}
//		Iterator<java.util.Map.Entry<Long, Employee>> entry = DataStore.EmpMap.entrySet().iterator();
//		while(entry.hasNext())
//		{
//			System.out.println(entry.next());
//		}
		

		iando.AdministratorInput();
		if(DataStore.AdminMap.isEmpty())
		{
			Administrator[] admin = {
					new Administrator(2, "石丹2", "女", new Department(1, "第一任2", null), "2222", "2222"),
					new Administrator(1, "石丹", "女", new Department(1, "第一任", null), "3333", "3333")
			};
			for (Administrator administrator : admin) {
				DataStore.AdminMap.put(administrator.getLoginName(), administrator);
			}
			iando.AdministratorOutput();
		}
		
		
//		System.out.println(DataStore.AdminMap.keySet());
		
		
//		//将map中的对象序列化到文件中
//		try {
//			ObjectOutputStream oose = new ObjectOutputStream(new FileOutputStream(AdminFilePath));
//			oose.writeObject(admin);
//			oose.close();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
	}
	/**
	 * 将选取语言包设置为一个方法
	 * @param locale
	 */
	public static void setCurrLanguage(Locale locale){
		resource = ResourceBundle.getBundle(baseName, locale);
	}
	/**
	 * 根据传进的key选择value
	 * @param key
	 * @return
	 */
	public static String GetString(String key){
		return resource.getString(key);
	}
}
