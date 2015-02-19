package nl.lveekhout.views;

import nl.lveekhout.applications.SkiApplication;
import nl.lveekhout.data.SkigebiedImageViewData;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.ScaleGestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;

public class SkigebiedImageView extends ImageView implements GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener {
	
	private GestureDetector detector;
	private ScaleGestureDetector scaleGestureDetector;
	
	public SkigebiedImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		detector = new GestureDetector(context, this);
		scaleGestureDetector = new ScaleGestureDetector(context, this);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		return detector.onTouchEvent(event) | scaleGestureDetector.onTouchEvent(event);
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);

		Bitmap bitmap = SkiApplication.getBitmap();
    	try {
			canvas.drawBitmap(bitmap, new Rect(SkigebiedImageViewData.offsetX, SkigebiedImageViewData.offsetY, SkigebiedImageViewData.offsetX+SkigebiedImageViewData.lengthX, SkigebiedImageViewData.offsetY+SkigebiedImageViewData.lengthY), new Rect(0, 0, SkigebiedImageViewData.lengthX, SkigebiedImageViewData.lengthY), null);
			canvas.drawRect(new Rect(0, 0, SkigebiedImageViewData.lengthX, 250), paint);
			paint.setColor(Color.WHITE);
			paint.setTextSize(32);
			canvas.drawText(SkigebiedImageViewData.motionEventString, 10, 30, paint);
			canvas.drawText(String.valueOf(SkigebiedImageViewData.offsetX) + ", " + String.valueOf(SkigebiedImageViewData.offsetY), 10, 60, paint);
//			canvas.drawText(String.valueOf(SkigebiedImageViewData.motionEvent.getHistorySize()) + ", " + String.valueOf(SkigebiedImageViewData.motionEvent.getPointerCount()), 10, 90, paint);
		} catch (Exception e) {
			canvas.drawText(e.getClass().toString(), 10, 100, paint);
		}
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
		
		if (changed) {
			SkigebiedImageViewData.lengthX = right-left;
			SkigebiedImageViewData.lengthY = bottom-top;
		}
	}

	@Override
	public boolean onDown(MotionEvent event) {
//		SkigebiedImageViewData.motionEvent = event;
		SkigebiedImageViewData.motionEventString = "onDown";
		SkigebiedImageViewData.offsetX = (int) event.getX();
		SkigebiedImageViewData.offsetY = (int) event.getY();
		invalidate();
		return true;
	}

	@Override
	public boolean onFling(MotionEvent arg0, MotionEvent event, float arg2, float arg3) {
//		SkigebiedImageViewData.motionEvent = event;
		SkigebiedImageViewData.motionEventString = "onFling";
		SkigebiedImageViewData.offsetX = (int) event.getX();
		SkigebiedImageViewData.offsetY = (int) event.getY();
		invalidate();
		return true;
	}

	@Override
	public void onLongPress(MotionEvent event) {
//		SkigebiedImageViewData.motionEvent = event;
		SkigebiedImageViewData.motionEventString = "onLongPress";
		SkigebiedImageViewData.offsetX = (int) event.getX();
		SkigebiedImageViewData.offsetY = (int) event.getY();
		invalidate();
    }

	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent event, float arg2, float arg3) {
//		SkigebiedImageViewData.motionEvent = event;
		SkigebiedImageViewData.motionEventString = "onScroll";
		SkigebiedImageViewData.offsetX = (int) event.getX();
		SkigebiedImageViewData.offsetY = (int) event.getY();
		invalidate();
		return true;
	}

	@Override
	public void onShowPress(MotionEvent event) {
//		SkigebiedImageViewData.motionEvent = event;
		SkigebiedImageViewData.motionEventString = "onShowPress";
		SkigebiedImageViewData.offsetX = (int) event.getX();
		SkigebiedImageViewData.offsetY = (int) event.getY();
		invalidate();
	}

	@Override
	public boolean onSingleTapUp(MotionEvent event) {
//		SkigebiedImageViewData.motionEvent = event;
		SkigebiedImageViewData.motionEventString = "onSingleTapUp";
		SkigebiedImageViewData.offsetX = (int) event.getX();
		SkigebiedImageViewData.offsetY = (int) event.getY();
		invalidate();
		return true;
	}

	@Override
	public boolean onScale(ScaleGestureDetector scale) {
		SkigebiedImageViewData.motionEventString = "onScale";
		SkigebiedImageViewData.offsetX = (int) scale.getScaleFactor();
		SkigebiedImageViewData.offsetY = (int) scale.getFocusY();
		invalidate();
		return true;
	}

	@Override
	public boolean onScaleBegin(ScaleGestureDetector scale) {
		SkigebiedImageViewData.motionEventString = "onScaleBegin";
		SkigebiedImageViewData.offsetX = (int) scale.getScaleFactor();
		SkigebiedImageViewData.offsetY = (int) scale.getFocusY();
		invalidate();
		return true;
	}

	@Override
	public void onScaleEnd(ScaleGestureDetector scale) {
		SkigebiedImageViewData.motionEventString = "onScaleEnd";
		SkigebiedImageViewData.offsetX = (int) scale.getScaleFactor();
		SkigebiedImageViewData.offsetY = (int) scale.getFocusY();
		invalidate();
	}
}