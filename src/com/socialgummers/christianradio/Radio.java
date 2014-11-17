package com.socialgummers.christianradio;

import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class Radio extends RadioActivity{
	
	private boolean isPlay = false;
	private ImageView psImage;
	private SeekBar volumeBar;
	private ProgressDialog pDialog;
	private AudioManager audioManager;
	IntentFilter intentFilter;
	
	@Override
	protected void create(Bundle savedInBundle) {
		setContentView(R.layout.radio);
		psImage = (ImageView) findViewById(R.id.btn_radio_ps);
		volumeBar = (SeekBar) findViewById(R.id.radio_vc);
		audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
		pDialog = new ProgressDialog(this);
		pDialog.setCancelable(false);
		pDialog.setMessage("Please wait loading...");
		initVolumeControl();
		
		intentFilter = new IntentFilter();
		intentFilter.addAction("radiomv.player");
		
		if(isMyServiceRunning()){
			isPlay = true;
			psImage.setImageDrawable(this.getResources().getDrawable(R.drawable.btn_stop));
		}
		else{
			startRadio();
		}
	}
	
	// play and stop radio
	public void psRadio(View v){
		startRadio();
	}
	
	private void startRadio(){
		// play radio
		if(! isPlay){
			
			if(connection.isConnectingToInternet()){
				isPlay = true;
				psImage.setImageDrawable(this.getResources().getDrawable(R.drawable.btn_stop));
				pDialog.show();
				playRadio();
			}
			
			// internet not connect
			else{
				DialogManager dm = new DialogManager(this);
				dm.setTitle("Error").setMessage("Internet not connected.").alert();
			}
		}
		
		// stop radio
		else{
			isPlay = false;
			psImage.setImageDrawable(this.getResources().getDrawable(R.drawable.btn_play));
			stopRadio();
		}
	}
	
	private void playRadio(){
		Intent intent = new Intent(this, RadioService.class);
		intent.putExtra("url", chanel.getStream());
		startService(intent);
	}
	
	private void stopRadio(){
		stopService(new Intent(this, RadioService.class));		
	}
	
	private void initVolumeControl(){
		
		volumeBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// TODO Auto-generated method stub
				//Log.d("volume", String.valueOf(progress));
				audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, AudioManager.FLAG_PLAY_SOUND);
				//player.setVolume(progress, progress);
			}
		});
	}
	
	private boolean isMyServiceRunning() {
	    ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
	    for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
	        if (RadioService.class.getName().equals(service.service.getClassName())) {
	            return true;
	        }
	    }
	    return false;
	}
	
	private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
		/** Receives the broadcast that has been fired */
		@Override
		public void onReceive(Context context, Intent intent) {
		    if(intent.getAction()== "radiomv.player"){
		       //HERE YOU WILL GET VALUES FROM BROADCAST THROUGH INTENT EDIT YOUR TEXTVIEW///////////
		       if(pDialog.isShowing()){
		    	   pDialog.dismiss();
		       }
		    }
		}
	};
	
	@Override
	protected void onResume(){
		super.onResume();
		registerReceiver(broadcastReceiver, intentFilter);
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
		unregisterReceiver(broadcastReceiver);
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
	public void gotoChat(View v){
		finish();
		Intent intent = new Intent(this, Chat.class);
		startActivity(intent);
	}
	
	// goto social
	public void gotoSocial(View v){
		finish();
		Intent intent = new Intent(this, Social.class);
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
