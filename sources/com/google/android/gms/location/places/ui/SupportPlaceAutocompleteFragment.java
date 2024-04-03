package com.google.android.gms.location.places.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.R;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.model.LatLngBounds;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;

@Instrumented
@Deprecated
public class SupportPlaceAutocompleteFragment extends Fragment implements TraceFieldInterface {
    public Trace _nr_trace;
    private View zzde;
    private View zzdf;
    private EditText zzdg;
    /* access modifiers changed from: private */
    public boolean zzdh;
    @Nullable
    private LatLngBounds zzdi;
    @Nullable
    private AutocompleteFilter zzdj;
    @Nullable
    private PlaceSelectionListener zzdk;

    private final void zzm() {
        int i11;
        boolean z11 = !this.zzdg.getText().toString().isEmpty();
        View view = this.zzdf;
        if (z11) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        view.setVisibility(i11);
    }

    /* access modifiers changed from: private */
    public final void zzn() {
        int i11;
        try {
            Intent build = new PlaceAutocomplete.IntentBuilder(2).setBoundsBias(this.zzdi).setFilter(this.zzdj).zzg(this.zzdg.getText().toString()).zzd(1).build(getActivity());
            this.zzdh = true;
            startActivityForResult(build, 30421);
            i11 = -1;
        } catch (GooglePlayServicesRepairableException e11) {
            i11 = e11.getConnectionStatusCode();
            Log.e("Places", "Could not open autocomplete activity", e11);
        } catch (GooglePlayServicesNotAvailableException e12) {
            i11 = e12.errorCode;
            Log.e("Places", "Could not open autocomplete activity", e12);
        }
        if (i11 != -1) {
            GoogleApiAvailability.getInstance().showErrorDialogFragment(getActivity(), i11, 30422);
        }
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        this.zzdh = false;
        if (i11 == 30421) {
            if (i12 == -1) {
                Place place = PlaceAutocomplete.getPlace(getActivity(), intent);
                PlaceSelectionListener placeSelectionListener = this.zzdk;
                if (placeSelectionListener != null) {
                    placeSelectionListener.onPlaceSelected(place);
                }
                setText(place.getName().toString());
            } else if (i12 == 2) {
                Status status = PlaceAutocomplete.getStatus(getActivity(), intent);
                PlaceSelectionListener placeSelectionListener2 = this.zzdk;
                if (placeSelectionListener2 != null) {
                    placeSelectionListener2.onError(status);
                }
            }
        }
        super.onActivityResult(i11, i12, intent);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "SupportPlaceAutocompleteFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "SupportPlaceAutocompleteFragment#onCreateView", (ArrayList<String>) null);
        }
        View inflate = layoutInflater.inflate(R.layout.place_autocomplete_fragment, viewGroup, false);
        this.zzde = inflate.findViewById(R.id.place_autocomplete_search_button);
        this.zzdf = inflate.findViewById(R.id.place_autocomplete_clear_button);
        this.zzdg = (EditText) inflate.findViewById(R.id.place_autocomplete_search_input);
        zzg zzg = new zzg(this);
        this.zzde.setOnClickListener(zzg);
        this.zzdg.setOnClickListener(zzg);
        this.zzdf.setOnClickListener(new zzf(this));
        zzm();
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onDestroyView() {
        this.zzde = null;
        this.zzdf = null;
        this.zzdg = null;
        super.onDestroyView();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void setBoundsBias(@Nullable LatLngBounds latLngBounds) {
        this.zzdi = latLngBounds;
    }

    public void setFilter(@Nullable AutocompleteFilter autocompleteFilter) {
        this.zzdj = autocompleteFilter;
    }

    public void setHint(CharSequence charSequence) {
        this.zzdg.setHint(charSequence);
        this.zzde.setContentDescription(charSequence);
    }

    public void setOnPlaceSelectedListener(PlaceSelectionListener placeSelectionListener) {
        this.zzdk = placeSelectionListener;
    }

    public void setText(CharSequence charSequence) {
        this.zzdg.setText(charSequence);
        zzm();
    }
}
