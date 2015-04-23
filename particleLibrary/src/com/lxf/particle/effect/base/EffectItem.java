package com.lxf.particle.effect.base;

import java.util.Random;

/**
 * 效果基础类
 * @author xianfeng
 *
 */
public abstract class EffectItem implements EffectBase{
	/**
	 * 显示区域的宽度
	 */
	protected int width;
	/**
	 * 显示区域的高度
	 */
	protected int height;
	/**
	 * 效果元素的随机对象
	 */
	protected Random rand;
	
//	public EffectItem(){
//		this(0, 0);
//	}
	
	public EffectItem(int width, int height){
		this.width = width;
		this.height = height;
		rand =new Random();
	}
}
