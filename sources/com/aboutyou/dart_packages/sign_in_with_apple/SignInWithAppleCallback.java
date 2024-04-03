package com.aboutyou.dart_packages.sign_in_with_apple;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.aboutyou.dart_packages.sign_in_with_apple.SignInWithApplePlugin;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import io.flutter.Log;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/aboutyou/dart_packages/sign_in_with_apple/SignInWithAppleCallback;", "Landroid/app/Activity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "sign_in_with_apple_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SignInWithAppleCallback extends Activity implements TraceFieldInterface {
    public Trace _nr_trace;

    public void onCreate(@Nullable Bundle bundle) {
        String str;
        Uri data;
        TraceMachine.startTracing("SignInWithAppleCallback");
        try {
            TraceMachine.enterMethod(this._nr_trace, "SignInWithAppleCallback#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SignInWithAppleCallback#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        SignInWithApplePlugin.Companion companion = SignInWithApplePlugin.Companion;
        MethodChannel.Result lastAuthorizationRequestResult = companion.getLastAuthorizationRequestResult();
        if (lastAuthorizationRequestResult != null) {
            Intent intent = getIntent();
            if (intent == null || (data = intent.getData()) == null) {
                str = null;
            } else {
                str = data.toString();
            }
            lastAuthorizationRequestResult.success(str);
            companion.setLastAuthorizationRequestResult((MethodChannel.Result) null);
        } else {
            companion.setTriggerMainActivityToHideChromeCustomTab((Function0<Unit>) null);
            Log.e(SignInWithApplePluginKt.getTAG(), "Received Sign in with Apple callback, but 'lastAuthorizationRequestResult' function was `null`");
        }
        Function0<Unit> triggerMainActivityToHideChromeCustomTab = companion.getTriggerMainActivityToHideChromeCustomTab();
        if (triggerMainActivityToHideChromeCustomTab != null) {
            triggerMainActivityToHideChromeCustomTab.invoke();
            companion.setTriggerMainActivityToHideChromeCustomTab((Function0<Unit>) null);
        } else {
            Log.e(SignInWithApplePluginKt.getTAG(), "Received Sign in with Apple callback, but 'triggerMainActivityToHideChromeCustomTab' function was `null`");
        }
        finish();
        TraceMachine.exitMethod();
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }
}
