package com.talabat.secure_payment_redirection;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import com.talabat.secure_payment_redirection.SecurePaymentRedirectionCallback;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\u000bH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/secure_payment_redirection/SecurePaymentRedirectionPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lio/flutter/plugin/common/MethodChannel$MethodCallHandler;", "()V", "channel", "Lio/flutter/plugin/common/MethodChannel;", "context", "Landroid/content/Context;", "onAttachedToEngine", "", "flutterPluginBinding", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromEngine", "binding", "onMethodCall", "call", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "secure_payment_redirection_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SecurePaymentRedirectionPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler {
    private MethodChannel channel;
    @Nullable
    private Context context;

    public void onAttachedToEngine(@NotNull @NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Intrinsics.checkNotNullParameter(flutterPluginBinding, "flutterPluginBinding");
        this.context = flutterPluginBinding.getApplicationContext();
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "secure_payment_redirection");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
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

    public void onMethodCall(@NotNull MethodCall methodCall, @NotNull MethodChannel.Result result) {
        Map map;
        Object obj;
        String str;
        Intrinsics.checkNotNullParameter(methodCall, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(result, "result");
        if (Intrinsics.areEqual((Object) methodCall.method, (Object) "finalisePaymentRedirection")) {
            Object obj2 = methodCall.arguments;
            if (obj2 instanceof Map) {
                map = (Map) obj2;
            } else {
                map = null;
            }
            if (map != null) {
                obj = map.get("redirectUrl");
            } else {
                obj = null;
            }
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                str = null;
            }
            if (str == null) {
                result.error(CardTokenizationPlugin.ERROR_CODE_INVALID_ARGUMENT, "Argument redirectUrl was missing or incorrect", (Object) null);
                return;
            }
            Intent intent = new Intent(this.context, SecurePaymentRedirectionWebViewActivity.class);
            intent.putExtra("redirectUrl", str);
            intent.addFlags(268435456);
            Context context2 = this.context;
            if (context2 != null) {
                context2.startActivity(intent);
            }
            SecurePaymentRedirectionCallback.Companion companion = SecurePaymentRedirectionCallback.Companion;
            companion.getInstance().setOnFailure(new SecurePaymentRedirectionPlugin$onMethodCall$1(result));
            companion.getInstance().setOnSuccess(new SecurePaymentRedirectionPlugin$onMethodCall$2(result));
            companion.getInstance().setOnClosed(new SecurePaymentRedirectionPlugin$onMethodCall$3(result));
            return;
        }
        result.notImplemented();
    }
}
