package com.instabug.terminations;

import android.content.Context;
import com.instabug.commons.logging.a;
import com.instabug.commons.snapshot.FileKtxKt;
import com.instabug.commons.snapshot.d;
import com.instabug.commons.snapshot.e;
import com.instabug.terminations.cache.b;
import java.io.File;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class g extends d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final e f52620a;

    static {
        new a((DefaultConstructorMarker) null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(@NotNull e eVar) {
        super(eVar.b());
        Intrinsics.checkNotNullParameter(eVar, "configurations");
        this.f52620a = eVar;
    }

    @NotNull
    public abstract b0 a(@NotNull Context context, @Nullable Object obj);

    public final void c() {
        if (!Thread.currentThread().isInterrupted()) {
            k(new f(this));
        }
    }

    @NotNull
    public final String d() {
        return "TerminationSnapshot";
    }

    public final long e() {
        return 2;
    }

    public final int getId() {
        return 2;
    }

    public final void k(@NotNull Function2 function2) {
        File file;
        Object obj;
        Intrinsics.checkNotNullParameter(function2, "snapshotGetter");
        a.b("Capturing Termination snapshot");
        File c11 = this.f52620a.c();
        if (c11 != null) {
            com.instabug.terminations.cache.a aVar = b.f52598b;
            File f11 = aVar.f(c11);
            File file2 = null;
            if (!f11.exists()) {
                f11 = null;
            }
            if (f11 != null) {
                aVar.j(f11);
            }
            Context a11 = l().a();
            if (a11 != null) {
                if (c11.exists()) {
                    file = c11;
                } else {
                    file = null;
                }
                if (file == null) {
                    c11.mkdirs();
                    Unit unit = Unit.INSTANCE;
                }
                File e11 = aVar.e(c11);
                if (!e11.exists()) {
                    e11 = null;
                }
                if (e11 == null) {
                    obj = null;
                } else {
                    obj = FileKtxKt.readSerializableAsAny(e11);
                }
                FileKtxKt.writeSerializable(aVar.f(c11), (Serializable) function2.invoke(a11, obj));
            }
            File e12 = aVar.e(c11);
            if (e12.exists()) {
                file2 = e12;
            }
            if (file2 != null) {
                file2.delete();
            }
        }
    }

    @NotNull
    public final e l() {
        return this.f52620a;
    }
}
