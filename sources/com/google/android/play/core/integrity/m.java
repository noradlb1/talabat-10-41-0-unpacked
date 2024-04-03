package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;

final class m implements IntegrityManager {

    /* renamed from: a  reason: collision with root package name */
    private final t f44551a;

    public m(t tVar) {
        this.f44551a = tVar;
    }

    public final Task<IntegrityTokenResponse> requestIntegrityToken(IntegrityTokenRequest integrityTokenRequest) {
        return this.f44551a.b(integrityTokenRequest);
    }
}
