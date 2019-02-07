package edu.autoar.base.database;

import java.util.List;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autoar.base.database 
 * ICrudDao.java 
 * 2019. 1. 16.
 * 
 * 애플리케이션의 공통 기능인 CRUD를 추상메소드로 인터페이스화 시킨다.
 * </pre> 
 * 
 *
 * @param <T>
 * @param <K> 
 */
public interface ICrudDao<T, K> {
	public List<T> selectList() throws Exception;
	public T selectOne(K k) throws Exception;
	public int insert(T t) throws Exception;
	public int update(T t) throws Exception;
	public int delete(K k) throws Exception;
}
