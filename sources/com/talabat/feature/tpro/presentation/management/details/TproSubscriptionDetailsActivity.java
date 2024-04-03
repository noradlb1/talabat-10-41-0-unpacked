package com.talabat.feature.tpro.presentation.management.details;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.feature.tpro.presentation.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lcom/talabat/feature/tpro/presentation/management/details/TproSubscriptionDetailsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setStatusBarGradiant", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TproSubscriptionDetailsActivity extends AppCompatActivity implements TraceFieldInterface {
    public Trace _nr_trace;

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("TproSubscriptionDetailsActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "TproSubscriptionDetailsActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TproSubscriptionDetailsActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.activity_layout);
        setStatusBarGradiant();
        if (bundle == null) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            int i11 = R.id.fragmentContainer;
            TProSubscriptionDetailsFragment tProSubscriptionDetailsFragment = new TProSubscriptionDetailsFragment();
            tProSubscriptionDetailsFragment.setArguments(getIntent().getExtras());
            Unit unit = Unit.INSTANCE;
            beginTransaction.add(i11, (Fragment) tProSubscriptionDetailsFragment, TProSubscriptionDetailsFragment.TAG).commit();
        }
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

    public final void setStatusBarGradiant() {
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.bg_activity_blue_gradient);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().setStatusBarColor(ContextCompat.getColor(this, 17170445));
        getWindow().setNavigationBarColor(ContextCompat.getColor(this, 17170445));
        getWindow().setBackgroundDrawable(drawable);
    }
}
