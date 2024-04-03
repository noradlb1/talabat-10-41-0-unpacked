package com.instabug.apm.handler.fragment;

import com.instabug.apm.cache.handler.fragments.a;
import com.instabug.apm.cache.handler.fragments.c;
import com.instabug.apm.cache.handler.session.f;
import com.instabug.apm.cache.model.d;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final b f45374a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final a f45375b = com.instabug.apm.di.a.J();

    /* renamed from: c  reason: collision with root package name */
    private static final c f45376c = com.instabug.apm.di.a.K();
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static final f f45377d = com.instabug.apm.di.a.Y();
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final com.instabug.apm.configuration.c f45378e;

    /* renamed from: f  reason: collision with root package name */
    private static final com.instabug.apm.logger.internal.a f45379f = com.instabug.apm.di.a.f();

    static {
        com.instabug.apm.configuration.c c11 = com.instabug.apm.di.a.c();
        Intrinsics.checkNotNullExpressionValue(c11, "getApmConfigurationProvider()");
        f45378e = c11;
    }

    private b() {
    }

    private final boolean b() {
        com.instabug.apm.configuration.c cVar = f45378e;
        return cVar.b() && cVar.H();
    }

    @NotNull
    public List a(@NotNull String str) {
        List list;
        Intrinsics.checkNotNullParameter(str, "sessionId");
        synchronized (this) {
            List<d> a11 = f45375b.a(str);
            list = null;
            if (!(!a11.isEmpty())) {
                a11 = null;
            }
            if (a11 != null) {
                for (d dVar : a11) {
                    dVar.a().addAll(f45376c.a(dVar.b()));
                }
                list = a11;
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
        }
        return list;
    }

    public void a() {
        synchronized (this) {
            f45375b.a();
            f fVar = f45377d;
            if (fVar != null) {
                fVar.d();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public boolean a(@NotNull com.instabug.apm.fragment.model.a aVar) {
        boolean z11;
        Intrinsics.checkNotNullParameter(aVar, "fragmentSpans");
        synchronized (this) {
            b bVar = f45374a;
            Integer num = null;
            if (!bVar.b()) {
                bVar = null;
            }
            z11 = false;
            if (bVar != null) {
                a aVar2 = f45375b;
                Long a11 = aVar2.a(aVar);
                if (a11 != null) {
                    if (!(a11.longValue() != -1)) {
                        a11 = null;
                    }
                    if (a11 != null) {
                        f45376c.a(aVar.a(), a11.longValue());
                        f fVar = f45377d;
                        if (fVar != null) {
                            fVar.f(aVar.c(), 1);
                        }
                        a11.longValue();
                        String c11 = aVar.c();
                        com.instabug.apm.configuration.c cVar = f45378e;
                        Integer a12 = aVar2.a(c11, cVar.W());
                        aVar2.a(cVar.w());
                        if (a12 != null) {
                            if (a12.intValue() > 0) {
                                z11 = true;
                            }
                            if (z11) {
                                num = a12;
                            }
                            if (num != null) {
                                int intValue = num.intValue();
                                if (fVar != null) {
                                    fVar.e(aVar.c(), intValue);
                                }
                                f45379f.a(Intrinsics.stringPlus("Fragment spans dropped count: ", Integer.valueOf(intValue)));
                            }
                        }
                        z11 = true;
                    }
                }
            }
        }
        return z11;
    }
}
