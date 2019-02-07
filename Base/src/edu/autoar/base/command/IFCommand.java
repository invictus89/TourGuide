package edu.autoar.base.command;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autoar.base.command 
 * IFCommand.java 
 * 2019. 1. 16.
 * 
 * 애플리케이션 공통 기능의 타입을 통일하기 위한 인터페이스를 정의한다
 * </pre> 
 * 
 * 
 */
@FunctionalInterface
public interface IFCommand {
	void execute() throws Exception;
}
