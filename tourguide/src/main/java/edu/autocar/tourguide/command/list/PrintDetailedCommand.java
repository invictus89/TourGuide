package edu.autocar.tourguide.command.list;

import java.util.InputMismatchException;

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
 * PrintDetailedCommand.java 
 * 2019. 1. 16.
 * 
 * 특정 데이터의 번호를 입력받아 상세 정보를 출력한다.
 * </pre> 
 * 
 * 
 */
public class PrintDetailedCommand extends TourGuideView implements IFCommand {

	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		TourGuideView view = new TourGuideView();
		ITourDao dao = new TourDaoImpl();
		int index = 0;
		while(true) {
			try {
				index = Input.getInt("상세 정보를 원하시면 해당 번호를 입력해주세요 : ");
				if(Integer.class.isInstance(index)) break;
			}catch(InputMismatchException e) {
				System.err.println("문자가 아닌 숫자를 입력해주세요");
			}
		}
		Tour tour = dao.selectDetailed(index);
		view.printDetailed(tour);
	}

}
