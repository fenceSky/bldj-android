package com.bldj.lexiang.ui;

import com.umeng.analytics.MobclickAgent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class BaseActivity extends Activity implements OnClickListener {
	
	protected static final String TAG = "BaseActivity";
	//protected static Context mContext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//mContext = this;
	}

	/**
	 * 左返回按钮点击事件
	 */
	protected void onLeftBackClick() {
		finish();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		MobclickAgent.onResume(this);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		MobclickAgent.onPause(this);
	}
	
	@Override
	protected void onDestroy() {
		dismissWaitingDialog();
		super.onDestroy();
	}

	protected void startActivity(Class<?> aTargetClass, Bundle aBundle) {
		Intent i = new Intent(this, aTargetClass);
		if (aBundle != null) {
			i.putExtras(aBundle);
		}
		startActivity(i);
	}

	protected void dismissWaitingDialog() {
	}
	
	public void showToast(String aMessage) {
		Toast.makeText(this, aMessage, Toast.LENGTH_SHORT).show();
	}
	
	public void showToast(int resId) {
		Toast.makeText(getApplicationContext(), resId, Toast.LENGTH_SHORT).show();
	}
	
	/**
	 * 隐藏键盘
	 */
	protected void hideInputMethod() {
		View view = getCurrentFocus();
		if (view != null) {
			((InputMethodManager) getSystemService(INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
					view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		}
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	}
}
