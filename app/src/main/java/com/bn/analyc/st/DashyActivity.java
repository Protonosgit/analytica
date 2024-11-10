package com.bn.analyc.st;

import android.Manifest;
import android.animation.*;
import android.animation.ObjectAnimator;
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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Switch;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mrudultora.colorpicker.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import net.cachapa.expandablelayout.*;
import org.json.*;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import androidx.appcompat.app.AlertDialog;
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

public class DashyActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private double count1 = 0;
	private double count2 = 0;
	private double s11 = 0;
	private double s12 = 0;
	private double s13 = 0;
	private double qg = 0;
	private double pt = 0;
	private double s21 = 0;
	private double s22 = 0;
	private double s23 = 0;
	private double s24 = 0;
	private double s25 = 0;
	private double s26 = 0;
	private double eva = 0;
	private boolean exit_state = false;
	private double s27 = 0;
	private double rune = 0;
	private double month = 0;
	private double point_sum = 0;
	private double eva2 = 0;
	
	private ArrayList<HashMap<String, Object>> RUNNER = new ArrayList<>();
	private ArrayList<String> tcpunter = new ArrayList<>();
	private ArrayList<String> scounter = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> grid = new ArrayList<>();
	private ArrayList<Double> points = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> yearcurve = new ArrayList<>();
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout frame1;
	private TextView h1;
	private LinearLayout linear20;
	private LinearLayout linear22;
	private LineChart chart1;
	private TextView textview38;
	private LinearLayout frame4;
	private LinearLayout linear24;
	private BarChart chart2;
	private LinearLayout linear25;
	private PieChart chart3;
	private TextView textview41;
	private LinearLayout frame5;
	private LinearLayout linear27;
	private LineChart chart4;
	private TextView h0;
	private LinearLayout linear17;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private LinearLayout linear19;
	private TextView textview27;
	private TextView textview28;
	private TextView gs;
	private TextView p;
	private TextView q;
	private TextView qp;
	private ImageView imageview4;
	private LinearLayout frame2;
	private LinearLayout linear23;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private TextView textview11;
	private TextView textview16;
	private TextView textview12;
	private TextView textview17;
	private TextView textview13;
	private TextView textview18;
	private TextView textview15;
	private TextView textview19;
	private TextView textview44;
	private ImageView imageview1;
	private TextView textview36;
	private Switch switch2;
	private ImageView imageview7;
	private LinearLayout f4i1;
	private LinearLayout f4i2;
	private TextView hu;
	private TextView ka;
	private TextView ep;
	private TextView aa;
	private TextView textview39;
	private ImageView imageview5;
	private TextView textview40;
	private ImageView imageview8;
	private LinearLayout linear18;
	private TextView textview29;
	private TextView textview30;
	private TextView textview31;
	private TextView textview32;
	private TextView textview43;
	private Switch switch1;
	private ImageView imageview10;
	
	private SharedPreferences sp;
	private Intent intent = new Intent();
	private TimerTask sleep;
	private TimerTask timer;
	private ObjectAnimator anim = new ObjectAnimator();
	private ObjectAnimator anim2 = new ObjectAnimator();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.dashy);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
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
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		frame1 = findViewById(R.id.frame1);
		h1 = findViewById(R.id.h1);
		linear20 = findViewById(R.id.linear20);
		linear22 = findViewById(R.id.linear22);
		chart1 = findViewById(R.id.chart1);
		textview38 = findViewById(R.id.textview38);
		frame4 = findViewById(R.id.frame4);
		linear24 = findViewById(R.id.linear24);
		chart2 = findViewById(R.id.chart2);
		linear25 = findViewById(R.id.linear25);
		chart3 = findViewById(R.id.chart3);
		textview41 = findViewById(R.id.textview41);
		frame5 = findViewById(R.id.frame5);
		linear27 = findViewById(R.id.linear27);
		chart4 = findViewById(R.id.chart4);
		h0 = findViewById(R.id.h0);
		linear17 = findViewById(R.id.linear17);
		linear13 = findViewById(R.id.linear13);
		linear14 = findViewById(R.id.linear14);
		linear19 = findViewById(R.id.linear19);
		textview27 = findViewById(R.id.textview27);
		textview28 = findViewById(R.id.textview28);
		gs = findViewById(R.id.gs);
		p = findViewById(R.id.p);
		q = findViewById(R.id.q);
		qp = findViewById(R.id.qp);
		imageview4 = findViewById(R.id.imageview4);
		frame2 = findViewById(R.id.frame2);
		linear23 = findViewById(R.id.linear23);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		textview11 = findViewById(R.id.textview11);
		textview16 = findViewById(R.id.textview16);
		textview12 = findViewById(R.id.textview12);
		textview17 = findViewById(R.id.textview17);
		textview13 = findViewById(R.id.textview13);
		textview18 = findViewById(R.id.textview18);
		textview15 = findViewById(R.id.textview15);
		textview19 = findViewById(R.id.textview19);
		textview44 = findViewById(R.id.textview44);
		imageview1 = findViewById(R.id.imageview1);
		textview36 = findViewById(R.id.textview36);
		switch2 = findViewById(R.id.switch2);
		imageview7 = findViewById(R.id.imageview7);
		f4i1 = findViewById(R.id.f4i1);
		f4i2 = findViewById(R.id.f4i2);
		hu = findViewById(R.id.hu);
		ka = findViewById(R.id.ka);
		ep = findViewById(R.id.ep);
		aa = findViewById(R.id.aa);
		textview39 = findViewById(R.id.textview39);
		imageview5 = findViewById(R.id.imageview5);
		textview40 = findViewById(R.id.textview40);
		imageview8 = findViewById(R.id.imageview8);
		linear18 = findViewById(R.id.linear18);
		textview29 = findViewById(R.id.textview29);
		textview30 = findViewById(R.id.textview30);
		textview31 = findViewById(R.id.textview31);
		textview32 = findViewById(R.id.textview32);
		textview43 = findViewById(R.id.textview43);
		switch1 = findViewById(R.id.switch1);
		imageview10 = findViewById(R.id.imageview10);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview4.setScaleX((float)(0.8d));
				imageview4.setScaleY((float)(0.8d));
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								imageview4.setScaleX((float)(1));
								imageview4.setScaleY((float)(1));
							}
						});
					}
				};
				_timer.schedule(timer, (int)(40));
				intent.setClass(getApplicationContext(), FinaActivity.class);
				startActivity(intent);
			}
		});
		
		switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					switch2.setText("Vereinfacht  ");
					_gra1(1);
				}
				else {
					switch2.setText("Alle  ");
					_gra1(0);
				}
			}
		});
		
		imageview7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				chart1.saveToGallery("history_chart");
					Toast toast = Toast.makeText(getApplicationContext(),"🔽 Saved to gallery  🔽", Toast.LENGTH_SHORT);
					toast.show();
			}
		});
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				chart2.saveToGallery("points_chart");
					Toast toast = Toast.makeText(getApplicationContext(),"🔽 Saved to gallery  🔽", Toast.LENGTH_SHORT);
					toast.show();
			}
		});
		
		imageview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
				chart3.saveToGallery("types_chart");
					Toast toast = Toast.makeText(getApplicationContext(),"🔽 Saved to gallery  🔽", Toast.LENGTH_SHORT);
					toast.show();
			}
		});
		
		switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					switch1.setText("Durchschnitt  ");
					_gra4(1);
				}
				else {
					switch1.setText("Menge  ");
					_gra4(0);
				}
			}
		});
		
		imageview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				chart4.saveToGallery("monthly_chart");
					Toast toast = Toast.makeText(getApplicationContext(),"🔽 Saved to gallery  🔽", Toast.LENGTH_SHORT);
					toast.show();
			}
		});
	}
	
	private void initializeLogic() {
		vscroll1.setVisibility(View.GONE);
		h0.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/xonuim.otf"), 1);
		q.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFE0E0E0, Color.TRANSPARENT));
		p.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFE0E0E0, Color.TRANSPARENT));
		gs.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFE0E0E0, Color.TRANSPARENT));
		qp.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)5, 0xFFE0E0E0, Color.TRANSPARENT));
		hu.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)4, 0xFFEEEEEE, Color.TRANSPARENT));
		ka.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)4, 0xFFEEEEEE, Color.TRANSPARENT));
		aa.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)4, 0xFFEEEEEE, Color.TRANSPARENT));
		ep.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)4, 0xFFEEEEEE, Color.TRANSPARENT));
		_RoundCorner(linear8, "#75FF03", "#8BC34A", 30, 30, 0, 0);
		_RoundCorner(linear11, "#EEEEEE", "#E0E0E0", 0, 0, 30, 30);
		try{
			LineChart chart1 = (LineChart) findViewById(R.id.chart1);
			BarChart chart2 = (BarChart) findViewById(R.id.chart2);
			PieChart chart3 = (PieChart) findViewById(R.id.chart3);
			
			chart1.setScaleEnabled(false);
			chart2.setScaleEnabled(false);
			chart4.setScaleEnabled(false);
			RUNNER = new Gson().fromJson(FileUtil.readFile(sp.getString("path", "")), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			if (RUNNER.size() < 9) {
				switch2.setEnabled(false);
			}
			vscroll1.setVisibility(View.VISIBLE);
			_sort1();
			_sort2();
			_sort3();
			_sort4();
			_sort5();
			_sort6();
			_gra1(0);
			_gra2();
			_gra3();
			_gra4(0);
			anim.setTarget(linear2);
			anim.setPropertyName("scaleX");
			anim.setFloatValues((float)(0));
			anim.setFloatValues((float)(0), (float)(1));
			anim.setDuration((int)(300));
			anim.setInterpolator(new AccelerateInterpolator());
			anim.start();
			anim2.setTarget(linear2);
			anim2.setPropertyName("scaleY");
			anim2.setFloatValues((float)(0));
			anim2.setFloatValues((float)(0), (float)(1));
			anim2.setDuration((int)(300));
			anim2.setInterpolator(new AccelerateInterpolator());
			anim2.start();
			if (sp.getString("premium", "").equals("true")) {
				chart1.setHardwareAccelerationEnabled(true);
				chart2.setHardwareAccelerationEnabled(true);
				chart3.setHardwareAccelerationEnabled(true);
				chart4.setHardwareAccelerationEnabled(true);
				chart1.setScaleEnabled(true);
				chart2.setScaleEnabled(true);
				chart4.setScaleEnabled(true);
				chart1.invalidate();
				chart2.invalidate();
				chart4.invalidate();
			}
			else {
				imageview7.setVisibility(View.GONE);
				imageview5.setVisibility(View.GONE);
				imageview8.setVisibility(View.GONE);
				imageview10.setVisibility(View.GONE);
			}
		}catch(Exception e){
			SketchwareUtil.CustomToast(getApplicationContext(), "😵 Ein Fehler ist aufgetreten bitte Entwickler kontaktieren!", 0xFF000000, 12, 0xFFFF5722, 4, SketchwareUtil.CENTER);
			intent.setClass(getApplicationContext(), Ac1Activity.class);
			startActivity(intent);
			finish();
		}
	}
	
	@Override
	public void onBackPressed() {
		if (!exit_state) {
			anim.setTarget(linear2);
			anim.setPropertyName("scaleX");
			anim.setFloatValues((float)(0));
			anim.setFloatValues((float)(1), (float)(0));
			anim.setDuration((int)(300));
			anim.setInterpolator(new AccelerateInterpolator());
			anim.start();
			anim2.setTarget(linear2);
			anim2.setPropertyName("scaleY");
			anim2.setFloatValues((float)(0));
			anim2.setFloatValues((float)(1), (float)(0));
			anim2.setDuration((int)(300));
			anim2.setInterpolator(new AccelerateInterpolator());
			anim2.start();
			exit_state = true;
			sleep = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							intent.setClass(getApplicationContext(), Ac1Activity.class);
							startActivity(intent);
							finish();
						}
					});
				}
			};
			_timer.schedule(sleep, (int)(250));
		}
	}
	
	public void _sort1() {
		count2 = 0;
		qg = 0;
		for(int _repeat10 = 0; _repeat10 < (int)(RUNNER.size()); _repeat10++) {
			if (RUNNER.get((int)count2).get("gr").toString().equals("1") || (RUNNER.get((int)count2).get("gr").toString().equals("1+") || RUNNER.get((int)count2).get("gr").toString().equals("1-"))) {
				s11 = s11 + 1;
			}
			if (RUNNER.get((int)count2).get("gr").toString().equals("2") || (RUNNER.get((int)count2).get("gr").toString().equals("2+") || RUNNER.get((int)count2).get("gr").toString().equals("2-"))) {
				s11 = s11 + 1;
			}
			if (RUNNER.get((int)count2).get("gr").toString().equals("3") || (RUNNER.get((int)count2).get("gr").toString().equals("3+") || RUNNER.get((int)count2).get("gr").toString().equals("3-"))) {
				s12 = s12 + 1;
			}
			if (RUNNER.get((int)count2).get("gr").toString().equals("4") || (RUNNER.get((int)count2).get("gr").toString().equals("4+") || RUNNER.get((int)count2).get("gr").toString().equals("4-"))) {
				s12 = s12 + 1;
			}
			if (RUNNER.get((int)count2).get("gr").toString().equals("5") || (RUNNER.get((int)count2).get("gr").toString().equals("5+") || RUNNER.get((int)count2).get("gr").toString().equals("5-"))) {
				s13 = s13 + 1;
			}
			if (RUNNER.get((int)count2).get("gr").toString().equals("6")) {
				s13 = s13 + 1;
			}
			qg = qg + Double.parseDouble(RUNNER.get((int)count2).get("gr").toString().replace("+", "").replace("-", ""));
			pt = pt + Double.parseDouble(RUNNER.get((int)count2).get("pt").toString());
			count2++;
		}
		q.setText(new DecimalFormat("0.00").format(qg / count2).concat(" ∅"));
		qp.setText(new DecimalFormat("0.00").format(pt / count2).concat(" ∅"));
		p.setText(String.valueOf((long)(pt)));
		textview16.setText(String.valueOf((long)(s11)));
		textview17.setText(String.valueOf((long)(s12)));
		textview18.setText(String.valueOf((long)(s13)));
		textview15.setText(String.valueOf((long)(count2)));
		textview11.setText(String.valueOf((long)((s11 / count2) * 100)).concat("%"));
		textview12.setText(String.valueOf((long)((s12 / count2) * 100)).concat("%"));
		textview13.setText(String.valueOf((long)((s13 / count2) * 100)).concat("%"));
		gs.setText(String.valueOf((long)(count2)));
	}
	
	
	public void _RoundCorner(final View _view, final String _bg, final String _br, final double _tl, final double _tr, final double _brr, final double _bl) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_bg));
		gd.setStroke(2, Color.parseColor(_br));
		
		gd.setCornerRadii(new float[]{(int)_tl,(int)_tl,(int)_tr,(int)_tr,(int)_brr,(int)_brr,(int)_bl,(int)_bl});
		
		_view.setBackground(gd);
	}
	
	
	public void _sort2() {
		count1 = 0;
		for(int _repeat10 = 0; _repeat10 < (int)(RUNNER.size()); _repeat10++) {
			if (RUNNER.get((int)count1).get("tp").toString().equals("Test")) {
				s21++;
			}
			if (RUNNER.get((int)count1).get("tp").toString().equals("Klassenarbeit")) {
				s22++;
			}
			if (RUNNER.get((int)count1).get("tp").toString().equals("Mündlich")) {
				s23++;
			}
			if (RUNNER.get((int)count1).get("tp").toString().equals("Sonderleistungen")) {
				s24++;
			}
			count1++;
		}
		ka.setText("Klassenarbeiten: ".concat(String.valueOf((long)(s21))));
		hu.setText("Tests:  ".concat(String.valueOf((long)(s22))));
		aa.setText("Mündlich:  ".concat(String.valueOf((long)(s23))));
		ep.setText("Sonderleistungen: ".concat(String.valueOf((long)(s24))));
	}
	
	
	public void _sort3() {
		count2 = 0;
		point_sum = 0;
		for(int _repeat297 = 0; _repeat297 < (int)((RUNNER.size() - 3)); _repeat297++) {
			point_sum = point_sum + Double.parseDouble(RUNNER.get((int)count2).get("pt").toString());
			count2++;
		}
		if (RUNNER.size() > 4) {
			linear23.setVisibility(View.VISIBLE);
			if (((point_sum / count2) > 14.40d) && !sp.getString("preci", "").equals("true")) {
				imageview1.setImageResource(R.drawable.ic10);
			}
			else {
				eva = (Double.parseDouble(RUNNER.get((int)RUNNER.size() - 3).get("pt").toString()) + (Double.parseDouble(RUNNER.get((int)RUNNER.size() - 2).get("pt").toString()) + Double.parseDouble(RUNNER.get((int)RUNNER.size() - 1).get("pt").toString()))) / 3;
				eva2 = point_sum / count2;
				if (eva2 < eva) {
					imageview1.setImageResource(R.drawable.expro_1);
					imageview1.setRotation((float)(-0.9d * (((eva / 15) * 100) - ((eva2 / 15) * 100))));
					textview44.setText("+ ".concat(new DecimalFormat("0.0").format(((eva / 15) * 100) - ((eva2 / 15) * 100)).concat(" %")));
				}
				if (eva2 > eva) {
					imageview1.setImageResource(R.drawable.expro_2);
					imageview1.setRotation((float)(-0.9d * (((eva / 15) * 100) - ((eva2 / 15) * 100))));
					textview44.setText(new DecimalFormat("0.0").format(((eva / 15) * 100) - ((eva2 / 15) * 100)).concat(" %"));
				}
				if (eva2 == eva) {
					imageview1.setImageResource(R.drawable.default_image);
					imageview1.setRotation((float)(0));
					textview44.setVisibility(View.INVISIBLE);
				}
			}
		}
		else {
			linear23.setVisibility(View.GONE);
		}
	}
	
	
	public void _sort4() {
		count1 = 0;
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("val", "0");
			grid.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("val", "0");
			grid.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("val", "0");
			grid.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("val", "0");
			grid.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("val", "0");
			grid.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("val", "0");
			grid.add(_item);
		}
		
		{
			HashMap<String, Object> _item = new HashMap<>();
			_item.put("val", "0");
			grid.add(_item);
		}
		
		for(int _repeat11 = 0; _repeat11 < (int)(RUNNER.size()); _repeat11++) {
			if (RUNNER.get((int)count1).get("tp").toString().equals("KA")) {
				grid.get((int)0).put("type", "KA");
				grid.get((int)0).put("val", String.valueOf((long)(Double.parseDouble(grid.get((int)0).get("val").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("gr").toString().replace("+", "").replace("-", "")))));
			}
			if (RUNNER.get((int)count1).get("tp").toString().equals("HÜ")) {
				grid.get((int)1).put("type", "HÜ");
				grid.get((int)1).put("val", String.valueOf((long)(Double.parseDouble(grid.get((int)1).get("val").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("gr").toString().replace("+", "").replace("-", "")))));
			}
			if (RUNNER.get((int)count1).get("tp").toString().equals("AA")) {
				grid.get((int)2).put("type", "AA");
				grid.get((int)2).put("val", String.valueOf((long)(Double.parseDouble(grid.get((int)2).get("val").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("gr").toString().replace("+", "").replace("-", "")))));
			}
			if (RUNNER.get((int)count1).get("tp").toString().equals("EPO")) {
				grid.get((int)3).put("type", "EPO");
				grid.get((int)3).put("val", String.valueOf((long)(Double.parseDouble(grid.get((int)3).get("val").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("gr").toString().replace("+", "").replace("-", "")))));
			}
			if (RUNNER.get((int)count1).get("tp").toString().equals("VOC")) {
				grid.get((int)4).put("type", "VOC");
				grid.get((int)4).put("val", String.valueOf((long)(Double.parseDouble(grid.get((int)4).get("val").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("gr").toString().replace("+", "").replace("-", "")))));
			}
			if (RUNNER.get((int)count1).get("tp").toString().equals("~")) {
				grid.get((int)5).put("type", "~");
				grid.get((int)5).put("val", String.valueOf((long)(Double.parseDouble(grid.get((int)5).get("val").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("gr").toString().replace("+", "").replace("-", "")))));
			}
			if (RUNNER.get((int)count1).get("tp").toString().equals("SÜ")) {
				grid.get((int)6).put("type", "SÜ");
				grid.get((int)6).put("val", String.valueOf((long)(Double.parseDouble(grid.get((int)6).get("val").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("gr").toString().replace("+", "").replace("-", "")))));
			}
			count1++;
		}
		textview29.setText("Klassenarbeiten".concat("\n").concat(new DecimalFormat("0.0").format(Double.parseDouble(grid.get((int)0).get("val").toString()) / s21)));
		textview30.setText("Tests".concat("\n").concat(new DecimalFormat("0.0").format(Double.parseDouble(grid.get((int)1).get("val").toString()) / s22)));
		textview31.setText("Mündlich".concat("\n").concat(new DecimalFormat("0.0").format(Double.parseDouble(grid.get((int)2).get("val").toString()) / s23)));
		textview32.setText("Sonderleistungen".concat("\n").concat(new DecimalFormat("0.0").format(Double.parseDouble(grid.get((int)3).get("val").toString()) / s24)));
		if (s21 == 0) {
			textview29.setVisibility(View.GONE);
		}
		if (s22 == 0) {
			textview30.setVisibility(View.GONE);
		}
		if (s23 == 0) {
			textview31.setVisibility(View.GONE);
		}
		if (s24 == 0) {
			textview32.setVisibility(View.GONE);
		}
		textview29.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)4, 0xFFEEEEEE, Color.TRANSPARENT));
		textview30.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)4, 0xFFEEEEEE, Color.TRANSPARENT));
		textview31.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)4, 0xFFEEEEEE, Color.TRANSPARENT));
		textview32.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)4, 0xFFEEEEEE, Color.TRANSPARENT));
	}
	
	
	public void _gra2() {
		//Bar chart1
		chart2.getDescription().setEnabled(false);
		chart2.getLegend().setEnabled(false);
		chart2.setDoubleTapToZoomEnabled(false);
		chart2.setExtraOffsets(5f,5f,5f,5f);
		chart2.setHighlightPerDragEnabled(false);
		
		chart2.getAxisLeft().setDrawGridLines(false);
		chart2.getAxisLeft().setDrawLabels(true);
		chart2.getAxisLeft().setDrawAxisLine(false);
		chart2.getXAxis().setDrawGridLines(false);
		chart2.getXAxis().setDrawLabels(true);
		chart2.getXAxis().setDrawAxisLine(false);
		chart2.getAxisRight().setDrawGridLines(false);
		chart2.getAxisRight().setDrawLabels(false);
		chart2.getAxisRight().setDrawAxisLine(false);
		
		chart2.getAxisLeft().setTextSize(12f);
		chart2.getAxisLeft().setTextColor(ContextCompat.getColor(this, R.color.text));
		chart2.getAxisLeft().setAxisMinValue(0);
		
		chart2.getXAxis().setAxisMinValue(0);
		chart2.getXAxis().setTextColor(ContextCompat.getColor(this, R.color.text));
		chart2.getXAxis().setTextSize(12f);
		chart2.getXAxis().setGranularityEnabled(true);
		chart2.getXAxis().setGranularity(1);
		
		List<BarEntry> entries = new ArrayList<>();
		count1 = 0;
		for(int _repeat14 = 0; _repeat14 < (int)(points.size()); _repeat14++) {
			rune = points.get((int)(count1)).doubleValue();
			entries.add(new BarEntry((int) count1, (int) rune));
			count1++;
		}
		BarDataSet set = new BarDataSet(entries, "BarDataSet");
		set.setColor(ContextCompat.getColor(this, R.color.text));
		
		BarData data = new BarData(set);
		data.setBarWidth(0.9f);
		data.setDrawValues(false);
		
		chart2.setData(data);
		chart2.animateXY(2500,2000);
		//OnClick listener
		chart2.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
			    @Override
			    public void onValueSelected(Entry e, Highlight h) {
				        float x=e.getX();
				        float y=e.getY();
				        
				        //event
				    }
			    @Override
			    public void onNothingSelected() {
				        //nothin
				        
				    }
		});
	}
	
	
	public void _gra3() {
		// Pie chart 1
		List<PieEntry> types = new ArrayList<>();
		chart3.getDescription().setEnabled(false);
		chart3.setExtraOffsets(5f,5f,5f,5f);
		chart3.getLegend().setEnabled(false);
		chart3.setHoleRadius(50);
		chart3.setDrawHoleEnabled(false);
		chart3.setDrawEntryLabels(false);
		if (s21 > 0) {
			types.add(new PieEntry((int) s21, "KA"));
		}
		if (s22 > 0) {
			types.add(new PieEntry((int) s22, "HÜ"));
		}
		if (s23 > 0) {
			types.add(new PieEntry((int) s23, "AA"));
		}
		if (s24 > 0) {
			types.add(new PieEntry((int) s24, "EPO"));
		}
		if (s25 > 0) {
			types.add(new PieEntry((int) s25, "VOC"));
		}
		if (s26 > 0) {
			types.add(new PieEntry((int) s26, "NIL"));
		}
		if (s27 > 0) {
			types.add(new PieEntry((int) s27, "SÜ"));
		}
		PieDataSet set2 = new PieDataSet(types, "Type count");
		PieData data2 = new PieData(set2);
		data2.setDrawValues(false);
		
		final int[] MY_COLORS = {
			Color.rgb(192,0,0),
			Color.rgb(255,0,0),
			Color.rgb(255,192,0),
			Color.rgb(127,127,127),
			Color.rgb(146,208,80),
			Color.rgb(0,176,80),
			Color.rgb(79,129,189)}; 
		ArrayList<Integer> colors = new ArrayList<Integer>(); 
		for(int c: MY_COLORS) colors.add(c);
		set2.setColors(colors);
		
		chart3.setData(data2);
		chart3.animateY(2500);
		//OnClick listener
		chart3.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
			    @Override
			    public void onValueSelected(Entry e, Highlight h) {
				        chart3.setDrawEntryLabels(true);
				        //event
				            //float x=e.getX();
				            //float y=e.getY();
				    }
			    @Override
			    public void onNothingSelected() {
				        chart3.setDrawEntryLabels(false);
				        //nothin
				        
				    }
		});
		if (sp.getString("premium", "").equals("true")) {
			chart3.setDragDecelerationFrictionCoef(0);
		}
	}
	
	
	public void _sort5() {
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		points.add(Double.valueOf(0));
		count1 = 0;
		for(int _repeat10 = 0; _repeat10 < (int)(RUNNER.size()); _repeat10++) {
			switch((int)Double.parseDouble(RUNNER.get((int)count1).get("pt").toString())) {
				case ((int)0): {
					points.set((int)0, points.get((int)(0)).doubleValue() + 1);
					break;
				}
				case ((int)1): {
					points.set((int)1, points.get((int)(1)).doubleValue() + 1);
					break;
				}
				case ((int)2): {
					points.set((int)2, points.get((int)(2)).doubleValue() + 1);
					break;
				}
				case ((int)3): {
					points.set((int)3, points.get((int)(3)).doubleValue() + 1);
					break;
				}
				case ((int)4): {
					points.set((int)4, points.get((int)(4)).doubleValue() + 1);
					break;
				}
				case ((int)5): {
					points.set((int)5, points.get((int)(5)).doubleValue() + 1);
					break;
				}
				case ((int)6): {
					points.set((int)6, points.get((int)(6)).doubleValue() + 1);
					break;
				}
				case ((int)7): {
					points.set((int)7, points.get((int)(7)).doubleValue() + 1);
					break;
				}
				case ((int)8): {
					points.set((int)8, points.get((int)(8)).doubleValue() + 1);
					break;
				}
				case ((int)9): {
					points.set((int)9, points.get((int)(9)).doubleValue() + 1);
					break;
				}
				case ((int)10): {
					points.set((int)10, points.get((int)(10)).doubleValue() + 1);
					break;
				}
				case ((int)11): {
					points.set((int)11, points.get((int)(11)).doubleValue() + 1);
					break;
				}
				case ((int)12): {
					points.set((int)12, points.get((int)(12)).doubleValue() + 1);
					break;
				}
				case ((int)13): {
					points.set((int)13, points.get((int)(13)).doubleValue() + 1);
					break;
				}
				case ((int)14): {
					points.set((int)14, points.get((int)(14)).doubleValue() + 1);
					break;
				}
				case ((int)15): {
					points.set((int)15, points.get((int)(15)).doubleValue() + 1);
					break;
				}
			}
			count1++;
		}
	}
	
	
	public void _sort6() {
		if (!sp.getString("timestamps", "").equals("false")) {
			{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("count", "0");
					yearcurve.add(_item);
			}
			
			yearcurve.get((int)0).put("sum", "0");
			{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("count", "0");
					yearcurve.add(_item);
			}
			
			yearcurve.get((int)1).put("sum", "0");
			{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("count", "0");
					yearcurve.add(_item);
			}
			
			yearcurve.get((int)2).put("sum", "0");
			{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("count", "0");
					yearcurve.add(_item);
			}
			
			yearcurve.get((int)3).put("sum", "0");
			{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("count", "0");
					yearcurve.add(_item);
			}
			
			yearcurve.get((int)4).put("sum", "0");
			{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("count", "0");
					yearcurve.add(_item);
			}
			
			yearcurve.get((int)5).put("sum", "0");
			{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("count", "0");
					yearcurve.add(_item);
			}
			
			yearcurve.get((int)6).put("sum", "0");
			{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("count", "0");
					yearcurve.add(_item);
			}
			
			yearcurve.get((int)7).put("sum", "0");
			{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("count", "0");
					yearcurve.add(_item);
			}
			
			yearcurve.get((int)8).put("sum", "0");
			{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("count", "0");
					yearcurve.add(_item);
			}
			
			yearcurve.get((int)9).put("sum", "0");
			{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("count", "0");
					yearcurve.add(_item);
			}
			
			yearcurve.get((int)10).put("sum", "0");
			{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("count", "0");
					yearcurve.add(_item);
			}
			
			yearcurve.get((int)11).put("sum", "0");
			count1 = 0;
			for(int _repeat10 = 0; _repeat10 < (int)(RUNNER.size()); _repeat10++) {
				month = Double.parseDouble(RUNNER.get((int)count1).get("dt").toString().substring((int)(3), (int)(5))) - 1;
				switch((int)Double.parseDouble(RUNNER.get((int)count1).get("dt").toString().substring((int)(3), (int)(5)))) {
					case ((int)1): {
						yearcurve.get((int)month).put("count", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("count").toString()) + 1)));
						yearcurve.get((int)month).put("sum", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("sum").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("pt").toString()))));
						break;
					}
					case ((int)2): {
						yearcurve.get((int)month).put("count", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("count").toString()) + 1)));
						yearcurve.get((int)month).put("sum", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("sum").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("pt").toString()))));
						break;
					}
					case ((int)3): {
						yearcurve.get((int)month).put("count", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("count").toString()) + 1)));
						yearcurve.get((int)month).put("sum", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("sum").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("pt").toString()))));
						break;
					}
					case ((int)4): {
						yearcurve.get((int)month).put("count", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("count").toString()) + 1)));
						yearcurve.get((int)month).put("sum", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("sum").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("pt").toString()))));
						break;
					}
					case ((int)5): {
						yearcurve.get((int)month).put("count", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("count").toString()) + 1)));
						yearcurve.get((int)month).put("sum", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("sum").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("pt").toString()))));
						break;
					}
					case ((int)6): {
						yearcurve.get((int)month).put("count", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("count").toString()) + 1)));
						yearcurve.get((int)month).put("sum", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("sum").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("pt").toString()))));
						break;
					}
					case ((int)7): {
						yearcurve.get((int)month).put("count", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("count").toString()) + 1)));
						yearcurve.get((int)month).put("sum", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("sum").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("pt").toString()))));
						break;
					}
					case ((int)8): {
						yearcurve.get((int)month).put("count", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("count").toString()) + 1)));
						yearcurve.get((int)month).put("sum", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("sum").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("pt").toString()))));
						break;
					}
					case ((int)9): {
						yearcurve.get((int)month).put("count", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("count").toString()) + 1)));
						yearcurve.get((int)month).put("sum", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("sum").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("pt").toString()))));
						break;
					}
					case ((int)10): {
						yearcurve.get((int)month).put("count", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("count").toString()) + 1)));
						yearcurve.get((int)month).put("sum", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("sum").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("pt").toString()))));
						break;
					}
					case ((int)11): {
						yearcurve.get((int)month).put("count", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("count").toString()) + 1)));
						yearcurve.get((int)month).put("sum", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("sum").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("pt").toString()))));
						break;
					}
					case ((int)12): {
						yearcurve.get((int)month).put("count", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("count").toString()) + 1)));
						yearcurve.get((int)month).put("sum", String.valueOf((long)(Double.parseDouble(yearcurve.get((int)month).get("sum").toString()) + Double.parseDouble(RUNNER.get((int)count1).get("pt").toString()))));
						break;
					}
				}
				count1++;
			}
		}
		else {
			chart4.setVisibility(View.GONE);
		}
	}
	
	
	public void _gra4(final double _mode) {
		if (_mode == 0) {
			//Line chart 2
			chart4.getDescription().setEnabled(false);
			chart4.getLegend().setEnabled(false);
			chart4.setDoubleTapToZoomEnabled(false);
			chart4.setExtraOffsets(5f,5f,5f,5f);
			chart1.setHighlightPerDragEnabled(false);
			
			chart4.getAxisLeft().setDrawGridLines(false);
			chart4.getAxisLeft().setDrawLabels(true);
			chart4.getAxisLeft().setDrawAxisLine(false);
			chart4.getXAxis().setDrawGridLines(false);
			chart4.getXAxis().setDrawLabels(true);
			chart4.getXAxis().setDrawAxisLine(false);
			chart4.getAxisRight().setDrawGridLines(false);
			chart4.getAxisRight().setDrawLabels(false);
			chart4.getAxisRight().setDrawAxisLine(false);
			
			chart4.getAxisLeft().setTextSize(12f);
			chart4.getAxisLeft().setTextColor(ContextCompat.getColor(this, R.color.text));
			chart4.getXAxis().setTextColor(ContextCompat.getColor(this, R.color.text));
			chart4.getAxisLeft().setGranularity(1);
			
			chart4.getXAxis().setAxisMinValue(1);
			chart4.getXAxis().setAxisMaxValue(12);
			chart4.getAxisLeft().setAxisMinValue(0);
			
			chart4.invalidate();
			List<Entry> pcurve = new ArrayList<Entry>();
			count1 = 0;
			for(int _repeat14 = 0; _repeat14 < (int)(yearcurve.size()); _repeat14++) {
				rune = Double.parseDouble(yearcurve.get((int)count1).get("count").toString());
				pcurve.add(new Entry((int) count1+1, (int) rune));
				count1++;
			}
			LineDataSet dataSet2 = new LineDataSet(pcurve, "Power curve");
			
			LineData lineData2 = new LineData(dataSet2);
			dataSet2.setColor(ContextCompat.getColor(this, R.color.text));
			dataSet2.setCircleColor(ContextCompat.getColor(this, R.color.text));
			dataSet2.setValueTextColor(ContextCompat.getColor(this, R.color.text));
			dataSet2.setLineWidth(4);
			dataSet2.setDrawValues(false);
			dataSet2.setMode(LineDataSet.Mode.CUBIC_BEZIER);
			dataSet2.setCircleRadius(5);
			
			chart4.setData(lineData2);
			chart4.animateXY(2500,2000);
		}
		else {
			//Line chart 2
			chart4.getDescription().setEnabled(false);
			chart4.getLegend().setEnabled(false);
			chart4.setDoubleTapToZoomEnabled(false);
			chart4.setExtraOffsets(5f,5f,5f,5f);
			chart1.setHighlightPerDragEnabled(false);
			
			chart4.getAxisLeft().setDrawGridLines(false);
			chart4.getAxisLeft().setDrawLabels(true);
			chart4.getAxisLeft().setDrawAxisLine(false);
			chart4.getXAxis().setDrawGridLines(false);
			chart4.getXAxis().setDrawLabels(true);
			chart4.getXAxis().setDrawAxisLine(false);
			chart4.getAxisRight().setDrawGridLines(false);
			chart4.getAxisRight().setDrawLabels(false);
			chart4.getAxisRight().setDrawAxisLine(false);
			
			chart4.getAxisLeft().setTextSize(12f);
			chart4.getAxisLeft().setTextColor(ContextCompat.getColor(this, R.color.text));
			chart4.getXAxis().setTextColor(ContextCompat.getColor(this, R.color.text));
			chart4.getAxisLeft().setGranularity(1);
			
			chart4.getXAxis().setAxisMinValue(1);
			chart4.getXAxis().setAxisMaxValue(12);
			chart4.getAxisLeft().setAxisMinValue(0);
			chart4.getAxisLeft().setAxisMaxValue(15);
			
			chart4.invalidate();
			List<Entry> pcurve = new ArrayList<Entry>();
			count1 = 0;
			for(int _repeat34 = 0; _repeat34 < (int)(yearcurve.size()); _repeat34++) {
				rune = Double.parseDouble(yearcurve.get((int)count1).get("sum").toString()) / Double.parseDouble(yearcurve.get((int)count1).get("count").toString());
				pcurve.add(new Entry((int) count1+1, (int) rune));
				count1++;
			}
			LineDataSet dataSet2 = new LineDataSet(pcurve, "Power curve");
			
			LineData lineData2 = new LineData(dataSet2);
			dataSet2.setColor(ContextCompat.getColor(this, R.color.text));
			dataSet2.setCircleColor(ContextCompat.getColor(this, R.color.text));
			dataSet2.setValueTextColor(ContextCompat.getColor(this, R.color.text));
			dataSet2.setLineWidth(4);
			dataSet2.setDrawValues(false);
			dataSet2.setMode(LineDataSet.Mode.CUBIC_BEZIER);
			dataSet2.setCircleRadius(5);
			
			chart4.setData(lineData2);
			chart4.animateXY(2500,2000);
		}
	}
	
	
	public void _gra1(final double _mode) {
		if (_mode == 0) {
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
			chart1.getAxisLeft().setAxisMinValue(0);
			chart1.getAxisLeft().setAxisMaxValue(15);
			
			chart1.invalidate();
			List<Entry> history = new ArrayList<Entry>();
			count1 = 0;
			for(int _repeat14 = 0; _repeat14 < (int)(RUNNER.size()); _repeat14++) {
				rune = Double.parseDouble(RUNNER.get((int)count1).get("pt").toString());
				history.add(new Entry((int) count1, (int) rune));
				count1++;
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
			chart1.animateXY(2500,2000);
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
			chart1.getAxisLeft().setAxisMinValue(0);
			chart1.getAxisLeft().setAxisMaxValue(15);
			
			chart1.invalidate();
			List<Entry> history = new ArrayList<Entry>();
			count1 = 0;
			for(int _repeat32 = 0; _repeat32 < (int)(RUNNER.size()); _repeat32++) {
				if (RUNNER.size() < 50) {
					if ((count1 % 3) == 0) {
						rune = Double.parseDouble(RUNNER.get((int)count1).get("pt").toString());
						history.add(new Entry((int) count1, (int) rune));
					}
				}
				else {
					if ((count1 % 6) == 0) {
						rune = Double.parseDouble(RUNNER.get((int)count1).get("pt").toString());
						history.add(new Entry((int) count1, (int) rune));
					}
				}
				count1++;
			}
			LineDataSet dataSet = new LineDataSet(history, "History");
			
			LineData lineData = new LineData(dataSet);
			dataSet.setColor(ContextCompat.getColor(this, R.color.text));
			dataSet.setCircleColor(ContextCompat.getColor(this, R.color.text));
			dataSet.setValueTextColor(ContextCompat.getColor(this, R.color.text));
			dataSet.setLineWidth(3f);
			dataSet.setDrawValues(false);
			dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
			dataSet.setCircleRadius(3);
			
			chart1.setData(lineData);
			chart1.animateXY(2500,2000);
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