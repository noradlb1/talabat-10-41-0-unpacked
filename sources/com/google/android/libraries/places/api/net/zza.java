package com.google.android.libraries.places.api.net;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;

final class zza extends FetchPhotoRequest.Builder {
    private Integer zza;
    private Integer zzb;
    private PhotoMetadata zzc;
    private CancellationToken zzd;

    @Nullable
    public final CancellationToken getCancellationToken() {
        return this.zzd;
    }

    @Nullable
    public final Integer getMaxHeight() {
        return this.zzb;
    }

    @Nullable
    public final Integer getMaxWidth() {
        return this.zza;
    }

    public final FetchPhotoRequest.Builder setCancellationToken(@Nullable CancellationToken cancellationToken) {
        this.zzd = cancellationToken;
        return this;
    }

    public final FetchPhotoRequest.Builder setMaxHeight(@Nullable Integer num) {
        this.zzb = num;
        return this;
    }

    public final FetchPhotoRequest.Builder setMaxWidth(@Nullable Integer num) {
        this.zza = num;
        return this;
    }

    public final PhotoMetadata zza() {
        PhotoMetadata photoMetadata = this.zzc;
        if (photoMetadata != null) {
            return photoMetadata;
        }
        throw new IllegalStateException("Property \"photoMetadata\" has not been set");
    }

    public final FetchPhotoRequest.Builder zzb(PhotoMetadata photoMetadata) {
        if (photoMetadata != null) {
            this.zzc = photoMetadata;
            return this;
        }
        throw new NullPointerException("Null photoMetadata");
    }

    public final FetchPhotoRequest zzc() {
        PhotoMetadata photoMetadata = this.zzc;
        if (photoMetadata != null) {
            return new zzc(this.zza, this.zzb, photoMetadata, this.zzd, (zzb) null);
        }
        throw new IllegalStateException("Missing required properties: photoMetadata");
    }
}
