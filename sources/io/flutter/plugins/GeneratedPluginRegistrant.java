package io.flutter.plugins;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.aboutyou.dart_packages.sign_in_with_apple.SignInWithApplePlugin;
import com.adjust.sdk.flutter.AdjustSdk;
import com.adtechsdk.dh_adtech_sdk_flutter.DhAdtechSdkFlutterPlugin;
import com.alexmiller.map_launcher.MapLauncherPlugin;
import com.baseflow.geolocator.GeolocatorPlugin;
import com.baseflow.permissionhandler.PermissionHandlerPlugin;
import com.braze.brazeplugin.BrazePlugin;
import com.github.droibit.flutter.plugins.customtabs.CustomTabsPlugin;
import com.google.flutter.recaptcha.RecaptchaEnterprisePlugin;
import com.huawei.hms.flutter.analytics.AnalyticsPlugin;
import com.huawei.hms.flutter.map.HmsMap;
import com.jaumard.smsautofill.SmsAutoFillPlugin;
import com.julienvignali.phone_number.PhoneNumberPlugin;
import com.mr.flutter.plugin.filepicker.FilePickerPlugin;
import com.newrelic.newrelic_mobile.NewrelicMobilePlugin;
import com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import com.talabat.device_info_plugin.DeviceInfoPlugin;
import com.talabat.dh_chat.DhChatPlugin;
import com.talabat.mobile_services_type.MobileServicesTypePlugin;
import com.talabat.performance_analytics.PerformanceAnalyticsPlugin;
import com.talabat.perseus.PerseusAnalyticsPlugin;
import com.talabat.secure_payment_redirection.SecurePaymentRedirectionPlugin;
import com.talabat.sign_in_with_facebook.SignInWithFacebookPlugin;
import com.talabat.token_secure_storage.TokenSecureStoragePlugin;
import com.tekartik.sqflite.SqflitePlugin;
import creativemaybeno.wakelock.WakelockPlugin;
import dev.flutter.plugins.integration_test.IntegrationTestPlugin;
import dev.fluttercommunity.plus.packageinfo.PackageInfoPlugin;
import dev.fluttercommunity.plus.share.SharePlusPlugin;
import dev.isar.isar_flutter_libs.IsarFlutterLibsPlugin;
import flutter.plugins.vibrate.VibratePlugin;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugins.connectivity.ConnectivityPlugin;
import io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin;
import io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin;
import io.flutter.plugins.firebase.database.FirebaseDatabasePlugin;
import io.flutter.plugins.firebaseanalytics.FirebaseAnalyticsPlugin;
import io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin;
import io.flutter.plugins.googlemaps.GoogleMapsPlugin;
import io.flutter.plugins.googlesignin.GoogleSignInPlugin;
import io.flutter.plugins.imagepicker.ImagePickerPlugin;
import io.flutter.plugins.pathprovider.PathProviderPlugin;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin;
import io.flutter.plugins.urllauncher.UrlLauncherPlugin;
import io.flutter.plugins.videoplayer.VideoPlayerPlugin;
import io.flutter.plugins.webviewflutter.WebViewFlutterPlugin;
import name.avioli.unilinks.UniLinksPlugin;

@Keep
public final class GeneratedPluginRegistrant {
    private static final String TAG = "GeneratedPluginRegistrant";

