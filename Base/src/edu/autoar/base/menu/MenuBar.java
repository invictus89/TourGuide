package edu.autoar.base.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autoar.base.menu 
 * MenuBar.java 
 * 2019. 1. 16.
 * 
 * 애플리케이션에 공통으로 적용될 메뉴를 구성한다.
 * </pre> 
 * 
 * 
 */
public class MenuBar {
	List<MenuItem> list;
	Map<String, MenuItem> map;
	
	public MenuBar() {
		// TODO Auto-generated constructor stub
		list = new ArrayList();
		map = new HashMap<>();
	}
	
	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param item
	 * 
	 * 메뉴를 리스트에 추가한다.
	 * </pre>
	 * 
	 */
	public void add(MenuItem item) {
		list.add(item);
		map.put(item.getHotKey(), item);
	}
	public void print() {
		for(MenuItem item : list) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
	
	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param hotKey
	 * @throws Exception
	 * 
	 * 맵의 Key를 이용하여 해당 메뉴의 기능을 실행한다
	 * </pre>
	 * 
	 */
	public void execute(String hotKey) throws Exception{
		MenuItem item = map.get(hotKey);
		if(item != null) {
			item.execute();
		}
	}
}