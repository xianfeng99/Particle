package com.lxf.particle.widget;

import android.content.Context;
import android.util.AttributeSet;

import com.lxf.particle.effect.base.EffectScence;
import com.lxf.particle.effect.scene.SknowScence;

/**
 * 基本雪花效果
 * @author xianfeng
 * 2015年4月23日	上午11:37:58
 */
public class SknowAnimation extends EffectAnimation {

	public SknowAnimation(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public SknowAnimation(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public SknowAnimation(Context context) {
		super(context);
	}

	@Override
	protected EffectScence initScence(int itemNum) {
		int width = getWidth();
		int height = getHeight();
		
		return new SknowScence(width, height, itemNum);
	}
}
