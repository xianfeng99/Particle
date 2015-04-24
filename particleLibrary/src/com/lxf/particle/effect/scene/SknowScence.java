package com.lxf.particle.effect.scene;

import com.lxf.particle.effect.base.EffectScence;
import com.lxf.particle.effect.item.SknowPoint;

public class SknowScence extends EffectScence{

	@Deprecated
	public SknowScence(int width, int height, int sknowNum){
		super(width, height, sknowNum);
	}
	@Deprecated
	public SknowScence(int width, int height, int sknowNum, int itemColor){
		super(width, height, sknowNum, itemColor);
	}
	public SknowScence(int width, int height, int sknowNum, int itemColor, boolean randColor){
		super(width, height, sknowNum, itemColor, randColor);
	}
	protected void initScence() {
		for(int i = 0; i < itemNum; i ++){
			list.add(new SknowPoint(width, height, itemColor, randColor));
		}		
	}
	
}
