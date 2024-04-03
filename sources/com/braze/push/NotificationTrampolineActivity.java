package com.braze.push;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.braze.Constants;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.push.BrazePushReceiver;
import com.braze.support.BrazeLogger;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0004H\u0014J\b\u0010\b\u001a\u00020\u0004H\u0014¨\u0006\t"}, d2 = {"Lcom/braze/push/NotificationTrampolineActivity;", "Landroid/app/Activity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NotificationTrampolineActivity extends Activity implements TraceFieldInterface {
    public Trace _nr_trace;

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("NotificationTrampolineActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "NotificationTrampolineActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "NotificationTrampolineActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) NotificationTrampolineActivity$onCreate$1.INSTANCE, 6, (Object) null);
        TraceMachine.exitMethod();
    }

    public void onPause() {
        super.onPause();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) NotificationTrampolineActivity$onPause$1.INSTANCE, 6, (Object) null);
        finish();
    }

    public void onResume() {
        super.onResume();
        try {
            Intent intent = getIntent();
            if (intent == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) NotificationTrampolineActivity$onResume$1.INSTANCE, 7, (Object) null);
                finish();
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) NotificationTrampolineActivity$onResume$2.INSTANCE, 7, (Object) null);
                finish();
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new NotificationTrampolineActivity$onResume$3(intent), 6, (Object) null);
            Intent intent2 = new Intent(action).setClass(this, BrazeNotificationUtils.getNotificationReceiverClass());
            Intrinsics.checkNotNullExpressionValue(intent2, "Intent(action).setClass(…otificationReceiverClass)");
            Bundle extras = intent.getExtras();
            if (extras != null) {
                intent2.putExtras(extras);
            }
            if (Constants.isAmazonDevice()) {
                BrazePushReceiver.Companion.handleReceivedIntent$default(BrazePushReceiver.Companion, this, intent2, false, 4, (Object) null);
            } else {
                BrazePushReceiver.Companion.handleReceivedIntent(this, intent2, false);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) NotificationTrampolineActivity$onResume$6.INSTANCE, 6, (Object) null);
            BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, 200, (CoroutineContext) null, new NotificationTrampolineActivity$onResume$7(this, (Continuation<? super NotificationTrampolineActivity$onResume$7>) null), 2, (Object) null);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) NotificationTrampolineActivity$onResume$5.INSTANCE, 4, (Object) null);
        }
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
