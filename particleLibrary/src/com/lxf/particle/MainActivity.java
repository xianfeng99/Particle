package com.lxf.particle;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.lxf.particle.fragment.LightFragment;
import com.lxf.particle.fragment.MusicFragment;
import com.lxf.particle.fragment.RainFragment;
import com.lxf.particle.fragment.SknowFragment;
import com.lxf.particle.fragment.StartFragment;

public class MainActivity extends FragmentActivity {

	private ViewGroup mViewGroup;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mViewGroup = (ViewGroup) findViewById(R.id.fragment_containers);
		getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers, new StartFragment()).commit();
	}

	public void onEffectChanged(View view) {
		Button button = (Button) view;
		if (button.getText().equals("星空")) {
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers, new StartFragment()).commit();
		} else if (button.getText().equals("音乐")) {
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers, new MusicFragment()).commit();
		} else if (button.getText().equals("下雨")) {
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers, new RainFragment()).commit();
		} else if (button.getText().equals("下雪")) {
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers, new SknowFragment()).commit();
		} else if (button.getText().equals("闪电")) {
			getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containers, new LightFragment()).commit();
		}
	}

}
