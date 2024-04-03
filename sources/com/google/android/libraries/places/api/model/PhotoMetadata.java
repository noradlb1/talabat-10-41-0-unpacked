package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.RecentlyNonNull;
import com.google.android.libraries.places.internal.zzfm;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class PhotoMetadata implements Parcelable {

    @AutoValue.Builder
    public static abstract class Builder {
        @RecentlyNonNull
        public PhotoMetadata build() {
            boolean z11;
            PhotoMetadata zzb = zzb();
            int width = zzb.getWidth();
            boolean z12 = false;
            if (width >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            zzfm.zzj(z11, "Width must not be < 0, but was: %s.", width);
            int height = zzb.getHeight();
            if (height >= 0) {
                z12 = true;
            }
            zzfm.zzj(z12, "Height must not be < 0, but was: %s.", height);
            zzfm.zzi(!TextUtils.isEmpty(zzb.zza()), "PhotoReference must not be null or empty.");
            return zzb;
        }

        @RecentlyNonNull
        public abstract String getAttributions();

        @IntRange(from = 0)
        public abstract int getHeight();

        @IntRange(from = 0)
        public abstract int getWidth();

        @RecentlyNonNull
        public abstract Builder setAttributions(@RecentlyNonNull String str);

        @RecentlyNonNull
        public abstract Builder setHeight(@IntRange(from = 0) int i11);

        @RecentlyNonNull
        public abstract Builder setWidth(@IntRange(from = 0) int i11);

        public abstract PhotoMetadata zzb();
    }

    @RecentlyNonNull
    public static Builder builder(@RecentlyNonNull String str) {
        zzo zzo = new zzo();
        zzo.zza(str);
        zzo.setWidth(0);
        zzo.setHeight(0);
        zzo.setAttributions("");
        return zzo;
    }

    @RecentlyNonNull
    public abstract String getAttributions();

    @IntRange(from = 0)
    public abstract int getHeight();

    @IntRange(from = 0)
    public abstract int getWidth();

    @RecentlyNonNull
    public abstract String zza();
}
