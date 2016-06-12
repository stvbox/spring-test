package ru.gootsite.test;

import org.springframework.beans.factory.annotation.Autowired;

public class BeeperЁ {
	@Autowired
	Beeper beeper;
	
	public void sayBeep() {
		System.out.println("BEEP!!!");
	}
}
