package com.aboutyou.dart_packages.sign_in_with_apple;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.app.NotificationCompat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 $2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001$B\u0005¢\u0006\u0002\u0010\u0005J\"\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\u0018\u001a\u00020\u00172\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u0012\u0010\u001d\u001a\u00020\u00172\b\b\u0001\u0010\b\u001a\u00020\u001aH\u0016J\u001c\u0010\u001e\u001a\u00020\u00172\b\b\u0001\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/aboutyou/dart_packages/sign_in_with_apple/SignInWithApplePlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;", "()V", "CUSTOM_TABS_REQUEST_CODE", "", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "getBinding", "()Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "setBinding", "(Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;)V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttachedToActivity", "", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onReattachedToActivityForConfigChanges", "Companion", "sign_in_with_apple_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SignInWithApplePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware, PluginRegistry.ActivityResultListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static MethodChannel.Result lastAuthorizationRequestResult;
    /* access modifiers changed from: private */
    @Nullable
    public static Function0<Unit> triggerMainActivityToHideChromeCustomTab;
    private final int CUSTOM_TABS_REQUEST_CODE = 1001;
    @Nullable
    private ActivityPluginBinding binding;
    @Nullable
    private MethodChannel channel;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/aboutyou/dart_packages/sign_in_with_apple/SignInWithApplePlugin$Companion;", "", "()V", "lastAuthorizationRequestResult", "Lio/flutter/plugin/common/MethodChannel$Result;", "getLastAuthorizationRequestResult", "()Lio/flutter/plugin/common/MethodChannel$Result;", "setLastAuthorizationRequestResult", "(Lio/flutter/plugin/common/MethodChannel$Result;)V", "triggerMainActivityToHideChromeCustomTab", "Lkotlin/Function0;", "", "getTriggerMainActivityToHideChromeCustomTab", "()Lkotlin/jvm/functions/Function0;", "setTriggerMainActivityToHideChromeCustomTab", "(Lkotlin/jvm/functions/Function0;)V", "registerWith", "registrar", "Lio/flutter/plugin/common/PluginRegistry$Registrar;", "sign_in_with_apple_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final MethodChannel.Result getLastAuthorizationRequestResult() {
            return SignInWithApplePlugin.lastAuthorizationRequestResult;
        }

        @Nullable
        public final Function0<Unit> getTriggerMainActivityToHideChromeCustomTab() {
            return SignInWithApplePlugin.triggerMainActivityToHideChromeCustomTab;
        }

        @JvmStatic
        public final void registerWith(@NotNull PluginRegistry.Registrar registrar) {
            Intrinsics.checkNotNullParameter(registrar, "registrar");
            new MethodChannel(registrar.messenger(), BuildConfig.LIBRARY_PACKAGE_NAME).setMethodCallHandler(new SignInWithApplePlugin());
        }

        public final void setLastAuthorizationRequestResult(@Nullable MethodChannel.Result result) {
            SignInWithApplePlugin.lastAuthorizationRequestResult = result;
        }

        public final void setTriggerMainActivityToHideChromeCustomTab(@Nullable Function0<Unit> function0) {
            SignInWithApplePlugin.triggerMainActivityToHideChromeCustomTab = function0;
        }
    }

    @JvmStatic
    public static final void registerWith(@NotNull PluginRegistry.Registrar registrar) {
        Companion.registerWith(registrar);
    }

    @Nullable
    public final ActivityPluginBinding getBinding() {
        return this.binding;
    }

    public boolean onActivityResult(int i11, int i12, @Nullable Intent intent) {
        MethodChannel.Result result;
        if (i11 != this.CUSTOM_TABS_REQUEST_CODE || (result = lastAuthorizationRequestResult) == null) {
            return false;
        }
        result.error("authorization-error/canceled", "The user closed the Custom Tab", (Object) null);
        lastAuthorizationRequestResult = null;
        triggerMainActivityToHideChromeCustomTab = null;
        return false;
    }

    public void onAttachedToActivity(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        this.binding = activityPluginBinding;
        activityPluginBinding.addActivityResultListener(this);
    }

    public void onAttachedToEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), BuildConfig.LIBRARY_PACKAGE_NAME);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromActivity() {
        ActivityPluginBinding activityPluginBinding = this.binding;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(this);
        }
        this.binding = null;
    }

    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    public void onDetachedFromEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        }
        this.channel = null;
    }

    public void onMethodCall(@NotNull @NonNull MethodCall methodCall, @NotNull @NonNull MethodChannel.Result result) {
        Activity activity;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) "isAvailable")) {
            result.success(Boolean.TRUE);
        } else if (Intrinsics.areEqual((Object) str, (Object) "performAuthorizationRequest")) {
            ActivityPluginBinding activityPluginBinding = this.binding;
            if (activityPluginBinding != null) {
                activity = activityPluginBinding.getActivity();
            } else {
                activity = null;
            }
            if (activity == null) {
                result.error("MISSING_ACTIVITY", "Plugin is not attached to an activity", methodCall.arguments);
                return;
            }
            String str2 = (String) methodCall.argument("url");
            if (str2 == null) {
                result.error("MISSING_ARG", "Missing 'url' argument", methodCall.arguments);
                return;
            }
            MethodChannel.Result result2 = lastAuthorizationRequestResult;
            if (result2 != null) {
                result2.error("NEW_REQUEST", "A new request came in while this was still pending. The previous request (this one) was then cancelled.", (Object) null);
            }
            Function0<Unit> function0 = triggerMainActivityToHideChromeCustomTab;
            if (function0 != null) {
                Intrinsics.checkNotNull(function0);
                function0.invoke();
            }
            lastAuthorizationRequestResult = result;
            triggerMainActivityToHideChromeCustomTab = new SignInWithApplePlugin$onMethodCall$1(activity);
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
            build.intent.setData(Uri.parse(str2));
            activity.startActivityForResult(build.intent, this.CUSTOM_TABS_REQUEST_CODE, build.startAnimationBundle);
        } else {
            result.notImplemented();
        }
    }

    public void onReattachedToActivityForConfigChanges(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        onAttachedToActivity(activityPluginBinding);
    }

    public final void setBinding(@Nullable ActivityPluginBinding activityPluginBinding) {
        this.binding = activityPluginBinding;
    }
}
