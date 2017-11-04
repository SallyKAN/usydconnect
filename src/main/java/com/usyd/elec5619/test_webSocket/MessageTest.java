package com.usyd.elec5619.test_webSocket;

import java.util.Date;

import com.usyd.elec5619.domain.*;

import junit.framework.TestCase;

public class MessageTest extends TestCase{
	
	private Message message;
	/*
	 * 	public Long from;
	
	public String fromName;

	public Long to;
	
	public String text;
	
	public Date date;
*/
	private static long FROM_ = 100;
	private static String FROM_NAME = "CHEN";
	private static long TO_= 90;
	private static String TEXT ="THIS IS A TEST";
	public static Date date = new Date();
	
	public void testGetEveryThingFromMessage(){
		message = new Message();
		message.setDate(date);
		message.setFrom(FROM_);
		message.setFromName(FROM_NAME);
		message.setTo(TO_);
		message.setText(TEXT);
		
		assertEquals(FROM_NAME, message.getFromName());
		assertEquals(TEXT, message.getText());
		assertEquals(date, message.getDate());
		assertEquals((long)TO_, (long)message.getTo());
		assertEquals((long)message.getFrom(), FROM_);
		
	}

}
