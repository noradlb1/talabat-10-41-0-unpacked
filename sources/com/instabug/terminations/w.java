package com.instabug.terminations;

import android.content.Context;
import com.instabug.commons.utils.b;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class w {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final w f52670a = new w();

    private w() {
    }

    public static /* synthetic */ x a(w wVar, Context context, x xVar, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            xVar = null;
        }
        if ((i11 & 4) != 0) {
            str = null;
        }
        return wVar.a(context, xVar, str);
    }

    private final boolean b(String str, boolean z11) {
        if (Intrinsics.areEqual((Object) str, (Object) "Anr")) {
            return true;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "Anr Recovery")) {
            return false;
        }
        return z11;
    }

    @NotNull
    public final x a(@NotNull Context context, @Nullable x xVar, @Nullable String str) {
        boolean z11;
        Intrinsics.checkNotNullParameter(context, "ctx");
        long currentTimeMillis = System.currentTimeMillis();
        List a11 = a(b.d(context), xVar);
        boolean z12 = false;
        if (xVar == null) {
            z11 = false;
        } else {
            z11 = xVar.d();
        }
        boolean b11 = b(str, z11);
        if (xVar != null) {
            z12 = xVar.b();
        }
        return new x(currentTimeMillis, a11, b11, a(str, z12));
    }

    private final boolean a(String str, boolean z11) {
        if (Intrinsics.areEqual((Object) str, (Object) "Crash")) {
            return true;
        }
        return z11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List a(boolean r3, com.instabug.terminations.x r4) {
        /*
            r2 = this;
            if (r4 != 0) goto L_0x0003
            goto L_0x002b
        L_0x0003:
            java.util.List r4 = r4.a()
            if (r4 != 0) goto L_0x000a
            goto L_0x002b
        L_0x000a:
            java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r4)
            if (r4 != 0) goto L_0x0011
            goto L_0x002b
        L_0x0011:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r3)
            r4.add(r0)
            int r0 = r4.size()
            r1 = 10
            if (r0 <= r1) goto L_0x0029
            int r0 = r4.size()
            r1 = 1
            java.util.List r4 = r4.subList(r1, r0)
        L_0x0029:
            if (r4 != 0) goto L_0x002d
        L_0x002b:
            r4 = 0
            goto L_0x0031
        L_0x002d:
            java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.toList(r4)
        L_0x0031:
            if (r4 != 0) goto L_0x003b
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r3)
        L_0x003b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.terminations.w.a(boolean, com.instabug.terminations.x):java.util.List");
    }
}
