package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.Preconditions;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public class SupportMapFragment extends Fragment implements TraceFieldInterface {
    public Trace _nr_trace;
    private final zzaw zza = new zzaw(this);

    @NonNull
    public static SupportMapFragment newInstance() {
        return new SupportMapFragment();
    }

    public void getMapAsync(@NonNull OnMapReadyCallback onMapReadyCallback) {
        Preconditions.checkMainThread("getMapAsync must be called on the main thread.");
        Preconditions.checkNotNull(onMapReadyCallback, "callback must not be null.");
        this.zza.zzb(onMapReadyCallback);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        ClassLoader classLoader = SupportMapFragment.class.getClassLoader();
        if (!(bundle == null || classLoader == null)) {
            bundle.setClassLoader(classLoader);
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        zzaw.zza(this.zza, activity);
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("SupportMapFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "SupportMapFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SupportMapFragment#onCreate", (ArrayList<String>) null);
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onCreate(bundle);
            this.zza.onCreate(bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
            TraceMachine.exitMethod();
        }
    }

    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "SupportMapFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SupportMapFragment#onCreateView", (ArrayList<String>) null);
        }
        View onCreateView = this.zza.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setClickable(true);
        TraceMachine.exitMethod();
        return onCreateView;
    }

    public void onDestroy() {
        this.zza.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zza.onDestroyView();
        super.onDestroyView();
    }

    public final void onEnterAmbient(@Nullable Bundle bundle) {
        Preconditions.checkMainThread("onEnterAmbient must be called on the main thread.");
        zzaw zzaw = this.zza;
        if (zzaw.getDelegate() != null) {
            ((zzav) zzaw.getDelegate()).zza(bundle);
        }
    }

    public final void onExitAmbient() {
        Preconditions.checkMainThread("onExitAmbient must be called on the main thread.");
        zzaw zzaw = this.zza;
        if (zzaw.getDelegate() != null) {
            ((zzav) zzaw.getDelegate()).zzb();
        }
    }

    public void onInflate(@NonNull Activity activity, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            zzaw.zza(this.zza, activity);
            GoogleMapOptions createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", createFromAttributes);
            this.zza.onInflate(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onLowMemory() {
        this.zza.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zza.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zza.onResume();
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        ClassLoader classLoader = SupportMapFragment.class.getClassLoader();
        if (!(bundle == null || classLoader == null)) {
            bundle.setClassLoader(classLoader);
        }
        super.onSaveInstanceState(bundle);
        this.zza.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        this.zza.onStart();
    }

    public void onStop() {
        this.zza.onStop();
        super.onStop();
    }

    public void setArguments(@Nullable Bundle bundle) {
        super.setArguments(bundle);
    }

    @NonNull
    public static SupportMapFragment newInstance(@Nullable GoogleMapOptions googleMapOptions) {
        SupportMapFragment supportMapFragment = new SupportMapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        supportMapFragment.setArguments(bundle);
        return supportMapFragment;
    }
}
