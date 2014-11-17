package com.socialgummers.christianradio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RadioQuality extends RadioActivity{

	@Override
	protected void create(Bundle savedInBundle) {
		setContentView(R.layout.radio_quality);
	}
	
	// goto high quality radio station
	public void gotoHQRadio(View v){
		chanel.setQuality(Quality.HIGH);
		gotoStation();
	}
	
	// goto low quality radio station
	public void gotoLQRadio(View v){
		chanel.setQuality(Quality.LOW);
		gotoStation();
	}
	
	private void gotoStation(){
		
		setStationStream();
		finish();
		Intent intent = new Intent(this, Radio.class);
		startActivity(intent);
	}
	
	private void setStationStream(){
		Station station = chanel.getStation();
		Quality quality = chanel.getQuality();
		
		switch(station){
		
		case RUSSIAN:
			
			switch(quality){
			
			case HIGH: chanel.setStream(RU_STREAM_HIGH); break;
			case LOW: chanel.setStream(RU_STREAM_LOW); break;
			
			}
			break;
		}
	}
	
	@Override
	// Detect when the back button is pressed
    public void onBackPressed() {
		super.onBackPressed();
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
    }
}
