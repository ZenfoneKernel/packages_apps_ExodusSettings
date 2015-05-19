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

import com.android.exodussettings.RomControls;

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
        sResMap.put(RomControls.class.getName(),
            new SearchIndexableResource(
                    Ranking.getRankForClassName(RomControls.class.getName()),
                    R.xml.rom_controls,
                    RomControls.class.getName(),
                    R.drawable.ic_settings_home));
    }
}