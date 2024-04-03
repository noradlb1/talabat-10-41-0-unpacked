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
public class SupportStreetViewPanoramaFragment extends Fragment implements TraceFieldInterface {
    public Trace _nr_trace;
    private final zzaz zza = new zzaz(this);

    @NonNull
    public static SupportStreetViewPanoramaFragment newInstance() {
        return new SupportStreetViewPanoramaFragment();
    }

    public void getStreetViewPanoramaAsync(@NonNull OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        Preconditions.checkMainThread("getStreetViewPanoramaAsync() must be called on the main thread");
        Preconditions.checkNotNull(onStreetViewPanoramaReadyCallback, "callback must not be null.");
        this.zza.zzb(onStreetViewPanoramaReadyCallback);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        ClassLoader classLoader = SupportStreetViewPanoramaFragment.class.getClassLoader();
        if (!(bundle == null || classLoader == null)) {
            bundle.setClassLoader(classLoader);
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        zzaz.zza(this.zza, activity);
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("SupportStreetViewPanoramaFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "SupportStreetViewPanoramaFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SupportStreetViewPanoramaFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        this.zza.onCreate(bundle);
        TraceMachine.exitMethod();
    }

    @NonNull
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "SupportStreetViewPanoramaFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SupportStreetViewPanoramaFragment#onCreateView", (ArrayList<String>) null);
        }
        View onCreateView = this.zza.onCreateView(layoutInflater, viewGroup, bundle);
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

    public void onInflate(@NonNull Activity activity, @NonNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            zzaz.zza(this.zza, activity);
            this.zza.onInflate(activity, new Bundle(), bundle);
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
        ClassLoader classLoader = SupportStreetViewPanoramaFragment.class.getClassLoader();
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
    public static SupportStreetViewPanoramaFragment newInstance(@Nullable StreetViewPanoramaOptions streetViewPanoramaOptions) {
        SupportStreetViewPanoramaFragment supportStreetViewPanoramaFragment = new SupportStreetViewPanoramaFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("StreetViewPanoramaOptions", streetViewPanoramaOptions);
        supportStreetViewPanoramaFragment.setArguments(bundle);
        return supportStreetViewPanoramaFragment;
    }
}
