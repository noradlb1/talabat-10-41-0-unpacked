package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.libraries.places.internal.zzfm;
import com.google.android.libraries.places.internal.zzge;
import com.google.auto.value.AutoValue;
import java.util.List;

@AutoValue
public abstract class AddressComponent implements Parcelable {

    @AutoValue.Builder
    public static abstract class Builder {
        @RecentlyNonNull
        public AddressComponent build() {
            AddressComponent zzc = zzc();
            zzfm.zzi(!zzc.getName().isEmpty(), "Name must not be empty.");
            List<String> types = zzc.getTypes();
            for (String isEmpty : types) {
                zzfm.zzi(!TextUtils.isEmpty(isEmpty), "Types must not contain null or empty values.");
            }
            zzb(zzge.zzk(types));
            return zzc();
        }

        @RecentlyNullable
        public abstract String getShortName();

        @RecentlyNonNull
        public abstract Builder setShortName(@Nullable String str);

        public abstract Builder zzb(List<String> list);

        public abstract AddressComponent zzc();
    }

    @RecentlyNonNull
    public static Builder builder(@RecentlyNonNull String str, @RecentlyNonNull List<String> list) {
        zza zza = new zza();
        zza.zza(str);
        zza.zzb(list);
        return zza;
    }

    @RecentlyNonNull
    public abstract String getName();

    @RecentlyNullable
    public abstract String getShortName();

    @RecentlyNonNull
    public abstract List<String> getTypes();
}
