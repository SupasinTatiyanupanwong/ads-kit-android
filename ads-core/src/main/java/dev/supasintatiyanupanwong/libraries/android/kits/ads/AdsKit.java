/*
 * Copyright 2020 Supasin Tatiyanupanwong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.supasintatiyanupanwong.libraries.android.kits.ads;

import android.content.Context;

import androidx.annotation.NonNull;

import dev.supasintatiyanupanwong.libraries.android.kits.ads.model.AdsFactory;
import dev.supasintatiyanupanwong.libraries.android.kits.ads.model.identifier.AdvertisingIdClient;

/**
 * The main entry point for Ads APIs.
 */
public final class AdsKit {

    private static final @NonNull AdsFactory FACTORY = AdsPlatform.get().getFactory();

    private AdsKit() {} // No instances!

    /**
     * Create a new instance of {@link AdvertisingIdClient}.
     */
    public static @NonNull AdvertisingIdClient getAdvertisingIdClient(@NonNull Context context) {
        return FACTORY.getAdvertisingIdClient(context);
    }

}
