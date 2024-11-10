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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
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
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Dia2DialogFragmentActivity extends DialogFragment {
	
	private Timer _timer = new Timer();
	
	private double iter1 = 0;
	private HashMap<String, Object> maker = new HashMap<>();
	private boolean tes = false;
	private boolean ActivityStopped = false;
	
	private ArrayList<HashMap<String, Object>> loader = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> grmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> sjmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> tymap = new ArrayList<>();
	private ArrayList<String> grli = new ArrayList<>();
	private ArrayList<String> sjli = new ArrayList<>();
	private ArrayList<String> tyli = new ArrayList<>();
	
	private LinearLayout linear1;
	private TextView textview7;
	private ImageView imageview1;
	private TextView textview2;
	private Spinner spinner1;
	private TextView textview3;
	private Spinner spinner2;
	private TextView textview4;
	private Spinner spinner3;
	private CheckBox checkbox1;
	private LinearLayout linear4;
	private LinearLayout linear3;
	private Button button1;
	private Button button2;
	private TextView textview5;
	private TextView textview6;
	
	private Intent intent = new Intent();
	private SharedPreferences sp;
	private Calendar cale = Calendar.getInstance();
	private TimerTask timer;
	private AlertDialog.Builder fly;
	private ObjectAnimator intro = new ObjectAnimator();
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.dia2_dialog_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear1 = _view.findViewById(R.id.linear1);
		textview7 = _view.findViewById(R.id.textview7);
		imageview1 = _view.findViewById(R.id.imageview1);
		textview2 = _view.findViewById(R.id.textview2);
		spinner1 = _view.findViewById(R.id.spinner1);
		textview3 = _view.findViewById(R.id.textview3);
		spinner2 = _view.findViewById(R.id.spinner2);
		textview4 = _view.findViewById(R.id.textview4);
		spinner3 = _view.findViewById(R.id.spinner3);
		checkbox1 = _view.findViewById(R.id.checkbox1);
		linear4 = _view.findViewById(R.id.linear4);
		linear3 = _view.findViewById(R.id.linear3);
		button1 = _view.findViewById(R.id.button1);
		button2 = _view.findViewById(R.id.button2);
		textview5 = _view.findViewById(R.id.textview5);
		textview6 = _view.findViewById(R.id.textview6);
		sp = getContext().getSharedPreferences("sp", Activity.MODE_PRIVATE);
		fly = new AlertDialog.Builder(getActivity());
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intro.setTarget(linear1);
				intro.setPropertyName("translationX");
				intro.setFloatValues((float)(0));
				intro.setFloatValues((float)(0), (float)(800));
				intro.setDuration((int)(300));
				intro.setInterpolator(new LinearInterpolator());
				intro.start();
				timer = new TimerTask() {
					@Override
					public void run() {
						getActivity().runOnUiThread(new Runnable() {
							@Override
							public void run() {
								//ListView listItems = getActivity().findViewById(R.id.listview1);
								((EditActivity) getActivity())._refreshData();
								dismiss();
							}
						});
					}
				};
				_timer.schedule(timer, (int)(300));
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				cale = Calendar.getInstance();
				if (sp.getString("pointer", "").equals("+")) {
					maker = new HashMap<>();
					maker.put("sj", sjli.get((int)(spinner1.getSelectedItemPosition())));
					maker.put("tp", tyli.get((int)(spinner2.getSelectedItemPosition())));
					maker.put("gr", grli.get((int)(spinner3.getSelectedItemPosition())));
					if (sp.getString("Pointmode", "").equals("false")) {
						maker.put("mode", "");
					}
					else {
						maker.put("mode", "");
					}
					if (sp.getString("timestamps", "").equals("false")) {
						maker.put("dt", " /");
					}
					else {
						maker.put("dt", new SimpleDateFormat("dd.MM.YYYY HH:mm").format(cale.getTime()));
					}
					maker.put("ed", "/");
					loader.add(maker);
					FileUtil.writeFile(sp.getString("path", ""), new Gson().toJson(loader));
					com.google.android.material.snackbar.Snackbar.make(linear1, "✅️ Eintrag gespeichert!", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
						@Override
						public void onClick(View _view) {
							 
						}
					}).show();
				}
				else {
					try{
						loader.get((int)Double.parseDouble(sp.getString("pointer", ""))).put("sj", sjli.get((int)(spinner1.getSelectedItemPosition())));
						loader.get((int)Double.parseDouble(sp.getString("pointer", ""))).put("tp", tyli.get((int)(spinner2.getSelectedItemPosition())));
						loader.get((int)Double.parseDouble(sp.getString("pointer", ""))).put("gr", grli.get((int)(spinner3.getSelectedItemPosition())));
						if (sp.getString("Timestamps", "").equals("false")) {
							loader.get((int)Double.parseDouble(sp.getString("pointer", ""))).put("ed", "/");
						}
						else {
							loader.get((int)Double.parseDouble(sp.getString("pointer", ""))).put("ed", new SimpleDateFormat("dd.MM.YYYY HH:mm").format(cale.getTime()));
						}
						FileUtil.writeFile(sp.getString("path", ""), new Gson().toJson(loader));
						com.google.android.material.snackbar.Snackbar.make(linear1, "✅️ Eintrag geändert!", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
							@Override
							public void onClick(View _view) {
								 
							}
						}).show();
					}catch(Exception e){
						 
					}
				}
				if (checkbox1.isChecked() && sp.getString("pointer", "").equals("+")) {
					
				}
				else {
					imageview1.performClick();
				}
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				new MaterialAlertDialogBuilder(getContext())
				    .setTitle("🗑 Löschen")
				    .setMessage("Bist du dir sicher?")
				    .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						if (!sp.getString("pointer", "").equals("+")) {
							loader.remove((int)(Double.parseDouble(sp.getString("pointer", ""))));
							FileUtil.writeFile(sp.getString("path", ""), new Gson().toJson(loader));
							if (tes) {
								//ListView listItems = getActivity().findViewById(R.id.listview1);
								((EditActivity) getActivity())._refreshData();
							}
							imageview1.performClick();
						}
						    }
					 })
				                       
				     .setNegativeButton("Nein", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						 
						    }
					 })
				                       
				    .show();
			}
		});
	}
	
	private void initializeLogic() {
		Dialog dialog = getDialog();
		  if (dialog != null) { 
			  int width = ViewGroup.LayoutParams.MATCH_PARENT;
			  int height = ViewGroup.LayoutParams.MATCH_PARENT; 
			  dialog.getWindow().setLayout(width, height);
			dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); 
			   }
		linear1.getLayoutParams().width = SketchwareUtil.getDisplayWidthPixels(getContext().getApplicationContext());
		
		linear1.getLayoutParams().height = SketchwareUtil.getDisplayHeightPixels(getContext().getApplicationContext());
		if (sp.getString("timestamps", "").equals("false")) {
			linear3.setVisibility(View.INVISIBLE);
		}
		if (sp.contains("pointer")) {
			loader = new Gson().fromJson(FileUtil.readFile(sp.getString("path", "")), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			sjmap = new Gson().fromJson(FileUtil.readFile(sp.getString("cpath", "")), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			iter1 = Double.parseDouble(sp.getString("Gstart", ""));
			while((iter1 - 1) < Double.parseDouble(sp.getString("Gend", ""))) {
				grli.add(String.valueOf((long)(iter1)));
				iter1++;
			}
			tyli.add("Test");
			tyli.add("Klassenarbeit");
			tyli.add("Mündlich");
			tyli.add("Sonderleistung");
			iter1 = 0;
			for(int _repeat369 = 0; _repeat369 < (int)(sjmap.size()); _repeat369++) {
				sjli.add(sjmap.get((int)iter1).get("id").toString());
				iter1++;
			}
			if (sp.getString("Pointmode", "").equals("true")) {
				Collections.reverse(grli);
			}
			ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(getContext(),  R.layout.custom_spinner, sjli);
			spinner1.setAdapter(arrayAdapter1);
			ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<>(getContext(),  R.layout.custom_spinner, tyli);
			spinner2.setAdapter(arrayAdapter2);
			ArrayAdapter<String> arrayAdapter3 = new ArrayAdapter<>(getContext(),  R.layout.custom_spinner, grli);
			spinner3.setAdapter(arrayAdapter3);
			if ((FileUtil.readFile(sp.getString("path", "")).length() > 5) && !sp.getString("pointer", "").equals("+")) {
				iter1 = 0;
				checkbox1.setVisibility(View.GONE);
				for(int _repeat226 = 0; _repeat226 < (int)(sjli.size()); _repeat226++) {
					if (sjli.get((int)(iter1)).equals(loader.get((int)Double.parseDouble(sp.getString("pointer", ""))).get("sj").toString())) {
						spinner1.setSelection((int)(iter1));
					}
					iter1++;
				}
				iter1 = 0;
				for(int _repeat241 = 0; _repeat241 < (int)(tyli.size()); _repeat241++) {
					if (tyli.get((int)(iter1)).equals(loader.get((int)Double.parseDouble(sp.getString("pointer", ""))).get("tp").toString())) {
						spinner2.setSelection((int)(iter1));
					}
					iter1++;
				}
				iter1 = 0;
				for(int _repeat254 = 0; _repeat254 < (int)(grli.size()); _repeat254++) {
					if (grli.get((int)(iter1)).equals(loader.get((int)Double.parseDouble(sp.getString("pointer", ""))).get("gr").toString())) {
						spinner3.setSelection((int)(iter1));
					}
					iter1++;
				}
				textview6.setText("/");
				textview5.setText("/");
				if (loader.get((int)Double.parseDouble(sp.getString("pointer", ""))).containsKey("dt") && !loader.get((int)Double.parseDouble(sp.getString("pointer", ""))).get("dt").toString().equals("/")) {
					textview5.setText("Erstellt:".concat(loader.get((int)Double.parseDouble(sp.getString("pointer", ""))).get("dt").toString()));
				}
				if (loader.get((int)Double.parseDouble(sp.getString("pointer", ""))).containsKey("ed") && !loader.get((int)Double.parseDouble(sp.getString("pointer", ""))).get("ed").toString().equals("/")) {
					textview6.setText("Bearbeitet:".concat(loader.get((int)Double.parseDouble(sp.getString("pointer", ""))).get("ed").toString()));
				}
			}
			else {
				linear3.setVisibility(View.INVISIBLE);
				button2.setVisibility(View.GONE);
				textview7.setText("Eintrag hinzufügen");
			}
		}
		else {
			dismiss();
		}
		intro.setTarget(linear1);
		intro.setPropertyName("translationX");
		intro.setFloatValues((float)(0));
		intro.setFloatValues((float)(800), (float)(0));
		intro.setDuration((int)(400));
		intro.setInterpolator(new DecelerateInterpolator());
		intro.start();
		getDialog().setOnKeyListener((dialogInterface, keyCode, event) -> {
			if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
				imageview1.performClick();
				return (true);
			}
			return false;
		});
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (tes) {
			dismiss();
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		tes = true;
	}
	
	
	@Override
	public void onStop() {
		super.onStop();
		ActivityStopped = true;
	}
}