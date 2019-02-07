package edu.autocar.tourguide.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** 
 * @author 백상우 
 *
 * <pre> 
 * edu.autocar.tourguide.domain 
 * Tour.java 
 * 2019. 1. 16.
 * 
 * TourGuide Application 활용 및 데이터베이스의 데이터를 활용하기 위한 DTO
 * </pre> 
 * 
 * 
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tour {
	private int num;
	private String siteName;
	private String state;
	private String district;
	private String contents;
	private String position;
	private String homepage;
}
