package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u001a¬\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001af\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00142\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010#\u001a\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00142\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010&2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\"\u0010'\u001a/\u0010(\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\u000eH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a;\u0010.\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00062"}, d2 = {"Surface", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "color", "Landroidx/compose/ui/graphics/Color;", "contentColor", "border", "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "content", "Landroidx/compose/runtime/Composable;", "Surface-9VG74zQ", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/Indication;ZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Surface-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Surface-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "selected", "Surface-Ny5ogXk", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "checked", "onCheckedChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "surfaceColorAtElevation", "elevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "absoluteElevation", "surfaceColorAtElevation-cq6XJ1M", "(JLandroidx/compose/material/ElevationOverlay;FLandroidx/compose/runtime/Composer;I)J", "surface", "backgroundColor", "surface-8ww4TTg", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JLandroidx/compose/foundation/BorderStroke;F)Landroidx/compose/ui/Modifier;", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SurfaceKt {
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:203:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x012c  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.material.ExperimentalMaterialApi
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.ERROR, message = "This API is deprecated with the introduction a newer Surface function overload that accepts an onClick().", replaceWith = @kotlin.ReplaceWith(expression = "Surface(onClick, modifier, enabled, shape, color, contentColor, border, elevation, interactionSource, content)", imports = {}))
    @androidx.compose.runtime.Composable
    /* renamed from: Surface-9VG74zQ  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1383Surface9VG74zQ(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r38, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r39, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r40, long r41, long r43, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r45, float r46, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r47, @org.jetbrains.annotations.Nullable androidx.compose.foundation.Indication r48, boolean r49, @org.jetbrains.annotations.Nullable java.lang.String r50, @org.jetbrains.annotations.Nullable androidx.compose.ui.semantics.Role r51, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r53, int r54, int r55, int r56) {
        /*
            r15 = r38
            r14 = r52
            r13 = r54
            r12 = r55
            r11 = r56
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1585925488(0x5e874d70, float:4.874786E18)
            r1 = r53
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
            if (r3 == 0) goto L_0x003b
            r0 = r0 | 48
            goto L_0x004e
        L_0x003b:
            r6 = r13 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004e
            r6 = r39
            boolean r7 = r10.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x004a
            r7 = 32
            goto L_0x004c
        L_0x004a:
            r7 = 16
        L_0x004c:
            r0 = r0 | r7
            goto L_0x0050
        L_0x004e:
            r6 = r39
        L_0x0050:
            r7 = r11 & 4
            if (r7 == 0) goto L_0x0057
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006b
        L_0x0057:
            r1 = r13 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x006b
            r1 = r40
            boolean r16 = r10.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x0066
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r16 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r0 = r0 | r16
            goto L_0x006d
        L_0x006b:
            r1 = r40
        L_0x006d:
            r4 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0085
            r4 = r11 & 8
            r5 = r41
            if (r4 != 0) goto L_0x0080
            boolean r17 = r10.changed((long) r5)
            if (r17 == 0) goto L_0x0080
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r0 = r0 | r17
            goto L_0x0087
        L_0x0085:
            r5 = r41
        L_0x0087:
            r17 = 57344(0xe000, float:8.0356E-41)
            r17 = r13 & r17
            if (r17 != 0) goto L_0x00a1
            r17 = r11 & 16
            r4 = r43
            if (r17 != 0) goto L_0x009d
            boolean r6 = r10.changed((long) r4)
            if (r6 == 0) goto L_0x009d
            r6 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r6 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r6
            goto L_0x00a3
        L_0x00a1:
            r4 = r43
        L_0x00a3:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x00ae
            r18 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r18
            r8 = r45
            goto L_0x00c3
        L_0x00ae:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r13 & r18
            r8 = r45
            if (r18 != 0) goto L_0x00c3
            boolean r19 = r10.changed((java.lang.Object) r8)
            if (r19 == 0) goto L_0x00bf
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c1
        L_0x00bf:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00c1:
            r0 = r0 | r19
        L_0x00c3:
            r19 = r11 & 64
            if (r19 == 0) goto L_0x00ce
            r20 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r20
            r9 = r46
            goto L_0x00e3
        L_0x00ce:
            r20 = 3670016(0x380000, float:5.142788E-39)
            r20 = r13 & r20
            r9 = r46
            if (r20 != 0) goto L_0x00e3
            boolean r21 = r10.changed((float) r9)
            if (r21 == 0) goto L_0x00df
            r21 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r21 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r0 = r0 | r21
        L_0x00e3:
            r2 = r11 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00ee
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r22
            r1 = r47
            goto L_0x0103
        L_0x00ee:
            r22 = 29360128(0x1c00000, float:7.052966E-38)
            r22 = r13 & r22
            r1 = r47
            if (r22 != 0) goto L_0x0103
            boolean r22 = r10.changed((java.lang.Object) r1)
            if (r22 == 0) goto L_0x00ff
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0101
        L_0x00ff:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x0101:
            r0 = r0 | r22
        L_0x0103:
            r22 = 234881024(0xe000000, float:1.5777218E-30)
            r22 = r13 & r22
            if (r22 != 0) goto L_0x011f
            r1 = r11 & 256(0x100, float:3.59E-43)
            if (r1 != 0) goto L_0x0118
            r1 = r48
            boolean r22 = r10.changed((java.lang.Object) r1)
            if (r22 == 0) goto L_0x011a
            r22 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x011c
        L_0x0118:
            r1 = r48
        L_0x011a:
            r22 = 33554432(0x2000000, float:9.403955E-38)
        L_0x011c:
            r0 = r0 | r22
            goto L_0x0121
        L_0x011f:
            r1 = r48
        L_0x0121:
            r1 = r11 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x012c
            r22 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r22
            r4 = r49
            goto L_0x0140
        L_0x012c:
            r22 = 1879048192(0x70000000, float:1.58456325E29)
            r22 = r13 & r22
            r4 = r49
            if (r22 != 0) goto L_0x0140
            boolean r5 = r10.changed((boolean) r4)
            if (r5 == 0) goto L_0x013d
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x013f
        L_0x013d:
            r5 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x013f:
            r0 = r0 | r5
        L_0x0140:
            r5 = r11 & 1024(0x400, float:1.435E-42)
            if (r5 == 0) goto L_0x0149
            r22 = r12 | 6
            r4 = r50
            goto L_0x015f
        L_0x0149:
            r22 = r12 & 14
            r4 = r50
            if (r22 != 0) goto L_0x015d
            boolean r22 = r10.changed((java.lang.Object) r4)
            if (r22 == 0) goto L_0x0158
            r22 = 4
            goto L_0x015a
        L_0x0158:
            r22 = 2
        L_0x015a:
            r22 = r12 | r22
            goto L_0x015f
        L_0x015d:
            r22 = r12
        L_0x015f:
            r4 = r11 & 2048(0x800, float:2.87E-42)
            if (r4 == 0) goto L_0x0166
            r22 = r22 | 48
            goto L_0x0179
        L_0x0166:
            r23 = r12 & 112(0x70, float:1.57E-43)
            r8 = r51
            if (r23 != 0) goto L_0x0179
            boolean r23 = r10.changed((java.lang.Object) r8)
            if (r23 == 0) goto L_0x0175
            r16 = 32
            goto L_0x0177
        L_0x0175:
            r16 = 16
        L_0x0177:
            r22 = r22 | r16
        L_0x0179:
            r8 = r22
            r9 = r11 & 4096(0x1000, float:5.74E-42)
            if (r9 == 0) goto L_0x0182
            r8 = r8 | 384(0x180, float:5.38E-43)
            goto L_0x0193
        L_0x0182:
            r9 = r12 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0193
            boolean r9 = r10.changed((java.lang.Object) r14)
            if (r9 == 0) goto L_0x018f
            r18 = 256(0x100, float:3.59E-43)
            goto L_0x0191
        L_0x018f:
            r18 = 128(0x80, float:1.794E-43)
        L_0x0191:
            r8 = r8 | r18
        L_0x0193:
            r9 = r8
            r8 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r8 = r8 & r0
            r12 = 306783378(0x12492492, float:6.3469493E-28)
            if (r8 != r12) goto L_0x01c6
            r8 = r9 & 731(0x2db, float:1.024E-42)
            r12 = 146(0x92, float:2.05E-43)
            if (r8 != r12) goto L_0x01c6
            boolean r8 = r10.getSkipping()
            if (r8 != 0) goto L_0x01aa
            goto L_0x01c6
        L_0x01aa:
            r10.skipToGroupEnd()
            r2 = r39
            r3 = r40
            r4 = r41
            r6 = r43
            r8 = r45
            r9 = r46
            r11 = r48
            r12 = r49
            r13 = r50
            r14 = r51
            r1 = r10
            r10 = r47
            goto L_0x0351
        L_0x01c6:
            r10.startDefaults()
            r8 = r13 & 1
            r16 = -57345(0xffffffffffff1fff, float:NaN)
            if (r8 == 0) goto L_0x0207
            boolean r8 = r10.getDefaultsInvalid()
            if (r8 == 0) goto L_0x01d7
            goto L_0x0207
        L_0x01d7:
            r10.skipToGroupEnd()
            r1 = r11 & 8
            if (r1 == 0) goto L_0x01e0
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x01e0:
            r1 = r11 & 16
            if (r1 == 0) goto L_0x01e6
            r0 = r0 & r16
        L_0x01e6:
            r1 = r11 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01ee
            r1 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r1
        L_0x01ee:
            r19 = r39
            r20 = r40
            r22 = r41
            r24 = r43
            r26 = r45
            r27 = r46
            r28 = r47
            r29 = r48
            r30 = r49
            r31 = r50
            r32 = r51
            r6 = r0
            goto L_0x02c6
        L_0x0207:
            if (r3 == 0) goto L_0x020c
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x020e
        L_0x020c:
            r3 = r39
        L_0x020e:
            if (r7 == 0) goto L_0x0215
            androidx.compose.ui.graphics.Shape r7 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            goto L_0x0217
        L_0x0215:
            r7 = r40
        L_0x0217:
            r8 = r11 & 8
            if (r8 == 0) goto L_0x022d
            androidx.compose.material.MaterialTheme r8 = androidx.compose.material.MaterialTheme.INSTANCE
            r12 = 6
            androidx.compose.material.Colors r8 = r8.getColors(r10, r12)
            long r22 = r8.m1183getSurface0d7_KjU()
            r0 = r0 & -7169(0xffffffffffffe3ff, float:NaN)
            r39 = r7
            r7 = r22
            goto L_0x0231
        L_0x022d:
            r39 = r7
            r7 = r41
        L_0x0231:
            r12 = r11 & 16
            if (r12 == 0) goto L_0x0240
            int r12 = r0 >> 9
            r12 = r12 & 14
            long r22 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r7, r10, r12)
            r0 = r0 & r16
            goto L_0x0242
        L_0x0240:
            r22 = r43
        L_0x0242:
            if (r6 == 0) goto L_0x0246
            r6 = 0
            goto L_0x0248
        L_0x0246:
            r6 = r45
        L_0x0248:
            r16 = r3
            if (r19 == 0) goto L_0x0253
            r12 = 0
            float r3 = (float) r12
            float r3 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r3)
            goto L_0x0255
        L_0x0253:
            r3 = r46
        L_0x0255:
            if (r2 == 0) goto L_0x0276
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r10.startReplaceableGroup(r2)
            java.lang.Object r2 = r10.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            if (r2 != r12) goto L_0x0270
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r10.updateRememberedValue(r2)
        L_0x0270:
            r10.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r2 = (androidx.compose.foundation.interaction.MutableInteractionSource) r2
            goto L_0x0278
        L_0x0276:
            r2 = r47
        L_0x0278:
            r12 = r11 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x028c
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.foundation.IndicationKt.getLocalIndication()
            java.lang.Object r12 = r10.consume(r12)
            androidx.compose.foundation.Indication r12 = (androidx.compose.foundation.Indication) r12
            r19 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            r0 = r0 & r19
            goto L_0x028e
        L_0x028c:
            r12 = r48
        L_0x028e:
            if (r1 == 0) goto L_0x0292
            r1 = 1
            goto L_0x0294
        L_0x0292:
            r1 = r49
        L_0x0294:
            if (r5 == 0) goto L_0x0298
            r5 = 0
            goto L_0x029a
        L_0x0298:
            r5 = r50
        L_0x029a:
            r20 = r39
            if (r4 == 0) goto L_0x02b1
            r30 = r1
            r28 = r2
            r27 = r3
            r31 = r5
            r26 = r6
            r29 = r12
            r19 = r16
            r24 = r22
            r32 = 0
            goto L_0x02c3
        L_0x02b1:
            r32 = r51
            r30 = r1
            r28 = r2
            r27 = r3
            r31 = r5
            r26 = r6
            r29 = r12
            r19 = r16
            r24 = r22
        L_0x02c3:
            r6 = r0
            r22 = r7
        L_0x02c6:
            r10.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            java.lang.Object r0 = r10.consume(r0)
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r0 = r0.m5492unboximpl()
            float r0 = r0 + r27
            float r0 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r0)
            r5 = r0
            r1 = 2
            androidx.compose.runtime.ProvidedValue[] r12 = new androidx.compose.runtime.ProvidedValue[r1]
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m2909boximpl(r24)
            androidx.compose.runtime.ProvidedValue r1 = r1.provides(r2)
            r2 = 0
            r12[r2] = r1
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.ui.unit.Dp r0 = androidx.compose.ui.unit.Dp.m5476boximpl(r0)
            androidx.compose.runtime.ProvidedValue r0 = r1.provides(r0)
            r16 = 1
            r12[r16] = r0
            androidx.compose.material.SurfaceKt$Surface$13 r8 = new androidx.compose.material.SurfaceKt$Surface$13
            r0 = r8
            r1 = r19
            r2 = r20
            r3 = r22
            r7 = r26
            r33 = r8
            r8 = r27
            r17 = r9
            r9 = r28
            r34 = r10
            r10 = r29
            r11 = r30
            r35 = r12
            r12 = r31
            r13 = r32
            r14 = r38
            r15 = r52
            r16 = r17
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r0 = 149594672(0x8eaa230, float:1.4121493E-33)
            r2 = r33
            r1 = r34
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r3, r2)
            r2 = 56
            r3 = r35
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r1, (int) r2)
            r2 = r19
            r3 = r20
            r4 = r22
            r6 = r24
            r8 = r26
            r9 = r27
            r10 = r28
            r11 = r29
            r12 = r30
            r13 = r31
            r14 = r32
        L_0x0351:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 != 0) goto L_0x0358
            goto L_0x0373
        L_0x0358:
            androidx.compose.material.SurfaceKt$Surface$14 r1 = new androidx.compose.material.SurfaceKt$Surface$14
            r0 = r1
            r36 = r1
            r1 = r38
            r37 = r15
            r15 = r52
            r16 = r54
            r17 = r55
            r18 = r56
            r0.<init>(r1, r2, r3, r4, r6, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            r1 = r36
            r0 = r37
            r0.updateScope(r1)
        L_0x0373:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1383Surface9VG74zQ(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.foundation.Indication, boolean, java.lang.String, androidx.compose.ui.semantics.Role, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00f9  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: Surface-F-jzlyU  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1384SurfaceFjzlyU(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r22, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r23, long r24, long r26, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r28, float r29, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r10 = r30
            r11 = r32
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1412203386(0x542c837a, float:2.96376074E12)
            r1 = r31
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r33 & 1
            if (r0 == 0) goto L_0x001c
            r2 = r11 | 6
            r3 = r2
            r2 = r22
            goto L_0x0030
        L_0x001c:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x002d
            r2 = r22
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002a
            r3 = 4
            goto L_0x002b
        L_0x002a:
            r3 = 2
        L_0x002b:
            r3 = r3 | r11
            goto L_0x0030
        L_0x002d:
            r2 = r22
            r3 = r11
        L_0x0030:
            r4 = r33 & 2
            if (r4 == 0) goto L_0x0037
            r3 = r3 | 48
            goto L_0x004a
        L_0x0037:
            r5 = r11 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004a
            r5 = r23
            boolean r6 = r12.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0046
            r6 = 32
            goto L_0x0048
        L_0x0046:
            r6 = 16
        L_0x0048:
            r3 = r3 | r6
            goto L_0x004c
        L_0x004a:
            r5 = r23
        L_0x004c:
            r6 = r11 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0065
            r6 = r33 & 4
            if (r6 != 0) goto L_0x005f
            r6 = r24
            boolean r8 = r12.changed((long) r6)
            if (r8 == 0) goto L_0x0061
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x005f:
            r6 = r24
        L_0x0061:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r3 = r3 | r8
            goto L_0x0067
        L_0x0065:
            r6 = r24
        L_0x0067:
            r8 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0080
            r8 = r33 & 8
            if (r8 != 0) goto L_0x007a
            r8 = r26
            boolean r13 = r12.changed((long) r8)
            if (r13 == 0) goto L_0x007c
            r13 = 2048(0x800, float:2.87E-42)
            goto L_0x007e
        L_0x007a:
            r8 = r26
        L_0x007c:
            r13 = 1024(0x400, float:1.435E-42)
        L_0x007e:
            r3 = r3 | r13
            goto L_0x0082
        L_0x0080:
            r8 = r26
        L_0x0082:
            r13 = r33 & 16
            if (r13 == 0) goto L_0x0089
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x0089:
            r14 = 57344(0xe000, float:8.0356E-41)
            r14 = r14 & r11
            if (r14 != 0) goto L_0x009e
            r14 = r28
            boolean r15 = r12.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x009a
            r15 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r15 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r3 = r3 | r15
            goto L_0x00a0
        L_0x009e:
            r14 = r28
        L_0x00a0:
            r15 = r33 & 32
            if (r15 == 0) goto L_0x00ab
            r16 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r16
            r1 = r29
            goto L_0x00c0
        L_0x00ab:
            r16 = 458752(0x70000, float:6.42848E-40)
            r16 = r11 & r16
            r1 = r29
            if (r16 != 0) goto L_0x00c0
            boolean r16 = r12.changed((float) r1)
            if (r16 == 0) goto L_0x00bc
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00be
        L_0x00bc:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00be:
            r3 = r3 | r16
        L_0x00c0:
            r16 = r33 & 64
            if (r16 == 0) goto L_0x00c9
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c6:
            r3 = r3 | r16
            goto L_0x00db
        L_0x00c9:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r11 & r16
            if (r16 != 0) goto L_0x00db
            boolean r16 = r12.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x00d8
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c6
        L_0x00d8:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c6
        L_0x00db:
            r16 = 2995931(0x2db6db, float:4.198194E-39)
            r1 = r3 & r16
            r2 = 599186(0x92492, float:8.39638E-40)
            if (r1 != r2) goto L_0x00f9
            boolean r1 = r12.getSkipping()
            if (r1 != 0) goto L_0x00ec
            goto L_0x00f9
        L_0x00ec:
            r12.skipToGroupEnd()
            r1 = r22
            r2 = r5
            r3 = r6
            r5 = r8
            r7 = r14
            r8 = r29
            goto L_0x01ca
        L_0x00f9:
            r12.startDefaults()
            r1 = r11 & 1
            r2 = 0
            if (r1 == 0) goto L_0x012e
            boolean r1 = r12.getDefaultsInvalid()
            if (r1 == 0) goto L_0x0108
            goto L_0x012e
        L_0x0108:
            r12.skipToGroupEnd()
            r0 = r33 & 4
            if (r0 == 0) goto L_0x0111
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x0111:
            r0 = r33 & 8
            if (r0 == 0) goto L_0x0122
            r0 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r13 = r22
            r20 = r29
            r15 = r6
            r17 = r8
            r19 = r14
            r6 = r0
            goto L_0x012c
        L_0x0122:
            r13 = r22
            r20 = r29
        L_0x0126:
            r15 = r6
            r17 = r8
            r19 = r14
            r6 = r3
        L_0x012c:
            r14 = r5
            goto L_0x016e
        L_0x012e:
            if (r0 == 0) goto L_0x0133
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0135
        L_0x0133:
            r0 = r22
        L_0x0135:
            if (r4 == 0) goto L_0x013c
            androidx.compose.ui.graphics.Shape r1 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            r5 = r1
        L_0x013c:
            r1 = r33 & 4
            if (r1 == 0) goto L_0x014d
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r4 = 6
            androidx.compose.material.Colors r1 = r1.getColors(r12, r4)
            long r6 = r1.m1183getSurface0d7_KjU()
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x014d:
            r1 = r33 & 8
            if (r1 == 0) goto L_0x015b
            int r1 = r3 >> 6
            r1 = r1 & 14
            long r8 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r6, r12, r1)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x015b:
            if (r13 == 0) goto L_0x015f
            r1 = 0
            r14 = r1
        L_0x015f:
            if (r15 == 0) goto L_0x016a
            float r1 = (float) r2
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            r13 = r0
            r20 = r1
            goto L_0x0126
        L_0x016a:
            r20 = r29
            r13 = r0
            goto L_0x0126
        L_0x016e:
            r12.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            java.lang.Object r0 = r12.consume(r0)
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r0 = r0.m5492unboximpl()
            float r0 = r0 + r20
            float r5 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r0)
            r0 = 2
            androidx.compose.runtime.ProvidedValue[] r9 = new androidx.compose.runtime.ProvidedValue[r0]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r1 = androidx.compose.ui.graphics.Color.m2909boximpl(r17)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r9[r2] = r0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m5476boximpl(r5)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r8 = 1
            r9[r8] = r0
            androidx.compose.material.SurfaceKt$Surface$1 r7 = new androidx.compose.material.SurfaceKt$Surface$1
            r0 = r7
            r1 = r13
            r2 = r14
            r3 = r15
            r10 = r7
            r7 = r19
            r11 = r8
            r8 = r20
            r21 = r9
            r9 = r30
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9)
            r0 = -1822160838(0xffffffff9364083a, float:-2.8781702E-27)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r12, r0, r11, r10)
            r1 = 56
            r2 = r21
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r12, (int) r1)
            r1 = r13
            r2 = r14
            r5 = r17
        L_0x01ca:
            androidx.compose.runtime.ScopeUpdateScope r12 = r12.endRestartGroup()
            if (r12 != 0) goto L_0x01d1
            goto L_0x01e0
        L_0x01d1:
            androidx.compose.material.SurfaceKt$Surface$2 r13 = new androidx.compose.material.SurfaceKt$Surface$2
            r0 = r13
            r9 = r30
            r10 = r32
            r11 = r33
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11)
            r12.updateScope(r13)
        L_0x01e0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x015f  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0291  */
    /* JADX WARNING: Removed duplicated region for block: B:157:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0126  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.Composable
    /* renamed from: Surface-LPr_se0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1385SurfaceLPr_se0(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r29, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r30, boolean r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r32, long r33, long r35, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r37, float r38, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r39, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r13 = r29
            r14 = r40
            r15 = r42
            r12 = r43
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1560876237(0x5d0914cd, float:6.1735908E17)
            r1 = r41
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0022
            r0 = r15 | 6
            goto L_0x0032
        L_0x0022:
            r0 = r15 & 14
            if (r0 != 0) goto L_0x0031
            boolean r0 = r11.changed((java.lang.Object) r13)
            if (r0 == 0) goto L_0x002e
            r0 = 4
            goto L_0x002f
        L_0x002e:
            r0 = 2
        L_0x002f:
            r0 = r0 | r15
            goto L_0x0032
        L_0x0031:
            r0 = r15
        L_0x0032:
            r2 = r12 & 2
            if (r2 == 0) goto L_0x0039
            r0 = r0 | 48
            goto L_0x004c
        L_0x0039:
            r3 = r15 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004c
            r3 = r30
            boolean r4 = r11.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0048
            r4 = 32
            goto L_0x004a
        L_0x0048:
            r4 = 16
        L_0x004a:
            r0 = r0 | r4
            goto L_0x004e
        L_0x004c:
            r3 = r30
        L_0x004e:
            r4 = r12 & 4
            if (r4 == 0) goto L_0x0055
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r5 = r15 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0068
            r5 = r31
            boolean r6 = r11.changed((boolean) r5)
            if (r6 == 0) goto L_0x0064
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r0 = r0 | r6
            goto L_0x006a
        L_0x0068:
            r5 = r31
        L_0x006a:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x0071
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r7 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r7 != 0) goto L_0x0084
            r7 = r32
            boolean r8 = r11.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0080
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r0 = r0 | r8
            goto L_0x0086
        L_0x0084:
            r7 = r32
        L_0x0086:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r15
            if (r8 != 0) goto L_0x00a1
            r8 = r12 & 16
            if (r8 != 0) goto L_0x009b
            r8 = r33
            boolean r10 = r11.changed((long) r8)
            if (r10 == 0) goto L_0x009d
            r10 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009b:
            r8 = r33
        L_0x009d:
            r10 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r10
            goto L_0x00a3
        L_0x00a1:
            r8 = r33
        L_0x00a3:
            r10 = 458752(0x70000, float:6.42848E-40)
            r10 = r10 & r15
            if (r10 != 0) goto L_0x00c0
            r10 = r12 & 32
            if (r10 != 0) goto L_0x00b8
            r10 = r2
            r1 = r35
            boolean r16 = r11.changed((long) r1)
            if (r16 == 0) goto L_0x00bb
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00b8:
            r10 = r2
            r1 = r35
        L_0x00bb:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r0 = r0 | r16
            goto L_0x00c3
        L_0x00c0:
            r10 = r2
            r1 = r35
        L_0x00c3:
            r16 = r12 & 64
            if (r16 == 0) goto L_0x00ce
            r17 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r17
            r1 = r37
            goto L_0x00e2
        L_0x00ce:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r15 & r17
            r1 = r37
            if (r17 != 0) goto L_0x00e2
            boolean r2 = r11.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x00df
            r2 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e1
        L_0x00df:
            r2 = 524288(0x80000, float:7.34684E-40)
        L_0x00e1:
            r0 = r0 | r2
        L_0x00e2:
            r2 = r12 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00ed
            r17 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r17
            r1 = r38
            goto L_0x0102
        L_0x00ed:
            r17 = 29360128(0x1c00000, float:7.052966E-38)
            r17 = r15 & r17
            r1 = r38
            if (r17 != 0) goto L_0x0102
            boolean r17 = r11.changed((float) r1)
            if (r17 == 0) goto L_0x00fe
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0100
        L_0x00fe:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x0100:
            r0 = r0 | r17
        L_0x0102:
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x010d
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r17
            r3 = r39
            goto L_0x0122
        L_0x010d:
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r15 & r17
            r3 = r39
            if (r17 != 0) goto L_0x0122
            boolean r17 = r11.changed((java.lang.Object) r3)
            if (r17 == 0) goto L_0x011e
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0120
        L_0x011e:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0120:
            r0 = r0 | r17
        L_0x0122:
            r3 = r12 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x012a
            r3 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0128:
            r0 = r0 | r3
            goto L_0x013b
        L_0x012a:
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r15
            if (r3 != 0) goto L_0x013b
            boolean r3 = r11.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0138
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0128
        L_0x0138:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0128
        L_0x013b:
            r3 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r3 = r3 & r0
            r5 = 306783378(0x12492492, float:6.3469493E-28)
            if (r3 != r5) goto L_0x015f
            boolean r3 = r11.getSkipping()
            if (r3 != 0) goto L_0x014b
            goto L_0x015f
        L_0x014b:
            r11.skipToGroupEnd()
            r2 = r30
            r3 = r31
            r10 = r38
            r4 = r7
            r5 = r8
            r15 = r11
            r7 = r35
            r9 = r37
            r11 = r39
            goto L_0x028a
        L_0x015f:
            r11.startDefaults()
            r3 = r15 & 1
            r18 = -57345(0xffffffffffff1fff, float:NaN)
            if (r3 == 0) goto L_0x0194
            boolean r3 = r11.getDefaultsInvalid()
            if (r3 == 0) goto L_0x0170
            goto L_0x0194
        L_0x0170:
            r11.skipToGroupEnd()
            r1 = r12 & 16
            if (r1 == 0) goto L_0x0179
            r0 = r0 & r18
        L_0x0179:
            r1 = r12 & 32
            if (r1 == 0) goto L_0x0181
            r1 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r1
        L_0x0181:
            r16 = r30
            r18 = r31
            r22 = r35
            r24 = r37
            r25 = r38
            r26 = r39
            r6 = r0
            r19 = r7
            r20 = r8
            goto L_0x0216
        L_0x0194:
            if (r10 == 0) goto L_0x0199
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x019b
        L_0x0199:
            r3 = r30
        L_0x019b:
            if (r4 == 0) goto L_0x019f
            r4 = 1
            goto L_0x01a1
        L_0x019f:
            r4 = r31
        L_0x01a1:
            if (r6 == 0) goto L_0x01a8
            androidx.compose.ui.graphics.Shape r6 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            goto L_0x01a9
        L_0x01a8:
            r6 = r7
        L_0x01a9:
            r7 = r12 & 16
            if (r7 == 0) goto L_0x01bb
            androidx.compose.material.MaterialTheme r7 = androidx.compose.material.MaterialTheme.INSTANCE
            r8 = 6
            androidx.compose.material.Colors r7 = r7.getColors(r11, r8)
            long r7 = r7.m1183getSurface0d7_KjU()
            r0 = r0 & r18
            goto L_0x01bc
        L_0x01bb:
            r7 = r8
        L_0x01bc:
            r9 = r12 & 32
            if (r9 == 0) goto L_0x01ce
            int r9 = r0 >> 12
            r9 = r9 & 14
            long r9 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r7, r11, r9)
            r17 = -458753(0xfffffffffff8ffff, float:NaN)
            r0 = r0 & r17
            goto L_0x01d0
        L_0x01ce:
            r9 = r35
        L_0x01d0:
            if (r16 == 0) goto L_0x01d5
            r16 = 0
            goto L_0x01d7
        L_0x01d5:
            r16 = r37
        L_0x01d7:
            if (r2 == 0) goto L_0x01e0
            r2 = 0
            float r5 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r5)
            goto L_0x01e2
        L_0x01e0:
            r2 = r38
        L_0x01e2:
            if (r1 == 0) goto L_0x0205
            r1 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r1)
            java.lang.Object r1 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r5 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r5.getEmpty()
            if (r1 != r5) goto L_0x01fd
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r1)
        L_0x01fd:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r1 = (androidx.compose.foundation.interaction.MutableInteractionSource) r1
            r26 = r1
            goto L_0x0207
        L_0x0205:
            r26 = r39
        L_0x0207:
            r25 = r2
            r18 = r4
            r19 = r6
            r20 = r7
            r22 = r9
            r24 = r16
            r6 = r0
            r16 = r3
        L_0x0216:
            r11.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            java.lang.Object r0 = r11.consume(r0)
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r0 = r0.m5492unboximpl()
            float r0 = r0 + r25
            float r5 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r0)
            r0 = 2
            androidx.compose.runtime.ProvidedValue[] r10 = new androidx.compose.runtime.ProvidedValue[r0]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r1 = androidx.compose.ui.graphics.Color.m2909boximpl(r22)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r1 = 0
            r10[r1] = r0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m5476boximpl(r5)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r7 = 1
            r10[r7] = r0
            androidx.compose.material.SurfaceKt$Surface$4 r9 = new androidx.compose.material.SurfaceKt$Surface$4
            r0 = r9
            r1 = r16
            r2 = r19
            r3 = r20
            r8 = r7
            r7 = r24
            r13 = r8
            r8 = r25
            r14 = r9
            r9 = r26
            r27 = r10
            r10 = r18
            r15 = r11
            r11 = r29
            r12 = r40
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = 2031491085(0x7916180d, float:4.870827E34)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r13, r14)
            r1 = 56
            r2 = r27
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r2, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r15, (int) r1)
            r2 = r16
            r3 = r18
            r4 = r19
            r5 = r20
            r7 = r22
            r9 = r24
            r10 = r25
            r11 = r26
        L_0x028a:
            androidx.compose.runtime.ScopeUpdateScope r15 = r15.endRestartGroup()
            if (r15 != 0) goto L_0x0291
            goto L_0x02a6
        L_0x0291:
            androidx.compose.material.SurfaceKt$Surface$5 r14 = new androidx.compose.material.SurfaceKt$Surface$5
            r0 = r14
            r1 = r29
            r12 = r40
            r13 = r42
            r28 = r14
            r14 = r43
            r0.<init>(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r14)
            r0 = r28
            r15.updateScope(r0)
        L_0x02a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1385SurfaceLPr_se0(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0124  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.Composable
    /* renamed from: Surface-Ny5ogXk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1386SurfaceNy5ogXk(boolean r32, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r33, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r34, boolean r35, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r36, long r37, long r39, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r41, float r42, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r43, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r45, int r46, int r47, int r48) {
        /*
            r15 = r33
            r14 = r44
            r13 = r46
            r12 = r48
            java.lang.String r0 = "onClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 262027249(0xf9e37f1, float:1.560155E-29)
            r1 = r45
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0024
            r0 = r13 | 6
            r10 = r32
            goto L_0x0036
        L_0x0024:
            r0 = r13 & 14
            r10 = r32
            if (r0 != 0) goto L_0x0035
            boolean r0 = r11.changed((boolean) r10)
            if (r0 == 0) goto L_0x0032
            r0 = 4
            goto L_0x0033
        L_0x0032:
            r0 = 2
        L_0x0033:
            r0 = r0 | r13
            goto L_0x0036
        L_0x0035:
            r0 = r13
        L_0x0036:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x003d
            r0 = r0 | 48
            goto L_0x004d
        L_0x003d:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004d
            boolean r3 = r11.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x004a
            r3 = 32
            goto L_0x004c
        L_0x004a:
            r3 = 16
        L_0x004c:
            r0 = r0 | r3
        L_0x004d:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x0054
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0054:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0067
            r4 = r34
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0063
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r0 = r0 | r5
            goto L_0x0069
        L_0x0067:
            r4 = r34
        L_0x0069:
            r5 = r12 & 8
            if (r5 == 0) goto L_0x0070
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x0070:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0083
            r6 = r35
            boolean r7 = r11.changed((boolean) r6)
            if (r7 == 0) goto L_0x007f
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r0 = r0 | r7
            goto L_0x0085
        L_0x0083:
            r6 = r35
        L_0x0085:
            r7 = r12 & 16
            if (r7 == 0) goto L_0x008c
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008c:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00a1
            r8 = r36
            boolean r9 = r11.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x009d
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r9
            goto L_0x00a3
        L_0x00a1:
            r8 = r36
        L_0x00a3:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00bc
            r9 = r12 & 32
            r1 = r37
            if (r9 != 0) goto L_0x00b7
            boolean r16 = r11.changed((long) r1)
            if (r16 == 0) goto L_0x00b7
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r0 = r0 | r16
            goto L_0x00be
        L_0x00bc:
            r1 = r37
        L_0x00be:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00d8
            r16 = r12 & 64
            r9 = r39
            if (r16 != 0) goto L_0x00d3
            boolean r17 = r11.changed((long) r9)
            if (r17 == 0) goto L_0x00d3
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d5
        L_0x00d3:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d5:
            r0 = r0 | r17
            goto L_0x00da
        L_0x00d8:
            r9 = r39
        L_0x00da:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x00e2
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r2
            goto L_0x00f7
        L_0x00e2:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r13
            if (r2 != 0) goto L_0x00f7
            r2 = r41
            boolean r17 = r11.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x00f2
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x00f2:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f4:
            r0 = r0 | r17
            goto L_0x00f9
        L_0x00f7:
            r2 = r41
        L_0x00f9:
            r2 = r12 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0104
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r17
            r4 = r42
            goto L_0x0119
        L_0x0104:
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r13 & r17
            r4 = r42
            if (r17 != 0) goto L_0x0119
            boolean r17 = r11.changed((float) r4)
            if (r17 == 0) goto L_0x0115
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0115:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r0 = r0 | r17
        L_0x0119:
            r4 = r12 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0124
            r17 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r17
            r6 = r43
            goto L_0x0139
        L_0x0124:
            r17 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = r13 & r17
            r6 = r43
            if (r17 != 0) goto L_0x0139
            boolean r17 = r11.changed((java.lang.Object) r6)
            if (r17 == 0) goto L_0x0135
            r17 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0137
        L_0x0135:
            r17 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0137:
            r0 = r0 | r17
        L_0x0139:
            r6 = r12 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x0142
            r6 = r47 | 6
        L_0x013f:
            r17 = r6
            goto L_0x0154
        L_0x0142:
            r6 = r47 & 14
            if (r6 != 0) goto L_0x0152
            boolean r6 = r11.changed((java.lang.Object) r14)
            if (r6 == 0) goto L_0x014e
            r6 = 4
            goto L_0x014f
        L_0x014e:
            r6 = 2
        L_0x014f:
            r6 = r47 | r6
            goto L_0x013f
        L_0x0152:
            r17 = r47
        L_0x0154:
            r6 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r6 = r6 & r0
            r8 = 306783378(0x12492492, float:6.3469493E-28)
            if (r6 != r8) goto L_0x017e
            r6 = r17 & 11
            r8 = 2
            if (r6 != r8) goto L_0x017e
            boolean r8 = r11.getSkipping()
            if (r8 != 0) goto L_0x0169
            goto L_0x017e
        L_0x0169:
            r11.skipToGroupEnd()
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r37
            r12 = r43
            r8 = r9
            r1 = r11
            r10 = r41
            r11 = r42
            goto L_0x02bf
        L_0x017e:
            r11.startDefaults()
            r8 = r13 & 1
            r16 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r8 == 0) goto L_0x01b4
            boolean r8 = r11.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0192
            goto L_0x01b4
        L_0x0192:
            r11.skipToGroupEnd()
            r1 = r12 & 32
            if (r1 == 0) goto L_0x019b
            r0 = r0 & r18
        L_0x019b:
            r1 = r12 & 64
            if (r1 == 0) goto L_0x01a1
            r0 = r0 & r16
        L_0x01a1:
            r16 = r34
            r18 = r35
            r19 = r36
            r20 = r37
            r24 = r41
            r25 = r42
            r26 = r43
            r6 = r0
            r22 = r9
            goto L_0x0241
        L_0x01b4:
            if (r3 == 0) goto L_0x01b9
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x01bb
        L_0x01b9:
            r3 = r34
        L_0x01bb:
            if (r5 == 0) goto L_0x01bf
            r5 = 1
            goto L_0x01c1
        L_0x01bf:
            r5 = r35
        L_0x01c1:
            if (r7 == 0) goto L_0x01c8
            androidx.compose.ui.graphics.Shape r7 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            goto L_0x01ca
        L_0x01c8:
            r7 = r36
        L_0x01ca:
            r8 = r12 & 32
            if (r8 == 0) goto L_0x01e0
            androidx.compose.material.MaterialTheme r8 = androidx.compose.material.MaterialTheme.INSTANCE
            r6 = 6
            androidx.compose.material.Colors r6 = r8.getColors(r11, r6)
            long r19 = r6.m1183getSurface0d7_KjU()
            r0 = r0 & r18
            r34 = r5
            r5 = r19
            goto L_0x01e4
        L_0x01e0:
            r34 = r5
            r5 = r37
        L_0x01e4:
            r8 = r12 & 64
            if (r8 == 0) goto L_0x01f3
            int r8 = r0 >> 15
            r8 = r8 & 14
            long r8 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r5, r11, r8)
            r0 = r0 & r16
            goto L_0x01f4
        L_0x01f3:
            r8 = r9
        L_0x01f4:
            if (r1 == 0) goto L_0x01f8
            r1 = 0
            goto L_0x01fa
        L_0x01f8:
            r1 = r41
        L_0x01fa:
            if (r2 == 0) goto L_0x0203
            r2 = 0
            float r10 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r10)
            goto L_0x0205
        L_0x0203:
            r2 = r42
        L_0x0205:
            if (r4 == 0) goto L_0x0230
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r4)
            java.lang.Object r4 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r4 != r10) goto L_0x0220
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r4)
        L_0x0220:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            r18 = r34
            r24 = r1
            r25 = r2
            r16 = r3
            r26 = r4
            goto L_0x023a
        L_0x0230:
            r18 = r34
            r26 = r43
            r24 = r1
            r25 = r2
            r16 = r3
        L_0x023a:
            r20 = r5
            r19 = r7
            r22 = r8
            r6 = r0
        L_0x0241:
            r11.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            java.lang.Object r0 = r11.consume(r0)
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r0 = r0.m5492unboximpl()
            float r0 = r0 + r25
            float r5 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r0)
            r0 = 2
            androidx.compose.runtime.ProvidedValue[] r10 = new androidx.compose.runtime.ProvidedValue[r0]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r1 = androidx.compose.ui.graphics.Color.m2909boximpl(r22)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r1 = 0
            r10[r1] = r0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m5476boximpl(r5)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r7 = 1
            r10[r7] = r0
            androidx.compose.material.SurfaceKt$Surface$7 r9 = new androidx.compose.material.SurfaceKt$Surface$7
            r0 = r9
            r1 = r16
            r2 = r19
            r3 = r20
            r8 = r7
            r7 = r24
            r15 = r8
            r8 = r25
            r27 = r9
            r9 = r32
            r28 = r10
            r10 = r26
            r29 = r11
            r11 = r18
            r12 = r33
            r13 = r44
            r14 = r17
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = -1391199439(0xffffffffad13fb31, float:-8.411758E-12)
            r2 = r27
            r1 = r29
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r15, r2)
            r2 = 56
            r3 = r28
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r1, (int) r2)
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r8 = r22
            r10 = r24
            r11 = r25
            r12 = r26
        L_0x02bf:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 != 0) goto L_0x02c6
            goto L_0x02e3
        L_0x02c6:
            androidx.compose.material.SurfaceKt$Surface$8 r14 = new androidx.compose.material.SurfaceKt$Surface$8
            r0 = r14
            r1 = r32
            r2 = r33
            r13 = r44
            r30 = r14
            r14 = r46
            r31 = r15
            r15 = r47
            r16 = r48
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16)
            r1 = r30
            r0 = r31
            r0.updateScope(r1)
        L_0x02e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1386SurfaceNy5ogXk(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: surface-8ww4TTg  reason: not valid java name */
    public static final Modifier m1390surface8ww4TTg(Modifier modifier, Shape shape, long j11, BorderStroke borderStroke, float f11) {
        Modifier modifier2;
        Modifier r102 = ShadowKt.m2593shadows4CzXII$default(modifier, f11, shape, false, 0, 0, 24, (Object) null);
        if (borderStroke != null) {
            modifier2 = BorderKt.border(Modifier.Companion, borderStroke, shape);
        } else {
            modifier2 = Modifier.Companion;
        }
        return ClipKt.clip(BackgroundKt.m176backgroundbw27NRU(r102.then(modifier2), j11, shape), shape);
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[0[0]]")
    @Composable
    /* renamed from: surfaceColorAtElevation-cq6XJ1M  reason: not valid java name */
    public static final long m1391surfaceColorAtElevationcq6XJ1M(long j11, ElevationOverlay elevationOverlay, float f11, Composer composer, int i11) {
        composer.startReplaceableGroup(1561611256);
        if (Color.m2920equalsimpl0(j11, MaterialTheme.INSTANCE.getColors(composer, 6).m1183getSurface0d7_KjU()) && elevationOverlay != null) {
            j11 = elevationOverlay.m1247apply7g2Lkgo(j11, f11, composer, (i11 & 14) | ((i11 >> 3) & 112) | ((i11 << 3) & 896));
        }
        composer.endReplaceableGroup();
        return j11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x02c6  */
    /* JADX WARNING: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0124  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.material.ExperimentalMaterialApi
    @androidx.compose.runtime.Composable
    /* renamed from: Surface-Ny5ogXk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1387SurfaceNy5ogXk(boolean r32, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r33, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r34, boolean r35, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r36, long r37, long r39, @org.jetbrains.annotations.Nullable androidx.compose.foundation.BorderStroke r41, float r42, @org.jetbrains.annotations.Nullable androidx.compose.foundation.interaction.MutableInteractionSource r43, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r45, int r46, int r47, int r48) {
        /*
            r15 = r33
            r14 = r44
            r13 = r46
            r12 = r48
            java.lang.String r0 = "onCheckedChange"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = 1341569296(0x4ff6b910, float:8.2786468E9)
            r1 = r45
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0024
            r0 = r13 | 6
            r10 = r32
            goto L_0x0036
        L_0x0024:
            r0 = r13 & 14
            r10 = r32
            if (r0 != 0) goto L_0x0035
            boolean r0 = r11.changed((boolean) r10)
            if (r0 == 0) goto L_0x0032
            r0 = 4
            goto L_0x0033
        L_0x0032:
            r0 = 2
        L_0x0033:
            r0 = r0 | r13
            goto L_0x0036
        L_0x0035:
            r0 = r13
        L_0x0036:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x003d
            r0 = r0 | 48
            goto L_0x004d
        L_0x003d:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x004d
            boolean r3 = r11.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x004a
            r3 = 32
            goto L_0x004c
        L_0x004a:
            r3 = 16
        L_0x004c:
            r0 = r0 | r3
        L_0x004d:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x0054
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0067
        L_0x0054:
            r4 = r13 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0067
            r4 = r34
            boolean r5 = r11.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0063
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r0 = r0 | r5
            goto L_0x0069
        L_0x0067:
            r4 = r34
        L_0x0069:
            r5 = r12 & 8
            if (r5 == 0) goto L_0x0070
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0083
        L_0x0070:
            r6 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0083
            r6 = r35
            boolean r7 = r11.changed((boolean) r6)
            if (r7 == 0) goto L_0x007f
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0081
        L_0x007f:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0081:
            r0 = r0 | r7
            goto L_0x0085
        L_0x0083:
            r6 = r35
        L_0x0085:
            r7 = r12 & 16
            if (r7 == 0) goto L_0x008c
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a1
        L_0x008c:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r13
            if (r8 != 0) goto L_0x00a1
            r8 = r36
            boolean r9 = r11.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x009d
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009f
        L_0x009d:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x009f:
            r0 = r0 | r9
            goto L_0x00a3
        L_0x00a1:
            r8 = r36
        L_0x00a3:
            r9 = 458752(0x70000, float:6.42848E-40)
            r9 = r9 & r13
            if (r9 != 0) goto L_0x00bc
            r9 = r12 & 32
            r1 = r37
            if (r9 != 0) goto L_0x00b7
            boolean r16 = r11.changed((long) r1)
            if (r16 == 0) goto L_0x00b7
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r0 = r0 | r16
            goto L_0x00be
        L_0x00bc:
            r1 = r37
        L_0x00be:
            r16 = 3670016(0x380000, float:5.142788E-39)
            r16 = r13 & r16
            if (r16 != 0) goto L_0x00d8
            r16 = r12 & 64
            r9 = r39
            if (r16 != 0) goto L_0x00d3
            boolean r17 = r11.changed((long) r9)
            if (r17 == 0) goto L_0x00d3
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d5
        L_0x00d3:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d5:
            r0 = r0 | r17
            goto L_0x00da
        L_0x00d8:
            r9 = r39
        L_0x00da:
            r1 = r12 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x00e2
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r2
            goto L_0x00f7
        L_0x00e2:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r13
            if (r2 != 0) goto L_0x00f7
            r2 = r41
            boolean r17 = r11.changed((java.lang.Object) r2)
            if (r17 == 0) goto L_0x00f2
            r17 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f4
        L_0x00f2:
            r17 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f4:
            r0 = r0 | r17
            goto L_0x00f9
        L_0x00f7:
            r2 = r41
        L_0x00f9:
            r2 = r12 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0104
            r17 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r17
            r4 = r42
            goto L_0x0119
        L_0x0104:
            r17 = 234881024(0xe000000, float:1.5777218E-30)
            r17 = r13 & r17
            r4 = r42
            if (r17 != 0) goto L_0x0119
            boolean r17 = r11.changed((float) r4)
            if (r17 == 0) goto L_0x0115
            r17 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0115:
            r17 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r0 = r0 | r17
        L_0x0119:
            r4 = r12 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x0124
            r17 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r17
            r6 = r43
            goto L_0x0139
        L_0x0124:
            r17 = 1879048192(0x70000000, float:1.58456325E29)
            r17 = r13 & r17
            r6 = r43
            if (r17 != 0) goto L_0x0139
            boolean r17 = r11.changed((java.lang.Object) r6)
            if (r17 == 0) goto L_0x0135
            r17 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0137
        L_0x0135:
            r17 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x0137:
            r0 = r0 | r17
        L_0x0139:
            r6 = r12 & 1024(0x400, float:1.435E-42)
            if (r6 == 0) goto L_0x0142
            r6 = r47 | 6
        L_0x013f:
            r17 = r6
            goto L_0x0154
        L_0x0142:
            r6 = r47 & 14
            if (r6 != 0) goto L_0x0152
            boolean r6 = r11.changed((java.lang.Object) r14)
            if (r6 == 0) goto L_0x014e
            r6 = 4
            goto L_0x014f
        L_0x014e:
            r6 = 2
        L_0x014f:
            r6 = r47 | r6
            goto L_0x013f
        L_0x0152:
            r17 = r47
        L_0x0154:
            r6 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r6 = r6 & r0
            r8 = 306783378(0x12492492, float:6.3469493E-28)
            if (r6 != r8) goto L_0x017e
            r6 = r17 & 11
            r8 = 2
            if (r6 != r8) goto L_0x017e
            boolean r8 = r11.getSkipping()
            if (r8 != 0) goto L_0x0169
            goto L_0x017e
        L_0x0169:
            r11.skipToGroupEnd()
            r3 = r34
            r4 = r35
            r5 = r36
            r6 = r37
            r12 = r43
            r8 = r9
            r1 = r11
            r10 = r41
            r11 = r42
            goto L_0x02bf
        L_0x017e:
            r11.startDefaults()
            r8 = r13 & 1
            r16 = -3670017(0xffffffffffc7ffff, float:NaN)
            r18 = -458753(0xfffffffffff8ffff, float:NaN)
            if (r8 == 0) goto L_0x01b4
            boolean r8 = r11.getDefaultsInvalid()
            if (r8 == 0) goto L_0x0192
            goto L_0x01b4
        L_0x0192:
            r11.skipToGroupEnd()
            r1 = r12 & 32
            if (r1 == 0) goto L_0x019b
            r0 = r0 & r18
        L_0x019b:
            r1 = r12 & 64
            if (r1 == 0) goto L_0x01a1
            r0 = r0 & r16
        L_0x01a1:
            r16 = r34
            r18 = r35
            r19 = r36
            r20 = r37
            r24 = r41
            r25 = r42
            r26 = r43
            r6 = r0
            r22 = r9
            goto L_0x0241
        L_0x01b4:
            if (r3 == 0) goto L_0x01b9
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x01bb
        L_0x01b9:
            r3 = r34
        L_0x01bb:
            if (r5 == 0) goto L_0x01bf
            r5 = 1
            goto L_0x01c1
        L_0x01bf:
            r5 = r35
        L_0x01c1:
            if (r7 == 0) goto L_0x01c8
            androidx.compose.ui.graphics.Shape r7 = androidx.compose.ui.graphics.RectangleShapeKt.getRectangleShape()
            goto L_0x01ca
        L_0x01c8:
            r7 = r36
        L_0x01ca:
            r8 = r12 & 32
            if (r8 == 0) goto L_0x01e0
            androidx.compose.material.MaterialTheme r8 = androidx.compose.material.MaterialTheme.INSTANCE
            r6 = 6
            androidx.compose.material.Colors r6 = r8.getColors(r11, r6)
            long r19 = r6.m1183getSurface0d7_KjU()
            r0 = r0 & r18
            r34 = r5
            r5 = r19
            goto L_0x01e4
        L_0x01e0:
            r34 = r5
            r5 = r37
        L_0x01e4:
            r8 = r12 & 64
            if (r8 == 0) goto L_0x01f3
            int r8 = r0 >> 15
            r8 = r8 & 14
            long r8 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r5, r11, r8)
            r0 = r0 & r16
            goto L_0x01f4
        L_0x01f3:
            r8 = r9
        L_0x01f4:
            if (r1 == 0) goto L_0x01f8
            r1 = 0
            goto L_0x01fa
        L_0x01f8:
            r1 = r41
        L_0x01fa:
            if (r2 == 0) goto L_0x0203
            r2 = 0
            float r10 = (float) r2
            float r2 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r10)
            goto L_0x0205
        L_0x0203:
            r2 = r42
        L_0x0205:
            if (r4 == 0) goto L_0x0230
            r4 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r4)
            java.lang.Object r4 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r4 != r10) goto L_0x0220
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r4)
        L_0x0220:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r4 = (androidx.compose.foundation.interaction.MutableInteractionSource) r4
            r18 = r34
            r24 = r1
            r25 = r2
            r16 = r3
            r26 = r4
            goto L_0x023a
        L_0x0230:
            r18 = r34
            r26 = r43
            r24 = r1
            r25 = r2
            r16 = r3
        L_0x023a:
            r20 = r5
            r19 = r7
            r22 = r8
            r6 = r0
        L_0x0241:
            r11.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            java.lang.Object r0 = r11.consume(r0)
            androidx.compose.ui.unit.Dp r0 = (androidx.compose.ui.unit.Dp) r0
            float r0 = r0.m5492unboximpl()
            float r0 = r0 + r25
            float r5 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r0)
            r0 = 2
            androidx.compose.runtime.ProvidedValue[] r10 = new androidx.compose.runtime.ProvidedValue[r0]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ContentColorKt.getLocalContentColor()
            androidx.compose.ui.graphics.Color r1 = androidx.compose.ui.graphics.Color.m2909boximpl(r22)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r1 = 0
            r10[r1] = r0
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.material.ElevationOverlayKt.getLocalAbsoluteElevation()
            androidx.compose.ui.unit.Dp r1 = androidx.compose.ui.unit.Dp.m5476boximpl(r5)
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r7 = 1
            r10[r7] = r0
            androidx.compose.material.SurfaceKt$Surface$10 r9 = new androidx.compose.material.SurfaceKt$Surface$10
            r0 = r9
            r1 = r16
            r2 = r19
            r3 = r20
            r8 = r7
            r7 = r24
            r15 = r8
            r8 = r25
            r27 = r9
            r9 = r32
            r28 = r10
            r10 = r26
            r29 = r11
            r11 = r18
            r12 = r33
            r13 = r44
            r14 = r17
            r0.<init>(r1, r2, r3, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = -311657392(0xffffffffed6c7c50, float:-4.5742967E27)
            r2 = r27
            r1 = r29
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r15, r2)
            r2 = 56
            r3 = r28
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r1, (int) r2)
            r3 = r16
            r4 = r18
            r5 = r19
            r6 = r20
            r8 = r22
            r10 = r24
            r11 = r25
            r12 = r26
        L_0x02bf:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 != 0) goto L_0x02c6
            goto L_0x02e3
        L_0x02c6:
            androidx.compose.material.SurfaceKt$Surface$11 r14 = new androidx.compose.material.SurfaceKt$Surface$11
            r0 = r14
            r1 = r32
            r2 = r33
            r13 = r44
            r30 = r14
            r14 = r46
            r31 = r15
            r15 = r47
            r16 = r48
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r14, r15, r16)
            r1 = r30
            r0 = r31
            r0.updateScope(r1)
        L_0x02e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SurfaceKt.m1387SurfaceNy5ogXk(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.foundation.BorderStroke, float, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }
}
