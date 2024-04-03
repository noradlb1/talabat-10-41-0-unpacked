package com.instabug.apm.fragment;

import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import com.instabug.apm.fragment.model.a;
import com.instabug.apm.fragment.model.b;
import com.instabug.apm.model.e;
import com.instabug.apm.util.c;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.model.common.Session;
import j$.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class t implements s {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final t f45351a = new t();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap f45352b = new HashMap();

    private t() {
    }

    public void a() {
        synchronized (this) {
            f45351a.c().clear();
            Unit unit = Unit.INSTANCE;
        }
    }

    @VisibleForTesting
    public final void a(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (fragment instanceof InstabugSpannableFragment) {
            t tVar = f45351a;
            if ((!tVar.c().containsKey(Integer.valueOf(fragment.hashCode())) ? this : null) != null) {
                tVar.c().put(Integer.valueOf(fragment.hashCode()), new a(((InstabugSpannableFragment) fragment).getInstabugName(), (String) null, (List) null, 6, (DefaultConstructorMarker) null));
                return;
            }
            return;
        }
        IBGDiagnostics.reportNonFatal(new Throwable("Couldn't get fragment name, fragment is not instance of InstabugSpannableFragment"), "Error while capturing fragment events");
    }

    public void a(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            t tVar = f45351a;
            if ((tVar.a(fragment.hashCode()) ? tVar : null) != null) {
                tVar.c().remove(Integer.valueOf(fragment.hashCode()));
            }
        }
    }

    @VisibleForTesting
    public final void a(@NotNull Fragment fragment, @NotNull String str, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        b bVar = new b(str, eVar.c(), 0, eVar.b(), 4, (DefaultConstructorMarker) null);
        a(fragment);
        a aVar = (a) Map.EL.getOrDefault(f45352b, Integer.valueOf(fragment.hashCode()), (Object) null);
        if (aVar != null) {
            aVar.a().add(bVar);
        }
    }

    @VisibleForTesting
    public final boolean a(int i11) {
        String id2;
        a aVar;
        com.instabug.apm.handler.fragment.a L = com.instabug.apm.di.a.L();
        Session b11 = com.instabug.apm.di.a.W().b();
        if (!(b11 == null || (id2 = b11.getId()) == null || (aVar = (a) f45351a.c().get(Integer.valueOf(i11))) == null)) {
            List a11 = c.a(aVar.a());
            Boolean bool = null;
            if (!(!a11.isEmpty())) {
                a11 = null;
            }
            Boolean valueOf = a11 == null ? null : Boolean.valueOf(L.a(new a(aVar.b(), id2, a11)));
            if (Intrinsics.areEqual((Object) valueOf, (Object) Boolean.TRUE)) {
                bool = valueOf;
            }
            if (bool != null) {
                bool.booleanValue();
                return true;
            }
        }
        return false;
    }

    public void b() {
        Iterator it = f45352b.entrySet().iterator();
        while (it.hasNext()) {
            if ((f45351a.a(((Number) ((Map.Entry) it.next()).getKey()).intValue()) ? this : null) != null) {
                it.remove();
            }
        }
    }

    public void b(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "preAttach", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public final HashMap c() {
        return f45352b;
    }

    public void c(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "postViewStateRestored", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void d(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "postCreate", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void e(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "preCreateView", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void f(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "postAttach", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void g(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "postCreateView", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void h(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "preViewStateRestored", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void i(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            t tVar = f45351a;
            tVar.a(fragment, "postResume", eVar);
            if ((tVar.a(fragment.hashCode()) ? tVar : null) != null) {
                tVar.c().remove(Integer.valueOf(fragment.hashCode()));
            }
        }
    }

    public void j(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "postActivityCreated", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void k(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "preCreate", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void l(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "preStart", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void m(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "preActivityCreated", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void n(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "postViewCreated", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void o(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "postStart", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void p(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "preViewCreated", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void q(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            f45351a.a(fragment, "preResume", eVar);
            Unit unit = Unit.INSTANCE;
        }
    }

    public void r(@NotNull Fragment fragment, @NotNull e eVar) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(eVar, "timeCapture");
        synchronized (this) {
            t tVar = f45351a;
            if ((tVar.a(fragment.hashCode()) ? tVar : null) != null) {
                tVar.c().remove(Integer.valueOf(fragment.hashCode()));
            }
        }
    }
}
