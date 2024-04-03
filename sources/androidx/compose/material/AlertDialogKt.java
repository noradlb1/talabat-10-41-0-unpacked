package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a~\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\u0015\b\u0002\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0015\b\u0002\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016\u001a8\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\fH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001c\u0010\u001d\u001a;\u0010\u001e\u001a\u00020\t*\u00020\u001f2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0001¢\u0006\u0002\u0010 \"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u0013\u0010\u0003\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\"\u0013\u0010\u0006\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"TextBaselineDistanceFromTitle", "Landroidx/compose/ui/unit/TextUnit;", "J", "TextBaselineDistanceFromTop", "TextPadding", "Landroidx/compose/ui/Modifier;", "TitleBaselineDistanceFromTop", "TitlePadding", "AlertDialogContent", "", "buttons", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "modifier", "title", "text", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "AlertDialogContent-WMdw5o4", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/runtime/Composer;II)V", "AlertDialogFlowRow", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisSpacing", "content", "AlertDialogFlowRow-ixp7dh8", "(FFLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "AlertDialogBaselineLayout", "Landroidx/compose/foundation/layout/ColumnScope;", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class AlertDialogKt {
    /* access modifiers changed from: private */
    public static final long TextBaselineDistanceFromTitle = TextUnitKt.getSp(36);
    /* access modifiers changed from: private */
    public static final long TextBaselineDistanceFromTop = TextUnitKt.getSp(38);
    @NotNull
    private static final Modifier TextPadding;
    /* access modifiers changed from: private */
    public static final long TitleBaselineDistanceFromTop = TextUnitKt.getSp(40);
    @NotNull
    private static final Modifier TitlePadding;

    static {
        Modifier.Companion companion = Modifier.Companion;
        float f11 = (float) 24;
        TitlePadding = PaddingKt.m490paddingqDBjuR0$default(companion, Dp.m5478constructorimpl(f11), 0.0f, Dp.m5478constructorimpl(f11), 0.0f, 10, (Object) null);
        TextPadding = PaddingKt.m490paddingqDBjuR0$default(companion, Dp.m5478constructorimpl(f11), 0.0f, Dp.m5478constructorimpl(f11), Dp.m5478constructorimpl((float) 28), 2, (Object) null);
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    public static final void AlertDialogBaselineLayout(@NotNull ColumnScope columnScope, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Function2<? super Composer, ? super Integer, Unit> function22, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        ColumnScope columnScope2 = columnScope;
        Function2<? super Composer, ? super Integer, Unit> function23 = function2;
        Function2<? super Composer, ? super Integer, Unit> function24 = function22;
        int i16 = i11;
        Intrinsics.checkNotNullParameter(columnScope2, "<this>");
        Composer startRestartGroup = composer.startRestartGroup(-555573207);
        if ((i16 & 14) == 0) {
            if (startRestartGroup.changed((Object) columnScope2)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i12 = i15 | i16;
        } else {
            i12 = i16;
        }
        if ((i16 & 112) == 0) {
            if (startRestartGroup.changed((Object) function23)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i12 |= i14;
        }
        if ((i16 & 896) == 0) {
            if (startRestartGroup.changed((Object) function24)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        if ((i12 & 731) != 146 || !startRestartGroup.getSkipping()) {
            Modifier weight = columnScope2.weight(Modifier.Companion, 1.0f, false);
            AlertDialogKt$AlertDialogBaselineLayout$2 alertDialogKt$AlertDialogBaselineLayout$2 = AlertDialogKt$AlertDialogBaselineLayout$2.INSTANCE;
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(weight);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r13 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r13, alertDialogKt$AlertDialogBaselineLayout$2, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r13, density, companion.getSetDensity());
            Updater.m2543setimpl(r13, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r13, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(1454034642);
            startRestartGroup.startReplaceableGroup(-1160646206);
            if (function23 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(TitlePadding, "title");
                Alignment.Companion companion2 = Alignment.Companion;
                Modifier align = columnScope2.align(layoutId, companion2.getStart());
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(companion2.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density2 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection2 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration2 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor2 = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf2 = LayoutKt.materializerOf(align);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r82 = Updater.m2536constructorimpl(startRestartGroup);
                Updater.m2543setimpl(r82, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m2543setimpl(r82, density2, companion.getSetDensity());
                Updater.m2543setimpl(r82, layoutDirection2, companion.getSetLayoutDirection());
                Updater.m2543setimpl(r82, viewConfiguration2, companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf2.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(472489145);
                function23.invoke(startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                Unit unit = Unit.INSTANCE;
            }
            startRestartGroup.endReplaceableGroup();
            if (function24 != null) {
                Modifier layoutId2 = LayoutIdKt.layoutId(TextPadding, "text");
                Alignment.Companion companion3 = Alignment.Companion;
                Modifier align2 = columnScope2.align(layoutId2, companion3.getStart());
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                Density density3 = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection3 = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ViewConfiguration viewConfiguration3 = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
                Function0<ComposeUiNode> constructor3 = companion.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf3 = LayoutKt.materializerOf(align2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r14 = Updater.m2536constructorimpl(startRestartGroup);
                Updater.m2543setimpl(r14, rememberBoxMeasurePolicy2, companion.getSetMeasurePolicy());
                Updater.m2543setimpl(r14, density3, companion.getSetDensity());
                Updater.m2543setimpl(r14, layoutDirection3, companion.getSetLayoutDirection());
                Updater.m2543setimpl(r14, viewConfiguration3, companion.getSetViewConfiguration());
                startRestartGroup.enableReusing();
                materializerOf3.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-2137368960);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                startRestartGroup.startReplaceableGroup(-272722206);
                function24.invoke(startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                Unit unit2 = Unit.INSTANCE;
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AlertDialogKt$AlertDialogBaselineLayout$3(columnScope2, function23, function24, i16));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:121:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00ee  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: AlertDialogContent-WMdw5o4  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m1075AlertDialogContentWMdw5o4(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r26, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r27, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r29, long r30, long r32, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r1 = r25
            r10 = r35
            java.lang.String r0 = "buttons"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            r0 = -453679601(0xffffffffe4f5660f, float:-3.6214451E22)
            r2 = r34
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r36 & 1
            if (r2 == 0) goto L_0x0019
            r2 = r10 | 6
            goto L_0x0029
        L_0x0019:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x0028
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0025
            r2 = 4
            goto L_0x0026
        L_0x0025:
            r2 = 2
        L_0x0026:
            r2 = r2 | r10
            goto L_0x0029
        L_0x0028:
            r2 = r10
        L_0x0029:
            r3 = r36 & 2
            if (r3 == 0) goto L_0x0030
            r2 = r2 | 48
            goto L_0x0043
        L_0x0030:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0043
            r4 = r26
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
            r4 = r26
        L_0x0045:
            r5 = r36 & 4
            if (r5 == 0) goto L_0x004c
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r6 = r10 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x005f
            r6 = r27
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005b
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r7 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r2 = r2 | r7
            goto L_0x0061
        L_0x005f:
            r6 = r27
        L_0x0061:
            r7 = r36 & 8
            if (r7 == 0) goto L_0x0068
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x007b
        L_0x0068:
            r8 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007b
            r8 = r28
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x0077
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0079
        L_0x0077:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0079:
            r2 = r2 | r9
            goto L_0x007d
        L_0x007b:
            r8 = r28
        L_0x007d:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r10
            if (r9 != 0) goto L_0x0098
            r9 = r36 & 16
            if (r9 != 0) goto L_0x0092
            r9 = r29
            boolean r11 = r0.changed((java.lang.Object) r9)
            if (r11 == 0) goto L_0x0094
            r11 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0096
        L_0x0092:
            r9 = r29
        L_0x0094:
            r11 = 8192(0x2000, float:1.14794E-41)
        L_0x0096:
            r2 = r2 | r11
            goto L_0x009a
        L_0x0098:
            r9 = r29
        L_0x009a:
            r11 = 458752(0x70000, float:6.42848E-40)
            r11 = r11 & r10
            if (r11 != 0) goto L_0x00b4
            r11 = r36 & 32
            if (r11 != 0) goto L_0x00ae
            r11 = r30
            boolean r13 = r0.changed((long) r11)
            if (r13 == 0) goto L_0x00b0
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b2
        L_0x00ae:
            r11 = r30
        L_0x00b0:
            r13 = 65536(0x10000, float:9.18355E-41)
        L_0x00b2:
            r2 = r2 | r13
            goto L_0x00b6
        L_0x00b4:
            r11 = r30
        L_0x00b6:
            r13 = 3670016(0x380000, float:5.142788E-39)
            r13 = r13 & r10
            if (r13 != 0) goto L_0x00d0
            r13 = r36 & 64
            if (r13 != 0) goto L_0x00ca
            r13 = r32
            boolean r15 = r0.changed((long) r13)
            if (r15 == 0) goto L_0x00cc
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00ce
        L_0x00ca:
            r13 = r32
        L_0x00cc:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x00ce:
            r2 = r2 | r15
            goto L_0x00d2
        L_0x00d0:
            r13 = r32
        L_0x00d2:
            r15 = 2995931(0x2db6db, float:4.198194E-39)
            r15 = r15 & r2
            r4 = 599186(0x92492, float:8.39638E-40)
            if (r15 != r4) goto L_0x00ee
            boolean r4 = r0.getSkipping()
            if (r4 != 0) goto L_0x00e2
            goto L_0x00ee
        L_0x00e2:
            r0.skipToGroupEnd()
            r2 = r26
            r3 = r6
            r4 = r8
            r5 = r9
            r6 = r11
            r8 = r13
            goto L_0x019c
        L_0x00ee:
            r0.startDefaults()
            r4 = r10 & 1
            r15 = -3670017(0xffffffffffc7ffff, float:NaN)
            r16 = -458753(0xfffffffffff8ffff, float:NaN)
            r17 = -57345(0xffffffffffff1fff, float:NaN)
            if (r4 == 0) goto L_0x0121
            boolean r4 = r0.getDefaultsInvalid()
            if (r4 == 0) goto L_0x0105
            goto L_0x0121
        L_0x0105:
            r0.skipToGroupEnd()
            r3 = r36 & 16
            if (r3 == 0) goto L_0x010e
            r2 = r2 & r17
        L_0x010e:
            r3 = r36 & 32
            if (r3 == 0) goto L_0x0114
            r2 = r2 & r16
        L_0x0114:
            r3 = r36 & 64
            if (r3 == 0) goto L_0x0119
            r2 = r2 & r15
        L_0x0119:
            r3 = r26
            r4 = r8
            r5 = r9
            r7 = r11
        L_0x011e:
            r23 = r13
            goto L_0x0164
        L_0x0121:
            if (r3 == 0) goto L_0x0126
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x0128
        L_0x0126:
            r3 = r26
        L_0x0128:
            r4 = 0
            if (r5 == 0) goto L_0x012c
            r6 = r4
        L_0x012c:
            if (r7 == 0) goto L_0x012f
            goto L_0x0130
        L_0x012f:
            r4 = r8
        L_0x0130:
            r5 = r36 & 16
            r7 = 6
            if (r5 == 0) goto L_0x0142
            androidx.compose.material.MaterialTheme r5 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Shapes r5 = r5.getShapes(r0, r7)
            androidx.compose.foundation.shape.CornerBasedShape r5 = r5.getMedium()
            r2 = r2 & r17
            goto L_0x0143
        L_0x0142:
            r5 = r9
        L_0x0143:
            r8 = r36 & 32
            if (r8 == 0) goto L_0x0154
            androidx.compose.material.MaterialTheme r8 = androidx.compose.material.MaterialTheme.INSTANCE
            androidx.compose.material.Colors r7 = r8.getColors(r0, r7)
            long r7 = r7.m1183getSurface0d7_KjU()
            r2 = r2 & r16
            goto L_0x0155
        L_0x0154:
            r7 = r11
        L_0x0155:
            r9 = r36 & 64
            if (r9 == 0) goto L_0x011e
            int r9 = r2 >> 15
            r9 = r9 & 14
            long r11 = androidx.compose.material.ColorsKt.m1197contentColorForek8zF_U(r7, r0, r9)
            r2 = r2 & r15
            r23 = r11
        L_0x0164:
            r0.endDefaults()
            r17 = 0
            r18 = 0
            androidx.compose.material.AlertDialogKt$AlertDialogContent$1 r9 = new androidx.compose.material.AlertDialogKt$AlertDialogContent$1
            r9.<init>(r6, r4, r1, r2)
            r11 = 629950291(0x258c4753, float:2.433446E-16)
            r12 = 1
            androidx.compose.runtime.internal.ComposableLambda r19 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r11, r12, r9)
            int r9 = r2 >> 3
            r9 = r9 & 14
            r11 = 1572864(0x180000, float:2.204052E-39)
            r9 = r9 | r11
            int r2 = r2 >> 9
            r11 = r2 & 112(0x70, float:1.57E-43)
            r9 = r9 | r11
            r11 = r2 & 896(0x380, float:1.256E-42)
            r9 = r9 | r11
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r21 = r9 | r2
            r22 = 48
            r11 = r3
            r12 = r5
            r13 = r7
            r15 = r23
            r20 = r0
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r11, r12, r13, r15, r17, r18, r19, r20, r21, r22)
            r2 = r3
            r3 = r6
            r6 = r7
            r8 = r23
        L_0x019c:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x01a3
            goto L_0x01b2
        L_0x01a3:
            androidx.compose.material.AlertDialogKt$AlertDialogContent$2 r13 = new androidx.compose.material.AlertDialogKt$AlertDialogContent$2
            r0 = r13
            r1 = r25
            r10 = r35
            r11 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10, r11)
            r12.updateScope(r13)
        L_0x01b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.AlertDialogKt.m1075AlertDialogContentWMdw5o4(kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, long, long, androidx.compose.runtime.Composer, int, int):void");
    }

    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: AlertDialogFlowRow-ixp7dh8  reason: not valid java name */
    public static final void m1076AlertDialogFlowRowixp7dh8(float f11, float f12, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer startRestartGroup = composer.startRestartGroup(73434452);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed(f11)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i12 = i15 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(f12)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i12 |= i14;
        }
        if ((i11 & 896) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        if ((i12 & 731) != 146 || !startRestartGroup.getSkipping()) {
            AlertDialogKt$AlertDialogFlowRow$1 alertDialogKt$AlertDialogFlowRow$1 = new AlertDialogKt$AlertDialogFlowRow$1(f11, f12);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.Companion;
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
            int i16 = ((((i12 >> 6) & 14) << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            startRestartGroup.disableReusing();
            Composer r72 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r72, alertDialogKt$AlertDialogFlowRow$1, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r72, density, companion2.getSetDensity());
            Updater.m2543setimpl(r72, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m2543setimpl(r72, viewConfiguration, companion2.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i16 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            function2.invoke(startRestartGroup, Integer.valueOf((i16 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new AlertDialogKt$AlertDialogFlowRow$2(f11, f12, function2, i11));
        }
    }
}
