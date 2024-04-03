package com.instabug.library.tracking;

import com.instabug.library.model.v3Session.r;
import com.instabug.library.model.v3Session.u;
import com.instabug.library.r0;
import com.instabug.library.sessionV3.manager.i;
import com.instabug.library.util.threading.PoolProvider;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class s extends Lambda implements Function0 {

    /* renamed from: a  reason: collision with root package name */
    public static final s f51945a = new s();

    public s() {
        super(0);
    }

    /* access modifiers changed from: private */
    public static final void b() {
        PoolProvider.postIOTask(new b0());
    }

    /* access modifiers changed from: private */
    public static final void c() {
        r0.e().b();
        i.f51800a.a((u) new r());
    }

    @NotNull
    /* renamed from: a */
    public final q invoke() {
        return new a0();
    }
}
