package com.test;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {

	@Override
	public IBinder onBind(Intent intent) {

		return null;

	}

	@Override
	public void onCreate() {
		Log.d("BOOT", "Svc OnCreate");
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		SharedPreferences.Editor editor = prefs.edit();
		
		String log = prefs.getString("Log", "No log found") +"Svc OnCreate\n";
		editor.putString("Log", log);
		editor.apply();
		
		Toast.makeText(this, "Service Created", Toast.LENGTH_LONG).show();
		log = log + "Service Toast\n";
		editor.putString("Log", log);
		editor.apply();
		
		log = log + "Service Notification Manager\n";
		editor.putString("Log", log);
		editor.apply();
		
		
		int icon = R.drawable.ic_launcher;
		CharSequence tickerText = "CheckLog";
		long when = System.currentTimeMillis();
		Notification notification = new Notification(icon, tickerText, when);
		
		Intent notificationIntent = new Intent (this, CheckLog.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
		notification.setLatestEventInfo(this, "Check Log", "Check the application log", pendingIntent);
		
		log = log + "Service new notif\n";
		editor.putString("Log", log);
		editor.apply();
		
		this.startForeground(1337, notification);
		log = log + "Service start foreground\n";
		editor.putString("Log", log);
		editor.apply();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
		return START_STICKY;

	}
}