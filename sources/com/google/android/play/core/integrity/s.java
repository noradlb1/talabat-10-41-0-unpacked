package com.google.android.play.core.integrity;

import android.os.Bundle;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.play.integrity.internal.i;
import com.google.android.play.integrity.internal.k;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;

final class s extends i {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ t f44562a;

    /* renamed from: b  reason: collision with root package name */
    private final k f44563b = new k("OnRequestIntegrityTokenCallback");

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource f44564c;

    public s(t tVar, TaskCompletionSource taskCompletionSource) {
        this.f44562a = tVar;
        this.f44564c = taskCompletionSource;
    }

    public final void b(Bundle bundle) {
        this.f44562a.f44565a.r(this.f44564c);
        this.f44563b.d("onRequestIntegrityToken", new Object[0]);
        int i11 = bundle.getInt("error");
        if (i11 != 0) {
            this.f44564c.trySetException(new IntegrityServiceException(i11, (Throwable) null));
            return;
        }
        String string = bundle.getString(LegacyTokenLocalDataSourceImpl.KEY);
        if (string == null) {
            this.f44564c.trySetException(new IntegrityServiceException(-100, (Throwable) null));
            return;
        }
        TaskCompletionSource taskCompletionSource = this.f44564c;
        d dVar = new d();
        dVar.a(string);
        taskCompletionSource.trySetResult(dVar.b());
    }
}
