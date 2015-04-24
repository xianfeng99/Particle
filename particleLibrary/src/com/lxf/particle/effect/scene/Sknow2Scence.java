package com.lxf.particle.effect.scene;

import com.lxf.particle.effect.base.EffectScence;
import com.lxf.particle.effect.item.SknowPoint2;

public class Sknow2Scence extends EffectScence{

	@Deprecated
	public Sknow2Scence(int width, int height, int sknowNum){
		super(width, height, sknowNum);
	}
	public Sknow2Scence(int width, int height, int sknowNum, int itemColor){
		super(width, height, sknowNum, itemColor);
	}
	public Sknow2Scence(int width, int height, int sknowNum, int itemColor, boolean randColor){
		super(width, height, sknowNum, itemColor, randColor);
	}
	protected void initScence() {
		for(int i = 0; i < itemNum; i ++){
			list.add(new SknowPoint2(width, height, itemColor, randColor));
		}		
	}
	
}
