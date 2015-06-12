/*
 * Copyright (C) 2015 Exodus
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.exodussettings.exodus;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.ContentObserver;
import android.hardware.CmHardwareManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemProperties;
import android.os.Vibrator;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceGroup;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.provider.Settings;
import android.util.Log;

import static android.provider.Settings.Secure.WAKE_GESTURE_ENABLED;
import static android.hardware.CmHardwareManager.FEATURE_TAP_TO_WAKE;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;

import java.io.File;

public class HardwareSettings extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {
    private static final String TAG = "Hardware.Settings";

    private static final String KEY_SENSORS_MOTORS_CATEGORY = "sensors_motors_category";
    private static final String KEY_SCREEN_GESTURE_SETTINGS = "device_specific_gesture_settings";
    private static final String KEY_VIBRATE_ON_TOUCH = "haptic_feedback";
    private static final String KEY_VIBRATE_WHEN_RINGING = "vibrate_when_ringing";
    private static final String KEY_TAP_TO_WAKE = "double_tap_wake_gesture";
    private static final String KEY_PROXIMITY_WAKE = "proximity_on_wake";
    private static final String KEY_LIFT_TO_WAKE = "lift_to_wake";
    private static final String KEY_WAKE_WHEN_PLUGGED_OR_UNPLUGGED = "wake_when_plugged_or_unplugged";
    private static final String KEY_BUTTON_NAVIGATION = "buttons_navigation";
    public static final String PREF_FCHARGE = "fast_charge";
    private static final String FCHARGE_PATH = "sys/kernel/fast_charge/force_fast_charge";

    private CheckBoxPreference mTapToWake;
    private CheckBoxPreference mProxWake;
    private CheckBoxPreference mLiftToWakePreference;
    private CheckBoxPreference mWakeWhenPluggedOrUnplugged;
    private CheckBoxPreference mHapticFeedback;
    private CheckBoxPreference mVibrateWhenRinging;
    private static CheckBoxPreference mFastCharge;

    private Preference mButtonNavigation;
    private CmHardwareManager mCmHardwareManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.hardware_settings);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
            // If we didn't handle it, let preferences handle it.
            return super.onPreferenceTreeClick(preferenceScreen, preference);

    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object objValue) {
        final String key = preference.getKey();

        return true;
    }

    /**
     * Restore the properties associated with this preference on boot
     * @param ctx A valid context
     */
    public static void restore(Context ctx) {
    }
}
