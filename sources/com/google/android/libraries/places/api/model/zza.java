package com.google.android.libraries.places.api.model;

import androidx.annotation.Nullable;
import com.google.android.libraries.places.api.model.AddressComponent;
import java.util.List;

final class zza extends AddressComponent.Builder {
    private String zza;
    private String zzb;
    private List<String> zzc;

    @Nullable
    public final String getShortName() {
        return this.zzb;
    }

    public final AddressComponent.Builder setShortName(@Nullable String str) {
        this.zzb = str;
        return this;
    }

    public final AddressComponent.Builder zza(String str) {
        if (str != null) {
            this.zza = str;
            return this;
        }
        throw new NullPointerException("Null name");
    }

    public final AddressComponent.Builder zzb(List<String> list) {
        if (list != null) {
            this.zzc = list;
            return this;
        }
        throw new NullPointerException("Null types");
    }

    public final AddressComponent zzc() {
        List<String> list;
        String str = this.zza;
        if (str != null && (list = this.zzc) != null) {
            return new zzz(str, this.zzb, list);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.zza == null) {
            sb2.append(" name");
        }
        if (this.zzc == null) {
            sb2.append(" types");
        }
        String valueOf = String.valueOf(sb2);
        StringBuilder sb3 = new StringBuilder(valueOf.length() + 28);
        sb3.append("Missing required properties:");
        sb3.append(valueOf);
        throw new IllegalStateException(sb3.toString());
    }
}
