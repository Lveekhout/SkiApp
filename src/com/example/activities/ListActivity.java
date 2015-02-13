package com.example.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

import com.example.activities.R;
import com.example.data.GlobalAppData;

public class ListActivity extends FragmentActivity {

	/** Called when the activity is first created. */
	@Override
    @SuppressLint("SimpleDateFormat")
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    try {
			setContentView(R.layout.activity_list);
						
			List<String> lijst = new ArrayList<String>();			
	        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			for (int i = 0; i < GlobalAppData.listCoordsList.size(); ++i) lijst.add(dateFormat.format(GlobalAppData.listCoordsList.get(i).date));
			
			ListView listView = (ListView)findViewById(R.id.listView1);
			ListAdapter listAdapter = new ArrayAdapter<String>(listView.getContext(), android.R.layout.simple_list_item_1, lijst);
			listView.setAdapter(listAdapter);
		} catch (Exception e) {
	    	Toast.makeText(this, e.getClass().toString(), Toast.LENGTH_LONG).show();
		}
	}

}
