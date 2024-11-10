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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
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
import java.util.Base64;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import androidx.appcompat.app.AlertDialog;

public class DiaDialogFragmentActivity extends DialogFragment {
	
	private Timer _timer = new Timer();
	
	private String beIN = "";
	private String beOUT = "";
	private String meta = "";
	private double count1 = 0;
	private String path = "";
	private HashMap<String, Object> sjmapper = new HashMap<>();
	private HashMap<String, Object> colmapper = new HashMap<>();
	private double count2 = 0;
	private double deletePointer = 0;
	
	private ArrayList<HashMap<String, Object>> checklist = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> sj_fixlist = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> sjmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> router = new ArrayList<>();
	private ArrayList<String> colcheck = new ArrayList<>();
	private ArrayList<String> routerlist = new ArrayList<>();
	
	private LinearLayout linear1;
	private TextView textview9;
	private TextView textview12;
	private LinearLayout linear7;
	private ListView listview1;
	private Button button9;
	private LinearLayout linear8;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear13;
	private LinearLayout linear9;
	private TextView textview10;
	private TextView textview11;
	private ImageView imageview2;
	private TextView textview6;
	private ImageView imageview3;
	private TextView textview7;
	private ImageView imageview6;
	private TextView textview14;
	private ImageView imageview4;
	private TextView textview8;
	
