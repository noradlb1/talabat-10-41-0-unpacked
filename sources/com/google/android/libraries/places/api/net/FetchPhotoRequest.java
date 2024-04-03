package com.google.android.libraries.places.api.net;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.internal.zzcz;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class FetchPhotoRequest implements zzcz {

    @AutoValue.Builder
    public static abstract class Builder {
        @RecentlyNonNull
        public FetchPhotoRequest build() {
            PhotoMetadata zza = zza();
            if (getMaxWidth() == null && getMaxHeight() == null) {
                int width = zza.getWidth();
                if (width > 0) {
                    setMaxWidth(Integer.valueOf(width));
                }
                int height = zza.getHeight();
                if (height > 0) {
                    setMaxHeight(Integer.valueOf(height));
                }
            }
            return zzc();
        }

        @RecentlyNullable
        public abstract CancellationToken getCancellationToken();

        @RecentlyNullable
        public abstract Integer getMaxHeight();

        @RecentlyNullable
        public abstract Integer getMaxWidth();

        @RecentlyNonNull
        public abstract Builder setCancellationToken(@Nullable CancellationToken cancellationToken);

        @RecentlyNonNull
        public abstract Builder setMaxHeight(@IntRange(from = 1, to = 1600) @Nullable Integer num);

        @RecentlyNonNull
        public abstract Builder setMaxWidth(@IntRange(from = 1, to = 1600) @Nullable Integer num);

        @Nullable
        public abstract PhotoMetadata zza();

        public abstract FetchPhotoRequest zzc();
    }

    @RecentlyNonNull
    public static Builder builder(@RecentlyNonNull PhotoMetadata photoMetadata) {
        zza zza = new zza();
        zza.zzb(photoMetadata);
        return zza;
    }

    @RecentlyNonNull
    public static FetchPhotoRequest newInstance(@RecentlyNonNull PhotoMetadata photoMetadata) {
        return builder(photoMetadata).build();
    }

    @RecentlyNullable
    public abstract CancellationToken getCancellationToken();

    @IntRange(from = 1, to = 1600)
    @RecentlyNullable
    public abstract Integer getMaxHeight();

    @IntRange(from = 1, to = 1600)
    @RecentlyNullable
    public abstract Integer getMaxWidth();

    @RecentlyNonNull
    public abstract PhotoMetadata getPhotoMetadata();
}
