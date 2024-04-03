package com.designsystem.ds_simple_card;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\n\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00162\u0015\b\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010\u0016¢\u0006\u0002\b\u0018H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0005\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\"\u0013\u0010\u0006\u001a\u00020\u0003X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0004\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"CardShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "DefaultRadius", "Landroidx/compose/ui/unit/Dp;", "F", "IconSize", "ImageSize", "DSSimpleCard", "", "label", "", "modifier", "Landroidx/compose/ui/Modifier;", "labelColor", "Landroidx/compose/ui/graphics/Color;", "descriptor", "descriptorColor", "icon", "", "image", "Lcom/designsystem/ds_simple_card/DSSimpleCardImageModel;", "onTap", "Lkotlin/Function0;", "trailingView", "Landroidx/compose/runtime/Composable;", "DSSimpleCard-baIBcDA", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JLjava/lang/String;JLjava/lang/Integer;Lcom/designsystem/ds_simple_card/DSSimpleCardImageModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSSimpleCardKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final RoundedCornerShape CardShape;
    /* access modifiers changed from: private */
    public static final float DefaultRadius;
    /* access modifiers changed from: private */
    public static final float IconSize = Dp.m5478constructorimpl((float) 16);
    /* access modifiers changed from: private */
    public static final float ImageSize = Dp.m5478constructorimpl((float) 48);

    static {
        float r02 = Dp.m5478constructorimpl((float) 8);
        DefaultRadius = r02;
        CardShape = RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(r02);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0258  */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0105  */
    @androidx.compose.runtime.Composable
    /* renamed from: DSSimpleCard-baIBcDA  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8571DSSimpleCardbaIBcDA(@org.jetbrains.annotations.NotNull java.lang.String r30, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r31, long r32, @org.jetbrains.annotations.Nullable java.lang.String r34, long r35, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r37, @org.jetbrains.annotations.Nullable com.designsystem.ds_simple_card.DSSimpleCardImageModel r38, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r39, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r14 = r30
            r15 = r42
            r13 = r43
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1077567721(0x403a60e9, float:2.912165)
            r1 = r41
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r13 & 1
            if (r0 == 0) goto L_0x001b
            r0 = r15 | 6
            goto L_0x002b
        L_0x001b:
            r0 = r15 & 14
            if (r0 != 0) goto L_0x002a
            boolean r0 = r12.changed((java.lang.Object) r14)
            if (r0 == 0) goto L_0x0027
            r0 = 4
            goto L_0x0028
        L_0x0027:
            r0 = 2
        L_0x0028:
            r0 = r0 | r15
            goto L_0x002b
        L_0x002a:
            r0 = r15
        L_0x002b:
            r2 = r13 & 2
            if (r2 == 0) goto L_0x0032
            r0 = r0 | 48
            goto L_0x0045
        L_0x0032:
            r3 = r15 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0045
            r3 = r31
            boolean r4 = r12.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0041
            r4 = 32
            goto L_0x0043
        L_0x0041:
            r4 = 16
        L_0x0043:
            r0 = r0 | r4
            goto L_0x0047
        L_0x0045:
            r3 = r31
        L_0x0047:
            r4 = r15 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0060
            r4 = r13 & 4
            if (r4 != 0) goto L_0x005a
            r4 = r32
            boolean r6 = r12.changed((long) r4)
            if (r6 == 0) goto L_0x005c
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x005e
        L_0x005a:
            r4 = r32
        L_0x005c:
            r6 = 128(0x80, float:1.794E-43)
        L_0x005e:
            r0 = r0 | r6
            goto L_0x0062
        L_0x0060:
            r4 = r32
        L_0x0062:
            r6 = r13 & 8
            if (r6 == 0) goto L_0x0069
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r7 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x007c
            r7 = r34
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0078
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r0 = r0 | r8
            goto L_0x007e
        L_0x007c:
            r7 = r34
        L_0x007e:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r15
            if (r8 != 0) goto L_0x0099
            r8 = r13 & 16
            if (r8 != 0) goto L_0x0093
            r8 = r35
            boolean r10 = r12.changed((long) r8)
            if (r10 == 0) goto L_0x0095
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0093:
            r8 = r35
        L_0x0095:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r0 = r0 | r10
            goto L_0x009b
        L_0x0099:
            r8 = r35
        L_0x009b:
            r10 = r13 & 32
            if (r10 == 0) goto L_0x00a3
            r11 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r11
            goto L_0x00b8
        L_0x00a3:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r15
            if (r11 != 0) goto L_0x00b8
            r11 = r37
            boolean r16 = r12.changed((java.lang.Object) r11)
            if (r16 == 0) goto L_0x00b3
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r0 = r0 | r16
            goto L_0x00ba
        L_0x00b8:
            r11 = r37
        L_0x00ba:
            r16 = r13 & 64
            if (r16 == 0) goto L_0x00c5
            r17 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r17
            r1 = r38
            goto L_0x00da
        L_0x00c5:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r15 & r17
            r1 = r38
            if (r17 != 0) goto L_0x00da
            boolean r17 = r12.changed((java.lang.Object) r1)
            if (r17 == 0) goto L_0x00d6
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d8
        L_0x00d6:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d8:
            r0 = r0 | r17
        L_0x00da:
            r1 = r13 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x00e5
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r17
            r3 = r39
            goto L_0x00fa
        L_0x00e5:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r15 & r17
            r3 = r39
            if (r17 != 0) goto L_0x00fa
            boolean r17 = r12.changed((java.lang.Object) r3)
            if (r17 == 0) goto L_0x00f6
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f8
        L_0x00f6:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f8:
            r0 = r0 | r17
        L_0x00fa:
            r3 = r13 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x0105
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r17
            r4 = r40
            goto L_0x0119
        L_0x0105:
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r15 & r17
            r4 = r40
            if (r17 != 0) goto L_0x0119
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0116
            r5 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0118
        L_0x0116:
            r5 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0118:
            r0 = r0 | r5
        L_0x0119:
            r5 = 191739611(0xb6db6db, float:4.5782105E-32)
            r5 = r5 & r0
            r17 = 38347922(0x2492492, float:1.4777643E-37)
            r5 = r5 ^ r17
            if (r5 != 0) goto L_0x013d
            boolean r5 = r12.getSkipping()
            if (r5 != 0) goto L_0x012b
            goto L_0x013d
        L_0x012b:
            r12.skipToGroupEnd()
            r16 = r31
            r10 = r39
            r5 = r7
            r6 = r8
            r8 = r11
            r2 = r12
            r9 = r38
            r11 = r4
            r3 = r32
            goto L_0x0251
        L_0x013d:
            r5 = r15 & 1
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r5 == 0) goto L_0x016e
            boolean r5 = r12.getDefaultsInvalid()
            if (r5 == 0) goto L_0x014b
            goto L_0x016e
        L_0x014b:
            r12.skipCurrentGroup()
            r1 = r13 & 4
            if (r1 == 0) goto L_0x0154
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0154:
            r1 = r13 & 16
            if (r1 == 0) goto L_0x015a
            r0 = r0 & r17
        L_0x015a:
            r16 = r31
            r19 = r32
            r24 = r38
            r25 = r39
            r26 = r40
            r27 = r0
            r17 = r7
            r21 = r8
        L_0x016a:
            r23 = r11
            goto L_0x01c8
        L_0x016e:
            r12.startDefaults()
            if (r2 == 0) goto L_0x0176
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x0178
        L_0x0176:
            r2 = r31
        L_0x0178:
            r5 = r13 & 4
            r4 = 0
            if (r5 == 0) goto L_0x018a
            com.designsystem.ds_theme.DSTheme r5 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r5 = r5.getColors(r12, r4)
            long r19 = r5.m8760getDsNeutral1000d7_KjU()
            r0 = r0 & -897(0xfffffffffffffc7f, float:NaN)
            goto L_0x018c
        L_0x018a:
            r19 = r32
        L_0x018c:
            if (r6 == 0) goto L_0x018f
            r7 = 0
        L_0x018f:
            r5 = r13 & 16
            if (r5 == 0) goto L_0x01a0
            com.designsystem.ds_theme.DSTheme r5 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r4 = r5.getColors(r12, r4)
            long r4 = r4.m8771getDsNeutral700d7_KjU()
            r0 = r0 & r17
            goto L_0x01a1
        L_0x01a0:
            r4 = r8
        L_0x01a1:
            if (r10 == 0) goto L_0x01a4
            r11 = 0
        L_0x01a4:
            if (r16 == 0) goto L_0x01a8
            r6 = 0
            goto L_0x01aa
        L_0x01a8:
            r6 = r38
        L_0x01aa:
            if (r1 == 0) goto L_0x01ae
            r1 = 0
            goto L_0x01b0
        L_0x01ae:
            r1 = r39
        L_0x01b0:
            if (r3 == 0) goto L_0x01b4
            r3 = 0
            goto L_0x01b6
        L_0x01b4:
            r3 = r40
        L_0x01b6:
            r12.endDefaults()
            r27 = r0
            r25 = r1
            r16 = r2
            r26 = r3
            r21 = r4
            r24 = r6
            r17 = r7
            goto L_0x016a
        L_0x01c8:
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r12.startReplaceableGroup(r0)
            java.lang.Object r1 = r12.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r2.getEmpty()
            if (r1 != r3) goto L_0x01e1
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r12.updateRememberedValue(r1)
        L_0x01e1:
            r12.endReplaceableGroup()
            r3 = r1
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            java.lang.Object r1 = r12.consume(r1)
            r4 = r1
            android.view.View r4 = (android.view.View) r4
            r12.startReplaceableGroup(r0)
            java.lang.Object r0 = r12.rememberedValue()
            java.lang.Object r1 = r2.getEmpty()
            if (r0 != r1) goto L_0x020e
            androidx.compose.ui.Alignment$Companion r0 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r0 = r0.getCenterVertically()
            r1 = 2
            r2 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r2, r1, r2)
            r12.updateRememberedValue(r0)
        L_0x020e:
            r12.endReplaceableGroup()
            r18 = r0
            androidx.compose.runtime.MutableState r18 = (androidx.compose.runtime.MutableState) r18
            com.designsystem.ds_simple_card.DSSimpleCardKt$DSSimpleCard$2 r10 = new com.designsystem.ds_simple_card.DSSimpleCardKt$DSSimpleCard$2
            r0 = r10
            r1 = r16
            r2 = r25
            r5 = r26
            r6 = r24
            r7 = r17
            r8 = r23
            r9 = r30
            r28 = r10
            r10 = r19
            r29 = r12
            r12 = r18
            r13 = r27
            r14 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14)
            r0 = -819890573(0xffffffffcf217673, float:-2.70889446E9)
            r1 = 1
            r3 = r28
            r2 = r29
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r2, r0, r1, r3)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r2, r1)
            r5 = r17
            r3 = r19
            r6 = r21
            r9 = r24
            r10 = r25
            r11 = r26
        L_0x0251:
            androidx.compose.runtime.ScopeUpdateScope r14 = r2.endRestartGroup()
            if (r14 != 0) goto L_0x0258
            goto L_0x0269
        L_0x0258:
            com.designsystem.ds_simple_card.DSSimpleCardKt$DSSimpleCard$3 r15 = new com.designsystem.ds_simple_card.DSSimpleCardKt$DSSimpleCard$3
            r0 = r15
            r1 = r30
            r2 = r16
            r12 = r42
            r13 = r43
            r0.<init>(r1, r2, r3, r5, r6, r8, r9, r10, r11, r12, r13)
            r14.updateScope(r15)
        L_0x0269:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_simple_card.DSSimpleCardKt.m8571DSSimpleCardbaIBcDA(java.lang.String, androidx.compose.ui.Modifier, long, java.lang.String, long, java.lang.Integer, com.designsystem.ds_simple_card.DSSimpleCardImageModel, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: DSSimpleCard_baIBcDA$lambda-3  reason: not valid java name */
    public static final Alignment.Vertical m8572DSSimpleCard_baIBcDA$lambda3(MutableState<Alignment.Vertical> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DSSimpleCard_baIBcDA$lambda-4  reason: not valid java name */
    public static final void m8573DSSimpleCard_baIBcDA$lambda4(MutableState<Alignment.Vertical> mutableState, Alignment.Vertical vertical) {
        mutableState.setValue(vertical);
    }
}
