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

package me.tatiyanupanwong.supasin.libraries.android.kits.ads;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import me.tatiyanupanwong.supasin.libraries.android.kits.ads.model.AdsFactory;

abstract class AdsPlatform {

    private static AdsPlatform sPlatform;

    static synchronized AdsPlatform get() {
        return sPlatform;
    }


    @NonNull
    abstract AdsFactory getFactory();


    static synchronized void init(@NonNull Context context) {
        sPlatform = findPlatform(context);
    }


    private static AdsPlatform findPlatform(@NonNull Context context) {
        AdsPlatform google = GoogleAdsPlatform.buildIfSupported(context);
        if (google != null) {
            return google;
        }

        AdsPlatform huawei = HuaweiAdsPlatform.buildIfSupported(context);
        if (huawei != null) {
            return huawei;
        }

        throw new IllegalStateException(
                "Can't find supported platform, make sure to include one of the next artifacts:"
                        + " ':ads-google', or ':ads-huawei'");
    }


    private static final class GoogleAdsPlatform extends AdsPlatform {
        private static final String LIBRARY_PACKAGE_NAME =
                "me.tatiyanupanwong.supasin.libraries.android.kits.ads.internal.google";

        private static AdsFactory sFactory;

        private GoogleAdsPlatform() {}

        @NonNull
        @Override
        AdsFactory getFactory() {
            return sFactory;
        }

        @Nullable
        static AdsPlatform buildIfSupported(@NonNull Context context) {
            try {
                sFactory = (AdsFactory) Class.forName(LIBRARY_PACKAGE_NAME + ".GoogleAdsFactory")
                        .getMethod("buildIfSupported", Context.class)
                        .invoke(null, context);

                return new GoogleAdsPlatform();
            } catch (Exception ex) {
                return null;
            }
        }
    }

    private static final class HuaweiAdsPlatform extends AdsPlatform {
        private static final String LIBRARY_PACKAGE_NAME =
                "me.tatiyanupanwong.supasin.libraries.android.kits.ads.internal.huawei";

        private static AdsFactory sFactory;

        private HuaweiAdsPlatform() {}

        @NonNull
        @Override
        AdsFactory getFactory() {
            return sFactory;
        }

        @Nullable
        static AdsPlatform buildIfSupported(@NonNull Context context) {
            try {
                sFactory = (AdsFactory) Class.forName(LIBRARY_PACKAGE_NAME + ".HuaweiAdsFactory")
                        .getMethod("buildIfSupported", Context.class)
                        .invoke(null, context);

                return new HuaweiAdsPlatform();
            } catch (Exception ex) {
                return null;
            }
        }
    }

}
