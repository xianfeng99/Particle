package com.lxf.particle.effect.scene;

import com.lxf.particle.effect.base.EffectScence;
import com.lxf.particle.effect.item.SknowPoint;

public class SknowScence extends EffectScence{

	public SknowScence(int width, int height, int sknowNum){
		super(width, height, sknowNum);
	}

	protected void initScence() {
		for(int i = 0; i < itemNum; i ++){
			list.add(new SknowPoint(width, height));
		}		
	}
	
}
