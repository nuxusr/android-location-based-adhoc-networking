package com.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

public class MyStartupIntentReceiver extends BroadcastReceiver{
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("BOOT", "Broadcast Receiver onReceive");
		String log = "Broadcast Receiver onReceive\n";
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = prefs.edit();
		
		editor.putString("Log", log);
		editor.apply();
		
		Intent serviceIntent = new Intent();
		log = log + "Broadcast Receiver new Intent()\n";
		editor.putString("Log", log);
		editor.apply();
		
		
		Toast.makeText(context, "On Receive", Toast.LENGTH_LONG).show();
		log = log + "Broadcast Receiver Toast\n";
		editor.putString("Log", log);
		editor.apply();
		
		serviceIntent.setAction("com.test.MyService");
		log = log + "Broadcast Receiver setAction\n";
		editor.putString("Log", log);
		editor.apply();
		
		
		
		context.startService(serviceIntent);
		
		
	}
}
