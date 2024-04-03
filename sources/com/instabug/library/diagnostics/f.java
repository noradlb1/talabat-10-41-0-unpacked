package com.instabug.library.diagnostics;

import kotlin.jvm.internal.Intrinsics;

public abstract class f {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.StackTraceElement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.StackTraceElement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.StackTraceElement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.StackTraceElement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.StackTraceElement} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean a(@org.jetbrains.annotations.Nullable java.lang.StackTraceElement[] r5) {
        /*
            r0 = 0
            r1 = 1
            r2 = 0
            if (r5 != 0) goto L_0x0006
            goto L_0x003c
        L_0x0006:
            int r3 = r5.length
            if (r3 != 0) goto L_0x000b
            r3 = r1
            goto L_0x000c
        L_0x000b:
            r3 = r0
        L_0x000c:
            r3 = r3 ^ r1
            if (r3 == 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r5 = r2
        L_0x0011:
            if (r5 != 0) goto L_0x0014
            goto L_0x003c
        L_0x0014:
            kotlin.sequences.Sequence r5 = kotlin.collections.ArraysKt___ArraysKt.asSequence((T[]) r5)
            if (r5 != 0) goto L_0x001b
            goto L_0x003c
        L_0x001b:
            kotlin.sequences.Sequence r5 = kotlin.sequences.SequencesKt___SequencesKt.filterNotNull(r5)
            if (r5 != 0) goto L_0x0022
            goto L_0x003c
        L_0x0022:
            java.util.Iterator r5 = r5.iterator()
        L_0x0026:
            boolean r3 = r5.hasNext()
            if (r3 == 0) goto L_0x003a
            java.lang.Object r3 = r5.next()
            r4 = r3
            java.lang.StackTraceElement r4 = (java.lang.StackTraceElement) r4
            boolean r4 = a((java.lang.StackTraceElement) r4)
            if (r4 == 0) goto L_0x0026
            r2 = r3
        L_0x003a:
            java.lang.StackTraceElement r2 = (java.lang.StackTraceElement) r2
        L_0x003c:
            if (r2 == 0) goto L_0x003f
            r0 = r1
        L_0x003f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.f.a(java.lang.StackTraceElement[]):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.StackTraceElement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.StackTraceElement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.StackTraceElement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: java.lang.StackTraceElement} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.StackTraceElement} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean b(@org.jetbrains.annotations.Nullable java.lang.StackTraceElement[] r5) {
        /*
            r0 = 0
            r1 = 0
            r2 = 1
            if (r5 != 0) goto L_0x0006
            goto L_0x004c
        L_0x0006:
            int r3 = r5.length
            if (r3 != 0) goto L_0x000b
            r3 = r2
            goto L_0x000c
        L_0x000b:
            r3 = r0
        L_0x000c:
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r5 = r1
        L_0x0011:
            if (r5 != 0) goto L_0x0014
            goto L_0x004c
        L_0x0014:
            kotlin.sequences.Sequence r5 = kotlin.collections.ArraysKt___ArraysKt.asSequence((T[]) r5)
            if (r5 != 0) goto L_0x001b
            goto L_0x004c
        L_0x001b:
            kotlin.sequences.Sequence r5 = kotlin.sequences.SequencesKt___SequencesKt.filterNotNull(r5)
            if (r5 != 0) goto L_0x0022
            goto L_0x004c
        L_0x0022:
            com.instabug.library.diagnostics.e r3 = com.instabug.library.diagnostics.e.f34287a
            kotlin.sequences.Sequence r5 = kotlin.sequences.SequencesKt___SequencesKt.dropWhile(r5, r3)
            if (r5 != 0) goto L_0x002b
            goto L_0x004c
        L_0x002b:
            kotlin.sequences.Sequence r5 = kotlin.sequences.SequencesKt___SequencesKt.drop(r5, r2)
            if (r5 != 0) goto L_0x0032
            goto L_0x004c
        L_0x0032:
            java.util.Iterator r5 = r5.iterator()
        L_0x0036:
            boolean r3 = r5.hasNext()
            if (r3 == 0) goto L_0x004a
            java.lang.Object r3 = r5.next()
            r4 = r3
            java.lang.StackTraceElement r4 = (java.lang.StackTraceElement) r4
            boolean r4 = a((java.lang.StackTraceElement) r4)
            if (r4 == 0) goto L_0x0036
            r1 = r3
        L_0x004a:
            java.lang.StackTraceElement r1 = (java.lang.StackTraceElement) r1
        L_0x004c:
            if (r1 == 0) goto L_0x004f
            r0 = r2
        L_0x004f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.diagnostics.f.b(java.lang.StackTraceElement[]):boolean");
    }

    private static final boolean a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "element.className");
        return StringsKt__StringsJVMKt.startsWith$default(className, "com.instabug", false, 2, (Object) null);
    }
}
