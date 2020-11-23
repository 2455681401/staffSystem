package biz;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import entity.Administrator;
import entity.Department;
import entity.Employee;
import entity.baseEntity;
import util.DataStore;
import util.InputAndOutput;
import util.SystemConfiguration;
import util.comparator.EmpNameComparator;

public class EmpBizImpLV1 implements EmpBiz{
	private static Scanner input = new Scanner(System.in);
	@Override
	public void add(baseEntity t) {
		if(t == null)
			throw new NullPointerException("对象不能为空！");
		if(t instanceof Employee)
		{
			DataStore.EmpMap.put(t.getId(), (Employee) t);
			new InputAndOutput().EmployeeOutput();
		}
		else
		{
			Administrator admin = (Administrator) t;
			DataStore.AdminMap.put(admin.getLoginName(), admin);
			new InputAndOutput().AdministratorOutput();
		}
		
	}
	
	/**
	 * 键盘输入对象元素然后用add方法添加对象
	 * @return
	 */
	public Employee GetScannerEmployee() {
		boolean isexist = true;
		long empid = 0;
		while(isexist)
		{
			Set<Long> longset = DataStore.EmpMap.keySet();
			System.out.print("请输入员工id：");
			empid = Long.parseLong(input.nextLine());
			if(longset.contains((Long)empid))
				System.out.println("员工id已存在！请重新输入");
			else
				isexist = false;
		}		
		System.out.print("请输入员工名字：");
		String empname = input.nextLine();
		
		System.out.print("请输入员工性别：");
		String sex = input.nextLine();
		
		System.out.print("请输入员工所属部门id：");
		int deparid = Integer.parseInt(input.nextLine());
		
		System.out.print("请输入员工所属部门名称：");
		String deparname = input.nextLine();
		
		Department depart = new Department(deparid, deparname, null);
		Employee employee = new Employee(empid, empname, sex, depart);
		return employee;
	}

	@Override
	public baseEntity delete(baseEntity t) {
		if(t == null)
			throw new NullPointerException("对象不能为空！");
		if(t instanceof Employee)
		{
			Employee deleteemp = DataStore.EmpMap.remove(t.getId());
			new InputAndOutput().EmployeeOutput();
			return deleteemp;
		}
		else
		{
			Administrator admin = (Administrator) t;
			Administrator deleteadmin = DataStore.AdminMap.remove(admin.getId());
			new InputAndOutput().AdministratorOutput();
			return deleteadmin;
		}
	}
	
	@Override
	public baseEntity find(baseEntity t) {
		return t;
	}
	
	public Employee FindById() {		
		boolean isexist = true;
		long empid = 0;
		Employee employee = null;
		while(isexist)
		{
			Set<Long> longset = DataStore.EmpMap.keySet();
			System.out.print("请输入要查找的员工id：");
			empid = Long.parseLong(input.nextLine());
			if(longset.contains((Long)empid))
			{
				System.out.println("员工信息：");
				employee = DataStore.EmpMap.get(empid);
				System.out.println(employee.toString());
				isexist = false;
			}
			else
			{
				System.out.println("员工不存在");				
			}
		}
		
		return employee;
	}

	@Override
	public baseEntity update(baseEntity t) {
		delete(t);
		baseEntity employee = GetScannerEmployee();
		add(employee);
		return employee;
	}

	@Override
	public Administrator login(String loginName, String loginPwd) {
		if(loginName == null || loginPwd == null)
		{
//			System.out.println(111);
			return null;
		}
		if(!DataStore.AdminMap.containsKey(loginName))
		{
			System.out.println("系统无匹配的名字");
			return null;
		}
		Administrator admin = DataStore.AdminMap.get(loginName);
		if(loginPwd.equals(admin.getLoginPwd()))
			return admin;
//		System.out.println(333);
		return null;
	}

	@Override
	public Map<Long, baseEntity> sort(int type, boolean asc) {
		EmpNameComparator comparator = new EmpNameComparator(DataStore.EmpMap);
		TreeMap<Long, baseEntity> sortedMap = new TreeMap<>(comparator);
		switch (type) {
		case 1: //员工名字排序			
			if(asc)
				sortedMap = new TreeMap<>(comparator);
			else
				sortedMap = new TreeMap<>(comparator.reversed());
			return sortedMap;

		default:
			break;
		}
		return sortedMap;
	}

	

}
