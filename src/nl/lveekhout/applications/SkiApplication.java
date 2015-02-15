package nl.lveekhout.applications;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;

public class SkiApplication extends Application {
	
	private static ContextWrapper contextWrapper = null;
	private static Bitmap bitmap;

    @Override
	public void onCreate() {
		super.onCreate();
		contextWrapper = (ContextWrapper) this;
	}

	public static Context context() {
    	return contextWrapper.getApplicationContext();
    }

	public static Bitmap getBitmap() {
		return bitmap;
	}
	
	public static void setBitmap(Bitmap bitmap) {
		SkiApplication.bitmap = bitmap;
	}
}
