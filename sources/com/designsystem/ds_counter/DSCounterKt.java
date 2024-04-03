package com.designsystem.ds_counter;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"DSCounter", "", "value", "", "modifier", "Landroidx/compose/ui/Modifier;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "DSCounter-eaDK9VM", "(ILandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSCounterKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* renamed from: DSCounter-eaDK9VM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8333DSCountereaDK9VM(int r18, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r19, long r20, long r22, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r7 = r25
            r0 = 553777879(0x2101fad7, float:4.4038884E-19)
            r1 = r24
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r26 & 1
            if (r1 == 0) goto L_0x0015
            r1 = r7 | 6
            r2 = r1
            r1 = r18
            goto L_0x0029
        L_0x0015:
            r1 = r7 & 14
            if (r1 != 0) goto L_0x0026
            r1 = r18
            boolean r2 = r0.changed((int) r1)
            if (r2 == 0) goto L_0x0023
            r2 = 4
            goto L_0x0024
        L_0x0023:
            r2 = 2
        L_0x0024:
            r2 = r2 | r7
            goto L_0x0029
        L_0x0026:
            r1 = r18
            r2 = r7
        L_0x0029:
            r3 = r26 & 2
            if (r3 == 0) goto L_0x0030
            r2 = r2 | 48
            goto L_0x0043
        L_0x0030:
            r4 = r7 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0043
            r4 = r19
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x003f
            r5 = 32
            goto L_0x0041
        L_0x003f:
            r5 = 16
        L_0x0041:
            r2 = r2 | r5
            goto L_0x0045
        L_0x0043:
            r4 = r19
        L_0x0045:
            r5 = r7 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x005e
            r5 = r26 & 4
            if (r5 != 0) goto L_0x0058
            r5 = r20
            boolean r8 = r0.changed((long) r5)
            if (r8 == 0) goto L_0x005a
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x0058:
            r5 = r20
        L_0x005a:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r2 = r2 | r8
            goto L_0x0060
        L_0x005e:
            r5 = r20
        L_0x0060:
            r8 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0079
            r8 = r26 & 8
            if (r8 != 0) goto L_0x0073
            r8 = r22
            boolean r10 = r0.changed((long) r8)
            if (r10 == 0) goto L_0x0075
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0073:
            r8 = r22
        L_0x0075:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r2 = r2 | r10
            goto L_0x007b
        L_0x0079:
            r8 = r22
        L_0x007b:
            r10 = r2 & 5851(0x16db, float:8.199E-42)
            r10 = r10 ^ 1170(0x492, float:1.64E-42)
            if (r10 != 0) goto L_0x0090
            boolean r10 = r0.getSkipping()
            if (r10 != 0) goto L_0x0088
            goto L_0x0090
        L_0x0088:
            r0.skipToGroupEnd()
            r2 = r4
            r3 = r5
            r5 = r8
            goto L_0x00fe
        L_0x0090:
            r10 = r7 & 1
            if (r10 == 0) goto L_0x00ad
            boolean r10 = r0.getDefaultsInvalid()
            if (r10 == 0) goto L_0x009b
            goto L_0x00ad
        L_0x009b:
            r0.skipCurrentGroup()
            r3 = r26 & 4
            if (r3 == 0) goto L_0x00a4
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00a4:
            r3 = r26 & 8
            if (r3 == 0) goto L_0x00aa
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00aa:
            r15 = r2
        L_0x00ab:
            r2 = r8
            goto L_0x00e0
        L_0x00ad:
            r0.startDefaults()
            if (r3 == 0) goto L_0x00b5
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x00b6
        L_0x00b5:
            r3 = r4
        L_0x00b6:
            r4 = r26 & 4
            r10 = 0
            if (r4 == 0) goto L_0x00c8
            com.designsystem.ds_theme.DSTheme r4 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r4 = r4.getColors(r0, r10)
            long r4 = r4.m8774getDsNeutralWhite0d7_KjU()
            r2 = r2 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x00c9
        L_0x00c8:
            r4 = r5
        L_0x00c9:
            r6 = r26 & 8
            if (r6 == 0) goto L_0x00d9
            com.designsystem.ds_theme.DSTheme r6 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r6 = r6.getColors(r0, r10)
            long r8 = r6.m8793getDsPrimary1000d7_KjU()
            r2 = r2 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00d9:
            r0.endDefaults()
            r15 = r2
            r5 = r4
            r4 = r3
            goto L_0x00ab
        L_0x00e0:
            com.designsystem.ds_counter.DSCounterKt$DSCounter$1 r13 = new com.designsystem.ds_counter.DSCounterKt$DSCounter$1
            r8 = r13
            r9 = r4
            r10 = r18
            r11 = r5
            r1 = r13
            r13 = r2
            r8.<init>(r9, r10, r11, r13, r15)
            r8 = -819895495(0xffffffffcf216339, float:-2.70763443E9)
            r9 = 1
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r8, r9, r1)
            r8 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r1, r0, r8)
            r16 = r2
            r2 = r4
            r3 = r5
            r5 = r16
        L_0x00fe:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x0105
            goto L_0x0114
        L_0x0105:
            com.designsystem.ds_counter.DSCounterKt$DSCounter$2 r10 = new com.designsystem.ds_counter.DSCounterKt$DSCounter$2
            r0 = r10
            r1 = r18
            r7 = r25
            r8 = r26
            r0.<init>(r1, r2, r3, r5, r7, r8)
            r9.updateScope(r10)
        L_0x0114:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_counter.DSCounterKt.m8333DSCountereaDK9VM(int, androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }
}
