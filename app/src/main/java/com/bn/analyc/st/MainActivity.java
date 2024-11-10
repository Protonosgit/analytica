package com.bn.analyc.st;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.mikephil.charting.*;
import com.google.android.material.*;
import com.mrudultora.colorpicker.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import net.cachapa.expandablelayout.*;
import org.json.*;
import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private double count1 = 0;
	private double checksum = 0;
	private boolean lockf = false;
	private HashMap<String, Object> subj = new HashMap<>();
	private String prefix = "";
	private HashMap<String, Object> licensing = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> chooser = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> subjects = new ArrayList<>();
	
	private LinearLayout linear1;
	private ImageView imageview3;
	private LinearLayout linear2;
	private TextView textview1;
	private ImageView imageview1;
	
	private Intent intent = new Intent();
	private SharedPreferences sp;
	private TimerTask timer;
	private RequestNetwork hollidays;
	private RequestNetwork.RequestListener _hollidays_request_listener;
	private RequestNetwork license;
	private RequestNetwork.RequestListener _license_request_listener;
	private Calendar calendar = Calendar.getInstance();
	private Calendar calendar2 = Calendar.getInstance();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.MANAGE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.MANAGE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		imageview3 = findViewById(R.id.imageview3);
		linear2 = findViewById(R.id.linear2);
		textview1 = findViewById(R.id.textview1);
		imageview1 = findViewById(R.id.imageview1);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		hollidays = new RequestNetwork(this);
		license = new RequestNetwork(this);
		
		_hollidays_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				FileUtil.writeFile(sp.getString("prefix", "").concat("/save/hollidays.json"), _response);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_license_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				sp.edit().putString("lastLogin", new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime())).commit();
				if (_response.contains("true")) {
					sp.edit().putString("premium", "true").commit();
				}
				else {
					sp.edit().putString("premium", "false").commit();
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		
		//styles setup
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		if (sp.getString("theme", "").equals("light")) {
			if (false) {
				            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
				        } else {
				            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
				        }
		}
		if (sp.getString("theme", "").equals("dark")) {
			if (true) {
				            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
				        } else {
				            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
				        }
		}
		//key setup
		prefix = "/data/user/0/com.bn.analyc.st";
		sp.edit().putString("cpath", prefix.concat("/save/subj.list")).commit();
		sp.edit().putString("rpath", prefix.concat("/save/router.list")).commit();
		sp.edit().putString("tpath", prefix.concat("/save/susa.list")).commit();
		sp.edit().putString("dpath", prefix.concat("/data/")).commit();
		sp.edit().putString("prefix", prefix).commit();
		sp.edit().remove("tmp1").commit();
		//Collection create
		if (!FileUtil.isExistFile(sp.getString("path", ""))) {
			FileUtil.writeFile(sp.getString("path", ""), "[]");
		}
		// android version check
		if (Double.parseDouble(Build.VERSION.SDK) < 26) {
			timer.cancel();
				Toast toast = Toast.makeText(getApplicationContext(),"🔴 Veraltete Android Version 🔴", Toast.LENGTH_LONG);
				toast.show();
			intent.setClass(getApplicationContext(), DebugActivity.class);
			intent.putExtra("error", "YOUR ANDROID VERSION IS OUTDATED⚠️\n\nSupport for your Android version has been seized in this release. Please use an older build or update your device to Android 8 Oreo or above.\nWe are sorry for this inconvenience but we want to provide a good user experience and a safe environment for your data in the future.\nThank you for your understanding!");
			startActivity(intent);
			finish();
		}
		//Inject json
		if (FileUtil.isExistFile("/storage/emulated/0/Download/SchoolStats/ssm24816174.json")) {
			FileUtil.writeFile(sp.getString("path", ""), FileUtil.readFile("/storage/emulated/0/Download/SchoolStats/ssm.json"));
				Toast toast = Toast.makeText(getApplicationContext(), "Data injection done !", Toast.LENGTH_LONG);
				toast.show();
		}
		//Subject generator
		if (!FileUtil.isExistFile(sp.getString("cpath", ""))) {
			FileUtil.writeFile(sp.getString("cpath", ""), "[\n  {\n    \"id\": \"Mathematik\",\n    \"level\": \"t0\",\n    \"color\": \"-65536\"\n  },\n  {\n    \"id\": \"Deutsch\",\n    \"level\": \"t0\",\n    \"color\": \"-65536\"\n  },\n  {\n    \"id\": \"Englisch\",\n    \"level\": \"t0\",\n    \"color\": \"-65536\"\n  },\n  {\n    \"id\": \"Sport\",\n    \"level\": \"t0\",\n    \"color\": \"-65536\"\n  }\n]");
		}
		// start end grade sys
		if (!(sp.contains("Gstart") || sp.contains("Gend"))) {
			sp.edit().putString("Gstart", String.valueOf((long)(1))).commit();
			sp.edit().putString("Gend", String.valueOf((long)(6))).commit();
		}
		// start gravity sys
		if (!sp.contains("t0")) {
			sp.edit().putString("t0", "0.33").commit();
			sp.edit().putString("t1", "0.33").commit();
			sp.edit().putString("t2", "0.33").commit();
			sp.edit().putString("t3", "0.33").commit();
			sp.edit().putString("t4", "0.33").commit();
			sp.edit().putString("t5", "0.33").commit();
		}
		//request hollidays
		hollidays.startRequestNetwork(RequestNetworkController.GET, "https://ferien-api.de/api/v1/holidays", "", _hollidays_request_listener);
		licensing.put("id", Secure.getString(MainActivity.this.getContentResolver(), Secure.ANDROID_ID));
		license.setParams(licensing, RequestNetworkController.REQUEST_PARAM);
		license.startRequestNetwork(RequestNetworkController.POST, "https://x8ki-letl-twmt.n7.xano.io/api:L47yEbay/licenses", "", _license_request_listener);
		//Startup proccedure
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (!sp.getString("FortStats", "").equals("")) {
							_FortStats();
						}
						else {
							intent.setClass(getApplicationContext(), Ac1Activity.class);
							startActivity(intent);
							finish();
						}
					}
				});
			}
		};
		_timer.schedule(timer, (int)(800));
		if (!SketchwareUtil.isConnected(getApplicationContext())) {
			calendar = Calendar.getInstance();
			calendar2.set(Calendar.DAY_OF_MONTH, (int)(Double.parseDouble(sp.getString("lastLogin", "").substring((int)(0), (int)(2)))));
			calendar2.set(Calendar.MONTH, (int)(Double.parseDouble(sp.getString("lastLogin", "").substring((int)(3), (int)(5))) - 1));
			calendar2.set(Calendar.YEAR, (int)(Double.parseDouble(sp.getString("lastLogin", "").substring((int)(6), (int)(10)))));
			if ((((((long)(calendar.getTimeInMillis() - calendar2.getTimeInMillis()) / 1000) / 60) / 60) / 24) > 7) {
				sp.edit().putString("premium", "false").commit();
			}
		}
	}
	
	@Override
	public void onBackPressed() {
		
	}
	
	public void _FortStats() {
		final EditText edit0 = new EditText(this);
		edit0.setSingleLine(true);
		edit0.setHint("Pin");
		edit0.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
		AlertDialog dialoga = new MaterialAlertDialogBuilder(this)
		.setCancelable(false)
		.setView(edit0)
		    .setTitle("🔒 App gesperrt")
		    .setMessage("Gib deine Pin ein um deine Daten freizuschalten")
		    .setPositiveButton("Bestätigen", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				if (edit0.getText().toString().equals(sp.getString("FortStats", ""))) {
					intent.setClass(getApplicationContext(), Ac1Activity.class);
					startActivity(intent);
					finish();
				}
				else {
					SketchwareUtil.CustomToast(getApplicationContext(), "Falsche Pin", 0xFFBDBDBD, 16, 0xFF000000, 3, SketchwareUtil.CENTER);
					_FortStats();
				}
				    }
			 })
		                       
		  .create();
		dialoga.show();
		dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
		
		edit0.addTextChangedListener(new TextWatcher() {
						@Override
						public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
								final String edit0nn = _param1.toString();
								dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
				
				if (edit0.getText().toString().length() == 4) {
					dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
					
					SketchwareUtil.hideKeyboard(getApplicationContext());
				}
				if (edit0.getText().toString().length() > 4) {
					edit0.setText(edit0.getText().toString().substring((int)(0), (int)(4)));
				}
						}
						
						@Override
						public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
								
						}
						
						@Override
						public void afterTextChanged(Editable _param1) {
								
						}
				});
	}
	
	
	public void _paradiese() {
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
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}