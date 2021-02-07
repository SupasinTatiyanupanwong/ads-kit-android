# Ads Kit

[![javadoc](https://javadoc.io/badge2/dev.supasintatiyanupanwong.libraries.android.kits.ads/ads-core/javadoc.svg)](https://javadoc.io/doc/dev.supasintatiyanupanwong.libraries.android.kits.ads/ads-core)
[![license](https://img.shields.io/github/license/SupasinTatiyanupanwong/ads-kit-android.svg)](https://www.apache.org/licenses/LICENSE-2.0)

Ads Kit is an abstraction wrapper that encapsulates Android's Ads APIs from Google and Huawei.

## Architecture

The library consists of 3 artifacts; `ads-core`, `ads-google`, and `ads-huawei`.

* `ads-core` artifact provides an abstraction layer to interact with the Android's Ads APIs.
* `ads-google` artifact provides an integration with the Google Mobile Ads SDK.
* `ads-huawei` artifact provides an integration with the Huawei Ads SDK.

## Usage

### Limitations

Only Advertising ID is currently supported.

### Migrating from the existing Ads APIs

| Existing Name                                         | Ads Kit Name                                                      |
|:----------------------------------------------------- |:----------------------------------------------------------------- |
| ``AdvertisingIdClient.getAdvertisingIdInfo(Context)`` | ``AdsKit.getAdvertisingIdClient(Context).getAdvertisingIdInfo()`` |

### Additional documentation

* [Mobile Ads SDK for Android - Google Developer](https://developers.google.com/ad-manager/mobile-ads-sdk/android)
* [Ads Kit - HUAWEI Ads Publisher Service - HUAWEI Developer](https://developer.huawei.com/consumer/en/hms/huawei-adskit)

## Declaring dependencies

Add the dependencies for the artifacts you need in the ```build.gradle``` file for your app or module:

```groovy
dependencies {
    // To use the Google Mobile Ads SDK via Ads Kit
    implementation 'dev.supasintatiyanupanwong.libraries.android.kits.ads:ads-google:0.1.0'

    // To use the Huawei Ads SDK via Ads Kit
    implementation 'dev.supasintatiyanupanwong.libraries.android.kits.ads:ads-huawei:0.1.0'
}
```

If both of integration artifacts are included in your final build, the implementation will be selected based on API availability upon application startup.

However, it is recommended to separate builds between them as next:

```groovy
android {
    // ...
    flavorDimensions 'vendor'
    productFlavors {
        google
        huawei { applicationIdSuffix '.huawei' }
    }
}

configurations {
    google
    huawei

    googleImplementation.extendsFrom(google)
    googleCompileOnly.extendsFrom(huawei)

    huaweiImplementation.extendsFrom(huawei)
    huaweiCompileOnly.extendsFrom(google)
}

dependencies {
    google 'dev.supasintatiyanupanwong.libraries.android.kits.ads:ads-google:0.1.0'
    huawei 'dev.supasintatiyanupanwong.libraries.android.kits.ads:ads-huawei:0.1.0'
}
```

Although make sure to have at least one of the integration artifacts included in your final build, otherwise an exception will be thrown at runtime.

For more information about dependencies, see [Add build dependencies](https://developer.android.com/studio/build/dependencies).

## License

```
Copyright 2020 Supasin Tatiyanupanwong

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
