package edu.autocar.tourguide.dao;

import java.io.PrintStream;
import java.util.List;
import edu.autocar.tourguide.domain.Tour;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autocar.tourguide.dao 
 * TourGuideView.java 
 * 2019. 1. 16.
 * 
 * 사용자에게 기능별 결과를 보여주기 위한 클래스
 * </pre> 
 * 
 * 
 */

public class TourGuideView {

	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param list
	 * 
	 * 전체 리스트 출력
	 * </pre>
	 * 
	 */
	public void printList(List<Tour> list) {
		
		for (Tour tour : list) {
			basicPrint(tour);
		}
	}
	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param tour
	 * 
	 * 특정 데이터 출력
	 * </pre>
	 * 
	 */
	public void printList(Tour tour) {
		
		basicPrint(tour);
	}
	
	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param list : 지역
	 * @param num : 검색을 위한 숫자
	 * 
	 * 권역 카테고리를 사용자에게 보여준다
	 * 
	 * </pre>
	 * 
	 */
	public void printList(List<String> list, int num) {
		for(String str : list)
			System.out.println(str + "[" + (num++) +"]");
	}
	
	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param total : 전체 페이지수
	 * @param page : 해당 페이지
	 * @param list : 해당 페이지의 리스트
	 * 
	 * 특정 페이지의 데이터를 보여준다
	 * </pre>
	 * 
	 */
	public void printList(int total, int page, List<Tour> list) {
		System.out.printf("전체 페이지 수(%d) | 현재 페이지(%d)\n", total, page);
		for (Tour tour : list) {
			basicPrint(tour);
		}
	}
	
	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param tour
	 * 
	 * 특정 데이터의 정보를 상세하게 보여준다
	 * </pre>
	 * 
	 */
	public void printDetailed(Tour tour) {
		System.out.println("----------------------------------------------------------");
		System.out.printf("[명소 이름] : %s\n\n", tour.getSiteName());
		System.out.printf("[지역 이름] : %s, %s\n\n", tour.getState(), tour.getDistrict());
		System.out.printf("[홈페이지] : %s\n\n", tour.getHomepage());
		System.out.printf("[위치] : %s\n\n", tour.getPosition());
		char[] charArr = new char[tour.getContents().length()];
		System.out.printf("[상세 내용] : ");
		for(int i = 0; i < charArr.length; i++) {
			if(i != 0 && i % 100 == 0) System.out.printf("\n\t");
			else System.out.printf("%s", tour.getContents().charAt(i));
		}
		System.out.println();
		System.out.println("----------------------------------------------------------");



	}
	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param tour
	 * 
	 * 기본 출력 정보
	 * 숫자와 명소 이름, 권역, 지역의 이름을 보여준다
	 * </pre>
	 * 
	 */
	public void basicPrint(Tour tour) {
		System.out.println("[  " + tour.getNum() + "]" + " | " + tour.getSiteName() + " | " + tour.getState() + " | "
				+ tour.getDistrict());
	}
	
	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param ps
	 * @param tour
	 * 
	 * 사용자에게 입력값을 받기 위한 화면을 보여준다
	 * </pre>
	 * 
	 */
	public void printDetail(PrintStream ps, Tour tour) {
		ps.println("명소 이름 : " + tour.getSiteName());
		ps.println("시/도 : " + tour.getState());
		ps.println("지역 : " + tour.getDistrict());
		ps.println("위치 : " + tour.getPosition());
		ps.println("홈페이지 : "  + tour.getHomepage());
		ps.println("내용 : " + tour.getContents());		
	}
}
