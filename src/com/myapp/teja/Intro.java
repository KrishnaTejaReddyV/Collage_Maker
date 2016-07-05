package com.myapp.teja;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Intro extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		Thread timer=new Thread(){
			public void run(){
				try{
					sleep(8000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMenu= new Intent("com.myapp.teja.MENU");
					startActivity(openMenu);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
}
