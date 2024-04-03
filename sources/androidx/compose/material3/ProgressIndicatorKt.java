package androidx.compose.material3;

import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.material3.tokens.CircularProgressIndicatorTokens;
import androidx.compose.material3.tokens.LinearProgressIndicatorTokens;
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

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a3\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010*\u001a;\u0010\"\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020\u0005H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-\u001a3\u0010.\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010/\u001a\u00020'H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a;\u0010.\u001a\u00020#2\u0006\u0010+\u001a\u00020\u00012\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010/\u001a\u00020'H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001a9\u00104\u001a\u00020#*\u0002052\u0006\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b:\u0010;\u001a9\u0010<\u001a\u00020#*\u0002052\u0006\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010;\u001aA\u0010>\u001a\u00020#*\u0002052\u0006\u00106\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\u00052\u0006\u00107\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a9\u0010A\u001a\u00020#*\u0002052\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010E\u001a)\u0010F\u001a\u00020#*\u0002052\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bG\u0010H\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u0019\u0010\u0004\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007\"\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u0019\u0010\u0014\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0015\u0010\u0007\"\u0019\u0010\u0016\u001a\u00020\u0005X\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0017\u0010\u0007\"\u000e\u0010\u0018\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\nXT¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006I"}, d2 = {"BaseRotationAngle", "", "CircularEasing", "Landroidx/compose/animation/core/CubicBezierEasing;", "CircularIndicatorDiameter", "Landroidx/compose/ui/unit/Dp;", "getCircularIndicatorDiameter", "()F", "F", "FirstLineHeadDelay", "", "FirstLineHeadDuration", "FirstLineHeadEasing", "FirstLineTailDelay", "FirstLineTailDuration", "FirstLineTailEasing", "HeadAndTailAnimationDuration", "HeadAndTailDelayDuration", "JumpRotationAngle", "LinearAnimationDuration", "LinearIndicatorHeight", "getLinearIndicatorHeight", "LinearIndicatorWidth", "getLinearIndicatorWidth", "RotationAngleOffset", "RotationDuration", "RotationsPerCycle", "SecondLineHeadDelay", "SecondLineHeadDuration", "SecondLineHeadEasing", "SecondLineTailDelay", "SecondLineTailDuration", "SecondLineTailEasing", "StartAngleOffset", "CircularProgressIndicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "CircularProgressIndicator-aM-cp0Q", "(Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "progress", "CircularProgressIndicator-MBs18nI", "(FLandroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator", "trackColor", "LinearProgressIndicator-RIQooxk", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "LinearProgressIndicator-eaDK9VM", "(FLandroidx/compose/ui/Modifier;JJLandroidx/compose/runtime/Composer;II)V", "drawCircularIndicator", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "startAngle", "sweep", "stroke", "Landroidx/compose/ui/graphics/drawscope/Stroke;", "drawCircularIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawDeterminateCircularIndicator", "drawDeterminateCircularIndicator-42QJj7c", "drawIndeterminateCircularIndicator", "drawIndeterminateCircularIndicator-hrjfTZI", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFFJLandroidx/compose/ui/graphics/drawscope/Stroke;)V", "drawLinearIndicator", "startFraction", "endFraction", "drawLinearIndicator-42QJj7c", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;FFJF)V", "drawLinearIndicatorTrack", "drawLinearIndicatorTrack-bw27NRU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JF)V", "material3_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ProgressIndicatorKt {
    private static final float BaseRotationAngle = 286.0f;
    /* access modifiers changed from: private */
    @NotNull
    public static final CubicBezierEasing CircularEasing = new CubicBezierEasing(0.4f, 0.0f, 0.2f, 1.0f);
    private static final float CircularIndicatorDiameter;
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
    private static final float LinearIndicatorHeight = LinearProgressIndicatorTokens.INSTANCE.m2262getTrackHeightD9Ej5fM();
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

    static {
        CircularProgressIndicatorTokens circularProgressIndicatorTokens = CircularProgressIndicatorTokens.INSTANCE;
        CircularIndicatorDiameter = Dp.m5478constructorimpl(circularProgressIndicatorTokens.m2056getSizeD9Ej5fM() - Dp.m5478constructorimpl(circularProgressIndicatorTokens.m2055getActiveIndicatorWidthD9Ej5fM() * ((float) 2)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: CircularProgressIndicator-MBs18nI  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1796CircularProgressIndicatorMBs18nI(float r21, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r22, long r23, float r25, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r26, int r27, int r28) {
        /*
            r6 = r21
            r7 = r27
            r0 = 402841196(0x1802de6c, float:1.69144E-24)
            r1 = r26
            androidx.compose.runtime.Composer r8 = r1.startRestartGroup(r0)
            r1 = r28 & 1
            if (r1 == 0) goto L_0x0014
            r1 = r7 | 6
            goto L_0x0024
        L_0x0014:
            r1 = r7 & 14
            if (r1 != 0) goto L_0x0023
            boolean r1 = r8.changed((float) r6)
            if (r1 == 0) goto L_0x0020
            r1 = 4
            goto L_0x0021
        L_0x0020:
            r1 = 2
        L_0x0021:
            r1 = r1 | r7
            goto L_0x0024
        L_0x0023:
            r1 = r7
        L_0x0024:
            r2 = r28 & 2
            if (r2 == 0) goto L_0x002b
            r1 = r1 | 48
            goto L_0x003e
        L_0x002b:
            r3 = r7 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x003e
            r3 = r22
            boolean r4 = r8.changed((java.lang.Object) r3)
            if (r4 == 0) goto L_0x003a
            r4 = 32
            goto L_0x003c
        L_0x003a:
            r4 = 16
        L_0x003c:
            r1 = r1 | r4
            goto L_0x0040
        L_0x003e:
            r3 = r22
        L_0x0040:
            r4 = r7 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0059
            r4 = r28 & 4
            if (r4 != 0) goto L_0x0053
            r4 = r23
            boolean r9 = r8.changed((long) r4)
            if (r9 == 0) goto L_0x0055
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0057
        L_0x0053:
            r4 = r23
        L_0x0055:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0057:
            r1 = r1 | r9
            goto L_0x005b
        L_0x0059:
            r4 = r23
        L_0x005b:
            r9 = r28 & 8
            if (r9 == 0) goto L_0x0062
            r1 = r1 | 3072(0xc00, float:4.305E-42)
            goto L_0x0075
        L_0x0062:
            r10 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r10 != 0) goto L_0x0075
            r10 = r25
            boolean r11 = r8.changed((float) r10)
            if (r11 == 0) goto L_0x0071
            r11 = 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x0071:
            r11 = 1024(0x400, float:1.435E-42)
        L_0x0073:
            r1 = r1 | r11
            goto L_0x0077
        L_0x0075:
            r10 = r25
        L_0x0077:
            r1 = r1 & 5851(0x16db, float:8.199E-42)
            r11 = 1170(0x492, float:1.64E-42)
            if (r1 != r11) goto L_0x008c
            boolean r1 = r8.getSkipping()
            if (r1 != 0) goto L_0x0084
            goto L_0x008c
        L_0x0084:
            r8.skipToGroupEnd()
            r2 = r3
            r3 = r4
            r5 = r10
            goto L_0x011d
        L_0x008c:
            r8.startDefaults()
            r1 = r7 & 1
            if (r1 == 0) goto L_0x00a1
            boolean r1 = r8.getDefaultsInvalid()
            if (r1 == 0) goto L_0x009a
            goto L_0x00a1
        L_0x009a:
            r8.skipToGroupEnd()
            r9 = r3
            r12 = r10
            r10 = r4
            goto L_0x00c3
        L_0x00a1:
            if (r2 == 0) goto L_0x00a6
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x00a7
        L_0x00a6:
            r1 = r3
        L_0x00a7:
            r2 = r28 & 4
            if (r2 == 0) goto L_0x00b3
            androidx.compose.material3.ProgressIndicatorDefaults r2 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            r3 = 6
            long r2 = r2.getCircularColor(r8, r3)
            goto L_0x00b4
        L_0x00b3:
            r2 = r4
        L_0x00b4:
            if (r9 == 0) goto L_0x00c0
            androidx.compose.material3.ProgressIndicatorDefaults r4 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r4 = r4.m1795getCircularStrokeWidthD9Ej5fM()
            r9 = r1
            r10 = r2
            r12 = r4
            goto L_0x00c3
        L_0x00c0:
            r9 = r1
            r12 = r10
            r10 = r2
        L_0x00c3:
            r8.endDefaults()
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x00d2
            r1 = -1
            java.lang.String r2 = "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:226)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r7, r1, r2)
        L_0x00d2:
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
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1 r1 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$1
            r1.<init>(r6, r10, r14)
            r2 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r0, r1, r8, r2)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x011a
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x011a:
            r2 = r9
            r3 = r10
            r5 = r12
        L_0x011d:
            androidx.compose.runtime.ScopeUpdateScope r8 = r8.endRestartGroup()
            if (r8 != 0) goto L_0x0124
            goto L_0x0133
        L_0x0124:
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2 r9 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$2
            r0 = r9
            r1 = r21
            r6 = r27
            r7 = r28
            r0.<init>(r1, r2, r3, r5, r6, r7)
            r8.updateScope(r9)
        L_0x0133:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m1796CircularProgressIndicatorMBs18nI(float, androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: CircularProgressIndicator-aM-cp0Q  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1797CircularProgressIndicatoraMcp0Q(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r30, long r31, float r33, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r5 = r35
            r0 = 947193756(0x3875079c, float:5.841964E-5)
            r1 = r34
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            r2 = r36 & 1
            r3 = 2
            if (r2 == 0) goto L_0x0016
            r4 = r5 | 6
            r6 = r4
            r4 = r30
            goto L_0x002a
        L_0x0016:
            r4 = r5 & 14
            if (r4 != 0) goto L_0x0027
            r4 = r30
            boolean r6 = r1.changed((java.lang.Object) r4)
            if (r6 == 0) goto L_0x0024
            r6 = 4
            goto L_0x0025
        L_0x0024:
            r6 = r3
        L_0x0025:
            r6 = r6 | r5
            goto L_0x002a
        L_0x0027:
            r4 = r30
            r6 = r5
        L_0x002a:
            r7 = r5 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x0043
            r7 = r36 & 2
            if (r7 != 0) goto L_0x003d
            r7 = r31
            boolean r9 = r1.changed((long) r7)
            if (r9 == 0) goto L_0x003f
            r9 = 32
            goto L_0x0041
        L_0x003d:
            r7 = r31
        L_0x003f:
            r9 = 16
        L_0x0041:
            r6 = r6 | r9
            goto L_0x0045
        L_0x0043:
            r7 = r31
        L_0x0045:
            r9 = r36 & 4
            if (r9 == 0) goto L_0x004c
            r6 = r6 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r10 = r5 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x005f
            r10 = r33
            boolean r11 = r1.changed((float) r10)
            if (r11 == 0) goto L_0x005b
            r11 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r11 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r6 = r6 | r11
            goto L_0x0061
        L_0x005f:
            r10 = r33
        L_0x0061:
            r6 = r6 & 731(0x2db, float:1.024E-42)
            r11 = 146(0x92, float:2.05E-43)
            if (r6 != r11) goto L_0x0076
            boolean r6 = r1.getSkipping()
            if (r6 != 0) goto L_0x006e
            goto L_0x0076
        L_0x006e:
            r1.skipToGroupEnd()
            r2 = r4
            r15 = r7
            r4 = r10
            goto L_0x01a0
        L_0x0076:
            r1.startDefaults()
            r6 = r5 & 1
            if (r6 == 0) goto L_0x008b
            boolean r6 = r1.getDefaultsInvalid()
            if (r6 == 0) goto L_0x0084
            goto L_0x008b
        L_0x0084:
            r1.skipToGroupEnd()
            r2 = r4
            r15 = r7
        L_0x0089:
            r4 = r10
            goto L_0x00aa
        L_0x008b:
            if (r2 == 0) goto L_0x0090
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x0091
        L_0x0090:
            r2 = r4
        L_0x0091:
            r4 = r36 & 2
            if (r4 == 0) goto L_0x009d
            androidx.compose.material3.ProgressIndicatorDefaults r4 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            r6 = 6
            long r6 = r4.getCircularColor(r1, r6)
            goto L_0x009e
        L_0x009d:
            r6 = r7
        L_0x009e:
            if (r9 == 0) goto L_0x00a8
            androidx.compose.material3.ProgressIndicatorDefaults r4 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            float r4 = r4.m1795getCircularStrokeWidthD9Ej5fM()
            r15 = r6
            goto L_0x00aa
        L_0x00a8:
            r15 = r6
            goto L_0x0089
        L_0x00aa:
            r1.endDefaults()
            boolean r6 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r6 == 0) goto L_0x00b9
            r6 = -1
            java.lang.String r7 = "androidx.compose.material3.CircularProgressIndicator (ProgressIndicator.kt:261)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r5, r6, r7)
        L_0x00b9:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r0 = r1.consume(r0)
            androidx.compose.ui.unit.Density r0 = (androidx.compose.ui.unit.Density) r0
            androidx.compose.ui.graphics.drawscope.Stroke r14 = new androidx.compose.ui.graphics.drawscope.Stroke
            float r7 = r0.m5447toPx0680j_4(r4)
            r8 = 0
            androidx.compose.ui.graphics.StrokeCap$Companion r0 = androidx.compose.ui.graphics.StrokeCap.Companion
            int r9 = r0.m3255getSquareKaPHkGw()
            r10 = 0
            r11 = 0
            r12 = 26
            r13 = 0
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            r0 = 0
            androidx.compose.animation.core.InfiniteTransition r13 = androidx.compose.animation.core.InfiniteTransitionKt.rememberInfiniteTransition(r1, r0)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            r6 = 5
            java.lang.Integer r8 = java.lang.Integer.valueOf(r6)
            kotlin.jvm.internal.IntCompanionObject r6 = kotlin.jvm.internal.IntCompanionObject.INSTANCE
            androidx.compose.animation.core.TwoWayConverter r9 = androidx.compose.animation.core.VectorConvertersKt.getVectorConverter((kotlin.jvm.internal.IntCompanionObject) r6)
            r6 = 6660(0x1a04, float:9.333E-42)
            androidx.compose.animation.core.Easing r10 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r12 = 0
            androidx.compose.animation.core.TweenSpec r17 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r6, r0, r10, r3, r12)
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
            r11 = r1
            r5 = r12
            r12 = r18
            androidx.compose.runtime.State r12 = androidx.compose.animation.core.InfiniteTransitionKt.animateValue(r6, r7, r8, r9, r10, r11, r12)
            r7 = 0
            r8 = 1133445120(0x438f0000, float:286.0)
            r6 = 1332(0x534, float:1.867E-42)
            androidx.compose.animation.core.Easing r9 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            androidx.compose.animation.core.TweenSpec r24 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r6, r0, r9, r3, r5)
            r25 = 0
            r26 = 0
            r28 = 6
            r29 = 0
            androidx.compose.animation.core.InfiniteRepeatableSpec r9 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r24, r25, r26, r28, r29)
            r3 = r23
            r5 = r3 | 432(0x1b0, float:6.05E-43)
            int r6 = r17 << 9
            r11 = r5 | r6
            r6 = r13
            r10 = r1
            androidx.compose.runtime.State r5 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r6, r7, r8, r9, r10, r11)
            r8 = 1133576192(0x43910000, float:290.0)
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1 r6 = androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$endAngle$1.INSTANCE
            androidx.compose.animation.core.KeyframesSpec r18 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r6)
            r19 = 0
            r20 = 0
            r22 = 6
            r23 = 0
            androidx.compose.animation.core.InfiniteRepeatableSpec r9 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r18, r19, r20, r22, r23)
            r6 = r3 | 432(0x1b0, float:6.05E-43)
            int r10 = r17 << 9
            r11 = r6 | r10
            r6 = r13
            r10 = r1
            androidx.compose.runtime.State r18 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r6, r7, r8, r9, r10, r11)
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1 r6 = androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$startAngle$1.INSTANCE
            androidx.compose.animation.core.KeyframesSpec r19 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r6)
            r20 = 0
            r21 = 0
            r23 = 6
            r24 = 0
            androidx.compose.animation.core.InfiniteRepeatableSpec r9 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r19, r20, r21, r23, r24)
            r3 = r3 | 432(0x1b0, float:6.05E-43)
            int r6 = r17 << 9
            r11 = r3 | r6
            r6 = r13
            androidx.compose.runtime.State r9 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r6, r7, r8, r9, r10, r11)
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics(r2)
            float r6 = CircularIndicatorDiameter
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.SizeKt.m558size3ABfNKs(r3, r6)
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$3 r13 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$3
            r6 = r13
            r7 = r12
            r8 = r18
            r10 = r5
            r11 = r4
            r5 = r13
            r12 = r15
            r6.<init>(r7, r8, r9, r10, r11, r12, r14)
            androidx.compose.foundation.CanvasKt.Canvas(r3, r5, r1, r0)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01a0
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01a0:
            androidx.compose.runtime.ScopeUpdateScope r7 = r1.endRestartGroup()
            if (r7 != 0) goto L_0x01a7
            goto L_0x01b6
        L_0x01a7:
            androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4 r8 = new androidx.compose.material3.ProgressIndicatorKt$CircularProgressIndicator$4
            r0 = r8
            r1 = r2
            r2 = r15
            r5 = r35
            r6 = r36
            r0.<init>(r1, r2, r4, r5, r6)
            r7.updateScope(r8)
        L_0x01b6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m1797CircularProgressIndicatoraMcp0Q(androidx.compose.ui.Modifier, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v19, resolved type: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$3$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v10, resolved type: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$3$1} */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01cd, code lost:
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x01cf;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: LinearProgressIndicator-RIQooxk  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1798LinearProgressIndicatorRIQooxk(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r25, long r26, long r28, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r30, int r31, int r32) {
        /*
            r6 = r31
            r0 = 585576195(0x22e72f03, float:6.266245E-18)
            r1 = r30
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            r2 = r32 & 1
            if (r2 == 0) goto L_0x0015
            r5 = r6 | 6
            r7 = r5
            r5 = r25
            goto L_0x0029
        L_0x0015:
            r5 = r6 & 14
            if (r5 != 0) goto L_0x0026
            r5 = r25
            boolean r7 = r1.changed((java.lang.Object) r5)
            if (r7 == 0) goto L_0x0023
            r7 = 4
            goto L_0x0024
        L_0x0023:
            r7 = 2
        L_0x0024:
            r7 = r7 | r6
            goto L_0x0029
        L_0x0026:
            r5 = r25
            r7 = r6
        L_0x0029:
            r8 = r6 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0042
            r8 = r32 & 2
            if (r8 != 0) goto L_0x003c
            r8 = r26
            boolean r10 = r1.changed((long) r8)
            if (r10 == 0) goto L_0x003e
            r10 = 32
            goto L_0x0040
        L_0x003c:
            r8 = r26
        L_0x003e:
            r10 = 16
        L_0x0040:
            r7 = r7 | r10
            goto L_0x0044
        L_0x0042:
            r8 = r26
        L_0x0044:
            r10 = r6 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x005d
            r10 = r32 & 4
            if (r10 != 0) goto L_0x0057
            r10 = r28
            boolean r12 = r1.changed((long) r10)
            if (r12 == 0) goto L_0x0059
            r12 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0057:
            r10 = r28
        L_0x0059:
            r12 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r7 = r7 | r12
            goto L_0x005f
        L_0x005d:
            r10 = r28
        L_0x005f:
            r7 = r7 & 731(0x2db, float:1.024E-42)
            r12 = 146(0x92, float:2.05E-43)
            if (r7 != r12) goto L_0x0073
            boolean r7 = r1.getSkipping()
            if (r7 != 0) goto L_0x006c
            goto L_0x0073
        L_0x006c:
            r1.skipToGroupEnd()
            r2 = r5
        L_0x0070:
            r4 = r10
            goto L_0x01f3
        L_0x0073:
            r1.startDefaults()
            r7 = r6 & 1
            r12 = 6
            if (r7 == 0) goto L_0x0087
            boolean r7 = r1.getDefaultsInvalid()
            if (r7 == 0) goto L_0x0082
            goto L_0x0087
        L_0x0082:
            r1.skipToGroupEnd()
            r2 = r5
            goto L_0x00a2
        L_0x0087:
            if (r2 == 0) goto L_0x008c
            androidx.compose.ui.Modifier$Companion r2 = androidx.compose.ui.Modifier.Companion
            goto L_0x008d
        L_0x008c:
            r2 = r5
        L_0x008d:
            r5 = r32 & 2
            if (r5 == 0) goto L_0x0098
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r7 = r5.getLinearColor(r1, r12)
            r8 = r7
        L_0x0098:
            r5 = r32 & 4
            if (r5 == 0) goto L_0x00a2
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r10 = r5.getLinearTrackColor(r1, r12)
        L_0x00a2:
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x00b1
            r5 = -1
            java.lang.String r7 = "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:103)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r6, r5, r7)
        L_0x00b1:
            r0 = 0
            androidx.compose.animation.core.InfiniteTransition r5 = androidx.compose.animation.core.InfiniteTransitionKt.rememberInfiniteTransition(r1, r0)
            r7 = 0
            r13 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1 r14 = androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineHead$1.INSTANCE
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
            r3 = r15 | 432(0x1b0, float:6.05E-43)
            int r17 = androidx.compose.animation.core.InfiniteRepeatableSpec.$stable
            int r18 = r17 << 9
            r3 = r3 | r18
            r25 = r5
            r26 = r7
            r27 = r13
            r28 = r14
            r29 = r1
            r30 = r3
            androidx.compose.runtime.State r3 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r25, r26, r27, r28, r29, r30)
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1 r14 = androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$firstLineTail$1.INSTANCE
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
            r4 = r15 | 432(0x1b0, float:6.05E-43)
            int r19 = r17 << 9
            r4 = r4 | r19
            r25 = r5
            r26 = r7
            r27 = r13
            r28 = r14
            r29 = r1
            r30 = r4
            androidx.compose.runtime.State r4 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r25, r26, r27, r28, r29, r30)
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1 r14 = androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineHead$1.INSTANCE
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
            r0 = r15 | 432(0x1b0, float:6.05E-43)
            int r19 = r17 << 9
            r0 = r0 | r19
            r25 = r5
            r26 = r7
            r27 = r13
            r28 = r14
            r29 = r1
            r30 = r0
            androidx.compose.runtime.State r20 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r25, r26, r27, r28, r29, r30)
            r0 = 0
            r7 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1 r13 = androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$secondLineTail$1.INSTANCE
            androidx.compose.animation.core.KeyframesSpec r13 = androidx.compose.animation.core.AnimationSpecKt.keyframes(r13)
            r14 = 0
            r23 = 0
            r19 = 6
            r21 = 0
            r25 = r13
            r26 = r14
            r27 = r23
            r29 = r19
            r30 = r21
            androidx.compose.animation.core.InfiniteRepeatableSpec r13 = androidx.compose.animation.core.AnimationSpecKt.m110infiniteRepeatable9IiC70o$default(r25, r26, r27, r29, r30)
            r14 = r15 | 432(0x1b0, float:6.05E-43)
            int r15 = r17 << 9
            r14 = r14 | r15
            r25 = r5
            r26 = r0
            r27 = r7
            r28 = r13
            r29 = r1
            r30 = r14
            androidx.compose.runtime.State r21 = androidx.compose.animation.core.InfiniteTransitionKt.animateFloat(r25, r26, r27, r28, r29, r30)
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics(r2)
            float r5 = LinearIndicatorWidth
            float r7 = LinearIndicatorHeight
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m560sizeVpY3zN4(r0, r5, r7)
            java.lang.Object[] r5 = new java.lang.Object[r12]
            androidx.compose.ui.graphics.Color r7 = androidx.compose.ui.graphics.Color.m2909boximpl(r10)
            r13 = 0
            r5[r13] = r7
            r7 = 1
            r5[r7] = r3
            r7 = 2
            r5[r7] = r4
            r7 = 3
            androidx.compose.ui.graphics.Color r13 = androidx.compose.ui.graphics.Color.m2909boximpl(r8)
            r5[r7] = r13
            r7 = 4
            r5[r7] = r20
            r7 = 5
            r5[r7] = r21
            r7 = -568225417(0xffffffffde219177, float:-2.91055434E18)
            r1.startReplaceableGroup(r7)
            r7 = 0
            r13 = 0
        L_0x01b5:
            if (r13 >= r12) goto L_0x01c1
            r14 = r5[r13]
            boolean r14 = r1.changed((java.lang.Object) r14)
            r7 = r7 | r14
            int r13 = r13 + 1
            goto L_0x01b5
        L_0x01c1:
            java.lang.Object r5 = r1.rememberedValue()
            if (r7 != 0) goto L_0x01cf
            androidx.compose.runtime.Composer$Companion r7 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r7.getEmpty()
            if (r5 != r7) goto L_0x01df
        L_0x01cf:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$3$1 r5 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$3$1
            r13 = r5
            r14 = r10
            r16 = r3
            r17 = r4
            r18 = r8
            r13.<init>(r14, r16, r17, r18, r20, r21)
            r1.updateRememberedValue(r5)
        L_0x01df:
            r1.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r3 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r0, r5, r1, r3)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0070
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0070
        L_0x01f3:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 != 0) goto L_0x01fa
            goto L_0x0209
        L_0x01fa:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4 r11 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$4
            r0 = r11
            r1 = r2
            r2 = r8
            r6 = r31
            r7 = r32
            r0.<init>(r1, r2, r4, r6, r7)
            r10.updateScope(r11)
        L_0x0209:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m1798LinearProgressIndicatorRIQooxk(androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v21, resolved type: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1} */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0118, code lost:
        if (r5 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x011a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    /* renamed from: LinearProgressIndicator-eaDK9VM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1799LinearProgressIndicatoreaDK9VM(float r13, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r14, long r15, long r17, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r19, int r20, int r21) {
        /*
            r7 = r20
            r0 = -372717133(0xffffffffe9c8c9b3, float:-3.0342208E25)
            r1 = r19
            androidx.compose.runtime.Composer r1 = r1.startRestartGroup(r0)
            r2 = r21 & 1
            if (r2 == 0) goto L_0x0014
            r2 = r7 | 6
            r3 = r2
            r2 = r13
            goto L_0x0026
        L_0x0014:
            r2 = r7 & 14
            if (r2 != 0) goto L_0x0024
            r2 = r13
            boolean r3 = r1.changed((float) r13)
            if (r3 == 0) goto L_0x0021
            r3 = 4
            goto L_0x0022
        L_0x0021:
            r3 = 2
        L_0x0022:
            r3 = r3 | r7
            goto L_0x0026
        L_0x0024:
            r2 = r13
            r3 = r7
        L_0x0026:
            r4 = r21 & 2
            if (r4 == 0) goto L_0x002d
            r3 = r3 | 48
            goto L_0x003f
        L_0x002d:
            r5 = r7 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x003f
            r5 = r14
            boolean r6 = r1.changed((java.lang.Object) r14)
            if (r6 == 0) goto L_0x003b
            r6 = 32
            goto L_0x003d
        L_0x003b:
            r6 = 16
        L_0x003d:
            r3 = r3 | r6
            goto L_0x0040
        L_0x003f:
            r5 = r14
        L_0x0040:
            r6 = r7 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0056
            r6 = r21 & 4
            r8 = r15
            if (r6 != 0) goto L_0x0052
            boolean r6 = r1.changed((long) r8)
            if (r6 == 0) goto L_0x0052
            r6 = 256(0x100, float:3.59E-43)
            goto L_0x0054
        L_0x0052:
            r6 = 128(0x80, float:1.794E-43)
        L_0x0054:
            r3 = r3 | r6
            goto L_0x0057
        L_0x0056:
            r8 = r15
        L_0x0057:
            r6 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x006e
            r6 = r21 & 8
            r10 = r17
            if (r6 != 0) goto L_0x006a
            boolean r6 = r1.changed((long) r10)
            if (r6 == 0) goto L_0x006a
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x006c
        L_0x006a:
            r6 = 1024(0x400, float:1.435E-42)
        L_0x006c:
            r3 = r3 | r6
            goto L_0x0070
        L_0x006e:
            r10 = r17
        L_0x0070:
            r6 = r3 & 5851(0x16db, float:8.199E-42)
            r12 = 1170(0x492, float:1.64E-42)
            if (r6 != r12) goto L_0x0084
            boolean r6 = r1.getSkipping()
            if (r6 != 0) goto L_0x007d
            goto L_0x0084
        L_0x007d:
            r1.skipToGroupEnd()
            r4 = r5
        L_0x0081:
            r5 = r10
            goto L_0x013c
        L_0x0084:
            r1.startDefaults()
            r6 = r7 & 1
            if (r6 == 0) goto L_0x00a3
            boolean r6 = r1.getDefaultsInvalid()
            if (r6 == 0) goto L_0x0092
            goto L_0x00a3
        L_0x0092:
            r1.skipToGroupEnd()
            r4 = r21 & 4
            if (r4 == 0) goto L_0x009b
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x009b:
            r4 = r21 & 8
            if (r4 == 0) goto L_0x00a1
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
        L_0x00a1:
            r4 = r5
            goto L_0x00c3
        L_0x00a3:
            if (r4 == 0) goto L_0x00a8
            androidx.compose.ui.Modifier$Companion r4 = androidx.compose.ui.Modifier.Companion
            goto L_0x00a9
        L_0x00a8:
            r4 = r5
        L_0x00a9:
            r5 = r21 & 4
            r6 = 6
            if (r5 == 0) goto L_0x00b6
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r8 = r5.getLinearColor(r1, r6)
            r3 = r3 & -897(0xfffffffffffffc7f, float:NaN)
        L_0x00b6:
            r5 = r21 & 8
            if (r5 == 0) goto L_0x00c3
            androidx.compose.material3.ProgressIndicatorDefaults r5 = androidx.compose.material3.ProgressIndicatorDefaults.INSTANCE
            long r5 = r5.getLinearTrackColor(r1, r6)
            r3 = r3 & -7169(0xffffffffffffe3ff, float:NaN)
            r10 = r5
        L_0x00c3:
            r1.endDefaults()
            boolean r5 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r5 == 0) goto L_0x00d2
            r5 = -1
            java.lang.String r6 = "androidx.compose.material3.LinearProgressIndicator (ProgressIndicator.kt:71)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r3, r5, r6)
        L_0x00d2:
            r0 = 0
            r3 = 0
            r5 = 6
            r6 = 0
            r14 = r4
            r15 = r13
            r16 = r0
            r17 = r3
            r18 = r5
            r19 = r6
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.ProgressSemanticsKt.progressSemantics$default(r14, r15, r16, r17, r18, r19)
            float r3 = LinearIndicatorWidth
            float r5 = LinearIndicatorHeight
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.m560sizeVpY3zN4(r0, r3, r5)
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m2909boximpl(r10)
            java.lang.Float r5 = java.lang.Float.valueOf(r13)
            androidx.compose.ui.graphics.Color r6 = androidx.compose.ui.graphics.Color.m2909boximpl(r8)
            r12 = 1618982084(0x607fb4c4, float:7.370227E19)
            r1.startReplaceableGroup(r12)
            boolean r3 = r1.changed((java.lang.Object) r3)
            boolean r5 = r1.changed((java.lang.Object) r5)
            r3 = r3 | r5
            boolean r5 = r1.changed((java.lang.Object) r6)
            r3 = r3 | r5
            java.lang.Object r5 = r1.rememberedValue()
            if (r3 != 0) goto L_0x011a
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r5 != r3) goto L_0x0128
        L_0x011a:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1 r5 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$1$1
            r14 = r5
            r15 = r10
            r17 = r13
            r18 = r8
            r14.<init>(r15, r17, r18)
            r1.updateRememberedValue(r5)
        L_0x0128:
            r1.endReplaceableGroup()
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r3 = 0
            androidx.compose.foundation.CanvasKt.Canvas(r0, r5, r1, r3)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0081
            androidx.compose.runtime.ComposerKt.traceEventEnd()
            goto L_0x0081
        L_0x013c:
            androidx.compose.runtime.ScopeUpdateScope r10 = r1.endRestartGroup()
            if (r10 != 0) goto L_0x0143
            goto L_0x0153
        L_0x0143:
            androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2 r11 = new androidx.compose.material3.ProgressIndicatorKt$LinearProgressIndicator$2
            r0 = r11
            r1 = r13
            r2 = r4
            r3 = r8
            r7 = r20
            r8 = r21
            r0.<init>(r1, r2, r3, r5, r7, r8)
            r10.updateScope(r11)
        L_0x0153:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.ProgressIndicatorKt.m1799LinearProgressIndicatoreaDK9VM(float, androidx.compose.ui.Modifier, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: drawCircularIndicator-42QJj7c  reason: not valid java name */
    private static final void m1804drawCircularIndicator42QJj7c(DrawScope drawScope, float f11, float f12, long j11, Stroke stroke) {
        float f13 = (float) 2;
        float width = stroke.getWidth() / f13;
        float r22 = Size.m2745getWidthimpl(drawScope.m3425getSizeNHjbRc()) - (f13 * width);
        b.v(drawScope, j11, f11, f12, false, OffsetKt.Offset(width, width), SizeKt.Size(r22, r22), 0.0f, stroke, (ColorFilter) null, 0, 832, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawDeterminateCircularIndicator-42QJj7c  reason: not valid java name */
    public static final void m1805drawDeterminateCircularIndicator42QJj7c(DrawScope drawScope, float f11, float f12, long j11, Stroke stroke) {
        m1804drawCircularIndicator42QJj7c(drawScope, f11, f12, j11, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawIndeterminateCircularIndicator-hrjfTZI  reason: not valid java name */
    public static final void m1806drawIndeterminateCircularIndicatorhrjfTZI(DrawScope drawScope, float f11, float f12, float f13, long j11, Stroke stroke) {
        m1804drawCircularIndicator42QJj7c(drawScope, f11 + (((f12 / Dp.m5478constructorimpl(CircularIndicatorDiameter / ((float) 2))) * 57.29578f) / 2.0f), Math.max(f13, 0.1f), j11, stroke);
    }

    /* access modifiers changed from: private */
    /* renamed from: drawLinearIndicator-42QJj7c  reason: not valid java name */
    public static final void m1807drawLinearIndicator42QJj7c(DrawScope drawScope, float f11, float f12, long j11, float f13) {
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
    /* renamed from: drawLinearIndicatorTrack-bw27NRU  reason: not valid java name */
    public static final void m1808drawLinearIndicatorTrackbw27NRU(DrawScope drawScope, long j11, float f11) {
        m1807drawLinearIndicator42QJj7c(drawScope, 0.0f, 1.0f, j11, f11);
    }

    public static final float getCircularIndicatorDiameter() {
        return CircularIndicatorDiameter;
    }

    public static final float getLinearIndicatorHeight() {
        return LinearIndicatorHeight;
    }

    public static final float getLinearIndicatorWidth() {
        return LinearIndicatorWidth;
    }
}
