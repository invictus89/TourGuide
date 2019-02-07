package edu.autocar.tourguide.dao;

import java.util.List;

import edu.autoar.base.database.ICrudDao;
import edu.autoar.base.database.PaginationDao;
import edu.autocar.tourguide.domain.Tour;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autocar.tourguide.dao 
 * ITourDao.java 
 * 2019. 1. 16.
 * 
 * 데이터베이스의 자료를 활용하기 위한 여러 기능을 정의한 인터페이스
 * [상세 기능]
 * 1. 기본 CRUD
 * 	- 전체 리스트 출력
 *  - 특정 데이터 검색 및 출력
 *  - 상세 데이터 출력
 * 2. 페이지 구성 및 출력
 *  - 전체 데이터 수 출력
 *  - 페이지 구성 후 해당 페이지 리스트 출력
 *  - 
 * </pre> 
 * 
 * 
 */
public interface ITourDao extends ICrudDao<Tour, String>, PaginationDao<Tour>{
	public Tour searchOne(String category, String searchName);
	public List<String> selectState();
	public List<Tour> selectListState(String state);
	public List<Tour> searchAll(String searchName);
	public Tour selectDetailed(int num);
	public Tour selectOneforNum(int num);

}
