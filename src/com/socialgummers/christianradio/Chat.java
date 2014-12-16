package com.socialgummers.christianradio;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Chat extends RadioActivity {
	
	WebView webView;
	
	@Override
	void create(Bundle savedInBundle) {
		// TODO Auto-generated method stub
		setContentView(R.layout.chat);
		
		webView = (WebView) findViewById(R.id.chat_view);
		
		startWebView("http://www.shoutmix.com/v3/chat.php?id=radiomv99");
		
	}
	
	@SuppressLint("SetJavaScriptEnabled")
	private void startWebView(String url) {
        
        //Create new webview Client to show progress dialog
        //When opening a url or click on link
         
        webView.setWebViewClient(new WebViewClient() {     
            ProgressDialog progressDialog;
          
            //If you will not use this method url links are opeen in new brower not in webview
            public boolean shouldOverrideUrlLoading(WebView view, String url) {             
                view.loadUrl(url);
                return true;
            }
        
            //Show loader on url load
            public void onLoadResource (WebView view, String url) {
                if (progressDialog == null) {
                    // in standard case YourActivity.this
                    progressDialog = new ProgressDialog(Chat.this);
                    progressDialog.setMessage("Loading...");
                    progressDialog.show();
                }
            }
            public void onPageFinished(WebView view, String url) {
                try{
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                    progressDialog = null;
                }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
            }
             
        });
          
         // Javascript inabled on webview 
        webView.getSettings().setJavaScriptEnabled(true);
         
        // Other webview options
        /*
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);
        webView.getSettings().setBuiltInZoomControls(true);
        */
         
        /*
         String summary = "<html><body>You scored <b>192</b> points.</body></html>";
         webview.loadData(summary, "text/html", null);
         */
         
        //Load url in webview
        webView.loadUrl(url);
          
          
    }
	
	// Open previous opened link from history on webview when back button pressed
    
    @Override
    // Detect when the back button is pressed
    public void onBackPressed() {
        if(webView.canGoBack()) {
            webView.goBack();
        } else {
            // Let the system handle the back button
            super.onBackPressed();
            Intent intent = new Intent(this, RadioQuality.class);
    		startActivity(intent);
        }
    }
    
    // goto donate
 	public void gotoDonate(View v){ 		
 		finish();
 		Intent intent = new Intent(this, Donate.class);
 		startActivity(intent); 		
 	}
 	
 	// goto chat
 	public void gotoRadio(View v){
 		finish();
 		Intent intent = new Intent(this, Radio.class);
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
}
