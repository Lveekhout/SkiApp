package nl.lveekhout.fragmentactivities;

import java.util.Queue;

import nl.lveekhout.applications.SkiApplication;
import nl.lveekhout.fragmentactivities.R;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;
import android.widget.ImageView;

public class SkigebiedActivity extends FragmentActivity {

	private int offsetX = 0;
	private int offsetY = 0;
	private int lengthX;
	private int lengthY;
    private Queue<MotionEvent> queue;
    private MotionEventThread motionEventThread;
    private ImageView imageView;

    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_skigebied);
		imageView = (ImageView) findViewById(R.id.skigebiedimageview_id);
	}

//	@Override
//	protected void onResume() {
//		super.onResume();
//        queue = new LinkedList<MotionEvent>();
//        motionEventThread = new MotionEventThread();
//        motionEventThread.setPriority(Thread.MIN_PRIORITY);
//        motionEventThread.start();
//	}
//
//	@Override
//	protected void onPause() {
//		motionEventThread.interrupt();
//		super.onPause();
//	}
//
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		switch(event.getAction()) {
//        case MotionEvent.ACTION_DOWN: {
//        	queue.add(event);
//        	return super.onTouchEvent(event);
//	    }
//        case MotionEvent.ACTION_MOVE: {
//        	queue.add(event);
//		    return true;
//	    }
//		}
//		return false;
//	}
//
    private class MotionEventThread extends Thread {
    	MotionEvent event;

        @Override
        public void run() {
            try {
                while (true) {
                    while (queue.size()>0) {
                    	event = queue.remove();
                    	offsetX = (int) event.getX();
                    	offsetY = (int) event.getY();
                    	final Bitmap bitmap = SkiApplication.getBitmap();
                    	
                    	runOnUiThread(new Runnable() {
							
							@Override
							public void run() {
								lengthX = imageView.getWidth();
								lengthY = imageView.getHeight();
		                    	imageView.setImageBitmap(Bitmap.createBitmap(bitmap, offsetX, offsetY, lengthX, lengthY));
							}
						});                    	
                    }
                    sleep(1);
                }
            } catch (InterruptedException e) {
            	System.out.println(e.toString());
            } catch (Exception e) {
            	System.out.println(e.toString());
            }
        }
    }
}