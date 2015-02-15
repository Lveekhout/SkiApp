package nl.lveekhout.applications;

import nl.lveekhout.fragmentactivities.R;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class SkiApplication extends Application {
	
	private static ContextWrapper contextWrapper = null;
	private static Bitmap bitmap;

    @Override
	public void onCreate() {
		super.onCreate();
		contextWrapper = (ContextWrapper) this;
	    bitmap = BitmapFactory.decodeResource(SkiApplication.context().getResources(), R.drawable.ski_kaart_groot);
	}

	public static Context context() {
    	return contextWrapper.getApplicationContext();
    }

	public static Bitmap getBitmap() {
		return bitmap;
	}
}
