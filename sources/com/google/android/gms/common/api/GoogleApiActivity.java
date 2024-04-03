package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.util.ArrayList;

@KeepName
@Instrumented
public class GoogleApiActivity extends Activity implements DialogInterface.OnCancelListener, TraceFieldInterface {
    public Trace _nr_trace;
    @VisibleForTesting
    protected int zaa = 0;

    @NonNull
    public static Intent zaa(@NonNull Context context, @NonNull PendingIntent pendingIntent, int i11, boolean z11) {
        Intent intent = new Intent(context, GoogleApiActivity.class);
        intent.putExtra(CloudMessagingReceiver.IntentKeys.PENDING_INTENT, pendingIntent);
        intent.putExtra("failing_client_id", i11);
        intent.putExtra("notify_manager", z11);
        return intent;
    }

    private final void zab() {
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            Log.e("GoogleApiActivity", "Activity started without extras");
            finish();
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) extras.get(CloudMessagingReceiver.IntentKeys.PENDING_INTENT);
        Integer num = (Integer) extras.get("error_code");
        if (pendingIntent == null && num == null) {
            Log.e("GoogleApiActivity", "Activity started without resolution");
            finish();
        } else if (pendingIntent != null) {
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 1, (Intent) null, 0, 0, 0);
                this.zaa = 1;
            } catch (ActivityNotFoundException e11) {
                if (extras.getBoolean("notify_manager", true)) {
                    GoogleApiManager.zak(this).zax(new ConnectionResult(22, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                } else {
                    String str = "Activity not found while launching " + pendingIntent.toString() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER;
                    if (Build.FINGERPRINT.contains("generic")) {
                        str = str.concat(" This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store.");
                    }
                    Log.e("GoogleApiActivity", str, e11);
                }
                this.zaa = 1;
                finish();
            } catch (IntentSender.SendIntentException e12) {
                Log.e("GoogleApiActivity", "Failed to launch pendingIntent", e12);
                finish();
            }
        } else {
            GoogleApiAvailability.getInstance().showErrorDialogFragment((Activity) this, ((Integer) Preconditions.checkNotNull(num)).intValue(), 2, (DialogInterface.OnCancelListener) this);
            this.zaa = 1;
        }
    }

    public final void onActivityResult(int i11, int i12, @NonNull Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i11 == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("notify_manager", true);
            this.zaa = 0;
            setResult(i12, intent);
            if (booleanExtra) {
                GoogleApiManager zak = GoogleApiManager.zak(this);
                if (i12 == -1) {
                    zak.zay();
                } else if (i12 == 0) {
                    zak.zax(new ConnectionResult(13, (PendingIntent) null), getIntent().getIntExtra("failing_client_id", -1));
                }
            }
        } else if (i11 == 2) {
            this.zaa = 0;
            setResult(i12, intent);
        }
        finish();
    }

    public final void onCancel(@NonNull DialogInterface dialogInterface) {
        this.zaa = 0;
        setResult(0);
        finish();
    }

    public final void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("GoogleApiActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "GoogleApiActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "GoogleApiActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        if (bundle != null) {
            this.zaa = bundle.getInt("resolution");
        }
        if (this.zaa != 1) {
            zab();
            TraceMachine.exitMethod();
            return;
        }
        TraceMachine.exitMethod();
    }

    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        bundle.putInt("resolution", this.zaa);
        super.onSaveInstanceState(bundle);
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
