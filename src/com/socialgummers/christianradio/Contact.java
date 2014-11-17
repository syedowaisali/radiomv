package com.socialgummers.christianradio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Contact extends RadioActivity{

	@Override
	void create(Bundle savedInBundle) {
		// TODO Auto-generated method stub
		setContentView(R.layout.contact);
	}
	
	public void openEmail(View v){
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"info@radiomv.com"});
		Intent mailer = Intent.createChooser(intent, null);
		startActivity(mailer);
	}
	
	public void openCOne(View v){
		openDialer("14252967892");
	}
	
	public void openCTwo(View v){
		openDialer("14083526127");
	}
	
	public void openCThree(View v){
		openDialer("19192839868");
	}
	
	private void openDialer(String num){
		Intent dial = new Intent();
		dial.setAction("android.intent.action.DIAL");
		dial.setData(Uri.parse("tel:" + num));
		startActivity(dial);
	}
	
	// goto donate
 	public void gotoDonate(View v){
 		/*
 		finish();
 		Intent intent = new Intent(this, Donate.class);
 		startActivity(intent);
 		*/
 	}
 	
 	// goto chat
 	public void gotoRadio(View v){
 		finish();
 		Intent intent = new Intent(this, Radio.class);
 		startActivity(intent);
 	}
 	
 	// goto social
 	public void gotoChat(View v){
 		finish();
 		Intent intent = new Intent(this, Chat.class);
 		startActivity(intent);
 	}
 	
 	// goto contact
 	public void gotoSocial(View v){
 		finish();
 		Intent intent = new Intent(this, Social.class);
 		startActivity(intent);
 	}
 	
 	@Override
	// Detect when the back button is pressed
    public void onBackPressed() {
		super.onBackPressed();
		Intent intent = new Intent(this, RadioQuality.class);
		startActivity(intent);
    }
}
