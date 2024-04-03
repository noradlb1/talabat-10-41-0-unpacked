package com.google.android.gms.location.places;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;
import java.util.Locale;

@Deprecated
public final class PlacesOptions implements Api.ApiOptions.Optional {
    @Nullable
    private final Locale locale;
    @Nullable
    public final String zzas;
    @Nullable
    public final String zzat;
    public final int zzau;
    @Nullable
    public final String zzav;

    public static class Builder {
        private int zzau = 0;

        public PlacesOptions build() {
            return new PlacesOptions(this);
        }
    }

    private PlacesOptions(Builder builder) {
        this.zzas = null;
        this.zzat = null;
        this.zzau = 0;
        this.zzav = null;
        this.locale = null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PlacesOptions) || !Objects.equal((Object) null, (Object) null) || !Objects.equal((Object) null, (Object) null) || !Objects.equal(0, 0) || !Objects.equal((Object) null, (Object) null) || !Objects.equal((Object) null, (Object) null)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(null, null, 0, null, null);
    }
}
