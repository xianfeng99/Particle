package com.lxf.particle.effect.scene;

import android.graphics.Canvas;

import com.lxf.particle.effect.base.EffectScence;
import com.lxf.particle.effect.item.Star;

public class StarSkyScence extends EffectScence{

	public StarSkyScence(int width, int height, int sknowNum){
		super(width, height, sknowNum);
	}

	protected void initScence() {
		for(int i = 0; i < itemNum; i ++){
			list.add(new Star(width, height));
		}		
	}
	
	public void draw(Canvas canvas){
		canvas.drawColor(0x80000000);
		super.draw(canvas);
	}
	
}
