package com.google.accompanist.flowlayout;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001ap\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\n\u0010\b\u001a\u00060\tj\u0002`\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\n\u0010\u0010\u001a\u00060\tj\u0002`\n2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001av\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\b\u0002\u0010\b\u001a\u00060\tj\u0002`\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\f\b\u0002\u0010\u0010\u001a\u00060\tj\u0002`\n2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001av\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\b\u0002\u0010\b\u001a\u00060\tj\u0002`\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\f\b\u0002\u0010\u0010\u001a\u00060\tj\u0002`\n2\u0011\u0010\u0011\u001a\r\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u0018*\n\u0010\u001b\"\u00020\t2\u00020\t\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Flow", "", "modifier", "Landroidx/compose/ui/Modifier;", "orientation", "Lcom/google/accompanist/flowlayout/LayoutOrientation;", "mainAxisSize", "Lcom/google/accompanist/flowlayout/SizeMode;", "mainAxisAlignment", "Lcom/google/accompanist/flowlayout/MainAxisAlignment;", "Lcom/google/accompanist/flowlayout/FlowMainAxisAlignment;", "mainAxisSpacing", "Landroidx/compose/ui/unit/Dp;", "crossAxisAlignment", "Lcom/google/accompanist/flowlayout/FlowCrossAxisAlignment;", "crossAxisSpacing", "lastLineMainAxisAlignment", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Flow-F4y8cZ0", "(Landroidx/compose/ui/Modifier;Lcom/google/accompanist/flowlayout/LayoutOrientation;Lcom/google/accompanist/flowlayout/SizeMode;Lcom/google/accompanist/flowlayout/MainAxisAlignment;FLcom/google/accompanist/flowlayout/FlowCrossAxisAlignment;FLcom/google/accompanist/flowlayout/MainAxisAlignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "FlowColumn", "FlowColumn-07r0xoM", "(Landroidx/compose/ui/Modifier;Lcom/google/accompanist/flowlayout/SizeMode;Lcom/google/accompanist/flowlayout/MainAxisAlignment;FLcom/google/accompanist/flowlayout/FlowCrossAxisAlignment;FLcom/google/accompanist/flowlayout/MainAxisAlignment;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "FlowRow", "FlowRow-07r0xoM", "FlowMainAxisAlignment", "flowlayout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class FlowKt {
    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: Flow-F4y8cZ0  reason: not valid java name */
    public static final void m9014FlowF4y8cZ0(Modifier modifier, LayoutOrientation layoutOrientation, SizeMode sizeMode, MainAxisAlignment mainAxisAlignment, float f11, FlowCrossAxisAlignment flowCrossAxisAlignment, float f12, MainAxisAlignment mainAxisAlignment2, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        int i23 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-1567419051);
        if ((i23 & 14) == 0) {
            if (startRestartGroup.changed((Object) modifier)) {
                i22 = 4;
            } else {
                i22 = 2;
            }
            i12 = i22 | i23;
        } else {
            Modifier modifier2 = modifier;
            i12 = i23;
        }
        if ((i23 & 112) == 0) {
            if (startRestartGroup.changed((Object) layoutOrientation)) {
                i21 = 32;
            } else {
                i21 = 16;
            }
            i12 |= i21;
        } else {
            LayoutOrientation layoutOrientation2 = layoutOrientation;
        }
        if ((i23 & 896) == 0) {
            if (startRestartGroup.changed((Object) sizeMode)) {
                i19 = 256;
            } else {
                i19 = 128;
            }
            i12 |= i19;
        } else {
            SizeMode sizeMode2 = sizeMode;
        }
        if ((i23 & 7168) == 0) {
            if (startRestartGroup.changed((Object) mainAxisAlignment)) {
                i18 = 2048;
            } else {
                i18 = 1024;
            }
            i12 |= i18;
        } else {
            MainAxisAlignment mainAxisAlignment3 = mainAxisAlignment;
        }
        if ((57344 & i23) == 0) {
            if (startRestartGroup.changed(f11)) {
                i17 = 16384;
            } else {
                i17 = 8192;
            }
            i12 |= i17;
        } else {
            float f13 = f11;
        }
        if ((458752 & i23) == 0) {
            if (startRestartGroup.changed((Object) flowCrossAxisAlignment)) {
                i16 = 131072;
            } else {
                i16 = 65536;
            }
            i12 |= i16;
        } else {
            FlowCrossAxisAlignment flowCrossAxisAlignment2 = flowCrossAxisAlignment;
        }
        float f14 = f12;
        if ((3670016 & i23) == 0) {
            if (startRestartGroup.changed(f14)) {
                i15 = 1048576;
            } else {
                i15 = 524288;
            }
            i12 |= i15;
        }
        MainAxisAlignment mainAxisAlignment4 = mainAxisAlignment2;
        if ((29360128 & i23) == 0) {
            if (startRestartGroup.changed((Object) mainAxisAlignment4)) {
                i14 = 8388608;
            } else {
                i14 = 4194304;
            }
            i12 |= i14;
        }
        if ((234881024 & i23) == 0) {
            if (startRestartGroup.changed((Object) function22)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i12 |= i13;
        }
        if ((191739611 & i12) != 38347922 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1567419051, i12, -1, "com.google.accompanist.flowlayout.Flow (Flow.kt:131)");
            }
            FlowKt$Flow$1 flowKt$Flow$1 = new FlowKt$Flow$1(layoutOrientation, f11, sizeMode, f12, mainAxisAlignment, mainAxisAlignment2, flowCrossAxisAlignment);
            startRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) startRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
            int i24 = (((((i12 << 3) & 112) | ((i12 >> 24) & 14)) << 9) & 7168) | 6;
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
            Composer r42 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r42, flowKt$Flow$1, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r42, density, companion.getSetDensity());
            Updater.m2543setimpl(r42, layoutDirection, companion.getSetLayoutDirection());
            Updater.m2543setimpl(r42, viewConfiguration, companion.getSetViewConfiguration());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i24 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            function22.invoke(startRestartGroup, Integer.valueOf((i24 >> 9) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new FlowKt$Flow$2(modifier, layoutOrientation, sizeMode, mainAxisAlignment, f11, flowCrossAxisAlignment, f12, mainAxisAlignment2, function2, i11));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x011a  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: FlowColumn-07r0xoM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m9015FlowColumn07r0xoM(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r26, @org.jetbrains.annotations.Nullable com.google.accompanist.flowlayout.SizeMode r27, @org.jetbrains.annotations.Nullable com.google.accompanist.flowlayout.MainAxisAlignment r28, float r29, @org.jetbrains.annotations.Nullable com.google.accompanist.flowlayout.FlowCrossAxisAlignment r30, float r31, @org.jetbrains.annotations.Nullable com.google.accompanist.flowlayout.MainAxisAlignment r32, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r11 = r33
            r12 = r35
            r13 = r36
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = 203669733(0xc23c0e5, float:1.261511E-31)
            r1 = r34
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x001e
            r2 = r12 | 6
            r3 = r2
            r2 = r26
            goto L_0x0032
        L_0x001e:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x002f
            r2 = r26
            boolean r3 = r14.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002c
            r3 = 4
            goto L_0x002d
        L_0x002c:
            r3 = 2
        L_0x002d:
            r3 = r3 | r12
            goto L_0x0032
        L_0x002f:
            r2 = r26
            r3 = r12
        L_0x0032:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x004c
        L_0x0039:
            r5 = r12 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004c
            r5 = r27
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0048
            r6 = 32
            goto L_0x004a
        L_0x0048:
            r6 = 16
        L_0x004a:
            r3 = r3 | r6
            goto L_0x004e
        L_0x004c:
            r5 = r27
        L_0x004e:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x0055
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r7 = r12 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0068
            r7 = r28
            boolean r8 = r14.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0064
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r3 = r3 | r8
            goto L_0x006a
        L_0x0068:
            r7 = r28
        L_0x006a:
            r8 = r13 & 8
            if (r8 == 0) goto L_0x0071
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0084
            r9 = r29
            boolean r10 = r14.changed((float) r9)
            if (r10 == 0) goto L_0x0080
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r3 = r3 | r10
            goto L_0x0086
        L_0x0084:
            r9 = r29
        L_0x0086:
            r10 = r13 & 16
            r15 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x0092
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            r15 = r30
            goto L_0x00a5
        L_0x0092:
            r16 = r12 & r15
            r15 = r30
            if (r16 != 0) goto L_0x00a5
            boolean r16 = r14.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00a1
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x00a1:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r3 = r3 | r16
        L_0x00a5:
            r16 = r13 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00b2
            r18 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r18
            r0 = r31
            goto L_0x00c5
        L_0x00b2:
            r18 = r12 & r17
            r0 = r31
            if (r18 != 0) goto L_0x00c5
            boolean r19 = r14.changed((float) r0)
            if (r19 == 0) goto L_0x00c1
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00c1:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00c3:
            r3 = r3 | r19
        L_0x00c5:
            r19 = 3670016(0x380000, float:5.142788E-39)
            r20 = r12 & r19
            if (r20 != 0) goto L_0x00df
            r20 = r13 & 64
            r0 = r32
            if (r20 != 0) goto L_0x00da
            boolean r20 = r14.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x00da
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dc
        L_0x00da:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00dc:
            r3 = r3 | r20
            goto L_0x00e1
        L_0x00df:
            r0 = r32
        L_0x00e1:
            r0 = r13 & 128(0x80, float:1.794E-43)
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            if (r0 == 0) goto L_0x00eb
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00e9:
            r3 = r3 | r0
            goto L_0x00fb
        L_0x00eb:
            r0 = r12 & r20
            if (r0 != 0) goto L_0x00fb
            boolean r0 = r14.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x00f8
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e9
        L_0x00f8:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00e9
        L_0x00fb:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r3
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x011a
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x010b
            goto L_0x011a
        L_0x010b:
            r14.skipToGroupEnd()
            r1 = r26
            r6 = r31
            r2 = r5
            r3 = r7
            r4 = r9
            r5 = r15
            r7 = r32
            goto L_0x01e2
        L_0x011a:
            r14.startDefaults()
            r0 = r12 & 1
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r0 == 0) goto L_0x0142
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x012b
            goto L_0x0142
        L_0x012b:
            r14.skipToGroupEnd()
            r0 = r13 & 64
            if (r0 == 0) goto L_0x0133
            r3 = r3 & r2
        L_0x0133:
            r24 = r31
            r25 = r32
            r16 = r5
            r21 = r7
            r22 = r9
            r23 = r15
            r15 = r26
            goto L_0x0186
        L_0x0142:
            if (r1 == 0) goto L_0x0147
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0149
        L_0x0147:
            r0 = r26
        L_0x0149:
            if (r4 == 0) goto L_0x014e
            com.google.accompanist.flowlayout.SizeMode r1 = com.google.accompanist.flowlayout.SizeMode.Wrap
            r5 = r1
        L_0x014e:
            if (r6 == 0) goto L_0x0153
            com.google.accompanist.flowlayout.MainAxisAlignment r1 = com.google.accompanist.flowlayout.MainAxisAlignment.Start
            r7 = r1
        L_0x0153:
            r1 = 0
            if (r8 == 0) goto L_0x015c
            float r4 = (float) r1
            float r4 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r4)
            r9 = r4
        L_0x015c:
            if (r10 == 0) goto L_0x0161
            com.google.accompanist.flowlayout.FlowCrossAxisAlignment r4 = com.google.accompanist.flowlayout.FlowCrossAxisAlignment.Start
            r15 = r4
        L_0x0161:
            if (r16 == 0) goto L_0x0169
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            goto L_0x016b
        L_0x0169:
            r1 = r31
        L_0x016b:
            r4 = r13 & 64
            if (r4 == 0) goto L_0x0179
            r3 = r3 & r2
            r24 = r1
            r16 = r5
            r21 = r7
            r25 = r21
            goto L_0x0181
        L_0x0179:
            r25 = r32
            r24 = r1
            r16 = r5
            r21 = r7
        L_0x0181:
            r22 = r9
            r23 = r15
            r15 = r0
        L_0x0186:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0198
            r0 = -1
            java.lang.String r1 = "com.google.accompanist.flowlayout.FlowColumn (Flow.kt:84)"
            r2 = 203669733(0xc23c0e5, float:1.261511E-31)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r3, r0, r1)
        L_0x0198:
            com.google.accompanist.flowlayout.LayoutOrientation r1 = com.google.accompanist.flowlayout.LayoutOrientation.Vertical
            r0 = r3 & 14
            r0 = r0 | 48
            int r2 = r3 << 3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = r2 & r17
            r0 = r0 | r3
            r3 = r2 & r19
            r0 = r0 | r3
            r3 = r2 & r20
            r0 = r0 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r3
            r10 = r0 | r2
            r0 = r15
            r2 = r16
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r33
            r9 = r14
            m9014FlowF4y8cZ0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01d5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01d5:
            r1 = r15
            r2 = r16
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
        L_0x01e2:
            androidx.compose.runtime.ScopeUpdateScope r14 = r14.endRestartGroup()
            if (r14 != 0) goto L_0x01e9
            goto L_0x01f8
        L_0x01e9:
            com.google.accompanist.flowlayout.FlowKt$FlowColumn$1 r15 = new com.google.accompanist.flowlayout.FlowKt$FlowColumn$1
            r0 = r15
            r8 = r33
            r9 = r35
            r10 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r14.updateScope(r15)
        L_0x01f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.accompanist.flowlayout.FlowKt.m9015FlowColumn07r0xoM(androidx.compose.ui.Modifier, com.google.accompanist.flowlayout.SizeMode, com.google.accompanist.flowlayout.MainAxisAlignment, float, com.google.accompanist.flowlayout.FlowCrossAxisAlignment, float, com.google.accompanist.flowlayout.MainAxisAlignment, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x011a  */
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    @androidx.compose.runtime.Composable
    /* renamed from: FlowRow-07r0xoM  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m9016FlowRow07r0xoM(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r26, @org.jetbrains.annotations.Nullable com.google.accompanist.flowlayout.SizeMode r27, @org.jetbrains.annotations.Nullable com.google.accompanist.flowlayout.MainAxisAlignment r28, float r29, @org.jetbrains.annotations.Nullable com.google.accompanist.flowlayout.FlowCrossAxisAlignment r30, float r31, @org.jetbrains.annotations.Nullable com.google.accompanist.flowlayout.MainAxisAlignment r32, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r11 = r33
            r12 = r35
            r13 = r36
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -137566119(0xfffffffff7cce859, float:-8.31204E33)
            r1 = r34
            androidx.compose.runtime.Composer r14 = r1.startRestartGroup(r0)
            r1 = r13 & 1
            if (r1 == 0) goto L_0x001e
            r2 = r12 | 6
            r3 = r2
            r2 = r26
            goto L_0x0032
        L_0x001e:
            r2 = r12 & 14
            if (r2 != 0) goto L_0x002f
            r2 = r26
            boolean r3 = r14.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x002c
            r3 = 4
            goto L_0x002d
        L_0x002c:
            r3 = 2
        L_0x002d:
            r3 = r3 | r12
            goto L_0x0032
        L_0x002f:
            r2 = r26
            r3 = r12
        L_0x0032:
            r4 = r13 & 2
            if (r4 == 0) goto L_0x0039
            r3 = r3 | 48
            goto L_0x004c
        L_0x0039:
            r5 = r12 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x004c
            r5 = r27
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x0048
            r6 = 32
            goto L_0x004a
        L_0x0048:
            r6 = 16
        L_0x004a:
            r3 = r3 | r6
            goto L_0x004e
        L_0x004c:
            r5 = r27
        L_0x004e:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x0055
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x0068
        L_0x0055:
            r7 = r12 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x0068
            r7 = r28
            boolean r8 = r14.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0064
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r3 = r3 | r8
            goto L_0x006a
        L_0x0068:
            r7 = r28
        L_0x006a:
            r8 = r13 & 8
            if (r8 == 0) goto L_0x0071
            r3 = r3 | 3072(0xc00, float:4.305E-42)
            goto L_0x0084
        L_0x0071:
            r9 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0084
            r9 = r29
            boolean r10 = r14.changed((float) r9)
            if (r10 == 0) goto L_0x0080
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0082
        L_0x0080:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0082:
            r3 = r3 | r10
            goto L_0x0086
        L_0x0084:
            r9 = r29
        L_0x0086:
            r10 = r13 & 16
            r15 = 57344(0xe000, float:8.0356E-41)
            if (r10 == 0) goto L_0x0092
            r3 = r3 | 24576(0x6000, float:3.4438E-41)
            r15 = r30
            goto L_0x00a5
        L_0x0092:
            r16 = r12 & r15
            r15 = r30
            if (r16 != 0) goto L_0x00a5
            boolean r16 = r14.changed((java.lang.Object) r15)
            if (r16 == 0) goto L_0x00a1
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a3
        L_0x00a1:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x00a3:
            r3 = r3 | r16
        L_0x00a5:
            r16 = r13 & 32
            r17 = 458752(0x70000, float:6.42848E-40)
            if (r16 == 0) goto L_0x00b2
            r18 = 196608(0x30000, float:2.75506E-40)
            r3 = r3 | r18
            r0 = r31
            goto L_0x00c5
        L_0x00b2:
            r18 = r12 & r17
            r0 = r31
            if (r18 != 0) goto L_0x00c5
            boolean r19 = r14.changed((float) r0)
            if (r19 == 0) goto L_0x00c1
            r19 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c3
        L_0x00c1:
            r19 = 65536(0x10000, float:9.18355E-41)
        L_0x00c3:
            r3 = r3 | r19
        L_0x00c5:
            r19 = 3670016(0x380000, float:5.142788E-39)
            r20 = r12 & r19
            if (r20 != 0) goto L_0x00df
            r20 = r13 & 64
            r0 = r32
            if (r20 != 0) goto L_0x00da
            boolean r20 = r14.changed((java.lang.Object) r0)
            if (r20 == 0) goto L_0x00da
            r20 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00dc
        L_0x00da:
            r20 = 524288(0x80000, float:7.34684E-40)
        L_0x00dc:
            r3 = r3 | r20
            goto L_0x00e1
        L_0x00df:
            r0 = r32
        L_0x00e1:
            r0 = r13 & 128(0x80, float:1.794E-43)
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            if (r0 == 0) goto L_0x00eb
            r0 = 12582912(0xc00000, float:1.7632415E-38)
        L_0x00e9:
            r3 = r3 | r0
            goto L_0x00fb
        L_0x00eb:
            r0 = r12 & r20
            if (r0 != 0) goto L_0x00fb
            boolean r0 = r14.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x00f8
            r0 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00e9
        L_0x00f8:
            r0 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x00e9
        L_0x00fb:
            r0 = 23967451(0x16db6db, float:4.3661218E-38)
            r0 = r0 & r3
            r2 = 4793490(0x492492, float:6.71711E-39)
            if (r0 != r2) goto L_0x011a
            boolean r0 = r14.getSkipping()
            if (r0 != 0) goto L_0x010b
            goto L_0x011a
        L_0x010b:
            r14.skipToGroupEnd()
            r1 = r26
            r6 = r31
            r2 = r5
            r3 = r7
            r4 = r9
            r5 = r15
            r7 = r32
            goto L_0x01e2
        L_0x011a:
            r14.startDefaults()
            r0 = r12 & 1
            r2 = -3670017(0xffffffffffc7ffff, float:NaN)
            if (r0 == 0) goto L_0x0142
            boolean r0 = r14.getDefaultsInvalid()
            if (r0 == 0) goto L_0x012b
            goto L_0x0142
        L_0x012b:
            r14.skipToGroupEnd()
            r0 = r13 & 64
            if (r0 == 0) goto L_0x0133
            r3 = r3 & r2
        L_0x0133:
            r24 = r31
            r25 = r32
            r16 = r5
            r21 = r7
            r22 = r9
            r23 = r15
            r15 = r26
            goto L_0x0186
        L_0x0142:
            if (r1 == 0) goto L_0x0147
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            goto L_0x0149
        L_0x0147:
            r0 = r26
        L_0x0149:
            if (r4 == 0) goto L_0x014e
            com.google.accompanist.flowlayout.SizeMode r1 = com.google.accompanist.flowlayout.SizeMode.Wrap
            r5 = r1
        L_0x014e:
            if (r6 == 0) goto L_0x0153
            com.google.accompanist.flowlayout.MainAxisAlignment r1 = com.google.accompanist.flowlayout.MainAxisAlignment.Start
            r7 = r1
        L_0x0153:
            r1 = 0
            if (r8 == 0) goto L_0x015c
            float r4 = (float) r1
            float r4 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r4)
            r9 = r4
        L_0x015c:
            if (r10 == 0) goto L_0x0161
            com.google.accompanist.flowlayout.FlowCrossAxisAlignment r4 = com.google.accompanist.flowlayout.FlowCrossAxisAlignment.Start
            r15 = r4
        L_0x0161:
            if (r16 == 0) goto L_0x0169
            float r1 = (float) r1
            float r1 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r1)
            goto L_0x016b
        L_0x0169:
            r1 = r31
        L_0x016b:
            r4 = r13 & 64
            if (r4 == 0) goto L_0x0179
            r3 = r3 & r2
            r24 = r1
            r16 = r5
            r21 = r7
            r25 = r21
            goto L_0x0181
        L_0x0179:
            r25 = r32
            r24 = r1
            r16 = r5
            r21 = r7
        L_0x0181:
            r22 = r9
            r23 = r15
            r15 = r0
        L_0x0186:
            r14.endDefaults()
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x0198
            r0 = -1
            java.lang.String r1 = "com.google.accompanist.flowlayout.FlowRow (Flow.kt:46)"
            r2 = -137566119(0xfffffffff7cce859, float:-8.31204E33)
            androidx.compose.runtime.ComposerKt.traceEventStart(r2, r3, r0, r1)
        L_0x0198:
            com.google.accompanist.flowlayout.LayoutOrientation r1 = com.google.accompanist.flowlayout.LayoutOrientation.Horizontal
            r0 = r3 & 14
            r0 = r0 | 48
            int r2 = r3 << 3
            r3 = r2 & 896(0x380, float:1.256E-42)
            r0 = r0 | r3
            r3 = r2 & 7168(0x1c00, float:1.0045E-41)
            r0 = r0 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r2
            r0 = r0 | r3
            r3 = r2 & r17
            r0 = r0 | r3
            r3 = r2 & r19
            r0 = r0 | r3
            r3 = r2 & r20
            r0 = r0 | r3
            r3 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r3
            r10 = r0 | r2
            r0 = r15
            r2 = r16
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
            r8 = r33
            r9 = r14
            m9014FlowF4y8cZ0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            boolean r0 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r0 == 0) goto L_0x01d5
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x01d5:
            r1 = r15
            r2 = r16
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            r7 = r25
        L_0x01e2:
            androidx.compose.runtime.ScopeUpdateScope r14 = r14.endRestartGroup()
            if (r14 != 0) goto L_0x01e9
            goto L_0x01f8
        L_0x01e9:
            com.google.accompanist.flowlayout.FlowKt$FlowRow$1 r15 = new com.google.accompanist.flowlayout.FlowKt$FlowRow$1
            r0 = r15
            r8 = r33
            r9 = r35
            r10 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r14.updateScope(r15)
        L_0x01f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.accompanist.flowlayout.FlowKt.m9016FlowRow07r0xoM(androidx.compose.ui.Modifier, com.google.accompanist.flowlayout.SizeMode, com.google.accompanist.flowlayout.MainAxisAlignment, float, com.google.accompanist.flowlayout.FlowCrossAxisAlignment, float, com.google.accompanist.flowlayout.MainAxisAlignment, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final int Flow_F4y8cZ0$crossAxisSize(Placeable placeable, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getHeight() : placeable.getWidth();
    }

    /* access modifiers changed from: private */
    public static final int Flow_F4y8cZ0$mainAxisSize(Placeable placeable, LayoutOrientation layoutOrientation) {
        return layoutOrientation == LayoutOrientation.Horizontal ? placeable.getWidth() : placeable.getHeight();
    }
}
