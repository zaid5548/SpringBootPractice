package com.khan.org;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.khan.org.dao.UserPagingAndSortingRepository;
import com.khan.org.entity.User;

@SpringBootApplication
public class SpringDataPagingAndSortingRepositoryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext= SpringApplication.run(SpringDataPagingAndSortingRepositoryApplication.class, args);
		UserPagingAndSortingRepository userPagingAndSortingRepository=applicationContext.getBean(UserPagingAndSortingRepository.class);
		
		List<User> userList=getUsres();
		if(userPagingAndSortingRepository.count()==0) {
			userPagingAndSortingRepository.saveAll(userList);
		}
		
		System.out.println("Sort By Name---------------------------------------");
		userPagingAndSortingRepository.findAll(Sort.by("name").ascending()).forEach(System.out::println);
		System.out.println("Sort By Name & Age---------------------------------------");
		userPagingAndSortingRepository.findAll(Sort.by("name").and(Sort.by("age")).ascending()).forEach(System.out::println);
		System.out.println("Sort By Age---------------------------------------");
		userPagingAndSortingRepository.findAll(Sort.by("age").descending()).forEach(System.out::println);
		System.out.println("1st Page with 10 records.........");
		PageRequest pageRequest=PageRequest.of(0, 10, Sort.by("age").and(Sort.by("name")));
		userPagingAndSortingRepository.findAll(pageRequest).get().forEach(System.out::println);
		System.out.println("2st Page with 10 records.........");
		PageRequest pageRequest2=PageRequest.of(1, 10, Sort.by("age").and(Sort.by("name")));
		userPagingAndSortingRepository.findAll(pageRequest2).get().forEach(System.out::println);
	
	}

	private static List<User> getUsres() {
		List<User> userList = new ArrayList<>();
		userList.add(new User("KK", 30, LocalDate.of(1990, Month.MARCH, 10)));
		userList.add(new User("SK", 21, LocalDate.of(1999, Month.FEBRUARY, 28)));
		userList.add(new User("BK", 31, LocalDate.of(1991, Month.JUNE, 20)));
		userList.add(new User("MK", 35, LocalDate.of(1988, Month.OCTOBER, 27)));
		userList.add(new User("TK", 36, LocalDate.of(1990, Month.FEBRUARY, 18)));
		userList.add(new User("CK", 18, LocalDate.of(1992, Month.APRIL, 10)));
		userList.add(new User("DK", 45, LocalDate.of(1993, Month.AUGUST, 20)));
		userList.add(new User("FK", 29, LocalDate.of(1988, Month.JUNE, 20)));
		userList.add(new User("GK", 19, LocalDate.of(1981, Month.JUNE, 28)));
		userList.add(new User("LK", 25, LocalDate.of(1983, Month.OCTOBER, 23)));
		userList.add(new User("OK", 23, LocalDate.of(1988, Month.DECEMBER, 24)));
		userList.add(new User("EK", 56, LocalDate.of(1989, Month.SEPTEMBER, 18)));
		userList.add(new User("JK", 33, LocalDate.of(1985, Month.MAY, 19)));
		userList.add(new User("QK", 39, LocalDate.of(1980, Month.JUNE, 23)));
		userList.add(new User("AK", 44, LocalDate.of(1990, Month.AUGUST, 31)));
		userList.add(new User("BK", 45, LocalDate.of(1977, Month.JULY, 30)));
		userList.add(new User("XK", 49, LocalDate.of(1976, Month.OCTOBER, 25)));
		userList.add(new User("BK", 37, LocalDate.of(1988, Month.AUGUST, 31)));
		userList.add(new User("MK", 38, LocalDate.of(1986, Month.MARCH, 29)));
		userList.add(new User("FK", 16, LocalDate.of(1959, Month.SEPTEMBER, 28)));
		userList.add(new User("XK", 32, LocalDate.of(1959, Month.SEPTEMBER, 29)));
		userList.add(new User("ZK", 34, LocalDate.of(1959, Month.SEPTEMBER, 20)));
		return userList;
	}

}