    public static void registerWith(@NonNull FlutterEngine flutterEngine) {
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new AdjustSdk());
        } catch (Exception e11) {
            Log.e(TAG, "Error registering plugin adjust_sdk, com.adjust.sdk.flutter.AdjustSdk", e11);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new BrazePlugin());
        } catch (Exception e12) {
            Log.e(TAG, "Error registering plugin braze_plugin, com.braze.brazeplugin.BrazePlugin", e12);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new CardTokenizationPlugin());
        } catch (Exception e13) {
            Log.e(TAG, "Error registering plugin card_tokenization, com.talabat.card_tokenization.CardTokenizationPlugin", e13);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new ConnectivityPlugin());
        } catch (Exception e14) {
            Log.e(TAG, "Error registering plugin connectivity, io.flutter.plugins.connectivity.ConnectivityPlugin", e14);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new DeviceInfoPlugin());
        } catch (Exception e15) {
            Log.e(TAG, "Error registering plugin device_info_plugin, com.talabat.device_info_plugin.DeviceInfoPlugin", e15);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new DhAdtechSdkFlutterPlugin());
        } catch (Exception e16) {
            Log.e(TAG, "Error registering plugin dh_adtech_sdk_flutter, com.adtechsdk.dh_adtech_sdk_flutter.DhAdtechSdkFlutterPlugin", e16);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new DhChatPlugin());
        } catch (Exception e17) {
            Log.e(TAG, "Error registering plugin dh_chat, com.talabat.dh_chat.DhChatPlugin", e17);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FilePickerPlugin());
        } catch (Exception e18) {
            Log.e(TAG, "Error registering plugin file_picker, com.mr.flutter.plugin.filepicker.FilePickerPlugin", e18);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FirebaseAnalyticsPlugin());
        } catch (Exception e19) {
            Log.e(TAG, "Error registering plugin firebase_analytics, io.flutter.plugins.firebaseanalytics.FirebaseAnalyticsPlugin", e19);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterFirebaseCorePlugin());
        } catch (Exception e21) {
            Log.e(TAG, "Error registering plugin firebase_core, io.flutter.plugins.firebase.core.FlutterFirebaseCorePlugin", e21);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterFirebaseCrashlyticsPlugin());
        } catch (Exception e22) {
            Log.e(TAG, "Error registering plugin firebase_crashlytics, io.flutter.plugins.firebase.crashlytics.FlutterFirebaseCrashlyticsPlugin", e22);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FirebaseDatabasePlugin());
        } catch (Exception e23) {
            Log.e(TAG, "Error registering plugin firebase_database, io.flutter.plugins.firebase.database.FirebaseDatabasePlugin", e23);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new CustomTabsPlugin());
        } catch (Exception e24) {
            Log.e(TAG, "Error registering plugin flutter_custom_tabs, com.github.droibit.flutter.plugins.customtabs.CustomTabsPlugin", e24);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new InAppWebViewFlutterPlugin());
        } catch (Exception e25) {
            Log.e(TAG, "Error registering plugin flutter_inappwebview, com.pichillilorenzo.flutter_inappwebview.InAppWebViewFlutterPlugin", e25);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new FlutterAndroidLifecyclePlugin());
        } catch (Exception e26) {
            Log.e(TAG, "Error registering plugin flutter_plugin_android_lifecycle, io.flutter.plugins.flutter_plugin_android_lifecycle.FlutterAndroidLifecyclePlugin", e26);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new VibratePlugin());
        } catch (Exception e27) {
            Log.e(TAG, "Error registering plugin flutter_vibrate, flutter.plugins.vibrate.VibratePlugin", e27);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new GeolocatorPlugin());
        } catch (Exception e28) {
            Log.e(TAG, "Error registering plugin geolocator_android, com.baseflow.geolocator.GeolocatorPlugin", e28);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new GoogleMapsPlugin());
        } catch (Exception e29) {
            Log.e(TAG, "Error registering plugin google_maps_flutter, io.flutter.plugins.googlemaps.GoogleMapsPlugin", e29);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new GoogleSignInPlugin());
        } catch (Exception e31) {
            Log.e(TAG, "Error registering plugin google_sign_in_android, io.flutter.plugins.googlesignin.GoogleSignInPlugin", e31);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new AnalyticsPlugin());
        } catch (Exception e32) {
            Log.e(TAG, "Error registering plugin huawei_analytics, com.huawei.hms.flutter.analytics.AnalyticsPlugin", e32);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new HmsMap());
        } catch (Exception e33) {
            Log.e(TAG, "Error registering plugin huawei_map, com.huawei.hms.flutter.map.HmsMap", e33);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new ImagePickerPlugin());
        } catch (Exception e34) {
            Log.e(TAG, "Error registering plugin image_picker, io.flutter.plugins.imagepicker.ImagePickerPlugin", e34);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new IntegrationTestPlugin());
        } catch (Exception e35) {
            Log.e(TAG, "Error registering plugin integration_test, dev.flutter.plugins.integration_test.IntegrationTestPlugin", e35);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new IsarFlutterLibsPlugin());
        } catch (Exception e36) {
            Log.e(TAG, "Error registering plugin isar_flutter_libs, dev.isar.isar_flutter_libs.IsarFlutterLibsPlugin", e36);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new MapLauncherPlugin());
        } catch (Exception e37) {
            Log.e(TAG, "Error registering plugin map_launcher, com.alexmiller.map_launcher.MapLauncherPlugin", e37);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new MobileServicesTypePlugin());
        } catch (Exception e38) {
            Log.e(TAG, "Error registering plugin mobile_services_type, com.talabat.mobile_services_type.MobileServicesTypePlugin", e38);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new NewrelicMobilePlugin());
        } catch (Exception e39) {
            Log.e(TAG, "Error registering plugin newrelic_mobile, com.newrelic.newrelic_mobile.NewrelicMobilePlugin", e39);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PackageInfoPlugin());
        } catch (Exception e41) {
            Log.e(TAG, "Error registering plugin package_info_plus, dev.fluttercommunity.plus.packageinfo.PackageInfoPlugin", e41);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PathProviderPlugin());
        } catch (Exception e42) {
            Log.e(TAG, "Error registering plugin path_provider, io.flutter.plugins.pathprovider.PathProviderPlugin", e42);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PerformanceAnalyticsPlugin());
        } catch (Exception e43) {
            Log.e(TAG, "Error registering plugin performance_analytics, com.talabat.performance_analytics.PerformanceAnalyticsPlugin", e43);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PermissionHandlerPlugin());
        } catch (Exception e44) {
            Log.e(TAG, "Error registering plugin permission_handler_android, com.baseflow.permissionhandler.PermissionHandlerPlugin", e44);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PerseusAnalyticsPlugin());
        } catch (Exception e45) {
            Log.e(TAG, "Error registering plugin perseus_analytics, com.talabat.perseus.PerseusAnalyticsPlugin", e45);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new PhoneNumberPlugin());
        } catch (Exception e46) {
            Log.e(TAG, "Error registering plugin phone_number, com.julienvignali.phone_number.PhoneNumberPlugin", e46);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new RecaptchaEnterprisePlugin());
        } catch (Exception e47) {
            Log.e(TAG, "Error registering plugin recaptcha_enterprise_flutter, com.google.flutter.recaptcha.RecaptchaEnterprisePlugin", e47);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SecurePaymentRedirectionPlugin());
        } catch (Exception e48) {
            Log.e(TAG, "Error registering plugin secure_payment_redirection, com.talabat.secure_payment_redirection.SecurePaymentRedirectionPlugin", e48);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SharePlusPlugin());
        } catch (Exception e49) {
            Log.e(TAG, "Error registering plugin share_plus, dev.fluttercommunity.plus.share.SharePlusPlugin", e49);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SharedPreferencesPlugin());
        } catch (Exception e50) {
            Log.e(TAG, "Error registering plugin shared_preferences_android, io.flutter.plugins.sharedpreferences.SharedPreferencesPlugin", e50);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SignInWithApplePlugin());
        } catch (Exception e51) {
            Log.e(TAG, "Error registering plugin sign_in_with_apple, com.aboutyou.dart_packages.sign_in_with_apple.SignInWithApplePlugin", e51);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SignInWithFacebookPlugin());
        } catch (Exception e52) {
            Log.e(TAG, "Error registering plugin sign_in_with_facebook, com.talabat.sign_in_with_facebook.SignInWithFacebookPlugin", e52);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SmsAutoFillPlugin());
        } catch (Exception e53) {
            Log.e(TAG, "Error registering plugin sms_autofill, com.jaumard.smsautofill.SmsAutoFillPlugin", e53);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new SqflitePlugin());
        } catch (Exception e54) {
            Log.e(TAG, "Error registering plugin sqflite, com.tekartik.sqflite.SqflitePlugin", e54);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new TokenSecureStoragePlugin());
        } catch (Exception e55) {
            Log.e(TAG, "Error registering plugin token_secure_storage, com.talabat.token_secure_storage.TokenSecureStoragePlugin", e55);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new UniLinksPlugin());
        } catch (Exception e56) {
            Log.e(TAG, "Error registering plugin uni_links, name.avioli.unilinks.UniLinksPlugin", e56);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new UrlLauncherPlugin());
        } catch (Exception e57) {
            Log.e(TAG, "Error registering plugin url_launcher, io.flutter.plugins.urllauncher.UrlLauncherPlugin", e57);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new VideoPlayerPlugin());
        } catch (Exception e58) {
            Log.e(TAG, "Error registering plugin video_player_android, io.flutter.plugins.videoplayer.VideoPlayerPlugin", e58);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new WakelockPlugin());
        } catch (Exception e59) {
            Log.e(TAG, "Error registering plugin wakelock, creativemaybeno.wakelock.WakelockPlugin", e59);
        }
        try {
            flutterEngine.getPlugins().add((FlutterPlugin) new WebViewFlutterPlugin());
        } catch (Exception e60) {
            Log.e(TAG, "Error registering plugin webview_flutter_android, io.flutter.plugins.webviewflutter.WebViewFlutterPlugin", e60);
        }
    }
}
