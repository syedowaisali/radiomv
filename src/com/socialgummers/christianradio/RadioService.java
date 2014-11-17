package com.socialgummers.christianradio;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.IBinder;
import android.util.Log;

public class RadioService extends Service{
	
    String url;
    MediaPlayer mp;
    
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
    @Override
    public void onCreate() {               
        mp = new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
    }

    @Override
    public void onDestroy() {            
        mp.stop();
        mp.release();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startid) {           

        url = intent.getExtras().getString("url");
        try{
			mp.setDataSource(url);			
			Log.d("url", url);
			mp.setOnPreparedListener(new OnPreparedListener() {
				
				@Override
				public void onPrepared(MediaPlayer mp) {
					// TODO Auto-generated method stub
					mp.start();
					Intent intent = new Intent();
					intent.setAction("radiomv.player");
					sendBroadcast(intent);
				}
			});
			mp.prepareAsync();
		}
		catch (IllegalArgumentException e){
			e.printStackTrace();
		}
		catch (IllegalStateException e){
			e.printStackTrace();
		}
		catch (IOException e){
			e.printStackTrace();
		}          
        return START_STICKY;
    }

}
