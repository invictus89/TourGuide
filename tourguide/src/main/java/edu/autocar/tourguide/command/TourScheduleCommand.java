package edu.autocar.tourguide.command;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import edu.autoar.base.command.IFCommand;
import edu.autoar.base.util.Input;
import edu.autocar.tourguide.dao.ITourDao;
import edu.autocar.tourguide.dao.TourDaoImpl;
import edu.autocar.tourguide.dao.TourGuideView;
import edu.autocar.tourguide.domain.Tour;
import lombok.AllArgsConstructor;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autocar.tourguide.command 
 * TourScheduleCommand.java 
 * 2019. 1. 16.
 * 
 * 사용자만의 여행 계획을 세워 파일로 저장한다.
 * 원하는 명소의 번호값을 입력받아 파일로 저장한다.
 * </pre> 
 * 
 * 
 */
public class TourScheduleCommand implements IFCommand {
	ITourDao dao = new TourDaoImpl();
	TourGuideView view = new TourGuideView();
	
	
	@AllArgsConstructor
	class Schedule{
		String title;
		String dates;
		List<Tour> list;
		String fileName;	
	}
	
	@Override
	public void execute() throws Exception {
		Schedule schedule = createSchedule();
		save(schedule);
	}
	
	private Schedule createSchedule() throws Exception {
		String title  = Input.getString("제목 : ");
		String dates  = Input.getString("일정 : ");
		String tours = Input.getString("여행지 : ");
		String fileName = Input.getString("파일명 : ");
		
		String [] nums = tours.split(",");
		List<Tour> list = getTourGuides(nums);
		
		return new Schedule(title, dates, list, fileName);
	}

	private List<Tour> getTourGuides(String[] nums) throws Exception{
		List<Tour> list = new ArrayList<>();
		
		for(String numStr : nums) {
			numStr = numStr.trim();
			int num = Integer.parseInt(numStr);
			Tour tg = dao.selectOneforNum(num);
			list.add(tg);
		}
		
		return list;
	}
	
	private void save(Schedule schedule) throws Exception{
		File file = new File("c:/Temp", schedule.fileName + ".txt");
		try(
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fos);	
		){
			ps.println("제목 : " + schedule.title);
			ps.println("일정 : " + schedule.dates);
			ps.println();
			for(int i=0 ; i<schedule.list.size(); i++) {
				Tour tg = schedule.list.get(i);
				ps.printf("여행지 [%d] --------------------------------------------\r\n", i+1);
				view.printDetail(ps, tg);
				ps.println("-------------------------------------------------------");
				ps.println();
				ps.println();
			}			
		}
	}

}
