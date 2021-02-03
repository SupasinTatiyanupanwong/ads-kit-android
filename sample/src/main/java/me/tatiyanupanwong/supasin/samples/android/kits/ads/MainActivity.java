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

package me.tatiyanupanwong.supasin.samples.android.kits.ads;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import me.tatiyanupanwong.supasin.libraries.android.kits.ads.AdsKit;
import me.tatiyanupanwong.supasin.libraries.android.kits.ads.model.identifier.AdvertisingIdClient;
import me.tatiyanupanwong.supasin.libraries.android.kits.ads.model.identifier.AdvertisingIdNotAvailableException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final AdvertisingIdClient client = AdsKit.getAdvertisingIdClient(this);

        // getAdvertisingIdInfo() must not be called on the main application thread.
        new Thread() {
            @Override
            public void run() {
                try {
                    Log.i("MainActivity", client.getAdvertisingIdInfo().getId());
                } catch (AdvertisingIdNotAvailableException ex) {
                    Log.i("MainActivity", "Advertising ID is not available");
                    ex.printStackTrace();
                }
            }
        }.start();
    }

}
