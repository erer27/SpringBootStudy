package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 서버 구동 => Spring - App
// 환경 설정 => XML => properties , yml
// 버전관리 / 라이브러리 관리 / 프로젝트 관리 => maven / gradle
/*
 * 	스프링 부트
 * 	  => 스프링 프레임워크를 기반 웹개발을 단순화하고 빠른 개발 / 배포 지원
 * 	  => XML 설정없이 간단하게 구성 => 자동 구성 , 내장 웹 서버를 가지고 있다
 * 	  => 스프링 프레임워크 / Java , Kotlin
 *	
 *	  => 웹 : JSP , Front (Vue3,Vuex,react,react-query) 
 * 
 * 
 * 
 */
@SpringBootApplication

public class SpringBootReactQuery2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactQuery2Application.class, args);
	}

}
