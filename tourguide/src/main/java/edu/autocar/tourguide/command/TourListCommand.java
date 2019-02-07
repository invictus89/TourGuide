package edu.autocar.tourguide.command;

import edu.autoar.base.application.Application;
import edu.autoar.base.command.IFCommand;
import edu.autoar.base.menu.MenuBar;
import edu.autoar.base.menu.MenuItem;
import edu.autoar.base.util.Input;
import edu.autocar.tourguide.command.list.PaginationCommand;
import edu.autocar.tourguide.command.list.PrintAllCommand;
import edu.autocar.tourguide.command.list.PrintDetailedCommand;
import edu.autocar.tourguide.command.list.PrintStateCommand;
import edu.autocar.tourguide.dao.TourGuideView;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autocar.tourguide.command 
 * TourListCommand.java 
 * 2019. 1. 16.
 * 
 * 리스트 출력 기능의 세부 리스트 메뉴를 구성한다.
 * </pre> 
 * 
 * 
 */
public class TourListCommand extends Application implements IFCommand {
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		Application subApp = new TourListCommand();
		subApp.run();
	}
	/* (non-Javadoc)
	 * @see edu.autoar.base.application.Application#createMenu(edu.autoar.base.menu.MenuBar)
	 * <pre>
	 *	[1] : 전체 페이지 출력
	 *	[2] : 권역별 정보 출력
	 *	[3] : 페이지 별 정보 출력
	 *	[4] : 애플리케이션 종료
	 * </pre>
	 */
	@Override
	protected void createMenu(MenuBar subMenuBar) {
		// TODO Auto-generated method stub
		subMenuBar.add(new MenuItem("전체 출력", "1", new PrintAllCommand()));
		subMenuBar.add(new MenuItem("권역별", "2", new PrintStateCommand()));
		subMenuBar.add(new MenuItem("페이지 출력", "3", new PaginationCommand()));
		subMenuBar.add(new MenuItem("Exit", "0", new TourExitCommand()));
	}
}
