package com.everis.component.ZKWebTest;


public class MyViewModel {

	private int count;

	public void init() {
		count = 100;
	}

	public void cmd() {
		++count;
	}

	public int getCount() {
		return count;
	}
}
