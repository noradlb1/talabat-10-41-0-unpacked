package com.google.android.libraries.places.api.net;

import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.libraries.places.api.model.PhotoMetadata;

final class zzc extends FetchPhotoRequest {
    private final Integer zza;
    private final Integer zzb;
    private final PhotoMetadata zzc;
    private final CancellationToken zzd;

    public /* synthetic */ zzc(Integer num, Integer num2, PhotoMetadata photoMetadata, CancellationToken cancellationToken, zzb zzb2) {
        this.zza = num;
        this.zzb = num2;
        this.zzc = photoMetadata;
        this.zzd = cancellationToken;
    }

    public final boolean equals(Object obj) {
        CancellationToken cancellationToken;
        if (obj == this) {
            return true;
        }
        if (obj instanceof FetchPhotoRequest) {
            FetchPhotoRequest fetchPhotoRequest = (FetchPhotoRequest) obj;
            Integer num = this.zza;
            if (num != null ? num.equals(fetchPhotoRequest.getMaxWidth()) : fetchPhotoRequest.getMaxWidth() == null) {
                Integer num2 = this.zzb;
                if (num2 != null ? num2.equals(fetchPhotoRequest.getMaxHeight()) : fetchPhotoRequest.getMaxHeight() == null) {
                    if (!this.zzc.equals(fetchPhotoRequest.getPhotoMetadata()) || ((cancellationToken = this.zzd) != null ? !cancellationToken.equals(fetchPhotoRequest.getCancellationToken()) : fetchPhotoRequest.getCancellationToken() != null)) {
                        return false;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    public final CancellationToken getCancellationToken() {
        return this.zzd;
    }

    @IntRange(from = 1, to = 1600)
    @Nullable
    public final Integer getMaxHeight() {
        return this.zzb;
    }

    @IntRange(from = 1, to = 1600)
    @Nullable
    public final Integer getMaxWidth() {
        return this.zza;
    }

    public final PhotoMetadata getPhotoMetadata() {
        return this.zzc;
    }

    public final int hashCode() {
        int i11;
        int i12;
        Integer num = this.zza;
        int i13 = 0;
        if (num == null) {
            i11 = 0;
        } else {
            i11 = num.hashCode();
        }
        int i14 = (i11 ^ 1000003) * 1000003;
        Integer num2 = this.zzb;
        if (num2 == null) {
            i12 = 0;
        } else {
            i12 = num2.hashCode();
        }
        int hashCode = (((i14 ^ i12) * 1000003) ^ this.zzc.hashCode()) * 1000003;
        CancellationToken cancellationToken = this.zzd;
        if (cancellationToken != null) {
            i13 = cancellationToken.hashCode();
        }
        return hashCode ^ i13;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String valueOf2 = String.valueOf(this.zzb);
        String valueOf3 = String.valueOf(this.zzc);
        String valueOf4 = String.valueOf(this.zzd);
        int length = valueOf.length();
        int length2 = valueOf2.length();
        StringBuilder sb2 = new StringBuilder(length + 76 + length2 + valueOf3.length() + valueOf4.length());
        sb2.append("FetchPhotoRequest{maxWidth=");
        sb2.append(valueOf);
        sb2.append(", maxHeight=");
        sb2.append(valueOf2);
        sb2.append(", photoMetadata=");
        sb2.append(valueOf3);
        sb2.append(", cancellationToken=");
        sb2.append(valueOf4);
        sb2.append("}");
        return sb2.toString();
    }
}
