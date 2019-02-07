package edu.autoar.base.util;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autoar.base.util 
 * Input.java 
 * 2019. 1. 16.
 * 
 * 여러 입력 방식을 정의한 클래스
 * </pre> 
 * 
 * 
 */
public class Input {
	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param str
	 * @return
	 * 
	 * 단순 문자열 데이터를 입력받는다. 
	 * </pre>
	 * 
	 */
	public static String getString(String str) {
		System.out.print(str);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param msg
	 * @param defaultValue
	 * @return
	 * 
	 * 입력정보가 없으면 디폴트 정보를 입력 값으로 넘긴다.
	 * </pre>
	 * 
	 */
	public static String getString(String msg, String defaultValue) {
		msg = String.format("%s (%s)", msg, defaultValue);
		Scanner scanner = new Scanner(System.in);
		String value = getString(msg);
		return value.equals("") ? defaultValue : value;
	}

	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param str
	 * @return
	 * 
	 * 정수형의 정보를 입력받는다
	 * </pre>
	 * 
	 */
	public static int getInt(String str) {
		System.out.print(str);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param msg
	 * @param defaultValue
	 * @return
	 * @throws Exception
	 * 
	 * 입력 받은 정보가 없으면 기본 정수형을 입력 값으로 지정한다.
	 * </pre>
	 * 
	 */
	public static int getInt(String msg, int defaultValue) throws Exception {
		msg = String.format("%s (%d)", msg, defaultValue);
		Scanner scanner = new Scanner(System.in);
		String value = getString(msg);
		return value.equals("") ? defaultValue : Integer.parseInt(value);
	}

	/**
	 * <pre>
	 * 2019. 1. 16.
	 * @param list
	 * @return
	 * 상세 정보를 출력하기 위한 각 데이터의 고유 숫자를 입력받는다.
	 * </pre>
	 * 
	 */
	public static int selectList(List<String> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%d] %s\n", i + 1, list.get(i));
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("선택");
		return scanner.nextInt() - 1;
	}
}
