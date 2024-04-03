package com.talabat.userandlocation.compliance.verification.ui.activity;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.userandlocation.compliance.R;
import com.talabat.userandlocation.compliance.verification.ui.fragment.ComplianceUserVerificationExtras;
import com.talabat.userandlocation.compliance.verification.ui.fragment.UserVerificationFragment;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0002¨\u0006\u000f"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/ui/activity/UserVerificationHostActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onAttachFragment", "", "fragment", "Landroidx/fragment/app/Fragment;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "replaceFragmentNow", "Lcom/talabat/userandlocation/compliance/verification/ui/fragment/UserVerificationFragment;", "setupToolBar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserVerificationHostActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    private final void replaceFragmentNow(UserVerificationFragment userVerificationFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, userVerificationFragment).commitNow();
    }

    /* access modifiers changed from: private */
    public final void setupToolBar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        toolbar.setPadding(0, 0, 0, 0);
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Nullable
    public View _$_findCachedViewById(int i11) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i11));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i11);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i11), findViewById);
        return findViewById;
    }

    public void onAttachFragment(@NotNull Fragment fragment) {
        UserVerificationFragment userVerificationFragment;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        super.onAttachFragment(fragment);
        if (fragment instanceof UserVerificationFragment) {
            userVerificationFragment = (UserVerificationFragment) fragment;
        } else {
            userVerificationFragment = null;
        }
        if (userVerificationFragment != null) {
            userVerificationFragment.setToolBarHandler(new UserVerificationHostActivity$onAttachFragment$1(this));
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("UserVerificationHostActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "UserVerificationHostActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "UserVerificationHostActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.user_verification_host_activity);
        if (bundle == null) {
            replaceFragmentNow(UserVerificationFragment.Companion.newInstance((ComplianceUserVerificationExtras) getIntent().getParcelableExtra("extras")));
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
}
