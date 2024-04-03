package com.google.android.libraries.places.api.model;

import java.util.List;

abstract class zzc extends AddressComponents {
    private final List<AddressComponent> zza;

    public zzc(List<AddressComponent> list) {
        if (list != null) {
            this.zza = list;
            return;
        }
        throw new NullPointerException("Null asList");
    }

    public final List<AddressComponent> asList() {
        return this.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AddressComponents) {
            return this.zza.equals(((AddressComponents) obj).asList());
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() ^ 1000003;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 26);
        sb2.append("AddressComponents{asList=");
        sb2.append(valueOf);
        sb2.append("}");
        return sb2.toString();
    }
}
