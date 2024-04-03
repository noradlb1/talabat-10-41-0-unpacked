package com.designsystem.ds_list_item_v2;

import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aµ\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"DSRadioListItem", "", "label", "", "isSelected", "", "onChanged", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "descriptor", "secondaryLabel", "descriptorColor", "", "leadingIcon", "leadingImage", "imageCornerRadius", "Landroidx/compose/ui/unit/Dp;", "isEnabled", "price", "oldPrice", "showSelectionIndicator", "DSRadioListItem-pU6N4AM", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;FZLjava/lang/String;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;III)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSRadioListItemKt {
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0184  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x02c9  */
    /* JADX WARNING: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0108  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x012a  */
    @androidx.compose.runtime.Composable
    /* renamed from: DSRadioListItem-pU6N4AM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8482DSRadioListItempU6N4AM(@org.jetbrains.annotations.NotNull java.lang.String r32, boolean r33, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r34, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r35, @org.jetbrains.annotations.Nullable java.lang.String r36, @org.jetbrains.annotations.Nullable java.lang.String r37, @org.jetbrains.annotations.Nullable @androidx.annotation.ColorRes java.lang.Integer r38, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r39, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r40, float r41, boolean r42, @org.jetbrains.annotations.Nullable java.lang.String r43, @org.jetbrains.annotations.Nullable java.lang.String r44, boolean r45, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r46, int r47, int r48, int r49) {
        /*
            r15 = r32
            r14 = r34
            r13 = r47
            r12 = r48
            r11 = r49
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "onChanged"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1130964168(0x436924c8, float:233.14368)
            r1 = r46
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            r0 = r11 & 1
            if (r0 == 0) goto L_0x0024
            r0 = r13 | 6
            goto L_0x0034
        L_0x0024:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0033
            boolean r0 = r10.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0030
            r0 = 4
            goto L_0x0031
        L_0x0030:
            r0 = 2
        L_0x0031:
            r0 = r0 | r13
            goto L_0x0034
        L_0x0033:
            r0 = r13
        L_0x0034:
            r3 = r11 & 2
            if (r3 == 0) goto L_0x003d
            r0 = r0 | 48
            r9 = r33
            goto L_0x004f
        L_0x003d:
            r3 = r13 & 112(0x70, float:1.57E-43)
            r9 = r33
            if (r3 != 0) goto L_0x004f
            boolean r3 = r10.changed((boolean) r9)
            if (r3 == 0) goto L_0x004c
            r3 = 32
            goto L_0x004e
        L_0x004c:
            r3 = 16
        L_0x004e:
            r0 = r0 | r3
        L_0x004f:
            r3 = r11 & 4
            if (r3 == 0) goto L_0x0056
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0066
        L_0x0056:
            r3 = r13 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0066
            boolean r3 = r10.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0063
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r0 = r0 | r3
        L_0x0066:
            r3 = r11 & 8
            r16 = 1024(0x400, float:1.435E-42)
            if (r3 == 0) goto L_0x006f
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x006f:
            r1 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r1 != 0) goto L_0x0083
            r1 = r35
            boolean r17 = r10.changed((java.lang.Object) r1)
            if (r17 == 0) goto L_0x007e
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r17 = r16
        L_0x0080:
            r0 = r0 | r17
            goto L_0x0085
        L_0x0083:
            r1 = r35
        L_0x0085:
            r17 = r11 & 16
            if (r17 == 0) goto L_0x008e
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r2 = r36
            goto L_0x00a4
        L_0x008e:
            r18 = 57344(0xe000, float:8.0356E-41)
            r18 = r13 & r18
            r2 = r36
            if (r18 != 0) goto L_0x00a4
            boolean r19 = r10.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x00a0
            r19 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x00a0:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r0 = r0 | r19
        L_0x00a4:
            r19 = r11 & 32
            if (r19 == 0) goto L_0x00af
            r20 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r20
            r4 = r37
            goto L_0x00c4
        L_0x00af:
            r20 = 458752(0x70000, float:6.42848E-40)
            r20 = r13 & r20
            r4 = r37
            if (r20 != 0) goto L_0x00c4
            boolean r21 = r10.changed((java.lang.Object) r4)
            if (r21 == 0) goto L_0x00c0
            r21 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00c0:
            r21 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r0 = r0 | r21
        L_0x00c4:
            r21 = r11 & 64
            if (r21 == 0) goto L_0x00cf
            r22 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r22
            r5 = r38
            goto L_0x00e4
        L_0x00cf:
            r22 = 3670016(0x380000, float:5.142788E-39)
            r22 = r13 & r22
            r5 = r38
            if (r22 != 0) goto L_0x00e4
            boolean r23 = r10.changed((java.lang.Object) r5)
            if (r23 == 0) goto L_0x00e0
            r23 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e2
        L_0x00e0:
            r23 = 524288(0x80000, float:7.34684E-40)
        L_0x00e2:
            r0 = r0 | r23
        L_0x00e4:
            r6 = r11 & 128(0x80, float:1.794E-43)
            if (r6 == 0) goto L_0x00ef
            r24 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r24
            r7 = r39
            goto L_0x0104
        L_0x00ef:
            r24 = 29360128(0x1c00000, float:7.052966E-38)
            r24 = r13 & r24
            r7 = r39
            if (r24 != 0) goto L_0x0104
            boolean r25 = r10.changed((java.lang.Object) r7)
            if (r25 == 0) goto L_0x0100
            r25 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0102
        L_0x0100:
            r25 = 4194304(0x400000, float:5.877472E-39)
        L_0x0102:
            r0 = r0 | r25
        L_0x0104:
            r8 = r11 & 256(0x100, float:3.59E-43)
            if (r8 == 0) goto L_0x010f
            r26 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r26
            r1 = r40
            goto L_0x0124
        L_0x010f:
            r26 = 234881024(0xe000000, float:1.5777218E-30)
            r26 = r13 & r26
            r1 = r40
            if (r26 != 0) goto L_0x0124
            boolean r26 = r10.changed((java.lang.Object) r1)
            if (r26 == 0) goto L_0x0120
            r26 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0122
        L_0x0120:
            r26 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0122:
            r0 = r0 | r26
        L_0x0124:
            r26 = 1879048192(0x70000000, float:1.58456325E29)
            r26 = r13 & r26
            if (r26 != 0) goto L_0x0140
            r1 = r11 & 512(0x200, float:7.175E-43)
            if (r1 != 0) goto L_0x0139
            r1 = r41
            boolean r26 = r10.changed((float) r1)
            if (r26 == 0) goto L_0x013b
            r26 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013d
        L_0x0139:
            r1 = r41
        L_0x013b:
            r26 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013d:
            r0 = r0 | r26
            goto L_0x0142
        L_0x0140:
            r1 = r41
        L_0x0142:
            r1 = r11 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x014b
            r18 = r12 | 6
            r2 = r42
            goto L_0x0161
        L_0x014b:
            r26 = r12 & 14
            r2 = r42
            if (r26 != 0) goto L_0x015f
            boolean r26 = r10.changed((boolean) r2)
            if (r26 == 0) goto L_0x015a
            r18 = 4
            goto L_0x015c
        L_0x015a:
            r18 = 2
        L_0x015c:
            r18 = r12 | r18
            goto L_0x0161
        L_0x015f:
            r18 = r12
        L_0x0161:
            r2 = r11 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0168
            r18 = r18 | 48
            goto L_0x017b
        L_0x0168:
            r26 = r12 & 112(0x70, float:1.57E-43)
            r4 = r43
            if (r26 != 0) goto L_0x017b
            boolean r26 = r10.changed((java.lang.Object) r4)
            if (r26 == 0) goto L_0x0177
            r20 = 32
            goto L_0x0179
        L_0x0177:
            r20 = 16
        L_0x0179:
            r18 = r18 | r20
        L_0x017b:
            r4 = r18
            r5 = r11 & 4096(0x1000, float:5.74E-42)
            if (r5 == 0) goto L_0x0184
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0198
        L_0x0184:
            r7 = r12 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0198
            r7 = r44
            boolean r18 = r10.changed((java.lang.Object) r7)
            if (r18 == 0) goto L_0x0193
            r23 = 256(0x100, float:3.59E-43)
            goto L_0x0195
        L_0x0193:
            r23 = 128(0x80, float:1.794E-43)
        L_0x0195:
            r4 = r4 | r23
            goto L_0x019a
        L_0x0198:
            r7 = r44
        L_0x019a:
            r7 = r11 & 8192(0x2000, float:1.14794E-41)
            if (r7 == 0) goto L_0x01a1
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x01b2
        L_0x01a1:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x01b2
            r9 = r45
            boolean r18 = r10.changed((boolean) r9)
            if (r18 == 0) goto L_0x01af
            r16 = 2048(0x800, float:2.87E-42)
        L_0x01af:
            r4 = r4 | r16
            goto L_0x01b4
        L_0x01b2:
            r9 = r45
        L_0x01b4:
            r16 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r16 = r0 & r16
            r18 = 306783378(0x12492492, float:6.3469493E-28)
            r16 = r16 ^ r18
            if (r16 != 0) goto L_0x01e9
            r9 = r4 & 5851(0x16db, float:8.199E-42)
            r9 = r9 ^ 1170(0x492, float:1.64E-42)
            if (r9 != 0) goto L_0x01e9
            boolean r9 = r10.getSkipping()
            if (r9 != 0) goto L_0x01cd
            goto L_0x01e9
        L_0x01cd:
            r10.skipToGroupEnd()
            r4 = r35
            r5 = r36
            r6 = r37
            r7 = r38
            r8 = r39
            r9 = r40
            r11 = r42
            r12 = r43
            r13 = r44
            r14 = r45
            r1 = r10
            r10 = r41
            goto L_0x02c2
        L_0x01e9:
            r9 = r13 & 1
            r16 = -1879048193(0xffffffff8fffffff, float:-2.5243547E-29)
            if (r9 == 0) goto L_0x0219
            boolean r9 = r10.getDefaultsInvalid()
            if (r9 == 0) goto L_0x01f7
            goto L_0x0219
        L_0x01f7:
            r10.skipCurrentGroup()
            r1 = r11 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0200
            r0 = r0 & r16
        L_0x0200:
            r17 = r35
            r18 = r36
            r19 = r37
            r20 = r38
            r21 = r39
            r22 = r40
            r23 = r41
            r24 = r42
            r25 = r43
            r26 = r44
            r27 = r45
            r15 = r0
            goto L_0x028a
        L_0x0219:
            r10.startDefaults()
            if (r3 == 0) goto L_0x0221
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x0223
        L_0x0221:
            r3 = r35
        L_0x0223:
            if (r17 == 0) goto L_0x0228
            r17 = 0
            goto L_0x022a
        L_0x0228:
            r17 = r36
        L_0x022a:
            if (r19 == 0) goto L_0x022f
            r18 = 0
            goto L_0x0231
        L_0x022f:
            r18 = r37
        L_0x0231:
            if (r21 == 0) goto L_0x0236
            r19 = 0
            goto L_0x0238
        L_0x0236:
            r19 = r38
        L_0x0238:
            if (r6 == 0) goto L_0x023c
            r6 = 0
            goto L_0x023e
        L_0x023c:
            r6 = r39
        L_0x023e:
            if (r8 == 0) goto L_0x0242
            r8 = 0
            goto L_0x0244
        L_0x0242:
            r8 = r40
        L_0x0244:
            r9 = r11 & 512(0x200, float:7.175E-43)
            if (r9 == 0) goto L_0x0256
            com.designsystem.ds_theme.DSTheme r9 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r15 = 0
            com.designsystem.ds_theme.DSDimens r9 = r9.getDimens(r10, r15)
            float r9 = r9.m8841getDsMD9Ej5fM()
            r0 = r0 & r16
            goto L_0x0258
        L_0x0256:
            r9 = r41
        L_0x0258:
            if (r1 == 0) goto L_0x025c
            r1 = 1
            goto L_0x025e
        L_0x025c:
            r1 = r42
        L_0x025e:
            if (r2 == 0) goto L_0x0262
            r2 = 0
            goto L_0x0264
        L_0x0262:
            r2 = r43
        L_0x0264:
            if (r5 == 0) goto L_0x0268
            r5 = 0
            goto L_0x026a
        L_0x0268:
            r5 = r44
        L_0x026a:
            if (r7 == 0) goto L_0x026e
            r7 = 1
            goto L_0x0270
        L_0x026e:
            r7 = r45
        L_0x0270:
            r10.endDefaults()
            r15 = r0
            r24 = r1
            r25 = r2
            r26 = r5
            r21 = r6
            r27 = r7
            r22 = r8
            r23 = r9
            r20 = r19
            r19 = r18
            r18 = r17
            r17 = r3
        L_0x028a:
            com.designsystem.ds_list_item_v2.DSRadioListItemKt$DSRadioListItem$1 r9 = new com.designsystem.ds_list_item_v2.DSRadioListItemKt$DSRadioListItem$1
            r0 = r9
            r1 = r32
            r2 = r33
            r3 = r34
            r16 = r4
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r28 = r9
            r9 = r22
            r29 = r10
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r14 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = -819892796(0xffffffffcf216dc4, float:-2.70832538E9)
            r2 = r28
            r1 = r29
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r3, r2)
            r2 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r1, r2)
        L_0x02c2:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 != 0) goto L_0x02c9
            goto L_0x02e6
        L_0x02c9:
            com.designsystem.ds_list_item_v2.DSRadioListItemKt$DSRadioListItem$2 r3 = new com.designsystem.ds_list_item_v2.DSRadioListItemKt$DSRadioListItem$2
            r0 = r3
            r1 = r32
            r2 = r33
            r30 = r3
            r3 = r34
            r31 = r15
            r15 = r47
            r16 = r48
            r17 = r49
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r1 = r30
            r0 = r31
            r0.updateScope(r1)
        L_0x02e6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_list_item_v2.DSRadioListItemKt.m8482DSRadioListItempU6N4AM(java.lang.String, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, float, boolean, java.lang.String, java.lang.String, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
