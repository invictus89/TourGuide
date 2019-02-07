package edu.autoar.base.database;

import java.util.List;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autoar.base.database 
 * PaginationDao.java 
 * 2019. 1. 16.
 * 
 * 애플리케이션의 공통 기능인 페이지 구성 기능을 인터페이스화 시킨다.
 * 	- 전체 데이터 수 출력
 *  - 정보 위치별 페이지 구성
 * </pre> 
 * 
 *
 * @param <T> 
 */
public interface PaginationDao<T> {
	int getCount() throws Exception;
	List<T> getPage(int start, int end) throws Exception;
}
