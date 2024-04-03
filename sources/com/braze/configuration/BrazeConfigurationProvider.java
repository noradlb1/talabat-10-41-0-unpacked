package com.braze.configuration;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import bo.app.u0;
import bo.app.v0;
import com.appboy.enums.DeviceKey;
import com.appboy.enums.LocationProviderName;
import com.appboy.enums.SdkFlavor;
import com.appboy.support.PackageUtils;
import com.braze.configuration.CachedConfigurationProvider;
import com.braze.enums.BrazeSdkMetadata;
import com.braze.support.BrazeLogger;
import com.visa.checkout.Profile;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(bv = {}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 p2\u00020\u0001:\u0002qrB\u000f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\bn\u0010oJ4\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u000e\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0007R \u0010\r\u001a\u00020\f8\u0000X\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\u00138BX\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00130\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010 \u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010$\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010%\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b%\u0010\u001aR\u0011\u0010&\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b&\u0010\u001aR\u0011\u0010'\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b'\u0010\u001aR\u0011\u0010+\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010-\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0011\u00101\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0011\u00103\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b2\u0010*R\u0017\u00106\u001a\u00020(8F¢\u0006\f\u0012\u0004\b5\u0010\u0012\u001a\u0004\b4\u0010*R\u0013\u00108\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b7\u0010\u0015R\u0011\u0010:\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b9\u0010\u001aR\u0011\u0010;\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b;\u0010\u001aR\u0011\u0010=\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b<\u0010\u0015R\u0011\u0010?\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b>\u0010\u0015R\u0011\u0010A\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b@\u0010*R\u0017\u0010D\u001a\u00020(8G¢\u0006\f\u0012\u0004\bC\u0010\u0012\u001a\u0004\bB\u0010*R\u0013\u0010H\u001a\u0004\u0018\u00010E8F¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0011\u0010I\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bI\u0010\u001aR\u0013\u0010K\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\bJ\u0010\u0015R\u0011\u0010L\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bL\u0010\u001aR\u0011\u0010M\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bM\u0010\u001aR\u0011\u0010N\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bN\u0010\u001aR\u0013\u0010P\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\bO\u0010\u0015R\u0017\u0010T\u001a\b\u0012\u0004\u0012\u00020Q0\b8G¢\u0006\u0006\u001a\u0004\bR\u0010SR\u0017\u0010V\u001a\b\u0012\u0004\u0012\u00020Q0\b8F¢\u0006\u0006\u001a\u0004\bU\u0010SR\u0011\u0010W\u001a\u00020\u00188G¢\u0006\u0006\u001a\u0004\bW\u0010\u001aR\u0011\u0010X\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bX\u0010\u001aR\u0011\u0010Y\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bY\u0010\u001aR\u0011\u0010Z\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bZ\u0010\u001aR\u0011\u0010[\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b[\u0010\u001aR\u0011\u0010\\\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\\\u0010\u001aR\u0011\u0010]\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b]\u0010\u001aR\u0011\u0010_\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b^\u0010*R\u0013\u0010a\u001a\u0004\u0018\u00010\u00138F¢\u0006\u0006\u001a\u0004\b`\u0010\u0015R\u0011\u0010c\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\bb\u0010*R\u0017\u0010f\u001a\b\u0012\u0004\u0012\u00020d0\b8F¢\u0006\u0006\u001a\u0004\be\u0010SR\u0011\u0010g\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bg\u0010\u001aR\u0011\u0010h\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bh\u0010\u001aR\u0011\u0010i\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bi\u0010\u001aR\u0011\u0010j\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\bj\u0010\u001aR\u0017\u0010m\u001a\b\u0012\u0004\u0012\u00020k0\b8F¢\u0006\u0006\u001a\u0004\bl\u0010S¨\u0006s"}, d2 = {"Lcom/braze/configuration/BrazeConfigurationProvider;", "Lcom/braze/configuration/CachedConfigurationProvider;", "", "E", "Ljava/lang/Class;", "targetEnumClass", "Lcom/braze/configuration/BrazeConfigurationProvider$b;", "configField", "Ljava/util/EnumSet;", "getGenericEnumSetFromStringSet", "", "clear", "Landroid/content/Context;", "context", "Landroid/content/Context;", "getContext$android_sdk_base_release", "()Landroid/content/Context;", "getContext$android_sdk_base_release$annotations", "()V", "", "getServerTarget", "()Ljava/lang/String;", "getServerTarget$annotations", "serverTarget", "", "isEphemeralEventsEnabled", "()Z", "", "getEphemeralEventKeys", "()Ljava/util/Set;", "ephemeralEventKeys", "getBaseUrlForRequests", "baseUrlForRequests", "Lbo/app/i;", "getBrazeApiKey", "()Lbo/app/i;", "brazeApiKey", "isAdmMessagingRegistrationEnabled", "isLocationCollectionEnabled", "isGeofencesEnabled", "", "getSmallNotificationIconResourceId", "()I", "smallNotificationIconResourceId", "getLargeNotificationIconResourceId", "largeNotificationIconResourceId", "", "getTriggerActionMinimumTimeIntervalInSeconds", "()J", "triggerActionMinimumTimeIntervalInSeconds", "getSessionTimeoutSeconds", "sessionTimeoutSeconds", "getVersionCode", "getVersionCode$annotations", "versionCode", "getCustomEndpoint", "customEndpoint", "getDoesHandlePushDeepLinksAutomatically", "doesHandlePushDeepLinksAutomatically", "isNewsfeedVisualIndicatorOn", "getDefaultNotificationChannelName", "defaultNotificationChannelName", "getDefaultNotificationChannelDescription", "defaultNotificationChannelDescription", "getApplicationIconResourceId", "applicationIconResourceId", "getDefaultNotificationAccentColor", "getDefaultNotificationAccentColor$annotations", "defaultNotificationAccentColor", "Lcom/appboy/enums/SdkFlavor;", "getSdkFlavor", "()Lcom/appboy/enums/SdkFlavor;", "sdkFlavor", "isPushDeepLinkBackStackActivityEnabled", "getPushDeepLinkBackStackActivityClassName", "pushDeepLinkBackStackActivityClassName", "isSessionStartBasedTimeoutEnabled", "isFirebaseCloudMessagingRegistrationEnabled", "isContentCardsUnreadVisualIndicatorEnabled", "getFirebaseCloudMessagingSenderIdKey", "firebaseCloudMessagingSenderIdKey", "Lcom/appboy/enums/DeviceKey;", "getDeviceObjectWhitelist", "()Ljava/util/EnumSet;", "deviceObjectWhitelist", "getDeviceObjectAllowlist", "deviceObjectAllowlist", "isDeviceObjectWhitelistEnabled", "isDeviceObjectAllowlistEnabled", "isInAppMessageAccessibilityExclusiveModeEnabled", "isPushWakeScreenForNotificationEnabled", "isPushNotificationHtmlRenderingEnabled", "isInAppMessageTestPushEagerDisplayEnabled", "isAutomaticGeofenceRequestsEnabled", "getLoggerInitialLogLevel", "loggerInitialLogLevel", "getCustomHtmlWebViewActivityClassName", "customHtmlWebViewActivityClassName", "getInAppMessageWebViewClientOnPageFinishedMaxWaitMs", "inAppMessageWebViewClientOnPageFinishedMaxWaitMs", "Lcom/appboy/enums/LocationProviderName;", "getCustomLocationProviderNames", "customLocationProviderNames", "isFirebaseMessagingServiceOnNewTokenRegistrationEnabled", "isSdkAuthenticationEnabled", "isTouchModeRequiredForHtmlInAppMessages", "isHtmlInAppMessageApplyWindowInsetsEnabled", "Lcom/braze/enums/BrazeSdkMetadata;", "getSdkMetadata", "sdkMetadata", "<init>", "(Landroid/content/Context;)V", "Companion", "a", "b", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
public class BrazeConfigurationProvider extends CachedConfigurationProvider {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final int DEFAULT_IN_APP_MESSAGE_WEBVIEW_ONPAGEFINISHED_WAIT_MS = ((int) TimeUnit.SECONDS.toMillis(15));
    public static final String DEFAULT_NOTIFICATION_CHANNEL_DESCRIPTION_DEFAULT_VALUE = "";
    public static final String DEFAULT_NOTIFICATION_CHANNEL_NAME_DEFAULT_VALUE = "General";
    private static final int DEFAULT_SESSION_TIMEOUT_SECONDS = 10;
    private static final int DEFAULT_TRIGGER_MINIMUM_INTERVAL = 30;
    public static final int MAX_ALLOWED_EPHEMERAL_EVENTS = 12;
    private final Context context;

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006XT¢\u0006\f\n\u0004\b\b\u0010\t\u0012\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u00020\u00078\u0006XT¢\u0006\f\n\u0004\b\u000b\u0010\t\u0012\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0006XT¢\u0006\f\n\u0004\b\u000f\u0010\u0004\u0012\u0004\b\u0010\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/braze/configuration/BrazeConfigurationProvider$a;", "", "", "DEFAULT_IN_APP_MESSAGE_WEBVIEW_ONPAGEFINISHED_WAIT_MS", "I", "getDEFAULT_IN_APP_MESSAGE_WEBVIEW_ONPAGEFINISHED_WAIT_MS$annotations", "()V", "", "DEFAULT_NOTIFICATION_CHANNEL_DESCRIPTION_DEFAULT_VALUE", "Ljava/lang/String;", "getDEFAULT_NOTIFICATION_CHANNEL_DESCRIPTION_DEFAULT_VALUE$annotations", "DEFAULT_NOTIFICATION_CHANNEL_NAME_DEFAULT_VALUE", "getDEFAULT_NOTIFICATION_CHANNEL_NAME_DEFAULT_VALUE$annotations", "DEFAULT_SESSION_TIMEOUT_SECONDS", "DEFAULT_TRIGGER_MINIMUM_INTERVAL", "MAX_ALLOWED_EPHEMERAL_EVENTS", "getMAX_ALLOWED_EPHEMERAL_EVENTS$annotations", "<init>", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/braze/configuration/BrazeConfigurationProvider$b;", "", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "key", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0})
    public enum b {
        EPHEMERAL_EVENTS_ENABLED("com_braze_ephemeral_events_enabled"),
        EPHEMERAL_EVENTS_KEYS("com_braze_ephemeral_events_keys"),
        API_KEY("com_braze_api_key"),
        SERVER_TARGET_KEY("com_braze_server_target"),
        ADM_MESSAGING_REGISTRATION_ENABLED_KEY("com_braze_push_adm_messaging_registration_enabled"),
        SMALL_NOTIFICATION_ICON_KEY("com_braze_push_small_notification_icon"),
        LARGE_NOTIFICATION_ICON_KEY("com_braze_push_large_notification_icon"),
        SESSION_TIMEOUT_KEY("com_braze_session_timeout"),
        ENABLE_LOCATION_COLLECTION_KEY("com_braze_enable_location_collection"),
        DEFAULT_NOTIFICATION_ACCENT_COLOR_KEY("com_braze_default_notification_accent_color"),
        TRIGGER_ACTION_MINIMUM_TIME_INTERVAL_KEY_SECONDS("com_braze_trigger_action_minimum_time_interval_seconds"),
        HANDLE_PUSH_DEEP_LINKS_AUTOMATICALLY("com_braze_handle_push_deep_links_automatically"),
        NEWSFEED_UNREAD_VISUAL_INDICATOR_ON("com_braze_newsfeed_unread_visual_indicator_on"),
        SDK_FLAVOR("com_braze_sdk_flavor"),
        CUSTOM_ENDPOINT("com_braze_custom_endpoint"),
        DEFAULT_NOTIFICATION_CHANNEL_NAME("com_braze_default_notification_channel_name"),
        DEFAULT_NOTIFICATION_CHANNEL_DESCRIPTION("com_braze_default_notification_channel_description"),
        PUSH_DEEP_LINK_BACK_STACK_ACTIVITY_ENABLED_KEY("com_braze_push_deep_link_back_stack_activity_enabled"),
        PUSH_DEEP_LINK_BACK_STACK_ACTIVITY_CLASS_NAME_KEY("com_braze_push_deep_link_back_stack_activity_class_name"),
        SESSION_START_BASED_TIMEOUT_ENABLED_KEY("com_braze_session_start_based_timeout_enabled"),
        FIREBASE_CLOUD_MESSAGING_REGISTRATION_ENABLED_KEY("com_braze_firebase_cloud_messaging_registration_enabled"),
        FIREBASE_CLOUD_MESSAGING_SENDER_ID_KEY("com_braze_firebase_cloud_messaging_sender_id"),
        CONTENT_CARDS_UNREAD_VISUAL_INDICATOR_ENABLED("com_braze_content_cards_unread_visual_indicator_enabled"),
        DEVICE_OBJECT_ALLOWLISTING_ENABLED_KEY("com_braze_device_object_whitelisting_enabled"),
        DEVICE_OBJECT_ALLOWLIST_VALUE("com_braze_device_object_whitelist"),
        IN_APP_MESSAGE_ACCESSIBILITY_EXCLUSIVE_MODE_ENABLED("com_braze_device_in_app_message_accessibility_exclusive_mode_enabled"),
        PUSH_WAKE_SCREEN_FOR_NOTIFICATION_ENABLED("com_braze_push_wake_screen_for_notification_enabled"),
        PUSH_NOTIFICATION_HTML_RENDERING_ENABLED("com_braze_push_notification_html_rendering_enabled"),
        GEOFENCES_ENABLED("com_braze_geofences_enabled"),
        IN_APP_MESSAGE_PUSH_TEST_EAGER_DISPLAY("com_braze_in_app_message_push_test_eager_display_enabled"),
        LOGGER_INITIAL_LOG_LEVEL("com_braze_logger_initial_log_level"),
        CUSTOM_HTML_WEBVIEW_ACTIVITY_CLASS_NAME_KEY("com_braze_custom_html_webview_activity_class_name"),
        GEOFENCES_AUTOMATIC_REQUESTS_ENABLED_KEY("com_braze_automatic_geofence_requests_enabled"),
        CUSTOM_LOCATION_PROVIDERS_LIST_KEY("com_braze_custom_location_providers_list"),
        IN_APP_MESSAGE_WEBVIEW_CLIENT_MAX_ONPAGEFINISHED_WAIT_KEY("com_braze_in_app_message_webview_client_max_onpagefinished_wait_ms"),
        FIREBASE_MESSAGING_SERVICE_AUTOMATICALLY_REGISTER_ON_NEW_TOKEN_KEY("com_braze_firebase_messaging_service_automatically_register_on_new_token"),
        SDK_AUTH_ENABLED("com_braze_sdk_authentication_enabled"),
        REQUIRE_TOUCH_MODE_FOR_HTML_IAMS_KEY("com_braze_require_touch_mode_for_html_in_app_messages"),
        DATA_SYNC_BAD_NETWORK_INTERVAL_KEY("com_braze_data_flush_interval_bad_network"),
        DATA_SYNC_GOOD_NETWORK_INTERVAL_KEY("com_braze_data_flush_interval_good_network"),
        DATA_SYNC_GREAT_NETWORK_INTERVAL_KEY("com_braze_data_flush_interval_great_network"),
        SDK_METADATA_INTERNAL_KEY("com_braze_internal_sdk_metadata"),
        SDK_METADATA_PUBLIC_KEY("com_braze_sdk_metadata"),
        HTML_IN_APP_MESSAGE_APPLY_WINDOW_INSETS("com_braze_html_in_app_message_apply_insets");
        

        /* renamed from: b  reason: collision with root package name */
        private final String f43681b;

        private b(String str) {
            this.f43681b = str;
        }

        public final String b() {
            return this.f43681b;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43682g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(0);
            this.f43682g = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return Intrinsics.stringPlus("Couldn't find application icon for package: ", this.f43682g);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class d extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final d f43683b = new d();

        public d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "****************************************************";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class e extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final e f43684b = new e();

        public e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Found an override api key. Using it to configure the Braze SDK";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class f extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final f f43685b = new f();

        public f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "****************************************************";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class g extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final g f43686b = new g();

        public g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "**                                                **";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class h extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final h f43687b = new h();

        public h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "**                 !! WARNING !!                  **";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class i extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final i f43688b = new i();

        public i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "**                                                **";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class j extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final j f43689b = new j();

        public j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "**     No API key set in res/values/braze.xml     **";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class k extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final k f43690b = new k();

        public k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "** No cached API Key found from Braze.configure   **";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class l extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final l f43691b = new l();

        public l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "**          Braze functionality disabled          **";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class m extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final m f43692b = new m();

        public m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "**                                                **";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class n extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final n f43693b = new n();

        public n() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Using default notification accent color found in resources";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class o extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final o f43694b = new o();

        public o() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "More than 12 ephemeral/graylisted events detected. Only using first 12 events. Please truncate this list!";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class p extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final p f43695b = new p();

        public p() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Exception while parsing stored SDK flavor. Returning null.";
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    public static final class q extends Lambda implements Function0<String> {

        /* renamed from: b  reason: collision with root package name */
        public static final q f43696b = new q();

        public q() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unable to read the version code.";
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrazeConfigurationProvider(Context context2) {
        super(context2, false, (RuntimeAppConfigurationProvider) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context2, "context");
        Context applicationContext = context2.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.context = applicationContext;
    }

    public static /* synthetic */ void getContext$android_sdk_base_release$annotations() {
    }

    public static /* synthetic */ void getDefaultNotificationAccentColor$annotations() {
    }

    private final <E extends Enum<E>> EnumSet<E> getGenericEnumSetFromStringSet(Class<E> cls, b bVar) {
        String b11 = bVar.b();
        if (getConfigurationCache().containsKey(b11)) {
            Object obj = getConfigurationCache().get(b11);
            if (obj != null) {
                return (EnumSet) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.util.EnumSet<E of com.braze.configuration.BrazeConfigurationProvider.getGenericEnumSetFromStringSet>");
        }
        Set stringSetValue = getStringSetValue(bVar.b(), new HashSet());
        if (stringSetValue == null) {
            stringSetValue = new HashSet();
        }
        EnumSet<E> a11 = u0.a(cls, (Set<String>) stringSetValue);
        getConfigurationCache().put(b11, a11);
        return a11;
    }

    private final String getServerTarget() {
        String stringValue = getStringValue(b.SERVER_TARGET_KEY.b(), "PROD");
        return stringValue == null ? "PROD" : stringValue;
    }

    private static /* synthetic */ void getServerTarget$annotations() {
    }

    public static /* synthetic */ void getVersionCode$annotations() {
    }

    public final void clear() {
        getConfigurationCache().clear();
        getRuntimeAppConfigurationProvider().getStorageMap().edit().clear().apply();
    }

    public final int getApplicationIconResourceId() {
        int i11;
        ApplicationInfo applicationInfo;
        if (getConfigurationCache().containsKey("application_icon")) {
            Object obj = getConfigurationCache().get("application_icon");
            if (obj != null) {
                return ((Integer) obj).intValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        String packageName = this.context.getPackageName();
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                applicationInfo = this.context.getPackageManager().getApplicationInfo(packageName, PackageManager.ApplicationInfoFlags.of(0));
            } else {
                applicationInfo = this.context.getPackageManager().getApplicationInfo(packageName, 0);
            }
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "if (Build.VERSION.SDK_IN… 0)\n                    }");
            i11 = applicationInfo.icon;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new c(packageName), 4, (Object) null);
            i11 = 0;
        }
        getConfigurationCache().put("application_icon", Integer.valueOf(i11));
        return i11;
    }

    public final String getBaseUrlForRequests() {
        String serverTarget = getServerTarget();
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
        String upperCase = serverTarget.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return Intrinsics.areEqual((Object) "STAGING", (Object) upperCase) ? "https://sondheim.braze.com/api/v3/" : "https://sdk.iad-01.braze.com/api/v3/";
    }

    public final bo.app.i getBrazeApiKey() {
        String b11 = b.API_KEY.b();
        String str = (String) getConfigurationCache().get(b11);
        if (str == null) {
            str = getRuntimeAppConfigurationProvider().getStringValue(b11, (String) null);
            if (str != null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) e.f43684b, 6, (Object) null);
            } else {
                str = getStringValue(b11, (String) null);
            }
            if (str != null) {
                getConfigurationCache().put(b11, str);
            }
        }
        if (str != null) {
            return new bo.app.i(str);
        }
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger brazeLogger2 = brazeLogger;
        BrazeLogger.Priority priority = BrazeLogger.Priority.W;
        BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) f.f43685b, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) g.f43686b, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) h.f43687b, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) i.f43688b, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) j.f43689b, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) k.f43690b, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) l.f43691b, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) m.f43692b, 6, (Object) null);
        BrazeLogger.brazelog$default(brazeLogger2, (Object) this, priority, (Throwable) null, false, (Function0) d.f43683b, 6, (Object) null);
        throw new RuntimeException("Unable to read the Braze API key from the res/values/braze.xml file or from runtime configuration via BrazeConfig. See log for more details.");
    }

    public final Context getContext$android_sdk_base_release() {
        return this.context;
    }

    public final String getCustomEndpoint() {
        return getStringValue(b.CUSTOM_ENDPOINT.b(), (String) null);
    }

    public final String getCustomHtmlWebViewActivityClassName() {
        return getStringValue(b.CUSTOM_HTML_WEBVIEW_ACTIVITY_CLASS_NAME_KEY.b(), "");
    }

    public final EnumSet<LocationProviderName> getCustomLocationProviderNames() {
        return getGenericEnumSetFromStringSet(LocationProviderName.class, b.CUSTOM_LOCATION_PROVIDERS_LIST_KEY);
    }

    public final int getDefaultNotificationAccentColor() {
        Integer colorValue = getColorValue(b.DEFAULT_NOTIFICATION_ACCENT_COLOR_KEY.b());
        if (colorValue == null) {
            return 0;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) n.f43693b, 7, (Object) null);
        return colorValue.intValue();
    }

    public final String getDefaultNotificationChannelDescription() {
        String stringValue = getStringValue(b.DEFAULT_NOTIFICATION_CHANNEL_DESCRIPTION.b(), "");
        if (stringValue == null) {
            return "";
        }
        return stringValue;
    }

    public final String getDefaultNotificationChannelName() {
        String stringValue = getStringValue(b.DEFAULT_NOTIFICATION_CHANNEL_NAME.b(), DEFAULT_NOTIFICATION_CHANNEL_NAME_DEFAULT_VALUE);
        if (stringValue == null) {
            return DEFAULT_NOTIFICATION_CHANNEL_NAME_DEFAULT_VALUE;
        }
        return stringValue;
    }

    public final EnumSet<DeviceKey> getDeviceObjectAllowlist() {
        return getGenericEnumSetFromStringSet(DeviceKey.class, b.DEVICE_OBJECT_ALLOWLIST_VALUE);
    }

    @Deprecated(message = "Use {@link #getDeviceObjectAllowList()}", replaceWith = @ReplaceWith(expression = "getDeviceObjectAllowlist", imports = {}))
    public final EnumSet<DeviceKey> getDeviceObjectWhitelist() {
        return getDeviceObjectAllowlist();
    }

    public final boolean getDoesHandlePushDeepLinksAutomatically() {
        return getBooleanValue(b.HANDLE_PUSH_DEEP_LINKS_AUTOMATICALLY.b(), false);
    }

    public final Set<String> getEphemeralEventKeys() {
        Set<String> stringSetValue = getStringSetValue(b.EPHEMERAL_EVENTS_KEYS.b(), SetsKt__SetsKt.emptySet());
        if (stringSetValue == null) {
            stringSetValue = SetsKt__SetsKt.emptySet();
        }
        if (stringSetValue.size() > 12) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) o.f43694b, 6, (Object) null);
        }
        return CollectionsKt___CollectionsKt.toSet(CollectionsKt___CollectionsKt.take(stringSetValue, 12));
    }

    public final String getFirebaseCloudMessagingSenderIdKey() {
        return getStringValue(b.FIREBASE_CLOUD_MESSAGING_SENDER_ID_KEY.b(), (String) null);
    }

    public final int getInAppMessageWebViewClientOnPageFinishedMaxWaitMs() {
        return getIntValue(b.IN_APP_MESSAGE_WEBVIEW_CLIENT_MAX_ONPAGEFINISHED_WAIT_KEY.b(), DEFAULT_IN_APP_MESSAGE_WEBVIEW_ONPAGEFINISHED_WAIT_MS);
    }

    public final int getLargeNotificationIconResourceId() {
        return getDrawableValue(b.LARGE_NOTIFICATION_ICON_KEY.b(), 0);
    }

    public final int getLoggerInitialLogLevel() {
        return getIntValue(b.LOGGER_INITIAL_LOG_LEVEL.b(), 4);
    }

    public final String getPushDeepLinkBackStackActivityClassName() {
        return getStringValue(b.PUSH_DEEP_LINK_BACK_STACK_ACTIVITY_CLASS_NAME_KEY.b(), "");
    }

    public final SdkFlavor getSdkFlavor() {
        boolean z11;
        String stringValue = getStringValue(b.SDK_FLAVOR.b(), (String) null);
        if (stringValue == null || StringsKt__StringsJVMKt.isBlank(stringValue)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return null;
        }
        try {
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
            String upperCase = stringValue.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            return SdkFlavor.valueOf(upperCase);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) p.f43695b, 4, (Object) null);
            return null;
        }
    }

    public final EnumSet<BrazeSdkMetadata> getSdkMetadata() {
        String b11 = b.SDK_METADATA_INTERNAL_KEY.b();
        CachedConfigurationProvider.b bVar = CachedConfigurationProvider.b.STRING_ARRAY;
        Object resourceConfigurationValue = getResourceConfigurationValue(bVar, b11, new HashSet());
        if (resourceConfigurationValue != null) {
            Set<String> asMutableSet = TypeIntrinsics.asMutableSet(resourceConfigurationValue);
            String b12 = b.SDK_METADATA_PUBLIC_KEY.b();
            Object resourceConfigurationValue2 = getResourceConfigurationValue(bVar, b12, new HashSet());
            if (resourceConfigurationValue2 != null) {
                Set set = (Set) resourceConfigurationValue2;
                Object runtimeConfigurationValue = getRuntimeConfigurationValue(bVar, b12, new HashSet());
                if (runtimeConfigurationValue != null) {
                    asMutableSet.addAll(set);
                    asMutableSet.addAll((Set) runtimeConfigurationValue);
                    u0 u0Var = u0.f39450a;
                    EnumSet<BrazeSdkMetadata> noneOf = EnumSet.noneOf(BrazeSdkMetadata.class);
                    for (String str : asMutableSet) {
                        try {
                            u0 u0Var2 = u0.f39450a;
                            Locale locale = Locale.US;
                            Intrinsics.checkNotNullExpressionValue(locale, Profile.Country.US);
                            String upperCase = str.toUpperCase(locale);
                            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                            BrazeSdkMetadata[] values = BrazeSdkMetadata.values();
                            int length = values.length;
                            int i11 = 0;
                            while (i11 < length) {
                                BrazeSdkMetadata brazeSdkMetadata = values[i11];
                                i11++;
                                if (Intrinsics.areEqual((Object) brazeSdkMetadata.name(), (Object) upperCase)) {
                                    noneOf.add(brazeSdkMetadata);
                                }
                            }
                            throw new NoSuchElementException("Array contains no element matching the predicate.");
                        } catch (Exception e11) {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) u0.f39450a, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new v0(str), 4, (Object) null);
                        }
                    }
                    Intrinsics.checkNotNullExpressionValue(noneOf, "result");
                    return noneOf;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<kotlin.String>");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableSet<kotlin.String>");
    }

    public final int getSessionTimeoutSeconds() {
        return getIntValue(b.SESSION_TIMEOUT_KEY.b(), 10);
    }

    public final int getSmallNotificationIconResourceId() {
        return getDrawableValue(b.SMALL_NOTIFICATION_ICON_KEY.b(), 0);
    }

    public final long getTriggerActionMinimumTimeIntervalInSeconds() {
        return (long) getIntValue(b.TRIGGER_ACTION_MINIMUM_TIME_INTERVAL_KEY_SECONDS.b(), 30);
    }

    public final int getVersionCode() {
        int i11;
        if (getConfigurationCache().containsKey("version_code")) {
            Object obj = getConfigurationCache().get("version_code");
            if (obj != null) {
                return ((Integer) obj).intValue();
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        try {
            i11 = this.context.getPackageManager().getPackageInfo(PackageUtils.getResourcePackageName(this.context), 0).versionCode;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) q.f43696b, 4, (Object) null);
            i11 = -1;
        }
        getConfigurationCache().put("version_code", Integer.valueOf(i11));
        return i11;
    }

    public final boolean isAdmMessagingRegistrationEnabled() {
        return getBooleanValue(b.ADM_MESSAGING_REGISTRATION_ENABLED_KEY.b(), false);
    }

    public final boolean isAutomaticGeofenceRequestsEnabled() {
        return getBooleanValue(b.GEOFENCES_AUTOMATIC_REQUESTS_ENABLED_KEY.b(), true);
    }

    public final boolean isContentCardsUnreadVisualIndicatorEnabled() {
        return getBooleanValue(b.CONTENT_CARDS_UNREAD_VISUAL_INDICATOR_ENABLED.b(), true);
    }

    public final boolean isDeviceObjectAllowlistEnabled() {
        return getBooleanValue(b.DEVICE_OBJECT_ALLOWLISTING_ENABLED_KEY.b(), false);
    }

    @Deprecated(message = "Use {@link #getIsDeviceObjectAllowlistEnabled()}")
    public final boolean isDeviceObjectWhitelistEnabled() {
        return isDeviceObjectAllowlistEnabled();
    }

    public final boolean isEphemeralEventsEnabled() {
        return getBooleanValue(b.EPHEMERAL_EVENTS_ENABLED.b(), false);
    }

    public final boolean isFirebaseCloudMessagingRegistrationEnabled() {
        return getBooleanValue(b.FIREBASE_CLOUD_MESSAGING_REGISTRATION_ENABLED_KEY.b(), false);
    }

    public final boolean isFirebaseMessagingServiceOnNewTokenRegistrationEnabled() {
        return getBooleanValue(b.FIREBASE_MESSAGING_SERVICE_AUTOMATICALLY_REGISTER_ON_NEW_TOKEN_KEY.b(), isFirebaseCloudMessagingRegistrationEnabled());
    }

    public final boolean isGeofencesEnabled() {
        return getBooleanValue(b.GEOFENCES_ENABLED.b(), isLocationCollectionEnabled());
    }

    public final boolean isHtmlInAppMessageApplyWindowInsetsEnabled() {
        return getBooleanValue(b.HTML_IN_APP_MESSAGE_APPLY_WINDOW_INSETS.b(), false);
    }

    public final boolean isInAppMessageAccessibilityExclusiveModeEnabled() {
        return getBooleanValue(b.IN_APP_MESSAGE_ACCESSIBILITY_EXCLUSIVE_MODE_ENABLED.b(), false);
    }

    public final boolean isInAppMessageTestPushEagerDisplayEnabled() {
        return getBooleanValue(b.IN_APP_MESSAGE_PUSH_TEST_EAGER_DISPLAY.b(), true);
    }

    public final boolean isLocationCollectionEnabled() {
        return getBooleanValue(b.ENABLE_LOCATION_COLLECTION_KEY.b(), false);
    }

    public final boolean isNewsfeedVisualIndicatorOn() {
        return getBooleanValue(b.NEWSFEED_UNREAD_VISUAL_INDICATOR_ON.b(), true);
    }

    public final boolean isPushDeepLinkBackStackActivityEnabled() {
        return getBooleanValue(b.PUSH_DEEP_LINK_BACK_STACK_ACTIVITY_ENABLED_KEY.b(), true);
    }

    public final boolean isPushNotificationHtmlRenderingEnabled() {
        return getBooleanValue(b.PUSH_NOTIFICATION_HTML_RENDERING_ENABLED.b(), false);
    }

    public final boolean isPushWakeScreenForNotificationEnabled() {
        return getBooleanValue(b.PUSH_WAKE_SCREEN_FOR_NOTIFICATION_ENABLED.b(), true);
    }

    public final boolean isSdkAuthenticationEnabled() {
        return getBooleanValue(b.SDK_AUTH_ENABLED.b(), false);
    }

    public final boolean isSessionStartBasedTimeoutEnabled() {
        return getBooleanValue(b.SESSION_START_BASED_TIMEOUT_ENABLED_KEY.b(), false);
    }

    public final boolean isTouchModeRequiredForHtmlInAppMessages() {
        return getBooleanValue(b.REQUIRE_TOUCH_MODE_FOR_HTML_IAMS_KEY.b(), true);
    }
}
