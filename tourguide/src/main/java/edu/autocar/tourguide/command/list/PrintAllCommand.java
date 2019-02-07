package edu.autocar.tourguide.command.list;

import java.util.List;

import edu.autoar.base.command.IFCommand;
import edu.autocar.tourguide.dao.ITourDao;
import edu.autocar.tourguide.dao.TourDaoImpl;
import edu.autocar.tourguide.dao.TourGuideView;
import edu.autocar.tourguide.domain.Tour;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autocar.tourguide.command.list 
 * PrintAllCommand.java 
 * 2019. 1. 16.
 * 
 * 전체 데이터를 출력하고, 특정 데이터의 번호를 입력하면 상제 데이터를 볼 수 있다.
 * </pre> 
 * 
 * 
 */
public class PrintAllCommand implements IFCommand {
	ITourDao dao = new TourDaoImpl();
	TourGuideView view = new TourGuideView();
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		List<Tour> list = dao.selectList();
		view.printList(list);
		PrintDetailedCommand detailed = new PrintDetailedCommand();
		detailed.execute();
	}

	

}
