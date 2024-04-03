package com.google.android.play.core.integrity;

import androidx.annotation.Nullable;

final class c extends IntegrityTokenRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f44540a;

    /* renamed from: b  reason: collision with root package name */
    private final Long f44541b;

    public /* synthetic */ c(String str, Long l11, b bVar) {
        this.f44540a = str;
        this.f44541b = l11;
    }

    @Nullable
    public final Long cloudProjectNumber() {
        return this.f44541b;
    }

    public final boolean equals(Object obj) {
        Long l11;
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenRequest) {
            IntegrityTokenRequest integrityTokenRequest = (IntegrityTokenRequest) obj;
            if (!this.f44540a.equals(integrityTokenRequest.nonce()) || ((l11 = this.f44541b) != null ? !l11.equals(integrityTokenRequest.cloudProjectNumber()) : integrityTokenRequest.cloudProjectNumber() != null)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i11;
        int hashCode = this.f44540a.hashCode() ^ 1000003;
        Long l11 = this.f44541b;
        if (l11 == null) {
            i11 = 0;
        } else {
            i11 = l11.hashCode();
        }
        return (hashCode * 1000003) ^ i11;
    }

    public final String nonce() {
        return this.f44540a;
    }

    public final String toString() {
        String str = this.f44540a;
        Long l11 = this.f44541b;
        return "IntegrityTokenRequest{nonce=" + str + ", cloudProjectNumber=" + l11 + "}";
    }
}
