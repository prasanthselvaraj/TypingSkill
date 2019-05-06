package com.pgx.java.web;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.util.comparator.Comparators;


class k {
	public int a = 5;
}

class C extends k {
	public int n = 10;

}



public class A {
	public static void main(String as[]) {
		List<Integer> mn = new ArrayList();
		List<Integer> po = Arrays.asList(22, 54, 96, 57, 54, 35, 96);
		List<String> fruit = Arrays.asList("apple","pine", "jack",  "appLe");
		//po.stream().collect(Collectors.toSet()).forEach(System.out::println);
		//fruit.stream().collect(Collectors.toSet()).forEach(System.out::println);
		//fruit.stream().map(p -> {
			//return p.toLowerCase();
		//}).collect(Collectors.toSet()).forEach(System.out::println);
		po.stream().sorted(Integer::compare).forEach(System.out::println);
		fruit.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
		mn.add(0, 1547);
		System.out.println(mn.get(0));
	}
}