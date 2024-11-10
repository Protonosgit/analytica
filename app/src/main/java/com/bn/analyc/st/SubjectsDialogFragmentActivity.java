package com.bn.analyc.st;

import android.Manifest;
import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
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
import android.widget.Button;
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
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mrudultora.colorpicker.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import net.cachapa.expandablelayout.*;
import org.json.*;
import android.widget.LinearLayout;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.tabs.TabLayout;
import com.mrudultora.colorpicker.ColorPickerDialog;
import com.mrudultora.colorpicker.ColorPickerBottomSheetDialog;
import com.mrudultora.colorpicker.listeners.OnDirectSelectColorListener;
import com.mrudultora.colorpicker.listeners.OnSelectColorListener;
import com.mrudultora.colorpicker.util.ColorItemShape;

public class SubjectsDialogFragmentActivity extends DialogFragment {
	
	private Timer _timer = new Timer();
	
	private boolean evi = false;
	private double count2 = 0;
	private double count1 = 0;
	private boolean id_existing = false;
	private HashMap<String, Object> add_item = new HashMap<>();
private int scolor = 0;
	
	private ArrayList<HashMap<String, Object>> chooser = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> kill_list = new ArrayList<>();
	
	private LinearLayout linear1;
	private TextView textview1;
	private ImageView imageview1;
	private LinearLayout linear3;
	private LinearLayout linear5;
	private RelativeLayout relative1;
	private GridView gridview1;
	private Button button2;
	private Button button3;
	
