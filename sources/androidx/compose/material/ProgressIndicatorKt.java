package androidx.compose.material;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import f0.b;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a3\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&\u001a;\u0010\u001e\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010)\u001a3\u0010*\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010+\u001a\u00020#H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-\u001a;\u0010*\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010+\u001a\u00020#H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/\u001a9\u00100\u001a\u00020\u001f*\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107\u001a9\u00108\u001a\u00020\u001f*\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u00107\u001aA\u0010:\u001a\u00020\u001f*\u0002012\u0006\u00102\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u00104\u001a\u000205H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b;\u0010<\u001a9\u0010=\u001a\u00020\u001f*\u0002012\u0006\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0001H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010A\u001a)\u0010B\u001a\u00020\u001f*\u0002012\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0001H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010D\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u0013\u0010\u0012\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u0013\u0010\u0013\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0014\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0018\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\bXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "LinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "StartAngleOffset", "CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "progress", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "backgroundColor", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJF)V", "drawLinearIndicatorBackground", "drawLinearIndicatorBackground-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JF)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    /* access modifiers changed from: private */
    @NotNull
    public static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    private static final float CircularIndicatorDiameter = Dp.m5478constructorimpl((float) 40);
    private static final int FirstLineHeadDelay = 0;
    private static final int FirstLineHeadDuration = 750;
    /* access modifiers changed from: private */
    @NotNull
    public static final CubicBezierEasing FirstLineHeadEasing = new CubicBezierEasing(0.2f, 0.0f, 0.8f, 1.0f);
    private static final int FirstLineTailDelay = 333;
    private static final int FirstLineTailDuration = 850;
    /* access modifiers changed from: private */
    @NotNull
    public static final CubicBezierEasing FirstLineTailEasing = new CubicBezierEasing(0.4f, 0.0f, 1.0f, 1.0f);
    private static final int HeadAndTailAnimationDuration = 666;
    private static final int HeadAndTailDelayDuration = 666;
    private static final float JumpRotationAngle = 290.0f;
    private static final int LinearAnimationDuration = 1800;
    private static final float LinearIndicatorHeight = ProgressIndicatorDefaults.INSTANCE.m1322getStrokeWidthD9Ej5fM();
    private static final float LinearIndicatorWidth = Dp.m5478constructorimpl((float) PsExtractor.VIDEO_STREAM_MASK);
    private static final float RotationAngleOffset = 216.0f;
    private static final int RotationDuration = 1332;
    private static final int RotationsPerCycle = 5;
    private static final int SecondLineHeadDelay = 1000;
    private static final int SecondLineHeadDuration = 567;
    /* access modifiers changed from: private */
    @NotNull
    public static final CubicBezierEasing SecondLineHeadEasing = new CubicBezierEasing(0.0f, 0.0f, 0.65f, 1.0f);
    private static final int SecondLineTailDelay = 1267;
    private static final int SecondLineTailDuration = 533;
    /* access modifiers changed from: private */
    @NotNull
    public static final CubicBezierEasing SecondLineTailEasing = new CubicBezierEasing(0.1f, 0.0f, 0.45f, 1.0f);
    private static final float StartAngleOffset = -90.0f;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: CircularProgressIndicator-MBs18nI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1323CircularProgressIndicatorMBs18nI(float r21, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r22, long r23, float r25, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r6 = r21
            r7 = r27
            r0 = -409649739(0xffffffffe7953db5, float:-1.4095418E24)
            r1 = r26
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            r0 = r28 & 1
            if (r0 == 0) goto L_0x0014
            r0 = r7 | 6
            goto L_0x0024
        L_0x0014:
            r0 = r7 & 14
            if (r0 != 0) goto L_0x0023
            boolean r0 = r8.changed((float) r6)
            if (r0 == 0) goto L_0x0020
            r0 = 4
            goto L_0x0021
        L_0x0020:
            r0 = 2
        L_0x0021:
            r0 = r0 | r7
            goto L_0x0024
        L_0x0023:
            r0 = r7
        L_0x0024:
            r1 = r28 & 2
            if (r1 == 0) goto L_0x002b
            r0 = r0 | 48
            goto L_0x003e
        L_0x002b:
            r2 = r7 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x003e
            r2 = r22
            boolean r3 = r8.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x003a
            r3 = 32
            goto L_0x003c
        L_0x003a:
            r3 = 16
        L_0x003c:
            r0 = r0 | r3
            goto L_0x0040
        L_0x003e:
            r2 = r22
        L_0x0040:
            r3 = r7 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0059
            r3 = r28 & 4
            if (r3 != 0) goto L_0x0053
            r3 = r23
            boolean r5 = r8.changed((long) r3)
            if (r5 == 0) goto L_0x0055
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0057
        L_0x0053:
            r3 = r23
        L_0x0055:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0057:
            r0 = r0 | r5
            goto L_0x005b
        L_0x0059:
            r3 = r23
        L_0x005b:
            r5 = r28 & 8
            if (r5 == 0) goto L_0x0062
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0075
        L_0x0062:
            r9 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0075
            r9 = r25
            boolean r10 = r8.changed((float) r9)
            if (r10 == 0) goto L_0x0071
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x0071:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0073:
            r0 = r0 | r10
            goto L_0x0077
        L_0x0075:
            r9 = r25
        L_0x0077:
            r0 = r0 & 5851(0x16db, float:8.199E-42)
            r10 = 1170(0x492, float:1.64E-42)
            if (r0 != r10) goto L_0x008a
            boolean r0 = r8.getSkipping()
            if (r0 != 0) goto L_0x0084
            goto L_0x008a
        L_0x0084:
            r8.skipToGroupEnd()
            r5 = r9
            goto L_0x010a
        L_0x008a:
            r8.startDefaults()
            r0 = r7 & 1
            if (r0 == 0) goto L_0x009f
            boolean r0 = r8.getDefaultsInvalid()
            if (r0 == 0) goto L_0x0098
            goto L_0x009f
        L_0x0098:
            r8.skipToGroupEnd()
            r10 = r3
            r12 = r9
            r9 = r2
            goto L_0x00c5
        L_0x009f:
            if (r1 == 0) goto L_0x00a4
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x00a5
        L_0x00a4:
            r0 = r2
        L_0x00a5:
            r1 = r28 & 4
            if (r1 == 0) goto L_0x00b5
            androidx.compose.material.MaterialTheme r1 = androidx.compose.material.MaterialTheme.INSTANCE
            r2 = 6
            androidx.compose.material.Colors r1 = r1.getColors(r8, r2)
            long r1 = r1.m1179getPrimary0d7_KjU()
            goto L_0x00b6
        L_0x00b5:
            r1 = r3
        L_0x00b6:
            if (r5 == 0) goto L_0x00c2
            androidx.compose.material.ProgressIndicatorDefaults r3 = androidx.compose.material.ProgressIndicatorDefaults.INSTANCE
            float r3 = r3.m1322getStrokeWidthD9Ej5fM()
            r9 = r0
            r10 = r1
            r12 = r3
            goto L_0x00c5
        L_0x00c2:
            r10 = r1
            r12 = r9
            r9 = r0
        L_0x00c5:
            r8.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r0 = r8.consume(r0)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.ui.graphics.drawscope.Stroke r5 = new androidx.compose.ui.graphics.drawscope.Stroke
            float r14 = r0.m5447toPx0680j_4(r12)
            r15 = 0
            androidx.compose.ui.graphics.StrokeCap$Companion r0 = androidx.compose.ui.graphics.StrokeCap.Companion
            int r16 = r0.m3253getButtKaPHkGw()
            r17 = 0
            r18 = 0
            r19 = 26
            r20 = 0
            r13 = r5
            r13.<init>(r14, r15, r16, r17, r18, r19, r20)
            r2 = 0
            r3 = 0
            r4 = 6
            r13 = 0
            r0 = r9
            r1 = r21
            r14 = r5
            r5 = r13
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics$default(r0, r1, r2, r3, r4, r5)
            float r1 = CircularIndicatorDiameter
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m558size3ABfNKs(r0, r1)
            androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1 r1 = new androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$1
            r1.<init>(r6, r10, r14)
            r2 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r0, r1, r8, r2)
            r2 = r9
            r3 = r10
            r5 = r12
        L_0x010a:
            androidx.compose.runtime.ScopeUpdateScope r8 = r8.endRestartGroup()
            if (r8 != 0) goto L_0x0111
            goto L_0x0120
        L_0x0111:
            androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2 r9 = new androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$2
            r0 = r9
            r1 = r21
            r6 = r27
            r7 = r28
            r0.<init>(r1, r2, r3, r5, r6, r7)
            r8.updateScope(r9)
        L_0x0120:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.m1323CircularProgressIndicatorMBs18nI(float, androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x019f  */
    /* JADX WARNING: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: CircularProgressIndicator-aM-cp0Q  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1324CircularProgressIndicatoraMcp0Q(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r30, long r31, float r33, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r5 = r35
            r0 = -392089979(0xffffffffe8a12e85, float:-6.089273E24)
            r1 = r34
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r36 & 1
            r2 = 2
            if (r1 == 0) goto L_0x0016
            r3 = r5 | 6
            r4 = r3
            r3 = r30
            goto L_0x002a
        L_0x0016:
            r3 = r5 & 14
            if (r3 != 0) goto L_0x0027
            r3 = r30
            boolean r4 = r0.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x0024
            r4 = 4
            goto L_0x0025
        L_0x0024:
            r4 = r2
        L_0x0025:
            r4 = r4 | r5
            goto L_0x002a
        L_0x0027:
            r3 = r30
            r4 = r5
        L_0x002a:
            r6 = r5 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0043
            r6 = r36 & 2
            if (r6 != 0) goto L_0x003d
            r6 = r31
            boolean r8 = r0.changed((long) r6)
            if (r8 == 0) goto L_0x003f
            r8 = 32
            goto L_0x0041
        L_0x003d:
            r6 = r31
        L_0x003f:
            r8 = 16
        L_0x0041:
            r4 = r4 | r8
            goto L_0x0045
        L_0x0043:
            r6 = r31
        L_0x0045:
            r8 = r36 & 4
            if (r8 == 0) goto L_0x004c
            r4 = r4 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r9 = r5 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x005f
            r9 = r33
            boolean r10 = r0.changed((float) r9)
            if (r10 == 0) goto L_0x005b
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r10 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r4 = r4 | r10
            goto L_0x0061
        L_0x005f:
            r9 = r33
        L_0x0061:
            r4 = r4 & 731(0x2db, float:1.024E-42)
            r10 = 146(0x92, float:2.05E-43)
            if (r4 != r10) goto L_0x0076
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x006e
            goto L_0x0076
        L_0x006e:
            r0.skipToGroupEnd()
            r1 = r3
            r2 = r6
            r4 = r9
            goto L_0x0198
        L_0x0076:
            r0.startDefaults()
            r4 = r5 & 1
            if (r4 == 0) goto L_0x008b
            boolean r4 = r0.getDefaultsInvalid()
            if (r4 == 0) goto L_0x0084
            goto L_0x008b
        L_0x0084:
            r0.skipToGroupEnd()
            r1 = r3
            r3 = r6
        L_0x0089:
            r15 = r9
            goto L_0x00ab
        L_0x008b:
            if (r1 == 0) goto L_0x0090
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x0091
        L_0x0090:
            r1 = r3
        L_0x0091:
            r3 = r36 & 2
            if (r3 == 0) goto L_0x00a1
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r4 = 6
            androidx.compose.material.Colors r3 = r3.getColors(r0, r4)
            long r3 = r3.m1179getPrimary0d7_KjU()
            goto L_0x00a2
        L_0x00a1:
            r3 = r6
        L_0x00a2:
            if (r8 == 0) goto L_0x0089
            androidx.compose.material.ProgressIndicatorDefaults r6 = androidx.compose.material.ProgressIndicatorDefaults.INSTANCE
            float r6 = r6.m1322getStrokeWidthD9Ej5fM()
            r15 = r6
        L_0x00ab:
            r0.endDefaults()
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r6 = r0.consume(r6)
            androidx.compose.ui.unit.Density r6 = (androidx.compose.ui.unit.Density) r6
            androidx.compose.ui.graphics.drawscope.Stroke r16 = new androidx.compose.ui.graphics.drawscope.Stroke
            float r8 = r6.m5447toPx0680j_4(r15)
            r9 = 0
            androidx.compose.ui.graphics.StrokeCap$Companion r6 = androidx.compose.ui.graphics.StrokeCap.Companion
            int r10 = r6.m3255getSquareKaPHkGw()
            r11 = 0
            r12 = 0
            r13 = 26
            r14 = 0
            r7 = r16
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            r14 = 0
            androidx.compose.animation.core.InfiniteTransition r13 = androidx.compose.animation.core.InfiniteTransitionKt.rememberInfiniteTransition(r0, r14)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r14)
            r6 = 5
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            kotlin.jvm.internal.IntCompanionObject r6 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r9 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.IntCompanionObject) r6)
            r6 = 6660(0x1a04, float:9.333E-42)
            androidx.compose.animation.core.Easing r10 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r17 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r6, r14, r10, r2, r12)
            r18 = 0
            r19 = 0
            r21 = 6
            r22 = 0
            androidx.compose.animation.core.InfiniteRepeatableSpec r10 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r17, r18, r19, r21, r22)
            int r11 = androidx.compose.animation.core.InfiniteTransition.$stable
            r6 = r11 | 4528(0x11b0, float:6.345E-42)
            int r17 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r18 = r17 << 12
            r18 = r6 | r18
            r6 = r13
            r23 = r11
            r11 = r0
            r5 = r12
            r12 = r18
            androidx.compose.runtime.State r12 = androidx.compose.animation.core.InfiniteTransitionKt.animateValue(r6, r7, r8, r9, r10, r11, r12)
            r7 = 0
            r8 = 1133445120(0x438f0000, float:286.0)
            r6 = 1332(0x534, float:1.867E-42)
            androidx.compose.animation.core.Easing r9 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r24 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r6, r14, r9, r2, r5)
            r25 = 0
            r26 = 0
            r28 = 6
            r29 = 0
            androidx.compose.animation.core.InfiniteRepeatableSpec r9 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r24, r25, r26, r28, r29)
            r2 = r23
            r5 = r2 | 432(0x1b0, float:6.05E-43)
            int r6 = r17 << 9
            r11 = r5 | r6
            r6 = r13
            r10 = r0
            androidx.compose.runtime.State r5 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r6, r7, r8, r9, r10, r11)
            r8 = 1133576192(0x43910000, float:290.0)
            androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2 r6 = androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$endAngle$2.INSTANCE
            androidx.compose.animation.core.KeyframesSpec r18 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r6)
            r19 = 0
            r20 = 0
            r22 = 6
            r23 = 0
            androidx.compose.animation.core.InfiniteRepeatableSpec r9 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r18, r19, r20, r22, r23)
            r6 = r2 | 432(0x1b0, float:6.05E-43)
            int r10 = r17 << 9
            r11 = r6 | r10
            r6 = r13
            r10 = r0
            androidx.compose.runtime.State r18 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r6, r7, r8, r9, r10, r11)
            androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startAngle$2 r6 = androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$startAngle$2.INSTANCE
            androidx.compose.animation.core.KeyframesSpec r19 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r6)
            r20 = 0
            r21 = 0
            r23 = 6
            r24 = 0
            androidx.compose.animation.core.InfiniteRepeatableSpec r9 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r19, r20, r21, r23, r24)
            r2 = r2 | 432(0x1b0, float:6.05E-43)
            int r6 = r17 << 9
            r11 = r2 | r6
            r6 = r13
            androidx.compose.runtime.State r13 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r6, r7, r8, r9, r10, r11)
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics(r1)
            float r6 = CircularIndicatorDiameter
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m558size3ABfNKs(r2, r6)
            androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3 r11 = new androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$3
            r6 = r11
            r7 = r15
            r8 = r3
            r10 = r16
            r30 = r1
            r1 = r11
            r11 = r12
            r12 = r18
            r31 = r3
            r3 = r14
            r14 = r5
            r6.<init>(r7, r8, r10, r11, r12, r13, r14)
            androidx.compose.foundation.CanvasKt.Canvas(r2, r1, r0, r3)
            r1 = r30
            r2 = r31
            r4 = r15
        L_0x0198:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x019f
            goto L_0x01ac
        L_0x019f:
            androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$4 r8 = new androidx.compose.material.ProgressIndicatorKt$CircularProgressIndicator$4
            r0 = r8
            r5 = r35
            r6 = r36
            r0.<init>(r1, r2, r4, r5, r6)
            r7.updateScope(r8)
        L_0x01ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.m1324CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-10  reason: not valid java name */
    public static final float m1325CircularProgressIndicator_aM_cp0Q$lambda10(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-11  reason: not valid java name */
    public static final float m1326CircularProgressIndicator_aM_cp0Q$lambda11(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-8  reason: not valid java name */
    public static final int m1327CircularProgressIndicator_aM_cp0Q$lambda8(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: CircularProgressIndicator_aM_cp0Q$lambda-9  reason: not valid java name */
    public static final float m1328CircularProgressIndicator_aM_cp0Q$lambda9(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$3$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v15, resolved type: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$3$1} */
    /* JADX WARNING: type inference failed for: r8v4 */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01d4, code lost:
        if (r8 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x01d6;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: LinearProgressIndicator-RIQooxk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1329LinearProgressIndicatorRIQooxk(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r25, long r26, long r28, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r6 = r31
            r0 = -819397058(0xffffffffcf28fe3e, float:-2.8352343E9)
            r1 = r30
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r32 & 1
            if (r1 == 0) goto L_0x0015
            r4 = r6 | 6
            r5 = r4
            r4 = r25
            goto L_0x0029
        L_0x0015:
            r4 = r6 & 14
            if (r4 != 0) goto L_0x0026
            r4 = r25
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0023
            r5 = 4
            goto L_0x0024
        L_0x0023:
            r5 = 2
        L_0x0024:
            r5 = r5 | r6
            goto L_0x0029
        L_0x0026:
            r4 = r25
            r5 = r6
        L_0x0029:
            r7 = r6 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0042
            r7 = r32 & 2
            if (r7 != 0) goto L_0x003c
            r7 = r26
            boolean r9 = r0.changed((long) r7)
            if (r9 == 0) goto L_0x003e
            r9 = 32
            goto L_0x0040
        L_0x003c:
            r7 = r26
        L_0x003e:
            r9 = 16
        L_0x0040:
            r5 = r5 | r9
            goto L_0x0044
        L_0x0042:
            r7 = r26
        L_0x0044:
            r9 = r6 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x005d
            r9 = r32 & 4
            if (r9 != 0) goto L_0x0057
            r9 = r28
            boolean r11 = r0.changed((long) r9)
            if (r11 == 0) goto L_0x0059
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0057:
            r9 = r28
        L_0x0059:
            r11 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r5 = r5 | r11
            goto L_0x005f
        L_0x005d:
            r9 = r28
        L_0x005f:
            r5 = r5 & 731(0x2db, float:1.024E-42)
            r11 = 146(0x92, float:2.05E-43)
            if (r5 != r11) goto L_0x0074
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L_0x006c
            goto L_0x0074
        L_0x006c:
            r0.skipToGroupEnd()
            r1 = r4
            r2 = r7
        L_0x0071:
            r4 = r9
            goto L_0x01f1
        L_0x0074:
            r0.startDefaults()
            r5 = r6 & 1
            r11 = 6
            if (r5 == 0) goto L_0x0089
            boolean r5 = r0.getDefaultsInvalid()
            if (r5 == 0) goto L_0x0083
            goto L_0x0089
        L_0x0083:
            r0.skipToGroupEnd()
            r1 = r4
            r4 = r7
            goto L_0x00b5
        L_0x0089:
            if (r1 == 0) goto L_0x008e
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x008f
        L_0x008e:
            r1 = r4
        L_0x008f:
            r4 = r32 & 2
            if (r4 == 0) goto L_0x009e
            androidx.compose.material.MaterialTheme r4 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r4 = r4.getColors(r0, r11)
            long r4 = r4.m1179getPrimary0d7_KjU()
            goto L_0x009f
        L_0x009e:
            r4 = r7
        L_0x009f:
            r7 = r32 & 4
            if (r7 == 0) goto L_0x00b5
            r14 = 1047904911(0x3e75c28f, float:0.24)
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 14
            r19 = 0
            r12 = r4
            long r7 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r12, r14, r15, r16, r17, r18, r19)
            r9 = r7
        L_0x00b5:
            r0.endDefaults()
            r7 = 0
            androidx.compose.animation.core.InfiniteTransition r8 = androidx.compose.animation.core.InfiniteTransitionKt.rememberInfiniteTransition(r0, r7)
            r12 = 0
            r13 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2 r14 = androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$2.INSTANCE
            androidx.compose.animation.core.KeyframesSpec r14 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r14)
            r15 = 0
            r16 = 0
            r18 = 6
            r19 = 0
            r25 = r14
            r26 = r15
            r27 = r16
            r29 = r18
            r30 = r19
            androidx.compose.animation.core.InfiniteRepeatableSpec r14 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r25, r26, r27, r29, r30)
            int r15 = androidx.compose.animation.core.InfiniteTransition.$stable
            r2 = r15 | 432(0x1b0, float:6.05E-43)
            int r17 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r18 = r17 << 9
            r2 = r2 | r18
            r25 = r8
            r26 = r12
            r27 = r13
            r28 = r14
            r29 = r0
            r30 = r2
            androidx.compose.runtime.State r2 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r25, r26, r27, r28, r29, r30)
            androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2 r14 = androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$2.INSTANCE
            androidx.compose.animation.core.KeyframesSpec r14 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r14)
            r18 = 0
            r19 = 0
            r21 = 6
            r22 = 0
            r25 = r14
            r26 = r18
            r27 = r19
            r29 = r21
            r30 = r22
            androidx.compose.animation.core.InfiniteRepeatableSpec r14 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r25, r26, r27, r29, r30)
            r3 = r15 | 432(0x1b0, float:6.05E-43)
            int r19 = r17 << 9
            r3 = r3 | r19
            r25 = r8
            r26 = r12
            r27 = r13
            r28 = r14
            r29 = r0
            r30 = r3
            androidx.compose.runtime.State r3 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r25, r26, r27, r28, r29, r30)
            androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2 r14 = androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$2.INSTANCE
            androidx.compose.animation.core.KeyframesSpec r14 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r14)
            r19 = 0
            r20 = 0
            r22 = 6
            r23 = 0
            r25 = r14
            r26 = r19
            r27 = r20
            r29 = r22
            r30 = r23
            androidx.compose.animation.core.InfiniteRepeatableSpec r14 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r25, r26, r27, r29, r30)
            r7 = r15 | 432(0x1b0, float:6.05E-43)
            int r19 = r17 << 9
            r7 = r7 | r19
            r25 = r8
            r26 = r12
            r27 = r13
            r28 = r14
            r29 = r0
            r30 = r7
            androidx.compose.runtime.State r19 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r25, r26, r27, r28, r29, r30)
            r7 = 0
            r12 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$2 r13 = androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$2.INSTANCE
            androidx.compose.animation.core.KeyframesSpec r13 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r13)
            r14 = 0
            r22 = 0
            r20 = 6
            r24 = 0
            r25 = r13
            r26 = r14
            r27 = r22
            r29 = r20
            r30 = r24
            androidx.compose.animation.core.InfiniteRepeatableSpec r13 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r25, r26, r27, r29, r30)
            r14 = r15 | 432(0x1b0, float:6.05E-43)
            int r15 = r17 << 9
            r14 = r14 | r15
            r25 = r8
            r26 = r7
            r27 = r12
            r28 = r13
            r29 = r0
            r30 = r14
            androidx.compose.runtime.State r20 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r25, r26, r27, r28, r29, r30)
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics(r1)
            float r8 = LinearIndicatorWidth
            float r12 = LinearIndicatorHeight
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m560sizeVpY3zN4(r7, r8, r12)
            java.lang.Object[] r8 = new java.lang.Object[r11]
            androidx.compose.ui.graphics.Color r12 = androidx.compose.ui.graphics.Color.m2909boximpl(r9)
            r13 = 0
            r8[r13] = r12
            r12 = 1
            r8[r12] = r2
            r12 = 2
            r8[r12] = r3
            r12 = 3
            androidx.compose.ui.graphics.Color r13 = androidx.compose.ui.graphics.Color.m2909boximpl(r4)
            r8[r12] = r13
            r12 = 4
            r8[r12] = r19
            r12 = 5
            r8[r12] = r20
            r12 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r0.startReplaceableGroup(r12)
            r12 = 0
            r13 = 0
        L_0x01bc:
            if (r13 >= r11) goto L_0x01c8
            r14 = r8[r13]
            boolean r14 = r0.changed((java.lang.Object) r14)
            r12 = r12 | r14
            int r13 = r13 + 1
            goto L_0x01bc
        L_0x01c8:
            java.lang.Object r8 = r0.rememberedValue()
            if (r12 != 0) goto L_0x01d6
            androidx.compose.runtime.Composer$Companion r11 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r11 = r11.getEmpty()
            if (r8 != r11) goto L_0x01e5
        L_0x01d6:
            androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$3$1 r8 = new androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$3$1
            r12 = r8
            r13 = r9
            r15 = r4
            r17 = r2
            r18 = r3
            r12.<init>(r13, r15, r17, r18, r19, r20)
            r0.updateRememberedValue(r8)
        L_0x01e5:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            r2 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r7, r8, r0, r2)
            r2 = r4
            goto L_0x0071
        L_0x01f1:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x01f8
            goto L_0x0205
        L_0x01f8:
            androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$4 r9 = new androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$4
            r0 = r9
            r6 = r31
            r7 = r32
            r0.<init>(r1, r2, r4, r6, r7)
            r8.updateScope(r9)
        L_0x0205:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.m1329LinearProgressIndicatorRIQooxk(androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v16, resolved type: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v3, resolved type: androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1} */
    /* JADX WARNING: type inference failed for: r10v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0119, code lost:
        if (r10 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x011b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: LinearProgressIndicator-eaDK9VM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1330LinearProgressIndicatoreaDK9VM(float r16, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r17, long r18, long r20, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r7 = r23
            r0 = -850309746(0xffffffffcd514d8e, float:-2.19470048E8)
            r1 = r22
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r24 & 1
            if (r1 == 0) goto L_0x0015
            r1 = r7 | 6
            r2 = r1
            r1 = r16
            goto L_0x0029
        L_0x0015:
            r1 = r7 & 14
            if (r1 != 0) goto L_0x0026
            r1 = r16
            boolean r2 = r0.changed((float) r1)
            if (r2 == 0) goto L_0x0023
            r2 = 4
            goto L_0x0024
        L_0x0023:
            r2 = 2
        L_0x0024:
            r2 = r2 | r7
            goto L_0x0029
        L_0x0026:
            r1 = r16
            r2 = r7
        L_0x0029:
            r3 = r24 & 2
            if (r3 == 0) goto L_0x0030
            r2 = r2 | 48
            goto L_0x0043
        L_0x0030:
            r4 = r7 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0043
            r4 = r17
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
            r4 = r17
        L_0x0045:
            r5 = r7 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x005e
            r5 = r24 & 4
            if (r5 != 0) goto L_0x0058
            r5 = r18
            boolean r8 = r0.changed((long) r5)
            if (r8 == 0) goto L_0x005a
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x0058:
            r5 = r18
        L_0x005a:
            r8 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r2 = r2 | r8
            goto L_0x0060
        L_0x005e:
            r5 = r18
        L_0x0060:
            r8 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0079
            r8 = r24 & 8
            if (r8 != 0) goto L_0x0073
            r8 = r20
            boolean r10 = r0.changed((long) r8)
            if (r10 == 0) goto L_0x0075
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0077
        L_0x0073:
            r8 = r20
        L_0x0075:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0077:
            r2 = r2 | r10
            goto L_0x007b
        L_0x0079:
            r8 = r20
        L_0x007b:
            r2 = r2 & 5851(0x16db, float:8.199E-42)
            r10 = 1170(0x492, float:1.64E-42)
            if (r2 != r10) goto L_0x0090
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x0088
            goto L_0x0090
        L_0x0088:
            r0.skipToGroupEnd()
            r2 = r4
            r3 = r5
        L_0x008d:
            r5 = r8
            goto L_0x0136
        L_0x0090:
            r0.startDefaults()
            r2 = r7 & 1
            if (r2 == 0) goto L_0x00a4
            boolean r2 = r0.getDefaultsInvalid()
            if (r2 == 0) goto L_0x009e
            goto L_0x00a4
        L_0x009e:
            r0.skipToGroupEnd()
            r2 = r4
            r3 = r5
            goto L_0x00ce
        L_0x00a4:
            if (r3 == 0) goto L_0x00a9
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x00aa
        L_0x00a9:
            r2 = r4
        L_0x00aa:
            r3 = r24 & 4
            if (r3 == 0) goto L_0x00ba
            androidx.compose.material.MaterialTheme r3 = androidx.compose.material.MaterialTheme.INSTANCE
            r4 = 6
            androidx.compose.material.Colors r3 = r3.getColors(r0, r4)
            long r3 = r3.m1179getPrimary0d7_KjU()
            goto L_0x00bb
        L_0x00ba:
            r3 = r5
        L_0x00bb:
            r5 = r24 & 8
            if (r5 == 0) goto L_0x00ce
            r10 = 1047904911(0x3e75c28f, float:0.24)
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 14
            r15 = 0
            r8 = r3
            long r5 = androidx.compose.ui.graphics.Color.m2918copywmQWz5c$default(r8, r10, r11, r12, r13, r14, r15)
            r8 = r5
        L_0x00ce:
            r0.endDefaults()
            r5 = 0
            r6 = 0
            r10 = 6
            r11 = 0
            r17 = r2
            r18 = r16
            r19 = r5
            r20 = r6
            r21 = r10
            r22 = r11
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics$default(r17, r18, r19, r20, r21, r22)
            float r6 = LinearIndicatorWidth
            float r10 = LinearIndicatorHeight
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m560sizeVpY3zN4(r5, r6, r10)
            androidx.compose.ui.graphics.Color r6 = androidx.compose.ui.graphics.Color.m2909boximpl(r8)
            java.lang.Float r10 = java.lang.Float.valueOf(r16)
            androidx.compose.ui.graphics.Color r11 = androidx.compose.ui.graphics.Color.m2909boximpl(r3)
            r12 = 1618982084(0x607fb4c4, float:7.370227E19)
            r0.startReplaceableGroup(r12)
            boolean r6 = r0.changed((java.lang.Object) r6)
            boolean r10 = r0.changed((java.lang.Object) r10)
            r6 = r6 | r10
            boolean r10 = r0.changed((java.lang.Object) r11)
            r6 = r6 | r10
            java.lang.Object r10 = r0.rememberedValue()
            if (r6 != 0) goto L_0x011b
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r6 = r6.getEmpty()
            if (r10 != r6) goto L_0x012b
        L_0x011b:
            androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1 r10 = new androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$1$1
            r17 = r10
            r18 = r8
            r20 = r16
            r21 = r3
            r17.<init>(r18, r20, r21)
            r0.updateRememberedValue(r10)
        L_0x012b:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r6 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r5, r10, r0, r6)
            goto L_0x008d
        L_0x0136:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x013d
            goto L_0x014c
        L_0x013d:
            androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$2 r10 = new androidx.compose.material.ProgressIndicatorKt$LinearProgressIndicator$2
            r0 = r10
            r1 = r16
            r7 = r23
            r8 = r24
            r0.<init>(r1, r2, r3, r5, r7, r8)
            r9.updateScope(r10)
        L_0x014c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ProgressIndicatorKt.m1330LinearProgressIndicatoreaDK9VM(float, androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-1  reason: not valid java name */
    public static final float m1331LinearProgressIndicator_RIQooxk$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-2  reason: not valid java name */
    public static final float m1332LinearProgressIndicator_RIQooxk$lambda2(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-3  reason: not valid java name */
    public static final float m1333LinearProgressIndicator_RIQooxk$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: LinearProgressIndicator_RIQooxk$lambda-4  reason: not valid java name */
    public static final float m1334LinearProgressIndicator_RIQooxk$lambda4(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* renamed from: drawCircularIndicator-42QJj7c  reason: not valid java name */
    private static final void m1347drawCircularIndicator42QJj7c(DrawScope drawScope, float f11, float f12, long j11, Stroke stroke) {
        float f13 = (float) 2;
        float width = stroke.getWidth() / f13;
        float r22 = Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()) - (f13 * width);
        b.v(drawScope, j11, f11, f12, false, OffsetKt.Offset(width, width), SizeKt.Size(r22, r22), 0.0f, stroke, (ColorFilter) null, 0, 832, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c  reason: not valid java name */
    public static final void m1348drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f11, float f12, long j11, Stroke stroke) {
        m1347drawCircularIndicator42QJj7c(drawScope, f11, f12, j11, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI  reason: not valid java name */
    public static final void m1349drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f11, float f12, float f13, long j11, Stroke stroke) {
        m1347drawCircularIndicator42QJj7c(drawScope, f11 + (((f12 / Dp.m5478constructorimpl(CircularIndicatorDiameter / ((float) 2))) * 57.29578f) / 2.0f), Math.max(f13, 0.1f), j11, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-42QJj7c  reason: not valid java name */
    public static final void m1350drawLinearIndicator42QJj7c(DrawScope drawScope, float f11, float f12, long j11, float f13) {
        boolean z11;
        float f14;
        float f15;
        float r02 = Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc());
        float r12 = Size.m2742getHeightimpl(drawScope.m3425getSizeNHjbRc()) / ((float) 2);
        if (drawScope.getLayoutDirection() == LayoutDirection.Ltr) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            f14 = f11;
        } else {
            f14 = 1.0f - f12;
        }
        float f16 = f14 * r02;
        if (z11) {
            f15 = f12;
        } else {
            f15 = 1.0f - f11;
        }
        b.C(drawScope, j11, OffsetKt.Offset(f16, r12), OffsetKt.Offset(f15 * r02, r12), f13, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawLinearIndicatorBackground-bw27NRU  reason: not valid java name */
    public static final void m1351drawLinearIndicatorBackgroundbw27NRU(DrawScope drawScope, long j11, float f11) {
        m1350drawLinearIndicator42QJj7c(drawScope, 0.0f, 1.0f, j11, f11);
    }
}
