/*
 * Copyright (C) 2020 Supasin Tatiyanupanwong
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

package me.tatiyanupanwong.supasin.android.libraries.kits.ads.model.identifier;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;

/**
 * Client for retrieving Advertising ID related info (the Advertising ID and LAT setting).
 */
public abstract class AdvertisingIdClient {

    protected final Context mContext;

    protected AdvertisingIdClient(Context context) {
        mContext = context;
    }

    /**
     * Retrieves the user's advertising ID and limit ad tracking preference.
     */
    @NonNull
    @WorkerThread
    public abstract AdvertisingIdInfo getAdvertisingIdInfo()
            throws AdvertisingIdNotAvailableException;

}