package app;

import java.security.KeyStore.Entry;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import javax.xml.crypto.Data;

import biz.EmpBiz;
import biz.EmpBizImpLV1;
import entity.Administrator;
import entity.Department;
import entity.Employee;
import util.DataStore;
import util.SystemConfiguration;
import view.View;
import view.ViewConsoleImpl;
import view.ViewDialogImpl;

public class start {
	private static Scanner input = new Scanner(System.in);
	public start(){
		View view = new ViewConsoleImpl();
//		View view = new ViewDialogImpl();
		
		EmpBizImpLV1 empbiz = new EmpBizImpLV1();
		while(true){
			int choice = view.LoginMenu();
//			System.out.println("用户选择：" + choice);
			switch (choice) {
			case 3:
				if(Locale.getDefault().getLanguage().equals("en"))
					Locale.setDefault(new Locale("zh","CN"));
				else
					Locale.setDefault(new Locale("en","US"));
				SystemConfiguration.setCurrLanguage(Locale.getDefault());
				break;
			case 1:				
				System.out.print("用户名：");
				String userName = input.nextLine();
				System.out.print("密码：");
				String password = input.nextLine();
				Administrator loginAdmin = empbiz.login(userName, password);
				if(loginAdmin == null)
				{
					System.out.print("登陆失败");
					break;
				}else{
					System.out.println(userName + "进入系统");
					while(choice != 0)
					{	
						System.out.println("-----------");
						System.out.println("管理员用户界面");
						choice = view.MainAdminMenu();
						switch (choice) {
						case 1://增
							Employee employee = empbiz.GetScannerEmployee();						
							empbiz.add(employee);
							System.out.println("添加成功");
							break;
						case 2://删					
							empbiz.delete(empbiz.FindById());
							System.out.println("删除成功");
							break;
						case 3://查
							empbiz.find(empbiz.FindById());//通过id查找到对象，将对象放回find
							break;
						case 4://改
							empbiz.update(empbiz.FindById());
							System.out.println("修改成功");
							break;
						case 5://排序并显示
							empbiz.sort(1, true);
							Iterator<java.util.Map.Entry<Long, Employee>> 
							it = DataStore.EmpMap.entrySet().iterator();
							while(it.hasNext())
							{
								System.out.println(it.next());
							}
							break;
						}
					}
				}				
				break;
				
			case 2:
				System.exit(0);
			}
		}
	}
	
	
}
