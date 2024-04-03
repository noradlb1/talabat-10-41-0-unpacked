package com.designsystem.ds_empty_state_v2;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"DSEmptyState", "", "title", "", "modifier", "Landroidx/compose/ui/Modifier;", "details", "buttonText", "onButtonTap", "Lkotlin/Function0;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSEmptyStateKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f7  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSEmptyState(@org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r18, @org.jetbrains.annotations.Nullable java.lang.String r19, @org.jetbrains.annotations.Nullable java.lang.String r20, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r21, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r10 = r17
            r11 = r23
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -755172350(0xffffffffd2fcfc02, float:-5.43279874E11)
            r1 = r22
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r24 & 1
            if (r0 == 0) goto L_0x0019
            r0 = r11 | 6
            goto L_0x0029
        L_0x0019:
            r0 = r11 & 14
            if (r0 != 0) goto L_0x0028
            boolean r0 = r12.changed((java.lang.Object) r10)
            if (r0 == 0) goto L_0x0025
            r0 = 4
            goto L_0x0026
        L_0x0025:
            r0 = 2
        L_0x0026:
            r0 = r0 | r11
            goto L_0x0029
        L_0x0028:
            r0 = r11
        L_0x0029:
            r1 = r24 & 2
            if (r1 == 0) goto L_0x0030
            r0 = r0 | 48
            goto L_0x0043
        L_0x0030:
            r2 = r11 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0043
            r2 = r18
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x003f
            r3 = 32
            goto L_0x0041
        L_0x003f:
            r3 = 16
        L_0x0041:
            r0 = r0 | r3
            goto L_0x0045
        L_0x0043:
            r2 = r18
        L_0x0045:
            r3 = r24 & 4
            if (r3 == 0) goto L_0x004c
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r4 = r11 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x005f
            r4 = r19
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x005b
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r0 = r0 | r5
            goto L_0x0061
        L_0x005f:
            r4 = r19
        L_0x0061:
            r5 = r24 & 8
            if (r5 == 0) goto L_0x0068
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r6 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x007b
            r6 = r20
            boolean r7 = r12.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0077
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r0 = r0 | r7
            goto L_0x007d
        L_0x007b:
            r6 = r20
        L_0x007d:
            r7 = r24 & 16
            r8 = 57344(0xe000, float:8.0356E-41)
            if (r7 == 0) goto L_0x0087
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0087:
            r9 = r11 & r8
            if (r9 != 0) goto L_0x009a
            r9 = r21
            boolean r13 = r12.changed((java.lang.Object) r9)
            if (r13 == 0) goto L_0x0096
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r0 = r0 | r13
            goto L_0x009c
        L_0x009a:
            r9 = r21
        L_0x009c:
            r13 = 46811(0xb6db, float:6.5596E-41)
            r13 = r13 & r0
            r13 = r13 ^ 9362(0x2492, float:1.3119E-41)
            if (r13 != 0) goto L_0x00b2
            boolean r13 = r12.getSkipping()
            if (r13 != 0) goto L_0x00ab
            goto L_0x00b2
        L_0x00ab:
            r12.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r9
            goto L_0x00f0
        L_0x00b2:
            if (r1 == 0) goto L_0x00b8
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r13 = r1
            goto L_0x00b9
        L_0x00b8:
            r13 = r2
        L_0x00b9:
            r1 = 0
            if (r3 == 0) goto L_0x00be
            r14 = r1
            goto L_0x00bf
        L_0x00be:
            r14 = r4
        L_0x00bf:
            if (r5 == 0) goto L_0x00c3
            r15 = r1
            goto L_0x00c4
        L_0x00c3:
            r15 = r6
        L_0x00c4:
            if (r7 == 0) goto L_0x00c9
            r16 = r1
            goto L_0x00cb
        L_0x00c9:
            r16 = r9
        L_0x00cb:
            r3 = 0
            r6 = 0
            r1 = r0 & 14
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r0 = r0 << 3
            r2 = r0 & r8
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r2
            r8 = r1 | r0
            r9 = 64
            r0 = r17
            r1 = r13
            r2 = r14
            r4 = r15
            r5 = r16
            r7 = r12
            com.designsystem.ds_empty_state_v2.EmptyStateComposablesKt.EmptyState(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r2 = r13
            r3 = r14
        L_0x00f0:
            androidx.compose.runtime.ScopeUpdateScope r8 = r12.endRestartGroup()
            if (r8 != 0) goto L_0x00f7
            goto L_0x0106
        L_0x00f7:
            com.designsystem.ds_empty_state_v2.DSEmptyStateKt$DSEmptyState$1 r9 = new com.designsystem.ds_empty_state_v2.DSEmptyStateKt$DSEmptyState$1
            r0 = r9
            r1 = r17
            r6 = r23
            r7 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.updateScope(r9)
        L_0x0106:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_empty_state_v2.DSEmptyStateKt.DSEmptyState(java.lang.String, androidx.compose.ui.Modifier, java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
