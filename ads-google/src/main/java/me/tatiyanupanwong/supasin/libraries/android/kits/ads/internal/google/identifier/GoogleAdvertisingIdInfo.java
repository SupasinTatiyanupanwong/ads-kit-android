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

package me.tatiyanupanwong.supasin.libraries.android.kits.ads.internal.google.identifier;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

import me.tatiyanupanwong.supasin.libraries.android.kits.ads.model.identifier.AdvertisingIdInfo;
import me.tatiyanupanwong.supasin.libraries.android.kits.ads.model.identifier.AdvertisingIdNotAvailableException;

import static androidx.annotation.RestrictTo.Scope.LIBRARY;

@RestrictTo(LIBRARY)
public class GoogleAdvertisingIdInfo implements AdvertisingIdInfo {

    private final com.google.android.gms.ads.identifier.AdvertisingIdClient.Info mDelegate;

    public GoogleAdvertisingIdInfo(@NonNull Context context)
            throws AdvertisingIdNotAvailableException {
        try {
            mDelegate = com.google.android.gms.ads.identifier.AdvertisingIdClient
                    .getAdvertisingIdInfo(context);
        } catch (Exception ex) {
            throw new AdvertisingIdNotAvailableException(ex);
        }
    }

    @Override
    public String getId() {
        return mDelegate.getId();
    }

    @Override
    public boolean isLimitAdTrackingEnabled() {
        return mDelegate.isLimitAdTrackingEnabled();
    }

    @NonNull
    @Override
    public String toString() {
        return mDelegate.toString();
    }

}
