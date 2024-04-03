package com.talabat.mobile_services_type;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/mobile_services_type/MobileServicesTypePlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "applicationContext", "Landroid/content/Context;", "channel", "Lio/flutter/plugin/common/MethodChannel;", "mobileServicesAvailability", "Lcom/talabat/mobile_services_type/MobileServicesAvailability;", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "mobile_services_type_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MobileServicesTypePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private Context applicationContext;
    private MethodChannel channel;
    @NotNull
    private final MobileServicesAvailability mobileServicesAvailability = new MobileServicesAvailability(new ApiAvailabilityProvider());

    public void onAttachedToEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        Context applicationContext2 = flutterPluginBinding.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext2, "flutterPluginBinding.applicationContext");
        this.applicationContext = applicationContext2;
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "mobile_services_type");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromEngine(@NotNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "binding");
        MethodChannel methodChannel = this.channel;
        if (methodChannel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
            methodChannel = null;
        }
        methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        String str = methodCall.method;
        Context context = null;
        if (Intrinsics.areEqual((Object) str, (Object) "isGooglePlayServicesAvailable")) {
            MobileServicesAvailability mobileServicesAvailability2 = this.mobileServicesAvailability;
            Context context2 = this.applicationContext;
            if (context2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            } else {
                context = context2;
            }
            result.success(Boolean.valueOf(mobileServicesAvailability2.isGooglePlayServicesAvailable(context)));
        } else if (Intrinsics.areEqual((Object) str, (Object) "isHuaweiMediaServicesAvailable")) {
            MobileServicesAvailability mobileServicesAvailability3 = this.mobileServicesAvailability;
            Context context3 = this.applicationContext;
            if (context3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
            } else {
                context = context3;
            }
            result.success(Boolean.valueOf(mobileServicesAvailability3.isHuaweiMobileServicesAvailable(context)));
        } else {
            result.notImplemented();
        }
    }
}
