package pl.mario.ninjagoapk;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import pl.mario.ninjagoapk.R.id;

public class MainActivity extends Activity {

	Button sprawdz;
	static Dane dane;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		File f = Environment.getExternalStorageDirectory();
		File folder = new File(Environment.getExternalStorageDirectory() + File.separator + "NinjagoApk");
		if (!folder.exists()) {
			folder.mkdir();
		}
		
		dane = new Dane();
		Button sprawdz = (Button) findViewById(R.id.sprawdz);
		sprawdz.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				dane.adres = "igi2.xaa.pl/mdos";
				startMyService();
			}
		});
		
		Button stop = (Button) findViewById(R.id.zamknij);
		stop.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				stopMyService();
				
			}
		});

	}
	

	public void toast(String txt){
		Toast.makeText(this.getApplicationContext(), txt, Toast.LENGTH_LONG).show();
	}
	
	private void startMyService() {
		Intent serviceIntent = new Intent(this, NinService.class);
		startService(serviceIntent);
	}

	private void stopMyService() {
		Intent serviceIntent = new Intent(this, NinService.class);
		stopService(serviceIntent);
	}

}
