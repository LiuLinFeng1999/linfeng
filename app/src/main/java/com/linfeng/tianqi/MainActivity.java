package com.linfeng.tianqi;

import android.app.*;
import android.os.*;
import android.content.*;
import android.preference.*;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
		if(prefs.getString("weather",null)!=null){
			Intent intent= new Intent(this,WeatherActivity.class);
			startActivity(intent);
			finish();
		}
    }
}
