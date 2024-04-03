package com.google.android.libraries.places.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.model.TypeFilter;
import com.google.android.libraries.places.internal.zzdh;
import com.google.android.libraries.places.internal.zzdv;
import com.google.android.libraries.places.internal.zzdw;
import com.google.android.libraries.places.internal.zzdx;
import com.google.android.libraries.places.internal.zzea;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import java.util.List;

public final class Autocomplete {

    public static class IntentBuilder {
        private final zzdw zza;

        public IntentBuilder(zzdx zzdx) {
            this.zza = zzdx.zzg();
        }

        @RecentlyNonNull
        public Intent build(@RecentlyNonNull Context context) {
            try {
                Intent intent = new Intent(context, AutocompleteActivity.class);
                zzdw zzdw = this.zza;
                Resources.Theme theme = context.getTheme();
                TypedValue typedValue = new TypedValue();
                if (theme.resolveAttribute(16843827, typedValue, true)) {
                    zzdw.zzi(typedValue.data);
                }
                TypedValue typedValue2 = new TypedValue();
                if (theme.resolveAttribute(16843828, typedValue2, true)) {
                    zzdw.zzj(typedValue2.data);
                }
                intent.putExtra("places/AutocompleteOptions", this.zza.zzl());
                return intent;
            } catch (Error | RuntimeException e11) {
                zzdh.zzb(e11);
                throw e11;
            }
        }

        @RecentlyNonNull
        public IntentBuilder setCountries(@RecentlyNonNull List<String> list) {
            this.zza.zza(list);
            return this;
        }

        @RecentlyNonNull
        public IntentBuilder setCountry(@Nullable String str) {
            this.zza.zzm(str);
            return this;
        }

        @RecentlyNonNull
        public IntentBuilder setHint(@Nullable String str) {
            this.zza.zzb(str);
            return this;
        }

        @RecentlyNonNull
        public IntentBuilder setInitialQuery(@Nullable String str) {
            this.zza.zzc(str);
            return this;
        }

        @RecentlyNonNull
        public IntentBuilder setLocationBias(@Nullable LocationBias locationBias) {
            this.zza.zzd(locationBias);
            return this;
        }

        @RecentlyNonNull
        public IntentBuilder setLocationRestriction(@Nullable LocationRestriction locationRestriction) {
            this.zza.zze(locationRestriction);
            return this;
        }

        @RecentlyNonNull
        public IntentBuilder setTypeFilter(@Nullable TypeFilter typeFilter) {
            this.zza.zzk(typeFilter);
            return this;
        }

        public final IntentBuilder zza(zzdv zzdv) {
            this.zza.zzg(zzdv);
            return this;
        }

        public IntentBuilder(@RecentlyNonNull AutocompleteActivityMode autocompleteActivityMode, @RecentlyNonNull List<Place.Field> list) {
            this.zza = zzdx.zzm(autocompleteActivityMode, list, zzdv.INTENT);
        }
    }

    private Autocomplete() {
    }

    @RecentlyNonNull
    public static Place getPlaceFromIntent(@RecentlyNonNull Intent intent) {
        return zzea.zzb(intent);
    }

    @RecentlyNonNull
    public static Status getStatusFromIntent(@RecentlyNonNull Intent intent) {
        return zzea.zza(intent);
    }
}
