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
 * PrintStateCommand.java 
 * 2019. 1. 16.
 * 
 * 권역별 정보를 출력하고, 해당 권역 숫자를 입력받아 리스트를 출력한다.
 * </pre> 
 * 
 * 
 */
public class PrintStateCommand implements IFCommand {
	ITourDao dao = new TourDaoImpl();
	TourGuideView view = new TourGuideView();

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		List<String> list = dao.selectState();
		view.printList(list, 1);

		String state;
		String arr[] = new String[list.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = list.get(i).toString();
		}
		int temp = Input.getInt("권역명 선택 : ");
		state = arr[temp - 1];
		System.out.println(state);
		List<Tour> listDetailed = dao.selectListState(state);
		view.printList(listDetailed);
		PrintDetailedCommand detailed = new PrintDetailedCommand();
		detailed.execute();
	}
}
