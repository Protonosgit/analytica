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
import android.media.MediaPlayer;
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
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.github.mikephil.charting.*;
import com.google.android.material.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mrudultora.colorpicker.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
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

public class EditActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private ArrayList<HashMap<String, Object>> lister = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> subjects = new ArrayList<>();
	
	private LinearLayout edit;
	private TextView textview13;
	private LinearLayout linear1;
	private TextView textview12;
	private RecyclerView recyclerview1;
	private Button button2;
	private Button button1;
	
	private Intent intent = new Intent();
	private SharedPreferences sp;
	private TimerTask timer;
	private MediaPlayer media;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.edit);
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
		edit = findViewById(R.id.edit);
		textview13 = findViewById(R.id.textview13);
		linear1 = findViewById(R.id.linear1);
		textview12 = findViewById(R.id.textview12);
		recyclerview1 = findViewById(R.id.recyclerview1);
		button2 = findViewById(R.id.button2);
		button1 = findViewById(R.id.button1);
		sp = getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (FileUtil.readFile(sp.getString("path", "")).equals("")) {
					FileUtil.writeFile(sp.getString("path", ""), "[]");
				}
				sp.edit().putString("pointer", "+").commit();
				FragmentManager fg = getSupportFragmentManager();
				Dia2DialogFragmentActivity dialog = new Dia2DialogFragmentActivity();
				dialog.show( getSupportFragmentManager(),"1");
				fg.executePendingTransactions(); dialog.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() { @Override public void onDismiss(DialogInterface dialogInterface) {  
						 
						 
						_refreshData();
						
					} 
				});
			}
		});
	}
	
	private void initializeLogic() {
		if (FileUtil.getFileLength(sp.getString("path", "")) > 4) {
			lister = new Gson().fromJson(FileUtil.readFile(sp.getString("path", "")), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			subjects = new Gson().fromJson(FileUtil.readFile(sp.getString("cpath", "")), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			_refreshData();
			recyclerview1.setLayoutManager(new LinearLayoutManager(this));
			if (getIntent().getStringExtra("def").equals("e")) {
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								button1.performClick();
							}
						});
					}
				};
				_timer.schedule(timer, (int)(250));
			}
		}
		else {
			
		}
		button2.setVisibility(View.GONE);
	}
	
	
	@Override
	public void onBackPressed() {
		finish();
	}
	public boolean _valCheck(final String _in) {
		return (true);
	}
	
	
	public void _refreshData() {
		try{
			if (FileUtil.readFile(sp.getString("path", "")).length() > 5) {
				lister = new Gson().fromJson(FileUtil.readFile(sp.getString("path", "")), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				recyclerview1.setAdapter(new Recyclerview1Adapter(lister));
				recyclerview1.setLayoutManager(new LinearLayoutManager(this));
				textview12.setVisibility(View.GONE);
			}
			else {
				lister = new Gson().fromJson("[]", new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				recyclerview1.setAdapter(new Recyclerview1Adapter(lister));
				recyclerview1.setLayoutManager(new LinearLayoutManager(this));
				textview12.setVisibility(View.VISIBLE);
			}
			recyclerview1.setItemAnimator(new DefaultItemAnimator());
		}catch(Exception e){
			 
		}
	}
	
	public class Recyclerview1Adapter extends RecyclerView.Adapter<Recyclerview1Adapter.ViewHolder> {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Recyclerview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
			LayoutInflater _inflater = getLayoutInflater();
			View _v = _inflater.inflate(R.layout.editor, null);
			RecyclerView.LayoutParams _lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
			_v.setLayoutParams(_lp);
			return new ViewHolder(_v);
		}
		
		@Override
		public void onBindViewHolder(ViewHolder _holder, final int _position) {
			View _view = _holder.itemView;
			
			final LinearLayout frame = _view.findViewById(R.id.frame);
			final LinearLayout color = _view.findViewById(R.id.color);
			final LinearLayout core = _view.findViewById(R.id.core);
			final LinearLayout top = _view.findViewById(R.id.top);
			final LinearLayout bottom = _view.findViewById(R.id.bottom);
			final TextView numbertxt = _view.findViewById(R.id.numbertxt);
			final TextView sjtxt = _view.findViewById(R.id.sjtxt);
			final TextView tytxt = _view.findViewById(R.id.tytxt);
			final TextView grtxt = _view.findViewById(R.id.grtxt);
			
			try{
				numbertxt.setText(String.valueOf((long)(_position + 1)));
				sjtxt.setText(_data.get((int)_position).get("sj").toString());
				grtxt.setText(_data.get((int)_position).get("gr").toString());
				tytxt.setText(_data.get((int)_position).get("tp").toString());
				core.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						sp.edit().putString("pointer", String.valueOf((long)(_position))).commit();
						FragmentManager fg = getSupportFragmentManager();
						Dia2DialogFragmentActivity dialog = new Dia2DialogFragmentActivity();
						dialog.show( getSupportFragmentManager(),"1");
						fg.executePendingTransactions(); dialog.getDialog().setOnDismissListener(new DialogInterface.OnDismissListener() { @Override public void onDismiss(DialogInterface dialogInterface) {  
								 
								 
								_refreshData();
								
							} 
						});
					}
				});
				for (int iter = 0; iter < (int)(subjects.size()); iter++) {
					if (_data.get((int)_position).get("sj").toString().equals(subjects.get((int)iter).get("id").toString())) {
						//colors.setBackgroundColor((int) color);
						int scolor = (int) Double.parseDouble(subjects.get((int) iter).get("color").toString());
						
						color.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, (int) scolor));
					}
				}
			}catch(Exception e){
				SketchwareUtil.CustomToast(getApplicationContext(), "😵 Ein Fehler ist aufgetreten bitte Entwickler kontaktieren!", 0xFF000000, 12, 0xFFFF5722, 4, SketchwareUtil.CENTER);
				finish();
			}
		}
		
		@Override
		public int getItemCount() {
			return _data.size();
		}
		
		public class ViewHolder extends RecyclerView.ViewHolder {
			public ViewHolder(View v) {
				super(v);
			}
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