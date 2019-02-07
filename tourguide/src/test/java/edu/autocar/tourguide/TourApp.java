package edu.autocar.tourguide;

import edu.autoar.base.application.Application;
import edu.autoar.base.menu.MenuBar;
import edu.autoar.base.menu.MenuItem;
import edu.autocar.tourguide.command.TourListCommand;
import edu.autocar.tourguide.command.TourScheduleCommand;
import edu.autocar.tourguide.command.TourSearchCommand;
import edu.autocar.tourguide.database.ConnectionProvider;

/** 
 * @author 백상우 
 * <pre> 
 * edu.autocar.tourguide 
 * TourApp.java 
 * 2019. 1. 7.
 * 
 * TourGuide Application 클래스
 * 운영에 필요한 메뉴를 구성하고, 메뉴 명령을 실행하여 애플리케이션이 구성됨
 * </pre> 
 * 
 */
public class TourApp extends Application {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application app = new TourApp();
		app.run();
	}


	/* (non-Javadoc)
	 * @see edu.autoar.base.application.Application#createMenu(edu.autoar.base.menu.MenuBar)
	 * <pre>
	 * Application의 메뉴바를 구성한다.
	 * [1] : List 출력
	 * [2] : 데이터 추가
	 * [3] : 데이터 업데이트
	 * [4] : 데이터 삭제
	 * [5] : 특정 데이터 검색
	 * [6] : Application 종료
	 * </pre>
	 */
	@Override
	protected void createMenu(MenuBar menu) {
		menu.add(new MenuItem("리스트 출력", "1", new TourListCommand()));
		menu.add(new MenuItem("검색하기", "2", new TourSearchCommand()));
		menu.add(new MenuItem("파일에 저장하기", "3", new TourScheduleCommand()));
		menu.add(new MenuItem("Exit", "0", this::exit));
	}

	/**
	 * <pre>
	 * 2019. 1. 16.
	 * 람다식 활용을 위한 Application 종료 및 데이터 베이스 연결 종료
	 * </pre>
	 * 
	 */
	public void exit() {
		System.out.println("Application 종료");
		ConnectionProvider.getSqlSession().close();
		System.exit(0);
	}
}
