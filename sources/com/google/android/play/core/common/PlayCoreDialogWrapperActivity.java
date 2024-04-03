package com.google.android.play.core.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.Nullable;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public class PlayCoreDialogWrapperActivity extends Activity implements TraceFieldInterface {
    public Trace _nr_trace;
    @Nullable
    private ResultReceiver zza;

    private final void zza() {
        ResultReceiver resultReceiver = this.zza;
        if (resultReceiver != null) {
            resultReceiver.send(3, new Bundle());
        }
    }

    public final void onActivityResult(int i11, int i12, Intent intent) {
        ResultReceiver resultReceiver;
        super.onActivityResult(i11, i12, intent);
        if (i11 == 0 && (resultReceiver = this.zza) != null) {
            if (i12 == -1) {
                resultReceiver.send(1, new Bundle());
            } else if (i12 == 0) {
                resultReceiver.send(2, new Bundle());
            }
        }
        finish();
    }

    public final void onCreate(Bundle bundle) {
        TraceMachine.startTracing("PlayCoreDialogWrapperActivity");
        Intent intent = null;
        try {
            TraceMachine.enterMethod(this._nr_trace, "PlayCoreDialogWrapperActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "PlayCoreDialogWrapperActivity#onCreate", (ArrayList<String>) null);
        }
        int intExtra = getIntent().getIntExtra("window_flags", 0);
        if (intExtra != 0) {
            getWindow().getDecorView().setSystemUiVisibility(intExtra);
            intent = new Intent();
            intent.putExtra("window_flags", intExtra);
        }
        Intent intent2 = intent;
        super.onCreate(bundle);
        if (bundle == null) {
            this.zza = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                zza();
                finish();
            }
            try {
                startIntentSenderForResult(((PendingIntent) extras.get("confirmation_intent")).getIntentSender(), 0, intent2, 0, 0, 0);
                TraceMachine.exitMethod();
            } catch (IntentSender.SendIntentException unused2) {
                zza();
                finish();
                TraceMachine.exitMethod();
            }
        } else {
            this.zza = (ResultReceiver) bundle.getParcelable("result_receiver");
            TraceMachine.exitMethod();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("result_receiver", this.zza);
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
