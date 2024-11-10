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
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.github.mikephil.charting.*;
import com.google.android.material.*;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mrudultora.colorpicker.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.DecimalFormat;
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
import java.io.File;
import java.io.FileOutputStream;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.components.*;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.*;
import com.github.mikephil.charting.data.*;

public class Ac1Activity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	private boolean washit = false;
	private double iter = 0;
	private boolean hollidaysFound = false;
	private double nextholiday = 0;
	private double gradeSum = 0;
	private double newcalc = 0;
	private HashMap<String, Object> msg = new HashMap<>();
	
	private ArrayList<HashMap<String, Object>> holidays = new ArrayList<>();
	private ArrayList<String> states = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> hollidayFilter = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> dataCheck = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> analysisPreview = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> graphCarusel = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private LinearLayout linear15;
	private LinearLayout linear17;
	private LinearLayout linear29;
	private LinearLayout linear16;
	private ImageView imageview7;
	private TextView textview8;
	private TextView textview4;
	private TextView textview3;
	private LinearLayout chart2;
	private TextView textview45;
	private LineChart chart1;
	private LinearLayout linear23;
	private LinearLayout linear21;
	private LinearLayout betawindow;
	private LinearLayout linear33;
	private TextView textview47;
	private LinearLayout linear26;
	private LinearLayout linear37;
	private LinearLayout frame2;
	private LinearLayout linear35;
	private LinearLayout linear38;
	private LinearLayout linear39;
	private ImageView imageview9;
	private TextView textview19;
	private ImageView imageview10;
	private TextView textview20;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private TextView textview23;
	private TextView textview24;
	private TextView textview25;
	private TextView textview44;
	private ImageView imageview12;
	private LinearLayout linear25;
	private TextView textview13;
	private ImageView imageview5;
	private TextView textview11;
	private LinearLayout linear24;
	private TextView textview12;
	private ImageView imageview4;
	private TextView textview10;
	private TextView textview46;
	private ViewPager viewpager2;
	private LinearLayout linear34;
	private TextView textview21;
	private ImageView imageview11;
	private TextView textview22;
	private LinearLayout linear27;
	private TextView textview15;
	private TextView textview14;
	private ImageView imageview6;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_linear3;
	private TextView _drawer_textview1;
	private LinearLayout _drawer_op2;
	private LinearLayout _drawer_op3;
	private LinearLayout _drawer_op4;
	private LinearLayout _drawer_op5;

	private LinearLayout _drawer_op_subject;
	private LinearLayout _drawer_op_settings;
	private LinearLayout _drawer_op_help;
	private TextView _drawer_textview14;
	private ImageView _drawer_imageview4;
	private TextView _drawer_textview6;
	private ImageView _drawer_imageview12;
	private ImageView _drawer_imageview13;
	private TextView _drawer_textview11;
	private ImageView _drawer_imageview14;
	private ImageView _drawer_imageview15;
	private TextView _drawer_textview12;
	private ImageView _drawer_imageview16;
	private ImageView _drawer_imageview17;
	private TextView _drawer_textview13;
	private ImageView _drawer_imageview18;
	private ImageView _drawer_imageview3;
	private TextView _drawer_textview3;
	private ImageView _drawer_imageview2;
	private TextView _drawer_textview4;
	private ImageView _drawer_imageview8;
	private TextView _drawer_textview10;
	
	private Intent intent = new Intent();
	private SharedPreferences sp;
	private TimerTask timer;
	private Calendar calendar = Calendar.getInstance();
	private Calendar sholliday = Calendar.getInstance();
	private Calendar eholliday = Calendar.getInstance();
	private RequestNetwork messenger;
	private RequestNetwork.RequestListener _messenger_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.ac1);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
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
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(Ac1Activity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		vscroll1 = findViewById(R.id.vscroll1);
		linear1 = findViewById(R.id.linear1);
		linear15 = findViewById(R.id.linear15);
		linear17 = findViewById(R.id.linear17);
		linear29 = findViewById(R.id.linear29);
		linear16 = findViewById(R.id.linear16);
		imageview7 = findViewById(R.id.imageview7);
		textview8 = findViewById(R.id.textview8);
		textview4 = findViewById(R.id.textview4);
		textview3 = findViewById(R.id.textview3);
		chart2 = findViewById(R.id.chart2);
		textview45 = findViewById(R.id.textview45);
		chart1 = findViewById(R.id.chart1);
		linear23 = findViewById(R.id.linear23);
		linear21 = findViewById(R.id.linear21);
		betawindow = findViewById(R.id.betawindow);
		linear33 = findViewById(R.id.linear33);
		textview47 = findViewById(R.id.textview47);
		linear26 = findViewById(R.id.linear26);
		linear37 = findViewById(R.id.linear37);
		frame2 = findViewById(R.id.frame2);
		linear35 = findViewById(R.id.linear35);
		linear38 = findViewById(R.id.linear38);
		linear39 = findViewById(R.id.linear39);
		imageview9 = findViewById(R.id.imageview9);
		textview19 = findViewById(R.id.textview19);
		imageview10 = findViewById(R.id.imageview10);
		textview20 = findViewById(R.id.textview20);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		textview23 = findViewById(R.id.textview23);
		textview24 = findViewById(R.id.textview24);
		textview25 = findViewById(R.id.textview25);
		textview44 = findViewById(R.id.textview44);
		imageview12 = findViewById(R.id.imageview12);
		linear25 = findViewById(R.id.linear25);
		textview13 = findViewById(R.id.textview13);
		imageview5 = findViewById(R.id.imageview5);
		textview11 = findViewById(R.id.textview11);
		linear24 = findViewById(R.id.linear24);
		textview12 = findViewById(R.id.textview12);
		imageview4 = findViewById(R.id.imageview4);
		textview10 = findViewById(R.id.textview10);
		textview46 = findViewById(R.id.textview46);
		viewpager2 = findViewById(R.id.viewpager2);
		linear34 = findViewById(R.id.linear34);
		textview21 = findViewById(R.id.textview21);
		imageview11 = findViewById(R.id.imageview11);
		textview22 = findViewById(R.id.textview22);
		linear27 = findViewById(R.id.linear27);
		textview15 = findViewById(R.id.textview15);
		textview14 = findViewById(R.id.textview14);
		imageview6 = findViewById(R.id.imageview6);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_linear3 = _nav_view.findViewById(R.id.linear3);
		_drawer_textview1 = _nav_view.findViewById(R.id.textview1);
		_drawer_op2 = _nav_view.findViewById(R.id.op2);
		_drawer_op3 = _nav_view.findViewById(R.id.op3);
		_drawer_op4 = _nav_view.findViewById(R.id.op4);
		_drawer_op5 = _nav_view.findViewById(R.id.op5);

		_drawer_op_subject = _nav_view.findViewById(R.id.op_subject);
		_drawer_op_settings = _nav_view.findViewById(R.id.op_settings);
		_drawer_op_help = _nav_view.findViewById(R.id.op_help);
		_drawer_textview14 = _nav_view.findViewById(R.id.textview14);
		_drawer_imageview4 = _nav_view.findViewById(R.id.imageview4);
		_drawer_textview6 = _nav_view.findViewById(R.id.textview6);
		_drawer_imageview12 = _nav_view.findViewById(R.id.imageview12);
		_drawer_imageview13 = _nav_view.findViewById(R.id.imageview13);
		_drawer_textview11 = _nav_view.findViewById(R.id.textview11);
		_drawer_imageview14 = _nav_view.findViewById(R.id.imageview14);
		_drawer_imageview15 = _nav_view.findViewById(R.id.imageview15);
		_drawer_textview12 = _nav_view.findViewById(R.id.textview12);
		_drawer_imageview16 = _nav_view.findViewById(R.id.imageview16);
		_drawer_imageview17 = _nav_view.findViewById(R.id.imageview17);
		_drawer_textview13 = _nav_view.findViewById(R.id.textview13);
		_drawer_imageview18 = _nav_view.findViewById(R.id.imageview18);
		_drawer_imageview3 = _nav_view.findViewById(R.id.imageview3);
		_drawer_textview3 = _nav_view.findViewById(R.id.textview3);
		_drawer_imageview2 = _nav_view.findViewById(R.id.imageview2);
		_drawer_textview4 = _nav_view.findViewById(R.id.textview4);
		_drawer_imageview8 = _nav_view.findViewById(R.id.imageview8);
		_drawer_textview10 = _nav_view.findViewById(R.id.textview10);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		messenger = new RequestNetwork(this);
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.openDrawer(GravityCompat.START);
			}
		});
		
		textview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				textview8.setTextColor((int) -65536);
					Toast toast = Toast.makeText(getApplicationContext(),"It's Wednesday 🐸", Toast.LENGTH_SHORT);
					toast.show();
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		textview45.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sp.getString("premium", "").equals("true")) {
					chart1.saveToGallery("history_chart");
					com.google.android.material.snackbar.Snackbar.make(linear1, "✅️ In Galerie exportiert", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
						@Override
						public void onClick(View _view) {
							 
						}
					}).show();
				}
				else {
					com.google.android.material.snackbar.Snackbar.make(linear1, "🪅 Du brauchst Premium um dieses Feature zu nutzen", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Holen", new View.OnClickListener(){
						@Override
						public void onClick(View _view) {
							intent.putExtra("tmp1", "s2");
							SysDialogFragmentActivity dialog = new SysDialogFragmentActivity();
							dialog.show(getSupportFragmentManager(),"1");
						}
					}).show();
				}
			}
		});
		
		linear23.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				if (!sp.getString("path", "").equals("")) {
					if (FileUtil.isExistFile(sp.getString("path", ""))) {
						FileUtil.writeFile("[]", sp.getString("path", ""));
					}
					intent.setClass(getApplicationContext(), EditActivity.class);
					sp.edit().putString("pointer", "+").commit();
					intent.putExtra("switch", "two");
					intent.putExtra("def", "e");
					startActivity(intent);
				}
				else {
					com.google.android.material.snackbar.Snackbar.make(linear1, "🚫 Du hast keine Kollektion erstellt!", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Erstellen", new View.OnClickListener(){
						@Override
						public void onClick(View _view) {
							linear21.performClick();
						}
					}).show();
				}
				return true;
			}
		});
		
		linear23.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!sp.getString("path", "").equals("")) {
					if (FileUtil.isExistFile(sp.getString("path", ""))) {
						FileUtil.writeFile("[]", sp.getString("path", ""));
					}
					intent.setClass(getApplicationContext(), EditActivity.class);
					intent.putExtra("switch", "two");
					intent.putExtra("def", "n");
					startActivity(intent);
				}
				else {
					com.google.android.material.snackbar.Snackbar.make(linear1, "🚫 Du hast keine Kollektion erstellt!", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Erstellen", new View.OnClickListener(){
						@Override
						public void onClick(View _view) {
							linear21.performClick();
						}
					}).show();
				}
			}
		});
		
		linear21.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				DiaDialogFragmentActivity dialog = new DiaDialogFragmentActivity();
				dialog.show(getSupportFragmentManager(),"1");
			}
		});
		
		linear33.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), FinaActivity.class);
				startActivity(intent);
			}
		});
		
		linear26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				sp.edit().putString("tmp1", "s2").commit();
				SysDialogFragmentActivity dialog = new SysDialogFragmentActivity();
				dialog.show(getSupportFragmentManager(),"1");
			}
		});
		
		viewpager2.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int _position, float _positionOffset, int _positionOffsetPixels) {
				
			}
			
			@Override
			public void onPageSelected(int _position) {
				textview46.setText(String.valueOf((long)(_position + 1)).concat(" / 3"));
			}
			
			@Override
			public void onPageScrollStateChanged(int _scrollState) {
				
			}
		});
		
		_messenger_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				FileUtil.writeFile(sp.getString("prefix", "").concat("/save/message.list"), _response);
				_messenger_handler(_response);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				_messenger_handler(FileUtil.readFile(sp.getString("prefix", "").concat("/save/message.list")));
			}
		};
		
		_drawer_op2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webdirect("https://moodle.com/de/");
			}
		});
		
		_drawer_op3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webdirect("https://www.wolframalpha.com/");
			}
		});
		
		_drawer_op4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webdirect("https://simpleclub.com/");
			}
		});
		
		_drawer_op5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_webdirect("https://studyflix.de/");
			}
		});
		
		_drawer_op_subject.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SubjectsDialogFragmentActivity dialog = new SubjectsDialogFragmentActivity();
				dialog.show(getSupportFragmentManager(),"1");
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_op_settings.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
				SetingsDialogFragmentActivity dialog = new SetingsDialogFragmentActivity();
				dialog.show(getSupportFragmentManager(),"1");
			}
		});
		
		_drawer_op_help.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
				sp.edit().putString("tmp1", "s1").commit();
				SysDialogFragmentActivity dialog = new SysDialogFragmentActivity();
				dialog.show(getSupportFragmentManager(),"1");
			}
		});
	}
	
	private void initializeLogic() {
		
		linear26.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFDD835));
		_RoundCorner(linear8, "#75FF03", "#8BC34A", 20, 20, 0, 0);
		_RoundCorner(linear10, "#FF1744", "#E0E0E0", 0, 0, 20, 20);
		try{
				getSupportActionBar().hide();
		}catch(Exception e){}
		textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/xonuim.otf"), 1);
		
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						calendar = Calendar.getInstance();
						textview3.setText(new SimpleDateFormat("HH:mm:ss").format(calendar.getTime()));
						textview4.setText(new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime()).concat("   KW: ".concat(new SimpleDateFormat("w").format(calendar.getTime()))));
						if ((Double.parseDouble(new SimpleDateFormat("w").format(calendar.getTime())) % 2) == 0) {
							if (sp.getString("weekin", "").equals("true")) {
								textview4.setText(textview4.getText().toString().concat(" B"));
							}
							else {
								textview4.setText(textview4.getText().toString().concat(" A"));
							}
						}
						else {
							if (sp.getString("weekin", "").equals("true")) {
								textview4.setText(textview4.getText().toString().concat(" A"));
							}
							else {
								textview4.setText(textview4.getText().toString().concat(" B"));
							}
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(timer, (int)(400), (int)(1000));
		if (sp.getString("premium", "").equals("true")) {
			linear26.setVisibility(View.GONE);
			chart1.setHardwareAccelerationEnabled(true);
			chart1.setScaleEnabled(true);
			chart1.invalidate();
		}
		else {
			chart1.setHardwareAccelerationEnabled(false);
			chart1.setScaleEnabled(false);
			chart1.invalidate();
		}
		if (sp.getString("showHollidays", "").equals("false")) {
			
		}
		if (sp.getString("experimental", "").equals("true")) {
			
		}
		else {
			betawindow.setVisibility(View.GONE);
			textview47.setVisibility(View.GONE);
		}
		_onboarding();
		_stats_preview();
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("num", "history");
			graphCarusel.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("num", "gradeGravity");
			graphCarusel.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("num", "typeCake");
			graphCarusel.add(_item);
		}
		
		viewpager2.setAdapter(new Viewpager2Adapter(graphCarusel));
		((PagerAdapter)viewpager2.getAdapter()).notifyDataSetChanged();
		messenger.startRequestNetwork(RequestNetworkController.GET, "https://x8ki-letl-twmt.n7.xano.io/api:aqI2vnIF/messages", "", _messenger_request_listener);
		if (!SketchwareUtil.isConnected(getApplicationContext())) {
			msg = new Gson().fromJson(FileUtil.readFile(sp.getString("prefix", "").concat("/save/message.list")).replace("]", "").replace("[", ""), new TypeToken<HashMap<String, Object>>(){}.getType());
			if ((boolean)msg.get("active")) {
				new MaterialAlertDialogBuilder(this)
				    .setTitle(msg.get("message").toString())
				    .setMessage(msg.get("title").toString())
				    .setCancelable((boolean) (boolean)msg.get("cancelable"))
				    .show();
			}
		}
	}
	
	
	@Override
	public void onResume() {
		super.onResume();
		_stats_preview();
	}
	
	@Override
	public void onBackPressed() {
		finishAffinity();
	}
	public void _webdirect(final String _url) {
		if (sp.getString("disclaimer", "").equals("true")) {
			intent.setAction(Intent.ACTION_VIEW);
			intent.setData(Uri.parse(_url));
			startActivity(intent);
		}
		else {
			new MaterialAlertDialogBuilder(this)
			    .setTitle("ℹ️ Information")
			    .setMessage("Die hier gelisteten Websites sind NICHT teil dieser App sonder lediglich eine kuratierte Auswahl und die Entwickler dieser App haben keinerlei Einfluss auf den Inhalt der Internetseiten!\nAlle eingetragen Informationen und Daten können im Zweifelsfall mit Dritten geteilt werden (siehe privacy policy der Websiten).\nNutzen der Hilfsmittel auf eigene Gefahr.")
			    .setPositiveButton("Bestätigen", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					sp.edit().putString("disclaimer", "true").commit();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setData(Uri.parse(_url));
					startActivity(intent);
					    }
				 })
			                       
			     .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					 
					    }
				 })
			                       
			    .show();
		}
	}
	
	
	public void _hollidays() {
		states.add("BW");
		states.add("BY");
		states.add("BE");
		states.add("BB");
		states.add("HB");
		states.add("HH");
		states.add("HE");
		states.add("NI");
		states.add("MV");
		states.add("NW");
		states.add("RP");
		states.add("SL");
		states.add("SN");
		states.add("ST");
		states.add("SH");
		states.add("TH");
		holidays = new Gson().fromJson(FileUtil.readFile(sp.getString("prefix", "").concat("/save/hollidays.json")), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		iter = 0;
		for(int _repeat11 = 0; _repeat11 < (int)(holidays.size()); _repeat11++) {
			if (holidays.get((int)iter).get("stateCode").toString().equals(states.get((int)(Double.parseDouble(sp.getString("state", ""))))) && holidays.get((int)iter).get("year").toString().equals(new SimpleDateFormat("yyyy").format(calendar.getTime()).concat(".0"))) {
				hollidayFilter.add(holidays.get((int)(iter)));
			}
			iter++;
		}
		iter = 0;
		hollidaysFound = false;
		for(int _repeat93 = 0; _repeat93 < (int)(hollidayFilter.size()); _repeat93++) {
			sholliday.set(Calendar.DAY_OF_MONTH, (int)(Double.parseDouble(hollidayFilter.get((int)iter).get("start").toString().substring((int)(8), (int)(10)))));
			sholliday.set(Calendar.MONTH, (int)(Double.parseDouble(hollidayFilter.get((int)iter).get("start").toString().substring((int)(5), (int)(7))) - 1));
			sholliday.set(Calendar.YEAR, (int)(Double.parseDouble(hollidayFilter.get((int)iter).get("start").toString().substring((int)(0), (int)(4)))));
			eholliday.set(Calendar.YEAR, (int)(Double.parseDouble(hollidayFilter.get((int)iter).get("end").toString().substring((int)(0), (int)(4)))));
			eholliday.set(Calendar.MONTH, (int)(Double.parseDouble(hollidayFilter.get((int)iter).get("end").toString().substring((int)(5), (int)(7))) - 1));
			eholliday.set(Calendar.DAY_OF_MONTH, (int)(Double.parseDouble(hollidayFilter.get((int)iter).get("end").toString().substring((int)(8), (int)(10)))));
			if (((long)(calendar.getTimeInMillis() - sholliday.getTimeInMillis()) > 1) && ((long)(calendar.getTimeInMillis() - eholliday.getTimeInMillis()) < 1)) {
				textview47.setText("Aktuell: ".concat(hollidayFilter.get((int)iter).get("name").toString()));
				hollidaysFound = true;
			}
			iter++;
		}
	}
	
	
	public void _onboarding() {
		if (!sp.contains("info")) {
			final EditText edit0 = new EditText(Ac1Activity.this);
			edit0.setSingleLine(true);
			edit0.setHint("Name der Kollektion");
			AlertDialog dialoga = new MaterialAlertDialogBuilder(this)
			.setCancelable(false)
			.setView(edit0)
			    .setTitle("👋 Willkommen")
			    .setMessage("Um zu starten wähle bitte einen Namen für deine erste Kollektion")
			    .setPositiveButton("Fertig", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialogInterface, int i) {
					sp.edit().putString("info", "true").commit();
					FileUtil.writeFile(sp.getString("prefix", "").concat("/data/".concat(edit0.getText().toString().trim().concat(".pajs"))), "[]");
					sp.edit().putString("path", sp.getString("prefix", "").concat("/data/".concat(edit0.getText().toString().trim().concat(".pajs")))).commit();
					com.google.android.material.snackbar.Snackbar.make(linear1, "Neue Kollektion erstellt", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
						@Override
						public void onClick(View _view) {
							 
						}
					}).show();
					    }
				 })
			                       
			  .create();
			dialoga.show();
			dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
			
			edit0.addTextChangedListener(new TextWatcher() {
							@Override
							public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
									final String edit0nn = _param1.toString();
									dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
					
					if (edit0.getText().toString().length() > 15) {
						((EditText)edit0).setError("Name zu lang");
						edit0.setText(edit0.getText().toString().substring((int)(0), (int)(15)));
						dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
						
					}
					if (edit0.getText().toString().length() < 1) {
						((EditText)edit0).setError("Name zu kurz");
						dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
						
					}
					if (edit0.getText().toString().contains("/") || edit0.getText().toString().contains(".")) {
						((EditText)edit0).setError("Ungültige Symbole");
						dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
						
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
	}
	
	
	public void _intro() {
		
	}
	
	
	public void _stats_preview() {
		chart1.setVisibility(View.GONE);
		chart2.setVisibility(View.GONE);
		textview45.setVisibility(View.GONE);
		try{
			if (sp.contains("path")) {
				if (FileUtil.readFile(sp.getString("path", "")).length() > 8) {
					analysisPreview = new Gson().fromJson(FileUtil.readFile(sp.getString("path", "")), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					textview19.setText(String.valueOf((long)(analysisPreview.size())));
					iter = 0;
					gradeSum = 0;
					for(int _repeat23 = 0; _repeat23 < (int)(analysisPreview.size()); _repeat23++) {
						gradeSum = gradeSum + Double.parseDouble(analysisPreview.get((int)iter).get("gr").toString());
						iter++;
					}
					textview20.setText(new DecimalFormat("0.00").format(gradeSum / analysisPreview.size()));
					chart2.setVisibility(View.VISIBLE);
					chart1.setVisibility(View.VISIBLE);
					textview44.setVisibility(View.VISIBLE);
					_graph1();
					_graph2();
				}
			}
		}catch(Exception e){
			 
		}
		try{
			textview20.setTextColor((int) _interpolateColor(Color.parseColor("F44336"), Color.parseColor("4CAF50"), 50));
		}catch(Exception e){
			 
		}
	}
	
	
	public void _updateCallback() {
		_stats_preview();
	}
	
	
	public double _interpolateColor(final double _start, final double _end, final double _value) {
		float[] startHSV = new float[3];
		float[] endHSV = new float[3];
		
		// Convert the start and end colors to HSV representation
		Color.colorToHSV((int)_start, startHSV);
		Color.colorToHSV((int)_end, endHSV);
		
		// Calculate the interpolated HSV values
		float[] interpolatedHSV = new float[3];
		for (int i = 0; i < 3; i++) {
				interpolatedHSV[i] = startHSV[i] + (endHSV[i] - startHSV[i]) * (int)_value / 100;
		}
		
		// Convert the interpolated HSV values back to RGB color
		return Color.HSVToColor(interpolatedHSV);
		
	}
	
	
	public void _graph1() {
		try{
			if (analysisPreview.size() > 2) {
				textview45.setVisibility(View.VISIBLE);
				//Line chart 1
				chart1.getDescription().setEnabled(false);
				chart1.getLegend().setEnabled(false);
				chart1.setDoubleTapToZoomEnabled(false);
				chart1.setHighlightPerDragEnabled(false);
				
				chart1.getAxisLeft().setDrawGridLines(false);
				chart1.getAxisLeft().setDrawLabels(true);
				chart1.getAxisLeft().setDrawAxisLine(false);
				chart1.getXAxis().setDrawGridLines(false);
				chart1.getXAxis().setDrawLabels(false);
				chart1.getXAxis().setDrawAxisLine(false);
				chart1.getAxisRight().setDrawGridLines(false);
				chart1.getAxisRight().setDrawLabels(false);
				chart1.getAxisRight().setDrawAxisLine(false);
				
				chart1.getAxisLeft().setTextSize(12f);
				chart1.getAxisLeft().setTextColor(ContextCompat.getColor(this, R.color.text));
				chart1.getAxisLeft().setGranularity(1);
				
				chart1.getXAxis().setAxisMinValue(0);
				chart1.getAxisLeft().setAxisMinValue((int) Double.parseDouble(sp.getString("Gstart", "")));
				chart1.getAxisLeft().setAxisMaxValue((int) Double.parseDouble(sp.getString("Gend", "")));
				
				chart1.invalidate();
				List<Entry> history = new ArrayList<Entry>();
				iter = 0;
				for(int _repeat14 = 0; _repeat14 < (int)(analysisPreview.size()); _repeat14++) {
					history.add(new Entry((int) iter, (int) Double.parseDouble(analysisPreview.get((int)iter).get("gr").toString())));
					iter++;
				}
				LineDataSet dataSet = new LineDataSet(history, "History");
				
				LineData lineData = new LineData(dataSet);
				dataSet.setColor(ContextCompat.getColor(this, R.color.text));
				dataSet.setCircleColor(ContextCompat.getColor(this, R.color.text));
				dataSet.setValueTextColor(ContextCompat.getColor(this, R.color.text));
				dataSet.setLineWidth(3f);
				dataSet.setDrawValues(false);
				//dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
				dataSet.setCircleRadius(3);
				
				chart1.setData(lineData);
				chart1.animateXY(800,300);
				//OnClick listener
				chart1.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
					    @Override
					    public void onValueSelected(Entry e, Highlight h) {
						            float x=e.getX();
						            //float y=e.getY();
						    }
					    @Override
					    public void onNothingSelected() {
						        //nothin
						    }
				});
			}
			else {
				chart1.setVisibility(View.GONE);
			}
		}catch(Exception e){
			 
		}
	}
	
	
	public void _graph2() {
		int low = 0;
		int medium = 0;
		int high = 0;
		for (int guano = 0; guano < (int)(analysisPreview.size()); guano++) {
			gradeSum = Double.parseDouble(analysisPreview.get((int)guano).get("gr").toString());
			if ((gradeSum < (Double.parseDouble(sp.getString("Gend", "")) / 3)) || (gradeSum == (Double.parseDouble(sp.getString("Gend", "")) / 3))) {
				low++;
			}
			if ((gradeSum > (Double.parseDouble(sp.getString("Gend", "")) / 3)) && (gradeSum < ((Double.parseDouble(sp.getString("Gend", "")) / 3) * 2))) {
				medium++;
			}
			if ((gradeSum > ((Double.parseDouble(sp.getString("Gend", "")) / 3) * 2)) || (gradeSum == ((Double.parseDouble(sp.getString("Gend", "")) / 3) * 2))) {
				high++;
			}
		}
		if (sp.getString("Pointmode", "").equals("true")) {
			textview23.setText(String.valueOf((long)(high)));
			textview24.setText(String.valueOf((long)(medium)));
			textview25.setText(String.valueOf((long)(low)));
		}
		else {
			textview25.setText(String.valueOf((long)(high)));
			textview24.setText(String.valueOf((long)(medium)));
			textview23.setText(String.valueOf((long)(low)));
		}
		if (analysisPreview.size() > 5) {
			textview44.setVisibility(View.VISIBLE);
			newcalc = (Double.parseDouble(analysisPreview.get((int)analysisPreview.size() - 1).get("gr").toString()) + Double.parseDouble(analysisPreview.get((int)analysisPreview.size() - 2).get("gr").toString())) / 2;
			gradeSum = Double.parseDouble(textview20.getText().toString().replace(",", "."));
			if (newcalc < gradeSum) {
				if (sp.getString("Pointmode", "").equals("true")) {
					imageview12.setImageResource(R.drawable.expro_2);
					imageview12.setRotation((float)(0.9d * (((gradeSum / 15) * 100) - ((newcalc / 15) * 100))));
				}
				else {
					imageview12.setImageResource(R.drawable.expro_1);
					imageview12.setRotation((float)(-0.9d * (((gradeSum / 15) * 100) - ((newcalc / 15) * 100))));
				}
				textview44.setText(new DecimalFormat("0.0").format(((newcalc / 15) * 100) - ((gradeSum / 15) * 100)).concat(" %"));
			}
			if (newcalc > gradeSum) {
				if (sp.getString("Pointmode", "").equals("true")) {
					imageview12.setImageResource(R.drawable.expro_1);
					imageview12.setRotation((float)(0.9d * (((gradeSum / 15) * 100) - ((newcalc / 15) * 100))));
				}
				else {
					imageview12.setImageResource(R.drawable.expro_2);
					imageview12.setRotation((float)(-0.9d * (((gradeSum / 15) * 100) - ((newcalc / 15) * 100))));
				}
				textview44.setText("+ ".concat(new DecimalFormat("0.0").format(((newcalc / 15) * 100) - ((gradeSum / 15) * 100)).concat(" %")));
			}
			if (gradeSum == newcalc) {
				imageview12.setImageResource(R.drawable.expro_3);
				imageview12.setRotation((float)(0));
				textview44.setVisibility(View.INVISIBLE);
			}
		}
		else {
			chart2.setVisibility(View.GONE);
		}
	}
	
	
	public void _RoundCorner(final View _view, final String _bg, final String _br, final double _tl, final double _tr, final double _brr, final double _bl) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_bg));
		gd.setStroke(0, Color.parseColor(_br));
		
		gd.setCornerRadii(new float[]{(int)_tl,(int)_tl,(int)_tr,(int)_tr,(int)_brr,(int)_brr,(int)_bl,(int)_bl});
		
		_view.setBackground(gd);
	}
	
	
	public void _messenger_handler(final String _message) {
		msg = new Gson().fromJson(_message.replace("]", "").replace("[", ""), new TypeToken<HashMap<String, Object>>(){}.getType());
		if ((boolean)msg.get("active")) {
			new MaterialAlertDialogBuilder(this)
			    .setTitle(msg.get("message").toString())
			    .setMessage(msg.get("title").toString())
			    .setCancelable((boolean) (boolean)msg.get("cancelable"))
			    .show();
		}
	}
	
	public class Viewpager2Adapter extends PagerAdapter {
		
		Context _context;
		ArrayList<HashMap<String, Object>> _data;
		
		public Viewpager2Adapter(Context _ctx, ArrayList<HashMap<String, Object>> _arr) {
			_context = _ctx;
			_data = _arr;
		}
		
		public Viewpager2Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_context = getApplicationContext();
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public boolean isViewFromObject(View _view, Object _object) {
			return _view == _object;
		}
		
		@Override
		public void destroyItem(ViewGroup _container, int _position, Object _object) {
			_container.removeView((View) _object);
		}
		
		@Override
		public int getItemPosition(Object _object) {
			return super.getItemPosition(_object);
		}
		
		@Override
		public CharSequence getPageTitle(int pos) {
			// Use the Activity Event (onTabLayoutNewTabAdded) in order to use this method
			return "page " + String.valueOf(pos);
		}
		
		@Override
		public Object instantiateItem(ViewGroup _container,  final int _position) {
			View _view = LayoutInflater.from(_context).inflate(R.layout.graphcard, _container, false);
			
			final com.github.mikephil.charting.charts.LineChart chart1 = _view.findViewById(R.id.chart1);
			final com.github.mikephil.charting.charts.BarChart chart2 = _view.findViewById(R.id.chart2);
			final com.github.mikephil.charting.charts.PieChart chart3 = _view.findViewById(R.id.chart3);
			
			if (_position == 0) {
				chart2.setVisibility(View.GONE);
				chart3.setVisibility(View.GONE);
				try{
					if (analysisPreview.size() > 2) {
						//Line chart 1
						chart1.getDescription().setEnabled(false);
						chart1.getLegend().setEnabled(false);
						chart1.setDoubleTapToZoomEnabled(false);
						chart1.setHighlightPerDragEnabled(false);
						
						chart1.getAxisLeft().setDrawGridLines(false);
						chart1.getAxisLeft().setDrawLabels(true);
						chart1.getAxisLeft().setDrawAxisLine(false);
						chart1.getXAxis().setDrawGridLines(false);
						chart1.getXAxis().setDrawLabels(false);
						chart1.getXAxis().setDrawAxisLine(false);
						chart1.getAxisRight().setDrawGridLines(false);
						chart1.getAxisRight().setDrawLabels(false);
						chart1.getAxisRight().setDrawAxisLine(false);
						
						chart1.getAxisLeft().setTextSize(12f);
						chart1.getAxisLeft().setGranularity(1);
						
						chart1.getXAxis().setAxisMinValue(0);
						chart1.getAxisLeft().setAxisMinValue((int) Double.parseDouble(sp.getString("Gstart", "")));
						chart1.getAxisLeft().setAxisMaxValue((int) Double.parseDouble(sp.getString("Gend", "")));
						
						chart1.invalidate();
						List<Entry> history = new ArrayList<Entry>();
						iter = 0;
						for(int _repeat39 = 0; _repeat39 < (int)(analysisPreview.size()); _repeat39++) {
							history.add(new Entry((int) iter, (int) Double.parseDouble(analysisPreview.get((int)iter).get("gr").toString())));
							iter++;
						}
						LineDataSet dataSet = new LineDataSet(history, "History");
						
						LineData lineData = new LineData(dataSet);
						
						dataSet.setLineWidth(3f);
						dataSet.setDrawValues(false);
						//dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
						dataSet.setCircleRadius(3);
						
						chart1.setData(lineData);
						chart1.animateXY(800,300);
						//OnClick listener
						chart1.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
							    @Override
							    public void onValueSelected(Entry e, Highlight h) {
								            float x=e.getX();
								            //float y=e.getY();
								    }
							    @Override
							    public void onNothingSelected() {
								        //nothin
								    }
						});
					}
					else {
						chart1.setVisibility(View.GONE);
					}
				}catch(Exception e){
					 
				}
			}
			if (_position == 1) {
				chart1.setVisibility(View.GONE);
				chart3.setVisibility(View.GONE);
			}
			if (_position == 2) {
				chart1.setVisibility(View.GONE);
				chart2.setVisibility(View.GONE);
			}
			
			_container.addView(_view);
			return _view;
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