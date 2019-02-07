package edu.autocar.tourguide.command.list;

import java.util.List;

import edu.autoar.base.command.IFCommand;
import edu.autoar.base.util.Input;
import edu.autocar.tourguide.dao.ITourDao;
import edu.autocar.tourguide.dao.TourDaoImpl;
import edu.autocar.tourguide.dao.TourGuideView;
import edu.autocar.tourguide.domain.Tour;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autocar.tourguide.command.list 
 * PaginationCommand.java 
 * 2019. 1. 16.
 * 
 * 데이터베이스의 전체 정보를 페이지별로 구성하는 클래스
 * </pre> 
 * 
 * 
 */
public class PaginationCommand implements IFCommand {
	final static int MAX_PER_PAGE = 10;
	ITourDao dao = new TourDaoImpl();
	TourGuideView view = new TourGuideView();

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		int total = (int) Math.ceil(dao.getCount() / MAX_PER_PAGE);
		int page = 1;
		while (true) {
			List<Tour> list = getPageList(page);
			view.printList(total, page, list);
			page = getPageNum(page);
			if(page == -1) {
				System.out.println("\n");
				break;
			}
			if(page == 0) page = 1;
			if(page > total) page = total;
		}
	}

	/**
	 * <pre>
	 * 해당 페이지의 정보 리스트를 넘겨준다.
	 * 
	 * @param page 페이지네이션에서 현재 페이지 번호
	 * @return 해당 페이지의 Tour List 
	 * @throws Exception 데이터베이스에서 페이지 출력시의 예외를 던짐
	 */
	public List<Tour> getPageList(int page) throws Exception {
		int start = (page - 1) * MAX_PER_PAGE + 1;
		int end = page * MAX_PER_PAGE;
		List<Tour> list = dao.getPage(start, end);
		return list;
	}
	
	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param page
	 * @return
	 * 
	 * 페이지를 넘긴다.
	 * [p] : 이전 페이지
	 * [n] : 다음 페이지
	 * [q] : 종료
	 * </pre>
	 * 
	 */
	public int getPageNum(int page) {
		System.out.println();
		String sel = Input.getString("선택(이전[p], 다음[n], 숫자, 출력 종료[q]) : ");
		switch(sel) {
		case "p" : page--; break;
		case "n" : page++; break;
		case "q" : page = -1; break;
		default : 
			page = Integer.parseInt(sel);
		}
		return page;
	}
}
