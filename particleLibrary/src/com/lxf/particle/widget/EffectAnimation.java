package com.lxf.particle.widget;

import com.lxf.particle.R;
import com.lxf.particle.effect.base.EffectScence;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/**
 * 效果动画基类
 * @author xianfeng
 *
 */
public abstract class EffectAnimation extends View {

	protected final String TAG = "EffectAnimation";
	
	private Thread spriteThread;
	private boolean running = false;
	protected EffectScence scence;
	private int itemNum;
	
	public EffectAnimation(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public EffectAnimation(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EffectAnimation);
		itemNum = a.getInt(R.styleable.EffectAnimation_itemNum, 0);
		a.recycle();
	}

	public EffectAnimation(Context context) {
		super(context);
	}

	/**
	 * 需要初始话的效果场景
	 * @return
	 */
	protected abstract EffectScence initScence(int itemNum);

	private void init(){
		running = false;
		if(itemNum == 0){
			itemNum = 100;
		}
		scence = initScence(itemNum);
		spriteThread = new Thread(run);
		spriteThread.start();
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if(scence != null){
			scence.draw(canvas);
		}
		else{
			init();
		}
	}
	
	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		running = false;
	}
	
	private Runnable run = new Runnable(){
		public void run() {
			running = true;
			while (running) {
				if(scence != null){
					scence.move();
				}
				
				mHandler.sendEmptyMessage(0);
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					break;
				}
			}

		}
	};
	
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			invalidate();
		};
	};
	
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		super.onLayout(changed, left, top, right, bottom);
	};
}
