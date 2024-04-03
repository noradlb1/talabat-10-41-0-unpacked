package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.IntegrityTokenRequest;

final class a extends IntegrityTokenRequest.Builder {

    /* renamed from: a  reason: collision with root package name */
    private String f44538a;

    /* renamed from: b  reason: collision with root package name */
    private Long f44539b;

    public final IntegrityTokenRequest build() {
        String str = this.f44538a;
        if (str != null) {
            return new c(str, this.f44539b, (b) null);
        }
        throw new IllegalStateException("Missing required properties: nonce");
    }

    public final IntegrityTokenRequest.Builder setCloudProjectNumber(long j11) {
        this.f44539b = Long.valueOf(j11);
        return this;
    }

    public final IntegrityTokenRequest.Builder setNonce(String str) {
        if (str != null) {
            this.f44538a = str;
            return this;
        }
        throw new NullPointerException("Null nonce");
    }
}
