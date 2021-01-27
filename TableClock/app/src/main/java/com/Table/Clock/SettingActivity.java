package com.Table.Clock;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.Button;
import android.content.SharedPreferences;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class SettingActivity extends Activity {
	
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear16;
	private TextView textview1;
	private ScrollView vscroll1;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private LinearLayout linear17;
	private Button darhthemeid;
	private Button lightthemeid;
	
	private SharedPreferences themedata;
	private Intent intent = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.setting);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		textview1 = (TextView) findViewById(R.id.textview1);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		darhthemeid = (Button) findViewById(R.id.darhthemeid);
		lightthemeid = (Button) findViewById(R.id.lightthemeid);
		themedata = getSharedPreferences("themedata", Activity.MODE_PRIVATE);
		
		linear17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		darhthemeid.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				themedata.edit().putString("themedata", darhthemeid.getText().toString()).commit();
				darhthemeid.setBackgroundResource(R.drawable.ic_check_white);
				darhthemeid.setTextColor(0xFF1B5E20);
				lightthemeid.setBackgroundResource(0);
				lightthemeid.setTextColor(0xFF000000);
				_theme();
			}
		});
		
		lightthemeid.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				themedata.edit().putString("themedata", lightthemeid.getText().toString()).commit();
				lightthemeid.setBackgroundResource(R.drawable.ic_check_black);
				lightthemeid.setTextColor(0xFF1B5E20);
				darhthemeid.setBackgroundResource(0);
				darhthemeid.setTextColor(0xFFFFFFFF);
				_theme();
			}
		});
	}
	private void initializeLogic() {
		_theme();
		
		
		
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		intent.setClass(getApplicationContext(), MainActivity.class);
		startActivity(intent);
		
	}
	private void _theme () {
		if (themedata.getString("themedata", "").equals("Dark")) {
			linear1.setBackgroundColor(0xFF000000);
			linear3.setBackgroundColor(0xFF000000);
			linear4.setBackgroundColor(0xFF000000);
			linear16.setBackgroundColor(0xFF000000);
			linear5.setBackgroundColor(0xFF000000);
			textview1.setTextColor(0xFFFFFFFF);
		}
		else {
			linear1.setBackgroundColor(0xFFFFFFFF);
			linear3.setBackgroundColor(0xFFFFFFFF);
			linear4.setBackgroundColor(0xFFFFFFFF);
			linear16.setBackgroundColor(0xFFFFFFFF);
			linear5.setBackgroundColor(0xFFFFFFFF);
			textview1.setTextColor(0xFF000000);
		}
		if (themedata.getString("themedata", "").equals("Dark")) {
			darhthemeid.setBackgroundResource(R.drawable.ic_check_white);
			darhthemeid.setTextColor(0xFF1B5E20);
			lightthemeid.setBackgroundResource(0);
			lightthemeid.setTextColor(0xFF000000);
		}
		else {
			lightthemeid.setBackgroundResource(R.drawable.ic_check_black);
			lightthemeid.setTextColor(0xFF1B5E20);
			darhthemeid.setBackgroundResource(0);
			darhthemeid.setTextColor(0xFFFFFFFF);
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
