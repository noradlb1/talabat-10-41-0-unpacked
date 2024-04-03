package com.google.flutter.recaptcha;

import android.app.Activity;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.facebook.internal.NativeProtocol;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaClient;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tekartik.sqflite.Constant;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0002J\u001c\u0010\u0011\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\f2\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\fH\u0016J\b\u0010\u001d\u001a\u00020\fH\u0016J\u0012\u0010\u001e\u001a\u00020\f2\b\b\u0001\u0010\u0017\u001a\u00020\u001bH\u0016J\u001c\u0010\u001f\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/google/flutter/recaptcha/RecaptchaEnterprisePlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "()V", "application", "Landroid/app/Application;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "recaptchaClient", "Lcom/google/android/recaptcha/RecaptchaClient;", "execute", "", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "initClient", "mapAction", "Lcom/google/android/recaptcha/RecaptchaAction;", "actionStr", "", "onAttachedToActivity", "binding", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onMethodCall", "onReattachedToActivityForConfigChanges", "recaptcha_enterprise_flutter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RecaptchaEnterprisePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {
    /* access modifiers changed from: private */
    public Application application;
    private MethodChannel channel;
    /* access modifiers changed from: private */
    public RecaptchaClient recaptchaClient;

    private final void execute(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        RecaptchaClient recaptchaClient2 = this.recaptchaClient;
        if (recaptchaClient2 != null) {
            if (recaptchaClient2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recaptchaClient");
            }
            String str = (String) methodCall.argument(NativeProtocol.WEB_DIALOG_ACTION);
            if (str == null) {
                result.error("FL_EXECUTE_FAILED", "Missing action", (Object) null);
                return;
            }
            RecaptchaAction mapAction = mapAction(str);
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new RecaptchaEnterprisePlugin$execute$2(this, (Double) methodCall.argument("timeout"), mapAction, result, (Continuation<? super RecaptchaEnterprisePlugin$execute$2>) null), 3, (Object) null);
            return;
        }
        result.error("FL_EXECUTE_FAILED", "Initialize client first", (Object) null);
    }

    private final void initClient(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if (this.application == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MimeTypes.BASE_TYPE_APPLICATION);
        }
        String str = (String) methodCall.argument("siteKey");
        Double d11 = (Double) methodCall.argument("timeout");
        if (str != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new RecaptchaEnterprisePlugin$initClient$1(d11, this, str, result, (Continuation<? super RecaptchaEnterprisePlugin$initClient$1>) null), 3, (Object) null);
        }
    }

    @NotNull
    public final RecaptchaAction mapAction(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "actionStr");
        if (str.equals(FirebaseAnalytics.Event.LOGIN)) {
            return RecaptchaAction.LOGIN;
        }
        if (str.equals("signup")) {
            return RecaptchaAction.SIGNUP;
        }
        return RecaptchaAction.Companion.custom(str);
    }

    public void onAttachedToActivity(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
        Activity activity = activityPluginBinding.getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "binding.activity");
        Application application2 = activity.getApplication();
        Intrinsics.checkNotNullExpressionValue(application2, "activity.application");
        this.application = application2;
    }

    public void onAttachedToEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "recaptcha_enterprise");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromActivity() {
    }

    public void onDetachedFromActivityForConfigChanges() {
    }

    public void onDetachedFromEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(@NotNull @NonNull MethodCall methodCall, @NotNull @NonNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        if (Intrinsics.areEqual((Object) str, (Object) "initClient")) {
            initClient(methodCall, result);
        } else if (Intrinsics.areEqual((Object) str, (Object) Constant.METHOD_EXECUTE)) {
            execute(methodCall, result);
        } else {
            result.notImplemented();
        }
    }

    public void onReattachedToActivityForConfigChanges(@NotNull ActivityPluginBinding activityPluginBinding) {
        Intrinsics.checkNotNullParameter(activityPluginBinding, "binding");
    }
}
