package com.designsystem.ds_button_v2;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a_\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"DSPrimaryButtonWithPrice", "", "title", "", "price", "modifier", "Landroidx/compose/ui/Modifier;", "quantity", "", "isEnabled", "", "isLoading", "forceMM2", "onTap", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/Integer;ZZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSPrimaryButtonWithPriceKt {
    /* JADX WARNING: Removed duplicated region for block: B:110:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x011c  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSPrimaryButtonWithPrice(@org.jetbrains.annotations.NotNull java.lang.String r22, @org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r24, @org.jetbrains.annotations.Nullable java.lang.Integer r25, boolean r26, boolean r27, boolean r28, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r29, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r10 = r22
            r11 = r23
            r12 = r29
            r13 = r31
            r14 = r32
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "price"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "onTap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -365942021(0xffffffffea302afb, float:-5.324348E25)
            r1 = r30
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            r0 = r14 & 1
            if (r0 == 0) goto L_0x0029
            r0 = r13 | 6
            goto L_0x0039
        L_0x0029:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0038
            boolean r0 = r15.changed((java.lang.Object) r10)
            if (r0 == 0) goto L_0x0035
            r0 = 4
            goto L_0x0036
        L_0x0035:
            r0 = 2
        L_0x0036:
            r0 = r0 | r13
            goto L_0x0039
        L_0x0038:
            r0 = r13
        L_0x0039:
            r1 = r14 & 2
            if (r1 == 0) goto L_0x0040
            r0 = r0 | 48
            goto L_0x0050
        L_0x0040:
            r1 = r13 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0050
            boolean r1 = r15.changed((java.lang.Object) r11)
            if (r1 == 0) goto L_0x004d
            r1 = 32
            goto L_0x004f
        L_0x004d:
            r1 = 16
        L_0x004f:
            r0 = r0 | r1
        L_0x0050:
            r1 = r14 & 4
            if (r1 == 0) goto L_0x0057
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006a
        L_0x0057:
            r2 = r13 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x006a
            r2 = r24
            boolean r3 = r15.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0066
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r0 = r0 | r3
            goto L_0x006c
        L_0x006a:
            r2 = r24
        L_0x006c:
            r3 = r14 & 8
            if (r3 == 0) goto L_0x0073
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0086
        L_0x0073:
            r4 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0086
            r4 = r25
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0082
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r0 = r0 | r5
            goto L_0x0088
        L_0x0086:
            r4 = r25
        L_0x0088:
            r5 = r14 & 16
            if (r5 == 0) goto L_0x008f
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a4
        L_0x008f:
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r13
            if (r6 != 0) goto L_0x00a4
            r6 = r26
            boolean r7 = r15.changed((boolean) r6)
            if (r7 == 0) goto L_0x00a0
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x00a0:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r0 = r0 | r7
            goto L_0x00a6
        L_0x00a4:
            r6 = r26
        L_0x00a6:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x00ae
            r8 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r8
            goto L_0x00c2
        L_0x00ae:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00c2
            r8 = r27
            boolean r9 = r15.changed((boolean) r8)
            if (r9 == 0) goto L_0x00be
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r0 = r0 | r9
            goto L_0x00c4
        L_0x00c2:
            r8 = r27
        L_0x00c4:
            r9 = r14 & 64
            if (r9 == 0) goto L_0x00cf
            r16 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r16
            r2 = r28
            goto L_0x00e4
        L_0x00cf:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r13 & r16
            r2 = r28
            if (r16 != 0) goto L_0x00e4
            boolean r16 = r15.changed((boolean) r2)
            if (r16 == 0) goto L_0x00e0
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e2
        L_0x00e0:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00e2:
            r0 = r0 | r16
        L_0x00e4:
            r2 = r14 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00ec
            r2 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00ea:
            r0 = r0 | r2
            goto L_0x00fd
        L_0x00ec:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r13
            if (r2 != 0) goto L_0x00fd
            boolean r2 = r15.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x00fa
            r2 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00ea
        L_0x00fa:
            r2 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00ea
        L_0x00fd:
            r16 = r0
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r16 & r0
            r2 = 4793490(0x492492, float:6.71711E-39)
            r0 = r0 ^ r2
            if (r0 != 0) goto L_0x011c
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x0111
            goto L_0x011c
        L_0x0111:
            r15.skipToGroupEnd()
            r3 = r24
            r7 = r28
            r5 = r6
            r6 = r8
            goto L_0x0174
        L_0x011c:
            if (r1 == 0) goto L_0x0123
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r17 = r0
            goto L_0x0125
        L_0x0123:
            r17 = r24
        L_0x0125:
            if (r3 == 0) goto L_0x012b
            r0 = 0
            r18 = r0
            goto L_0x012d
        L_0x012b:
            r18 = r4
        L_0x012d:
            r4 = 1
            if (r5 == 0) goto L_0x0133
            r19 = r4
            goto L_0x0135
        L_0x0133:
            r19 = r6
        L_0x0135:
            r0 = 0
            if (r7 == 0) goto L_0x013b
            r20 = r0
            goto L_0x013d
        L_0x013b:
            r20 = r8
        L_0x013d:
            if (r9 == 0) goto L_0x0142
            r21 = r0
            goto L_0x0144
        L_0x0142:
            r21 = r28
        L_0x0144:
            com.designsystem.ds_button_v2.DSPrimaryButtonWithPriceKt$DSPrimaryButtonWithPrice$1 r9 = new com.designsystem.ds_button_v2.DSPrimaryButtonWithPriceKt$DSPrimaryButtonWithPrice$1
            r0 = r9
            r1 = r21
            r2 = r19
            r3 = r20
            r8 = r4
            r4 = r16
            r5 = r18
            r6 = r22
            r7 = r23
            r10 = r8
            r8 = r17
            r11 = r9
            r9 = r29
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = -819892270(0xffffffffcf216fd2, float:-2.70846003E9)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r10, r11)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r15, r1)
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
        L_0x0174:
            androidx.compose.runtime.ScopeUpdateScope r11 = r15.endRestartGroup()
            if (r11 != 0) goto L_0x017b
            goto L_0x018e
        L_0x017b:
            com.designsystem.ds_button_v2.DSPrimaryButtonWithPriceKt$DSPrimaryButtonWithPrice$2 r15 = new com.designsystem.ds_button_v2.DSPrimaryButtonWithPriceKt$DSPrimaryButtonWithPrice$2
            r0 = r15
            r1 = r22
            r2 = r23
            r8 = r29
            r9 = r31
            r10 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r11.updateScope(r15)
        L_0x018e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_button_v2.DSPrimaryButtonWithPriceKt.DSPrimaryButtonWithPrice(java.lang.String, java.lang.String, androidx.compose.ui.Modifier, java.lang.Integer, boolean, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }
}
