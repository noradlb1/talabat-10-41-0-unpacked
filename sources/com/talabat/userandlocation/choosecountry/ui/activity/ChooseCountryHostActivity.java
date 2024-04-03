package com.talabat.userandlocation.choosecountry.ui.activity;

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
import com.talabat.userandlocation.choosecountry.R;
import com.talabat.userandlocation.choosecountry.ui.fragment.ChooseCountryFragment;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0010"}, d2 = {"Lcom/talabat/userandlocation/choosecountry/ui/activity/ChooseCountryHostActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "addFragment", "", "chooseCountryFragment", "Lcom/talabat/userandlocation/choosecountry/ui/fragment/ChooseCountryFragment;", "onAttachFragment", "fragment", "Landroidx/fragment/app/Fragment;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupToolBar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "com_talabat_NewArchi_UserAndLocation_ChooseCountry_ChooseCountry"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ExperimentalStdlibApi
public final class ChooseCountryHostActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    private final void addFragment(ChooseCountryFragment chooseCountryFragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, chooseCountryFragment).commitNow();
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
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        super.onAttachFragment(fragment);
        if (fragment instanceof ChooseCountryFragment) {
            ((ChooseCountryFragment) fragment).setToolbarHandler(new ChooseCountryHostActivity$onAttachFragment$1(this));
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("ChooseCountryHostActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "ChooseCountryHostActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ChooseCountryHostActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(R.layout.choose_country_host_activity);
        if (bundle == null) {
            ChooseCountryFragment newInstance = ChooseCountryFragment.Companion.newInstance();
            newInstance.setArguments(getIntent().getExtras());
            addFragment(newInstance);
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
