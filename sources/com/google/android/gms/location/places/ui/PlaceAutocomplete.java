package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLngBounds;
import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.library.model.session.config.SessionsConfigParameter;

@Deprecated
public class PlaceAutocomplete extends zzb {
    public static final int MODE_FULLSCREEN = 1;
    public static final int MODE_OVERLAY = 2;
    public static final int RESULT_ERROR = 2;

    public static class IntentBuilder extends zzc {
        public IntentBuilder(int i11) {
            super("com.google.android.gms.location.places.ui.AUTOCOMPLETE");
            this.intent.putExtra("gmscore_client_jar_version", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            this.intent.putExtra(SessionsConfigParameter.SYNC_MODE, i11);
            this.intent.putExtra("origin", 2);
        }

        public Intent build(Activity activity) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
            return super.build(activity);
        }

        public IntentBuilder setBoundsBias(@Nullable LatLngBounds latLngBounds) {
            if (latLngBounds != null) {
                this.intent.putExtra(Param.BOUNDS, latLngBounds);
            } else {
                this.intent.removeExtra(Param.BOUNDS);
            }
            return this;
        }

        public IntentBuilder setFilter(@Nullable AutocompleteFilter autocompleteFilter) {
            if (autocompleteFilter != null) {
                this.intent.putExtra("filter", autocompleteFilter);
            } else {
                this.intent.removeExtra("filter");
            }
            return this;
        }

        public final IntentBuilder zzd(int i11) {
            this.intent.putExtra("origin", 1);
            return this;
        }

        public final IntentBuilder zzg(@Nullable String str) {
            if (str != null) {
                this.intent.putExtra("initial_query", str);
            } else {
                this.intent.removeExtra("initial_query");
            }
            return this;
        }
    }

    private PlaceAutocomplete() {
    }

    public static Place getPlace(Context context, Intent intent) {
        return zzb.getPlace(context, intent);
    }

    public static Status getStatus(Context context, Intent intent) {
        return zzb.getStatus(context, intent);
    }
}
