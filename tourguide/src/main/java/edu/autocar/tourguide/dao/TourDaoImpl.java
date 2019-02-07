package edu.autocar.tourguide.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import edu.autocar.tourguide.database.ConnectionProvider;
import edu.autocar.tourguide.domain.Tour;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autocar.tourguide.dao 
 * TourDaoImpl.java 
 * 2019. 1. 16.
 * 
 * 인터페이스의 추상 메소드를 구현한 클래스
 * </pre> 
 * 
 * 
 */
public class TourDaoImpl implements ITourDao {
	
	static final String namespace = "edu.autocar.tourguide.dao.ITourDao.";
	SqlSession sqlSession;

	public TourDaoImpl() {
		// TODO Auto-generated constructor stub
		sqlSession = ConnectionProvider.getSqlSession();
	}
	
	@Override
	public List<Tour> selectList() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "selectList");
	}

	@Override
	public Tour selectOne(String searchName) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectOne", searchName);
	}
	
	@Override
	public int getCount() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "getCount");
	}

	@Override
	public List<Tour> getPage(int start, int end) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<>();
		map.put("start", start);
		map.put("end", end);
		return sqlSession.selectList(namespace + "getPage", map);
	}


	@Override
	public Tour searchOne(String category, String searchName) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<>();
		map.put("category", category);
		map.put("searchName", searchName);
		System.out.println(category + ", " + searchName);
		return sqlSession.selectOne(namespace + "searchOne", map);
	}

	@Override
	public List<String> selectState() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "selectState");
	}

	@Override
	public List<Tour> selectListState(String state) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "selectListState", state);
	}

	@Override
	public List<Tour> searchAll(String searchName) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + "searchAll", searchName);
	}

	@Override
	public Tour selectDetailed(int num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectDetailed", num);
	}

	@Override
	public int insert(Tour t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Tour t) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String k) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tour selectOneforNum(int num) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + "selectDetailed", num);
	}

}
