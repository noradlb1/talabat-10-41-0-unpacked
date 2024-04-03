package com.google.android.play.core.integrity;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.l;
import com.google.android.play.integrity.internal.w;

final class r extends l {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ byte[] f44557a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Long f44558b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ TaskCompletionSource f44559c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ IntegrityTokenRequest f44560d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ t f44561e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(t tVar, TaskCompletionSource taskCompletionSource, byte[] bArr, Long l11, TaskCompletionSource taskCompletionSource2, IntegrityTokenRequest integrityTokenRequest) {
        super(taskCompletionSource);
        this.f44561e = tVar;
        this.f44557a = bArr;
        this.f44558b = l11;
        this.f44559c = taskCompletionSource2;
        this.f44560d = integrityTokenRequest;
    }

    public final void a(Exception exc) {
        if (exc instanceof w) {
            super.a(new IntegrityServiceException(-9, exc));
        } else {
            super.a(exc);
        }
    }

    /* JADX WARNING: type inference failed for: r0v3, types: [android.os.IInterface, com.google.android.play.integrity.internal.h] */
    public final void b() {
        try {
            this.f44561e.f44565a.e().c(t.a(this.f44561e, this.f44557a, this.f44558b), new s(this.f44561e, this.f44559c));
        } catch (RemoteException e11) {
            this.f44561e.f44566b.c(e11, "requestIntegrityToken(%s)", this.f44560d);
            this.f44559c.trySetException(new IntegrityServiceException(-100, e11));
        }
    }
}
