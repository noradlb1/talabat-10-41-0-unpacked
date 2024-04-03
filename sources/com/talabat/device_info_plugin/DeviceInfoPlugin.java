package com.talabat.device_info_plugin;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u0005¢\u0006\u0002\u0010\u0003J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0003J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u0010\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001cH\u0016J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/talabat/device_info_plugin/DeviceInfoPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "applicationContext", "Landroid/content/Context;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "activityGuard", "", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "functionName", "", "callback", "Lkotlin/Function0;", "getAndroidId", "getAppVersion", "getDeviceBrand", "getDeviceManufacture", "getDeviceName", "getGoogleAdvertisingId", "getHuaweiOpenId", "getResourceFromContext", "context", "resName", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "Companion", "device_info_plugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DeviceInfoPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    @NotNull
    private static String CHANNEL_NAME = "com.talabat.flutter/device_info_plugin";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static String GET_ADVERTISING_ID = "getAdvertisingId";
    @NotNull
    private static String GET_ANDROID_ID = "getAndroidId";
    @NotNull
    private static String GET_APP_VERSION = "getAppVersion";
    @NotNull
    private static String GET_DEVICE_BRNAD = "getDeviceBrand";
    @NotNull
    private static String GET_DEVICE_MANUFACTURE = "getDeviceManufacture";
    @NotNull
    private static String GET_DEVICE_NAME = "getDeviceName";
    @NotNull
    private static String GET_HUAWEI_OPEN_ID = "getHuaweiOpenId";
    /* access modifiers changed from: private */
    @Nullable
    public Context applicationContext;
    @Nullable
    private MethodChannel channel;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/device_info_plugin/DeviceInfoPlugin$Companion;", "", "()V", "CHANNEL_NAME", "", "GET_ADVERTISING_ID", "GET_ANDROID_ID", "GET_APP_VERSION", "GET_DEVICE_BRNAD", "GET_DEVICE_MANUFACTURE", "GET_DEVICE_NAME", "GET_HUAWEI_OPEN_ID", "device_info_plugin_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void activityGuard(MethodChannel.Result result, String str, Function0<Unit> function0) {
        if (this.applicationContext == null) {
            result.error("The applicationContext is null", "While calling " + str, (Object) null);
            return;
        }
        function0.invoke();
    }

    @SuppressLint({"HardwareIds"})
    private final void getAndroidId(MethodChannel.Result result) {
        ContentResolver contentResolver;
        Context context = this.applicationContext;
        if (context != null) {
            contentResolver = context.getContentResolver();
        } else {
            contentResolver = null;
        }
        if (contentResolver == null) {
            result.error("NotInitializedYet", "DeviceInfoPlugin isn't attached to engine", (Object) null);
            return;
        }
        try {
            result.success(Settings.Secure.getString(contentResolver, "android_id"));
        } catch (Exception e11) {
            result.error("getAndroidId", e11.getLocalizedMessage(), (Object) null);
        }
    }

    private final void getAppVersion(MethodChannel.Result result) {
        Context context = this.applicationContext;
        if (context == null) {
            result.error("NotInitializedYet", "DeviceInfoPlugin isn't attached to engine", (Object) null);
            return;
        }
        try {
            Intrinsics.checkNotNull(context);
            String resourceFromContext = getResourceFromContext(context, "app_version");
            if (resourceFromContext != null) {
                result.success(resourceFromContext);
                return;
            }
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT >= 33) {
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0));
                Intrinsics.checkNotNullExpressionValue(packageInfo, "manager.getPackageInfo(\n…s.of(0)\n                )");
                result.success(packageInfo.versionName);
                return;
            }
            result.success(packageManager.getPackageInfo(context.getPackageName(), 0).versionName);
        } catch (Exception e11) {
            result.error("getAppVersion", e11.getLocalizedMessage(), (Object) null);
        }
    }

    private final void getDeviceBrand(MethodChannel.Result result) {
        result.success(Build.BRAND);
    }

    private final void getDeviceManufacture(MethodChannel.Result result) {
        result.success(Build.MANUFACTURER);
    }

    private final void getDeviceName(MethodChannel.Result result) {
        result.success(Build.MODEL);
    }

    private final void getGoogleAdvertisingId(MethodChannel.Result result) {
        activityGuard(result, GET_ADVERTISING_ID, new DeviceInfoPlugin$getGoogleAdvertisingId$1(this, result));
    }

    private final void getHuaweiOpenId(MethodChannel.Result result) {
        activityGuard(result, GET_HUAWEI_OPEN_ID, new DeviceInfoPlugin$getHuaweiOpenId$1(this, result));
    }

    private final String getResourceFromContext(Context context, String str) {
        boolean z11;
        try {
            int identifier = context.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, context.getPackageName());
            if (identifier != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                return context.getString(identifier);
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("The 'R.string.%s' value it's not defined in your project's resources file.", Arrays.copyOf(new Object[]{str}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            throw new IllegalArgumentException(format.toString());
        } catch (Exception unused) {
            return null;
        }
    }

    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        this.applicationContext = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), CHANNEL_NAME);
        this.channel = methodChannel;
        Intrinsics.checkNotNull(methodChannel);
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        this.applicationContext = null;
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) GET_ADVERTISING_ID)) {
            getGoogleAdvertisingId(result);
        } else if (Intrinsics.areEqual((Object) str, (Object) GET_ANDROID_ID)) {
            getAndroidId(result);
        } else if (Intrinsics.areEqual((Object) str, (Object) GET_HUAWEI_OPEN_ID)) {
            getHuaweiOpenId(result);
        } else if (Intrinsics.areEqual((Object) str, (Object) GET_DEVICE_NAME)) {
            getDeviceName(result);
        } else if (Intrinsics.areEqual((Object) str, (Object) GET_APP_VERSION)) {
            getAppVersion(result);
        } else if (Intrinsics.areEqual((Object) str, (Object) GET_DEVICE_BRNAD)) {
            getDeviceBrand(result);
        } else if (Intrinsics.areEqual((Object) str, (Object) GET_DEVICE_MANUFACTURE)) {
            getDeviceManufacture(result);
        } else {
            result.notImplemented();
        }
    }
}
