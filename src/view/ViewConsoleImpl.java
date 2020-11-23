package view;

import java.util.Scanner;

import util.SystemConfiguration;

public class ViewConsoleImpl implements View{
	Scanner input = new Scanner(System.in);
	
	@Override
	public int LoginMenu() {
		System.out.println(SystemConfiguration.GetString(SystemConfiguration.Welcom));
		System.out.println(SystemConfiguration.GetString(SystemConfiguration.Menu_Login));
		return input.nextInt();
	}

	@Override
	public int MainAdminMenu() {
		System.out.println(SystemConfiguration.GetString(SystemConfiguration.Menu_Main_Admin));
		return input.nextInt();
	}

	@Override
	public int MainNormalMenu() {
		// TODO Auto-generated method stub
		return 0;
	}

}
