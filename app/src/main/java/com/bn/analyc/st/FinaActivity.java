package com.bn.analyc.st;

import android.Manifest;
import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import net.cachapa.expandablelayout.ExpandableLayout;
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

public class FinaActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private FloatingActionButton _fab;
	private double count2 = 0;
	private double count1 = 0;
	private double tp1 = 0;
	private double tp2 = 0;
	private double tp3 = 0;
	private double retu = 0;
	private double count3 = 0;
	private boolean chart_visible = false;
	private double rune = 0;
	private boolean fab_tmr = false;
	private double lt = 0;
	private double lk = 0;
	private double le = 0;
	private double ht = 0;
	private double hk = 0;
	private double he = 0;
	
	private ArrayList<HashMap<String, Object>> master = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> out = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> Lma = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> Hma = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> Ema = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> tycheck = new ArrayList<>();
	private ArrayList<String> graph_eva = new ArrayList<>();
	private ArrayList<String> subject_labels = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private LinearLayout linear2;
	private LinearLayout linear4;
	private TextView textview5;
	private ListView listview1;
	private TextView textview1;
	private TextView textview3;
	private TextView textview4;
	private TextView textview2;
	private RadarChart chart1;
	
	private AlertDialog.Builder dia;
	private ObjectAnimator anima = new ObjectAnimator();
	private SharedPreferences sp;
	private Intent intent = new Intent();
	private ObjectAnimator anima2 = new ObjectAnimator();
	private TimerTask clock;
	private TimerTask timer;
	private ObjectAnimator anima3 = new ObjectAnimator();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.fina);
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
		_fab = findViewById(R.id._fab);
		
		linear1 = findViewById(R.id.linear1);
		linear3 = findViewById(R.id.linear3);
		linear2 = findViewById(R.id.linear2);
		linear4 = findViewById(R.id.linear4);
		textview5 = findViewById(R.id.textview5);
		listview1 = findViewById(R.id.listview1);
		textview1 = findViewById(R.id.textview1);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview2 = findViewById(R.id.textview2);
		chart1 = findViewById(R.id.chart1);
		dia = new AlertDialog.Builder(this);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		listview1.setOnScrollListener(new AbsListView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView abs, int _scrollState) {
				if (fab_tmr) {
					timer.cancel();
					fab_tmr = false;
				}
				if (_scrollState == 1) {
					_fab.hide();
				}
				if (_scrollState == 0) {
					fab_tmr = true;
					timer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									_fab.hide();
									fab_tmr = false;
								}
							});
						}
					};
					_timer.schedule(timer, (int)(1000));
				}
			}
			
			@Override
			public void onScroll(AbsListView abs, int _firstVisibleItem, int _visibleItemCount, int _totalItemCount) {
				
			}
		});
		
		_fab.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View _view) {
				if (sp.getString("premium", "").equals("true")) {
					chart1.saveToGallery("power_chart");
						Toast toast = Toast.makeText(getApplicationContext(),"Saved to gallerie", Toast.LENGTH_SHORT);
						toast.show();
				}
				else {
						Toast toast = Toast.makeText(getApplicationContext(),"You do not own premium", Toast.LENGTH_SHORT);
						toast.show();
				}
				return true;
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!anima2.isRunning()) {
					if (chart_visible) {
						anima2.setTarget(linear3);
						anima2.setPropertyName("translationY");
						anima2.setFloatValues((float)(-400), (float)(0));
						anima2.setDuration((int)(600));
						anima2.setInterpolator(new AccelerateInterpolator());
						anima2.start();
						chart_visible = false;
					}
					else {
						anima2.setTarget(linear3);
						anima2.setPropertyName("translationY");
						anima2.setFloatValues((float)(0), (float)(-400));
						anima2.setDuration((int)(600));
						anima2.setInterpolator(new DecelerateInterpolator());
						anima2.start();
						chart_visible = true;
						chart1.animateXY(800,0);
					}
				}
			}
		});
	}
	
	private void initializeLogic() {
		_fab.setBackgroundColor(0xFF1FA9FF);
		chart1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFF000000));
		try{
			listview1.setSelector(android.R.color.transparent);
			RadarChart chart1 = (RadarChart) findViewById(R.id.chart1);
			master = new Gson().fromJson(FileUtil.readFile(sp.getString("path", "")), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			tycheck = new Gson().fromJson(FileUtil.readFile(sp.getString("cpath", "")), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			if (master.size() > 0) {
				textview5.setVisibility(View.GONE);
				count1 = 0;
				for(int _repeat125 = 0; _repeat125 < (int)(tycheck.size()); _repeat125++) {
					{
						HashMap<String, Object> _item = new HashMap<>();
						_item.put("hgv", "0");
						Hma.add(_item);
					}
					
					Hma.get((int)count1).put("gcv", "0");
					{
						HashMap<String, Object> _item = new HashMap<>();
						_item.put("lgv", "0");
						Lma.add(_item);
					}
					
					Lma.get((int)count1).put("gcv", "0");
					count1++;
				}
				count1 = 0;
				for(int _repeat148 = 0; _repeat148 < (int)(tycheck.size()); _repeat148++) {
					{
						HashMap<String, Object> _item = new HashMap<>();
						_item.put("val", "0");
						Ema.add(_item);
					}
					
					Ema.get((int)count1).put("gcv", "0");
					count1++;
				}
				count1 = 0;
				for(int _repeat156 = 0; _repeat156 < (int)(tycheck.size()); _repeat156++) {
					{
						HashMap<String, Object> _item = new HashMap<>();
						_item.put("pot1", "0");
						out.add(_item);
					}
					
					out.get((int)count1).put("pot2", "0");
					out.get((int)count1).put("pot3", "0");
					count1++;
				}
				_maindif();
				_secdif();
				_terdif();
				_gra1();
			}
		}catch(Exception e){
			 
		}
		_fab.hide();
	}
	
	public void _maindif() {
		try{
			count2 = 0;
			for(int _repeat10 = 0; _repeat10 < (int)(master.size()); _repeat10++) {
				count3 = 0;
				for(int _repeat1751 = 0; _repeat1751 < (int)(tycheck.size()); _repeat1751++) {
					if (tycheck.get((int)count3).get("id").toString().equals(master.get((int)count2).get("sj").toString())) {
						if (master.get((int)count2).get("tp").toString().equals("Klassenarbeit") || master.get((int)count2).get("tp").toString().equals("KA")) {
							Hma.get((int)count3).put("hgv", String.valueOf((long)(Double.parseDouble(Hma.get((int)count3).get("hgv").toString()) + Double.parseDouble(master.get((int)count2).get("gr").toString()))));
							Hma.get((int)count3).put("gcv", String.valueOf((long)(Double.parseDouble(Hma.get((int)count3).get("gcv").toString()) + 1)));
						}
						else {
							if (!master.get((int)count2).get("tp").toString().equals("Mündlich")) {
								Lma.get((int)count3).put("lgv", String.valueOf((long)(Double.parseDouble(Lma.get((int)count3).get("lgv").toString()) + Double.parseDouble(master.get((int)count2).get("gr").toString()))));
								Lma.get((int)count3).put("gcv", String.valueOf((long)(Double.parseDouble(Lma.get((int)count3).get("gcv").toString()) + 1)));
							}
						}
					}
					count3++;
				}
				count2++;
			}
		}catch(Exception e){
			SketchwareUtil.CustomToast(getApplicationContext(), "😵 Ein Fehler ist aufgetreten bitte Entwickler kontaktieren!", 0xFF000000, 12, 0xFFFF5722, 4, SketchwareUtil.CENTER);
			finish();
		}
	}
	
	
	public void _secdif() {
		try{
			count2 = 0;
			for(int _repeat10 = 0; _repeat10 < (int)(master.size()); _repeat10++) {
				count3 = 0;
				for(int _repeat380 = 0; _repeat380 < (int)(tycheck.size()); _repeat380++) {
					if (tycheck.get((int)count3).get("id").toString().equals(master.get((int)count2).get("sj").toString())) {
						if (master.get((int)count2).get("tp").toString().equals("Mündlich")) {
							Ema.get((int)count3).put("val", String.valueOf((long)(Double.parseDouble(Ema.get((int)count3).get("val").toString()) + Double.parseDouble(master.get((int)count2).get("gr").toString()))));
							Ema.get((int)count3).put("gcv", String.valueOf((long)(Double.parseDouble(Ema.get((int)count3).get("gcv").toString()) + 1)));
						}
					}
					count3++;
				}
				count2++;
			}
		}catch(Exception e){
			 
		}
	}
	
	
	public void _terdif() {
		try{
			count1 = 0;
			for(int _repeat10 = 0; _repeat10 < (int)(Hma.size()); _repeat10++) {
				if (Hma.get((int)count1).get("gcv").toString().equals("0")) {
					out.get((int)count1).put("pot1", "0");
				}
				else {
					out.get((int)count1).put("pot1", new DecimalFormat("0.00").format(Double.parseDouble(Hma.get((int)count1).get("hgv").toString()) / Double.parseDouble(Hma.get((int)count1).get("gcv").toString())));
				}
				count1++;
			}
			count1 = 0;
			for(int _repeat12 = 0; _repeat12 < (int)(Lma.size()); _repeat12++) {
				if (Lma.get((int)count1).get("gcv").toString().equals("0")) {
					out.get((int)count1).put("pot2", "0");
				}
				else {
					out.get((int)count1).put("pot2", new DecimalFormat("0.00").format(Double.parseDouble(Lma.get((int)count1).get("lgv").toString()) / Double.parseDouble(Lma.get((int)count1).get("gcv").toString())));
				}
				count1++;
			}
			count1 = 0;
			for(int _repeat14 = 0; _repeat14 < (int)(Ema.size()); _repeat14++) {
				if (Ema.get((int)count1).get("gcv").toString().equals("0")) {
					out.get((int)count1).put("pot3", "0");
				}
				else {
					out.get((int)count1).put("pot3", new DecimalFormat("0.00").format(Double.parseDouble(Ema.get((int)count1).get("val").toString()) / Double.parseDouble(Ema.get((int)count1).get("gcv").toString())));
				}
				count1++;
			}
			listview1.setAdapter(new Listview1Adapter(out));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		}catch(Exception e){
			 
		}
	}
	
	
	public double _EVAl(final double _pointer) {
		lt = Double.parseDouble(sp.getString("t0", "")) * 100;
		lk = Double.parseDouble(sp.getString("t1", "")) * 100;
		le = Double.parseDouble(sp.getString("t2", "")) * 100;
		ht = Double.parseDouble(sp.getString("t3", "")) * 100;
		hk = Double.parseDouble(sp.getString("t4", "")) * 100;
		he = Double.parseDouble(sp.getString("t5", "")) * 100;
		retu = -1;
		// ka
		tp1 = Double.parseDouble(out.get((int)_pointer).get("pot1").toString().replace(",", "."));
		// te
		tp2 = Double.parseDouble(out.get((int)_pointer).get("pot2").toString().replace(",", "."));
		// ep
		tp3 = Double.parseDouble(out.get((int)_pointer).get("pot3").toString().replace(",", "."));
		if (out.get((int)_pointer).get("pot1").toString().equals("0") || (out.get((int)_pointer).get("pot2").toString().equals("0") || out.get((int)_pointer).get("pot3").toString().equals("0"))) {
			if (tycheck.get((int)_pointer).get("level").toString().equals("t0")) {
				if (out.get((int)_pointer).get("pot1").toString().equals("0")) {
					retu = ((tp2 / 100) * lk) + ((tp3 / 100) * le);
				}
				if (out.get((int)_pointer).get("pot2").toString().equals("0")) {
					retu = ((tp1 / 100) * lt) + ((tp3 / 100) * le);
				}
				if (out.get((int)_pointer).get("pot3").toString().equals("0")) {
					retu = ((tp2 / 100) * lk) + ((tp1 / 100) * lt);
				}
				if (out.get((int)_pointer).get("pot1").toString().equals("0") && out.get((int)_pointer).get("pot2").toString().equals("0")) {
					retu = tp3;
				}
				if (out.get((int)_pointer).get("pot1").toString().equals("0") && out.get((int)_pointer).get("pot3").toString().equals("0")) {
					retu = tp2;
				}
				if (out.get((int)_pointer).get("pot2").toString().equals("0") && out.get((int)_pointer).get("pot3").toString().equals("0")) {
					retu = tp1;
				}
			}
			else {
				if (out.get((int)_pointer).get("pot1").toString().equals("0")) {
					retu = ((tp2 / 100) * hk) + ((tp3 / 100) * he);
				}
				if (out.get((int)_pointer).get("pot2").toString().equals("0")) {
					retu = ((tp1 / 100) * ht) + ((tp3 / 100) * he);
				}
				if (out.get((int)_pointer).get("pot3").toString().equals("0")) {
					retu = ((tp2 / 100) * hk) + ((tp1 / 100) * ht);
				}
				if (out.get((int)_pointer).get("pot1").toString().equals("0") && out.get((int)_pointer).get("pot2").toString().equals("0")) {
					retu = tp3;
				}
				if (out.get((int)_pointer).get("pot1").toString().equals("0") && out.get((int)_pointer).get("pot3").toString().equals("0")) {
					retu = tp2;
				}
				if (out.get((int)_pointer).get("pot2").toString().equals("0") && out.get((int)_pointer).get("pot3").toString().equals("0")) {
					retu = tp1;
				}
			}
		}
		else {
			if (tycheck.get((int)_pointer).get("level").toString().equals("t0")) {
				return (((Double.parseDouble(new DecimalFormat("1").format(tp1)) / 100) * lt) + (((Double.parseDouble(new DecimalFormat("1").format(tp2)) / 100) * lk) + ((Double.parseDouble(new DecimalFormat("1").format(tp3)) / 100) * le)));
			}
			else {
				return (((Double.parseDouble(new DecimalFormat("1").format(tp1)) / 100) * ht) + (((Double.parseDouble(new DecimalFormat("1").format(tp2)) / 100) * hk) + ((Double.parseDouble(new DecimalFormat("1").format(tp3)) / 100) * he)));
			}
		}
		return (retu);
	}
	
	
	public void _gra1() {
		//radar chart 1
		clock = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						chart1.getDescription().setEnabled(false);
						chart1.getLegend().setEnabled(false);
						chart1.getXAxis().setDrawGridLines(false);
						chart1.getXAxis().setDrawLabels(false);
						chart1.getXAxis().setDrawAxisLine(false);
						chart1.getXAxis().setDrawLabels(false);
						chart1.getYAxis().setDrawLabels(false);
						chart1.setWebColor(0xFFFFFFFF);
						chart1.setWebColorInner(0xFFFFFFFF);
						
						int min = (int) Double.parseDouble(sp.getString("Gstart", ""));
						int max = (int) Double.parseDouble(sp.getString("Gend", ""));
						chart1.setTouchEnabled(false);
						chart1.getXAxis().setAxisMinValue(3);
						chart1.getXAxis().setAxisMaxValue(30);
						chart1.getYAxis().setAxisMinValue(min);
						chart1.getYAxis().setAxisMaxValue(max);
						chart1.invalidate();
						ArrayList<RadarEntry> power = new ArrayList<>();
						count1 = 0;
						for(int _repeat67 = 0; _repeat67 < (int)(graph_eva.size()); _repeat67++) {
							rune = Double.parseDouble(graph_eva.get((int)(count1)));
							power.add(new RadarEntry((int) rune));
							count1++;
						}
						RadarDataSet dataSet = new RadarDataSet(power, "Power");
						
						RadarData lineData = new RadarData(dataSet);
						
						dataSet.setDrawHorizontalHighlightIndicator(false);
						dataSet.setDrawVerticalHighlightIndicator(false);
						dataSet.setColor(0xFFFFFFFF);
						dataSet.setLineWidth(3f);
						dataSet.setValueTextColor(0xFFFFFFFF);
						chart1.setData(lineData);
						if (graph_eva.size() < 3) {
							_fab.setVisibility(View.GONE);
						}
						if (sp.getString("premium", "").equals("true")) {
							chart1.setDragDecelerationFrictionCoef(0);
							chart1.setTouchEnabled(true);
							chart1.setHardwareAccelerationEnabled(true);
							chart1.invalidate();
							
							chart1.setMarker(new MarkerView(FinaActivity.this,R.layout.tooltip){
								    @Override
								    public void refreshContent(Entry e,  Highlight highlight) {
									        float x=e.getX();
									        float y=e.getY();
									        TextView tooltip = (TextView)findViewById(R.id.tooltxt);
									        tooltip.setText(subject_labels.get((int)(highlight.getX())));
									        super.refreshContent(e, highlight);
									        }
								    });
						}
					}
				});
			}
		};
		_timer.schedule(clock, (int)(200));
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.fina_list, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final net.cachapa.expandablelayout.ExpandableLayout expander = _view.findViewById(R.id.expander);
			final ImageView imageview3 = _view.findViewById(R.id.imageview3);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			
			try{
				if (!(out.get((int)_position).get("pot1").toString().equals("0") && (out.get((int)_position).get("pot2").toString().equals("0") && out.get((int)_position).get("pot3").toString().equals("0")))) {
					textview1.setText(tycheck.get((int)_position).get("id").toString());
					if (_EVAl(_position) == -1) {
						textview2.setText("err");
					}
					else {
						textview2.setText(new DecimalFormat("0.00").format(_EVAl(_position)));
						graph_eva.add(String.valueOf(_EVAl(_position)));
						subject_labels.add(tycheck.get((int)_position).get("id").toString());
					}
					linear1.setVisibility(View.VISIBLE);
					imageview1.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							if (!anima.isRunning()) {
								if (expander.isExpanded()) {
									expander.collapse();
									anima.setTarget(imageview1);
									anima.setPropertyName("rotation");
									anima.setFloatValues((float)(180), (float)(0));
									anima.setDuration((int)(400));
									anima.setInterpolator(new DecelerateInterpolator());
									anima.start();
								}
								else {
									expander.expand();
									anima.setTarget(imageview1);
									anima.setPropertyName("rotation");
									anima.setFloatValues((float)(0), (float)(180));
									anima.setDuration((int)(400));
									anima.setInterpolator(new DecelerateInterpolator());
									anima.start();
								}
							}
						}
					});
					if (!out.get((int)_position).get("pot1").toString().equals("0")) {
						textview3.setText(out.get((int)_position).get("pot1").toString());
					}
					if (!out.get((int)_position).get("pot2").toString().equals("0")) {
						textview4.setText(out.get((int)_position).get("pot2").toString());
					}
					if (!out.get((int)_position).get("pot3").toString().equals("0")) {
						textview5.setText(out.get((int)_position).get("pot3").toString());
					}
					if (tycheck.get((int)_position).get("level").toString().equals("t0")) {
						imageview3.setImageResource(R.drawable.ic_star);
					}
					else {
						imageview3.setImageResource(R.drawable.ic_star2);
					}
				}
				else {
					linear1.setVisibility(View.GONE);
				}
			}catch(Exception e){
				SketchwareUtil.CustomToast(getApplicationContext(), "😵 Ein Fehler ist aufgetreten bitte Entwickler kontaktieren!", 0xFF000000, 12, 0xFFFF5722, 4, SketchwareUtil.CENTER);
				finish();
			}
			
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