	private TimerTask tmr;
	private Calendar cal = Calendar.getInstance();
	private SharedPreferences sp;
	private Intent intent = new Intent();
	private Calendar calendar = Calendar.getInstance();
	private ObjectAnimator motion = new ObjectAnimator();
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.dia_dialog_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear1 = _view.findViewById(R.id.linear1);
		textview9 = _view.findViewById(R.id.textview9);
		textview12 = _view.findViewById(R.id.textview12);
		linear7 = _view.findViewById(R.id.linear7);
		listview1 = _view.findViewById(R.id.listview1);
		button9 = _view.findViewById(R.id.button9);
		linear8 = _view.findViewById(R.id.linear8);
		linear10 = _view.findViewById(R.id.linear10);
		linear11 = _view.findViewById(R.id.linear11);
		linear13 = _view.findViewById(R.id.linear13);
		linear9 = _view.findViewById(R.id.linear9);
		textview10 = _view.findViewById(R.id.textview10);
		textview11 = _view.findViewById(R.id.textview11);
		imageview2 = _view.findViewById(R.id.imageview2);
		textview6 = _view.findViewById(R.id.textview6);
		imageview3 = _view.findViewById(R.id.imageview3);
		textview7 = _view.findViewById(R.id.textview7);
		imageview6 = _view.findViewById(R.id.imageview6);
		textview14 = _view.findViewById(R.id.textview14);
		imageview4 = _view.findViewById(R.id.imageview4);
		textview8 = _view.findViewById(R.id.textview8);
		sp = getContext().getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		textview9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				sp.edit().putString("path", router.get((int)_position).get("path").toString()).commit();
				_loadeouterlist();
				SketchwareUtil.CustomToast(getContext().getApplicationContext(), "Kollektion geändert", 0xFFBDBDBD, 14, 0xFF000000, 3, SketchwareUtil.CENTER);
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				
				return true;
			}
		});
		
		button9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sp.getString("premium", "").equals("true") || (routerlist.size() < 3)) {
					Ac1Activity menu = (Ac1Activity) getActivity();
					final EditText edit0 = new EditText(menu);
					
					edit0.setSingleLine(true);
					edit0.setHint("Name der Kollektion");
					AlertDialog dialoga = new MaterialAlertDialogBuilder(getContext())
					    .setTitle("📒 Neue Kollektion")
					    .setPositiveButton("Erstellen", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialogInterface, int i) {
							FileUtil.writeFile(sp.getString("dpath", "").concat("/".concat(edit0.getText().toString().trim().concat(".pajs"))), "[]");
							_loadeouterlist();
							if (routerlist.size() < 2) {
								sp.edit().putString("path", routerlist.get((int)(0))).commit();
							}
							com.google.android.material.snackbar.Snackbar.make(linear1, "✅️ Neue Kollektion erstellt", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
								@Override
								public void onClick(View _view) {
									 
								}
							}).show();
							_loadeouterlist();
							    }
						 })
					                       
					     .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialogInterface, int i) {
							 
							    }
						 })
					                       
					.setView(edit0)
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
							count1 = 0;
							for(int _repeat266 = 0; _repeat266 < (int)(routerlist.size()); _repeat266++) {
								if (Uri.parse(routerlist.get((int)(count1))).getLastPathSegment().equals(edit0.getText().toString().trim().concat(".pajs"))) {
									((EditText)edit0).setError("Bereits vorhanden");
									dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
									
								}
								count1++;
							}
							if (edit0.getText().toString().contains("/") || (edit0.getText().toString().contains(".") || (edit0.getText().toString().contains("%") || (edit0.getText().toString().contains("#") || (edit0.getText().toString().contains(":") || edit0.getText().toString().contains("?")))))) {
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
				else {
					com.google.android.material.snackbar.Snackbar.make(linear1, "🪅 Du brauchst Premium um mehr Kollektionen zu nutzen", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Holen", new View.OnClickListener(){
						@Override
						public void onClick(View _view) {
							intent.putExtra("tmp1", "s2");
							SysDialogFragmentActivity dialog = new SysDialogFragmentActivity();
							dialog.show(getActivity().getSupportFragmentManager(),"1");
						}
					}).show();
				}
			}
		});
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (FileUtil.readFile(sp.getString("path", "")).equals("[]")) {
					Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
					intent.setType("*/*");
					intent.createChooser(intent, "Import PAM file");
					startActivityForResult(intent, 8777);
				}
				else {
					com.google.android.material.snackbar.Snackbar.make(linear1, "❌️ Wähle eine leere Kollektion ", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
						@Override
						public void onClick(View _view) {
							 
						}
					}).show();
				}
			}
		});
		
		linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				try{
					cal = Calendar.getInstance();
					count1 = 1;
					meta = new SimpleDateFormat("dd.MM.YYYY_HH:mm").format(cal.getTime()).concat("_pamfile_classA5.2");
					while(FileUtil.isExistFile("/storage/emulated/0/Download/SchoolStats/paex_".concat(String.valueOf((long)(count1)).concat(".pam")))) {
						count1++;
					}
					if (FileUtil.readFile(sp.getString("path", "")).length() > 5) {
						beIN = meta.concat(FileUtil.readFile(sp.getString("path", "")));
						beOUT = Base64.getEncoder().encodeToString(beIN.getBytes());
						FileUtil.writeFile("/storage/emulated/0/Download/SchoolStats/paex_".concat(String.valueOf((long)(count1)).concat(".pam")), "_pamsys<".concat(beOUT.concat(">expdatSSclass")));
						if (FileUtil.isExistFile("/storage/emulated/0/Download/SchoolStats/paex_".concat(String.valueOf((long)(count1)).concat(".pam")))) {
							com.google.android.material.snackbar.Snackbar.make(linear1, "✅️ Daten exportiert!", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
								@Override
								public void onClick(View _view) {
									 
								}
							}).show();
						}
						else {
							com.google.android.material.snackbar.Snackbar.make(linear1, "❌️ Fehler (keine Speicher Berechtigung)", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
								@Override
								public void onClick(View _view) {
									 
								}
							}).show();
						}
					}
					else {
						com.google.android.material.snackbar.Snackbar.make(linear1, "❌️ Keine Daten zu exportieren", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
							@Override
							public void onClick(View _view) {
								 
							}
						}).show();
					}
				}catch(Exception e){
					com.google.android.material.snackbar.Snackbar.make(linear1, "❌️ Fehler", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
						@Override
						public void onClick(View _view) {
							 
						}
					}).show();
				}
			}
		});
		
		linear13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				//Export all data as json
				try{
					 
				}catch(Exception e){
					com.google.android.material.snackbar.Snackbar.make(linear1, "❌️ Fehler", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
						@Override
						public void onClick(View _view) {
							 
						}
					}).show();
				}
			}
		});
		
		linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				deletePointer = routerlist.indexOf(sp.getString("path", ""));
				new MaterialAlertDialogBuilder(getContext())
				    .setTitle("🗑 Löschen")
				    .setMessage("Die Kollektion wird permanent entfernt")
				    .setPositiveButton("Bestätigen", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						try{
							FileUtil.deleteFile(routerlist.get((int)(deletePointer)));
							routerlist.remove((int)(deletePointer));
							if (routerlist.size() == 0) {
								sp.edit().putString("path", "").commit();
							}
							else {
								sp.edit().putString("path", routerlist.get((int)(0))).commit();
							}
							_loadeouterlist();
							com.google.android.material.snackbar.Snackbar.make(linear1, "✅️ Kollektion gelöscht", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
								@Override
								public void onClick(View _view) {
									 
								}
							}).show();
						}catch(Exception e){
							com.google.android.material.snackbar.Snackbar.make(linear1, "🚫 Fehler", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
								@Override
								public void onClick(View _view) {
									 
								}
							}).show();
						}
						    }
					 })
				                       
				     .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
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
		beIN = "";
		beOUT = "";
		sjmap = new Gson().fromJson(FileUtil.readFile(sp.getString("cpath", "")), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		_loadeouterlist();
		linear1.getLayoutParams().width = SketchwareUtil.getDisplayWidthPixels(getContext().getApplicationContext())-100;
		
		linear1.getLayoutParams().height = SketchwareUtil.getDisplayHeightPixels(getContext().getApplicationContext())-200;
		if (sp.getString("premium", "").equals("true")) {
			
		}
		linear7.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)2, 0xFFBDBDBD, Color.TRANSPARENT));
		motion.setTarget(linear1);
		motion.setPropertyName("translationY");
		motion.setFloatValues((float)(0));
		motion.setFloatValues((float)(800), (float)(0));
		motion.setDuration((int)(300));
		motion.setInterpolator(new DecelerateInterpolator());
		motion.start();
		getDialog().setOnKeyListener((dialogInterface, keyCode, event) -> {
			if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
				motion.setTarget(linear1);
				motion.setPropertyName("translationY");
				motion.setFloatValues((float)(0));
				motion.setFloatValues((float)(0), (float)(900));
				motion.setDuration((int)(300));
				motion.setInterpolator(new AccelerateInterpolator());
				motion.start();
				tmr = new TimerTask() {
					@Override
					public void run() {
						getActivity().runOnUiThread(new Runnable() {
							@Override
							public void run() {
								dismiss();
							}
						});
					}
				};
				_timer.schedule(tmr, (int)(200));
				return (true);
			}
			return false;
		});
		
		linear13.setVisibility(View.GONE);
	}
	
	@Override
	public void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		if (_resultCode == -1) {
				try{
						Uri uri = null;
						uri  =  _data.getData();
						File file = new File(uri.getPath());
						final String[] split = file.getPath().split(":");
						String filePath = split[1];
						if (filePath.contains("/") && filePath.contains(".")) {
								path = "/storage/emulated/0/".concat(filePath);
								beOUT = "";
								if (path.contains(".pam")) {
										if (FileUtil.readFile(path).contains("_pamsys<")) {
												beIN = FileUtil.readFile(path).replace("_pamsys<", "").replace(">expdatSSclass", "");
												byte[] byteget = Base64.getDecoder().decode(beIN);
												String beOUT= new String(byteget);
												if (_valCheck(beOUT.replace(beOUT.substring((int)(0), (int)(34)), ""))) {
														FileUtil.writeFile(sp.getString("path", ""), beOUT.replace(beOUT.substring((int)(0), (int)(34)), ""));
														sj_fixlist = new Gson().fromJson(beOUT.replace(beOUT.substring((int)(0), (int)(34)), ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
														count1 = 0;
														for(int _repeat415 = 0; _repeat415 < (int)(sj_fixlist.size()); _repeat415++) {
																if (!_comparator(sj_fixlist.get((int)count1).get("sj").toString())) {
																		sjmapper = new HashMap<>();
																		sjmapper.put("id", sj_fixlist.get((int)count1).get("sj").toString());
																		sjmapper.put("color", "-65536");
																		sjmapper.put("level", "t0");
																		sjmap.add(sjmapper);
																}
																count1++;
														}
														tmr = new TimerTask() {
																@Override
																public void run() {
																		getActivity().runOnUiThread(new Runnable() {
																				@Override
																				public void run() {
																						FileUtil.writeFile(sp.getString("cpath", ""), new Gson().toJson(sjmap));
																						com.google.android.material.snackbar.Snackbar.make(linear1, "✅️ Daten importiert", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
																								@Override
																								public void onClick(View _view) {
																										 
																								}
																						}).show();
																				}
																		});
																}
														};
														_timer.schedule(tmr, (int)(200));
												}
												else {
														com.google.android.material.snackbar.Snackbar.make(linear1, "❌️ Daten beschädigt ", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
																@Override
																public void onClick(View _view) {
																		 
																}
														}).show();
												}
										}
										else {
												com.google.android.material.snackbar.Snackbar.make(linear1, "📛 Inkompatibele Version", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
														@Override
														public void onClick(View _view) {
																 
														}
												}).show();
										}
								}
								else {
										com.google.android.material.snackbar.Snackbar.make(linear1, "❌️ Ungültiger Pfad", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
												@Override
												public void onClick(View _view) {
														 
												}
										}).show();
								}
						}
						else {
								new MaterialAlertDialogBuilder(getContext())
								    .setTitle("🚫 Fehler")
								    .setMessage("Bitte den Pfad vom internen Speicher wählen und nicht von den Shortcuts (Dokumente, etc)!")
								    .setPositiveButton("Neuer Versuch", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface dialogInterface, int i) {
												linear10.performClick();
												    }
										 })
								                       
								     .setNegativeButton("Abbruch", new DialogInterface.OnClickListener() {
										@Override
										public void onClick(DialogInterface dialogInterface, int i) {
												 
												    }
										 })
								                       
								    .show();
						}
				}catch(Exception e){
						com.google.android.material.snackbar.Snackbar.make(linear1, "❌️ Fehler", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
								@Override
								public void onClick(View _view) {
										 
								}
						}).show();
				}
		}
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	
	@Override
	public void onStop() {
		super.onStop();
		((Ac1Activity) getActivity())._updateCallback();
	}
	public boolean _valCheck(final String _in) {
		count1 = 0;
		if (_in.length() > 4) {
			if (_in.contains("[{") && _in.contains("}]")) {
				try{
					checklist = new Gson().fromJson(_in, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
					if (checklist.size() > 0) {
						for(int _repeat39 = 0; _repeat39 < (int)(checklist.size()); _repeat39++) {
							if (!checklist.get((int)count1).containsKey("dt")) {
								return (false);
							}
							if (!checklist.get((int)count1).containsKey("sj")) {
								return (false);
							}
							if (!checklist.get((int)count1).containsKey("gr")) {
								return (false);
							}
							if (!checklist.get((int)count1).containsKey("tp")) {
								return (false);
							}
							count1++;
						}
					}
					else {
						return (false);
					}
				}catch(Exception e){
					return (false);
				}
			}
			else {
				return (false);
			}
		}
		else {
			return (false);
		}
		return (true);
	}
	
	
	public boolean _comparator(final String _target) {
		count2 = 0;
		for(int _repeat23 = 0; _repeat23 < (int)(sjmap.size()); _repeat23++) {
			if (sjmap.get((int)count2).get("id").toString().equals(_target)) {
				return (true);
			}
			count2++;
		}
		return (false);
	}
	
	
	public void _loadeouterlist() {
		linear7.setVisibility(View.VISIBLE);
		textview12.setVisibility(View.GONE);
		try{
			routerlist.clear();
			router.clear();
			FileUtil.listDir(sp.getString("dpath", ""), routerlist);
			count1 = 0;
			for(int _repeat13 = 0; _repeat13 < (int)(routerlist.size()); _repeat13++) {
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("name", Uri.parse(routerlist.get((int)(count1))).getLastPathSegment().replace(".pajs", ""));
					router.add(_item);
				}
				
				router.get((int)count1).put("path", routerlist.get((int)(count1)));
				count1++;
			}
			tmr = new TimerTask() {
				@Override
				public void run() {
					getActivity().runOnUiThread(new Runnable() {
						@Override
						public void run() {
							listview1.setAdapter(new Listview1Adapter(router));
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						}
					});
				}
			};
			_timer.schedule(tmr, (int)(50));
			if (sp.getString("path", "").equals("")) {
				linear7.setVisibility(View.GONE);
				textview12.setVisibility(View.VISIBLE);
			}
			else {
				textview11.setText(Uri.parse(sp.getString("path", "")).getLastPathSegment().replace(".pajs", ""));
			}
		}catch(Exception e){
			 
		}
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
			LayoutInflater _inflater = getActivity().getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.scpick, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			imageview1.setVisibility(View.GONE);
			linear1.setBackgroundColor(Color.TRANSPARENT);
			try{
				textview1.setText(router.get((int)_position).get("name").toString());
				if (router.get((int)_position).get("path").toString().equals(sp.getString("path", ""))) {
					linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)3, 0xFFE11E72, Color.TRANSPARENT));
				}
				else {
					linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, Color.TRANSPARENT));
				}
			}catch(Exception e){
				 
			}
			
			return _view;
		}
	}
}