package com.socialgummers.christianradio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends RadioActivity {

	@Override
	protected void create(Bundle savedInBundle) {
		setContentView(R.layout.activity_main);
		
	}
	
	// goto russion radio
	public void gotoRURadio(View v){
		chanel.setStation(Station.RUSSIAN);
		
		finish();
		Intent intent = new Intent(this, RadioQuality.class);
		startActivity(intent);
		
	}
	
	// goto english radio
	public void gotoENRadio(View v){
		
	}
	
	// goto spanish radio
	public void gotoSPRadio(View v){
		
	}
	
	// goto german radio
	public void gotoGRRadio(View v){
		
	}

}
