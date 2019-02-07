package edu.autocar.tourguide.command;

import java.util.List;

import edu.autoar.base.command.IFCommand;
import edu.autoar.base.util.Input;
import edu.autocar.tourguide.command.list.PrintDetailedCommand;
import edu.autocar.tourguide.dao.ITourDao;
import edu.autocar.tourguide.dao.TourDaoImpl;
import edu.autocar.tourguide.dao.TourGuideView;
import edu.autocar.tourguide.domain.Tour;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autocar.tourguide.command 
 * TourSearchCommand.java 
 * 2019. 1. 16.
 * 
 * 원하는 키워드를 통해 데이터를 검색한다.
 * 이후 해당 데이터의 번호를 입력하면 상세정보를 볼 수 있다.
 * </pre> 
 * 
 * 
 */
public class TourSearchCommand implements IFCommand {

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		ITourDao dao = new TourDaoImpl();
		TourGuideView view = new TourGuideView();

		while (true) {
			String searchName = Input.getString("키워드 입력 : ");
			System.out.println("* 명소 이름, 지역 외에 상세 콘텐츠에서도 검색합니다.");
			List<Tour> list = dao.searchAll(searchName);

			if (list.size() != 0) {
				view.printList(list);
				PrintDetailedCommand detailed = new PrintDetailedCommand();
				detailed.execute();
				break;
			}
			else {
				System.out.println("일치하는 데이터가 없습니다.");
			}
		}
	}
}