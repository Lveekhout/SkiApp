package nl.lveekhout.views;

import nl.lveekhout.applications.SkiApplication;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SkigebiedImageView extends ImageView {
	public SkigebiedImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setImageBitmap(SkiApplication.getBitmap());
	}
}