package nl.lveekhout.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class GpsCompasView extends View {

	private Paint paint;
	private RectF rectF;
	private Float bearing;

	public GpsCompasView(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint = new Paint();
		rectF = new RectF();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		paint.setColor(Color.RED);
		rectF.set(0, 0, canvas.getWidth(), canvas.getHeight());
		canvas.drawOval(rectF , paint);

		paint.setColor(Color.WHITE);
		rectF.set(10, 10, canvas.getWidth()-10, canvas.getHeight()-10);
		canvas.drawOval(rectF , paint);

		paint.setColor(Color.RED);
		rectF.set(canvas.getWidth()/2-5, 0, canvas.getWidth()/2+5, 20);
		canvas.drawRect(rectF, paint);
		rectF.set(canvas.getWidth()/2-5, canvas.getHeight()-20, canvas.getWidth()/2+5, canvas.getHeight());
		canvas.drawRect(rectF, paint);
		rectF.set(0, canvas.getHeight()/2-5, 20, canvas.getHeight()/2+5);
		canvas.drawRect(rectF, paint);
		rectF.set(canvas.getWidth()-20, canvas.getHeight()/2-5, canvas.getWidth(), canvas.getHeight()/2+5);
		canvas.drawRect(rectF, paint);
		
//		bearing = (float) (Math.PI/4+Math.PI);
		paint.setColor(Color.BLACK);
		paint.setStrokeWidth(10);
		if (bearing!=null) {
			canvas.drawLine(canvas.getWidth()/2, canvas.getHeight()/2, canvas.getWidth()/2+(float)Math.sin(bearing)*(canvas.getWidth()/2-21), canvas.getHeight()/2-(float)Math.cos(bearing)*(canvas.getHeight()/2-21), paint);
		}
	}

	public void setBearing(Float bearing) {
		this.bearing = bearing;
		invalidate();
	}
}
