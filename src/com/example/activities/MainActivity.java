package com.example.activities;

import com.example.activities.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Toast;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GestureDetectorCompat;

public class MainActivity extends FragmentActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

	private GestureDetectorCompat mDetector;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDetector = new GestureDetectorCompat(this,this);
        mDetector.setOnDoubleTapListener(this);
    	Toast.makeText(this, "Applicatie gestart", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	//Toast.makeText(this, "onTouchEvent", Toast.LENGTH_SHORT).show();
    	mDetector.onTouchEvent(event);
    	return super.onTouchEvent(event);
    }

    @Override
    protected void onDestroy() {
    	super.onDestroy();
    	Toast.makeText(this, "Applicatie gestopt", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onAboutMenuClick(MenuItem item) {
    	TestDialog dlg = new TestDialog();
    	dlg.show(getSupportFragmentManager(), "tag");
    }

    public void onListMenuClick(MenuItem item) {
        Intent listActivity = new Intent(this, ListActivity.class);
    	startActivity(listActivity);
    }

    public void showGps(View view) {
        Intent about = new Intent(this, GpsActivity.class);
		view.getContext().startActivity(about);
    	Toast.makeText(this, "showAbout gestart", Toast.LENGTH_LONG).show();
    }

    public void doExit(View view) {
        finish();
    }

    @Override
	public boolean onDown(MotionEvent e) {
		return false;
	}

	@Override
	public boolean onDoubleTap(MotionEvent arg0) {
 		return false;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent arg0) {
    	Toast.makeText(this, "onDoubleTapEvent", Toast.LENGTH_LONG).show();
		return false;
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent arg0) {
		return false;
	}

	@Override
	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
    	Toast.makeText(this, "onFling", Toast.LENGTH_LONG).show();
		return false;
	}

	@Override
	public void onLongPress(MotionEvent arg0) {
    	Toast.makeText(this, "onLongPress", Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
    	Toast.makeText(this, "onScroll", Toast.LENGTH_LONG).show();
		return false;
	}

	@Override
	public void onShowPress(MotionEvent arg0) {
    	Toast.makeText(this, "onShowPress", Toast.LENGTH_LONG).show();		
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		return false;
	}
}