	private SharedPreferences sp;
	private ObjectAnimator motion = new ObjectAnimator();
	private TimerTask tmr;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.subjects_dialog_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear1 = _view.findViewById(R.id.linear1);
		textview1 = _view.findViewById(R.id.textview1);
		imageview1 = _view.findViewById(R.id.imageview1);
		linear3 = _view.findViewById(R.id.linear3);
		linear5 = _view.findViewById(R.id.linear5);
		relative1 = _view.findViewById(R.id.relative1);
		gridview1 = _view.findViewById(R.id.gridview1);
		button2 = _view.findViewById(R.id.button2);
		button3 = _view.findViewById(R.id.button3);
		sp = getContext().getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				motion.setTarget(linear1);
				motion.setPropertyName("translationX");
				motion.setFloatValues((float)(0));
				motion.setFloatValues((float)(0), (float)(-800));
				motion.setDuration((int)(300));
				motion.setInterpolator(new LinearInterpolator());
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
				_timer.schedule(tmr, (int)(300));
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				new MaterialAlertDialogBuilder(getContext())
				    .setTitle("♻️ Fächer zurücksetzen")
				    .setMessage("⚠️ Dieser Vorgang ist irreversibel")
				    .setPositiveButton("BESTÄTIGEN", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						FileUtil.writeFile(sp.getString("cpath", ""), "[\n  {\n    \"id\": \"Mathematik\",\n    \"level\": \"t0\",\n    \"color\": \"-65536\"\n  },\n  {\n    \"id\": \"Deutsch\",\n    \"level\": \"t0\",\n    \"color\": \"-65536\"\n  },\n  {\n    \"id\": \"Englisch\",\n    \"level\": \"t0\",\n    \"color\": \"-65536\"\n  },\n  {\n    \"id\": \"Sport\",\n    \"level\": \"t0\",\n    \"color\": \"-65536\"\n  }\n]");
						com.google.android.material.snackbar.Snackbar.make(linear1, "✅️ Fächer zurückgesetzt", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
							@Override
							public void onClick(View _view) {
								 
							}
						}).show();
						    }
					 })
				                       
				     .setNegativeButton("Abbruch", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						 
						    }
					 })
				                       
				    .show();
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Ac1Activity menu = (Ac1Activity) getActivity();
				final EditText edit0 = new EditText(menu);
				final CheckBox check1 = new CheckBox(menu);
				final LinearLayout layout1 = new LinearLayout(menu);
				final LinearLayout colores = new LinearLayout(menu);
				
				layout1.addView(edit0);
				layout1.addView(check1);
				layout1.addView(colores);
				
				colores.getLayoutParams().width = 50;
				colores.getLayoutParams().height = 50;
				ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) colores.getLayoutParams();
				layoutParams.setMargins(20, 20, 0, 0);
				colores.setLayoutParams(layoutParams);
				
				check1.setText("Wichtig / Leistungskurs");
				layout1.setOrientation(LinearLayout.VERTICAL);
				edit0.setWidth(SketchwareUtil.getDisplayWidthPixels(getContext().getApplicationContext()));
				edit0.setSingleLine(true);
				edit0.setHint("Name");
				scolor = Color.RED;
				//colores.setBackgroundColor((int) color);
				
				colores.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, (int) scolor));
				colores.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						ColorPickerBottomSheetDialog colorPicke = new ColorPickerBottomSheetDialog(getContext()); 
						        colorPicke.setColumns(5)
						        .setColors(-24729642, -256, -6700269, -14508161, -1315860, -3050323, -7264853, -16744448, -65536, -16711423, -12490241, -1821306, -727899, -7942677, -64154, -16776961, -18055, -6751336, -14128533, -6250334)
						.setDialogTitle("Fachfarbe wählen")
						.setDefaultSelectedColor((int) Color.RED)		  
						.setOnSelectColorListener(new OnSelectColorListener() {
							                    @Override
							                    public void onColorSelected(int color, int position) {
								                        scolor = color;
								//colores.setBackgroundColor((int) color);
								
								colores.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, (int) scolor));
								                    }
							
							                    @Override
							                    public void cancel() {
								                        colorPicke.dismissDialog();
								                    }
							                })
								.show();
					}
				});
				AlertDialog dialoga = new MaterialAlertDialogBuilder(getContext())
				.setView(layout1)
				    .setTitle("📚 Neues Fach")
				    .setPositiveButton("Hinzufügen", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						try{
							if (_checkkey(1, "0", edit0.getText().toString().trim())) {
								add_item = new HashMap<>();
								add_item.put("id", edit0.getText().toString().trim());
								add_item.put("color", String.valueOf((long)(scolor)));
								if (check1.isChecked()) {
									add_item.put("level", "t1");
								}
								else {
									add_item.put("level", "t0");
								}
								chooser.add(add_item);
								FileUtil.writeFile(sp.getString("cpath", ""), new Gson().toJson(chooser));
								com.google.android.material.snackbar.Snackbar.make(linear1, "Neues Fach erstellt!", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
									@Override
									public void onClick(View _view) {
										 
									}
								}).show();
								gridview1.setAdapter(new Gridview1Adapter(chooser));
							}
							else {
								SketchwareUtil.CustomToast(getContext().getApplicationContext(), "Falsche Eingabe", 0xFFBDBDBD, 14, 0xFF000000, 3, SketchwareUtil.CENTER);
							}
						}catch(Exception e){
							SketchwareUtil.CustomToast(getContext().getApplicationContext(), "Fehler", 0xFFBDBDBD, 14, 0xFF000000, 3, SketchwareUtil.CENTER);
						}
						    }
					 })
				                       
				     .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						 
						    }
					 })
				                       
				  .create();
				dialoga.show();
				dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
				
				edit0.addTextChangedListener(new TextWatcher() {
								@Override
								public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
										final String edit0nn = _param1.toString();
										if (edit0.getText().toString().length() > 15) {
							edit0.setText(edit0.getText().toString().substring((int)(0), (int)(15)));
							dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
							
						}
						if (!_checkkey(1, "0", edit0.getText().toString().trim())) {
							((EditText)edit0).setError("Üngültiger Name");
							dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
							
						}
						else {
							dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
							
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
		evi = false;
		try{
			chooser = new Gson().fromJson(FileUtil.readFile(sp.getString("cpath", "")), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			if (FileUtil.isExistFile(sp.getString("path", ""))) {
				kill_list = new Gson().fromJson(FileUtil.readFile(sp.getString("path", "")), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			}
		}catch(Exception e){
			 
		}
		gridview1.setAdapter(new Gridview1Adapter(chooser));
		motion.setTarget(linear1);
		motion.setPropertyName("translationX");
		motion.setFloatValues((float)(0));
		motion.setFloatValues((float)(-800), (float)(0));
		motion.setDuration((int)(400));
		motion.setInterpolator(new DecelerateInterpolator());
		motion.start();
		getDialog().setOnKeyListener((dialogInterface, keyCode, event) -> {
			if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_UP) {
				imageview1.performClick();
				return (true);
			}
			return false;
		});
		
	}
	
	public boolean _checkkey(final double _mode, final String _old, final String _newer) {
		if (_mode == 1) {
			count2 = 0;
			if (_newer.length() < 1) {
				return (false);
			}
			for(int _repeat42 = 0; _repeat42 < (int)(chooser.size()); _repeat42++) {
				if (chooser.get((int)count2).get("id").toString().equals(_newer)) {
					return (false);
				}
				count2++;
			}
			return (true);
		}
		if (_mode == 2) {
			count2 = 0;
			if (_newer.length() < 1) {
				return (false);
			}
			if (FileUtil.isExistFile(sp.getString("path", ""))) {
				for(int _repeat165 = 0; _repeat165 < (int)(kill_list.size()); _repeat165++) {
					if (_old.equals(kill_list.get((int)count2).get("sj").toString())) {
						return (true);
					}
					count2++;
				}
			}
			return (true);
		}
		if (_mode == 3) {
			count2 = 0;
			if (FileUtil.isExistFile(sp.getString("path", ""))) {
				for(int _repeat150 = 0; _repeat150 < (int)(kill_list.size()); _repeat150++) {
					if (_old.equals(kill_list.get((int)count2).get("sj").toString())) {
						return (true);
					}
					count2++;
				}
			}
		}
		return (false);
	}
	
	public class Gridview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Gridview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
			
			textview1.setVisibility(View.VISIBLE);
			try{
				scolor = (int) Double.parseDouble(chooser.get((int)_position).get("color").toString());
				linear1.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						scolor = (int) Double.parseDouble(chooser.get((int)_position).get("color").toString());
						Ac1Activity menu = (Ac1Activity) getActivity();
						final EditText edit1 = new EditText(menu);
						final CheckBox check0 = new CheckBox(menu);
						final LinearLayout layout = new LinearLayout(menu);
						final LinearLayout colors = new LinearLayout(menu);
						
						layout.addView(edit1);
						layout.addView(check0);
						layout.addView(colors);
						
						layout.setOrientation(LinearLayout.VERTICAL);
						edit1.setWidth(SketchwareUtil.getDisplayWidthPixels(getContext().getApplicationContext()));
						colors.getLayoutParams().width = 50;
						colors.getLayoutParams().height = 50;
						ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) colors.getLayoutParams();
						layoutParams.setMargins(20, 20, 0, 0);
						colors.setLayoutParams(layoutParams);
						
						check0.setText("Wichtig / Leistungskurs");
						edit1.setSingleLine(true);
						//colors.setBackgroundColor((int) color);
						
						colors.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, (int) scolor));
						colors.setOnClickListener(new View.OnClickListener() {
							@Override
							public void onClick(View _view) {
								ColorPickerBottomSheetDialog colorPick = new ColorPickerBottomSheetDialog(getContext()); 
								        colorPick.setColumns(5)
								        .setColors(-24729642, -256, -6700269, -14508161, -1315860, -3050323, -7264853, -16744448, -65536, -16711423, -12490241, -1821306, -727899, -7942677, -64154, -16776961, -18055, -6751336, -14128533, -6250334)
								.setDialogTitle("Fachfarbe wählen")
								.setDefaultSelectedColor((int) scolor)		  
								.setOnSelectColorListener(new OnSelectColorListener() {
									                    @Override
									                    public void onColorSelected(int color, int position) {
										                        scolor = color;
										//colors.setBackgroundColor((int) color);
										
										colors.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, (int) scolor));
										                    }
									
									                    @Override
									                    public void cancel() {
										                        colorPick.dismissDialog();
										                    }
									                })
										.show();
							}
						});
						edit1.setHint("Name");
						edit1.addTextChangedListener(new TextWatcher() {
										@Override
										public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
												final String edit1nn = _param1.toString();
												if (edit1.getText().toString().length() > 15) {
									edit1.setText(edit1.getText().toString().substring((int)(0), (int)(15)));
								}
										}
										
										@Override
										public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
												
										}
										
										@Override
										public void afterTextChanged(Editable _param1) {
												
										}
								});
						edit1.setText(chooser.get((int)_position).get("id").toString());
						if (chooser.get((int)_position).get("level").toString().equals("t1")) {
							check0.setChecked(true);
						}
						AlertDialog dialog = new MaterialAlertDialogBuilder(getContext())
						.setView(layout)
						    .setTitle("✏️ Fach bearbeiten")
						    .setPositiveButton("Speichern", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								try{
									if (_checkkey(2, chooser.get((int)_position).get("id").toString(), edit1.getText().toString().trim())) {
										count1 = 0;
										id_existing = false;
										for(int _repeat62 = 0; _repeat62 < (int)(chooser.size()); _repeat62++) {
											if (chooser.get((int)count1).get("id").toString().equals(edit1.getText().toString().trim())) {
												id_existing = true;
											}
											count1++;
										}
										if (!id_existing) {
											chooser.get((int)_position).put("id", edit1.getText().toString().trim());
										}
										if (check0.isChecked()) {
											chooser.get((int)_position).put("level", "t1");
										}
										else {
											chooser.get((int)_position).put("level", "t0");
										}
										chooser.get((int)_position).put("color", String.valueOf((long)(scolor)));
										FileUtil.writeFile(sp.getString("cpath", ""), new Gson().toJson(chooser));
										SketchwareUtil.CustomToast(getContext().getApplicationContext(), "Fach gespeichert", 0xFFBDBDBD, 14, 0xFF000000, 3, SketchwareUtil.CENTER);
										notifyDataSetChanged();
									}
									else {
										SketchwareUtil.CustomToast(getContext().getApplicationContext(), "Ungültige Eingabe(n)", 0xFFBDBDBD, 14, 0xFF000000, 3, SketchwareUtil.CENTER);
									}
								}catch(Exception e){
									SketchwareUtil.CustomToast(getContext().getApplicationContext(), "Fehler bei Fächer_Hinzufügen", 0xFFBDBDBD, 14, 0xFF000000, 3, SketchwareUtil.CENTER);
								}
								    }
							 })
						                       
						     .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								 
								    }
							 })
						                       
						  .create();
						dialog.show();
					}
				});
				linear1.setOnLongClickListener(new View.OnLongClickListener() {
					@Override
					public boolean onLongClick(View _view) {
						new MaterialAlertDialogBuilder(getContext())
						    .setTitle("🗑 Löschen")
						    .setPositiveButton("Bestätigen", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								try{
									if (chooser.size() > 1) {
										if (_checkkey(3, chooser.get((int)_position).get("id").toString(), "0")) {
											new MaterialAlertDialogBuilder(getContext())
											    .setTitle("⚠️ Warnung")
											    .setMessage("Entferne zunächst alle Einträge mit diesem Fach!")
											    .setPositiveButton("Schließen", new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface dialogInterface, int i) {
													 
													    }
												 })
											                       
											    .show();
										}
										else {
											chooser.remove((int)(_position));
											FileUtil.writeFile(sp.getString("cpath", ""), new Gson().toJson(chooser));
											notifyDataSetChanged();
											SketchwareUtil.CustomToast(getContext().getApplicationContext(), "Fach gelöscht", 0xFFBDBDBD, 14, 0xFF000000, 3, SketchwareUtil.CENTER);
										}
									}
									else {
										SketchwareUtil.CustomToast(getContext().getApplicationContext(), "Es muss mindestens ein Fach vorhanden sein", 0xFFBDBDBD, 14, 0xFF000000, 3, SketchwareUtil.CENTER);
									}
								}catch(Exception e){
									SketchwareUtil.CustomToast(getContext().getApplicationContext(), "Fehler", 0xFFBDBDBD, 14, 0xFF000000, 3, SketchwareUtil.CENTER);
								}
								    }
							 })
						                       
						     .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								 
								    }
							 })
						                       
						    .show();
						return true;
					}
				});
				if (chooser.get((int)_position).get("level").toString().equals("t0")) {
					imageview1.setImageResource(R.drawable.ic_star);
				}
				else {
					imageview1.setImageResource(R.drawable.ic_star2);
				}
				textview1.setText(chooser.get((int)_position).get("id").toString());
				scolor = (int) Double.parseDouble(chooser.get((int)_position).get("color").toString());
				
				linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)10, (int)8, (int) scolor, Color.TRANSPARENT));
			}catch(Exception e){
				SketchwareUtil.CustomToast(getContext().getApplicationContext(), "😵 Ein Fehler ist aufgetreten bitte Entwickler kontaktieren!", 0xFF000000, 12, 0xFFFF5722, 4, SketchwareUtil.CENTER);
			}
			
			return _view;
		}
	}
}