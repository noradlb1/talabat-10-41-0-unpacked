package com.designsystem.ds_empty_state_v2;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aS\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000eH\u0007¢\u0006\u0002\u0010\u000f\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"EmptyStateSmallIllustrationHeight", "Landroidx/compose/ui/unit/Dp;", "F", "DSEmptyStateWithSmallIllustration", "", "title", "", "illustration", "", "modifier", "Landroidx/compose/ui/Modifier;", "details", "buttonText", "onButtonTap", "Lkotlin/Function0;", "(Ljava/lang/String;ILandroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSEmptyStateWithSmallIllustrationKt {
    private static final float EmptyStateSmallIllustrationHeight = Dp.m5478constructorimpl((float) 90);

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:88:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSEmptyStateWithSmallIllustration(@org.jetbrains.annotations.NotNull java.lang.String r27, @androidx.annotation.DrawableRes int r28, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r29, @org.jetbrains.annotations.Nullable java.lang.String r30, @org.jetbrains.annotations.Nullable java.lang.String r31, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r32, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r10 = r27
            r11 = r34
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1621934810(0x60acc2da, float:9.959002E19)
            r1 = r33
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r35 & 1
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
            r1 = r35 & 2
            if (r1 == 0) goto L_0x0032
            r0 = r0 | 48
            r9 = r28
            goto L_0x0044
        L_0x0032:
            r1 = r11 & 112(0x70, float:1.57E-43)
            r9 = r28
            if (r1 != 0) goto L_0x0044
            boolean r1 = r12.changed((int) r9)
            if (r1 == 0) goto L_0x0041
            r1 = 32
            goto L_0x0043
        L_0x0041:
            r1 = 16
        L_0x0043:
            r0 = r0 | r1
        L_0x0044:
            r1 = r35 & 4
            if (r1 == 0) goto L_0x004b
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004b:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x005e
            r2 = r29
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x005a
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r3 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r0 = r0 | r3
            goto L_0x0060
        L_0x005e:
            r2 = r29
        L_0x0060:
            r3 = r35 & 8
            if (r3 == 0) goto L_0x0067
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r4 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x007a
            r4 = r30
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0076
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r0 = r0 | r5
            goto L_0x007c
        L_0x007a:
            r4 = r30
        L_0x007c:
            r5 = r35 & 16
            r6 = 57344(0xe000, float:8.0356E-41)
            if (r5 == 0) goto L_0x0086
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r7 = r11 & r6
            if (r7 != 0) goto L_0x0099
            r7 = r31
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0095
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r0 = r0 | r8
            goto L_0x009b
        L_0x0099:
            r7 = r31
        L_0x009b:
            r8 = r35 & 32
            r22 = 458752(0x70000, float:6.42848E-40)
            if (r8 == 0) goto L_0x00a5
            r13 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r13
            goto L_0x00b8
        L_0x00a5:
            r13 = r11 & r22
            if (r13 != 0) goto L_0x00b8
            r13 = r32
            boolean r14 = r12.changed((java.lang.Object) r13)
            if (r14 == 0) goto L_0x00b4
            r14 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b4:
            r14 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r0 = r0 | r14
            goto L_0x00ba
        L_0x00b8:
            r13 = r32
        L_0x00ba:
            r14 = 374491(0x5b6db, float:5.24774E-40)
            r14 = r14 & r0
            r15 = 74898(0x12492, float:1.04954E-40)
            r14 = r14 ^ r15
            if (r14 != 0) goto L_0x00d3
            boolean r14 = r12.getSkipping()
            if (r14 != 0) goto L_0x00cb
            goto L_0x00d3
        L_0x00cb:
            r12.skipToGroupEnd()
            r3 = r2
            r5 = r7
            r6 = r13
            goto L_0x013b
        L_0x00d3:
            if (r1 == 0) goto L_0x00da
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r23 = r1
            goto L_0x00dc
        L_0x00da:
            r23 = r2
        L_0x00dc:
            r1 = 0
            if (r3 == 0) goto L_0x00e2
            r24 = r1
            goto L_0x00e4
        L_0x00e2:
            r24 = r4
        L_0x00e4:
            if (r5 == 0) goto L_0x00e9
            r25 = r1
            goto L_0x00eb
        L_0x00e9:
            r25 = r7
        L_0x00eb:
            if (r8 == 0) goto L_0x00f0
            r26 = r1
            goto L_0x00f2
        L_0x00f0:
            r26 = r13
        L_0x00f2:
            com.designsystem.ds_empty_state_v2.EmptyStateIcon r3 = new com.designsystem.ds_empty_state_v2.EmptyStateIcon
            com.designsystem.ds_theme.DSTheme r1 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r2 = 0
            com.designsystem.ds_theme.DSDimens r1 = r1.getDimens(r12, r2)
            float r15 = r1.m8842getDsSD9Ej5fM()
            float r16 = EmptyStateSmallIllustrationHeight
            r17 = 0
            r18 = 0
            r20 = 24
            r21 = 0
            r13 = r3
            r14 = r28
            r13.<init>(r14, r15, r16, r17, r18, r20, r21)
            r7 = 0
            r1 = r0 & 14
            int r2 = r0 >> 3
            r4 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r4
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & r6
            r1 = r1 | r2
            r0 = r0 & r22
            r8 = r1 | r0
            r13 = 64
            r0 = r27
            r1 = r23
            r2 = r24
            r4 = r25
            r5 = r26
            r6 = r7
            r7 = r12
            r9 = r13
            com.designsystem.ds_empty_state_v2.EmptyStateComposablesKt.EmptyState(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r3 = r23
            r4 = r24
            r5 = r25
            r6 = r26
        L_0x013b:
            androidx.compose.runtime.ScopeUpdateScope r9 = r12.endRestartGroup()
            if (r9 != 0) goto L_0x0142
            goto L_0x0153
        L_0x0142:
            com.designsystem.ds_empty_state_v2.DSEmptyStateWithSmallIllustrationKt$DSEmptyStateWithSmallIllustration$1 r12 = new com.designsystem.ds_empty_state_v2.DSEmptyStateWithSmallIllustrationKt$DSEmptyStateWithSmallIllustration$1
            r0 = r12
            r1 = r27
            r2 = r28
            r7 = r34
            r8 = r35
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.updateScope(r12)
        L_0x0153:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_empty_state_v2.DSEmptyStateWithSmallIllustrationKt.DSEmptyStateWithSmallIllustration(java.lang.String, int, androidx.compose.ui.Modifier, java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
