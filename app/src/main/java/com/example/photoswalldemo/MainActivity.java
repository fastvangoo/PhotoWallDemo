package com.example.photoswalldemo;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

/**
 * 照片墙主活动，使用GridView展示照片墙。
 * 
 * @author guolin
 */
public class MainActivity extends Activity {

	private WelcomeFragment mWelcomeFragment;

	private FragmentManager mFragmentMgr;

	private Button mBtnNext;

	private Context mContext;

	public MainActivity() {
	}

	private void initView()
	{
		mFragmentMgr = getFragmentManager();
		mWelcomeFragment = new WelcomeFragment();
		FragmentTransaction transaction =  mFragmentMgr.beginTransaction();
		transaction.add(R.id.gallary, mWelcomeFragment);
		transaction.commit();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("kill me");
		Log.d("this is log.d", "this is log.d");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();

		mContext = this;


		mBtnNext = (Button) this.findViewById(R.id.btnNext);
		mBtnNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(mContext, NextPageActivity.class);
				startActivity(intent);
			}
		});

	}
	
	@Override
	protected void onPause() {
		super.onPause();

	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// 退出程序时结束所有的下载任务

	}

	@Override
	protected void onResume() {
		super.onResume();
	}
}