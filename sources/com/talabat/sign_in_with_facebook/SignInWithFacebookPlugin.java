package com.talabat.sign_in_with_facebook;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.List;

public class SignInWithFacebookPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {
    private static final String CHANNEL_NAME = "com.talabat.sign_in_with_facebook";
    private ActivityPluginBinding activityPluginBinding;
    private MethodChannel channel;
    private final FacebookAuth facebookAuth = new FacebookAuth();

    /* renamed from: com.talabat.sign_in_with_facebook.SignInWithFacebookPlugin$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f61421a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.talabat.sign_in_with_facebook.FacebookMethod[] r0 = com.talabat.sign_in_with_facebook.FacebookMethod.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f61421a = r0
                com.talabat.sign_in_with_facebook.FacebookMethod r1 = com.talabat.sign_in_with_facebook.FacebookMethod.LOGIN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f61421a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.talabat.sign_in_with_facebook.FacebookMethod r1 = com.talabat.sign_in_with_facebook.FacebookMethod.GET_USER_DATA     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f61421a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.talabat.sign_in_with_facebook.FacebookMethod r1 = com.talabat.sign_in_with_facebook.FacebookMethod.LOG_OUT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.talabat.sign_in_with_facebook.SignInWithFacebookPlugin.AnonymousClass1.<clinit>():void");
        }
    }

    private void attachToActivity(ActivityPluginBinding activityPluginBinding2) {
        this.activityPluginBinding = activityPluginBinding2;
        activityPluginBinding2.addActivityResultListener(this.facebookAuth.f61415a);
    }

    private void disposeActivity() {
        this.activityPluginBinding.removeActivityResultListener(this.facebookAuth.f61415a);
        this.activityPluginBinding = null;
    }

    public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding2) {
        attachToActivity(activityPluginBinding2);
    }

    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getBinaryMessenger(), "com.talabat.sign_in_with_facebook");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void onDetachedFromActivity() {
        disposeActivity();
    }

    public void onDetachedFromActivityForConfigChanges() {
        disposeActivity();
    }

    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
    }

    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        FacebookMethod fromString = FacebookMethod.fromString(methodCall.method);
        if (fromString == null) {
            result.notImplemented();
            return;
        }
        int i11 = AnonymousClass1.f61421a[fromString.ordinal()];
        if (i11 == 1) {
            this.facebookAuth.setLoginBehavior((String) methodCall.argument("loginBehavior"));
            this.facebookAuth.c(this.activityPluginBinding.getActivity(), (List) methodCall.argument("permissions"), result);
        } else if (i11 == 2) {
            this.facebookAuth.getUserData((String) methodCall.argument("fields"), result);
        } else if (i11 != 3) {
            result.notImplemented();
        } else {
            this.facebookAuth.b(result);
        }
    }

    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding2) {
        attachToActivity(activityPluginBinding2);
    }
}
