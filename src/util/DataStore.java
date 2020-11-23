package util;
/**
 * 数据仓库，为以后连接数据库、文件做准备
 * @author Administrator
 *
 */

import java.util.Map;

import entity.Administrator;
import entity.Employee;

public class DataStore {
	public static Map<Long, Employee> EmpMap = null;
	/**
	 * 管理员对象集合，使用登录名作为key
	 */
	public static Map<String, Administrator> AdminMap = null;

}
