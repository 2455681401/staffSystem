package i18n;

import java.util.Locale;
import util.SystemConfiguration;

/**
 * 国际化测试
 * @author Administrator
 *
 */
public class i18ntest {
	public static void main(String[] args) {
		//基于类的属性文件类：属性文件必须放在包里
		
//		ResourceBundle resource = ResourceBundle.getBundle("i18n/language");
//		System.out.println(resource.getString("welcom"));
		
//		Locale locale = new Locale("en", "US");//强制设置本地语言为英语
//		ResourceBundle resource = ResourceBundle.getBundle("i18n/language", locale);
//		System.out.println(resource.getString("welcom"));
		
		Locale locale = new Locale("zh", "CN");
		SystemConfiguration.setCurrLanguage(locale);
		System.out.println(SystemConfiguration.GetString(SystemConfiguration.Welcom));


	}
}
