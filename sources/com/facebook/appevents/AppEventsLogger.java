package com.facebook.appevents;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.google.android.exoplayer2.util.MimeTypes;
import java.math.BigDecimal;
import java.util.Currency;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 -2\u00020\u0001:\u0004-./0B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J\u001a\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0018\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0016J\"\u0010\u0011\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0001\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u00052\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010\u00052\b\u0010&\u001a\u0004\u0018\u00010\u00052\b\u0010'\u001a\u0004\u0018\u00010\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u001a\u0010(\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$J$\u0010(\u001a\u00020\u000e2\b\u0010)\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u000e\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u0014J\u0018\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u00142\b\u0010,\u001a\u0004\u0018\u00010\u0005R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger;", "", "context", "Landroid/content/Context;", "applicationId", "", "accessToken", "Lcom/facebook/AccessToken;", "(Landroid/content/Context;Ljava/lang/String;Lcom/facebook/AccessToken;)V", "getApplicationId", "()Ljava/lang/String;", "loggerImpl", "Lcom/facebook/appevents/AppEventsLoggerImpl;", "flush", "", "isValidForAccessToken", "", "logEvent", "eventName", "parameters", "Landroid/os/Bundle;", "valueToSum", "", "logProductItem", "itemID", "availability", "Lcom/facebook/appevents/AppEventsLogger$ProductAvailability;", "condition", "Lcom/facebook/appevents/AppEventsLogger$ProductCondition;", "description", "imageLink", "link", "title", "priceAmount", "Ljava/math/BigDecimal;", "currency", "Ljava/util/Currency;", "gtin", "mpn", "brand", "logPurchase", "purchaseAmount", "logPushNotificationOpen", "payload", "action", "Companion", "FlushBehavior", "ProductAvailability", "ProductCondition", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class AppEventsLogger {
    @NotNull
    public static final String ACTION_APP_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_FLUSHED";
    @NotNull
    public static final String APP_EVENTS_EXTRA_FLUSH_RESULT = "com.facebook.sdk.APP_EVENTS_FLUSH_RESULT";
    @NotNull
    public static final String APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED = "com.facebook.sdk.APP_EVENTS_NUM_EVENTS_FLUSHED";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = AppEventsLogger.class.getCanonicalName();
    @NotNull
    private final AppEventsLoggerImpl loggerImpl;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\b\u0010\u0013\u001a\u00020\nH\u0007J\b\u0010\u0014\u001a\u00020\nH\u0007J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0004H\u0007J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0007J\u001a\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007J\b\u0010\u001f\u001a\u00020\nH\u0007J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0017H\u0007J\u0012\u0010\"\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0007Jl\u0010&\u001a\u00020\n2\b\u0010'\u001a\u0004\u0018\u00010\u00042\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00042\b\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010\u00042\b\u0010-\u001a\u0004\u0018\u00010\u00042\b\u0010.\u001a\u0004\u0018\u00010\u00042\b\u0010/\u001a\u0004\u0018\u00010\u00042\b\u00100\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u00101\u001a\u00020\n2\b\u00102\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger$Companion;", "", "()V", "ACTION_APP_EVENTS_FLUSHED", "", "APP_EVENTS_EXTRA_FLUSH_RESULT", "APP_EVENTS_EXTRA_NUM_EVENTS_FLUSHED", "TAG", "kotlin.jvm.PlatformType", "activateApp", "", "application", "Landroid/app/Application;", "applicationId", "augmentWebView", "webView", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "clearUserData", "clearUserID", "getAnonymousAppDeviceGUID", "getFlushBehavior", "Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "getUserData", "getUserID", "initializeLib", "newLogger", "Lcom/facebook/appevents/AppEventsLogger;", "accessToken", "Lcom/facebook/AccessToken;", "onContextStop", "setFlushBehavior", "flushBehavior", "setInstallReferrer", "referrer", "setPushNotificationsRegistrationId", "registrationId", "setUserData", "email", "firstName", "lastName", "phone", "dateOfBirth", "gender", "city", "state", "zip", "country", "setUserID", "userID", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void activateApp(@NotNull Application application) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            AppEventsLoggerImpl.Companion.activateApp(application, (String) null);
        }

        @JvmStatic
        public final void augmentWebView(@NotNull WebView webView, @Nullable Context context) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            AppEventsLoggerImpl.Companion.augmentWebView(webView, context);
        }

        @JvmStatic
        public final void clearUserData() {
            UserDataStore.clear();
        }

        @JvmStatic
        public final void clearUserID() {
            AnalyticsUserIDStore.setUserID((String) null);
        }

        @JvmStatic
        @NotNull
        public final String getAnonymousAppDeviceGUID(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return AppEventsLoggerImpl.Companion.getAnonymousAppDeviceGUID(context);
        }

        @JvmStatic
        @Nullable
        public final FlushBehavior getFlushBehavior() {
            return AppEventsLoggerImpl.Companion.getFlushBehavior();
        }

        @JvmStatic
        @NotNull
        public final String getUserData() {
            return UserDataStore.getHashedUserData$facebook_core_release();
        }

        @JvmStatic
        @Nullable
        public final String getUserID() {
            return AnalyticsUserIDStore.getUserID();
        }

        @JvmStatic
        public final void initializeLib(@NotNull Context context, @Nullable String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            AppEventsLoggerImpl.Companion.initializeLib(context, str);
        }

        @JvmStatic
        @NotNull
        public final AppEventsLogger newLogger(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new AppEventsLogger(context, (String) null, (AccessToken) null, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        public final void onContextStop() {
            AppEventsLoggerImpl.Companion.onContextStop();
        }

        @JvmStatic
        public final void setFlushBehavior(@NotNull FlushBehavior flushBehavior) {
            Intrinsics.checkNotNullParameter(flushBehavior, "flushBehavior");
            AppEventsLoggerImpl.Companion.setFlushBehavior(flushBehavior);
        }

        @JvmStatic
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public final void setInstallReferrer(@Nullable String str) {
            AppEventsLoggerImpl.Companion.setInstallReferrer(str);
        }

        @JvmStatic
        public final void setPushNotificationsRegistrationId(@Nullable String str) {
            AppEventsLoggerImpl.Companion.setPushNotificationsRegistrationId(str);
        }

        @JvmStatic
        public final void setUserData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
            UserDataStore.setUserDataAndHash(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
        }

        @JvmStatic
        public final void setUserID(@Nullable String str) {
            AnalyticsUserIDStore.setUserID(str);
        }

        @JvmStatic
        public final void activateApp(@NotNull Application application, @Nullable String str) {
            Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
            AppEventsLoggerImpl.Companion.activateApp(application, str);
        }

        @JvmStatic
        @NotNull
        public final AppEventsLogger newLogger(@NotNull Context context, @Nullable AccessToken accessToken) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new AppEventsLogger(context, (String) null, accessToken, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        @NotNull
        public final AppEventsLogger newLogger(@NotNull Context context, @Nullable String str, @Nullable AccessToken accessToken) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new AppEventsLogger(context, str, accessToken, (DefaultConstructorMarker) null);
        }

        @JvmStatic
        @NotNull
        public final AppEventsLogger newLogger(@NotNull Context context, @Nullable String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new AppEventsLogger(context, str, (AccessToken) null, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger$FlushBehavior;", "", "(Ljava/lang/String;I)V", "AUTO", "EXPLICIT_ONLY", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger$ProductAvailability;", "", "(Ljava/lang/String;I)V", "IN_STOCK", "OUT_OF_STOCK", "PREORDER", "AVALIABLE_FOR_ORDER", "DISCONTINUED", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ProductAvailability {
        IN_STOCK,
        OUT_OF_STOCK,
        PREORDER,
        AVALIABLE_FOR_ORDER,
        DISCONTINUED
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/AppEventsLogger$ProductCondition;", "", "(Ljava/lang/String;I)V", "NEW", "REFURBISHED", "USED", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum ProductCondition {
        NEW,
        REFURBISHED,
        USED
    }

    private AppEventsLogger(Context context, String str, AccessToken accessToken) {
        this.loggerImpl = new AppEventsLoggerImpl(context, str, accessToken);
    }

    public /* synthetic */ AppEventsLogger(Context context, String str, AccessToken accessToken, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, accessToken);
    }

    @JvmStatic
    public static final void activateApp(@NotNull Application application) {
        Companion.activateApp(application);
    }

    @JvmStatic
    public static final void activateApp(@NotNull Application application, @Nullable String str) {
        Companion.activateApp(application, str);
    }

    @JvmStatic
    public static final void augmentWebView(@NotNull WebView webView, @Nullable Context context) {
        Companion.augmentWebView(webView, context);
    }

    @JvmStatic
    public static final void clearUserData() {
        Companion.clearUserData();
    }

    @JvmStatic
    public static final void clearUserID() {
        Companion.clearUserID();
    }

    @JvmStatic
    @NotNull
    public static final String getAnonymousAppDeviceGUID(@NotNull Context context) {
        return Companion.getAnonymousAppDeviceGUID(context);
    }

    @JvmStatic
    @Nullable
    public static final FlushBehavior getFlushBehavior() {
        return Companion.getFlushBehavior();
    }

    @JvmStatic
    @NotNull
    public static final String getUserData() {
        return Companion.getUserData();
    }

    @JvmStatic
    @Nullable
    public static final String getUserID() {
        return Companion.getUserID();
    }

    @JvmStatic
    public static final void initializeLib(@NotNull Context context, @Nullable String str) {
        Companion.initializeLib(context, str);
    }

    @JvmStatic
    @NotNull
    public static final AppEventsLogger newLogger(@NotNull Context context) {
        return Companion.newLogger(context);
    }

    @JvmStatic
    @NotNull
    public static final AppEventsLogger newLogger(@NotNull Context context, @Nullable AccessToken accessToken) {
        return Companion.newLogger(context, accessToken);
    }

    @JvmStatic
    @NotNull
    public static final AppEventsLogger newLogger(@NotNull Context context, @Nullable String str) {
        return Companion.newLogger(context, str);
    }

    @JvmStatic
    @NotNull
    public static final AppEventsLogger newLogger(@NotNull Context context, @Nullable String str, @Nullable AccessToken accessToken) {
        return Companion.newLogger(context, str, accessToken);
    }

    @JvmStatic
    public static final void onContextStop() {
        Companion.onContextStop();
    }

    @JvmStatic
    public static final void setFlushBehavior(@NotNull FlushBehavior flushBehavior) {
        Companion.setFlushBehavior(flushBehavior);
    }

    @JvmStatic
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void setInstallReferrer(@Nullable String str) {
        Companion.setInstallReferrer(str);
    }

    @JvmStatic
    public static final void setPushNotificationsRegistrationId(@Nullable String str) {
        Companion.setPushNotificationsRegistrationId(str);
    }

    @JvmStatic
    public static final void setUserData(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10) {
        Companion.setUserData(str, str2, str3, str4, str5, str6, str7, str8, str9, str10);
    }

    @JvmStatic
    public static final void setUserID(@Nullable String str) {
        Companion.setUserID(str);
    }

    public final void flush() {
        this.loggerImpl.flush();
    }

    @NotNull
    public final String getApplicationId() {
        return this.loggerImpl.getApplicationId();
    }

    public final boolean isValidForAccessToken(@NotNull AccessToken accessToken) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        return this.loggerImpl.isValidForAccessToken(accessToken);
    }

    public final void logEvent(@Nullable String str) {
        this.loggerImpl.logEvent(str);
    }

    public final void logProductItem(@Nullable String str, @Nullable ProductAvailability productAvailability, @Nullable ProductCondition productCondition, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable BigDecimal bigDecimal, @Nullable Currency currency, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable Bundle bundle) {
        this.loggerImpl.logProductItem(str, productAvailability, productCondition, str2, str3, str4, str5, bigDecimal, currency, str6, str7, str8, bundle);
    }

    public final void logPurchase(@Nullable BigDecimal bigDecimal, @Nullable Currency currency) {
        this.loggerImpl.logPurchase(bigDecimal, currency);
    }

    public final void logPushNotificationOpen(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "payload");
        this.loggerImpl.logPushNotificationOpen(bundle, (String) null);
    }

    public final void logEvent(@Nullable String str, double d11) {
        this.loggerImpl.logEvent(str, d11);
    }

    public final void logPurchase(@Nullable BigDecimal bigDecimal, @Nullable Currency currency, @Nullable Bundle bundle) {
        this.loggerImpl.logPurchase(bigDecimal, currency, bundle);
    }

    public final void logPushNotificationOpen(@NotNull Bundle bundle, @Nullable String str) {
        Intrinsics.checkNotNullParameter(bundle, "payload");
        this.loggerImpl.logPushNotificationOpen(bundle, str);
    }

    public final void logEvent(@Nullable String str, @Nullable Bundle bundle) {
        this.loggerImpl.logEvent(str, bundle);
    }

    public final void logEvent(@Nullable String str, double d11, @Nullable Bundle bundle) {
        this.loggerImpl.logEvent(str, d11, bundle);
    }
}
