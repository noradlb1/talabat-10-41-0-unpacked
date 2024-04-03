package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.internal.common.zzi;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import j$.util.DesugarCollections;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.WeakHashMap;

@Instrumented
public final class zzd extends Fragment implements LifecycleFragment, TraceFieldInterface {
    private static final WeakHashMap zza = new WeakHashMap();
    public Trace _nr_trace;
    private final Map zzb = DesugarCollections.synchronizedMap(new ArrayMap());
    /* access modifiers changed from: private */
    public int zzc = 0;
    /* access modifiers changed from: private */
    @Nullable
    public Bundle zzd;

    public static zzd zzc(FragmentActivity fragmentActivity) {
        zzd zzd2;
        WeakHashMap weakHashMap = zza;
        WeakReference weakReference = (WeakReference) weakHashMap.get(fragmentActivity);
        if (weakReference != null && (zzd2 = (zzd) weakReference.get()) != null) {
            return zzd2;
        }
        try {
            zzd zzd3 = (zzd) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
            if (zzd3 == null || zzd3.isRemoving()) {
                zzd3 = new zzd();
                fragmentActivity.getSupportFragmentManager().beginTransaction().add((Fragment) zzd3, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
            }
            weakHashMap.put(fragmentActivity, new WeakReference(zzd3));
            return zzd3;
        } catch (ClassCastException e11) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e11);
        }
    }

    public final void addCallback(String str, @NonNull LifecycleCallback lifecycleCallback) {
        if (!this.zzb.containsKey(str)) {
            this.zzb.put(str, lifecycleCallback);
            if (this.zzc > 0) {
                new zzi(Looper.getMainLooper()).post(new zzc(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("LifecycleCallback with tag " + str + " already added to this fragment.");
    }

    public final void dump(String str, @Nullable FileDescriptor fileDescriptor, PrintWriter printWriter, @Nullable String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback dump : this.zzb.values()) {
            dump.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Nullable
    public final <T extends LifecycleCallback> T getCallbackOrNull(String str, Class<T> cls) {
        return (LifecycleCallback) cls.cast(this.zzb.get(str));
    }

    @Nullable
    public final /* synthetic */ Activity getLifecycleActivity() {
        return getActivity();
    }

    public final boolean isCreated() {
        return this.zzc > 0;
    }

    public final boolean isStarted() {
        return this.zzc >= 2;
    }

    public final void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        super.onActivityResult(i11, i12, intent);
        for (LifecycleCallback onActivityResult : this.zzb.values()) {
            onActivityResult.onActivityResult(i11, i12, intent);
        }
    }

    public final void onCreate(@Nullable Bundle bundle) {
        Bundle bundle2;
        TraceMachine.startTracing("zzd");
        try {
            TraceMachine.enterMethod(this._nr_trace, "zzd#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "zzd#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        this.zzc = 1;
        this.zzd = bundle;
        for (Map.Entry entry : this.zzb.entrySet()) {
            LifecycleCallback lifecycleCallback = (LifecycleCallback) entry.getValue();
            if (bundle != null) {
                bundle2 = bundle.getBundle((String) entry.getKey());
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
        TraceMachine.exitMethod();
    }

    public final void onDestroy() {
        super.onDestroy();
        this.zzc = 5;
        for (LifecycleCallback onDestroy : this.zzb.values()) {
            onDestroy.onDestroy();
        }
    }

    public final void onResume() {
        super.onResume();
        this.zzc = 3;
        for (LifecycleCallback onResume : this.zzb.values()) {
            onResume.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry entry : this.zzb.entrySet()) {
                Bundle bundle2 = new Bundle();
                ((LifecycleCallback) entry.getValue()).onSaveInstanceState(bundle2);
                bundle.putBundle((String) entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.zzc = 2;
        for (LifecycleCallback onStart : this.zzb.values()) {
            onStart.onStart();
        }
    }

    public final void onStop() {
        super.onStop();
        this.zzc = 4;
        for (LifecycleCallback onStop : this.zzb.values()) {
            onStop.onStop();
        }
    }
}
