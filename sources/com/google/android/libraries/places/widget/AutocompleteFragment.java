package com.google.android.libraries.places.widget;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.internal.zzdh;
import com.google.android.libraries.places.internal.zzdv;
import com.google.android.libraries.places.internal.zzfm;
import com.google.android.libraries.places.internal.zzge;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.List;

@Instrumented
@Deprecated
public class AutocompleteFragment extends Fragment implements TraceFieldInterface {
    public Trace _nr_trace;
    private View zza;
    private View zzb;
    private EditText zzc;
    @Nullable
    private LocationBias zzd;
    @Nullable
    private LocationRestriction zze;
    @Nullable
    private String zzf;
    @Nullable
    private TypeFilter zzg;
    @Nullable
    private zzge<Place.Field> zzh;
    @Nullable
    private PlaceSelectionListener zzi;

    private final void zzb() {
        int i11;
        boolean isEmpty = this.zzc.getText().toString().isEmpty();
        View view = this.zzb;
        if (true != isEmpty) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        view.setVisibility(i11);
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        try {
            getView().setEnabled(true);
            if (i11 == 30421) {
                if (this.zzi == null) {
                    if (Log.isLoggable("Places", 5)) {
                        Log.w("Places", "No PlaceSelectionListener is set. No result will be delivered.");
                    }
                } else if (i12 == -1) {
                    Place placeFromIntent = Autocomplete.getPlaceFromIntent(intent);
                    this.zzi.onPlaceSelected(placeFromIntent);
                    setText(placeFromIntent.getName());
                } else if (i12 == 2) {
                    this.zzi.onError(Autocomplete.getStatusFromIntent(intent));
                    i12 = 2;
                }
                i11 = 30421;
            }
            super.onActivityResult(i11, i12, intent);
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    @RecentlyNonNull
    public View onCreateView(@RecentlyNonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "AutocompleteFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "AutocompleteFragment#onCreateView", (ArrayList<String>) null);
        }
        try {
            View inflate = layoutInflater.inflate(R.layout.places_autocomplete_fragment, viewGroup, false);
            this.zza = inflate.findViewById(R.id.places_autocomplete_search_button);
            this.zzb = inflate.findViewById(R.id.places_autocomplete_clear_button);
            this.zzc = (EditText) inflate.findViewById(R.id.places_autocomplete_search_input);
            zzc zzc2 = new zzc(this);
            this.zza.setOnClickListener(zzc2);
            this.zzc.setOnClickListener(zzc2);
            this.zzb.setOnClickListener(new zzd(this));
            zzb();
            inflate.setEnabled(false);
            TraceMachine.exitMethod();
            return inflate;
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            TraceMachine.exitMethod();
            throw e11;
        }
    }

    public void onDestroyView() {
        try {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            super.onDestroyView();
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void setCountry(@Nullable String str) {
        this.zzf = str;
    }

    public void setHint(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            try {
                charSequence = getString(R.string.places_autocomplete_search_hint);
            } catch (Error | RuntimeException e11) {
                zzdh.zzb(e11);
                throw e11;
            }
        }
        this.zzc.setHint(charSequence);
        this.zza.setContentDescription(charSequence);
    }

    public void setLocationBias(@Nullable LocationBias locationBias) {
        this.zzd = locationBias;
    }

    public void setLocationRestriction(@Nullable LocationRestriction locationRestriction) {
        this.zze = locationRestriction;
    }

    public void setOnPlaceSelectedListener(@Nullable PlaceSelectionListener placeSelectionListener) {
        this.zzi = placeSelectionListener;
    }

    public void setPlaceFields(@RecentlyNonNull List<Place.Field> list) {
        try {
            zzfm.zzc(list, "Place Fields must not be null.");
            this.zzh = zzge.zzk(list);
            getView().setEnabled(true);
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    public void setText(@Nullable CharSequence charSequence) {
        try {
            this.zzc.setText(charSequence);
            zzb();
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    public void setTypeFilter(@Nullable TypeFilter typeFilter) {
        this.zzg = typeFilter;
    }

    public final /* synthetic */ void zza(View view) {
        if (!getView().isEnabled()) {
            zzfm.zzc(this.zzh, "Place Fields must be set.");
            if (Log.isLoggable("Places", 6)) {
                Log.e("Places", "Autocomplete activity cannot be launched until fragment is enabled.");
                return;
            }
            return;
        }
        Autocomplete.IntentBuilder intentBuilder = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, this.zzh);
        intentBuilder.setInitialQuery(this.zzc.getText().toString());
        intentBuilder.setHint(this.zzc.getHint().toString());
        intentBuilder.setCountry(this.zzf);
        intentBuilder.setLocationBias(this.zzd);
        intentBuilder.setLocationRestriction(this.zze);
        intentBuilder.setTypeFilter(this.zzg);
        intentBuilder.zza(zzdv.FRAGMENT);
        Intent build = intentBuilder.build(getActivity());
        getView().setEnabled(false);
        startActivityForResult(build, 30421);
    }
}
