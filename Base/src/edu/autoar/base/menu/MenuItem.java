package edu.autoar.base.menu;

import edu.autoar.base.command.IFCommand;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autoar.base.menu 
 * MenuItem.java 
 * 2019. 1. 16.
 * 
 * 각 메뉴의 구성 요소를 정의한 DTO 클래스
 * </pre> 
 * 
 * 
 */
public class MenuItem {
	private String title;
	private String hotKey;
	private IFCommand command;
	
	public MenuItem(String title, String hotKey, IFCommand command) {
		super();
		this.title = title;
		this.hotKey = hotKey;
		this.command = command;
	}

	public String getTitle() {
		return title;
	}

	public String getHotKey() {
		return hotKey;
	}

	public IFCommand getCommand() {
		return command;
	}
	
	public void execute() throws Exception {
			command.execute();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%s(%s)", title, hotKey);
	}
	
	
}
