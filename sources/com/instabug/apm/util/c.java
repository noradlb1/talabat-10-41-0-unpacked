package com.instabug.apm.util;

import androidx.annotation.VisibleForTesting;
import com.instabug.apm.fragment.model.b;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class c {
    public static final long a(@NotNull Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return ((Number) pair.getSecond()).longValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        if (r2 == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
        if (r2 == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007b, code lost:
        if (r2 == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008f, code lost:
        if (r2 == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (r2 == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00b7, code lost:
        if (r2 == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00bf, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return a(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0025, code lost:
        if (r2 == null) goto L_0x00bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003b, code lost:
        if (r2 == null) goto L_0x00bf;
     */
    @androidx.annotation.VisibleForTesting
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.instabug.apm.fragment.model.b a(@org.jetbrains.annotations.NotNull java.util.List r2, @org.jetbrains.annotations.NotNull java.lang.String r3) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "eventName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            int r0 = r3.hashCode()
            switch(r0) {
                case -1336895037: goto L_0x00a6;
                case 126661882: goto L_0x0092;
                case 248544387: goto L_0x007e;
                case 414896384: goto L_0x006a;
                case 991151364: goto L_0x0055;
                case 1046116283: goto L_0x003f;
                case 1463983852: goto L_0x0029;
                case 1498091812: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x00bf
        L_0x0013:
            java.lang.String r0 = "onViewCreated"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x001d
            goto L_0x00bf
        L_0x001d:
            java.lang.String r0 = "preViewCreated"
            java.lang.String r1 = "postViewCreated"
            kotlin.Pair r2 = a(r2, r0, r1)
            if (r2 != 0) goto L_0x00ba
            goto L_0x00bf
        L_0x0029:
            java.lang.String r0 = "onResume"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0033
            goto L_0x00bf
        L_0x0033:
            java.lang.String r0 = "preResume"
            java.lang.String r1 = "postResume"
            kotlin.Pair r2 = a(r2, r0, r1)
            if (r2 != 0) goto L_0x00ba
            goto L_0x00bf
        L_0x003f:
            java.lang.String r0 = "onCreate"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0049
            goto L_0x00bf
        L_0x0049:
            java.lang.String r0 = "preCreate"
            java.lang.String r1 = "postCreate"
            kotlin.Pair r2 = a(r2, r0, r1)
            if (r2 != 0) goto L_0x00ba
            goto L_0x00bf
        L_0x0055:
            java.lang.String r0 = "onAttach"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x005f
            goto L_0x00bf
        L_0x005f:
            java.lang.String r0 = "preAttach"
            java.lang.String r1 = "postAttach"
            kotlin.Pair r2 = a(r2, r0, r1)
            if (r2 != 0) goto L_0x00ba
            goto L_0x00bf
        L_0x006a:
            java.lang.String r0 = "onCreateView"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0073
            goto L_0x00bf
        L_0x0073:
            java.lang.String r0 = "preCreateView"
            java.lang.String r1 = "postCreateView"
            kotlin.Pair r2 = a(r2, r0, r1)
            if (r2 != 0) goto L_0x00ba
            goto L_0x00bf
        L_0x007e:
            java.lang.String r0 = "onViewStateRestored"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x0087
            goto L_0x00bf
        L_0x0087:
            java.lang.String r0 = "preViewStateRestored"
            java.lang.String r1 = "postViewStateRestored"
            kotlin.Pair r2 = a(r2, r0, r1)
            if (r2 != 0) goto L_0x00ba
            goto L_0x00bf
        L_0x0092:
            java.lang.String r0 = "onActivityCreated"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x009b
            goto L_0x00bf
        L_0x009b:
            java.lang.String r0 = "preActivityCreated"
            java.lang.String r1 = "postActivityCreated"
            kotlin.Pair r2 = a(r2, r0, r1)
            if (r2 != 0) goto L_0x00ba
            goto L_0x00bf
        L_0x00a6:
            java.lang.String r0 = "onStart"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L_0x00af
            goto L_0x00bf
        L_0x00af:
            java.lang.String r0 = "preStart"
            java.lang.String r1 = "postStart"
            kotlin.Pair r2 = a(r2, r0, r1)
            if (r2 != 0) goto L_0x00ba
            goto L_0x00bf
        L_0x00ba:
            com.instabug.apm.fragment.model.b r2 = a((kotlin.Pair) r2, (java.lang.String) r3)
            goto L_0x00c0
        L_0x00bf:
            r2 = 0
        L_0x00c0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.apm.util.c.a(java.util.List, java.lang.String):com.instabug.apm.fragment.model.b");
    }

    @VisibleForTesting
    @Nullable
    public static final b a(@Nullable Pair pair, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        if (pair == null) {
            return null;
        }
        return new b(str, b(pair), a(pair), 0, 8, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final List a(@NotNull List list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return CollectionsKt___CollectionsKt.toMutableList(CollectionsKt___CollectionsKt.filterNotNull(CollectionsKt__CollectionsKt.mutableListOf(a(list, "onAttach"), a(list, "onCreate"), a(list, "onCreateView"), a(list, "onViewCreated"), a(list, "onActivityCreated"), a(list, "onViewStateRestored"), a(list, "onStart"), a(list, "onResume"))));
    }

    @VisibleForTesting
    @Nullable
    public static final Pair a(@NotNull List list, @NotNull String str, @NotNull String str2) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(str, "preEventName");
        Intrinsics.checkNotNullParameter(str2, "postEventName");
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((b) obj).b(), (Object) str)) {
                break;
            }
        }
        b bVar = (b) obj;
        if (bVar == null) {
            return null;
        }
        long c11 = bVar.c();
        long d11 = bVar.d();
        Iterator it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it2.next();
            if (Intrinsics.areEqual((Object) ((b) obj2).b(), (Object) str2)) {
                break;
            }
        }
        b bVar2 = (b) obj2;
        if (bVar2 == null) {
            return null;
        }
        return TuplesKt.to(Long.valueOf(c11), Long.valueOf((bVar2.d() - d11) / 1000));
    }

    public static final long b(@NotNull Pair pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return ((Number) pair.getFirst()).longValue();
    }
}
