package com.facebook.login;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import b7.k;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import com.facebook.login.LoginClient;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Instrumented
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 (2\u00020\u0001:\u0001(B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J`\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0018\u0010\u0013\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J(\u0010\u0016\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J(\u0010\u0017\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J\\\u0010\u0018\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u001a2\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u001e\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u001f\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010!\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u0010\u0010\"\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u0010\u0010#\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005J\u001c\u0010$\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007J(\u0010'\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/facebook/login/LoginLogger;", "", "context", "Landroid/content/Context;", "applicationId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getApplicationId", "()Ljava/lang/String;", "facebookVersion", "logger", "Lcom/facebook/appevents/InternalAppEventsLogger;", "logAuthorizationMethodComplete", "", "authId", "method", "result", "errorMessage", "errorCode", "loggingExtras", "", "eventName", "logAuthorizationMethodNotTried", "logAuthorizationMethodStart", "logCompleteLogin", "loginRequestId", "Lcom/facebook/login/LoginClient$Result$Code;", "resultExtras", "exception", "Ljava/lang/Exception;", "logHeartbeatEvent", "logLoginStatusError", "loggerRef", "logLoginStatusFailure", "logLoginStatusStart", "logLoginStatusSuccess", "logStartLogin", "pendingLoginRequest", "Lcom/facebook/login/LoginClient$Request;", "logUnexpectedError", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class LoginLogger {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String EVENT_EXTRAS_DEFAULT_AUDIENCE = "default_audience";
    @NotNull
    public static final String EVENT_EXTRAS_FACEBOOK_VERSION = "facebookVersion";
    @NotNull
    public static final String EVENT_EXTRAS_FAILURE = "failure";
    @NotNull
    public static final String EVENT_EXTRAS_IS_REAUTHORIZE = "isReauthorize";
    @NotNull
    public static final String EVENT_EXTRAS_LOGIN_BEHAVIOR = "login_behavior";
    @NotNull
    public static final String EVENT_EXTRAS_MISSING_INTERNET_PERMISSION = "no_internet_permission";
    @NotNull
    public static final String EVENT_EXTRAS_NEW_PERMISSIONS = "new_permissions";
    @NotNull
    public static final String EVENT_EXTRAS_NOT_TRIED = "not_tried";
    @NotNull
    public static final String EVENT_EXTRAS_PERMISSIONS = "permissions";
    @NotNull
    public static final String EVENT_EXTRAS_REQUEST_CODE = "request_code";
    @NotNull
    public static final String EVENT_EXTRAS_TARGET_APP = "target_app";
    @NotNull
    public static final String EVENT_EXTRAS_TRY_LOGIN_ACTIVITY = "try_login_activity";
    @NotNull
    public static final String EVENT_NAME_FOA_LOGIN_COMPLETE = "foa_mobile_login_complete";
    @NotNull
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_COMPLETE = "foa_mobile_login_method_complete";
    @NotNull
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_NOT_TRIED = "foa_mobile_login_method_not_tried";
    @NotNull
    public static final String EVENT_NAME_FOA_LOGIN_METHOD_START = "foa_mobile_login_method_start";
    @NotNull
    public static final String EVENT_NAME_FOA_LOGIN_START = "foa_mobile_login_start";
    @NotNull
    public static final String EVENT_NAME_LOGIN_COMPLETE = "fb_mobile_login_complete";
    @NotNull
    public static final String EVENT_NAME_LOGIN_HEARTBEAT = "fb_mobile_login_heartbeat";
    @NotNull
    public static final String EVENT_NAME_LOGIN_METHOD_COMPLETE = "fb_mobile_login_method_complete";
    @NotNull
    public static final String EVENT_NAME_LOGIN_METHOD_NOT_TRIED = "fb_mobile_login_method_not_tried";
    @NotNull
    public static final String EVENT_NAME_LOGIN_METHOD_START = "fb_mobile_login_method_start";
    @NotNull
    public static final String EVENT_NAME_LOGIN_START = "fb_mobile_login_start";
    @NotNull
    public static final String EVENT_NAME_LOGIN_STATUS_COMPLETE = "fb_mobile_login_status_complete";
    @NotNull
    public static final String EVENT_NAME_LOGIN_STATUS_START = "fb_mobile_login_status_start";
    @NotNull
    public static final String EVENT_PARAM_AUTH_LOGGER_ID = "0_auth_logger_id";
    @NotNull
    public static final String EVENT_PARAM_CHALLENGE = "7_challenge";
    @NotNull
    public static final String EVENT_PARAM_ERROR_CODE = "4_error_code";
    @NotNull
    public static final String EVENT_PARAM_ERROR_MESSAGE = "5_error_message";
    @NotNull
    public static final String EVENT_PARAM_EXTRAS = "6_extras";
    @NotNull
    public static final String EVENT_PARAM_FOA_METHOD_RESULT_SKIPPED = "foa_skipped";
    @NotNull
    public static final String EVENT_PARAM_LOGIN_RESULT = "2_result";
    @NotNull
    public static final String EVENT_PARAM_METHOD = "3_method";
    @NotNull
    public static final String EVENT_PARAM_METHOD_RESULT_SKIPPED = "skipped";
    @NotNull
    public static final String EVENT_PARAM_TIMESTAMP = "1_timestamp_ms";
    @NotNull
    public static final String FACEBOOK_PACKAGE_NAME = "com.facebook.katana";
    private static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
    @NotNull
    private final String applicationId;
    @Nullable
    private String facebookVersion;
    @NotNull
    private final InternalAppEventsLogger logger;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n **\u0004\u0018\u00010)0)X\u0004¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/facebook/login/LoginLogger$Companion;", "", "()V", "EVENT_EXTRAS_DEFAULT_AUDIENCE", "", "EVENT_EXTRAS_FACEBOOK_VERSION", "EVENT_EXTRAS_FAILURE", "EVENT_EXTRAS_IS_REAUTHORIZE", "EVENT_EXTRAS_LOGIN_BEHAVIOR", "EVENT_EXTRAS_MISSING_INTERNET_PERMISSION", "EVENT_EXTRAS_NEW_PERMISSIONS", "EVENT_EXTRAS_NOT_TRIED", "EVENT_EXTRAS_PERMISSIONS", "EVENT_EXTRAS_REQUEST_CODE", "EVENT_EXTRAS_TARGET_APP", "EVENT_EXTRAS_TRY_LOGIN_ACTIVITY", "EVENT_NAME_FOA_LOGIN_COMPLETE", "EVENT_NAME_FOA_LOGIN_METHOD_COMPLETE", "EVENT_NAME_FOA_LOGIN_METHOD_NOT_TRIED", "EVENT_NAME_FOA_LOGIN_METHOD_START", "EVENT_NAME_FOA_LOGIN_START", "EVENT_NAME_LOGIN_COMPLETE", "EVENT_NAME_LOGIN_HEARTBEAT", "EVENT_NAME_LOGIN_METHOD_COMPLETE", "EVENT_NAME_LOGIN_METHOD_NOT_TRIED", "EVENT_NAME_LOGIN_METHOD_START", "EVENT_NAME_LOGIN_START", "EVENT_NAME_LOGIN_STATUS_COMPLETE", "EVENT_NAME_LOGIN_STATUS_START", "EVENT_PARAM_AUTH_LOGGER_ID", "EVENT_PARAM_CHALLENGE", "EVENT_PARAM_ERROR_CODE", "EVENT_PARAM_ERROR_MESSAGE", "EVENT_PARAM_EXTRAS", "EVENT_PARAM_FOA_METHOD_RESULT_SKIPPED", "EVENT_PARAM_LOGIN_RESULT", "EVENT_PARAM_METHOD", "EVENT_PARAM_METHOD_RESULT_SKIPPED", "EVENT_PARAM_TIMESTAMP", "FACEBOOK_PACKAGE_NAME", "worker", "Ljava/util/concurrent/ScheduledExecutorService;", "kotlin.jvm.PlatformType", "newAuthorizationLoggingBundle", "Landroid/os/Bundle;", "authLoggerId", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final Bundle newAuthorizationLoggingBundle(String str) {
            Bundle bundle = new Bundle();
            bundle.putLong(LoginLogger.EVENT_PARAM_TIMESTAMP, System.currentTimeMillis());
            bundle.putString(LoginLogger.EVENT_PARAM_AUTH_LOGGER_ID, str);
            bundle.putString(LoginLogger.EVENT_PARAM_METHOD, "");
            bundle.putString(LoginLogger.EVENT_PARAM_LOGIN_RESULT, "");
            bundle.putString(LoginLogger.EVENT_PARAM_ERROR_MESSAGE, "");
            bundle.putString(LoginLogger.EVENT_PARAM_ERROR_CODE, "");
            bundle.putString(LoginLogger.EVENT_PARAM_EXTRAS, "");
            return bundle;
        }
    }

    public LoginLogger(@NotNull Context context, @NotNull String str) {
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "applicationId");
        this.applicationId = str;
        this.logger = new InternalAppEventsLogger(context, str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (packageInfo = packageManager.getPackageInfo("com.facebook.katana", 0)) != null) {
                this.facebookVersion = packageInfo.versionName;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static /* synthetic */ void logAuthorizationMethodComplete$default(LoginLogger loginLogger, String str, String str2, String str3, String str4, String str5, Map map, String str6, int i11, Object obj) {
        loginLogger.logAuthorizationMethodComplete(str, str2, str3, str4, str5, map, (i11 & 64) != 0 ? EVENT_NAME_LOGIN_METHOD_COMPLETE : str6);
    }

    public static /* synthetic */ void logAuthorizationMethodNotTried$default(LoginLogger loginLogger, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = EVENT_NAME_LOGIN_METHOD_NOT_TRIED;
        }
        loginLogger.logAuthorizationMethodNotTried(str, str2, str3);
    }

    public static /* synthetic */ void logAuthorizationMethodStart$default(LoginLogger loginLogger, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = EVENT_NAME_LOGIN_METHOD_START;
        }
        loginLogger.logAuthorizationMethodStart(str, str2, str3);
    }

    public static /* synthetic */ void logCompleteLogin$default(LoginLogger loginLogger, String str, Map map, LoginClient.Result.Code code, Map map2, Exception exc, String str2, int i11, Object obj) {
        if ((i11 & 32) != 0) {
            str2 = EVENT_NAME_LOGIN_COMPLETE;
        }
        loginLogger.logCompleteLogin(str, map, code, map2, exc, str2);
    }

    private final void logHeartbeatEvent(String str) {
        worker.schedule(new k(this, Companion.newAuthorizationLoggingBundle(str)), 5, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: private */
    /* renamed from: logHeartbeatEvent$lambda-0  reason: not valid java name */
    public static final void m8997logHeartbeatEvent$lambda0(LoginLogger loginLogger, Bundle bundle) {
        Intrinsics.checkNotNullParameter(loginLogger, "this$0");
        Intrinsics.checkNotNullParameter(bundle, "$bundle");
        loginLogger.logger.logEventImplicitly(EVENT_NAME_LOGIN_HEARTBEAT, bundle);
    }

    public static /* synthetic */ void logStartLogin$default(LoginLogger loginLogger, LoginClient.Request request, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = EVENT_NAME_LOGIN_START;
        }
        loginLogger.logStartLogin(request, str);
    }

    public static /* synthetic */ void logUnexpectedError$default(LoginLogger loginLogger, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = "";
        }
        loginLogger.logUnexpectedError(str, str2, str3);
    }

    @NotNull
    public final String getApplicationId() {
        return this.applicationId;
    }

    @JvmOverloads
    public final void logAuthorizationMethodComplete(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Map<String, String> map) {
        logAuthorizationMethodComplete$default(this, str, str2, str3, str4, str5, map, (String) null, 64, (Object) null);
    }

    @JvmOverloads
    public final void logAuthorizationMethodComplete(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Map<String, String> map, @Nullable String str6) {
        boolean z11;
        Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
        if (str3 != null) {
            access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, str3);
        }
        if (str4 != null) {
            access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str4);
        }
        if (str5 != null) {
            access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_CODE, str5);
        }
        if (map != null && (!map.isEmpty())) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                if (((String) next.getKey()) != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11) {
                    linkedHashMap.put(next.getKey(), next.getValue());
                }
            }
            access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, JSONObjectInstrumentation.toString(new JSONObject((Map<?, ?>) linkedHashMap)));
        }
        access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
        this.logger.logEventImplicitly(str6, access$newAuthorizationLoggingBundle);
    }

    @JvmOverloads
    public final void logAuthorizationMethodNotTried(@Nullable String str, @Nullable String str2) {
        logAuthorizationMethodNotTried$default(this, str, str2, (String) null, 4, (Object) null);
    }

    @JvmOverloads
    public final void logAuthorizationMethodNotTried(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
        access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
        this.logger.logEventImplicitly(str3, access$newAuthorizationLoggingBundle);
    }

    @JvmOverloads
    public final void logAuthorizationMethodStart(@Nullable String str, @Nullable String str2) {
        logAuthorizationMethodStart$default(this, str, str2, (String) null, 4, (Object) null);
    }

    @JvmOverloads
    public final void logAuthorizationMethodStart(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
        access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str2);
        this.logger.logEventImplicitly(str3, access$newAuthorizationLoggingBundle);
    }

    @JvmOverloads
    public final void logCompleteLogin(@Nullable String str, @NotNull Map<String, String> map, @Nullable LoginClient.Result.Code code, @Nullable Map<String, String> map2, @Nullable Exception exc) {
        Intrinsics.checkNotNullParameter(map, "loggingExtras");
        logCompleteLogin$default(this, str, map, code, map2, exc, (String) null, 32, (Object) null);
    }

    @JvmOverloads
    public final void logCompleteLogin(@Nullable String str, @NotNull Map<String, String> map, @Nullable LoginClient.Result.Code code, @Nullable Map<String, String> map2, @Nullable Exception exc, @Nullable String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(map, "loggingExtras");
        Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
        if (code != null) {
            access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, code.getLoggingValue());
        }
        JSONObject jSONObject = null;
        if (exc == null) {
            str3 = null;
        } else {
            str3 = exc.getMessage();
        }
        if (str3 != null) {
            access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.getMessage());
        }
        if (!map.isEmpty()) {
            jSONObject = new JSONObject((Map<?, ?>) map);
        }
        if (map2 != null) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            try {
                for (Map.Entry next : map2.entrySet()) {
                    String str4 = (String) next.getKey();
                    String str5 = (String) next.getValue();
                    if (str4 != null) {
                        jSONObject.put(str4, (Object) str5);
                    }
                }
            } catch (JSONException unused) {
            }
        }
        if (jSONObject != null) {
            access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, JSONObjectInstrumentation.toString(jSONObject));
        }
        this.logger.logEventImplicitly(str2, access$newAuthorizationLoggingBundle);
        if (code == LoginClient.Result.Code.SUCCESS) {
            logHeartbeatEvent(str);
        }
    }

    public final void logLoginStatusError(@Nullable String str, @NotNull Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "exception");
        Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
        access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.ERROR.getLoggingValue());
        access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, exc.toString());
        this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, access$newAuthorizationLoggingBundle);
    }

    public final void logLoginStatusFailure(@Nullable String str) {
        Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
        access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, "failure");
        this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, access$newAuthorizationLoggingBundle);
    }

    public final void logLoginStatusStart(@Nullable String str) {
        this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_START, Companion.newAuthorizationLoggingBundle(str));
    }

    public final void logLoginStatusSuccess(@Nullable String str) {
        Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(str);
        access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.SUCCESS.getLoggingValue());
        this.logger.logEventImplicitly(EVENT_NAME_LOGIN_STATUS_COMPLETE, access$newAuthorizationLoggingBundle);
    }

    @JvmOverloads
    public final void logStartLogin(@NotNull LoginClient.Request request) {
        Intrinsics.checkNotNullParameter(request, "pendingLoginRequest");
        logStartLogin$default(this, request, (String) null, 2, (Object) null);
    }

    @JvmOverloads
    public final void logStartLogin(@NotNull LoginClient.Request request, @Nullable String str) {
        Intrinsics.checkNotNullParameter(request, "pendingLoginRequest");
        Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle(request.getAuthId());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("login_behavior", (Object) request.getLoginBehavior().toString());
            jSONObject.put(EVENT_EXTRAS_REQUEST_CODE, LoginClient.Companion.getLoginRequestCode());
            jSONObject.put("permissions", (Object) TextUtils.join(",", request.getPermissions()));
            jSONObject.put("default_audience", (Object) request.getDefaultAudience().toString());
            jSONObject.put(EVENT_EXTRAS_IS_REAUTHORIZE, request.isRerequest());
            String str2 = this.facebookVersion;
            if (str2 != null) {
                jSONObject.put(EVENT_EXTRAS_FACEBOOK_VERSION, (Object) str2);
            }
            if (request.getLoginTargetApp() != null) {
                jSONObject.put(EVENT_EXTRAS_TARGET_APP, (Object) request.getLoginTargetApp().toString());
            }
            access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_EXTRAS, JSONObjectInstrumentation.toString(jSONObject));
        } catch (JSONException unused) {
        }
        this.logger.logEventImplicitly(str, access$newAuthorizationLoggingBundle);
    }

    @JvmOverloads
    public final void logUnexpectedError(@Nullable String str, @Nullable String str2) {
        logUnexpectedError$default(this, str, str2, (String) null, 4, (Object) null);
    }

    @JvmOverloads
    public final void logUnexpectedError(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        Bundle access$newAuthorizationLoggingBundle = Companion.newAuthorizationLoggingBundle("");
        access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_LOGIN_RESULT, LoginClient.Result.Code.ERROR.getLoggingValue());
        access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_ERROR_MESSAGE, str2);
        access$newAuthorizationLoggingBundle.putString(EVENT_PARAM_METHOD, str3);
        this.logger.logEventImplicitly(str, access$newAuthorizationLoggingBundle);
    }
}
