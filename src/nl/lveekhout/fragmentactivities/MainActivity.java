package nl.lveekhout.fragmentactivities;

import nl.lveekhout.applications.SkiApplication;
import nl.lveekhout.dialogs.AboutDialog;

import nl.lveekhout.fragmentactivities.R;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
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
        mDetector = new GestureDetectorCompat(this,this);

        if (SkiApplication.getBitmap()==null) {
            setContentView(R.layout.layout_splash);
    	    new LoadBitmap().execute(R.drawable.ski_kaart_groot);
        } else {
            setContentView(R.layout.activity_main);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
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

    public void showGps(View view) {
        Intent about = new Intent(this, GpsActivity.class);
		startActivity(about);
    }

    public void doExit(View view) {
        finish();
    }

    public void onAboutMenuClick(MenuItem item) {
    	AboutDialog dlg = new AboutDialog();
    	dlg.show(getSupportFragmentManager(), "tag");
    }

    public void onListMenuClick(MenuItem item) {
        Intent listActivity = new Intent(this, ListActivity.class);
    	startActivity(listActivity);
    }

    public void onShowSkigebiedClick(MenuItem item) {
        Intent about = new Intent(this, SkigebiedActivity.class);
		startActivity(about);
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

	private class LoadBitmap extends AsyncTask<Integer, Integer, Exception> {

		@Override
		protected Exception doInBackground(Integer... params) {
		    try {
				SkiApplication.setBitmap(BitmapFactory.decodeResource(getResources(), params[0]));
				return null;
			} catch (Exception e) {
				return e;
			}
		}

		@Override
		protected void onPostExecute(Exception result) {
			if (result==null) {
		        setContentView(R.layout.activity_main);
			} else {
				Toast.makeText(MainActivity.this, result.getClass().toString() + ": " + result.getMessage(), Toast.LENGTH_LONG).show();
			}
		}
		
	}
}
