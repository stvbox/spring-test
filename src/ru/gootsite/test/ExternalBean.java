package ru.gootsite.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ext")
public class ExternalBean {
	@Autowired
	Beeper beeper;
}
