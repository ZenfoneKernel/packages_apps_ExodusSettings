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

package com.android.exodussettings;

import android.content.Context;
import android.content.res.Resources;

import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.preference.SwitchPreference;

import android.provider.SearchIndexableResource;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.AsyncTask;
import android.os.ServiceManager;

import android.app.ProgressDialog;
import android.app.Activity;
import android.app.ActivityManagerNative;
import android.app.IActivityManager;

import android.util.DisplayMetrics;
import android.util.Log;

import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settings.search.Indexable;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

import java.util.List;
import java.util.ArrayList;

/**
 * This class intended for Exodus Features. (note: only targets packages_apps_setting module)
 * ROM controls under category Exodus should appear in setting section. >> following categories are implemented as of now.
 * 1 : LCD Display completely aligned with CyanogenMod code as of now
 *                 (Upon selection of density restarts the UI). @TODO: Dave will enhance it with custom LCD settings.
 *
 * --------------------
 * @see res/values/exodus_strings.xml, res/xml/dashboard_categories.xml, res/xml/rom_controls.xml
 *
 * @Author	Raja Mungamuri
 * @Version	1.0 (Android 5.1.x)
 * @Since	2015-MAY-17
 */
public class RomControls extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener, Indexable  {

    private static final String TAG = "RomControls";
    private static final String KEY_LCD_DENSITY = "lcd_density";

    private ListPreference mLcdDensityPreference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //final Activity activity = getActivity();

        addPreferencesFromResource(R.xml.rom_controls);

    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object objValue) {
        final String key = preference.getKey();
        return false;
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
    public void onDestroy() {
        super.onDestroy();
    }

    public static void restore(Context ctx) {
    }

  //Indexable support
  public static final Indexable.SearchIndexProvider SEARCH_INDEX_DATA_PROVIDER =
            new BaseSearchIndexProvider() {

                @Override
                public List<SearchIndexableResource> getXmlResourcesToIndex(Context context,
                        boolean enabled) {
                    ArrayList<SearchIndexableResource> result =
                            new ArrayList<SearchIndexableResource>();

                    SearchIndexableResource sir = new SearchIndexableResource(context);
                    sir.xmlResId = R.xml.rom_controls;
                    result.add(sir);

                    return result;
                }

            };
}
