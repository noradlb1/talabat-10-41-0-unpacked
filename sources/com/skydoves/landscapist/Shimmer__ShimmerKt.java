package com.skydoves.landscapist;

import androidx.compose.ui.graphics.Paint;
import androidx.core.util.Pools;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\u001aW\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a%\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0002\b\u0016\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"paintPool", "Landroidx/core/util/Pools$SimplePool;", "Landroidx/compose/ui/graphics/Paint;", "Shimmer", "", "modifier", "Landroidx/compose/ui/Modifier;", "baseColor", "Landroidx/compose/ui/graphics/Color;", "highlightColor", "intensity", "", "dropOff", "tilt", "durationMillis", "", "Shimmer-K2djEUw", "(Landroidx/compose/ui/Modifier;JJFFFILandroidx/compose/runtime/Composer;II)V", "offset", "start", "end", "percent", "offset$Shimmer__ShimmerKt", "landscapist_release"}, k = 5, mv = {1, 5, 1}, xi = 48, xs = "com/skydoves/landscapist/Shimmer")
final /* synthetic */ class Shimmer__ShimmerKt {
    /* access modifiers changed from: private */
    @NotNull
    public static final Pools.SimplePool<Paint> paintPool = new Pools.SimplePool<>(2);

    /* JADX WARNING: Removed duplicated region for block: B:103:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:105:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f9  */
    @androidx.compose.runtime.Composable
    /* renamed from: Shimmer-K2djEUw  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m9406ShimmerK2djEUw(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r22, long r23, long r25, float r27, float r28, float r29, int r30, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r31, int r32, int r33) {
        /*
            r10 = r32
            r0 = 460361547(0x1b708f4b, float:1.9898635E-22)
            r1 = r31
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r33 & 1
            if (r1 == 0) goto L_0x0015
            r3 = r10 | 6
            r4 = r3
            r3 = r22
            goto L_0x0029
        L_0x0015:
            r3 = r10 & 14
            if (r3 != 0) goto L_0x0026
            r3 = r22
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0023
            r4 = 4
            goto L_0x0024
        L_0x0023:
            r4 = 2
        L_0x0024:
            r4 = r4 | r10
            goto L_0x0029
        L_0x0026:
            r3 = r22
            r4 = r10
        L_0x0029:
            r5 = r33 & 2
            if (r5 == 0) goto L_0x0030
            r4 = r4 | 48
            goto L_0x0043
        L_0x0030:
            r5 = r10 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x0043
            r5 = r23
            boolean r7 = r0.changed((long) r5)
            if (r7 == 0) goto L_0x003f
            r7 = 32
            goto L_0x0041
        L_0x003f:
            r7 = 16
        L_0x0041:
            r4 = r4 | r7
            goto L_0x0045
        L_0x0043:
            r5 = r23
        L_0x0045:
            r7 = r33 & 4
            if (r7 == 0) goto L_0x004c
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r7 = r10 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x005f
            r7 = r25
            boolean r9 = r0.changed((long) r7)
            if (r9 == 0) goto L_0x005b
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r4 = r4 | r9
            goto L_0x0061
        L_0x005f:
            r7 = r25
        L_0x0061:
            r9 = r33 & 8
            if (r9 == 0) goto L_0x0068
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r11 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x007b
            r11 = r27
            boolean r12 = r0.changed((float) r11)
            if (r12 == 0) goto L_0x0077
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r4 = r4 | r12
            goto L_0x007d
        L_0x007b:
            r11 = r27
        L_0x007d:
            r12 = r33 & 16
            if (r12 == 0) goto L_0x0084
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0084:
            r13 = 57344(0xe000, float:8.0356E-41)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x0099
            r13 = r28
            boolean r14 = r0.changed((float) r13)
            if (r14 == 0) goto L_0x0095
            r14 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r14 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r4 = r4 | r14
            goto L_0x009b
        L_0x0099:
            r13 = r28
        L_0x009b:
            r14 = r33 & 32
            if (r14 == 0) goto L_0x00a3
            r15 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r15
            goto L_0x00b8
        L_0x00a3:
            r15 = 458752(0x70000, float:6.42848E-40)
            r15 = r15 & r10
            if (r15 != 0) goto L_0x00b8
            r15 = r29
            boolean r16 = r0.changed((float) r15)
            if (r16 == 0) goto L_0x00b3
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b5
        L_0x00b3:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b5:
            r4 = r4 | r16
            goto L_0x00ba
        L_0x00b8:
            r15 = r29
        L_0x00ba:
            r16 = r33 & 64
            if (r16 == 0) goto L_0x00c5
            r17 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r17
            r2 = r30
            goto L_0x00da
        L_0x00c5:
            r17 = 3670016(0x380000, float:5.142788E-39)
            r17 = r10 & r17
            r2 = r30
            if (r17 != 0) goto L_0x00da
            boolean r17 = r0.changed((int) r2)
            if (r17 == 0) goto L_0x00d6
            r17 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d8
        L_0x00d6:
            r17 = 524288(0x80000, float:7.34684E-40)
        L_0x00d8:
            r4 = r4 | r17
        L_0x00da:
            r17 = 2995931(0x2db6db, float:4.198194E-39)
            r17 = r4 & r17
            r18 = 599186(0x92492, float:8.39638E-40)
            r17 = r17 ^ r18
            if (r17 != 0) goto L_0x00f9
            boolean r17 = r0.getSkipping()
            if (r17 != 0) goto L_0x00ed
            goto L_0x00f9
        L_0x00ed:
            r0.skipToGroupEnd()
            r1 = r3
            r9 = r11
            r20 = r13
            r21 = r15
        L_0x00f6:
            r11 = r2
            goto L_0x0167
        L_0x00f9:
            if (r1 == 0) goto L_0x00fe
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x00ff
        L_0x00fe:
            r1 = r3
        L_0x00ff:
            r3 = 0
            if (r9 == 0) goto L_0x0104
            r9 = r3
            goto L_0x0105
        L_0x0104:
            r9 = r11
        L_0x0105:
            if (r12 == 0) goto L_0x010c
            r11 = 1056964608(0x3f000000, float:0.5)
            r20 = r11
            goto L_0x010e
        L_0x010c:
            r20 = r13
        L_0x010e:
            if (r14 == 0) goto L_0x0115
            r11 = 1101004800(0x41a00000, float:20.0)
            r21 = r11
            goto L_0x0117
        L_0x0115:
            r21 = r15
        L_0x0117:
            if (r16 == 0) goto L_0x011b
            r2 = 650(0x28a, float:9.11E-43)
        L_0x011b:
            r11 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r11)
            java.lang.Object r11 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r12 = r12.getEmpty()
            r13 = 0
            if (r11 != r12) goto L_0x0136
            r12 = 2
            androidx.compose.animation.core.Animatable r11 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r3, r3, r12, r13)
            r0.updateRememberedValue(r11)
        L_0x0136:
            r0.endReplaceableGroup()
            r14 = r11
            androidx.compose.animation.core.Animatable r14 = (androidx.compose.animation.core.Animatable) r14
            androidx.compose.ui.graphics.Color r11 = androidx.compose.ui.graphics.Color.m2909boximpl(r23)
            com.skydoves.landscapist.Shimmer__ShimmerKt$Shimmer$1 r12 = new com.skydoves.landscapist.Shimmer__ShimmerKt$Shimmer$1
            r12.<init>(r14, r2, r13)
            int r4 = r4 >> 3
            r4 = r4 & 14
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r11, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r12, (androidx.compose.runtime.Composer) r0, (int) r4)
            r4 = 1
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r1, r3, r4, r13)
            com.skydoves.landscapist.Shimmer__ShimmerKt$Shimmer$2 r4 = new com.skydoves.landscapist.Shimmer__ShimmerKt$Shimmer$2
            r11 = r4
            r12 = r21
            r13 = r14
            r14 = r23
            r16 = r25
            r18 = r9
            r19 = r20
            r11.<init>(r12, r13, r14, r16, r18, r19)
            r11 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r3, r4, r0, r11)
            goto L_0x00f6
        L_0x0167:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x016e
            goto L_0x0185
        L_0x016e:
            com.skydoves.landscapist.Shimmer__ShimmerKt$Shimmer$3 r13 = new com.skydoves.landscapist.Shimmer__ShimmerKt$Shimmer$3
            r0 = r13
            r2 = r23
            r4 = r25
            r6 = r9
            r7 = r20
            r8 = r21
            r9 = r11
            r10 = r32
            r11 = r33
            r0.<init>(r1, r2, r4, r6, r7, r8, r9, r10, r11)
            r12.updateScope(r13)
        L_0x0185:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.skydoves.landscapist.Shimmer__ShimmerKt.m9406ShimmerK2djEUw(androidx.compose.ui.Modifier, long, long, float, float, float, int, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final float offset$Shimmer__ShimmerKt(float f11, float f12, float f13) {
        return f11 + ((f12 - f11) * f13);
    }
}
