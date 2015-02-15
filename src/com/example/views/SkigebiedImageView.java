package com.example.views;

import com.example.application.SkiApplication;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

public class SkigebiedImageView extends ImageView {
	public SkigebiedImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setImageBitmap(SkiApplication.getBitmap());
	}
}