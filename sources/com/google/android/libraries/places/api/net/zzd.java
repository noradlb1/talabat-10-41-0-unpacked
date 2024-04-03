package com.google.android.libraries.places.api.net;

import android.graphics.Bitmap;

final class zzd extends FetchPhotoResponse {
    private final Bitmap zza;

    public zzd(Bitmap bitmap) {
        if (bitmap != null) {
            this.zza = bitmap;
            return;
        }
        throw new NullPointerException("Null bitmap");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FetchPhotoResponse) {
            return this.zza.equals(((FetchPhotoResponse) obj).getBitmap());
        }
        return false;
    }

    public final Bitmap getBitmap() {
        return this.zza;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ 1000003;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 27);
        sb2.append("FetchPhotoResponse{bitmap=");
        sb2.append(valueOf);
        sb2.append("}");
        return sb2.toString();
    }
}
