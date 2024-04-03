package com.facebook;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0006H\u0014R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/CustomTabActivity;", "Landroid/app/Activity;", "()V", "closeReceiver", "Landroid/content/BroadcastReceiver;", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CustomTabActivity extends Activity implements TraceFieldInterface {
    @NotNull
    @JvmField
    public static final String CUSTOM_TAB_REDIRECT_ACTION;
    private static final int CUSTOM_TAB_REDIRECT_REQUEST_CODE = 2;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @JvmField
    public static final String DESTROY_ACTION;
    public Trace _nr_trace;
    @Nullable
    private BroadcastReceiver closeReceiver;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/facebook/CustomTabActivity$Companion;", "", "()V", "CUSTOM_TAB_REDIRECT_ACTION", "", "CUSTOM_TAB_REDIRECT_REQUEST_CODE", "", "DESTROY_ACTION", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Class<CustomTabActivity> cls = CustomTabActivity.class;
        CUSTOM_TAB_REDIRECT_ACTION = Intrinsics.stringPlus(cls.getSimpleName(), ".action_customTabRedirect");
        DESTROY_ACTION = Intrinsics.stringPlus(cls.getSimpleName(), ".action_destroy");
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == 0) {
            Intent intent2 = new Intent(CUSTOM_TAB_REDIRECT_ACTION);
            intent2.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
            LocalBroadcastManager.getInstance(this).sendBroadcast(intent2);
            CustomTabActivity$onActivityResult$closeReceiver$1 customTabActivity$onActivityResult$closeReceiver$1 = new CustomTabActivity$onActivityResult$closeReceiver$1(this);
            LocalBroadcastManager.getInstance(this).registerReceiver(customTabActivity$onActivityResult$closeReceiver$1, new IntentFilter(DESTROY_ACTION));
            this.closeReceiver = customTabActivity$onActivityResult$closeReceiver$1;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("CustomTabActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "CustomTabActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "CustomTabActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        Intent intent = new Intent(this, CustomTabMainActivity.class);
        intent.setAction(CUSTOM_TAB_REDIRECT_ACTION);
        intent.putExtra(CustomTabMainActivity.EXTRA_URL, getIntent().getDataString());
        intent.addFlags(603979776);
        startActivityForResult(intent, 2);
        TraceMachine.exitMethod();
    }

    public void onDestroy() {
        BroadcastReceiver broadcastReceiver = this.closeReceiver;
        if (broadcastReceiver != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
        }
        super.onDestroy();
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
