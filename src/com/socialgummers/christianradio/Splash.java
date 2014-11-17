package com.socialgummers.christianradio;

import android.view.MotionEvent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class Splash extends RadioActivity {
	
	final Splash sSplashScreen = this;
	
	@Override
	protected void create(Bundle savedInBundle) {
		setContentView(R.layout.splash);
		
		handler.postDelayed(runnable, Setting.SPLASH_TIMEOUT);	
		
	}

	final Handler handler = new Handler();
	final Runnable runnable = new Runnable()
	{
		public void run()
		{	
			startMainActivity();
		}
	};	
	
	/**
     * Processes splash screen touch events
     */
	@Override
	public boolean onTouchEvent(MotionEvent evt)
	{
		if(evt.getAction() == MotionEvent.ACTION_DOWN)
		{
			handler.removeCallbacks(runnable);
			startMainActivity();			
		}
		return true;
	}
	
	public void startMainActivity()
	{
		finish();
		
		// Run next activity
		Intent intent = new Intent(sSplashScreen, MainActivity.class);		
		startActivity(intent);
	}
	
	@Override
	public void onBackPressed(){
		super.onBackPressed();
		handler.removeCallbacks(runnable);
	}
}
