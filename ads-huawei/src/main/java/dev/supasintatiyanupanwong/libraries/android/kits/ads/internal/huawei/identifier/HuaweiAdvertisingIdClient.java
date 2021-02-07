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

package dev.supasintatiyanupanwong.libraries.android.kits.ads.internal.huawei.identifier;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;

import dev.supasintatiyanupanwong.libraries.android.kits.ads.internal.Preconditions;
import dev.supasintatiyanupanwong.libraries.android.kits.ads.model.identifier.AdvertisingIdClient;
import dev.supasintatiyanupanwong.libraries.android.kits.ads.model.identifier.AdvertisingIdInfo;
import dev.supasintatiyanupanwong.libraries.android.kits.ads.model.identifier.AdvertisingIdNotAvailableException;

import static androidx.annotation.RestrictTo.Scope.LIBRARY;

@RestrictTo(LIBRARY)
public class HuaweiAdvertisingIdClient extends AdvertisingIdClient {

    private final @NonNull Context mContext;

    public HuaweiAdvertisingIdClient(@NonNull Context context) {
        mContext = context;
    }

    @WorkerThread
    @Override
    public @NonNull AdvertisingIdInfo getAdvertisingIdInfo()
            throws AdvertisingIdNotAvailableException {
        Preconditions.checkNotMainThread();
        return new HuaweiAdvertisingIdInfo(mContext);
    }

}
