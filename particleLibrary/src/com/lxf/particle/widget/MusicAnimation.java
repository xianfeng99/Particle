package com.lxf.particle.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.lxf.particle.effect.base.EffectScence;
import com.lxf.particle.effect.scene.MusicJumpScence;
import com.lxf.particle.effect.scene.RainScence;

public class MusicAnimation extends EffectAnimation {

	public MusicAnimation(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public MusicAnimation(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public MusicAnimation(Context context) {
		super(context);
	}

	@Override
	protected EffectScence initScence(int itemNum) {
		int width = getWidth();
		int height = getHeight();
		
		return new MusicJumpScence(width, height, itemNum);
	}

}
