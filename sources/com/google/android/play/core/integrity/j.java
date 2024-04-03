package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.aa;
import com.google.android.play.integrity.internal.ab;
import com.google.android.play.integrity.internal.ac;
import com.google.android.play.integrity.internal.z;

final class j {

    /* renamed from: a  reason: collision with root package name */
    private final j f44545a = this;

    /* renamed from: b  reason: collision with root package name */
    private final ac f44546b;

    /* renamed from: c  reason: collision with root package name */
    private final ac f44547c;

    /* renamed from: d  reason: collision with root package name */
    private final ac f44548d;

    /* renamed from: e  reason: collision with root package name */
    private final ac f44549e;

    public /* synthetic */ j(Context context, i iVar) {
        aa b11 = ab.b(context);
        this.f44546b = b11;
        ac b12 = z.b(o.f44555a);
        this.f44547c = b12;
        ac b13 = z.b(new v(b11, b12));
        this.f44548d = b13;
        this.f44549e = z.b(new n(b13));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.f44549e.a();
    }
}
