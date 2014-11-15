package com.bldj.lexiang.http;

import java.util.concurrent.ConcurrentHashMap;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;


import com.bldj.lexiang.GlobalConfig;

/**
 * 添加请求头
 */
public class HttpClientAddHeaders {
	private static ConcurrentHashMap<String, String> headers = new ConcurrentHashMap<String,String>();
	/**
	 * 获取请求头集合
	 * isAuthentication 是否需要认证，注册，密码重置 不需要
	 * @return
	 */
	public static ConcurrentHashMap<String, String> getHeaders(Context context){
		headers.clear();
		headers.put("source","Android");

		if("".equals(GlobalConfig.VERSION_NAME_V)){
			try {
				String pName = context.getPackageName();
				PackageInfo pinfo = context.getPackageManager().getPackageInfo(
						pName, PackageManager.GET_CONFIGURATIONS);
                GlobalConfig.VERSION_NAME_V = String.valueOf(pinfo.versionName);
                GlobalConfig.VERSION_CODE_V = String.valueOf(pinfo.versionCode);

			} catch (NameNotFoundException e) {
			}
		}
		headers.put("version",GlobalConfig.VERSION_NAME_V);
		headers.put("code",GlobalConfig.VERSION_CODE_V);
        headers.put("userId",GlobalConfig.USER_ID);
        headers.put("enterId",GlobalConfig.ENTER_ID);
		if("".equals(GlobalConfig.EQUIPMENT_V)){
            GlobalConfig.EQUIPMENT_V = Build.MODEL;
		}
		headers.put("equipment",GlobalConfig.EQUIPMENT_V);

		return headers;
	}
}