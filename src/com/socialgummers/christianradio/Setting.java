package com.socialgummers.christianradio;

import java.util.regex.Pattern;

import android.graphics.Typeface;
import android.widget.TextView;

public class Setting {
	
	// status code
	public static final int ERROR = 0;
	public static final int SUCCESS = 1;
	public static final int INFO = 2;
	public static final String CHECK_OUT = "check_out";
	public static final String CHECK_IN = "check_in";
	
	// dictionary item per request
	public static final int ITEM_PER_REQUEST = 10;
	
	// set 1 second to splash screen time out
	public static final int SPLASH_TIMEOUT = 3000;
	
	// web service url
	public static final String WEB_URL = "http://www.mypromoanimation.com/dic/web_service";
	
	// bearer access token 
	public static final String TOKEN = "63d9cc58df7e024621b4a7c3507736c2d1ffe9a94ca4dab0093c48773a715351d7af0275f44c1cb015681392326b62b4";
	
	// valid email pattern
	public static final Pattern EMAIL_ADDRESS_PATTERN = Pattern.compile(
		"[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
		"\\@" +
	    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
	    "(" +
	    "\\." +
	    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
	    ")+"
	);
	
	
}
