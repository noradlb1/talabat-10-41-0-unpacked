package com.google.android.play.core.integrity;

import android.content.Context;
import android.os.Bundle;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.integrity.internal.e;
import com.google.android.play.integrity.internal.k;
import com.google.android.play.integrity.internal.q;
import com.google.android.play.integrity.internal.v;
import com.google.android.play.integrity.internal.y;
import java.util.ArrayList;

final class t {
    @VisibleForTesting
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    final v f44565a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final k f44566b;

    /* renamed from: c  reason: collision with root package name */
    private final String f44567c;

    public t(Context context, k kVar) {
        this.f44567c = context.getPackageName();
        this.f44566b = kVar;
        if (!y.a(context)) {
            kVar.b("Phonesky is not installed.", new Object[0]);
            this.f44565a = null;
            return;
        }
        this.f44565a = new v(context, kVar, "IntegrityService", u.f44568a, q.f44556a, (q) null, (byte[]) null);
    }

    public static /* bridge */ /* synthetic */ Bundle a(t tVar, byte[] bArr, Long l11) {
        Bundle bundle = new Bundle();
        bundle.putString("package.name", tVar.f44567c);
        bundle.putByteArray("nonce", bArr);
        bundle.putInt("playcore.integrity.version.major", 1);
        bundle.putInt("playcore.integrity.version.minor", 1);
        bundle.putInt("playcore.integrity.version.patch", 0);
        if (l11 != null) {
            bundle.putLong("cloud.prj", l11.longValue());
        }
        ArrayList<e> arrayList = new ArrayList<>();
        arrayList.add(e.c(3, System.currentTimeMillis()));
        ArrayList arrayList2 = new ArrayList();
        for (e b11 : arrayList) {
            Bundle bundle2 = new Bundle();
            bundle2.putInt("event_type", 3);
            bundle2.putLong("event_timestamp", b11.b());
            arrayList2.add(bundle2);
        }
        bundle.putParcelableArrayList("event_timestamps", new ArrayList(arrayList2));
        return bundle;
    }

    public final Task b(IntegrityTokenRequest integrityTokenRequest) {
        if (this.f44565a == null) {
            return Tasks.forException(new IntegrityServiceException(-2, (Throwable) null));
        }
        try {
            byte[] decode = Base64.decode(integrityTokenRequest.nonce(), 10);
            Long cloudProjectNumber = integrityTokenRequest.cloudProjectNumber();
            this.f44566b.d("requestIntegrityToken(%s)", integrityTokenRequest);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.f44565a.p(new r(this, taskCompletionSource, decode, cloudProjectNumber, taskCompletionSource, integrityTokenRequest), taskCompletionSource);
            return taskCompletionSource.getTask();
        } catch (IllegalArgumentException e11) {
            return Tasks.forException(new IntegrityServiceException(-13, e11));
        }
    }
}
