package com.socialgummers.christianradio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Social extends RadioActivity{

	String open_url = null;
	
	@Override
	void create(Bundle savedInBundle) {
		// TODO Auto-generated method stub
		setContentView(R.layout.social);
		
	}
	
	public void openFacebook(View v){
		openBrowser("https://www.facebook.com/radiomv");
	}
	
	public void openInstagram(View v){
		//openBrowser("");
	}
	
	public void openVimeo(View v){
		openBrowser("http://vimeo.com/user9871191");
	}
	
	public void openOdno(View v){
		openBrowser("http://www.odnoklassniki.ru/#/group/51866532315248");
	}
	
	public void openBrowser(String url){
		Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		startActivity(browserIntent);
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
 	public void gotoContact(View v){
 		finish();
 		Intent intent = new Intent(this, Contact.class);
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
