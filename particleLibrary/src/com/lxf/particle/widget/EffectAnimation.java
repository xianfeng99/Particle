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
	private int itemColor = 0xffffffff;
	private boolean randColor = false;
	
	public EffectAnimation(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public EffectAnimation(Context context, AttributeSet attrs) {
		super(context, attrs);
		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.EffectAnimation);
		itemNum = a.getInt(R.styleable.EffectAnimation_itemNum, 0);
		itemColor = a.getColor(R.styleable.EffectAnimation_itemColor, 0xffffffff);
		randColor = a.getBoolean(R.styleable.EffectAnimation_randColor, false);
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

	/**
	 * need init scence
	 * @param itemNum
	 * @param itemColor
	 * @return
	 */
	protected abstract EffectScence initScence(int itemNum, int itemColor);
	
	/**
	 * need init scence
	 * @param itemNum
	 * @param itemColor
	 * @param randColor
	 * @return
	 */
	protected abstract EffectScence initScence(int itemNum, int itemColor, boolean randColor);
	
	private void init(){
		running = false;
		if(itemNum == 0){
			itemNum = 100;
		}
		scence = initScence(itemNum, itemColor, randColor);
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
			long curTime = 0;
			while (running) {
				curTime = System.currentTimeMillis();
				if(scence != null){
					scence.move();
				}
				mHandler.sendEmptyMessage(0);
				curTime = System.currentTimeMillis() - curTime;
				if(curTime < 30){
					try {
						Thread.sleep(30 - curTime);
					} catch (InterruptedException e) {
						break;
					}
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
