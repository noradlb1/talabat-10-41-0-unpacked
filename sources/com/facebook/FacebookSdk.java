package com.facebook;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.apptimize.fb;
import com.facebook.GraphRequest;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.AppEventsManager;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.internal.AppEventsLoggerUtility;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.LockOnGetVariable;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.instrument.InstrumentManager;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import k6.e;
import k6.m;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0016\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0001\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020?H\u0007J\b\u0010H\u001a\u00020FH\u0007J\b\u0010I\u001a\u00020FH\u0007J\b\u0010J\u001a\u00020*H\u0007J\b\u0010K\u001a\u00020&H\u0007J\b\u0010L\u001a\u00020\u0004H\u0007J\n\u0010M\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010N\u001a\u0004\u0018\u00010\u00042\b\u0010O\u001a\u0004\u0018\u00010&H\u0007J\b\u0010P\u001a\u00020*H\u0007J\b\u0010Q\u001a\u00020*H\u0007J\n\u0010R\u001a\u0004\u0018\u00010-H\u0007J\b\u0010S\u001a\u00020\u0016H\u0007J\b\u0010T\u001a\u00020\u0004H\u0007J\b\u0010U\u001a\u00020*H\u0007J\b\u0010V\u001a\u00020*H\u0007J\b\u0010W\u001a\u000202H\u0007J\b\u0010X\u001a\u00020\u0004H\u0007J\b\u0010Y\u001a\u00020\u0004H\u0007J\b\u0010Z\u001a\u00020\u0004H\u0007J\b\u0010[\u001a\u00020\u0004H\u0007J\b\u0010\\\u001a\u00020\u0004H\u0007J\u0010\u0010]\u001a\u00020*2\u0006\u0010O\u001a\u00020&H\u0007J\u000e\u0010^\u001a\b\u0012\u0004\u0012\u00020?0_H\u0007J\b\u0010`\u001a\u00020*H\u0007J\b\u0010a\u001a\u00020bH\u0007J\b\u0010c\u001a\u00020\u0004H\u0007J\b\u0010d\u001a\u00020*H\u0007J\u0010\u0010e\u001a\u00020*2\u0006\u0010f\u001a\u00020\u0016H\u0007J\b\u0010;\u001a\u00020*H\u0007J\b\u0010g\u001a\u00020*H\u0007J\b\u0010<\u001a\u00020*H\u0007J\u0010\u0010h\u001a\u00020*2\u0006\u0010G\u001a\u00020?H\u0007J\u0017\u0010i\u001a\u00020F2\b\u0010O\u001a\u0004\u0018\u00010&H\u0001¢\u0006\u0002\bjJ\u0018\u0010k\u001a\u00020F2\u0006\u0010O\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004H\u0003J\u0018\u0010l\u001a\u00020F2\u0006\u0010O\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0004H\u0007J\u0010\u0010m\u001a\u00020F2\u0006\u0010G\u001a\u00020?H\u0007J\u0010\u0010n\u001a\u00020F2\u0006\u0010%\u001a\u00020&H\u0007J\u001a\u0010n\u001a\u00020F2\u0006\u0010%\u001a\u00020&2\b\u0010o\u001a\u0004\u0018\u00010pH\u0007J\u0018\u0010n\u001a\u00020F2\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020\u0016H\u0007J\"\u0010n\u001a\u00020F2\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020\u00162\b\u0010o\u001a\u0004\u0018\u00010pH\u0007J\u0010\u0010q\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u0010\u0010s\u001a\u00020F2\u0006\u0010'\u001a\u00020\u0004H\u0007J\u0012\u0010t\u001a\u00020F2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010u\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u0010\u0010v\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u0010\u0010w\u001a\u00020F2\u0006\u0010+\u001a\u00020-H\u0007J\u0012\u0010x\u001a\u00020F2\b\u0010y\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010z\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u001d\u0010{\u001a\u00020F2\u000e\u0010|\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010}H\u0007¢\u0006\u0002\u0010~J/\u0010{\u001a\u00020F2\u000e\u0010|\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010}2\u0006\u0010\u001a\u00020\u00162\u0007\u0010\u0001\u001a\u00020\u0016H\u0007¢\u0006\u0003\u0010\u0001J\u0011\u0010\u0001\u001a\u00020F2\u0006\u00101\u001a\u000202H\u0007J\u0011\u0010\u0001\u001a\u00020F2\u0006\u00103\u001a\u00020\u0004H\u0007J\u0011\u0010\u0001\u001a\u00020F2\u0006\u00104\u001a\u00020\u0004H\u0007J\u0017\u0010\u0001\u001a\u00020F2\u0006\u00105\u001a\u000206H\u0001¢\u0006\u0003\b\u0001J\u0012\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020*H\u0007J\u0012\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020*H\u0007J\u001a\u0010\u0001\u001a\u00020F2\u0006\u0010O\u001a\u00020&2\u0007\u0010\u0001\u001a\u00020*H\u0007J\u0011\u0010\u0001\u001a\u00020F2\u0006\u0010r\u001a\u00020*H\u0007J\u0012\u0010\u0001\u001a\u00020F2\u0007\u0010\u0001\u001a\u00020bH\u0007J\t\u0010\u0001\u001a\u00020FH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0016XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n \"*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010/\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u000e¢\u0006\u0002\n\u0000R\u0012\u00107\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u00108\u001a\u00020*8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010=\u001a\u0012\u0012\u0004\u0012\u00020?0>j\b\u0012\u0004\u0012\u00020?`@X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/facebook/FacebookSdk;", "", "()V", "ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY", "", "APPLICATION_ID_PROPERTY", "APPLICATION_NAME_PROPERTY", "APP_EVENT_PREFERENCES", "ATTRIBUTION_PREFERENCES", "AUTO_INIT_ENABLED_PROPERTY", "AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY", "CALLBACK_OFFSET_CHANGED_AFTER_INIT", "CALLBACK_OFFSET_NEGATIVE", "CALLBACK_OFFSET_PROPERTY", "CLIENT_TOKEN_PROPERTY", "CLOUDBRIDGE_SAVED_CREDENTIALS", "CODELESS_DEBUG_LOG_ENABLED_PROPERTY", "DATA_PROCESSING_OPTIONS_PREFERENCES", "DATA_PROCESSION_OPTIONS", "DATA_PROCESSION_OPTIONS_COUNTRY", "DATA_PROCESSION_OPTIONS_STATE", "DEFAULT_CALLBACK_REQUEST_CODE_OFFSET", "", "FACEBOOK_COM", "FB_GG", "GAMING", "INSTAGRAM", "INSTAGRAM_COM", "LOCK", "Ljava/util/concurrent/locks/ReentrantLock;", "MAX_REQUEST_CODE_RANGE", "MONITOR_ENABLED_PROPERTY", "PUBLISH_ACTIVITY_PATH", "TAG", "kotlin.jvm.PlatformType", "WEB_DIALOG_THEME", "appClientToken", "applicationContext", "Landroid/content/Context;", "applicationId", "applicationName", "bypassAppSwitch", "", "cacheDir", "Lcom/facebook/internal/LockOnGetVariable;", "Ljava/io/File;", "callbackRequestCodeOffset", "codelessDebugLogEnabled", "Ljava/lang/Boolean;", "executor", "Ljava/util/concurrent/Executor;", "facebookDomain", "graphApiVersion", "graphRequestCreator", "Lcom/facebook/FacebookSdk$GraphRequestCreator;", "hasCustomTabsPrefetching", "ignoreAppSwitchToLoggedOut", "instagramDomain", "isDebugEnabledField", "isFullyInitialized", "isLegacyTokenUpgradeSupported", "loggingBehaviors", "Ljava/util/HashSet;", "Lcom/facebook/LoggingBehavior;", "Lkotlin/collections/HashSet;", "onProgressThreshold", "Ljava/util/concurrent/atomic/AtomicLong;", "sdkInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "addLoggingBehavior", "", "behavior", "clearLoggingBehaviors", "fullyInitialize", "getAdvertiserIDCollectionEnabled", "getApplicationContext", "getApplicationId", "getApplicationName", "getApplicationSignature", "context", "getAutoInitEnabled", "getAutoLogAppEventsEnabled", "getCacheDir", "getCallbackRequestCodeOffset", "getClientToken", "getCodelessDebugLogEnabled", "getCodelessSetupEnabled", "getExecutor", "getFacebookDomain", "getFacebookGamingDomain", "getGraphApiVersion", "getGraphDomain", "getInstagramDomain", "getLimitEventAndDataUsage", "getLoggingBehaviors", "", "getMonitorEnabled", "getOnProgressThreshold", "", "getSdkVersion", "isDebugEnabled", "isFacebookRequestCode", "requestCode", "isInitialized", "isLoggingBehaviorEnabled", "loadDefaultsFromMetadata", "loadDefaultsFromMetadata$facebook_core_release", "publishInstallAndWaitForResponse", "publishInstallAsync", "removeLoggingBehavior", "sdkInitialize", "callback", "Lcom/facebook/FacebookSdk$InitializeCallback;", "setAdvertiserIDCollectionEnabled", "flag", "setApplicationId", "setApplicationName", "setAutoInitEnabled", "setAutoLogAppEventsEnabled", "setCacheDir", "setClientToken", "clientToken", "setCodelessDebugLogEnabled", "setDataProcessingOptions", "options", "", "([Ljava/lang/String;)V", "country", "state", "([Ljava/lang/String;II)V", "setExecutor", "setFacebookDomain", "setGraphApiVersion", "setGraphRequestCreator", "setGraphRequestCreator$facebook_core_release", "setIsDebugEnabled", "enabled", "setLegacyTokenUpgradeSupported", "supported", "setLimitEventAndDataUsage", "limitEventUsage", "setMonitorEnabled", "setOnProgressThreshold", "threshold", "updateGraphDebugBehavior", "GraphRequestCreator", "InitializeCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class FacebookSdk {
    @NotNull
    public static final String ADVERTISER_ID_COLLECTION_ENABLED_PROPERTY = "com.facebook.sdk.AdvertiserIDCollectionEnabled";
    @NotNull
    public static final String APPLICATION_ID_PROPERTY = "com.facebook.sdk.ApplicationId";
    @NotNull
    public static final String APPLICATION_NAME_PROPERTY = "com.facebook.sdk.ApplicationName";
    @NotNull
    public static final String APP_EVENT_PREFERENCES = "com.facebook.sdk.appEventPreferences";
    @NotNull
    private static final String ATTRIBUTION_PREFERENCES = "com.facebook.sdk.attributionTracking";
    @NotNull
    public static final String AUTO_INIT_ENABLED_PROPERTY = "com.facebook.sdk.AutoInitEnabled";
    @NotNull
    public static final String AUTO_LOG_APP_EVENTS_ENABLED_PROPERTY = "com.facebook.sdk.AutoLogAppEventsEnabled";
    @NotNull
    public static final String CALLBACK_OFFSET_CHANGED_AFTER_INIT = "The callback request code offset can't be updated once the SDK is initialized. Call FacebookSdk.setCallbackRequestCodeOffset inside your Application.onCreate method";
    @NotNull
    public static final String CALLBACK_OFFSET_NEGATIVE = "The callback request code offset can't be negative.";
    @NotNull
    public static final String CALLBACK_OFFSET_PROPERTY = "com.facebook.sdk.CallbackOffset";
    @NotNull
    public static final String CLIENT_TOKEN_PROPERTY = "com.facebook.sdk.ClientToken";
    @NotNull
    public static final String CLOUDBRIDGE_SAVED_CREDENTIALS = "com.facebook.sdk.CloudBridgeSavedCredentials";
    @NotNull
    public static final String CODELESS_DEBUG_LOG_ENABLED_PROPERTY = "com.facebook.sdk.CodelessDebugLogEnabled";
    @NotNull
    public static final String DATA_PROCESSING_OPTIONS_PREFERENCES = "com.facebook.sdk.DataProcessingOptions";
    @NotNull
    public static final String DATA_PROCESSION_OPTIONS = "data_processing_options";
    @NotNull
    public static final String DATA_PROCESSION_OPTIONS_COUNTRY = "data_processing_options_country";
    @NotNull
    public static final String DATA_PROCESSION_OPTIONS_STATE = "data_processing_options_state";
    private static final int DEFAULT_CALLBACK_REQUEST_CODE_OFFSET = 64206;
    @NotNull
    public static final String FACEBOOK_COM = "facebook.com";
    @NotNull
    public static final String FB_GG = "fb.gg";
    @NotNull
    public static final String GAMING = "gaming";
    @NotNull
    public static final String INSTAGRAM = "instagram";
    @NotNull
    public static final String INSTAGRAM_COM = "instagram.com";
    @NotNull
    public static final FacebookSdk INSTANCE = new FacebookSdk();
    @NotNull
    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final int MAX_REQUEST_CODE_RANGE = 100;
    @NotNull
    public static final String MONITOR_ENABLED_PROPERTY = "com.facebook.sdk.MonitorEnabled";
    @NotNull
    private static final String PUBLISH_ACTIVITY_PATH = "%s/activities";
    private static final String TAG = FacebookSdk.class.getCanonicalName();
    @NotNull
    public static final String WEB_DIALOG_THEME = "com.facebook.sdk.WebDialogTheme";
    @Nullable
    private static volatile String appClientToken;
    private static Context applicationContext;
    @Nullable
    private static volatile String applicationId;
    @Nullable
    private static volatile String applicationName;
    @JvmField
    public static boolean bypassAppSwitch;
    private static LockOnGetVariable<File> cacheDir;
    private static int callbackRequestCodeOffset = DEFAULT_CALLBACK_REQUEST_CODE_OFFSET;
    @Nullable
    private static volatile Boolean codelessDebugLogEnabled;
    @Nullable
    private static Executor executor;
    @NotNull
    private static volatile String facebookDomain = "facebook.com";
    @NotNull
    private static String graphApiVersion = ServerProtocol.getDefaultAPIVersion();
    @NotNull
    private static GraphRequestCreator graphRequestCreator = new m();
    @JvmField
    public static boolean hasCustomTabsPrefetching;
    @JvmField
    public static boolean ignoreAppSwitchToLoggedOut;
    @NotNull
    private static volatile String instagramDomain = INSTAGRAM_COM;
    private static volatile boolean isDebugEnabledField;
    private static boolean isFullyInitialized;
    private static boolean isLegacyTokenUpgradeSupported;
    @NotNull
    private static final HashSet<LoggingBehavior> loggingBehaviors = SetsKt__SetsKt.hashSetOf(LoggingBehavior.DEVELOPER_ERRORS);
    @NotNull
    private static AtomicLong onProgressThreshold = new AtomicLong(PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
    @NotNull
    private static final AtomicBoolean sdkInitialized = new AtomicBoolean(false);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bá\u0001\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&¨\u0006\f"}, d2 = {"Lcom/facebook/FacebookSdk$GraphRequestCreator;", "", "createPostRequest", "Lcom/facebook/GraphRequest;", "accessToken", "Lcom/facebook/AccessToken;", "publishUrl", "", "publishParams", "Lorg/json/JSONObject;", "callback", "Lcom/facebook/GraphRequest$Callback;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @VisibleForTesting
    public interface GraphRequestCreator {
        @NotNull
        GraphRequest createPostRequest(@Nullable AccessToken accessToken, @Nullable String str, @Nullable JSONObject jSONObject, @Nullable GraphRequest.Callback callback);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/facebook/FacebookSdk$InitializeCallback;", "", "onInitialized", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface InitializeCallback {
        void onInitialized();
    }

    private FacebookSdk() {
    }

    @JvmStatic
    public static final void addLoggingBehavior(@NotNull LoggingBehavior loggingBehavior) {
        Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.add(loggingBehavior);
            INSTANCE.updateGraphDebugBehavior();
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final void clearLoggingBehaviors() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @JvmStatic
    public static final void fullyInitialize() {
        isFullyInitialized = true;
    }

    @JvmStatic
    public static final boolean getAdvertiserIDCollectionEnabled() {
        return UserSettingsManager.getAdvertiserIDCollectionEnabled();
    }

    @JvmStatic
    @NotNull
    public static final Context getApplicationContext() {
        Validate.sdkInitialized();
        Context context = applicationContext;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        throw null;
    }

    @JvmStatic
    @NotNull
    public static final String getApplicationId() {
        Validate.sdkInitialized();
        String str = applicationId;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk.");
    }

    @JvmStatic
    @Nullable
    public static final String getApplicationName() {
        Validate.sdkInitialized();
        return applicationName;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.Nullable
    @com.facebook.internal.instrument.crashshield.AutoHandleExceptions
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String getApplicationSignature(@org.jetbrains.annotations.Nullable android.content.Context r3) {
        /*
            com.facebook.internal.Validate.sdkInitialized()
            r0 = 0
            if (r3 != 0) goto L_0x0007
            return r0
        L_0x0007:
            android.content.pm.PackageManager r1 = r3.getPackageManager()
            if (r1 != 0) goto L_0x000e
            return r0
        L_0x000e:
            java.lang.String r3 = r3.getPackageName()
            r2 = 64
            android.content.pm.PackageInfo r3 = r1.getPackageInfo(r3, r2)     // Catch:{ NameNotFoundException -> 0x0042 }
            android.content.pm.Signature[] r1 = r3.signatures
            if (r1 == 0) goto L_0x0042
            int r1 = r1.length
            r2 = 0
            if (r1 != 0) goto L_0x0022
            r1 = 1
            goto L_0x0023
        L_0x0022:
            r1 = r2
        L_0x0023:
            if (r1 == 0) goto L_0x0026
            goto L_0x0042
        L_0x0026:
            java.lang.String r1 = "SHA-1"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r1)     // Catch:{  }
            android.content.pm.Signature[] r3 = r3.signatures
            r3 = r3[r2]
            byte[] r3 = r3.toByteArray()
            r0.update(r3)
            byte[] r3 = r0.digest()
            r0 = 9
            java.lang.String r3 = android.util.Base64.encodeToString(r3, r0)
            return r3
        L_0x0042:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.getApplicationSignature(android.content.Context):java.lang.String");
    }

    @JvmStatic
    public static final boolean getAutoInitEnabled() {
        return UserSettingsManager.getAutoInitEnabled();
    }

    @JvmStatic
    public static final boolean getAutoLogAppEventsEnabled() {
        return UserSettingsManager.getAutoLogAppEventsEnabled();
    }

    @JvmStatic
    @Nullable
    public static final File getCacheDir() {
        Validate.sdkInitialized();
        LockOnGetVariable<File> lockOnGetVariable = cacheDir;
        if (lockOnGetVariable != null) {
            return lockOnGetVariable.getValue();
        }
        Intrinsics.throwUninitializedPropertyAccessException("cacheDir");
        throw null;
    }

    @JvmStatic
    public static final int getCallbackRequestCodeOffset() {
        Validate.sdkInitialized();
        return callbackRequestCodeOffset;
    }

    @JvmStatic
    @NotNull
    public static final String getClientToken() {
        Validate.sdkInitialized();
        String str = appClientToken;
        if (str != null) {
            return str;
        }
        throw new FacebookException("A valid Facebook client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk. Visit https://developers.facebook.com/docs/android/getting-started#add-app_id for more information.");
    }

    @JvmStatic
    public static final boolean getCodelessDebugLogEnabled() {
        Validate.sdkInitialized();
        Boolean bool = codelessDebugLogEnabled;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @JvmStatic
    public static final boolean getCodelessSetupEnabled() {
        return UserSettingsManager.getCodelessSetupEnabled();
    }

    /* JADX INFO: finally extract failed */
    @JvmStatic
    @NotNull
    public static final Executor getExecutor() {
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            if (executor == null) {
                executor = AsyncTask.THREAD_POOL_EXECUTOR;
            }
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            Executor executor2 = executor;
            if (executor2 != null) {
                return executor2;
            }
            throw new IllegalStateException("Required value was null.".toString());
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @JvmStatic
    @NotNull
    public static final String getFacebookDomain() {
        return facebookDomain;
    }

    @JvmStatic
    @NotNull
    public static final String getFacebookGamingDomain() {
        return FB_GG;
    }

    @JvmStatic
    @NotNull
    public static final String getGraphApiVersion() {
        Utility utility = Utility.INSTANCE;
        String str = TAG;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("getGraphApiVersion: %s", Arrays.copyOf(new Object[]{graphApiVersion}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        Utility.logd(str, format);
        return graphApiVersion;
    }

    @JvmStatic
    @NotNull
    public static final String getGraphDomain() {
        String str;
        AccessToken currentAccessToken = AccessToken.Companion.getCurrentAccessToken();
        if (currentAccessToken != null) {
            str = currentAccessToken.getGraphDomain();
        } else {
            str = null;
        }
        return Utility.getGraphDomainFromTokenDomain(str);
    }

    @JvmStatic
    @NotNull
    public static final String getInstagramDomain() {
        return instagramDomain;
    }

    @JvmStatic
    public static final boolean getLimitEventAndDataUsage(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Validate.sdkInitialized();
        return context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).getBoolean("limitEventUsage", false);
    }

    @JvmStatic
    @NotNull
    public static final Set<LoggingBehavior> getLoggingBehaviors() {
        Set<LoggingBehavior> unmodifiableSet;
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            unmodifiableSet = Collections.unmodifiableSet(new HashSet(hashSet));
            Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "unmodifiableSet(HashSet(loggingBehaviors))");
        }
        return unmodifiableSet;
    }

    @JvmStatic
    public static final boolean getMonitorEnabled() {
        return UserSettingsManager.getMonitorEnabled();
    }

    @JvmStatic
    public static final long getOnProgressThreshold() {
        Validate.sdkInitialized();
        return onProgressThreshold.get();
    }

    @JvmStatic
    @NotNull
    public static final String getSdkVersion() {
        return FacebookSdkVersion.BUILD;
    }

    /* access modifiers changed from: private */
    /* renamed from: graphRequestCreator$lambda-0  reason: not valid java name */
    public static final GraphRequest m8861graphRequestCreator$lambda0(AccessToken accessToken, String str, JSONObject jSONObject, GraphRequest.Callback callback) {
        return GraphRequest.Companion.newPostRequest(accessToken, str, jSONObject, callback);
    }

    @JvmStatic
    public static final boolean isDebugEnabled() {
        return isDebugEnabledField;
    }

    @JvmStatic
    public static final boolean isFacebookRequestCode(int i11) {
        int i12 = callbackRequestCodeOffset;
        return i11 >= i12 && i11 < i12 + 100;
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final synchronized boolean isFullyInitialized() {
        boolean z11;
        synchronized (FacebookSdk.class) {
            z11 = isFullyInitialized;
        }
        return z11;
    }

    @JvmStatic
    public static final boolean isInitialized() {
        return sdkInitialized.get();
    }

    @JvmStatic
    public static final boolean isLegacyTokenUpgradeSupported() {
        return isLegacyTokenUpgradeSupported;
    }

    @JvmStatic
    public static final boolean isLoggingBehaviorEnabled(@NotNull LoggingBehavior loggingBehavior) {
        boolean z11;
        Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            if (!isDebugEnabled() || !hashSet.contains(loggingBehavior)) {
                z11 = false;
            } else {
                z11 = true;
            }
        }
        return z11;
    }

    @JvmStatic
    public static final void loadDefaultsFromMetadata$facebook_core_release(@Nullable Context context) {
        if (context != null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                Intrinsics.checkNotNullExpressionValue(applicationInfo, "try {\n          context.packageManager.getApplicationInfo(\n              context.packageName, PackageManager.GET_META_DATA)\n        } catch (e: PackageManager.NameNotFoundException) {\n          return\n        }");
                if (applicationInfo.metaData != null) {
                    if (applicationId == null) {
                        Object obj = applicationInfo.metaData.get(APPLICATION_ID_PROPERTY);
                        if (obj instanceof String) {
                            String str = (String) obj;
                            Locale locale = Locale.ROOT;
                            Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                            String lowerCase = str.toLowerCase(locale);
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                            if (StringsKt__StringsJVMKt.startsWith$default(lowerCase, fb.f42395a, false, 2, (Object) null)) {
                                String substring = str.substring(2);
                                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                                applicationId = substring;
                            } else {
                                applicationId = str;
                            }
                        } else if (obj instanceof Number) {
                            throw new FacebookException("App Ids cannot be directly placed in the manifest.They must be prefixed by 'fb' or be placed in the string resource file.");
                        }
                    }
                    if (applicationName == null) {
                        applicationName = applicationInfo.metaData.getString(APPLICATION_NAME_PROPERTY);
                    }
                    if (appClientToken == null) {
                        appClientToken = applicationInfo.metaData.getString(CLIENT_TOKEN_PROPERTY);
                    }
                    if (callbackRequestCodeOffset == DEFAULT_CALLBACK_REQUEST_CODE_OFFSET) {
                        callbackRequestCodeOffset = applicationInfo.metaData.getInt(CALLBACK_OFFSET_PROPERTY, DEFAULT_CALLBACK_REQUEST_CODE_OFFSET);
                    }
                    if (codelessDebugLogEnabled == null) {
                        codelessDebugLogEnabled = Boolean.valueOf(applicationInfo.metaData.getBoolean(CODELESS_DEBUG_LOG_ENABLED_PROPERTY, false));
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
    }

    @AutoHandleExceptions
    private final void publishInstallAndWaitForResponse(Context context, String str) {
        try {
            AttributionIdentifiers attributionIdentifiers = AttributionIdentifiers.Companion.getAttributionIdentifiers(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences(ATTRIBUTION_PREFERENCES, 0);
            String stringPlus = Intrinsics.stringPlus(str, "ping");
            long j11 = sharedPreferences.getLong(stringPlus, 0);
            AppEventsLoggerUtility appEventsLoggerUtility = AppEventsLoggerUtility.INSTANCE;
            JSONObject jSONObjectForGraphAPICall = AppEventsLoggerUtility.getJSONObjectForGraphAPICall(AppEventsLoggerUtility.GraphAPIActivityType.MOBILE_INSTALL_EVENT, attributionIdentifiers, AppEventsLogger.Companion.getAnonymousAppDeviceGUID(context), getLimitEventAndDataUsage(context), context);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(PUBLISH_ACTIVITY_PATH, Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            GraphRequest createPostRequest = graphRequestCreator.createPostRequest((AccessToken) null, format, jSONObjectForGraphAPICall, (GraphRequest.Callback) null);
            if (j11 == 0 && createPostRequest.executeAndWait().getError() == null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(stringPlus, System.currentTimeMillis());
                edit.apply();
            }
        } catch (JSONException e11) {
            throw new FacebookException("An error occurred while publishing install.", (Throwable) e11);
        } catch (Exception e12) {
            Utility.logd("Facebook-publish", e12);
        }
    }

    @JvmStatic
    @VisibleForTesting(otherwise = 3)
    @AutoHandleExceptions
    public static final void publishInstallAsync(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Context applicationContext2 = context.getApplicationContext();
        if (applicationContext2 != null) {
            getExecutor().execute(new e(applicationContext2, str));
            FeatureManager featureManager = FeatureManager.INSTANCE;
            if (FeatureManager.isEnabled(FeatureManager.Feature.OnDeviceEventProcessing) && OnDeviceProcessingManager.isOnDeviceProcessingEnabled()) {
                OnDeviceProcessingManager.sendInstallEventAsync(str, ATTRIBUTION_PREFERENCES);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: publishInstallAsync$lambda-15  reason: not valid java name */
    public static final void m8862publishInstallAsync$lambda15(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "$applicationContext");
        Intrinsics.checkNotNullParameter(str, "$applicationId");
        INSTANCE.publishInstallAndWaitForResponse(context, str);
    }

    @JvmStatic
    public static final void removeLoggingBehavior(@NotNull LoggingBehavior loggingBehavior) {
        Intrinsics.checkNotNullParameter(loggingBehavior, "behavior");
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        synchronized (hashSet) {
            hashSet.remove(loggingBehavior);
        }
    }

    @JvmStatic
    @Deprecated(message = "")
    public static final synchronized void sdkInitialize(@NotNull Context context, int i11) {
        synchronized (FacebookSdk.class) {
            Intrinsics.checkNotNullParameter(context, "applicationContext");
            sdkInitialize(context, i11, (InitializeCallback) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-3  reason: not valid java name */
    public static final File m8863sdkInitialize$lambda3() {
        Context context = applicationContext;
        if (context != null) {
            return context.getCacheDir();
        }
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        throw null;
    }

    /* access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-4  reason: not valid java name */
    public static final void m8864sdkInitialize$lambda4(boolean z11) {
        if (z11) {
            InstrumentManager.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-5  reason: not valid java name */
    public static final void m8865sdkInitialize$lambda5(boolean z11) {
        if (z11) {
            AppEventsManager.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-6  reason: not valid java name */
    public static final void m8866sdkInitialize$lambda6(boolean z11) {
        if (z11) {
            hasCustomTabsPrefetching = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-7  reason: not valid java name */
    public static final void m8867sdkInitialize$lambda7(boolean z11) {
        if (z11) {
            ignoreAppSwitchToLoggedOut = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-8  reason: not valid java name */
    public static final void m8868sdkInitialize$lambda8(boolean z11) {
        if (z11) {
            bypassAppSwitch = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: sdkInitialize$lambda-9  reason: not valid java name */
    public static final Void m8869sdkInitialize$lambda9(InitializeCallback initializeCallback) {
        AccessTokenManager.Companion.getInstance().loadCurrentAccessToken();
        ProfileManager.Companion.getInstance().loadCurrentProfile();
        if (AccessToken.Companion.isCurrentAccessTokenActive()) {
            Profile.Companion companion = Profile.Companion;
            if (companion.getCurrentProfile() == null) {
                companion.fetchProfileForCurrentAccessToken();
            }
        }
        if (initializeCallback != null) {
            initializeCallback.onInitialized();
        }
        AppEventsLogger.Companion companion2 = AppEventsLogger.Companion;
        companion2.initializeLib(getApplicationContext(), applicationId);
        UserSettingsManager.logIfAutoAppLinkEnabled();
        Context applicationContext2 = getApplicationContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "getApplicationContext().applicationContext");
        companion2.newLogger(applicationContext2).flush();
        return null;
    }

    @JvmStatic
    public static final void setAdvertiserIDCollectionEnabled(boolean z11) {
        UserSettingsManager.setAdvertiserIDCollectionEnabled(z11);
    }

    @JvmStatic
    public static final void setApplicationId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "applicationId");
        Validate.notEmpty(str, "applicationId");
        applicationId = str;
    }

    @JvmStatic
    public static final void setApplicationName(@Nullable String str) {
        applicationName = str;
    }

    @JvmStatic
    public static final void setAutoInitEnabled(boolean z11) {
        UserSettingsManager.setAutoInitEnabled(z11);
        if (z11) {
            fullyInitialize();
        }
    }

    @JvmStatic
    public static final void setAutoLogAppEventsEnabled(boolean z11) {
        UserSettingsManager.setAutoLogAppEventsEnabled(z11);
        if (z11) {
            ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
            ActivityLifecycleTracker.startTracking((Application) getApplicationContext(), getApplicationId());
        }
    }

    @JvmStatic
    public static final void setCacheDir(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "cacheDir");
        cacheDir = new LockOnGetVariable<>(file);
    }

    @JvmStatic
    public static final void setClientToken(@Nullable String str) {
        appClientToken = str;
    }

    @JvmStatic
    public static final void setCodelessDebugLogEnabled(boolean z11) {
        codelessDebugLogEnabled = Boolean.valueOf(z11);
    }

    @JvmStatic
    @AutoHandleExceptions
    public static final void setDataProcessingOptions(@Nullable String[] strArr) {
        setDataProcessingOptions(strArr, 0, 0);
    }

    @JvmStatic
    public static final void setExecutor(@NotNull Executor executor2) {
        Intrinsics.checkNotNullParameter(executor2, "executor");
        ReentrantLock reentrantLock = LOCK;
        reentrantLock.lock();
        try {
            executor = executor2;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @JvmStatic
    public static final void setFacebookDomain(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "facebookDomain");
        Log.w(TAG, "WARNING: Calling setFacebookDomain from non-DEBUG code.");
        facebookDomain = str;
    }

    @JvmStatic
    public static final void setGraphApiVersion(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "graphApiVersion");
        Log.w(TAG, "WARNING: Calling setGraphApiVersion from non-DEBUG code.");
        if (!Utility.isNullOrEmpty(str) && !Intrinsics.areEqual((Object) graphApiVersion, (Object) str)) {
            graphApiVersion = str;
        }
    }

    @JvmStatic
    @VisibleForTesting
    public static final void setGraphRequestCreator$facebook_core_release(@NotNull GraphRequestCreator graphRequestCreator2) {
        Intrinsics.checkNotNullParameter(graphRequestCreator2, "graphRequestCreator");
        graphRequestCreator = graphRequestCreator2;
    }

    @JvmStatic
    public static final void setIsDebugEnabled(boolean z11) {
        isDebugEnabledField = z11;
    }

    @JvmStatic
    public static final void setLegacyTokenUpgradeSupported(boolean z11) {
        isLegacyTokenUpgradeSupported = z11;
    }

    @JvmStatic
    public static final void setLimitEventAndDataUsage(@NotNull Context context, boolean z11) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.getSharedPreferences(APP_EVENT_PREFERENCES, 0).edit().putBoolean("limitEventUsage", z11).apply();
    }

    @JvmStatic
    public static final void setMonitorEnabled(boolean z11) {
        UserSettingsManager.setMonitorEnabled(z11);
    }

    @JvmStatic
    public static final void setOnProgressThreshold(long j11) {
        onProgressThreshold.set(j11);
    }

    private final void updateGraphDebugBehavior() {
        HashSet<LoggingBehavior> hashSet = loggingBehaviors;
        if (hashSet.contains(LoggingBehavior.GRAPH_API_DEBUG_INFO)) {
            LoggingBehavior loggingBehavior = LoggingBehavior.GRAPH_API_DEBUG_WARNING;
            if (!hashSet.contains(loggingBehavior)) {
                hashSet.add(loggingBehavior);
            }
        }
    }

    @JvmStatic
    @AutoHandleExceptions
    public static final void setDataProcessingOptions(@Nullable String[] strArr, int i11, int i12) {
        if (strArr == null) {
            strArr = new String[0];
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(DATA_PROCESSION_OPTIONS, (Object) new JSONArray((Collection<?>) ArraysKt___ArraysKt.toList((T[]) strArr)));
            jSONObject.put(DATA_PROCESSION_OPTIONS_COUNTRY, i11);
            jSONObject.put(DATA_PROCESSION_OPTIONS_STATE, i12);
            Context context = applicationContext;
            if (context != null) {
                context.getSharedPreferences(DATA_PROCESSING_OPTIONS_PREFERENCES, 0).edit().putString(DATA_PROCESSION_OPTIONS, JSONObjectInstrumentation.toString(jSONObject)).apply();
            } else {
                Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
                throw null;
            }
        } catch (JSONException unused) {
        }
    }

    @JvmStatic
    @Deprecated(message = "")
    public static final synchronized void sdkInitialize(@NotNull Context context, int i11, @Nullable InitializeCallback initializeCallback) {
        synchronized (FacebookSdk.class) {
            Intrinsics.checkNotNullParameter(context, "applicationContext");
            if (sdkInitialized.get()) {
                if (i11 != callbackRequestCodeOffset) {
                    throw new FacebookException(CALLBACK_OFFSET_CHANGED_AFTER_INIT);
                }
            }
            if (i11 >= 0) {
                callbackRequestCodeOffset = i11;
                sdkInitialize(context, initializeCallback);
            } else {
                throw new FacebookException(CALLBACK_OFFSET_NEGATIVE);
            }
        }
    }

    @JvmStatic
    @Deprecated(message = "")
    public static final synchronized void sdkInitialize(@NotNull Context context) {
        synchronized (FacebookSdk.class) {
            Intrinsics.checkNotNullParameter(context, "applicationContext");
            sdkInitialize(context, (InitializeCallback) null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f9  */
    @kotlin.jvm.JvmStatic
    @kotlin.Deprecated(message = "")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized void sdkInitialize(@org.jetbrains.annotations.NotNull android.content.Context r5, @org.jetbrains.annotations.Nullable com.facebook.FacebookSdk.InitializeCallback r6) {
        /*
            java.lang.Class<com.facebook.FacebookSdk> r0 = com.facebook.FacebookSdk.class
            monitor-enter(r0)
            java.lang.String r1 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)     // Catch:{ all -> 0x0107 }
            java.util.concurrent.atomic.AtomicBoolean r1 = sdkInitialized     // Catch:{ all -> 0x0107 }
            boolean r2 = r1.get()     // Catch:{ all -> 0x0107 }
            if (r2 == 0) goto L_0x0018
            if (r6 != 0) goto L_0x0013
            goto L_0x0016
        L_0x0013:
            r6.onInitialized()     // Catch:{ all -> 0x0107 }
        L_0x0016:
            monitor-exit(r0)
            return
        L_0x0018:
            r2 = 0
            com.facebook.internal.Validate.hasFacebookActivity(r5, r2)     // Catch:{ all -> 0x0107 }
            com.facebook.internal.Validate.hasInternetPermissions(r5, r2)     // Catch:{ all -> 0x0107 }
            android.content.Context r3 = r5.getApplicationContext()     // Catch:{ all -> 0x0107 }
            java.lang.String r4 = "applicationContext.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ all -> 0x0107 }
            applicationContext = r3     // Catch:{ all -> 0x0107 }
            com.facebook.appevents.AppEventsLogger$Companion r3 = com.facebook.appevents.AppEventsLogger.Companion     // Catch:{ all -> 0x0107 }
            r3.getAnonymousAppDeviceGUID(r5)     // Catch:{ all -> 0x0107 }
            android.content.Context r5 = applicationContext     // Catch:{ all -> 0x0107 }
            r3 = 0
            if (r5 == 0) goto L_0x0101
            loadDefaultsFromMetadata$facebook_core_release(r5)     // Catch:{ all -> 0x0107 }
            java.lang.String r5 = applicationId     // Catch:{ all -> 0x0107 }
            r4 = 1
            if (r5 == 0) goto L_0x0045
            int r5 = r5.length()     // Catch:{ all -> 0x0107 }
            if (r5 != 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r5 = r2
            goto L_0x0046
        L_0x0045:
            r5 = r4
        L_0x0046:
            if (r5 != 0) goto L_0x00f9
            java.lang.String r5 = appClientToken     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x0052
            int r5 = r5.length()     // Catch:{ all -> 0x0107 }
            if (r5 != 0) goto L_0x0053
        L_0x0052:
            r2 = r4
        L_0x0053:
            if (r2 != 0) goto L_0x00f1
            r1.set(r4)     // Catch:{ all -> 0x0107 }
            boolean r5 = getAutoInitEnabled()     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x0061
            fullyInitialize()     // Catch:{ all -> 0x0107 }
        L_0x0061:
            android.content.Context r5 = applicationContext     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x00eb
            boolean r5 = r5 instanceof android.app.Application     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x0083
            boolean r5 = com.facebook.UserSettingsManager.getAutoLogAppEventsEnabled()     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x0083
            com.facebook.appevents.internal.ActivityLifecycleTracker r5 = com.facebook.appevents.internal.ActivityLifecycleTracker.INSTANCE     // Catch:{ all -> 0x0107 }
            android.content.Context r5 = applicationContext     // Catch:{ all -> 0x0107 }
            if (r5 == 0) goto L_0x007d
            android.app.Application r5 = (android.app.Application) r5     // Catch:{ all -> 0x0107 }
            java.lang.String r1 = applicationId     // Catch:{ all -> 0x0107 }
            com.facebook.appevents.internal.ActivityLifecycleTracker.startTracking(r5, r1)     // Catch:{ all -> 0x0107 }
            goto L_0x0083
        L_0x007d:
            java.lang.String r5 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x0107 }
            throw r3     // Catch:{ all -> 0x0107 }
        L_0x0083:
            com.facebook.internal.FetchedAppSettingsManager.loadAppSettingsAsync()     // Catch:{ all -> 0x0107 }
            com.facebook.internal.NativeProtocol.updateAllAvailableProtocolVersionsAsync()     // Catch:{ all -> 0x0107 }
            com.facebook.internal.BoltsMeasurementEventListener$Companion r5 = com.facebook.internal.BoltsMeasurementEventListener.Companion     // Catch:{ all -> 0x0107 }
            android.content.Context r1 = applicationContext     // Catch:{ all -> 0x0107 }
            if (r1 == 0) goto L_0x00e5
            r5.getInstance(r1)     // Catch:{ all -> 0x0107 }
            com.facebook.internal.LockOnGetVariable r5 = new com.facebook.internal.LockOnGetVariable     // Catch:{ all -> 0x0107 }
            k6.f r1 = new k6.f     // Catch:{ all -> 0x0107 }
            r1.<init>()     // Catch:{ all -> 0x0107 }
            r5.<init>(r1)     // Catch:{ all -> 0x0107 }
            cacheDir = r5     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager r5 = com.facebook.internal.FeatureManager.INSTANCE     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.Instrument     // Catch:{ all -> 0x0107 }
            k6.g r1 = new k6.g     // Catch:{ all -> 0x0107 }
            r1.<init>()     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.AppEvents     // Catch:{ all -> 0x0107 }
            k6.h r1 = new k6.h     // Catch:{ all -> 0x0107 }
            r1.<init>()     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.ChromeCustomTabsPrefetching     // Catch:{ all -> 0x0107 }
            k6.i r1 = new k6.i     // Catch:{ all -> 0x0107 }
            r1.<init>()     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.IgnoreAppSwitchToLoggedOut     // Catch:{ all -> 0x0107 }
            k6.j r1 = new k6.j     // Catch:{ all -> 0x0107 }
            r1.<init>()     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager$Feature r5 = com.facebook.internal.FeatureManager.Feature.BypassAppSwitch     // Catch:{ all -> 0x0107 }
            k6.k r1 = new k6.k     // Catch:{ all -> 0x0107 }
            r1.<init>()     // Catch:{ all -> 0x0107 }
            com.facebook.internal.FeatureManager.checkFeature(r5, r1)     // Catch:{ all -> 0x0107 }
            java.util.concurrent.FutureTask r5 = new java.util.concurrent.FutureTask     // Catch:{ all -> 0x0107 }
            k6.l r1 = new k6.l     // Catch:{ all -> 0x0107 }
            r1.<init>(r6)     // Catch:{ all -> 0x0107 }
            r5.<init>(r1)     // Catch:{ all -> 0x0107 }
            java.util.concurrent.Executor r6 = getExecutor()     // Catch:{ all -> 0x0107 }
            r6.execute(r5)     // Catch:{ all -> 0x0107 }
            monitor-exit(r0)
            return
        L_0x00e5:
            java.lang.String r5 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x0107 }
            throw r3     // Catch:{ all -> 0x0107 }
        L_0x00eb:
            java.lang.String r5 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x0107 }
            throw r3     // Catch:{ all -> 0x0107 }
        L_0x00f1:
            com.facebook.FacebookException r5 = new com.facebook.FacebookException     // Catch:{ all -> 0x0107 }
            java.lang.String r6 = "A valid Facebook app client token must be set in the AndroidManifest.xml or set by calling FacebookSdk.setClientToken before initializing the sdk."
            r5.<init>((java.lang.String) r6)     // Catch:{ all -> 0x0107 }
            throw r5     // Catch:{ all -> 0x0107 }
        L_0x00f9:
            com.facebook.FacebookException r5 = new com.facebook.FacebookException     // Catch:{ all -> 0x0107 }
            java.lang.String r6 = "A valid Facebook app id must be set in the AndroidManifest.xml or set by calling FacebookSdk.setApplicationId before initializing the sdk."
            r5.<init>((java.lang.String) r6)     // Catch:{ all -> 0x0107 }
            throw r5     // Catch:{ all -> 0x0107 }
        L_0x0101:
            java.lang.String r5 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)     // Catch:{ all -> 0x0107 }
            throw r3     // Catch:{ all -> 0x0107 }
        L_0x0107:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.FacebookSdk.sdkInitialize(android.content.Context, com.facebook.FacebookSdk$InitializeCallback):void");
    }
}
