package com.lxf.particle.effect.scene;

import com.lxf.particle.effect.base.EffectScence;
import com.lxf.particle.effect.item.MusicPoint;

public class MusicJumpScence extends EffectScence {

	public MusicJumpScence(int width, int height, int musicNum){
		super(width, height, musicNum);
	}

	protected void initScence() {
		for(int i = 0; i < itemNum; i ++){
			list.add(new MusicPoint(i * width / itemNum, width, height));
		}		
	}
	
}
