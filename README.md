# Ads Kit

Abstraction wrapper that encapsulates Ads APIs for Android.

Ads Kit is currently providing supports for Google Ads and Huawei Ads.

## Usage

This project contains 3 artifacts; `ads-core`, `ads-google`, and `ads-huawei`.

`ads-core` artifact provides abstraction interfaces to interact with Ads APIs.

`ads-google` artifact provides Google Ads integration.

`ads-huawei` artifact provides Huawei Ads integration.

### Migration from existing Ads APIs

| Existing Name                                         | Ads Kit Name                                                      |
|:----------------------------------------------------- |:----------------------------------------------------------------- |
| ``AdvertisingIdClient.getAdvertisingIdInfo(Context)`` | ``AdsKit.getAdvertisingIdClient(Context).getAdvertisingIdInfo()`` |

### Limitations

Only Advertising ID is currently supported.

### Additional documentation

* [Mobile Ads SDK for Android - Google Developer](https://developers.google.com/ad-manager/mobile-ads-sdk/android)
* [Ads Kit - HUAWEI Ads Publisher Service - HUAWEI Developer](https://developer.huawei.com/consumer/en/hms/huawei-adskit)

## Download

Add the following to your Gradle build file:

```groovy
dependencies {
    implementation 'me.tatiyanupanwong.supasin.android.libraries.kits.ads:ads-google:1.0.0'
    implementation 'me.tatiyanupanwong.supasin.android.libraries.kits.ads:ads-huawei:1.0.0'
}
```

If both of integration artifacts are included in your final build, the implementation will be selected based on API availability upon application startup.

However, it is recommended to separate builds between them as next:

```groovy
android {
    ...
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
    google 'me.tatiyanupanwong.supasin.android.libraries.kits.ads:ads-google:1.0.0'
    huawei 'me.tatiyanupanwong.supasin.android.libraries.kits.ads:ads-huawei:1.0.0'
}
```

## License

```
Copyright (C) 2020 Supasin Tatiyanupanwong

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
