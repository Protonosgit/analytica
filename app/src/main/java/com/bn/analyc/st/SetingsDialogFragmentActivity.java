package com.bn.analyc.st;

import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.LinearLayout;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.slider.RangeSlider;
import com.google.android.material.slider.Slider;
import androidx.appcompat.app.AppCompatDelegate;

public class SetingsDialogFragmentActivity extends DialogFragment {
	
	private Timer _timer = new Timer();
	
	private double count1 = 0;
	
	private ArrayList<HashMap<String, Object>> checklist = new ArrayList<>();
	private ArrayList<String> states = new ArrayList<>();
	
	private ScrollView vscroll1;
	private LinearLayout linear1;
	private TextView textview1;
	private ImageView imageview1;
	private LinearLayout linear4;
	private LinearLayout linear7;
	private LinearLayout linear11;
	private LinearLayout linear17;
	private LinearLayout linear36;
	private LinearLayout linear14;
	private LinearLayout linear9;
	private LinearLayout linear42;
	private Button button1;
	private LinearLayout linear8;
	private Spinner spinner1;
	private LinearLayout linear44;
	private TextView textview23;
	private Switch switch2;
	private TextView textview4;
	private TextView textview7;
	private TextView textview48;
	private RangeSlider slider1;
	private LinearLayout linear23;
	private LinearLayout linear19;
	private TextView textview15;
	private LinearLayout linear20;
	private LinearLayout linear21;
	private LinearLayout linear22;
	private TextView textview16;
	private TextView textview21;
	private TextView textview17;
	private TextView textview20;
	private TextView textview18;
	private TextView textview22;
	private LinearLayout linear37;
	private LinearLayout linear38;
	private TextView textview38;
	private LinearLayout linear39;
	private LinearLayout linear40;
	private LinearLayout linear41;
	private TextView textview39;
	private TextView textview40;
	private TextView textview41;
	private TextView textview42;
	private TextView textview43;
	private TextView textview44;
	private Switch switch4;
	private TextView textview11;
	private Switch switch3;
	private TextView textview8;
	private TextView textview46;
	private LinearLayout linear43;
	private RadioButton radiobutton1;
	private RadioButton radiobutton2;
	private RadioButton radiobutton3;
	private Switch switch5;
	private TextView textview6;
	private Switch switch6;
	private TextView textview47;
	
