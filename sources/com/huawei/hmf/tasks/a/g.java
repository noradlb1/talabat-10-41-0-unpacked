package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.util.Log;
import com.huawei.hmf.tasks.ExecuteResult;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

@Instrumented
public final class g extends Fragment implements TraceFieldInterface {

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<Activity, WeakReference<g>> f47692b = new WeakHashMap<>();
    public Trace _nr_trace;

    /* renamed from: a  reason: collision with root package name */
    private final List<WeakReference<ExecuteResult<?>>> f47693a = new ArrayList();

    private static g a(Activity activity) {
        g gVar;
        WeakHashMap<Activity, WeakReference<g>> weakHashMap = f47692b;
        WeakReference weakReference = weakHashMap.get(activity);
        if (weakReference != null && weakReference.get() != null) {
            return (g) weakReference.get();
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        try {
            g gVar2 = (g) fragmentManager.findFragmentByTag("com.huawei.hmf.tasks.lifecycle_fragment_tag");
            if (gVar2 == null) {
                try {
                    gVar = a(fragmentManager);
                } catch (ClassCastException e11) {
                    e = e11;
                    gVar = gVar2;
                    Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
                    return gVar;
                }
            } else {
                gVar = gVar2;
            }
            try {
                weakHashMap.put(activity, new WeakReference(gVar));
            } catch (ClassCastException e12) {
                e = e12;
            }
        } catch (ClassCastException e13) {
            e = e13;
            gVar = null;
            Log.e("LifecycleCallbackFrg", "found LifecycleCallbackFragment but the type do not match. " + e.getMessage());
            return gVar;
        }
        return gVar;
    }

    private static g a(FragmentManager fragmentManager) {
        g gVar = null;
        try {
            g gVar2 = new g();
            try {
                fragmentManager.beginTransaction().add(gVar2, "com.huawei.hmf.tasks.lifecycle_fragment_tag").commitAllowingStateLoss();
                return gVar2;
            } catch (Exception e11) {
                e = e11;
                gVar = gVar2;
            }
        } catch (Exception e12) {
            e = e12;
            Log.e("LifecycleCallbackFrg", "create fragment failed." + e.getMessage());
            return gVar;
        }
    }

    public static void a(Activity activity, ExecuteResult executeResult) {
        g a11 = a(activity);
        if (a11 != null) {
            synchronized (a11.f47693a) {
                a11.f47693a.add(new WeakReference(executeResult));
            }
        }
    }

    public void onStart() {
        super.onStart();
    }

    public final void onStop() {
        super.onStop();
        synchronized (this.f47693a) {
            for (WeakReference<ExecuteResult<?>> weakReference : this.f47693a) {
                ExecuteResult executeResult = (ExecuteResult) weakReference.get();
                if (executeResult != null) {
                    executeResult.cancel();
                }
            }
            this.f47693a.clear();
        }
    }
}
