package com.socialgummers.christianradio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public abstract class RadioActivity extends ActionBarActivity{
	
	public ConnectionDetector connection;
	public Chanel chanel = Chanel.getInstance();
	public static final String RU_STREAM_LOW = "http://energy10.egihosting.com:2202";
	public static final String RU_STREAM_HIGH = "http://energy10.egihosting.com:2204";
	
	public enum Station{
		RUSSIAN,
		ENGLISH,
		SPANISH,
		GERMAN
	}
	
	public enum Quality{
		HIGH,
		LOW
	}	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		connection = new ConnectionDetector(this);
		create(savedInstanceState);
	}
	
	/*
	public void gotoActivity(Class<?> act){
		Intent intent = new Intent(this, act);
		startActivity(intent);
		finish();
	}*/
	
	abstract void create(Bundle savedInBundle);
}
