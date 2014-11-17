package com.socialgummers.christianradio;

import com.socialgummers.christianradio.RadioActivity.Quality;
import com.socialgummers.christianradio.RadioActivity.Station;

public class Chanel {
	
	public static final Chanel INSTANCE = new Chanel();
	
	private Station station;
	private Quality quality;
	private String stream;
	
	public Chanel(){}
	
	// get chanel instance
	public static Chanel getInstance(){
		if(INSTANCE == null){
			return new Chanel();
		}
		else{
			return INSTANCE;
		}
	}
	
	public void setStation(Station s){
		this.station = s;
	}
	
	public Station getStation(){
		return this.station;
	}
	
	public void setQuality(Quality q){
		this.quality = q;
	}
	
	public Quality getQuality(){
		return this.quality;
	}
	
	public void setStream(String s){
		this.stream = s;
	}
	
	public String getStream(){
		return this.stream;
	}
}
