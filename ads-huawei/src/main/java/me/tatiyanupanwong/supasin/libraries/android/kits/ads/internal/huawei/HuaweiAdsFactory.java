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

package me.tatiyanupanwong.supasin.libraries.android.kits.ads.internal.huawei;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;

import java.util.Arrays;
import java.util.List;

import me.tatiyanupanwong.supasin.libraries.android.kits.ads.internal.huawei.identifier.HuaweiAdvertisingIdClient;
import me.tatiyanupanwong.supasin.libraries.android.kits.ads.model.AdsFactory;
import me.tatiyanupanwong.supasin.libraries.android.kits.ads.model.identifier.AdvertisingIdClient;

import static androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP;

@SuppressWarnings("unused")
@RestrictTo(LIBRARY_GROUP)
public class HuaweiAdsFactory implements AdsFactory {

    private static final List<Integer> UNAVAILABLE_RESULTS = Arrays.asList(
            ConnectionResult.SERVICE_DISABLED,
            ConnectionResult.SERVICE_MISSING,
            ConnectionResult.SERVICE_INVALID);

    private HuaweiAdsFactory() {}

    @NonNull
    @Override
    public AdvertisingIdClient getAdvertisingIdClient(@NonNull Context context) {
        return new HuaweiAdvertisingIdClient(context);
    }


    @NonNull
    public static AdsFactory buildIfSupported(@NonNull Context context) {
        int result = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(context);
        if (UNAVAILABLE_RESULTS.contains(result)) {
            throw new UnsupportedOperationException("Huawei Ads is not available.");
        }

        return new HuaweiAdsFactory();
    }

}
