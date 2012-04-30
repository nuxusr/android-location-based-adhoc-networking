package com.test;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class CheckLog extends Activity{

	
	public void onCreate(Bundle bundle){
		super.onCreate(bundle);
		this.setContentView(R.layout.main);
		
		TextView textview = (TextView) this.findViewById(R.id.text);
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		String text = prefs.getString("Log", "No log found");
		textview.setText(text);
	}
}