	private SharedPreferences sp;
	private TimerTask tmr;
	private Intent intent = new Intent();
	private Calendar calendar = Calendar.getInstance();
	private ObjectAnimator motion = new ObjectAnimator();
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.setings_dialog_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		vscroll1 = _view.findViewById(R.id.vscroll1);
		linear1 = _view.findViewById(R.id.linear1);
		textview1 = _view.findViewById(R.id.textview1);
		imageview1 = _view.findViewById(R.id.imageview1);
		linear4 = _view.findViewById(R.id.linear4);
		linear7 = _view.findViewById(R.id.linear7);
		linear11 = _view.findViewById(R.id.linear11);
		linear17 = _view.findViewById(R.id.linear17);
		linear36 = _view.findViewById(R.id.linear36);
		linear14 = _view.findViewById(R.id.linear14);
		linear9 = _view.findViewById(R.id.linear9);
		linear42 = _view.findViewById(R.id.linear42);
		button1 = _view.findViewById(R.id.button1);
		linear8 = _view.findViewById(R.id.linear8);
		spinner1 = _view.findViewById(R.id.spinner1);
		linear44 = _view.findViewById(R.id.linear44);
		textview23 = _view.findViewById(R.id.textview23);
		switch2 = _view.findViewById(R.id.switch2);
		textview4 = _view.findViewById(R.id.textview4);
		textview7 = _view.findViewById(R.id.textview7);
		textview48 = _view.findViewById(R.id.textview48);
		slider1 = _view.findViewById(R.id.slider1);
		linear23 = _view.findViewById(R.id.linear23);
		linear19 = _view.findViewById(R.id.linear19);
		textview15 = _view.findViewById(R.id.textview15);
		linear20 = _view.findViewById(R.id.linear20);
		linear21 = _view.findViewById(R.id.linear21);
		linear22 = _view.findViewById(R.id.linear22);
		textview16 = _view.findViewById(R.id.textview16);
		textview21 = _view.findViewById(R.id.textview21);
		textview17 = _view.findViewById(R.id.textview17);
		textview20 = _view.findViewById(R.id.textview20);
		textview18 = _view.findViewById(R.id.textview18);
		textview22 = _view.findViewById(R.id.textview22);
		linear37 = _view.findViewById(R.id.linear37);
		linear38 = _view.findViewById(R.id.linear38);
		textview38 = _view.findViewById(R.id.textview38);
		linear39 = _view.findViewById(R.id.linear39);
		linear40 = _view.findViewById(R.id.linear40);
		linear41 = _view.findViewById(R.id.linear41);
		textview39 = _view.findViewById(R.id.textview39);
		textview40 = _view.findViewById(R.id.textview40);
		textview41 = _view.findViewById(R.id.textview41);
		textview42 = _view.findViewById(R.id.textview42);
		textview43 = _view.findViewById(R.id.textview43);
		textview44 = _view.findViewById(R.id.textview44);
		switch4 = _view.findViewById(R.id.switch4);
		textview11 = _view.findViewById(R.id.textview11);
		switch3 = _view.findViewById(R.id.switch3);
		textview8 = _view.findViewById(R.id.textview8);
		textview46 = _view.findViewById(R.id.textview46);
		linear43 = _view.findViewById(R.id.linear43);
		radiobutton1 = _view.findViewById(R.id.radiobutton1);
		radiobutton2 = _view.findViewById(R.id.radiobutton2);
		radiobutton3 = _view.findViewById(R.id.radiobutton3);
		switch5 = _view.findViewById(R.id.switch5);
		textview6 = _view.findViewById(R.id.textview6);
		switch6 = _view.findViewById(R.id.switch6);
		textview47 = _view.findViewById(R.id.textview47);
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
								((Ac1Activity) getActivity())._updateCallback();
								dismiss();
							}
						});
					}
				};
				_timer.schedule(tmr, (int)(300));
			}
		});
		
		linear42.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (sp.getString("FortStats", "").equals("")) {
					if (sp.getString("premium", "").equals("true")) {
						final EditText edit0 = new EditText(getContext());
						edit0.setSingleLine(true);
						edit0.setHint("Pin");
						edit0.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
						AlertDialog dialoga = new MaterialAlertDialogBuilder(getContext())
						.setView(edit0)
						    .setTitle("🔑 Pin setzten")
						    .setMessage("Die App wird gesperrt!\nSoltest du also deine Pin vergessen, verlierst du auch deine Daten!")
						    .setPositiveButton("Speichern", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int i) {
								sp.edit().putString("FortStats", edit0.getText().toString()).commit();
								button1.setText("Sperre entfernen");
								button1.setBackgroundColor(0xFFEF5350);
								com.google.android.material.snackbar.Snackbar.make(linear1, "🔑 Pin gesetzt!", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
									@Override
									public void onClick(View _view) {
										 
									}
								}).show();
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
												dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
								
								if (edit0.getText().toString().contains("/") || (edit0.getText().toString().contains("-") || edit0.getText().toString().contains("."))) {
									((EditText)edit0).setError("Ungültige Symbole");
									dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false);
									
								}
								if (edit0.getText().toString().length() == 4) {
									dialoga.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(true);
									
									SketchwareUtil.hideKeyboard(getContext().getApplicationContext());
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
					else {
						com.google.android.material.snackbar.Snackbar.make(linear1, "🪅 Du brauchst Premium um dieses Feature zu nutzen", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("Holen", new View.OnClickListener(){
							@Override
							public void onClick(View _view) {
								intent.putExtra("tmp1", "s2");
								SysDialogFragmentActivity dialog = new SysDialogFragmentActivity();
								dialog.show(getActivity().getSupportFragmentManager(),"1");
							}
						}).show();
					}
				}
				else {
					new MaterialAlertDialogBuilder(getContext())
					    .setTitle("🔓 Sperre entfernen")
					    .setMessage("Die Pin Sperre wird entfernt und du kannst alles wie gewohnt weiter benutzen.")
					    .setPositiveButton("Zurücksetzen", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialogInterface, int i) {
							sp.edit().putString("FortStats", "").commit();
							button1.setText("Pin-Sperre setzen");
							button1.setBackgroundColor(0xFF8FB3FF);
							com.google.android.material.snackbar.Snackbar.make(linear1, "🔓 Pin Sperre entfernt", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
								@Override
								public void onClick(View _view) {
									 
								}
							}).show();
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
		});
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				try{
					if (!(_position == Double.parseDouble(sp.getString("state", "")))) {
						com.google.android.material.snackbar.Snackbar.make(linear1, "✅️ Bundesland aktualisiert!", com.google.android.material.snackbar.Snackbar.LENGTH_SHORT).setAction("", new View.OnClickListener(){
							@Override
							public void onClick(View _view) {
								 
							}
						}).show();
					}
					sp.edit().putString("state", String.valueOf((long)(_position))).commit();
				}catch(Exception e){
					 
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					sp.edit().putString("weekin", "true").commit();
				}
				else {
					sp.edit().putString("weekin", "false").commit();
				}
			}
		});
		
		linear20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_GradeGravity(0, 0);
			}
		});
		
		linear21.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_GradeGravity(1, 0);
			}
		});
		
		linear22.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_GradeGravity(2, 0);
			}
		});
		
		linear39.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_GradeGravity(0, 1);
			}
		});
		
		linear40.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_GradeGravity(1, 1);
			}
		});
		
		linear41.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_GradeGravity(2, 1);
			}
		});
		
		switch4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					sp.edit().putString("Pointmode", "true").commit();
				}
				else {
					sp.edit().putString("Pointmode", "false").commit();
				}
			}
		});
		
		switch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					sp.edit().putString("timestamps", "true").commit();
				}
				else {
					sp.edit().putString("timestamps", "false").commit();
				}
			}
		});
		
		radiobutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				new MaterialAlertDialogBuilder(getContext())
				    .setMessage("Bitte neustarten um die Einstellungen anzuwenden")
				    .setPositiveButton("Verstanden", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						 
						    }
					 })
				                       
				    .show();
			}
		});
		
		radiobutton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					sp.edit().putString("theme", "").commit();
					radiobutton2.setChecked(false);
					radiobutton3.setChecked(false);
				}
			}
		});
		
		radiobutton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					sp.edit().putString("theme", "light").commit();
					radiobutton1.setChecked(false);
					radiobutton3.setChecked(false);
					if (_darkModeEnabled()) {
						if (false) {
							            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
							        } else {
							            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
							        }
					}
				}
			}
		});
		
		radiobutton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					radiobutton1.setChecked(false);
					radiobutton2.setChecked(false);
					sp.edit().putString("theme", "dark").commit();
					if (!_darkModeEnabled()) {
						if (true) {
							            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
							        } else {
							            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
							        }
					}
				}
			}
		});
		
		switch5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					sp.edit().putString("showHollidays", "true").commit();
					spinner1.setVisibility(View.VISIBLE);
				}
				else {
					sp.edit().putString("showHollidays", "false").commit();
					spinner1.setVisibility(View.GONE);
				}
			}
		});
		
		switch6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					sp.edit().putString("experimental", "true").commit();
					switch5.setEnabled(true);
				}
				else {
					sp.edit().putString("experimental", "false").commit();
					switch5.setChecked(false);
					switch5.setEnabled(false);
				}
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
		vscroll1.getLayoutParams().width = SketchwareUtil.getDisplayWidthPixels(getContext().getApplicationContext());
		
		vscroll1.getLayoutParams().height = SketchwareUtil.getDisplayHeightPixels(getContext().getApplicationContext());
		states.add("Baden-Württemberg");
		states.add("Bayern");
		states.add("Berlin");
		states.add("Brandenburg");
		states.add("Bremen");
		states.add("Hamburg");
		states.add("Hessen");
		states.add("Niedersachsen");
		states.add("Mecklenburg-Vorpommern");
		states.add("Nordrhein-Westfalen");
		states.add("Rheinland-Pfalz");
		states.add("Saarland");
		states.add("Sachsen");
		states.add("Sachsen-Anhalt");
		states.add("Schleswig-Holstein");
		states.add("Thüringen");
		ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<>(getContext(),  R.layout.custom_spinner, states);
		spinner1.setAdapter(arrayAdapter1);
		if (sp.getString("weekin", "").equals("true")) {
			switch2.setChecked(true);
		}
		if (sp.getString("timestamps", "").equals("false")) {
			switch3.setChecked(false);
		}
		if (sp.getString("Pointmode", "").equals("true")) {
			switch4.setChecked(true);
		}
		if (sp.getString("experimental", "").equals("true")) {
			switch6.setChecked(true);
			switch5.setEnabled(true);
		}
		if (!sp.getString("FortStats", "").equals("")) {
			button1.setText("Sperre entfernen");
			button1.setBackgroundColor(0xFFEF5350);
		}
		if (true) {
			switch5.setChecked(false);
			spinner1.setVisibility(View.GONE);
		}
		if (sp.contains("state")) {
			spinner1.setSelection((int)(Double.parseDouble(sp.getString("state", ""))));
		}
		textview21.setText(String.valueOf((long)(Double.parseDouble(sp.getString("t0", "")) * 100)).concat(" %"));
		textview20.setText(String.valueOf((long)(Double.parseDouble(sp.getString("t1", "")) * 100)).concat(" %"));
		textview22.setText(String.valueOf((long)(Double.parseDouble(sp.getString("t2", "")) * 100)).concat(" %"));
		textview40.setText(String.valueOf((long)(Double.parseDouble(sp.getString("t3", "")) * 100)).concat(" %"));
		textview42.setText(String.valueOf((long)(Double.parseDouble(sp.getString("t4", "")) * 100)).concat(" %"));
		textview44.setText(String.valueOf((long)(Double.parseDouble(sp.getString("t5", "")) * 100)).concat(" %"));
		if (sp.getString("theme", "").equals("")) {
			radiobutton1.setChecked(true);
		}
		if (sp.getString("theme", "").equals("light")) {
			radiobutton2.setChecked(true);
		}
		if (sp.getString("theme", "").equals("dark")) {
			radiobutton3.setChecked(true);
		}
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
		
		slider1.setValues((float)Double.parseDouble(sp.getString("Gstart", "")),(float) Double.parseDouble(sp.getString("Gend", "")));
		slider1.addOnChangeListener(new RangeSlider.OnChangeListener() {
			    @Override
			    public void onValueChange(RangeSlider rangeSlider, float value, boolean fromUser) {
				        sp.edit().putString("Gstart", String.valueOf((slider1.getValues().get(0)))).commit();
				sp.edit().putString("Gend", String.valueOf((slider1.getValues().get(1)))).commit();
				    }
		});
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
						for(int _repeat57 = 0; _repeat57 < (int)(checklist.size()); _repeat57++) {
							if (!checklist.get((int)count1).containsKey("dt")) {
								return (false);
							}
							if (!checklist.get((int)count1).containsKey("pt")) {
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
	
	
	public void _GradeGravity(final double _type, final double _relev) {
		final Slider range0 = new Slider(getContext());
		switch((int)_type) {
			case ((int)0): {
				if (_relev == 0) {
					range0.setValue((float) Double.parseDouble(sp.getString("t0", "")));
				}
				else {
					range0.setValue((float) Double.parseDouble(sp.getString("t3", "")));
				}
				new MaterialAlertDialogBuilder(getContext())
				.setView(range0)
				    .setTitle("⚖️ Gewichtung festlegen")
				    .setMessage("Lege die Gewichtung für den Typ ".concat("Tests/SL".concat(" fest")))
				    .setPositiveButton("Speichern", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						if (_relev == 0) {
							sp.edit().putString("t0", String.valueOf(range0.getValue())).commit();
							textview21.setText(String.valueOf((long)(Double.parseDouble(sp.getString("t0", "")) * 100)).concat(" %"));
						}
						else {
							sp.edit().putString("t3", String.valueOf(range0.getValue())).commit();
							textview40.setText(String.valueOf((long)(Double.parseDouble(sp.getString("t3", "")) * 100)).concat(" %"));
						}
						    }
					 })
				                       
				     .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						 
						    }
					 })
				                       
				    .show();
				break;
			}
			case ((int)1): {
				if (_relev == 0) {
					range0.setValue((float) Double.parseDouble(sp.getString("t1", "")));
				}
				else {
					range0.setValue((float) Double.parseDouble(sp.getString("t4", "")));
				}
				new MaterialAlertDialogBuilder(getContext())
				.setView(range0)
				    .setTitle("⚖️ Gewichtung festlegen")
				    .setMessage("Lege die Gewichtung für den Typ ".concat("Klassenarbeiten".concat(" fest")))
				    .setPositiveButton("Speichern", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						if (_relev == 0) {
							sp.edit().putString("t1", String.valueOf(range0.getValue())).commit();
							textview20.setText(String.valueOf((long)(Double.parseDouble(sp.getString("t1", "")) * 100)).concat(" %"));
						}
						else {
							sp.edit().putString("t4", String.valueOf(range0.getValue())).commit();
							textview42.setText(String.valueOf((long)(Double.parseDouble(sp.getString("t4", "")) * 100)).concat(" %"));
						}
						    }
					 })
				                       
				     .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						 
						    }
					 })
				                       
				    .show();
				break;
			}
			case ((int)2): {
				if (_relev == 0) {
					range0.setValue((float) Double.parseDouble(sp.getString("t2", "")));
				}
				else {
					range0.setValue((float) Double.parseDouble(sp.getString("t5", "")));
				}
				new MaterialAlertDialogBuilder(getContext())
				.setView(range0)
				    .setTitle("⚖️ Gewichtung festlegen")
				    .setMessage("Lege die Gewichtung für den Typ ".concat("Mündlich".concat(" fest")))
				    .setPositiveButton("Speichern", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						if (_relev == 0) {
							sp.edit().putString("t2", String.valueOf(range0.getValue())).commit();
							textview22.setText(String.valueOf((long)(Double.parseDouble(sp.getString("t2", "")) * 100)).concat(" %"));
						}
						else {
							sp.edit().putString("t5", String.valueOf(range0.getValue())).commit();
							textview44.setText(String.valueOf((long)(Double.parseDouble(sp.getString("t5", "")) * 100)).concat(" %"));
						}
						    }
					 })
				                       
				     .setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						 
						    }
					 })
				                       
				    .show();
				break;
			}
		}
	}
	
	
	public boolean _darkModeEnabled() {
		int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
		
		return currentNightMode == Configuration.UI_MODE_NIGHT_YES;
		
	}
	
}