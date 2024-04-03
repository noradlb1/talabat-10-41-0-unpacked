package com.google.android.libraries.places.widget;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import com.google.android.libraries.places.R;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.internal.zzdh;
import com.google.android.libraries.places.internal.zzdv;
import com.google.android.libraries.places.internal.zzdw;
import com.google.android.libraries.places.internal.zzdx;
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
public class AutocompleteSupportFragment extends Fragment implements TraceFieldInterface {
    public Trace _nr_trace;
    private final MutableLiveData<CharSequence> zza = new MutableLiveData<>();
    private final MutableLiveData<CharSequence> zzb = new MutableLiveData<>();
    private zzdw zzc = zzdx.zzm(AutocompleteActivityMode.OVERLAY, zzge.zzm(), zzdv.FRAGMENT);
    @Nullable
    private PlaceSelectionListener zzd;

    public AutocompleteSupportFragment() {
        super(R.layout.places_autocomplete_fragment);
    }

    @RecentlyNonNull
    public static AutocompleteSupportFragment newInstance() {
        return new AutocompleteSupportFragment();
    }

    public static /* synthetic */ void zzd(EditText editText, View view, CharSequence charSequence) {
        try {
            editText.setHint(charSequence);
            view.setContentDescription(charSequence);
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    private final void zze() {
        Intent build = new Autocomplete.IntentBuilder(this.zzc.zzl()).build(requireContext());
        if (requireView().isEnabled()) {
            requireView().setEnabled(false);
            startActivityForResult(build, 30421);
        }
    }

    private final void zzf(View view) {
        int i11;
        if (true != TextUtils.isEmpty(this.zza.getValue())) {
            i11 = 0;
        } else {
            i11 = 8;
        }
        view.setVisibility(i11);
    }

    public void onActivityResult(int i11, int i12, @Nullable Intent intent) {
        if (i11 == 30421) {
            try {
                PlaceSelectionListener placeSelectionListener = this.zzd;
                if (placeSelectionListener == null) {
                    if (Log.isLoggable("Places", 5)) {
                        Log.w("Places", "No PlaceSelectionListener is set. No result will be delivered.");
                    }
                } else if (intent == null) {
                    if (Log.isLoggable("Places", 6)) {
                        Log.e("Places", "Intent data was null.");
                    }
                } else if (i12 == -1) {
                    Place placeFromIntent = Autocomplete.getPlaceFromIntent(intent);
                    placeSelectionListener.onPlaceSelected(placeFromIntent);
                    setText(placeFromIntent.getName());
                } else {
                    placeSelectionListener.onError(Autocomplete.getStatusFromIntent(intent));
                }
            } catch (Error | RuntimeException e11) {
                zzdh.zzb(e11);
                throw e11;
            }
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        TraceMachine.startTracing("AutocompleteSupportFragment");
        try {
            TraceMachine.enterMethod(this._nr_trace, "AutocompleteSupportFragment#onCreate", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "AutocompleteSupportFragment#onCreate", (ArrayList<String>) null);
        }
        super.onCreate(bundle);
        if (bundle != null) {
            try {
                zzdx zzdx = (zzdx) bundle.getParcelable("options");
                if (zzdx != null) {
                    if (this.zza.getValue() == null) {
                        this.zza.postValue(zzdx.zzl());
                    }
                    if (this.zzb.getValue() == null) {
                        this.zzb.postValue(zzdx.zzk());
                    }
                    this.zzc = zzdx.zzg();
                    TraceMachine.exitMethod();
                    return;
                }
            } catch (Error | RuntimeException e11) {
                zzdh.zzb(e11);
                TraceMachine.exitMethod();
                throw e11;
            }
        }
        TraceMachine.exitMethod();
    }

    public void onResume() {
        super.onResume();
        requireView().setEnabled(true);
    }

    public void onSaveInstanceState(@RecentlyNonNull Bundle bundle) {
        bundle.putParcelable("options", this.zzc.zzl());
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(@RecentlyNonNull View view, @Nullable Bundle bundle) {
        View findViewById = view.findViewById(R.id.places_autocomplete_search_button);
        View findViewById2 = view.findViewById(R.id.places_autocomplete_clear_button);
        EditText editText = (EditText) view.findViewById(R.id.places_autocomplete_search_input);
        findViewById.setOnClickListener(new zze(this));
        editText.setOnClickListener(new zzf(this));
        findViewById2.setOnClickListener(new zzg(this));
        zzf(findViewById2);
        this.zza.observe(getViewLifecycleOwner(), new zzi(this, editText, findViewById2));
        this.zzb.observe(getViewLifecycleOwner(), new zzh(editText, findViewById));
    }

    @RecentlyNonNull
    public AutocompleteSupportFragment setActivityMode(@RecentlyNonNull AutocompleteActivityMode autocompleteActivityMode) {
        this.zzc.zzf(autocompleteActivityMode);
        return this;
    }

    @RecentlyNonNull
    public AutocompleteSupportFragment setCountries(@RecentlyNonNull List<String> list) {
        this.zzc.zza(list);
        return this;
    }

    @RecentlyNonNull
    public AutocompleteSupportFragment setCountry(@Nullable String str) {
        this.zzc.zzm(str);
        return this;
    }

    @RecentlyNonNull
    public AutocompleteSupportFragment setHint(@Nullable CharSequence charSequence) {
        if (charSequence == null) {
            try {
                String string = getString(R.string.places_autocomplete_search_hint);
                this.zzc.zzb(string);
                this.zzb.postValue(string);
            } catch (Error | RuntimeException e11) {
                zzdh.zzb(e11);
                throw e11;
            }
        } else {
            this.zzc.zzb(charSequence.toString());
            this.zzb.postValue(charSequence);
        }
        return this;
    }

    @RecentlyNonNull
    public AutocompleteSupportFragment setLocationBias(@Nullable LocationBias locationBias) {
        this.zzc.zzd(locationBias);
        return this;
    }

    @RecentlyNonNull
    public AutocompleteSupportFragment setLocationRestriction(@Nullable LocationRestriction locationRestriction) {
        this.zzc.zze(locationRestriction);
        return this;
    }

    @RecentlyNonNull
    public AutocompleteSupportFragment setOnPlaceSelectedListener(@Nullable PlaceSelectionListener placeSelectionListener) {
        this.zzd = placeSelectionListener;
        return this;
    }

    @RecentlyNonNull
    public AutocompleteSupportFragment setPlaceFields(@RecentlyNonNull List<Place.Field> list) {
        this.zzc.zzh(list);
        return this;
    }

    @RecentlyNonNull
    public AutocompleteSupportFragment setText(@Nullable CharSequence charSequence) {
        String str;
        try {
            zzdw zzdw = this.zzc;
            if (TextUtils.isEmpty(charSequence)) {
                str = null;
            } else {
                str = charSequence.toString();
            }
            zzdw.zzc(str);
            this.zza.postValue(charSequence);
            return this;
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    @RecentlyNonNull
    public AutocompleteSupportFragment setTypeFilter(@Nullable TypeFilter typeFilter) {
        this.zzc.zzk(typeFilter);
        return this;
    }

    public final /* synthetic */ void zza(View view) {
        zze();
    }

    public final /* synthetic */ void zzb(View view) {
        zze();
    }

    public final /* synthetic */ void zzc(EditText editText, View view, CharSequence charSequence) {
        try {
            editText.setText(charSequence);
            zzf(view);
        } catch (Error | RuntimeException e11) {
            zzdh.zzb(e11);
            throw e11;
        }
    }

    @RecentlyNonNull
    public AutocompleteSupportFragment setCountries(@RecentlyNonNull String... strArr) {
        this.zzc.zza(zzge.zzl(strArr));
        return this;
    }
}
