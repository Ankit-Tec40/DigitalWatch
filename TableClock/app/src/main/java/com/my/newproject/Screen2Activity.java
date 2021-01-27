package com.my.newproject;

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
import android.widget.ImageView;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.AdListener;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

public class Screen2Activity extends Activity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private TextView hrid;
	private TextView textview2;
	private TextView minid;
	private TextView textview4;
	private TextView secid;
	private TextView dateid;
	private ImageView settingimage;
	private ImageView rotateimage;
	
	private Calendar calender = Calendar.getInstance();
	private TimerTask timer;
	private Intent intent = new Intent();
	private InterstitialAd interstitialad;
	private AdListener _interstitialad_ad_listener;
	private SharedPreferences themedata;
	private AlertDialog.Builder dialog;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.screen2);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		hrid = (TextView) findViewById(R.id.hrid);
		textview2 = (TextView) findViewById(R.id.textview2);
		minid = (TextView) findViewById(R.id.minid);
		textview4 = (TextView) findViewById(R.id.textview4);
		secid = (TextView) findViewById(R.id.secid);
		dateid = (TextView) findViewById(R.id.dateid);
		settingimage = (ImageView) findViewById(R.id.settingimage);
		rotateimage = (ImageView) findViewById(R.id.rotateimage);
		themedata = getSharedPreferences("themedata", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		settingimage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), SettingActivity.class);
				startActivity(intent);
				interstitialad.show();
			}
		});
		
		rotateimage.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), MainActivity.class);
				startActivity(intent);
			}
		});
		
		_interstitialad_ad_listener = new AdListener() {
			@Override
			public void onAdLoaded() {
				
			}
			
			@Override
			public void onAdFailedToLoad(int _param1) {
				final int _errorCode = _param1;
				
			}
			
			@Override
			public void onAdOpened() {
				
			}
			
			@Override
			public void onAdClosed() {
				
			}
		};
	}
	private void initializeLogic() {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		_theme();
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						calender = Calendar.getInstance();
						hrid.setText(new SimpleDateFormat("hh").format(calender.getTime()));
						minid.setText(new SimpleDateFormat("mm").format(calender.getTime()));
						secid.setText(new SimpleDateFormat("ss").format(calender.getTime()));
						dateid.setText(new SimpleDateFormat("dd-MM-yyyy").format(calender.getTime()));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(1000), (int)(1000));
		interstitialad = new InterstitialAd(getApplicationContext());
		interstitialad.setAdListener(_interstitialad_ad_listener);
		interstitialad.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
		interstitialad.loadAd(new AdRequest.Builder().addTestDevice("4DA114242B04025B7B135C6FB8F8AC21")
		.build());
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
		dialog.setMessage("Do you want to exit");
		dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finishAffinity();
			}
		});
		dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				SketchwareUtil.showMessage(getApplicationContext(), "Ok");
			}
		});
		dialog.create().show();
	}
	private void _theme () {
		if (themedata.getString("themedata", "").equals("Dark")) {
			linear1.setBackgroundColor(0xFF000000);
			linear2.setBackgroundColor(0xFF000000);
			linear3.setBackgroundColor(0xFF000000);
			hrid.setTextColor(0xFFFFFFFF);
			minid.setTextColor(0xFFFFFFFF);
			secid.setTextColor(0xFFFFFFFF);
			dateid.setTextColor(0xFFFFFFFF);
			textview2.setTextColor(0xFFFFFFFF);
			textview4.setTextColor(0xFFFFFFFF);
			rotateimage.setImageResource(R.drawable.ic_screen_rotation_white);
			settingimage.setImageResource(R.drawable.ic_style_white);
		}
		else {
			linear1.setBackgroundColor(0xFFFFFFFF);
			linear2.setBackgroundColor(0xFFFFFFFF);
			linear3.setBackgroundColor(0xFFFFFFFF);
			hrid.setTextColor(0xFF000000);
			minid.setTextColor(0xFF000000);
			secid.setTextColor(0xFF000000);
			dateid.setTextColor(0xFF000000);
			textview2.setTextColor(0xFF000000);
			textview4.setTextColor(0xFF000000);
			rotateimage.setImageResource(R.drawable.ic_screen_rotation_black);
			settingimage.setImageResource(R.drawable.ic_style_black);
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
