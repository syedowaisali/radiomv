package com.socialgummers.christianradio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Donate extends RadioActivity{

	@Override
	void create(Bundle savedInBundle) {
		// TODO Auto-generated method stub
		setContentView(R.layout.donate);
	}
	
	// goto donate
 	public void gotoContact(View v){
 		
 		finish();
 		Intent intent = new Intent(this, Contact.class);
 		startActivity(intent);
 		
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
