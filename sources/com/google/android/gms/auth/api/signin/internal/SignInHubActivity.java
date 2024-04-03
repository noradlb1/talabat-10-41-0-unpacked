package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.util.ArrayList;

@KeepName
@Instrumented
public class SignInHubActivity extends FragmentActivity implements TraceFieldInterface {
    private static boolean zba = false;
    public Trace _nr_trace;
    private boolean zbb = false;
    private SignInConfiguration zbc;
    private boolean zbd;
    /* access modifiers changed from: private */
    public int zbe;
    /* access modifiers changed from: private */
    public Intent zbf;

    private final void zbc() {
        getSupportLoaderManager().initLoader(0, (Bundle) null, new zbw(this, (zbv) null));
        zba = false;
    }

    private final void zbd(int i11) {
        Status status = new Status(i11);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        zba = false;
    }

    private final void zbe(String str) {
        Intent intent = new Intent(str);
        if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
            intent.setPackage("com.google.android.gms");
        } else {
            intent.setPackage(getPackageName());
        }
        intent.putExtra(DarkstoresMainActivity.CONFIG_EXTRA_KEY, this.zbc);
        try {
            startActivityForResult(intent, 40962);
        } catch (ActivityNotFoundException unused) {
            this.zbb = true;
            Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
            zbd(17);
        }
    }

    public final boolean dispatchPopulateAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        return true;
    }

    public final void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        if (!this.zbb) {
            setResult(0);
            if (i11 == 40962) {
                if (intent != null) {
                    SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                    if (signInAccount != null && signInAccount.zba() != null) {
                        GoogleSignInAccount zba2 = signInAccount.zba();
                        zbn zbc2 = zbn.zbc(this);
                        GoogleSignInOptions zba3 = this.zbc.zba();
                        zba2.getClass();
                        zbc2.zbe(zba3, zba2);
                        intent.removeExtra(GoogleSignInApi.EXTRA_SIGN_IN_ACCOUNT);
                        intent.putExtra("googleSignInAccount", zba2);
                        this.zbd = true;
                        this.zbe = i12;
                        this.zbf = intent;
                        zbc();
                        return;
                    } else if (intent.hasExtra("errorCode")) {
                        int intExtra = intent.getIntExtra("errorCode", 8);
                        if (intExtra == 13) {
                            intExtra = GoogleSignInStatusCodes.SIGN_IN_CANCELLED;
                        }
                        zbd(intExtra);
                        return;
                    }
                }
                zbd(8);
            }
        }
    }

    public final void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("SignInHubActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "SignInHubActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SignInHubActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        Intent intent = getIntent();
        String action = intent.getAction();
        if (action == null) {
            TraceMachine.exitMethod();
            throw null;
        } else if ("com.google.android.gms.auth.NO_IMPL".equals(action)) {
            zbd(GoogleSignInStatusCodes.SIGN_IN_FAILED);
            TraceMachine.exitMethod();
        } else if (action.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") || action.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            Bundle bundleExtra = intent.getBundleExtra(DarkstoresMainActivity.CONFIG_EXTRA_KEY);
            if (bundleExtra != null) {
                SignInConfiguration signInConfiguration = (SignInConfiguration) bundleExtra.getParcelable(DarkstoresMainActivity.CONFIG_EXTRA_KEY);
                if (signInConfiguration == null) {
                    Log.e("AuthSignInClient", "Activity started with invalid configuration.");
                    setResult(0);
                    finish();
                    TraceMachine.exitMethod();
                    return;
                }
                this.zbc = signInConfiguration;
                if (bundle != null) {
                    boolean z11 = bundle.getBoolean("signingInGoogleApiClients");
                    this.zbd = z11;
                    if (z11) {
                        this.zbe = bundle.getInt("signInResultCode");
                        Intent intent2 = (Intent) bundle.getParcelable("signInResultData");
                        if (intent2 != null) {
                            this.zbf = intent2;
                            zbc();
                            TraceMachine.exitMethod();
                            return;
                        }
                        TraceMachine.exitMethod();
                        throw null;
                    }
                    TraceMachine.exitMethod();
                } else if (zba) {
                    setResult(0);
                    zbd(GoogleSignInStatusCodes.SIGN_IN_CURRENTLY_IN_PROGRESS);
                    TraceMachine.exitMethod();
                } else {
                    zba = true;
                    zbe(action);
                    TraceMachine.exitMethod();
                }
            } else {
                TraceMachine.exitMethod();
                throw null;
            }
        } else {
            Log.e("AuthSignInClient", "Unknown action: ".concat(String.valueOf(intent.getAction())));
            finish();
            TraceMachine.exitMethod();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        zba = false;
    }

    public final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.zbd);
        if (this.zbd) {
            bundle.putInt("signInResultCode", this.zbe);
            bundle.putParcelable("signInResultData", this.zbf);
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
