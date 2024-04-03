package com.google.android.libraries.places.api.model;

import androidx.annotation.Nullable;
import java.util.List;

abstract class zzb extends AddressComponent {
    private final String zza;
    private final String zzb;
    private final List<String> zzc;

    public zzb(String str, @Nullable String str2, List<String> list) {
        if (str != null) {
            this.zza = str;
            this.zzb = str2;
            if (list != null) {
                this.zzc = list;
                return;
            }
            throw new NullPointerException("Null types");
        }
        throw new NullPointerException("Null name");
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof AddressComponent) {
            AddressComponent addressComponent = (AddressComponent) obj;
            if (!this.zza.equals(addressComponent.getName()) || ((str = this.zzb) != null ? !str.equals(addressComponent.getShortName()) : addressComponent.getShortName() != null) || !this.zzc.equals(addressComponent.getTypes())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final String getName() {
        return this.zza;
    }

    @Nullable
    public final String getShortName() {
        return this.zzb;
    }

    public final List<String> getTypes() {
        return this.zzc;
    }

    public final int hashCode() {
        int i11;
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        String str = this.zzb;
        if (str == null) {
            i11 = 0;
        } else {
            i11 = str.hashCode();
        }
        return ((hashCode ^ i11) * 1000003) ^ this.zzc.hashCode();
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String valueOf = String.valueOf(this.zzc);
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(length + 43 + String.valueOf(str2).length() + valueOf.length());
        sb2.append("AddressComponent{name=");
        sb2.append(str);
        sb2.append(", shortName=");
        sb2.append(str2);
        sb2.append(", types=");
        sb2.append(valueOf);
        sb2.append("}");
        return sb2.toString();
    }
}
