package com.instabug.terminations;

import android.content.Context;
import com.instabug.commons.utils.b;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class q {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final q f52649a = new q();

    private q() {
    }

    @NotNull
    public final r a(@NotNull Context context, @Nullable r rVar) {
        Intrinsics.checkNotNullParameter(context, "ctx");
        return new r(a(b.d(context), rVar));
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List a(boolean r3, com.instabug.terminations.r r4) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.terminations.q.a(boolean, com.instabug.terminations.r):java.util.List");
    }
}
