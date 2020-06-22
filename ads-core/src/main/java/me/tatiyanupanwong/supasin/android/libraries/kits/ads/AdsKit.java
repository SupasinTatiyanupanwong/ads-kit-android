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

package me.tatiyanupanwong.supasin.android.libraries.kits.ads;

import android.content.Context;

import androidx.annotation.NonNull;

import me.tatiyanupanwong.supasin.android.libraries.kits.ads.model.AdsFactory;
import me.tatiyanupanwong.supasin.android.libraries.kits.ads.model.identifier.AdvertisingIdClient;

/**
 * The main entry point for Ads APIs.
 *
 * @since 1.0.0
 */
public final class AdsKit {

    private static final AdsFactory FACTORY = AdsPlatform.get().getFactory();

    private AdsKit() {} // No instances!

    /**
     * Create a new instance of {@link AdvertisingIdClient}.
     */
    @NonNull
    public static AdvertisingIdClient getAdvertisingIdClient(@NonNull Context context) {
        return FACTORY.getAdvertisingIdClient(context);
    }

}
