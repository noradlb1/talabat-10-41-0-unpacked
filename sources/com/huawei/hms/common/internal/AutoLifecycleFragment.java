package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.SparseArray;
import com.huawei.hms.api.HuaweiApiClient;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public class AutoLifecycleFragment extends Fragment implements TraceFieldInterface {
    public Trace _nr_trace;

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<a> f48134a = new SparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private boolean f48135b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final HuaweiApiClient f48136a;

        /* renamed from: b  reason: collision with root package name */
        protected final int f48137b;

        public a(int i11, HuaweiApiClient huaweiApiClient) {
            this.f48136a = huaweiApiClient;
            this.f48137b = i11;
        }

        public void a() {
            this.f48136a.disconnect();
        }
    }

    public static AutoLifecycleFragment getInstance(Activity activity) {
        Preconditions.checkMainThread("Must be called on the main thread");
        try {
            AutoLifecycleFragment autoLifecycleFragment = (AutoLifecycleFragment) activity.getFragmentManager().findFragmentByTag("HmsAutoLifecycleFrag");
            FragmentManager fragmentManager = activity.getFragmentManager();
            if (autoLifecycleFragment != null) {
                return autoLifecycleFragment;
            }
            AutoLifecycleFragment autoLifecycleFragment2 = new AutoLifecycleFragment();
            fragmentManager.beginTransaction().add(autoLifecycleFragment2, "HmsAutoLifecycleFrag").commitAllowingStateLoss();
            fragmentManager.executePendingTransactions();
            return autoLifecycleFragment2;
        } catch (ClassCastException e11) {
            throw new IllegalStateException("Fragment with tag HmsAutoLifecycleFrag is not a AutoLifecycleFragment", e11);
        }
    }

    public void onCreate(Bundle bundle) {
        TraceMachine.startTracing("AutoLifecycleFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "AutoLifecycleFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "AutoLifecycleFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        TraceMachine.exitMethod();
    }

    public void onStart() {
        super.onStart();
        this.f48135b = true;
        for (int i11 = 0; i11 < this.f48134a.size(); i11++) {
            this.f48134a.valueAt(i11).f48136a.connect((Activity) null);
        }
    }

    public void onStop() {
        super.onStop();
        this.f48135b = false;
        for (int i11 = 0; i11 < this.f48134a.size(); i11++) {
            this.f48134a.valueAt(i11).f48136a.disconnect();
        }
    }

    public void startAutoMange(int i11, HuaweiApiClient huaweiApiClient) {
        boolean z11;
        Preconditions.checkNotNull(huaweiApiClient, "HuaweiApiClient instance cannot be null");
        if (this.f48134a.indexOfKey(i11) < 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkState(z11, "Already managing a HuaweiApiClient with this clientId: " + i11);
        this.f48134a.put(i11, new a(i11, huaweiApiClient));
        if (this.f48135b) {
            huaweiApiClient.connect((Activity) null);
        }
    }

    public void stopAutoManage(int i11) {
        a aVar = this.f48134a.get(i11);
        this.f48134a.remove(i11);
        if (aVar != null) {
            aVar.a();
        }
    }
}
