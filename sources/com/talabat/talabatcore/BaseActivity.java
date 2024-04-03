package com.talabat.talabatcore;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bH&J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcore/BaseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "addFragment", "", "savedInstanceState", "Landroid/os/Bundle;", "fragment", "Lcom/talabat/talabatcore/BaseFragment;", "Lcom/talabat/talabatcore/viewmodel/BaseViewModel;", "getLayoutId", "", "onBackPressed", "", "onCreate", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class BaseActivity extends AppCompatActivity implements TraceFieldInterface {
    @NotNull
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    public Trace _nr_trace;

    private final Object addFragment(Bundle bundle) {
        if (bundle != null) {
            return bundle;
        }
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        int i11 = R.id.fragmentContainer;
        BaseFragment fragment = fragment();
        fragment.setArguments(getIntent().getExtras());
        Unit unit = Unit.INSTANCE;
        FragmentTransaction add = beginTransaction.add(i11, (Fragment) fragment);
        Intrinsics.checkNotNullExpressionValue(add, "add(\n                   …s }\n                    )");
        return Integer.valueOf(add.commit());
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

    public void _nr_setTrace(Trace trace) {
        try {
            this._nr_trace = trace;
        } catch (Exception unused) {
        }
    }

    @NotNull
    public abstract BaseFragment fragment();

    public int getLayoutId() {
        return R.layout.activity_layout;
    }

    public void onBackPressed() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
        if (findFragmentById != null) {
            ((BaseFragment) findFragmentById).onBackPressed();
            super.onBackPressed();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.talabat.talabatcore.BaseFragment<*>");
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("BaseActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "BaseActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "BaseActivity#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        setContentView(getLayoutId());
        addFragment(bundle);
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
