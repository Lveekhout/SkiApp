package com.example.activities;

//import lveekhout.StrMods;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import com.example.data.GlobalAppData;
import com.example.data.ListCoords;
import com.example.dialogs.ShowCoordDialog;
import com.example.activities.R;
import com.example.application.MyApplication;

public class GpsActivity extends FragmentActivity {

    TextView textLat;
    TextView textLong;
    TextView textSpeed;
    TextView textMaxSpeed;
    
    LocationManager locationManager;
    LocationListener locationListener;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);
        
        textLat = (TextView) findViewById(R.id.textLat);
        textLong = (TextView) findViewById(R.id.textLong);
        textSpeed = (TextView) findViewById(R.id.textSpeed);
        textMaxSpeed = (TextView) findViewById(R.id.textMaxSpeed);
        displayData();
        
        @SuppressWarnings("unused")
		MyApplication application = (MyApplication)getApplication();
        
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationListener = new MyLocationListener();        

        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
        catch(Exception e) {
        	textLong.setText(e.getMessage());
        }
    }

    @Override
    protected void onDestroy() {
		locationManager.removeUpdates(locationListener);
    	super.onDestroy();
    }
    
    @SuppressLint("SimpleDateFormat")
	private void displayData() {
    	textLat.setText(GlobalAppData.latitude);
    	textLong.setText(GlobalAppData.longitude);
    	textSpeed.setText(GlobalAppData.speed);

        if (GlobalAppData.maxSpeedDate==null) textMaxSpeed.setText(String.format("%.2f km/u", GlobalAppData.maxSpeed));
		else {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			textMaxSpeed.setText(String.format("%.2f km/u om %s uur", GlobalAppData.maxSpeed, dateFormat.format(GlobalAppData.maxSpeedDate)));
		}
    }
	
    public void resetMaxSpeed(View view) {
    	GlobalAppData.latitude = "----";
    	GlobalAppData.longitude = "----";
    	GlobalAppData.speed = "----";
        GlobalAppData.maxSpeed = 0.0f;
        GlobalAppData.maxSpeedDate = null;
    	GlobalAppData.maxSpeedCoord = "----";
    	GlobalAppData.listCoordsList.clear();
        displayData();
    	
    	View button = findViewById(R.id.getMaxSpeed);
    	button.setEnabled(false);
    }

    public void showCoordMaxSpeed(View view) {
    	ShowCoordDialog dlg = new ShowCoordDialog();
    	dlg.show(getSupportFragmentManager(), "tag");
    }

    class MyLocationListener implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            if (location != null) {
                //textLat.setText(StrMods.convert(location.getLatitude()));
                //textLong.setText(StrMods.convert(location.getLongitude()));
            	
                float f = location.getSpeed()*3.6f;
            	GlobalAppData.latitude = Double.toString(location.getLatitude());
            	GlobalAppData.longitude = Double.toString(location.getLongitude());
            	GlobalAppData.speed = String.format("%.2f", f) + " km/u";
            	GlobalAppData.listCoordsList.add(new ListCoords(location.getLatitude(), location.getLongitude(), new Date()));
            	
                if (f>GlobalAppData.maxSpeed) {
                	GlobalAppData.maxSpeed = f;
                	GlobalAppData.maxSpeedDate = new Date();
                	GlobalAppData.maxSpeedCoord = Double.toString(location.getLatitude()) + "," + Double.toString(location.getLongitude());

                	View button = findViewById(R.id.getMaxSpeed);
                	button.setEnabled(true);
                }
                displayData();
            }
        }

        @Override
        public void onProviderDisabled(String arg0) {
        	textLong.setText("onProviderDisabled");
            }

        @Override
        public void onProviderEnabled(String arg0) {
        	textLong.setText("onProviderEnabled");
            }

        @Override
        public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
        	textLong.setText("onStatusChanged");
            }
       }
}
