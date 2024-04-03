package com.designsystem.ds_empty_state_v2;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ae\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"EmptyStateIconSize", "Landroidx/compose/ui/unit/Dp;", "F", "DSEmptyStateWithIcon", "", "title", "", "icon", "", "modifier", "Landroidx/compose/ui/Modifier;", "details", "iconColor", "Landroidx/compose/ui/graphics/Color;", "buttonText", "onButtonTap", "Lkotlin/Function0;", "DSEmptyStateWithIcon-3f6hBDE", "(Ljava/lang/String;ILandroidx/compose/ui/Modifier;Ljava/lang/String;JLjava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSEmptyStateWithIconKt {
    private static final float EmptyStateIconSize = Dp.m5478constructorimpl((float) 56);

    /* JADX WARNING: Removed duplicated region for block: B:106:0x018e  */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f4  */
    @androidx.compose.runtime.Composable
    /* renamed from: DSEmptyStateWithIcon-3f6hBDE  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8334DSEmptyStateWithIcon3f6hBDE(@org.jetbrains.annotations.NotNull java.lang.String r22, @androidx.annotation.DrawableRes int r23, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r24, @org.jetbrains.annotations.Nullable java.lang.String r25, long r26, @org.jetbrains.annotations.Nullable java.lang.String r28, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r29, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r10 = r22
            r11 = r31
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 196842854(0xbbb9566, float:7.225457E-32)
            r1 = r30
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r32 & 1
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
            r1 = r32 & 2
            if (r1 == 0) goto L_0x0032
            r0 = r0 | 48
            r13 = r23
            goto L_0x0044
        L_0x0032:
            r1 = r11 & 112(0x70, float:1.57E-43)
            r13 = r23
            if (r1 != 0) goto L_0x0044
            boolean r1 = r12.changed((int) r13)
            if (r1 == 0) goto L_0x0041
            r1 = 32
            goto L_0x0043
        L_0x0041:
            r1 = 16
        L_0x0043:
            r0 = r0 | r1
        L_0x0044:
            r1 = r32 & 4
            if (r1 == 0) goto L_0x004b
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004b:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x005e
            r2 = r24
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
            r2 = r24
        L_0x0060:
            r3 = r32 & 8
            if (r3 == 0) goto L_0x0067
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r4 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x007a
            r4 = r25
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
            r4 = r25
        L_0x007c:
            r14 = 57344(0xe000, float:8.0356E-41)
            r5 = r11 & r14
            if (r5 != 0) goto L_0x0098
            r5 = r32 & 16
            if (r5 != 0) goto L_0x0092
            r5 = r26
            boolean r7 = r12.changed((long) r5)
            if (r7 == 0) goto L_0x0094
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0092:
            r5 = r26
        L_0x0094:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r0 = r0 | r7
            goto L_0x009a
        L_0x0098:
            r5 = r26
        L_0x009a:
            r7 = r32 & 32
            r15 = 458752(0x70000, float:6.42848E-40)
            if (r7 == 0) goto L_0x00a4
            r8 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r8
            goto L_0x00b7
        L_0x00a4:
            r8 = r11 & r15
            if (r8 != 0) goto L_0x00b7
            r8 = r28
            boolean r9 = r12.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00b3
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r0 = r0 | r9
            goto L_0x00b9
        L_0x00b7:
            r8 = r28
        L_0x00b9:
            r9 = r32 & 64
            if (r9 == 0) goto L_0x00c4
            r16 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r16
            r15 = r29
            goto L_0x00d9
        L_0x00c4:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r11 & r16
            r15 = r29
            if (r16 != 0) goto L_0x00d9
            boolean r16 = r12.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00d5
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d7
        L_0x00d5:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00d7:
            r0 = r0 | r16
        L_0x00d9:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r16 = r0 & r16
            r17 = 599186(0x92492, float:8.39638E-40)
            r16 = r16 ^ r17
            if (r16 != 0) goto L_0x00f4
            boolean r16 = r12.getSkipping()
            if (r16 != 0) goto L_0x00ec
            goto L_0x00f4
        L_0x00ec:
            r12.skipToGroupEnd()
            r3 = r2
            r7 = r8
            r8 = r15
            goto L_0x0187
        L_0x00f4:
            r16 = r11 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r16 == 0) goto L_0x0115
            boolean r16 = r12.getDefaultsInvalid()
            if (r16 == 0) goto L_0x0102
            goto L_0x0115
        L_0x0102:
            r12.skipCurrentGroup()
            r1 = r32 & 16
            if (r1 == 0) goto L_0x010b
            r0 = r0 & r17
        L_0x010b:
            r16 = r4
            r17 = r5
            r19 = r8
            r20 = r15
            r15 = r2
            goto L_0x0140
        L_0x0115:
            r12.startDefaults()
            if (r1 == 0) goto L_0x011d
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x011e
        L_0x011d:
            r1 = r2
        L_0x011e:
            r2 = 0
            if (r3 == 0) goto L_0x0122
            r4 = r2
        L_0x0122:
            r3 = r32 & 16
            if (r3 == 0) goto L_0x012e
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            long r5 = r3.m2955getUnspecified0d7_KjU()
            r0 = r0 & r17
        L_0x012e:
            if (r7 == 0) goto L_0x0131
            r8 = r2
        L_0x0131:
            if (r9 == 0) goto L_0x0134
            r15 = r2
        L_0x0134:
            r12.endDefaults()
            r16 = r4
            r17 = r5
            r19 = r8
            r20 = r15
            r15 = r1
        L_0x0140:
            com.designsystem.ds_empty_state_v2.EmptyStateIcon r21 = new com.designsystem.ds_empty_state_v2.EmptyStateIcon
            com.designsystem.ds_theme.DSTheme r1 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r2 = 0
            com.designsystem.ds_theme.DSDimens r1 = r1.getDimens(r12, r2)
            float r4 = r1.m8846getDsXxsD9Ej5fM()
            float r6 = EmptyStateIconSize
            r9 = 0
            r2 = r21
            r3 = r23
            r5 = r6
            r7 = r17
            r2.<init>(r3, r4, r5, r6, r7, r9)
            r6 = 0
            r1 = r0 & 14
            int r0 = r0 >> 3
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            r2 = r0 & r14
            r1 = r1 | r2
            r2 = 458752(0x70000, float:6.42848E-40)
            r0 = r0 & r2
            r8 = r1 | r0
            r9 = 64
            r0 = r22
            r1 = r15
            r2 = r16
            r3 = r21
            r4 = r19
            r5 = r20
            r7 = r12
            com.designsystem.ds_empty_state_v2.EmptyStateComposablesKt.EmptyState(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r3 = r15
            r4 = r16
            r5 = r17
            r7 = r19
            r8 = r20
        L_0x0187:
            androidx.compose.runtime.ScopeUpdateScope r12 = r12.endRestartGroup()
            if (r12 != 0) goto L_0x018e
            goto L_0x019f
        L_0x018e:
            com.designsystem.ds_empty_state_v2.DSEmptyStateWithIconKt$DSEmptyStateWithIcon$1 r14 = new com.designsystem.ds_empty_state_v2.DSEmptyStateWithIconKt$DSEmptyStateWithIcon$1
            r0 = r14
            r1 = r22
            r2 = r23
            r9 = r31
            r10 = r32
            r0.<init>(r1, r2, r3, r4, r5, r7, r8, r9, r10)
            r12.updateScope(r14)
        L_0x019f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_empty_state_v2.DSEmptyStateWithIconKt.m8334DSEmptyStateWithIcon3f6hBDE(java.lang.String, int, androidx.compose.ui.Modifier, java.lang.String, long, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
