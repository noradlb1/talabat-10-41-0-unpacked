package com.talabat.feature.walletaddcard.presentation;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.walletaddcard.presentation.di.WalletFlutterAddCardFragment;
import java.util.ArrayList;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/walletaddcard/presentation/WalletFlutterAddCardActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "com_talabat_feature_wallet-add-card_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletFlutterAddCardActivity extends AppCompatActivity implements TraceFieldInterface {
    public Trace _nr_trace;

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("WalletFlutterAddCardActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "WalletFlutterAddCardActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "WalletFlutterAddCardActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_wallet_add_card);
        WalletFlutterAddCardFragment walletFlutterAddCardFragment = new WalletFlutterAddCardFragment();
        walletFlutterAddCardFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().replace(R.id.wallet_add_card_fragment_container, walletFlutterAddCardFragment).commit();
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
