package com.example.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

public class SkigebiedActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		try {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_skigebied);

		} catch (Exception e) {
			Toast.makeText(this, e.getClass() + ": " + e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
}
