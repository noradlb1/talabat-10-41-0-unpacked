package com.instabug.library.diagnostics.sdkEvents;

import java.util.List;

public abstract class a {
    public static /* synthetic */ void a(List list, f fVar, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            fVar = com.instabug.library.diagnostics.sdkEvents.di.a.f34336a.j();
        }
        a(list, fVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: org.json.JSONArray} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(@org.jetbrains.annotations.Nullable java.util.List r4, @org.jetbrains.annotations.NotNull com.instabug.library.diagnostics.sdkEvents.f r5) {
        /*
            java.lang.String r0 = "sdkEventsManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            if (r4 != 0) goto L_0x0008
            goto L_0x0042
        L_0x0008:
            java.util.Iterator r4 = r4.iterator()
        L_0x000c:
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 == 0) goto L_0x0027
            java.lang.Object r0 = r4.next()
            r2 = r0
            com.instabug.library.networkv2.request.RequestParameter r2 = (com.instabug.library.networkv2.request.RequestParameter) r2
            java.lang.String r2 = r2.getKey()
            java.lang.String r3 = "sdk_events"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x000c
            goto L_0x0028
        L_0x0027:
            r0 = r1
        L_0x0028:
            com.instabug.library.networkv2.request.RequestParameter r0 = (com.instabug.library.networkv2.request.RequestParameter) r0
            if (r0 != 0) goto L_0x002d
            goto L_0x0042
        L_0x002d:
            java.lang.Object r4 = r0.getValue()
            boolean r0 = r4 instanceof org.json.JSONArray
            if (r0 == 0) goto L_0x0038
            r1 = r4
            org.json.JSONArray r1 = (org.json.JSONArray) r1
        L_0x0038:
            java.util.List r4 = com.instabug.library.diagnostics.sdkEvents.mappers.b.a((org.json.JSONArray) r1)
            if (r4 != 0) goto L_0x003f
            goto L_0x0042
        L_0x003f:
            r5.a((java.util.List) r4)
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.sdkEvents.a.a(java.util.List, com.instabug.library.diagnostics.sdkEvents.f):void");
    }
}
