package com.b2w.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

class Task {

	public static void main(String[] args) {
		Task task = new Task();
		System.out.println(task.rearrange(120));
		System.out.println(task.rearrange(432));
	}

	public int rearrange(int n) {
		List<String> listNumbers = new ArrayList<String>();
		LinkedList<String> list = new LinkedList<String>();

		prepareList(list, n);

		addListNumber(listNumbers, list);

		popAndAddNumber(listNumbers, list);

		Collections.reverse(list);
		addListNumber(listNumbers, list);

		popAndAddNumber(listNumbers, list);

		System.out.println("List Numbers: " + listNumbers);

		listNumbers.removeIf(i -> i.startsWith("0"));
		System.out.println("Validated List: " + listNumbers);

		return listNumbers.size();
	}

	private static void popAndAddNumber(List<String> listNumbers, LinkedList<String> list) {
		for (int i = 1; i < list.size(); i++) {
			list.add(list.pop());
			addListNumber(listNumbers, list);
		}
	}

	private static void prepareList(LinkedList<String> list, int n) {
		int[] digits = Integer.toString(n).chars().map(c -> c - '0').toArray();
		List<Integer> integerList1 = Arrays.stream(digits).boxed().collect(Collectors.toList());
		integerList1.forEach(i -> list.add(i.toString()));
	}

	private static void addListNumber(List<String> listNumbers, LinkedList<String> list) {
		String number = "";
		for (String aux : list)
			number += aux;
		listNumbers.add(number);
	}
}