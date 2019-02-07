package edu.autocar.tourguide.command;

import edu.autoar.base.command.IFCommand;
import edu.autoar.base.database.ConnectionProvider;
/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autocar.tourguide.command 
 * TourExitCommand.java 
 * 2019. 1. 16.
 * 
 * 애플리케이션을 종료한다.
 * </pre> 
 * 
 * 
 */
public class TourExitCommand implements IFCommand {
	@Override
	public void execute() throws Exception {
		// TODO Auto-generated method stub
		System.exit(0);
	}

}
