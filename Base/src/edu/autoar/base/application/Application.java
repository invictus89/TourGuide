package edu.autoar.base.application;

import edu.autoar.base.menu.MenuBar;
import edu.autoar.base.util.Input;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autoar.base.application 
 * Application.java 
 * 2019. 1. 16.
 * 
 * 공통 애플리케이션을 정의한다.
 * 메뉴를 적용시키고, 해당 메뉴 번호를 입력하면 메뉴가 실행된다.
 * </pre> 
 * 
 * 
 */
public class Application {
	MenuBar menuBar;

	public Application() {
		// TODO Auto-generated constructor stub
		//createMenu보다 먼저 호출되도록
		init();
		menuBar = new MenuBar();
		createMenu(menuBar);
	}
	protected void init() {
		
	}
	protected void createMenu(MenuBar menu) {
		//add기능을 수행해야 하지만 추상화로서 공통부분!따라서 직접 정의가 아닌 상속이용!
	}
	
	public void run() {
		while (true) {
			menuBar.print();
			String sel = Input.getString("선택 : ");
			try {
				menuBar.execute(sel);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("----------------------------------------------------------");
		}
	}
}
