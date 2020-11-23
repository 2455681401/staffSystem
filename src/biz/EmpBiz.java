package biz;

import java.util.Map;

import entity.Administrator;
import entity.Employee;
import entity.baseEntity;
/**
 * 实现员工业务方法
 * @author Administrator
 *
 */
public interface EmpBiz extends Biz<baseEntity>{
	/**
	 * 管理员登录方法
	 * @param loginName
	 * @param loginPwd
	 * @return
	 */
	public Administrator login(String loginName, String loginPwd);
	
	public Map<Long, baseEntity> sort (int type, boolean asc);
	
}
