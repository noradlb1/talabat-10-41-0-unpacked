package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a©\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, d2 = {"Group", "", "name", "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class VectorComposeKt {
    /* JADX WARNING: Removed duplicated region for block: B:103:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01ca  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x01da  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x024a  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0115  */
    @androidx.compose.ui.graphics.vector.VectorComposable
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Group(@org.jetbrains.annotations.Nullable java.lang.String r20, float r21, float r22, float r23, float r24, float r25, float r26, float r27, @org.jetbrains.annotations.Nullable java.util.List<? extends androidx.compose.ui.graphics.vector.PathNode> r28, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r10 = r29
            r11 = r31
            r12 = r32
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -213417674(0xfffffffff3478136, float:-1.5806393E31)
            r1 = r30
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            r2 = r12 & 1
            if (r2 == 0) goto L_0x001e
            r3 = r11 | 6
            r4 = r3
            r3 = r20
            goto L_0x0032
        L_0x001e:
            r3 = r11 & 14
            if (r3 != 0) goto L_0x002f
            r3 = r20
            boolean r4 = r1.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x002c
            r4 = 4
            goto L_0x002d
        L_0x002c:
            r4 = 2
        L_0x002d:
            r4 = r4 | r11
            goto L_0x0032
        L_0x002f:
            r3 = r20
            r4 = r11
        L_0x0032:
            r5 = r12 & 2
            if (r5 == 0) goto L_0x0039
            r4 = r4 | 48
            goto L_0x004c
        L_0x0039:
            r6 = r11 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x004c
            r6 = r21
            boolean r7 = r1.changed((float) r6)
            if (r7 == 0) goto L_0x0048
            r7 = 32
            goto L_0x004a
        L_0x0048:
            r7 = 16
        L_0x004a:
            r4 = r4 | r7
            goto L_0x004e
        L_0x004c:
            r6 = r21
        L_0x004e:
            r7 = r12 & 4
            if (r7 == 0) goto L_0x0055
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r9 = r11 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0068
            r9 = r22
            boolean r13 = r1.changed((float) r9)
            if (r13 == 0) goto L_0x0064
            r13 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r13 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r4 = r4 | r13
            goto L_0x006a
        L_0x0068:
            r9 = r22
        L_0x006a:
            r13 = r12 & 8
            if (r13 == 0) goto L_0x0071
            r4 = r4 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r14 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r14 != 0) goto L_0x0084
            r14 = r23
            boolean r15 = r1.changed((float) r14)
            if (r15 == 0) goto L_0x0080
            r15 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r15 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r4 = r4 | r15
            goto L_0x0086
        L_0x0084:
            r14 = r23
        L_0x0086:
            r15 = r12 & 16
            if (r15 == 0) goto L_0x008f
            r4 = r4 | 24576(0x6000, float:3.4438E-41)
            r0 = r24
            goto L_0x00a5
        L_0x008f:
            r16 = 57344(0xe000, float:8.0356E-41)
            r16 = r11 & r16
            r0 = r24
            if (r16 != 0) goto L_0x00a5
            boolean r17 = r1.changed((float) r0)
            if (r17 == 0) goto L_0x00a1
            r17 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x00a1:
            r17 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r4 = r4 | r17
        L_0x00a5:
            r17 = r12 & 32
            if (r17 == 0) goto L_0x00b0
            r18 = 196608(0x30000, float:2.75506E-40)
            r4 = r4 | r18
            r8 = r25
            goto L_0x00c5
        L_0x00b0:
            r18 = 458752(0x70000, float:6.42848E-40)
            r18 = r11 & r18
            r8 = r25
            if (r18 != 0) goto L_0x00c5
            boolean r18 = r1.changed((float) r8)
            if (r18 == 0) goto L_0x00c1
            r18 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00c1:
            r18 = 65536(0x10000, float:9.18355E-41)
        L_0x00c3:
            r4 = r4 | r18
        L_0x00c5:
            r18 = r12 & 64
            if (r18 == 0) goto L_0x00d0
            r19 = 1572864(0x180000, float:2.204052E-39)
            r4 = r4 | r19
            r0 = r26
            goto L_0x00e5
        L_0x00d0:
            r19 = 3670016(0x380000, float:5.142788E-39)
            r19 = r11 & r19
            r0 = r26
            if (r19 != 0) goto L_0x00e5
            boolean r19 = r1.changed((float) r0)
            if (r19 == 0) goto L_0x00e1
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00e3
        L_0x00e1:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00e3:
            r4 = r4 | r19
        L_0x00e5:
            r0 = r12 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x00f0
            r19 = 12582912(0xc00000, float:1.7632415E-38)
            r4 = r4 | r19
            r3 = r27
            goto L_0x0105
        L_0x00f0:
            r19 = 29360128(0x1c00000, float:7.052966E-38)
            r19 = r11 & r19
            r3 = r27
            if (r19 != 0) goto L_0x0105
            boolean r19 = r1.changed((float) r3)
            if (r19 == 0) goto L_0x0101
            r19 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x0103
        L_0x0101:
            r19 = 4194304(0x400000, float:5.877472E-39)
        L_0x0103:
            r4 = r4 | r19
        L_0x0105:
            r3 = r12 & 256(0x100, float:3.59E-43)
            if (r3 == 0) goto L_0x010d
            r19 = 33554432(0x2000000, float:9.403955E-38)
            r4 = r4 | r19
        L_0x010d:
            r6 = r12 & 512(0x200, float:7.175E-43)
            if (r6 == 0) goto L_0x0115
            r6 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0113:
            r4 = r4 | r6
            goto L_0x0126
        L_0x0115:
            r6 = 1879048192(0x70000000, float:1.58456325E29)
            r6 = r6 & r11
            if (r6 != 0) goto L_0x0126
            boolean r6 = r1.changed((java.lang.Object) r10)
            if (r6 == 0) goto L_0x0123
            r6 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0113
        L_0x0123:
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0113
        L_0x0126:
            r6 = 256(0x100, float:3.59E-43)
            if (r3 != r6) goto L_0x014f
            r6 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r6 = r6 & r4
            r8 = 306783378(0x12492492, float:6.3469493E-28)
            if (r6 != r8) goto L_0x014f
            boolean r6 = r1.getSkipping()
            if (r6 != 0) goto L_0x013a
            goto L_0x014f
        L_0x013a:
            r1.skipToGroupEnd()
            r2 = r20
            r5 = r21
            r13 = r24
            r6 = r25
            r7 = r26
            r8 = r27
            r3 = r9
            r4 = r14
            r9 = r28
            goto L_0x0253
        L_0x014f:
            r1.startDefaults()
            r6 = r11 & 1
            r8 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            if (r6 == 0) goto L_0x0175
            boolean r6 = r1.getDefaultsInvalid()
            if (r6 == 0) goto L_0x0160
            goto L_0x0175
        L_0x0160:
            r1.skipToGroupEnd()
            if (r3 == 0) goto L_0x0166
            r4 = r4 & r8
        L_0x0166:
            r2 = r20
            r5 = r21
            r13 = r24
            r7 = r25
            r15 = r26
            r6 = r27
        L_0x0172:
            r0 = r28
            goto L_0x01a8
        L_0x0175:
            if (r2 == 0) goto L_0x017a
            java.lang.String r2 = ""
            goto L_0x017c
        L_0x017a:
            r2 = r20
        L_0x017c:
            r6 = 0
            if (r5 == 0) goto L_0x0181
            r5 = r6
            goto L_0x0183
        L_0x0181:
            r5 = r21
        L_0x0183:
            if (r7 == 0) goto L_0x0186
            r9 = r6
        L_0x0186:
            if (r13 == 0) goto L_0x0189
            r14 = r6
        L_0x0189:
            r7 = 1065353216(0x3f800000, float:1.0)
            if (r15 == 0) goto L_0x018f
            r13 = r7
            goto L_0x0191
        L_0x018f:
            r13 = r24
        L_0x0191:
            if (r17 == 0) goto L_0x0194
            goto L_0x0196
        L_0x0194:
            r7 = r25
        L_0x0196:
            if (r18 == 0) goto L_0x019a
            r15 = r6
            goto L_0x019c
        L_0x019a:
            r15 = r26
        L_0x019c:
            if (r0 == 0) goto L_0x019f
            goto L_0x01a1
        L_0x019f:
            r6 = r27
        L_0x01a1:
            if (r3 == 0) goto L_0x0172
            java.util.List r0 = androidx.compose.ui.graphics.vector.VectorKt.getEmptyPath()
            r4 = r4 & r8
        L_0x01a8:
            r1.endDefaults()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x01ba
            r3 = -1
            java.lang.String r8 = "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:28)"
            r11 = -213417674(0xfffffffff3478136, float:-1.5806393E31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r11, r4, r3, r8)
        L_0x01ba:
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1 r3 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1.INSTANCE
            r8 = -548224868(0xffffffffdf52c09c, float:-1.518631E19)
            r1.startReplaceableGroup(r8)
            androidx.compose.runtime.Applier r8 = r1.getApplier()
            boolean r8 = r8 instanceof androidx.compose.ui.graphics.vector.VectorApplier
            if (r8 != 0) goto L_0x01cd
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01cd:
            r1.startNode()
            boolean r8 = r1.getInserting()
            if (r8 == 0) goto L_0x01da
            r1.createNode(r3)
            goto L_0x01dd
        L_0x01da:
            r1.useNode()
        L_0x01dd:
            androidx.compose.runtime.Composer r3 = androidx.compose.runtime.Updater.m2536constructorimpl(r1)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1 r8 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1.INSTANCE
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r3, r2, r8)
            java.lang.Float r8 = java.lang.Float.valueOf(r5)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2 r11 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2.INSTANCE
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            java.lang.Float r8 = java.lang.Float.valueOf(r9)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3 r11 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3.INSTANCE
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            java.lang.Float r8 = java.lang.Float.valueOf(r14)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4 r11 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4.INSTANCE
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            java.lang.Float r8 = java.lang.Float.valueOf(r13)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5 r11 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5.INSTANCE
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            java.lang.Float r8 = java.lang.Float.valueOf(r7)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6 r11 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6.INSTANCE
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            java.lang.Float r8 = java.lang.Float.valueOf(r15)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7 r11 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7.INSTANCE
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            java.lang.Float r8 = java.lang.Float.valueOf(r6)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8 r11 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8.INSTANCE
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r3, r8, r11)
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9 r8 = androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9.INSTANCE
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r3, r0, r8)
            r3 = -983907633(0xffffffffc55ac2cf, float:-3500.1755)
            r1.startReplaceableGroup(r3)
            int r3 = r4 >> 27
            r3 = r3 & 14
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r10.invoke(r1, r3)
            r1.endReplaceableGroup()
            r1.endNode()
            r1.endReplaceableGroup()
            boolean r3 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r3 == 0) goto L_0x024d
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x024d:
            r8 = r6
            r6 = r7
            r3 = r9
            r4 = r14
            r7 = r15
            r9 = r0
        L_0x0253:
            androidx.compose.runtime.ScopeUpdateScope r14 = r1.endRestartGroup()
            if (r14 != 0) goto L_0x025a
            goto L_0x026c
        L_0x025a:
            androidx.compose.ui.graphics.vector.VectorComposeKt$Group$4 r15 = new androidx.compose.ui.graphics.vector.VectorComposeKt$Group$4
            r0 = r15
            r1 = r2
            r2 = r5
            r5 = r13
            r10 = r29
            r11 = r31
            r12 = r32
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r14.updateScope(r15)
        L_0x026c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorComposeKt.Group(java.lang.String, float, float, float, float, float, float, float, java.util.List, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    @VectorComposable
    @Composable
    /* renamed from: Path-9cdaXJ4  reason: not valid java name */
    public static final void m3544Path9cdaXJ4(@NotNull List<? extends PathNode> list, int i11, @Nullable String str, @Nullable Brush brush, float f11, @Nullable Brush brush2, float f12, float f13, int i12, int i13, float f14, float f15, float f16, float f17, @Nullable Composer composer, int i14, int i15, int i16) {
        List<? extends PathNode> list2 = list;
        int i17 = i16;
        Intrinsics.checkNotNullParameter(list2, "pathData");
        Composer startRestartGroup = composer.startRestartGroup(-1478270750);
        int defaultFillType = (i17 & 2) != 0 ? VectorKt.getDefaultFillType() : i11;
        String str2 = (i17 & 4) != 0 ? "" : str;
        Brush brush3 = null;
        Brush brush4 = (i17 & 8) != 0 ? null : brush;
        float f18 = (i17 & 16) != 0 ? 1.0f : f11;
        if ((i17 & 32) == 0) {
            brush3 = brush2;
        }
        float f19 = (i17 & 64) != 0 ? 1.0f : f12;
        float f21 = (i17 & 128) != 0 ? 0.0f : f13;
        int defaultStrokeLineCap = (i17 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i12;
        int defaultStrokeLineJoin = (i17 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i13;
        float f22 = (i17 & 1024) != 0 ? 4.0f : f14;
        float f23 = (i17 & 2048) != 0 ? 0.0f : f15;
        float f24 = (i17 & 4096) != 0 ? 1.0f : f16;
        float f25 = (i17 & 8192) != 0 ? 0.0f : f17;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1478270750, i14, i15, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:60)");
        } else {
            int i18 = i14;
            int i19 = i15;
        }
        VectorComposeKt$Path$1 vectorComposeKt$Path$1 = VectorComposeKt$Path$1.INSTANCE;
        startRestartGroup.startReplaceableGroup(1886828752);
        if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(new VectorComposeKt$Path9cdaXJ4$$inlined$ComposeNode$1(vectorComposeKt$Path$1));
        } else {
            startRestartGroup.useNode();
        }
        Composer r02 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r02, str2, VectorComposeKt$Path$2$1.INSTANCE);
        Updater.m2543setimpl(r02, list2, VectorComposeKt$Path$2$2.INSTANCE);
        Updater.m2543setimpl(r02, PathFillType.m3158boximpl(defaultFillType), VectorComposeKt$Path$2$3.INSTANCE);
        Updater.m2543setimpl(r02, brush4, VectorComposeKt$Path$2$4.INSTANCE);
        Updater.m2543setimpl(r02, Float.valueOf(f18), VectorComposeKt$Path$2$5.INSTANCE);
        Updater.m2543setimpl(r02, brush3, VectorComposeKt$Path$2$6.INSTANCE);
        Updater.m2543setimpl(r02, Float.valueOf(f19), VectorComposeKt$Path$2$7.INSTANCE);
        Updater.m2543setimpl(r02, Float.valueOf(f21), VectorComposeKt$Path$2$8.INSTANCE);
        Updater.m2543setimpl(r02, StrokeJoin.m3256boximpl(defaultStrokeLineJoin), VectorComposeKt$Path$2$9.INSTANCE);
        Updater.m2543setimpl(r02, StrokeCap.m3246boximpl(defaultStrokeLineCap), VectorComposeKt$Path$2$10.INSTANCE);
        Updater.m2543setimpl(r02, Float.valueOf(f22), VectorComposeKt$Path$2$11.INSTANCE);
        Updater.m2543setimpl(r02, Float.valueOf(f23), VectorComposeKt$Path$2$12.INSTANCE);
        Updater.m2543setimpl(r02, Float.valueOf(f24), VectorComposeKt$Path$2$13.INSTANCE);
        Updater.m2543setimpl(r02, Float.valueOf(f25), VectorComposeKt$Path$2$14.INSTANCE);
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            VectorComposeKt$Path$3 vectorComposeKt$Path$3 = r0;
            VectorComposeKt$Path$3 vectorComposeKt$Path$32 = new VectorComposeKt$Path$3(list, defaultFillType, str2, brush4, f18, brush3, f19, f21, defaultStrokeLineCap, defaultStrokeLineJoin, f22, f23, f24, f25, i14, i15, i16);
            endRestartGroup.updateScope(vectorComposeKt$Path$3);
        }
    }
}
