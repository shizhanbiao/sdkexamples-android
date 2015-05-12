/**
 * Copyright (C) 2013-2014 EaseMob Technologies. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.easemob.applib.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.json.JSONArray;

import com.easemob.chatuidemo.DemoApplication;

import android.content.Context;
import android.content.SharedPreferences;

public class HXPreferenceUtils {
	/**
	 * 保存Preference的name
	 */
	public static final String PREFERENCE_NAME = "saveInfo";
	private static SharedPreferences mSharedPreferences;
	private static HXPreferenceUtils mPreferenceUtils;
	private static SharedPreferences.Editor editor;

	private String SHARED_KEY_SETTING_NOTIFICATION = "shared_key_setting_notification";
	private String SHARED_KEY_SETTING_SOUND = "shared_key_setting_sound";
	private String SHARED_KEY_SETTING_VIBRATE = "shared_key_setting_vibrate";
	private String SHARED_KEY_SETTING_SPEAKER = "shared_key_setting_speaker";
	private String SHARED_KEY_SETTING_DISABLED_GROUPS =  "shared_key__setting_disabled_groups";
	private String SHARED_KEY_SETTING_DISABLED_IDS =  "shared_key_setting_disabled_ids";
	private String SHARED_KEY_SETTING_SYNC_GROUPS_FINISHED = "shared_key_setting_sync_groups_finished";
	private String SHARED_KEY_SETTING_SYNC_CONTACTS_FINISHED = "shared_key_setting_sync_contacts_finished";
	private String SHARED_KEY_SETTING_SYNC_BLACK_LIST_FINISHED = "shared_key_setting_sync_blacklist_finished";


	private HXPreferenceUtils(Context cxt) {
		mSharedPreferences = cxt.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
		editor = mSharedPreferences.edit();
	}

	public static synchronized void init(Context cxt){
	    if(mPreferenceUtils == null){
	        mPreferenceUtils = new HXPreferenceUtils(cxt);
	    }
	}

	/**
	 * 单例模式，获取instance实例
	 * 
	 * @param cxt
	 * @return
	 */
	public static HXPreferenceUtils getInstance() {
		if (mPreferenceUtils == null) {
			throw new RuntimeException("please init first!");
		}
		
		return mPreferenceUtils;
	}
	
	public void setSettingMsgNotification(boolean paramBoolean) {
		editor.putBoolean(SHARED_KEY_SETTING_NOTIFICATION, paramBoolean);
		editor.commit();
	}

	public boolean getSettingMsgNotification() {
		return mSharedPreferences.getBoolean(SHARED_KEY_SETTING_NOTIFICATION, true);
	}

	public void setSettingMsgSound(boolean paramBoolean) {
		editor.putBoolean(SHARED_KEY_SETTING_SOUND, paramBoolean);
		editor.commit();
	}

	public boolean getSettingMsgSound() {

		return mSharedPreferences.getBoolean(SHARED_KEY_SETTING_SOUND, true);
	}

	public void setSettingMsgVibrate(boolean paramBoolean) {
		editor.putBoolean(SHARED_KEY_SETTING_VIBRATE, paramBoolean);
		editor.commit();
	}

	public boolean getSettingMsgVibrate() {
		return mSharedPreferences.getBoolean(SHARED_KEY_SETTING_VIBRATE, true);
	}

	public void setSettingMsgSpeaker(boolean paramBoolean) {
		editor.putBoolean(SHARED_KEY_SETTING_SPEAKER, paramBoolean);
		editor.commit();
	}

	public boolean getSettingMsgSpeaker() {
		return mSharedPreferences.getBoolean(SHARED_KEY_SETTING_SPEAKER, true);
	}

	public void setSettingSyncGroupsFinished(boolean paramBoolean) {
		String username = DemoApplication.getInstance().getUserName();
		editor.putBoolean(SHARED_KEY_SETTING_SYNC_GROUPS_FINISHED + " " + username, paramBoolean);
		editor.commit();
	}
	
	public boolean getSettingSyncGroupsFinished() {
		String username = DemoApplication.getInstance().getUserName();
		return mSharedPreferences.getBoolean(SHARED_KEY_SETTING_SYNC_GROUPS_FINISHED + " " + username, false);		
	}

	public void setSettingSyncContactsFinished(boolean paramBoolean) {
		String username = DemoApplication.getInstance().getUserName();
		editor.putBoolean(SHARED_KEY_SETTING_SYNC_CONTACTS_FINISHED + " " + username, paramBoolean);
		editor.commit();
	}
	
	public boolean getSettingSyncContactsFinished() {
		String username = DemoApplication.getInstance().getUserName();
		return mSharedPreferences.getBoolean(SHARED_KEY_SETTING_SYNC_CONTACTS_FINISHED + " " + username, false);		
	}

	public void setSettingSyncBlackListFinished(boolean paramBoolean) {
		String username = DemoApplication.getInstance().getUserName();
		editor.putBoolean(SHARED_KEY_SETTING_SYNC_BLACK_LIST_FINISHED + " " + username, paramBoolean);
		editor.commit();
	}
	
	public boolean getSettingSyncBlackListFinished() {
		String username = DemoApplication.getInstance().getUserName();
		return mSharedPreferences.getBoolean(SHARED_KEY_SETTING_SYNC_BLACK_LIST_FINISHED + " " + username, false);		
	}
}
