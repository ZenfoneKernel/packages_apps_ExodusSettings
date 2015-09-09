/*
 * Copyright (C) 2014 The Android Open Source Project
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

import android.provider.SearchIndexableResource;

import com.android.settings.R;
import com.android.settings.search.Ranking;
import com.android.settings.AOSPDisplaySettings;
import com.android.settings.AOSPSecuritySettings;
import com.android.settings.AOSPWirelessSettings;
import com.android.settings.WallpaperTypeSettings;
import com.android.settings.notification.NotificationSettings;

import com.android.exodussettings.RomControls;
import com.android.exodussettings.exodus.ExodusInterface;

import java.util.HashMap;

/**
 * Utility class for dealing with Search Ranking.
 */
public final class ExodusSearchHelper {

    public static final int RANK_EXODUS = 22;

    public static void AddExodusRanks(HashMap<String, Integer> sRankMap) {
        sRankMap.put(RomControls.class.getName(), RANK_EXODUS);
    }

    public static void AddExodusSearches(HashMap<String, SearchIndexableResource> sResMap) {
        sResMap.put(WallpaperTypeSettings.class.getName(),
            new SearchIndexableResource(
                    Ranking.getRankForClassName(WallpaperTypeSettings.class.getName()),
                    R.xml.wallpaper_settings,
                    WallpaperTypeSettings.class.getName(),
                    R.drawable.ic_settings_display));
        sResMap.put(NotificationSettings.class.getName(),
            new SearchIndexableResource(
                    Ranking.getRankForClassName(NotificationSettings.class.getName()),
                    R.xml.notification_settings,
                    NotificationSettings.class.getName(),
                    R.drawable.ic_settings_notifications));
        sResMap.put(AOSPSecuritySettings.class.getName(),
            new SearchIndexableResource(
                    Ranking.getRankForClassName(AOSPSecuritySettings.class.getName()),
                    R.xml.security_settings,
                    AOSPSecuritySettings.class.getName(),
                    R.drawable.ic_settings_security));
        sResMap.put(ExodusInterface.class.getName(),
            new SearchIndexableResource(
                    Ranking.getRankForClassName(ExodusInterface.class.getName()),
                    R.xml.exodus_interface,
                    ExodusInterface.class.getName(),
                    R.drawable.ic_settings_system));
    }
}
