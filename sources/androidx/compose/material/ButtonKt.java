package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001c"}, d2 = {"Button", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "elevation", "Landroidx/compose/material/ButtonElevation;", "shape", "Landroidx/compose/ui/graphics/Shape;", "border", "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ButtonColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/ButtonElevation;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ButtonColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedButton", "TextButton", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ButtonKt {
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x030a  */
    /* JADX WARNING: Removed duplicated region for block: B:166:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0123  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Button(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r38, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r39, boolean r40, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r41, @org.jetbrains.annotations.Nullable androidx.compose.material.ButtonElevation r42, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r43, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r44, @org.jetbrains.annotations.Nullable androidx.compose.material.ButtonColors r45, @org.jetbrains.annotations.Nullable androidx.compose.foundation.layout.PaddingValues r46, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r47, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r48, int r49, int r50) {
        /*
            r15 = r38
            r14 = r47
            r13 = r49
            r12 = r50
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -2116133464(0xffffffff81de5da8, float:-8.168431E-38)
            r1 = r48
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0022
            r0 = r13 | 6
            goto L_0x0032
        L_0x0022:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0031
            boolean r0 = r11.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x002e
            r0 = 4
            goto L_0x002f
        L_0x002e:
            r0 = 2
        L_0x002f:
            r0 = r0 | r13
            goto L_0x0032
        L_0x0031:
            r0 = r13
        L_0x0032:
            r1 = r12 & 2
            if (r1 == 0) goto L_0x0039
            r0 = r0 | 48
            goto L_0x004c
        L_0x0039:
            r2 = r13 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x004c
            r2 = r39
            boolean r3 = r11.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0048
            r3 = 32
            goto L_0x004a
        L_0x0048:
            r3 = 16
        L_0x004a:
            r0 = r0 | r3
            goto L_0x004e
        L_0x004c:
            r2 = r39
        L_0x004e:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x0055
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0068
            r4 = r40
            boolean r5 = r11.changed((boolean) r4)
            if (r5 == 0) goto L_0x0064
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r0 = r0 | r5
            goto L_0x006a
        L_0x0068:
            r4 = r40
        L_0x006a:
            r5 = r12 & 8
            if (r5 == 0) goto L_0x0071
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0084
            r6 = r41
            boolean r7 = r11.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x0080
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r0 = r0 | r7
            goto L_0x0086
        L_0x0084:
            r6 = r41
        L_0x0086:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r13
            if (r7 != 0) goto L_0x00a1
            r7 = r12 & 16
            if (r7 != 0) goto L_0x009b
            r7 = r42
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x009d
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009b:
            r7 = r42
        L_0x009d:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r8
            goto L_0x00a3
        L_0x00a1:
            r7 = r42
        L_0x00a3:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00bb
            r8 = r12 & 32
            r10 = r43
            if (r8 != 0) goto L_0x00b7
            boolean r8 = r11.changed((java.lang.Object) r10)
            if (r8 == 0) goto L_0x00b7
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r8 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r0 = r0 | r8
            goto L_0x00bd
        L_0x00bb:
            r10 = r43
        L_0x00bd:
            r16 = r12 & 64
            r28 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00c9
            r8 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r8
            r9 = r44
            goto L_0x00db
        L_0x00c9:
            r8 = r13 & r28
            r9 = r44
            if (r8 != 0) goto L_0x00db
            boolean r8 = r11.changed((java.lang.Object) r9)
            if (r8 == 0) goto L_0x00d8
            r8 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00da
        L_0x00d8:
            r8 = 524288(0x80000, float:7.34684E-40)
        L_0x00da:
            r0 = r0 | r8
        L_0x00db:
            r8 = 29360128(0x1c00000, float:7.052966E-38)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00f6
            r8 = r12 & 128(0x80, float:1.794E-43)
            if (r8 != 0) goto L_0x00ef
            r8 = r45
            boolean r17 = r11.changed((java.lang.Object) r8)
            if (r17 == 0) goto L_0x00f1
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f3
        L_0x00ef:
            r8 = r45
        L_0x00f1:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f3:
            r0 = r0 | r17
            goto L_0x00f8
        L_0x00f6:
            r8 = r45
        L_0x00f8:
            r9 = r12 & 256(0x100, float:3.59E-43)
            r29 = 234881024(0xe000000, float:1.5777218E-30)
            if (r9 == 0) goto L_0x0103
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r17
            goto L_0x0119
        L_0x0103:
            r17 = r13 & r29
            if (r17 != 0) goto L_0x0119
            r17 = r9
            r9 = r46
            boolean r18 = r11.changed((java.lang.Object) r9)
            if (r18 == 0) goto L_0x0114
            r18 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0116
        L_0x0114:
            r18 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0116:
            r0 = r0 | r18
            goto L_0x011d
        L_0x0119:
            r17 = r9
            r9 = r46
        L_0x011d:
            r2 = r12 & 512(0x200, float:7.175E-43)
            r30 = 805306368(0x30000000, float:4.656613E-10)
            if (r2 == 0) goto L_0x0126
            r0 = r0 | r30
            goto L_0x0137
        L_0x0126:
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r13
            if (r2 != 0) goto L_0x0137
            boolean r2 = r11.changed((java.lang.Object) r14)
            if (r2 == 0) goto L_0x0134
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0136
        L_0x0134:
            r2 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0136:
            r0 = r0 | r2
        L_0x0137:
            r2 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r2 = r2 & r0
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            if (r2 != r4) goto L_0x0157
            boolean r2 = r11.getSkipping()
            if (r2 != 0) goto L_0x0147
            goto L_0x0157
        L_0x0147:
            r11.skipToGroupEnd()
            r2 = r39
            r3 = r40
            r4 = r6
            r5 = r7
            r6 = r10
            r21 = r11
            r7 = r44
            goto L_0x0303
        L_0x0157:
            r11.startDefaults()
            r2 = r13 & 1
            r31 = 0
            r32 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            r19 = -57345(0xffffffffffff1fff, float:NaN)
            r4 = 1
            if (r2 == 0) goto L_0x0197
            boolean r2 = r11.getDefaultsInvalid()
            if (r2 == 0) goto L_0x0171
            goto L_0x0197
        L_0x0171:
            r11.skipToGroupEnd()
            r1 = r12 & 16
            if (r1 == 0) goto L_0x017a
            r0 = r0 & r19
        L_0x017a:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x0180
            r0 = r0 & r18
        L_0x0180:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0186
            r0 = r0 & r32
        L_0x0186:
            r33 = r39
            r17 = r44
            r16 = r10
            r10 = r40
            r37 = r9
            r9 = r6
            r6 = r8
            r8 = r7
            r7 = r37
            goto L_0x0245
        L_0x0197:
            if (r1 == 0) goto L_0x019e
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r33 = r1
            goto L_0x01a0
        L_0x019e:
            r33 = r39
        L_0x01a0:
            if (r3 == 0) goto L_0x01a5
            r34 = r4
            goto L_0x01a7
        L_0x01a5:
            r34 = r40
        L_0x01a7:
            if (r5 == 0) goto L_0x01ca
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r1)
            java.lang.Object r1 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r1 != r2) goto L_0x01c2
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r1)
        L_0x01c2:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r35 = r1
            goto L_0x01cc
        L_0x01ca:
            r35 = r6
        L_0x01cc:
            r1 = r12 & 16
            if (r1 == 0) goto L_0x01ed
            androidx.compose.material.ButtonDefaults r1 = androidx.compose.material.ButtonDefaults.INSTANCE
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r20 = 196608(0x30000, float:2.75506E-40)
            r21 = 31
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r11
            r8 = r20
            r36 = r17
            r9 = r21
            androidx.compose.material.ButtonElevation r1 = r1.m1130elevationR_JCAzs(r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = r0 & r19
            r7 = r1
            goto L_0x01ef
        L_0x01ed:
            r36 = r17
        L_0x01ef:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x0201
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r2 = 6
            androidx.compose.material.Shapes r1 = r1.getShapes(r11, r2)
            androidx.compose.foundation.shape.CornerBasedShape r1 = r1.getSmall()
            r0 = r0 & r18
            r10 = r1
        L_0x0201:
            if (r16 == 0) goto L_0x0206
            r1 = r31
            goto L_0x0208
        L_0x0206:
            r1 = r44
        L_0x0208:
            r2 = r12 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x0223
            androidx.compose.material.ButtonDefaults r16 = androidx.compose.material.ButtonDefaults.INSTANCE
            r17 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r26 = 24576(0x6000, float:3.4438E-41)
            r27 = 15
            r25 = r11
            androidx.compose.material.ButtonColors r2 = r16.m1129buttonColorsro_MJ88(r17, r19, r21, r23, r25, r26, r27)
            r0 = r0 & r32
            goto L_0x0225
        L_0x0223:
            r2 = r45
        L_0x0225:
            if (r36 == 0) goto L_0x0239
            androidx.compose.material.ButtonDefaults r3 = androidx.compose.material.ButtonDefaults.INSTANCE
            androidx.compose.foundation.layout.PaddingValues r3 = r3.getContentPadding()
            r17 = r1
            r6 = r2
            r8 = r7
            r16 = r10
            r10 = r34
            r9 = r35
            r7 = r3
            goto L_0x0245
        L_0x0239:
            r17 = r1
            r6 = r2
            r8 = r7
            r16 = r10
            r10 = r34
            r9 = r35
            r7 = r46
        L_0x0245:
            r11.endDefaults()
            int r1 = r0 >> 6
            r2 = r1 & 14
            int r3 = r0 >> 18
            r3 = r3 & 112(0x70, float:1.57E-43)
            r3 = r3 | r2
            androidx.compose.runtime.State r4 = r6.contentColor(r10, r11, r3)
            androidx.compose.runtime.State r3 = r6.backgroundColor(r10, r11, r3)
            java.lang.Object r3 = r3.getValue()
            androidx.compose.ui.graphics.Color r3 = (androidx.compose.ui.graphics.Color) r3
            long r18 = r3.m2929unboximpl()
            long r20 = m1139Button$lambda1(r4)
            r3 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            r22 = 0
            r23 = 0
            r24 = 14
            r25 = 0
            r39 = r20
            r41 = r3
            r42 = r5
            r43 = r22
            r44 = r23
            r45 = r24
            r46 = r25
            long r20 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r39, r41, r42, r43, r44, r45, r46)
            if (r8 != 0) goto L_0x0287
            goto L_0x0291
        L_0x0287:
            r3 = r1 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = r1 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            androidx.compose.runtime.State r31 = r8.elevation(r10, r9, r11, r2)
        L_0x0291:
            if (r31 == 0) goto L_0x029e
            java.lang.Object r2 = r31.getValue()
            androidx.compose.ui.unit.Dp r2 = (androidx.compose.ui.unit.Dp) r2
            float r2 = r2.m5492unboximpl()
            goto L_0x02a4
        L_0x029e:
            r2 = 0
            float r2 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r2)
        L_0x02a4:
            r22 = r2
            androidx.compose.material.ButtonKt$Button$2 r2 = new androidx.compose.material.ButtonKt$Button$2
            r2.<init>(r4, r7, r14, r0)
            r3 = 7524271(0x72cfaf, float:1.054375E-38)
            r4 = 1
            androidx.compose.runtime.internal.ComposableLambda r23 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r3, r4, r2)
            r2 = r0 & 14
            r2 = r2 | r30
            r3 = r0 & 112(0x70, float:1.57E-43)
            r2 = r2 | r3
            r3 = r0 & 896(0x380, float:1.256E-42)
            r2 = r2 | r3
            r1 = r1 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r0 & r28
            r1 = r1 | r2
            int r0 = r0 << 15
            r0 = r0 & r29
            r24 = r1 | r0
            r25 = 0
            r0 = r38
            r1 = r33
            r2 = r10
            r3 = r16
            r4 = r18
            r18 = r6
            r19 = r7
            r6 = r20
            r20 = r8
            r8 = r17
            r35 = r9
            r9 = r22
            r34 = r10
            r10 = r35
            r21 = r11
            r11 = r23
            r12 = r21
            r13 = r24
            r14 = r25
            androidx.compose.material.SurfaceKt.m1385SurfaceLPr_se0(r0, r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14)
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r5 = r20
            r2 = r33
            r3 = r34
            r4 = r35
        L_0x0303:
            androidx.compose.runtime.ScopeUpdateScope r13 = r21.endRestartGroup()
            if (r13 != 0) goto L_0x030a
            goto L_0x031b
        L_0x030a:
            androidx.compose.material.ButtonKt$Button$3 r14 = new androidx.compose.material.ButtonKt$Button$3
            r0 = r14
            r1 = r38
            r10 = r47
            r11 = r49
            r12 = r50
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.updateScope(r14)
        L_0x031b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ButtonKt.Button(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.ButtonElevation, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.ButtonColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: Button$lambda-1  reason: not valid java name */
    public static final long m1139Button$lambda1(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void OutlinedButton(@NotNull Function0<Unit> function0, @Nullable Modifier modifier, boolean z11, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable ButtonElevation buttonElevation, @Nullable Shape shape, @Nullable BorderStroke borderStroke, @Nullable ButtonColors buttonColors, @Nullable PaddingValues paddingValues, @NotNull Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i11, int i12) {
        Modifier.Companion companion;
        boolean z12;
        MutableInteractionSource mutableInteractionSource2;
        ButtonElevation buttonElevation2;
        CornerBasedShape cornerBasedShape;
        BorderStroke borderStroke2;
        ButtonColors buttonColors2;
        PaddingValues paddingValues2;
        Composer composer2 = composer;
        int i13 = i11;
        int i14 = i12;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function3, "content");
        composer2.startReplaceableGroup(-1776134358);
        if ((i14 & 2) != 0) {
            companion = Modifier.Companion;
        } else {
            companion = modifier;
        }
        if ((i14 & 4) != 0) {
            z12 = true;
        } else {
            z12 = z11;
        }
        if ((i14 & 8) != 0) {
            composer2.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if ((i14 & 16) != 0) {
            buttonElevation2 = null;
        } else {
            buttonElevation2 = buttonElevation;
        }
        if ((i14 & 32) != 0) {
            cornerBasedShape = MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall();
        } else {
            cornerBasedShape = shape;
        }
        if ((i14 & 64) != 0) {
            borderStroke2 = ButtonDefaults.INSTANCE.getOutlinedBorder(composer2, 6);
        } else {
            borderStroke2 = borderStroke;
        }
        if ((i14 & 128) != 0) {
            buttonColors2 = ButtonDefaults.INSTANCE.m1137outlinedButtonColorsRGew2ao(0, 0, 0, composer, KfsConstant.KFS_RSA_KEY_LEN_3072, 7);
        } else {
            buttonColors2 = buttonColors;
        }
        if ((i14 & 256) != 0) {
            paddingValues2 = ButtonDefaults.INSTANCE.getContentPadding();
        } else {
            paddingValues2 = paddingValues;
        }
        Button(function0, companion, z12, mutableInteractionSource2, buttonElevation2, cornerBasedShape, borderStroke2, buttonColors2, paddingValues2, function3, composer, (i13 & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (29360128 & i13) | (234881024 & i13) | (1879048192 & i13), 0);
        composer.endReplaceableGroup();
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void TextButton(@NotNull Function0<Unit> function0, @Nullable Modifier modifier, boolean z11, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable ButtonElevation buttonElevation, @Nullable Shape shape, @Nullable BorderStroke borderStroke, @Nullable ButtonColors buttonColors, @Nullable PaddingValues paddingValues, @NotNull Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i11, int i12) {
        Modifier.Companion companion;
        boolean z12;
        MutableInteractionSource mutableInteractionSource2;
        ButtonElevation buttonElevation2;
        CornerBasedShape cornerBasedShape;
        BorderStroke borderStroke2;
        ButtonColors buttonColors2;
        PaddingValues paddingValues2;
        Composer composer2 = composer;
        int i13 = i11;
        int i14 = i12;
        Intrinsics.checkNotNullParameter(function0, "onClick");
        Intrinsics.checkNotNullParameter(function3, "content");
        composer2.startReplaceableGroup(288797557);
        if ((i14 & 2) != 0) {
            companion = Modifier.Companion;
        } else {
            companion = modifier;
        }
        if ((i14 & 4) != 0) {
            z12 = true;
        } else {
            z12 = z11;
        }
        if ((i14 & 8) != 0) {
            composer2.startReplaceableGroup(-492369756);
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                composer2.updateRememberedValue(rememberedValue);
            }
            composer.endReplaceableGroup();
            mutableInteractionSource2 = (MutableInteractionSource) rememberedValue;
        } else {
            mutableInteractionSource2 = mutableInteractionSource;
        }
        if ((i14 & 16) != 0) {
            buttonElevation2 = null;
        } else {
            buttonElevation2 = buttonElevation;
        }
        if ((i14 & 32) != 0) {
            cornerBasedShape = MaterialTheme.INSTANCE.getShapes(composer2, 6).getSmall();
        } else {
            cornerBasedShape = shape;
        }
        if ((i14 & 64) != 0) {
            borderStroke2 = null;
        } else {
            borderStroke2 = borderStroke;
        }
        if ((i14 & 128) != 0) {
            buttonColors2 = ButtonDefaults.INSTANCE.m1138textButtonColorsRGew2ao(0, 0, 0, composer, KfsConstant.KFS_RSA_KEY_LEN_3072, 7);
        } else {
            buttonColors2 = buttonColors;
        }
        if ((i14 & 256) != 0) {
            paddingValues2 = ButtonDefaults.INSTANCE.getTextButtonContentPadding();
        } else {
            paddingValues2 = paddingValues;
        }
        Button(function0, companion, z12, mutableInteractionSource2, buttonElevation2, cornerBasedShape, borderStroke2, buttonColors2, paddingValues2, function3, composer, (i13 & 14) | (i13 & 112) | (i13 & 896) | (i13 & 7168) | (57344 & i13) | (458752 & i13) | (3670016 & i13) | (29360128 & i13) | (234881024 & i13) | (1879048192 & i13), 0);
        composer.endReplaceableGroup();
    }
}
