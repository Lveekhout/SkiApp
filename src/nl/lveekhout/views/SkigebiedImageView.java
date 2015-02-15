package nl.lveekhout.views;

import nl.lveekhout.applications.SkiApplication;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class SkigebiedImageView extends ImageView {
	private int offsetX = 0;
	private int offsetY = 0;
	private int lengthX;
	private int lengthY;

	public SkigebiedImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		if (changed) {
			lengthX = right-left;
			lengthY = bottom-top;
//			setImageBitmap(Bitmap.createBitmap(SkiApplication.getBitmap(), offsetX, offsetY, lengthX, lengthY));
		}
		super.onLayout(changed, left, top, right, bottom);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
//		return super.onTouchEvent(event);
		switch(event.getAction()) {
        case MotionEvent.ACTION_DOWN: {
		    setImageBitmap(Bitmap.createBitmap(SkiApplication.getBitmap(), offsetX, offsetY, lengthX, lengthY));
		    return true;
	    }
        case MotionEvent.ACTION_MOVE: {
        	offsetX = (int) event.getX();
        	offsetY = (int) event.getY();
		    setImageBitmap(Bitmap.createBitmap(SkiApplication.getBitmap(), offsetX, offsetY, lengthX, lengthY));
		    return true;
	    }
		}
		return false;
	}
}