package com.google.android.exoplayer2.source.dash.manifest;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;

public final class Descriptor {
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    public final String f35023id;
    public final String schemeIdUri;
    @Nullable
    public final String value;

    public Descriptor(String str, @Nullable String str2, @Nullable String str3) {
        this.schemeIdUri = str;
        this.value = str2;
        this.f35023id = str3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Descriptor.class != obj.getClass()) {
            return false;
        }
        Descriptor descriptor = (Descriptor) obj;
        if (!Util.areEqual(this.schemeIdUri, descriptor.schemeIdUri) || !Util.areEqual(this.value, descriptor.value) || !Util.areEqual(this.f35023id, descriptor.f35023id)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i11;
        int hashCode = this.schemeIdUri.hashCode() * 31;
        String str = this.value;
        int i12 = 0;
        if (str != null) {
            i11 = str.hashCode();
        } else {
            i11 = 0;
        }
        int i13 = (hashCode + i11) * 31;
        String str2 = this.f35023id;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        return i13 + i12;
    }
}
