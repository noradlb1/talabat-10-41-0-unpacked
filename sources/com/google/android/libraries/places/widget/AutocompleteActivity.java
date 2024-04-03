package com.google.android.libraries.places.widget;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesStatusCodes;
import com.google.android.libraries.places.internal.zzdh;
import com.google.android.libraries.places.internal.zzdx;
import com.google.android.libraries.places.internal.zzfm;
import com.google.android.libraries.places.widget.internal.ui.AutocompleteImplFragment;
import com.google.android.libraries.places.widget.internal.ui.zzh;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
public class AutocompleteActivity extends AppCompatActivity implements PlaceSelectionListener, TraceFieldInterface {
    public static final int RESULT_ERROR = 2;
    @VisibleForTesting
    static boolean zza = true;
    public Trace _nr_trace;
    @LayoutRes
    private int zzb;
    @StyleRes
    private int zzc;
    private boolean zzd = false;

    public AutocompleteActivity() {
        super(R.layout.places_autocomplete_activity);
    }

    private final void zzc(int i11, @Nullable Place place, Status status) {
        try {
            Intent intent = new Intent();
            if (place != null) {
                intent.putExtra("places/selected_place", place);
            }
            intent.putExtra("places/status", status);
            setResult(i11, intent);
            finish();
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    @SuppressLint({"MissingSuperCall"})
    public void onCreate(@Nullable Bundle bundle) {
        boolean z11;
        TraceMachine.startTracing("AutocompleteActivity");
        try {
            TraceMachine.enterMethod(this._nr_trace, "AutocompleteActivity#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "AutocompleteActivity#onCreate", (ArrayList<String>) null);
        }
        try {
            zzfm.zzi(Places.isInitialized(), "Places must be initialized.");
            boolean z12 = false;
            if (zza) {
                if (getCallingActivity() != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zzfm.zzi(z11, "Cannot find caller. startActivityForResult should be used.");
            }
            zzdx zzdx = (zzdx) getIntent().getParcelableExtra("places/AutocompleteOptions");
            if (zzdx != null) {
                AutocompleteActivityMode autocompleteActivityMode = AutocompleteActivityMode.FULLSCREEN;
                int ordinal = zzdx.zzh().ordinal();
                if (ordinal == 0) {
                    this.zzb = R.layout.places_autocomplete_impl_fragment_fullscreen;
                    this.zzc = R.style.PlacesAutocompleteFullscreen;
                } else if (ordinal == 1) {
                    this.zzb = R.layout.places_autocomplete_impl_fragment_overlay;
                    this.zzc = R.style.PlacesAutocompleteOverlay;
                }
                getSupportFragmentManager().setFragmentFactory(new zzh(this.zzb, this, zzdx));
                setTheme(this.zzc);
                super.onCreate(bundle);
                AutocompleteImplFragment autocompleteImplFragment = (AutocompleteImplFragment) getSupportFragmentManager().findFragmentById(R.id.places_autocomplete_content);
                if (autocompleteImplFragment != null) {
                    z12 = true;
                }
                zzfm.zzh(z12);
                autocompleteImplFragment.zzh(this);
                View findViewById = findViewById(16908290);
                findViewById.setOnTouchListener(new zzb(this, autocompleteImplFragment, findViewById));
                findViewById.setOnClickListener(new zza(this));
                if (zzdx.zzj().isEmpty()) {
                    zzc(2, (Place) null, new Status((int) PlacesStatusCodes.INVALID_REQUEST, "Place Fields must not be empty."));
                    TraceMachine.exitMethod();
                    return;
                }
                TraceMachine.exitMethod();
                return;
            }
            TraceMachine.exitMethod();
            throw null;
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            TraceMachine.exitMethod();
            throw e11;
        }
    }

    public void onError(@RecentlyNonNull Status status) {
        zzc(true != status.isCanceled() ? 2 : 0, (Place) null, status);
    }

    public void onPlaceSelected(@RecentlyNonNull Place place) {
        zzc(-1, place, Status.RESULT_SUCCESS);
    }

    public void onStart() {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    public void onStop() {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public final /* synthetic */ void zza(View view) {
        if (this.zzd) {
            zzc(0, (Place) null, new Status(16));
        }
    }

    public final /* synthetic */ boolean zzb(AutocompleteImplFragment autocompleteImplFragment, View view, View view2, MotionEvent motionEvent) {
        this.zzd = false;
        View view3 = autocompleteImplFragment.getView();
        if (view3 == null || motionEvent.getY() <= ((float) view3.getBottom())) {
            return false;
        }
        this.zzd = true;
        view.performClick();
        return true;
    }
}
