package com.example.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.activities.R;

public class NewActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    try {
			setContentView(R.layout.activity_newactivity);
			
			ListView listView = (ListView)findViewById(R.id.listView1);
			
			String[] values = new String[] { "Android", "iPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2", "Android", "iPhone", "WindowsMobile" };	
			List<String> lijst = new ArrayList<String>();
			for (int i = 0; i < values.length; ++i) lijst.add(values[i]);
			ListAdapter listAdapter = new ArrayAdapter<String>(listView.getContext(), android.R.layout.simple_list_item_1, lijst);
			listView.setAdapter(listAdapter);
		} catch (Exception e) {
			// TODO Auto-generated catch block
	    	Toast.makeText(this, e.getClass().toString(), Toast.LENGTH_LONG).show();
		}
	    
	
	    // TODO Auto-generated method stub
	}

}
