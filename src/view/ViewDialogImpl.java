package view;

import javax.swing.JOptionPane;

import util.SystemConfiguration;

public class ViewDialogImpl implements View{

	@Override
	public int LoginMenu() {
		Object[] loginMenu = SystemConfiguration.GetString(SystemConfiguration.Menu_Login).split("\n");
		int choice = JOptionPane.showOptionDialog(
				null,        //当前对话框父窗体，这里设置为null
				SystemConfiguration.GetString(SystemConfiguration.Dialog_Box_Prompt_Information), 
				//对话框提示信息
				"请选择需要的操作",  //对话框标题信息
				JOptionPane.DEFAULT_OPTION, //设置为默认选项 
				JOptionPane.QUESTION_MESSAGE,//设置为问题信息（问号图片） 
				null, 						//设置自定义图片，这里使用默认问题图片
				loginMenu, 					//数组，按照数组内容生成对话框按钮			
				""							//对话框默认值 
				);
		
		return choice + 1;
	}

	@Override
	public int MainAdminMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int MainNormalMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

}
