package edu.autocar.tourguide;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

import edu.autoar.base.util.Input;
import edu.autocar.tourguide.dao.ITourDao;
import edu.autocar.tourguide.dao.TourDaoImpl;
import edu.autocar.tourguide.database.ConnectionProvider;
import edu.autocar.tourguide.domain.Tour;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autocar.tourguide 
 * TourExample.java 
 * 2019. 1. 16.
 * 
 *  텍스트 파일 안의 데이터를 데이터베이스에 저장하기 위한 클래스
 * </pre> 
 * 
 * 
 */
public class TourExample {
	public static void main(String[] args) {
		ITourDao dao = new TourDaoImpl();
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param dao
	 * 
	 * 파일 경로를 읽은 뒤 split함수를 통하여 데이터를 카테고리화 시킨다.
	 * 그 결과를 데이터베이스에 담는다.
	 * </pre>
	 * 
	 */
	public static void insertTest(ITourDao dao) {

		File file = new File("C:/Temp/tour100.txt");

		try (Reader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader);) {
			br.readLine();
			String line;

			while ((line = br.readLine()) != null) {
				String arr[] = line.split("\t");

				Tour tour = Tour.builder().siteName(arr[0]).state(arr[1]).district(arr[2]).contents(arr[3])
						.position(arr[4]).homepage(arr[5]).build();

				System.out.println(tour);
				if (tour == null)
					System.out.println("tour 값 null");

				int result = dao.insert(tour);
				if (result == 1) {
					System.out.println("값 입력 성공");
					ConnectionProvider.getSqlSession().commit();
				} else {
					System.out.println("값 입력 실패");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
