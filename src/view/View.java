package view;
/**
 * 界面层接口
 * @author Administrator
 *
 */
public interface View {
	/**
	 * 登录界面
	 */
	public int LoginMenu();
	/**
	 * 管理员主界面
	 */
	public int MainAdminMenu();
	/**
	 * 普通用户主界面
	 */
	public int MainNormalMenu();
}
