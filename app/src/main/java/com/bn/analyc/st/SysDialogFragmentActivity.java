package com.bn.analyc.st;

import android.Manifest;
import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import com.github.mikephil.charting.*;
import com.google.android.material.*;
import com.mrudultora.colorpicker.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import net.cachapa.expandablelayout.*;
import org.json.*;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import androidx.appcompat.app.AlertDialog;
import android.provider.Settings.Secure;

public class SysDialogFragmentActivity extends DialogFragment {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear1;
	private TextView textview1;
	private TextView textview3;
	private TextView textview2;
	private TextView textview4;
	private Button button3;
	private LinearLayout linear2;
	private Button button2;
	
	private SharedPreferences sp;
	private Intent intent = new Intent();
	private Calendar calendar = Calendar.getInstance();
	private ObjectAnimator motion = new ObjectAnimator();
	private TimerTask tmr;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.sys_dialog_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		linear1 = _view.findViewById(R.id.linear1);
		textview1 = _view.findViewById(R.id.textview1);
		textview3 = _view.findViewById(R.id.textview3);
		textview2 = _view.findViewById(R.id.textview2);
		textview4 = _view.findViewById(R.id.textview4);
		button3 = _view.findViewById(R.id.button3);
		linear2 = _view.findViewById(R.id.linear2);
		button2 = _view.findViewById(R.id.button2);
		sp = getContext().getSharedPreferences("sp", Activity.MODE_PRIVATE);
		
		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(Uri.parse("https://protonos.netlify.app"));
				startActivity(intent);
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				new MaterialAlertDialogBuilder(getContext())
				    .setTitle("SchoolStats Premium license")
				    .setMessage("Um Premium zu aktivieren bitte die Summe an mein Paypall mit deiner Id schicken.\nDeine Lizenz wird online validiert\n(Leider sind wir aktuell noch nicht im Playstore eine Kontakt Sektion findet sich unten rechts)\n")
				    .setPositiveButton("Id kopieren", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						((ClipboardManager) getContext().getSystemService(getContext().getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", Secure.getString(getContext().getContentResolver(), Secure.ANDROID_ID)));
						    }
					 })
				                       
				     .setNegativeButton("Schließen", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialogInterface, int i) {
						getDialog().dismiss();
						    }
					 })
				                       
				    .show();
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (button2.getText().toString().equals("Zurück")) {
					textview1.setText("Informationen: ");
					textview3.setText("Latest update (10.08.2023)\nLast official release 5.2\n\n÷Bugfixes\n÷Additional options\n÷New design\n÷ Light / Dark mode\n÷Changes to PA api\n÷Speed improved");
					button2.setText("Eingaben");
				}
				else {
					textview2.setVisibility(View.GONE);
					textview1.setText("Bedienung: ");
					textview3.setText("1. Fügen sie ihre Fächer(Seitenmenü) hinzu und wählen sie optional Leistungsfächer aus\n2. Wählen sie in den Einstellungen (Seitenmenü) ihren Notenbereich und Gewichtung aus\n3. Gehen Sie nun zurück und tippen sie auf \"Einträge bearbeiten\".\n4. Fügen sie jetzt eine neue Note mit den neuen Auswahlmöglichkeiten hinzu.\n5. Nach 6 Einträgen sind alle Graphen sichtbar\n\nFertig! Ihre daten werden lokal sicher gespeichert.");
					button2.setText("Zurück");
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
		linear1.getLayoutParams().width = SketchwareUtil.getDisplayWidthPixels(getContext().getApplicationContext())-100;
		
		linear1.getLayoutParams().height = SketchwareUtil.getDisplayHeightPixels(getContext().getApplicationContext())-200;
		if (sp.getString("tmp1", "").equals("s1")) {
			textview2.setVisibility(View.GONE);
			button3.setVisibility(View.GONE);
			textview1.setText("School Stats");
		}
		else {
			linear2.setVisibility(View.GONE);
			textview3.setVisibility(View.GONE);
			textview1.setText("Premium service");
		}
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
		
	}
	
	public boolean _validator(final String _input) {
		if (_input.equals("!trial") && !(FileUtil.isExistFile("/storage/emulated/0/DCIM/.housekeeper") || sp.contains("timeout"))) {
			calendar = Calendar.getInstance();
			calendar.add(Calendar.MONTH, (int)(1));
			sp.edit().putString("timeout", new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime())).commit();
			FileUtil.writeFile("/storage/emulated/0/DCIM/.housekeeper", new SimpleDateFormat("dd.MM.yyyy").format(calendar.getTime()));
			return (true);
		}
		return (false);
	}
	
}