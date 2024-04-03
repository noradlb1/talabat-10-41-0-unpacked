package com.designsystem.ds_stepper;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.annotation.DrawableRes;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.CardKt;
import androidx.compose.material.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import com.designsystem.ds_spinner.DSSpinnerColor;
import com.designsystem.ds_spinner.DSSpinnerKt;
import com.designsystem.ds_spinner.DSSpinnerSize;
import com.designsystem.ds_theme.DSTheme;
import com.designsystem.marshmallow.R;
import com.google.android.exoplayer2.RendererCapabilities;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.bytebuddy.jar.asm.Opcodes;

@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aY\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a%\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001aM\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001c\u001a\r\u0010\u001d\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001e\u001a\u0001\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0002\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#2\u0016\b\u0002\u0010&\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0001\u0018\u00010'2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u001aH\u0001¢\u0006\u0002\u0010.\u001aO\u0010/\u001a\u00020\u00012\b\b\u0001\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u00020\u00122\u0006\u00103\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105\u001a\r\u00106\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001e\u001a{\u00107\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u00108\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010:\u001aI\u0010;\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u00108\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0003¢\u0006\u0002\u0010>\u001a3\u0010?\u001a\u00020\u00012\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u001a2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0003¢\u0006\u0002\u0010F\u001a\u0010\u0010G\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a\u0011\u0010H\u001a\u00020!*\u00020\u0018H\u0003¢\u0006\u0002\u0010I\u001a8\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00070K*\b\u0012\u0004\u0012\u00020\u001a0L2\u0006\u0010M\u001a\u00020\u001a2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0003ø\u0001\u0000¢\u0006\u0002\u0010N\u001a(\u0010O\u001a\b\u0012\u0004\u0012\u00020\u00070K*\b\u0012\u0004\u0012\u00020\u001a0L2\u0006\u0010\u0004\u001a\u00020\u0005H\u0003ø\u0001\u0000¢\u0006\u0002\u0010P\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006Q"}, d2 = {"CollapsedStepperBackground", "", "stepperValues", "Lcom/designsystem/ds_stepper/StepperValues;", "style", "Lcom/designsystem/ds_stepper/DSStepperStyle;", "fontColor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "mm2Properties", "Lcom/designsystem/ds_stepper/MM2Properties;", "expandCollapsedStepper", "Lkotlin/Function0;", "expandCollapsedStepperAndIncrement", "CollapsedStepperBackground-Y0xEhic", "(Lcom/designsystem/ds_stepper/StepperValues;Lcom/designsystem/ds_stepper/DSStepperStyle;JJLcom/designsystem/ds_stepper/MM2Properties;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "DummyStepperWidth", "maxWidth", "Landroidx/compose/ui/unit/Dp;", "minWidth", "DummyStepperWidth-i1RSzL4", "(FFLandroidx/compose/runtime/Composer;I)V", "ExpandedStepperBackground", "scope", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "shouldShowBinIcon", "", "ExpandedStepperBackground-jB83MbM", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Lcom/designsystem/ds_stepper/StepperValues;Lcom/designsystem/ds_stepper/DSStepperStyle;JJLcom/designsystem/ds_stepper/MM2Properties;ZLandroidx/compose/runtime/Composer;I)V", "MockStepperCounter", "(Landroidx/compose/runtime/Composer;I)V", "Stepper", "modifier", "Landroidx/compose/ui/Modifier;", "min", "", "max", "initialValue", "onValueChanged", "Lkotlin/Function1;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "canCollapse", "isLoading", "isEnabled", "isMM2", "(Landroidx/compose/ui/Modifier;IIILkotlin/jvm/functions/Function1;ZLandroidx/compose/ui/Alignment$Horizontal;ZZZLcom/designsystem/ds_stepper/DSStepperStyle;ZLandroidx/compose/runtime/Composer;III)V", "StepperIconArea", "icon", "isTappable", "paddingStart", "paddingEnd", "StepperIconArea-1yyLQnY", "(IZFFZZLcom/designsystem/ds_stepper/DSStepperStyle;Landroidx/compose/runtime/Composer;I)V", "StepperSpinner", "StepperStaticIconsBackgroundLayer", "isCollapsed", "StepperStaticIconsBackgroundLayer-DTdxfFs", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/ui/Alignment$Horizontal;Lcom/designsystem/ds_stepper/MM2Properties;Lcom/designsystem/ds_stepper/DSStepperStyle;JZLcom/designsystem/ds_stepper/StepperValues;JZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "StepperTappableForegroundLayer", "onDecreased", "onIncreased", "(Landroidx/compose/ui/Modifier;ZLcom/designsystem/ds_stepper/StepperValues;Lcom/designsystem/ds_stepper/MM2Properties;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "TappableArea", "view", "Landroid/view/View;", "testTag", "", "isClickable", "onTap", "(Landroid/view/View;Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "getDecrementIcon", "GetStepperWidthModifier", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "animateBackgroundColor", "Landroidx/compose/runtime/State;", "Landroidx/compose/animation/core/Transition;", "displayCollapsedPlusIcon", "(Landroidx/compose/animation/core/Transition;ZLcom/designsystem/ds_stepper/DSStepperStyle;Lcom/designsystem/ds_stepper/MM2Properties;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "animateFontColor", "(Landroidx/compose/animation/core/Transition;Lcom/designsystem/ds_stepper/DSStepperStyle;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class StepperComposablesKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v0, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* renamed from: CollapsedStepperBackground-Y0xEhic  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8593CollapsedStepperBackgroundY0xEhic(com.designsystem.ds_stepper.StepperValues r27, com.designsystem.ds_stepper.DSStepperStyle r28, long r29, long r31, com.designsystem.ds_stepper.MM2Properties r33, kotlin.jvm.functions.Function0<kotlin.Unit> r34, kotlin.jvm.functions.Function0<kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37) {
        /*
            r11 = r28
            r12 = r33
            r13 = r35
            r14 = r37
            r0 = -1659293149(0xffffffff9d193223, float:-2.0275301E-21)
            r1 = r36
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            r0 = r14 & 14
            r9 = r27
            if (r0 != 0) goto L_0x0022
            boolean r0 = r10.changed((java.lang.Object) r9)
            if (r0 == 0) goto L_0x001f
            r0 = 4
            goto L_0x0020
        L_0x001f:
            r0 = 2
        L_0x0020:
            r0 = r0 | r14
            goto L_0x0023
        L_0x0022:
            r0 = r14
        L_0x0023:
            r1 = r14 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0033
            boolean r1 = r10.changed((java.lang.Object) r11)
            if (r1 == 0) goto L_0x0030
            r1 = 32
            goto L_0x0032
        L_0x0030:
            r1 = 16
        L_0x0032:
            r0 = r0 | r1
        L_0x0033:
            r1 = r14 & 896(0x380, float:1.256E-42)
            r7 = r29
            if (r1 != 0) goto L_0x0045
            boolean r1 = r10.changed((long) r7)
            if (r1 == 0) goto L_0x0042
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x0044
        L_0x0042:
            r1 = 128(0x80, float:1.794E-43)
        L_0x0044:
            r0 = r0 | r1
        L_0x0045:
            r1 = r14 & 7168(0x1c00, float:1.0045E-41)
            r4 = r31
            if (r1 != 0) goto L_0x0057
            boolean r1 = r10.changed((long) r4)
            if (r1 == 0) goto L_0x0054
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x0056
        L_0x0054:
            r1 = 1024(0x400, float:1.435E-42)
        L_0x0056:
            r0 = r0 | r1
        L_0x0057:
            r1 = 57344(0xe000, float:8.0356E-41)
            r2 = r14 & r1
            if (r2 != 0) goto L_0x006a
            boolean r2 = r10.changed((java.lang.Object) r12)
            if (r2 == 0) goto L_0x0067
            r2 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0069
        L_0x0067:
            r2 = 8192(0x2000, float:1.14794E-41)
        L_0x0069:
            r0 = r0 | r2
        L_0x006a:
            r2 = 458752(0x70000, float:6.42848E-40)
            r3 = r14 & r2
            r6 = r34
            if (r3 != 0) goto L_0x007e
            boolean r3 = r10.changed((java.lang.Object) r6)
            if (r3 == 0) goto L_0x007b
            r3 = 131072(0x20000, float:1.83671E-40)
            goto L_0x007d
        L_0x007b:
            r3 = 65536(0x10000, float:9.18355E-41)
        L_0x007d:
            r0 = r0 | r3
        L_0x007e:
            r3 = 3670016(0x380000, float:5.142788E-39)
            r15 = r14 & r3
            if (r15 != 0) goto L_0x0090
            boolean r15 = r10.changed((java.lang.Object) r13)
            if (r15 == 0) goto L_0x008d
            r15 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x008f
        L_0x008d:
            r15 = 524288(0x80000, float:7.34684E-40)
        L_0x008f:
            r0 = r0 | r15
        L_0x0090:
            r15 = 2995931(0x2db6db, float:4.198194E-39)
            r15 = r15 & r0
            r16 = 599186(0x92492, float:8.39638E-40)
            r15 = r15 ^ r16
            if (r15 != 0) goto L_0x00a8
            boolean r15 = r10.getSkipping()
            if (r15 != 0) goto L_0x00a2
            goto L_0x00a8
        L_0x00a2:
            r10.skipToGroupEnd()
        L_0x00a5:
            r15 = r10
            goto L_0x015e
        L_0x00a8:
            int r15 = r27.getValue()
            int r3 = r27.getMin()
            if (r15 != r3) goto L_0x0128
            r1 = -1659292826(0xffffffff9d193366, float:-2.0275954E-21)
            r10.startReplaceableGroup(r1)
            androidx.compose.ui.Modifier$Companion r15 = androidx.compose.ui.Modifier.Companion
            boolean r18 = r33.isClickable()
            androidx.compose.foundation.interaction.MutableInteractionSource r16 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r17 = 0
            r19 = 0
            r20 = 0
            r1 = -3686930(0xffffffffffc7bdee, float:NaN)
            r10.startReplaceableGroup(r1)
            boolean r1 = r10.changed((java.lang.Object) r13)
            java.lang.Object r2 = r10.rememberedValue()
            if (r1 != 0) goto L_0x00e0
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x00e8
        L_0x00e0:
            com.designsystem.ds_stepper.StepperComposablesKt$CollapsedStepperBackground$1$1 r2 = new com.designsystem.ds_stepper.StepperComposablesKt$CollapsedStepperBackground$1$1
            r2.<init>(r13)
            r10.updateRememberedValue(r2)
        L_0x00e8:
            r10.endReplaceableGroup()
            r21 = r2
            kotlin.jvm.functions.Function0 r21 = (kotlin.jvm.functions.Function0) r21
            r22 = 24
            r23 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r15, r16, r17, r18, r19, r20, r21, r22, r23)
            java.lang.String r2 = "StepperQuantityPlusSignTestTag"
            androidx.compose.ui.Modifier r15 = androidx.compose.ui.platform.TestTagKt.testTag(r1, r2)
            r16 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            com.designsystem.ds_stepper.StepperComposablesKt$CollapsedStepperBackground$2 r1 = new com.designsystem.ds_stepper.StepperComposablesKt$CollapsedStepperBackground$2
            r1.<init>(r12, r11, r0)
            r2 = -819902016(0xffffffffcf2149c0, float:-2.70596506E9)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r23 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r2, r3, r1)
            int r0 = r0 >> 3
            r0 = r0 & 896(0x380, float:1.256E-42)
            r1 = 1572864(0x180000, float:2.204052E-39)
            r25 = r0 | r1
            r26 = 58
            r17 = r31
            r24 = r10
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r15, r16, r17, r19, r21, r22, r23, r24, r25, r26)
            r10.endReplaceableGroup()
            goto L_0x00a5
        L_0x0128:
            r3 = -1659291961(0xffffffff9d1936c7, float:-2.02777E-21)
            r10.startReplaceableGroup(r3)
            int r15 = r27.getValue()
            r3 = r0 & 896(0x380, float:1.256E-42)
            r3 = r3 | 6
            r2 = r0 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r3
            int r3 = r0 << 9
            r1 = r1 & r3
            r1 = r1 | r2
            int r0 = r0 << 3
            r2 = 458752(0x70000, float:6.42848E-40)
            r2 = r2 & r0
            r1 = r1 | r2
            r2 = 3670016(0x380000, float:5.142788E-39)
            r0 = r0 & r2
            r17 = r1 | r0
            r0 = 1
            r1 = r15
            r2 = r29
            r4 = r31
            r6 = r28
            r7 = r33
            r8 = r34
            r9 = r10
            r15 = r10
            r10 = r17
            com.designsystem.ds_stepper.StepperCounterComposablesKt.m8619StepperCounterY0xEhic(r0, r1, r2, r4, r6, r7, r8, r9, r10)
            r15.endReplaceableGroup()
        L_0x015e:
            androidx.compose.runtime.ScopeUpdateScope r15 = r15.endRestartGroup()
            if (r15 != 0) goto L_0x0165
            goto L_0x017f
        L_0x0165:
            com.designsystem.ds_stepper.StepperComposablesKt$CollapsedStepperBackground$3 r10 = new com.designsystem.ds_stepper.StepperComposablesKt$CollapsedStepperBackground$3
            r0 = r10
            r1 = r27
            r2 = r28
            r3 = r29
            r5 = r31
            r7 = r33
            r8 = r34
            r9 = r35
            r11 = r10
            r10 = r37
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10)
            r15.updateScope(r11)
        L_0x017f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_stepper.StepperComposablesKt.m8593CollapsedStepperBackgroundY0xEhic(com.designsystem.ds_stepper.StepperValues, com.designsystem.ds_stepper.DSStepperStyle, long, long, com.designsystem.ds_stepper.MM2Properties, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    @Composable
    /* renamed from: DummyStepperWidth-i1RSzL4  reason: not valid java name */
    public static final void m8594DummyStepperWidthi1RSzL4(float f11, float f12, Composer composer, int i11) {
        int i12;
        Modifier modifier;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(1236306228);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed(f11)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed(f12)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            if (Dp.m5477compareTo0680j_4(f12, Dp.m5478constructorimpl((float) 116)) < 0) {
                modifier = SizeKt.m563width3ABfNKs(Modifier.Companion, Dp.m5478constructorimpl((float) 96));
            } else {
                modifier = SizeKt.m563width3ABfNKs(Modifier.Companion, f11);
            }
            startRestartGroup.startReplaceableGroup(-1989997546);
            Modifier.Companion companion = Modifier.Companion;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(companion);
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
            Updater.m2543setimpl(r72, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m2543setimpl(r72, density, companion2.getSetDensity());
            Updater.m2543setimpl(r72, layoutDirection, companion2.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-326682743);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            BoxKt.Box(SizeKt.m544height3ABfNKs(modifier, Dp.m5478constructorimpl((float) 48)), startRestartGroup, 0);
            MockStepperCounter(startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new StepperComposablesKt$DummyStepperWidth$2(f11, f12, i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    /* renamed from: ExpandedStepperBackground-jB83MbM  reason: not valid java name */
    public static final void m8595ExpandedStepperBackgroundjB83MbM(BoxWithConstraintsScope boxWithConstraintsScope, StepperValues stepperValues, DSStepperStyle dSStepperStyle, long j11, long j12, MM2Properties mM2Properties, boolean z11, Composer composer, int i11) {
        int i12;
        boolean z12;
        boolean z13;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        BoxWithConstraintsScope boxWithConstraintsScope2 = boxWithConstraintsScope;
        int i21 = i11;
        Composer startRestartGroup = composer.startRestartGroup(1530476624);
        if ((i21 & 14) == 0) {
            if (startRestartGroup.changed((Object) boxWithConstraintsScope2)) {
                i19 = 4;
            } else {
                i19 = 2;
            }
            i12 = i19 | i21;
        } else {
            i12 = i21;
        }
        if ((i21 & 112) == 0) {
            if (startRestartGroup.changed((Object) stepperValues)) {
                i18 = 32;
            } else {
                i18 = 16;
            }
            i12 |= i18;
        } else {
            StepperValues stepperValues2 = stepperValues;
        }
        if ((i21 & 896) == 0) {
            if (startRestartGroup.changed((Object) dSStepperStyle)) {
                i17 = 256;
            } else {
                i17 = 128;
            }
            i12 |= i17;
        } else {
            DSStepperStyle dSStepperStyle2 = dSStepperStyle;
        }
        if ((i21 & 7168) == 0) {
            if (startRestartGroup.changed(j11)) {
                i16 = 2048;
            } else {
                i16 = 1024;
            }
            i12 |= i16;
        } else {
            long j13 = j11;
        }
        if ((i21 & 57344) == 0) {
            if (startRestartGroup.changed(j12)) {
                i15 = 16384;
            } else {
                i15 = 8192;
            }
            i12 |= i15;
        } else {
            long j14 = j12;
        }
        MM2Properties mM2Properties2 = mM2Properties;
        if ((i21 & Opcodes.ASM7) == 0) {
            if (startRestartGroup.changed((Object) mM2Properties2)) {
                i14 = 131072;
            } else {
                i14 = 65536;
            }
            i12 |= i14;
        }
        boolean z14 = z11;
        if ((i21 & 3670016) == 0) {
            if (startRestartGroup.changed(z14)) {
                i13 = 1048576;
            } else {
                i13 = 524288;
            }
            i12 |= i13;
        }
        if (((2995931 & i12) ^ 599186) != 0 || !startRestartGroup.getSkipping()) {
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
            Modifier GetStepperWidthModifier = GetStepperWidthModifier(boxWithConstraintsScope2, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(-1989997546);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(GetStepperWidthModifier);
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
            Composer r32 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r32, rowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r32, density, companion.getSetDensity());
            Updater.m2543setimpl(r32, layoutDirection, companion.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-326682743);
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            int decrementIcon = getDecrementIcon(z11);
            if (stepperValues.getValue() != stepperValues.getMin()) {
                z12 = true;
            } else {
                z12 = false;
            }
            DSTheme dSTheme = DSTheme.INSTANCE;
            float f11 = (float) 0;
            int i22 = (i12 << 12) & 3670016;
            m8604StepperIconArea1yyLQnY(decrementIcon, z12, dSTheme.getDimens(startRestartGroup, 0).m8846getDsXxsD9Ej5fM(), Dp.m5478constructorimpl(f11), mM2Properties.isEnabled(), mM2Properties.isMM2(), dSStepperStyle, startRestartGroup, i22 | KfsConstant.KFS_RSA_KEY_LEN_3072);
            if (!mM2Properties.isLoading() || !mM2Properties.isEnabled()) {
                startRestartGroup.startReplaceableGroup(-1011569250);
                int i23 = i12 >> 3;
                long j15 = j11;
                long j16 = j12;
                DSStepperStyle dSStepperStyle3 = dSStepperStyle;
                MM2Properties mM2Properties3 = mM2Properties;
                Composer composer2 = startRestartGroup;
                StepperCounterComposablesKt.m8619StepperCounterY0xEhic(false, stepperValues.getValue(), j15, j16, dSStepperStyle3, mM2Properties3, StepperComposablesKt$ExpandedStepperBackground$1$1$1.INSTANCE, composer2, (i23 & 7168) | (i23 & 896) | 6 | ((i12 << 6) & 57344) | (i12 & Opcodes.ASM7));
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-1011569296);
                StepperSpinner(startRestartGroup, 0);
                startRestartGroup.endReplaceableGroup();
            }
            int i24 = R.drawable.ds_plus;
            if (stepperValues.getValue() != stepperValues.getMax()) {
                z13 = true;
            } else {
                z13 = false;
            }
            m8604StepperIconArea1yyLQnY(i24, z13, Dp.m5478constructorimpl(f11), dSTheme.getDimens(startRestartGroup, 0).m8846getDsXxsD9Ej5fM(), mM2Properties.isEnabled(), mM2Properties.isMM2(), dSStepperStyle, startRestartGroup, i22 | RendererCapabilities.MODE_SUPPORT_MASK);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new StepperComposablesKt$ExpandedStepperBackground$2(boxWithConstraintsScope, stepperValues, dSStepperStyle, j11, j12, mM2Properties, z11, i11));
        }
    }

    @Composable
    private static final Modifier GetStepperWidthModifier(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer, int i11) {
        Modifier modifier;
        composer.startReplaceableGroup(-518530397);
        float f11 = (float) 116;
        if (Dp.m5477compareTo0680j_4(boxWithConstraintsScope.m438getMinWidthD9Ej5fM(), Dp.m5478constructorimpl(f11)) < 0) {
            modifier = SizeKt.m563width3ABfNKs(Modifier.Companion, Dp.m5478constructorimpl(f11));
        } else {
            modifier = SizeKt.m563width3ABfNKs(Modifier.Companion, boxWithConstraintsScope.m436getMaxWidthD9Ej5fM());
        }
        composer.endReplaceableGroup();
        return modifier;
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void MockStepperCounter(Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-994630332);
        if (i11 != 0 || !startRestartGroup.getSkipping()) {
            Modifier wrapContentWidth$default = SizeKt.wrapContentWidth$default(Modifier.Companion, (Alignment.Horizontal) null, false, 3, (Object) null);
            startRestartGroup.startReplaceableGroup(-1990474327);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(wrapContentWidth$default);
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
            Composer r62 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r62, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r62, density, companion.getSetDensity());
            Updater.m2543setimpl(r62, layoutDirection, companion.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            AndroidView_androidKt.AndroidView(StepperComposablesKt$MockStepperCounter$1$1.INSTANCE, (Modifier) null, (Function1) null, startRestartGroup, 0, 6);
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new StepperComposablesKt$MockStepperCounter$2(i11));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0315  */
    /* JADX WARNING: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x012e  */
    @android.annotation.SuppressLint({"MissingPermission"})
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void Stepper(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r37, int r38, int r39, int r40, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r41, boolean r42, @org.jetbrains.annotations.Nullable androidx.compose.ui.Alignment.Horizontal r43, boolean r44, boolean r45, boolean r46, @org.jetbrains.annotations.NotNull com.designsystem.ds_stepper.DSStepperStyle r47, boolean r48, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r49, int r50, int r51, int r52) {
        /*
            r15 = r37
            r14 = r45
            r13 = r46
            r12 = r47
            r10 = r48
            r8 = r50
            r7 = r52
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "style"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = -1892915693(0xffffffff8f2c6613, float:-8.4999135E-30)
            r1 = r49
            androidx.compose.runtime.Composer r6 = r1.startRestartGroup(r0)
            r0 = r7 & 1
            if (r0 == 0) goto L_0x0028
            r0 = r8 | 6
            goto L_0x0038
        L_0x0028:
            r0 = r8 & 14
            if (r0 != 0) goto L_0x0037
            boolean r0 = r6.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0034
            r0 = 4
            goto L_0x0035
        L_0x0034:
            r0 = 2
        L_0x0035:
            r0 = r0 | r8
            goto L_0x0038
        L_0x0037:
            r0 = r8
        L_0x0038:
            r3 = r7 & 2
            if (r3 == 0) goto L_0x003f
            r0 = r0 | 48
            goto L_0x0052
        L_0x003f:
            r9 = r8 & 112(0x70, float:1.57E-43)
            if (r9 != 0) goto L_0x0052
            r9 = r38
            boolean r11 = r6.changed((int) r9)
            if (r11 == 0) goto L_0x004e
            r11 = 32
            goto L_0x0050
        L_0x004e:
            r11 = 16
        L_0x0050:
            r0 = r0 | r11
            goto L_0x0054
        L_0x0052:
            r9 = r38
        L_0x0054:
            r11 = r7 & 4
            if (r11 == 0) goto L_0x005b
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006f
        L_0x005b:
            r1 = r8 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x006f
            r1 = r39
            boolean r16 = r6.changed((int) r1)
            if (r16 == 0) goto L_0x006a
            r16 = 256(0x100, float:3.59E-43)
            goto L_0x006c
        L_0x006a:
            r16 = 128(0x80, float:1.794E-43)
        L_0x006c:
            r0 = r0 | r16
            goto L_0x0071
        L_0x006f:
            r1 = r39
        L_0x0071:
            r16 = r7 & 8
            if (r16 == 0) goto L_0x0078
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x008c
        L_0x0078:
            r4 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x008c
            r4 = r40
            boolean r17 = r6.changed((int) r4)
            if (r17 == 0) goto L_0x0087
            r17 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r17 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r0 = r0 | r17
            goto L_0x008e
        L_0x008c:
            r4 = r40
        L_0x008e:
            r17 = r7 & 16
            if (r17 == 0) goto L_0x0097
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r5 = r41
            goto L_0x00ad
        L_0x0097:
            r18 = 57344(0xe000, float:8.0356E-41)
            r18 = r8 & r18
            r5 = r41
            if (r18 != 0) goto L_0x00ad
            boolean r19 = r6.changed((java.lang.Object) r5)
            if (r19 == 0) goto L_0x00a9
            r19 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00ab
        L_0x00a9:
            r19 = 8192(0x2000, float:1.14794E-41)
        L_0x00ab:
            r0 = r0 | r19
        L_0x00ad:
            r19 = r7 & 32
            if (r19 == 0) goto L_0x00b8
            r20 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r20
            r2 = r42
            goto L_0x00cd
        L_0x00b8:
            r20 = 458752(0x70000, float:6.42848E-40)
            r20 = r8 & r20
            r2 = r42
            if (r20 != 0) goto L_0x00cd
            boolean r21 = r6.changed((boolean) r2)
            if (r21 == 0) goto L_0x00c9
            r21 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00cb
        L_0x00c9:
            r21 = 65536(0x10000, float:9.18355E-41)
        L_0x00cb:
            r0 = r0 | r21
        L_0x00cd:
            r21 = r7 & 64
            if (r21 == 0) goto L_0x00d8
            r22 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r22
            r1 = r43
            goto L_0x00ed
        L_0x00d8:
            r22 = 3670016(0x380000, float:5.142788E-39)
            r22 = r8 & r22
            r1 = r43
            if (r22 != 0) goto L_0x00ed
            boolean r22 = r6.changed((java.lang.Object) r1)
            if (r22 == 0) goto L_0x00e9
            r22 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00eb
        L_0x00e9:
            r22 = 524288(0x80000, float:7.34684E-40)
        L_0x00eb:
            r0 = r0 | r22
        L_0x00ed:
            r1 = r7 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x00f8
            r22 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r22
            r2 = r44
            goto L_0x010d
        L_0x00f8:
            r22 = 29360128(0x1c00000, float:7.052966E-38)
            r22 = r8 & r22
            r2 = r44
            if (r22 != 0) goto L_0x010d
            boolean r22 = r6.changed((boolean) r2)
            if (r22 == 0) goto L_0x0109
            r22 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x010b
        L_0x0109:
            r22 = 4194304(0x400000, float:5.877472E-39)
        L_0x010b:
            r0 = r0 | r22
        L_0x010d:
            r2 = r7 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0115
            r2 = 100663296(0x6000000, float:2.4074124E-35)
        L_0x0113:
            r0 = r0 | r2
            goto L_0x0126
        L_0x0115:
            r2 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r8
            if (r2 != 0) goto L_0x0126
            boolean r2 = r6.changed((boolean) r14)
            if (r2 == 0) goto L_0x0123
            r2 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0113
        L_0x0123:
            r2 = 33554432(0x2000000, float:9.403955E-38)
            goto L_0x0113
        L_0x0126:
            r2 = r7 & 512(0x200, float:7.175E-43)
            if (r2 == 0) goto L_0x012e
            r2 = 805306368(0x30000000, float:4.656613E-10)
        L_0x012c:
            r0 = r0 | r2
            goto L_0x013f
        L_0x012e:
            r2 = 1879048192(0x70000000, float:1.58456325E29)
            r2 = r2 & r8
            if (r2 != 0) goto L_0x013f
            boolean r2 = r6.changed((boolean) r13)
            if (r2 == 0) goto L_0x013c
            r2 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x012c
        L_0x013c:
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x012c
        L_0x013f:
            r22 = r0
            r0 = r7 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0148
            r0 = r51 | 6
            goto L_0x015a
        L_0x0148:
            r0 = r51 & 14
            if (r0 != 0) goto L_0x0158
            boolean r0 = r6.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x0154
            r0 = 4
            goto L_0x0155
        L_0x0154:
            r0 = 2
        L_0x0155:
            r0 = r51 | r0
            goto L_0x015a
        L_0x0158:
            r0 = r51
        L_0x015a:
            r2 = r7 & 2048(0x800, float:2.87E-42)
            if (r2 == 0) goto L_0x0161
            r0 = r0 | 48
            goto L_0x0172
        L_0x0161:
            r2 = r51 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0172
            boolean r2 = r6.changed((boolean) r10)
            if (r2 == 0) goto L_0x016e
            r16 = 32
            goto L_0x0170
        L_0x016e:
            r16 = 16
        L_0x0170:
            r0 = r0 | r16
        L_0x0172:
            r16 = r0
            r0 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r22 & r0
            r2 = 306783378(0x12492492, float:6.3469493E-28)
            r0 = r0 ^ r2
            if (r0 != 0) goto L_0x019b
            r0 = r16 & 91
            r0 = r0 ^ 18
            if (r0 != 0) goto L_0x019b
            boolean r0 = r6.getSkipping()
            if (r0 != 0) goto L_0x018c
            goto L_0x019b
        L_0x018c:
            r6.skipToGroupEnd()
            r3 = r39
            r7 = r43
            r8 = r44
            r1 = r6
            r2 = r9
            r6 = r42
            goto L_0x030e
        L_0x019b:
            if (r3 == 0) goto L_0x019e
            r9 = 0
        L_0x019e:
            if (r11 == 0) goto L_0x01a4
            r0 = 99
            r11 = r0
            goto L_0x01a6
        L_0x01a4:
            r11 = r39
        L_0x01a6:
            r0 = 0
            if (r17 == 0) goto L_0x01ac
            r23 = r0
            goto L_0x01ae
        L_0x01ac:
            r23 = r5
        L_0x01ae:
            if (r19 == 0) goto L_0x01b3
            r24 = 0
            goto L_0x01b5
        L_0x01b3:
            r24 = r42
        L_0x01b5:
            if (r21 == 0) goto L_0x01ba
            r21 = r0
            goto L_0x01bc
        L_0x01ba:
            r21 = r43
        L_0x01bc:
            if (r1 == 0) goto L_0x01c1
            r25 = 1
            goto L_0x01c3
        L_0x01c1:
            r25 = r44
        L_0x01c3:
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            java.lang.Object r1 = r6.consume(r1)
            r17 = r1
            android.view.View r17 = (android.view.View) r17
            r1 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r6.startReplaceableGroup(r1)
            java.lang.Object r3 = r6.rememberedValue()
            androidx.compose.runtime.Composer$Companion r18 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r18.getEmpty()
            if (r3 != r5) goto L_0x01ee
            java.lang.Integer r3 = java.lang.Integer.valueOf(r40)
            r5 = 2
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r0, r5, r0)
            r6.updateRememberedValue(r3)
            goto L_0x01ef
        L_0x01ee:
            r5 = 2
        L_0x01ef:
            r6.endReplaceableGroup()
            r19 = r3
            androidx.compose.runtime.MutableState r19 = (androidx.compose.runtime.MutableState) r19
            r6.startReplaceableGroup(r1)
            java.lang.Object r3 = r6.rememberedValue()
            java.lang.Object r2 = r18.getEmpty()
            if (r3 != r2) goto L_0x020e
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r25)
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r0, r5, r0)
            r6.updateRememberedValue(r3)
        L_0x020e:
            r6.endReplaceableGroup()
            r26 = r3
            androidx.compose.runtime.MutableState r26 = (androidx.compose.runtime.MutableState) r26
            r2 = -723524056(0xffffffffd4dfe628, float:-7.6931127E12)
            r6.startReplaceableGroup(r2)
            r6.startReplaceableGroup(r1)
            java.lang.Object r2 = r6.rememberedValue()
            java.lang.Object r3 = r18.getEmpty()
            if (r2 != r3) goto L_0x0237
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            kotlinx.coroutines.CoroutineScope r2 = androidx.compose.runtime.EffectsKt.createCompositionCoroutineScope(r2, r6)
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r3 = new androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller
            r3.<init>(r2)
            r6.updateRememberedValue(r3)
            r2 = r3
        L_0x0237:
            r6.endReplaceableGroup()
            androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller r2 = (androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller) r2
            kotlinx.coroutines.CoroutineScope r27 = r2.getCoroutineScope()
            r6.endReplaceableGroup()
            r6.startReplaceableGroup(r1)
            java.lang.Object r1 = r6.rememberedValue()
            java.lang.Object r2 = r18.getEmpty()
            if (r1 != r2) goto L_0x0258
            r2 = 2
            androidx.compose.runtime.MutableState r1 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r0, r2, r0)
            r6.updateRememberedValue(r1)
        L_0x0258:
            r6.endReplaceableGroup()
            r18 = r1
            androidx.compose.runtime.MutableState r18 = (androidx.compose.runtime.MutableState) r18
            com.designsystem.ds_stepper.MM2Properties r5 = new com.designsystem.ds_stepper.MM2Properties
            r5.<init>(r10, r14, r13)
            com.designsystem.ds_stepper.StepperValues r3 = new com.designsystem.ds_stepper.StepperValues
            int r0 = m8596Stepper$lambda1(r19)
            r3.<init>(r0, r9, r11)
            boolean r0 = m8599Stepper$lambda4(r26)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            java.lang.String r1 = "StepperTransitionLabel"
            r2 = 48
            r39 = r3
            r3 = 0
            androidx.compose.animation.core.Transition r2 = androidx.compose.animation.core.TransitionKt.updateTransition(r0, (java.lang.String) r1, (androidx.compose.runtime.Composer) r6, (int) r2, (int) r3)
            int r0 = m8596Stepper$lambda1(r19)
            if (r0 != r9) goto L_0x028a
            if (r25 == 0) goto L_0x028a
            r1 = 1
            goto L_0x028b
        L_0x028a:
            r1 = r3
        L_0x028b:
            int r0 = r16 << 6
            r0 = r0 & 896(0x380, float:1.256E-42)
            r20 = r0
            r0 = r2
            r28 = r3
            r3 = r2
            r2 = r47
            r29 = r39
            r7 = r3
            r3 = r5
            r4 = r6
            r30 = r5
            r15 = 1
            r5 = r20
            androidx.compose.runtime.State r0 = animateBackgroundColor(r0, r1, r2, r3, r4, r5)
            r20 = r9
            r9 = r0
            int r0 = r16 << 3
            r0 = r0 & 112(0x70, float:1.57E-43)
            androidx.compose.runtime.State r0 = animateFontColor(r7, r12, r6, r0)
            r31 = r11
            r11 = r0
            androidx.compose.runtime.ProvidedValue[] r7 = new androidx.compose.runtime.ProvidedValue[r15]
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            androidx.compose.ui.unit.LayoutDirection r1 = androidx.compose.ui.unit.LayoutDirection.Ltr
            androidx.compose.runtime.ProvidedValue r0 = r0.provides(r1)
            r7[r28] = r0
            com.designsystem.ds_stepper.StepperComposablesKt$Stepper$1 r5 = new com.designsystem.ds_stepper.StepperComposablesKt$Stepper$1
            r0 = r5
            r1 = r37
            r2 = r22
            r3 = r21
            r4 = r30
            r32 = r5
            r5 = r47
            r33 = r6
            r6 = r29
            r34 = r7
            r7 = r24
            r8 = r16
            r10 = r26
            r12 = r25
            r13 = r27
            r14 = r18
            r15 = r23
            r16 = r17
            r17 = r19
            r18 = r20
            r19 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r0 = -819890693(0xffffffffcf2175fb, float:-2.70886374E9)
            r2 = r32
            r1 = r33
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r3, r2)
            r2 = 56
            r3 = r34
            androidx.compose.runtime.CompositionLocalKt.CompositionLocalProvider((androidx.compose.runtime.ProvidedValue<?>[]) r3, (kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) r0, (androidx.compose.runtime.Composer) r1, (int) r2)
            r2 = r20
            r7 = r21
            r5 = r23
            r6 = r24
            r8 = r25
            r3 = r31
        L_0x030e:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 != 0) goto L_0x0315
            goto L_0x0338
        L_0x0315:
            com.designsystem.ds_stepper.StepperComposablesKt$Stepper$2 r14 = new com.designsystem.ds_stepper.StepperComposablesKt$Stepper$2
            r0 = r14
            r1 = r37
            r4 = r40
            r9 = r45
            r10 = r46
            r11 = r47
            r12 = r48
            r13 = r50
            r35 = r14
            r14 = r51
            r36 = r15
            r15 = r52
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1 = r35
            r0 = r36
            r0.updateScope(r1)
        L_0x0338:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_stepper.StepperComposablesKt.Stepper(androidx.compose.ui.Modifier, int, int, int, kotlin.jvm.functions.Function1, boolean, androidx.compose.ui.Alignment$Horizontal, boolean, boolean, boolean, com.designsystem.ds_stepper.DSStepperStyle, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* access modifiers changed from: private */
    public static final void Stepper$collapseComponentWithDelay(boolean z11, CoroutineScope coroutineScope, MutableState<Job> mutableState, MutableState<Boolean> mutableState2) {
        if (z11) {
            Job r82 = m8601Stepper$lambda7(mutableState);
            if (r82 != null) {
                Job.DefaultImpls.cancel$default(r82, (CancellationException) null, 1, (Object) null);
            }
            m8602Stepper$lambda8(mutableState, BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new StepperComposablesKt$Stepper$collapseComponentWithDelay$1(mutableState2, (Continuation<? super StepperComposablesKt$Stepper$collapseComponentWithDelay$1>) null), 3, (Object) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Stepper$lambda-1  reason: not valid java name */
    public static final int m8596Stepper$lambda1(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: Stepper$lambda-10  reason: not valid java name */
    public static final long m8597Stepper$lambda10(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: Stepper$lambda-2  reason: not valid java name */
    public static final void m8598Stepper$lambda2(MutableState<Integer> mutableState, int i11) {
        mutableState.setValue(Integer.valueOf(i11));
    }

    /* access modifiers changed from: private */
    /* renamed from: Stepper$lambda-4  reason: not valid java name */
    public static final boolean m8599Stepper$lambda4(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: Stepper$lambda-5  reason: not valid java name */
    public static final void m8600Stepper$lambda5(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }

    /* renamed from: Stepper$lambda-7  reason: not valid java name */
    private static final Job m8601Stepper$lambda7(MutableState<Job> mutableState) {
        return mutableState.getValue();
    }

    /* renamed from: Stepper$lambda-8  reason: not valid java name */
    private static final void m8602Stepper$lambda8(MutableState<Job> mutableState, Job job) {
        mutableState.setValue(job);
    }

    /* access modifiers changed from: private */
    /* renamed from: Stepper$lambda-9  reason: not valid java name */
    public static final long m8603Stepper$lambda9(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* access modifiers changed from: private */
    @Composable
    /* renamed from: StepperIconArea-1yyLQnY  reason: not valid java name */
    public static final void m8604StepperIconArea1yyLQnY(@DrawableRes int i11, boolean z11, float f11, float f12, boolean z12, boolean z13, DSStepperStyle dSStepperStyle, Composer composer, int i12) {
        int i13;
        long j11;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22 = i11;
        boolean z14 = z11;
        float f13 = f11;
        float f14 = f12;
        boolean z15 = z12;
        boolean z16 = z13;
        int i23 = i12;
        Composer startRestartGroup = composer.startRestartGroup(-2012495684);
        if ((i23 & 14) == 0) {
            if (startRestartGroup.changed(i22)) {
                i21 = 4;
            } else {
                i21 = 2;
            }
            i13 = i21 | i23;
        } else {
            i13 = i23;
        }
        if ((i23 & 112) == 0) {
            if (startRestartGroup.changed(z14)) {
                i19 = 32;
            } else {
                i19 = 16;
            }
            i13 |= i19;
        }
        if ((i23 & 896) == 0) {
            if (startRestartGroup.changed(f13)) {
                i18 = 256;
            } else {
                i18 = 128;
            }
            i13 |= i18;
        }
        if ((i23 & 7168) == 0) {
            if (startRestartGroup.changed(f14)) {
                i17 = 2048;
            } else {
                i17 = 1024;
            }
            i13 |= i17;
        }
        if ((57344 & i23) == 0) {
            if (startRestartGroup.changed(z15)) {
                i16 = 16384;
            } else {
                i16 = 8192;
            }
            i13 |= i16;
        }
        if ((458752 & i23) == 0) {
            if (startRestartGroup.changed(z16)) {
                i15 = 131072;
            } else {
                i15 = 65536;
            }
            i13 |= i15;
        }
        DSStepperStyle dSStepperStyle2 = dSStepperStyle;
        if ((3670016 & i23) == 0) {
            if (startRestartGroup.changed((Object) dSStepperStyle2)) {
                i14 = 1048576;
            } else {
                i14 = 524288;
            }
            i13 |= i14;
        }
        if (((2995931 & i13) ^ 599186) != 0 || !startRestartGroup.getSkipping()) {
            if (z16 && !z15) {
                startRestartGroup.startReplaceableGroup(-2012495453);
                j11 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8762getDsNeutral200d7_KjU();
                startRestartGroup.endReplaceableGroup();
            } else if (z14) {
                startRestartGroup.startReplaceableGroup(-2012495389);
                startRestartGroup.endReplaceableGroup();
                j11 = dSStepperStyle.m8589getInteractiveColor0d7_KjU();
            } else {
                startRestartGroup.startReplaceableGroup(-2012495345);
                startRestartGroup.endReplaceableGroup();
                j11 = dSStepperStyle.m8590getInteractiveDisabledColor0d7_KjU();
            }
            long j12 = j11;
            Painter painterResource = PainterResources_androidKt.painterResource(i22, startRestartGroup, i13 & 14);
            Modifier.Companion companion = Modifier.Companion;
            DSTheme dSTheme = DSTheme.INSTANCE;
            IconKt.m1278Iconww6aTOc(painterResource, "", SizeKt.m558size3ABfNKs(PaddingKt.m489paddingqDBjuR0(companion, f13, dSTheme.getDimens(startRestartGroup, 0).m8846getDsXxsD9Ej5fM(), f14, dSTheme.getDimens(startRestartGroup, 0).m8846getDsXxsD9Ej5fM()), dSTheme.getDimens(startRestartGroup, 0).m8840getDsLD9Ej5fM()), j12, startRestartGroup, 56, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new StepperComposablesKt$StepperIconArea$1(i11, z11, f11, f12, z12, z13, dSStepperStyle, i12));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void StepperSpinner(Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(1852118393);
        if (i11 != 0 || !startRestartGroup.getSkipping()) {
            DSSpinnerKt.DSSpinner(TestTagKt.testTag(Modifier.Companion, Stepper.StepperLoaderTestTag), DSSpinnerColor.Black, DSSpinnerSize.VerySmall, startRestartGroup, 438, 0);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new StepperComposablesKt$StepperSpinner$1(i11));
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    @Composable
    /* renamed from: StepperStaticIconsBackgroundLayer-DTdxfFs  reason: not valid java name */
    public static final void m8605StepperStaticIconsBackgroundLayerDTdxfFs(BoxWithConstraintsScope boxWithConstraintsScope, Alignment.Horizontal horizontal, MM2Properties mM2Properties, DSStepperStyle dSStepperStyle, long j11, boolean z11, StepperValues stepperValues, long j12, boolean z12, Function0<Unit> function0, Function0<Unit> function02, Composer composer, int i11, int i12) {
        int i13;
        int i14;
        Composer composer2;
        BoxWithConstraintsScope boxWithConstraintsScope2 = boxWithConstraintsScope;
        Alignment.Horizontal horizontal2 = horizontal;
        int i15 = i11;
        Composer startRestartGroup = composer.startRestartGroup(795458500);
        int i16 = 4;
        if ((i15 & 14) == 0) {
            i13 = (startRestartGroup.changed((Object) boxWithConstraintsScope2) ? 4 : 2) | i15;
        } else {
            i13 = i15;
        }
        if ((i15 & 112) == 0) {
            i13 |= startRestartGroup.changed((Object) horizontal2) ? 32 : 16;
        }
        MM2Properties mM2Properties2 = mM2Properties;
        if ((i15 & 896) == 0) {
            i13 |= startRestartGroup.changed((Object) mM2Properties2) ? 256 : 128;
        }
        DSStepperStyle dSStepperStyle2 = dSStepperStyle;
        if ((i15 & 7168) == 0) {
            i13 |= startRestartGroup.changed((Object) dSStepperStyle2) ? 2048 : 1024;
        }
        long j13 = j11;
        if ((57344 & i15) == 0) {
            i13 |= startRestartGroup.changed(j13) ? 16384 : 8192;
        }
        boolean z13 = z11;
        if ((458752 & i15) == 0) {
            i13 |= startRestartGroup.changed(z13) ? 131072 : 65536;
        }
        StepperValues stepperValues2 = stepperValues;
        if ((3670016 & i15) == 0) {
            i13 |= startRestartGroup.changed((Object) stepperValues2) ? 1048576 : 524288;
        }
        long j14 = j12;
        if ((29360128 & i15) == 0) {
            i13 |= startRestartGroup.changed(j14) ? 8388608 : 4194304;
        }
        if ((234881024 & i15) == 0) {
            i13 |= startRestartGroup.changed(z12) ? 67108864 : 33554432;
        } else {
            boolean z14 = z12;
        }
        Function0<Unit> function03 = function0;
        if ((i15 & 1879048192) == 0) {
            i13 |= startRestartGroup.changed((Object) function03) ? 536870912 : 268435456;
        }
        int i17 = i13;
        if ((i12 & 14) == 0) {
            if (!startRestartGroup.changed((Object) function02)) {
                i16 = 2;
            }
            i14 = i12 | i16;
        } else {
            Function0<Unit> function04 = function02;
            i14 = i12;
        }
        if (((i17 & 1533916891) ^ 306783378) == 0 && ((i14 & 11) ^ 2) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            float r18 = Dp.m5478constructorimpl(!mM2Properties.isEnabled() ? (float) 0 : (float) 2);
            Modifier GetStepperWidthModifier = GetStepperWidthModifier(boxWithConstraintsScope2, startRestartGroup, 0);
            Alignment.Horizontal centerHorizontally = horizontal2 == null ? Alignment.Companion.getCenterHorizontally() : horizontal2;
            startRestartGroup.startReplaceableGroup(-1113031299);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(GetStepperWidthModifier);
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
            Updater.m2543setimpl(r42, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r42, density, companion.getSetDensity());
            Updater.m2543setimpl(r42, layoutDirection, companion.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(276693241);
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            RoundedCornerShape r19 = RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(dSStepperStyle.m8588getCornerRadiusD9Ej5fM());
            Modifier.Companion companion2 = Modifier.Companion;
            DSTheme dSTheme = DSTheme.INSTANCE;
            Modifier testTag = TestTagKt.testTag(SizeKt.m544height3ABfNKs(PaddingKt.m486padding3ABfNKs(companion2, dSTheme.getDimens(startRestartGroup, 0).m8848getDsXxxsD9Ej5fM()), dSTheme.getDimens(startRestartGroup, 0).m8845getDsXxlD9Ej5fM()), Stepper.StepperContainerTestTag);
            StepperComposablesKt$StepperStaticIconsBackgroundLayer$1$1$1 stepperComposablesKt$StepperStaticIconsBackgroundLayer$1$1$1 = r0;
            StepperComposablesKt$StepperStaticIconsBackgroundLayer$1$1$1 stepperComposablesKt$StepperStaticIconsBackgroundLayer$1$1$12 = new StepperComposablesKt$StepperStaticIconsBackgroundLayer$1$1$1(j11, i17, z11, boxWithConstraintsScope, stepperValues, dSStepperStyle, j12, mM2Properties, z12, function0, function02, i14);
            composer2 = startRestartGroup;
            CardKt.m1142CardFjzlyU(testTag, r19, 0, 0, (BorderStroke) null, r18, ComposableLambdaKt.composableLambda(composer2, -819902823, true, stepperComposablesKt$StepperStaticIconsBackgroundLayer$1$1$1), composer2, 1572864, 28);
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            StepperComposablesKt$StepperStaticIconsBackgroundLayer$2 stepperComposablesKt$StepperStaticIconsBackgroundLayer$2 = r0;
            StepperComposablesKt$StepperStaticIconsBackgroundLayer$2 stepperComposablesKt$StepperStaticIconsBackgroundLayer$22 = new StepperComposablesKt$StepperStaticIconsBackgroundLayer$2(boxWithConstraintsScope, horizontal, mM2Properties, dSStepperStyle, j11, z11, stepperValues, j12, z12, function0, function02, i11, i12);
            endRestartGroup.updateScope(stepperComposablesKt$StepperStaticIconsBackgroundLayer$2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v10, resolved type: kotlin.jvm.functions.Function0} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void StepperTappableForegroundLayer(androidx.compose.ui.Modifier r17, boolean r18, com.designsystem.ds_stepper.StepperValues r19, com.designsystem.ds_stepper.MM2Properties r20, kotlin.jvm.functions.Function0<kotlin.Unit> r21, kotlin.jvm.functions.Function0<kotlin.Unit> r22, androidx.compose.runtime.Composer r23, int r24) {
        /*
            r2 = r18
            r5 = r21
            r6 = r22
            r7 = r24
            r0 = -1346062618(0xffffffffafc4b6e6, float:-3.578215E-10)
            r1 = r23
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r7 & 14
            if (r1 != 0) goto L_0x0022
            r1 = r17
            boolean r4 = r0.changed((java.lang.Object) r1)
            if (r4 == 0) goto L_0x001f
            r4 = 4
            goto L_0x0020
        L_0x001f:
            r4 = 2
        L_0x0020:
            r4 = r4 | r7
            goto L_0x0025
        L_0x0022:
            r1 = r17
            r4 = r7
        L_0x0025:
            r8 = r7 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0035
            boolean r8 = r0.changed((boolean) r2)
            if (r8 == 0) goto L_0x0032
            r8 = 32
            goto L_0x0034
        L_0x0032:
            r8 = 16
        L_0x0034:
            r4 = r4 | r8
        L_0x0035:
            r8 = r7 & 896(0x380, float:1.256E-42)
            r14 = r19
            if (r8 != 0) goto L_0x0047
            boolean r8 = r0.changed((java.lang.Object) r14)
            if (r8 == 0) goto L_0x0044
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0046
        L_0x0044:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0046:
            r4 = r4 | r8
        L_0x0047:
            r8 = r7 & 7168(0x1c00, float:1.0045E-41)
            r15 = r20
            if (r8 != 0) goto L_0x0059
            boolean r8 = r0.changed((java.lang.Object) r15)
            if (r8 == 0) goto L_0x0056
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0058
        L_0x0056:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0058:
            r4 = r4 | r8
        L_0x0059:
            r8 = 57344(0xe000, float:8.0356E-41)
            r8 = r8 & r7
            if (r8 != 0) goto L_0x006b
            boolean r8 = r0.changed((java.lang.Object) r5)
            if (r8 == 0) goto L_0x0068
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x006a
        L_0x0068:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x006a:
            r4 = r4 | r8
        L_0x006b:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r7
            if (r8 != 0) goto L_0x007c
            boolean r8 = r0.changed((java.lang.Object) r6)
            if (r8 == 0) goto L_0x0079
            r8 = 131072(0x20000, float:1.83671E-40)
            goto L_0x007b
        L_0x0079:
            r8 = 65536(0x10000, float:9.18355E-41)
        L_0x007b:
            r4 = r4 | r8
        L_0x007c:
            r8 = 374491(0x5b6db, float:5.24774E-40)
            r8 = r8 & r4
            r10 = 74898(0x12492, float:1.04954E-40)
            r8 = r8 ^ r10
            if (r8 != 0) goto L_0x0092
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x008d
            goto L_0x0092
        L_0x008d:
            r0.skipToGroupEnd()
            goto L_0x0224
        L_0x0092:
            if (r2 != 0) goto L_0x021b
            r8 = -1346062380(0xffffffffafc4b7d4, float:-3.578281E-10)
            r0.startReplaceableGroup(r8)
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$HorizontalOrVertical r8 = r8.getSpaceBetween()
            r4 = r4 & 14
            r10 = -1989997546(0xffffffff89630c16, float:-2.7329814E-33)
            r0.startReplaceableGroup(r10)
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r10 = r10.getTop()
            int r11 = r4 >> 3
            r12 = r11 & 14
            r11 = r11 & 112(0x70, float:1.57E-43)
            r11 = r11 | r12
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r8, r10, r0, r11)
            int r10 = r4 << 3
            r10 = r10 & 112(0x70, float:1.57E-43)
            r11 = 1376089335(0x520574f7, float:1.43298249E11)
            r0.startReplaceableGroup(r11)
            androidx.compose.runtime.ProvidableCompositionLocal r11 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r11 = r0.consume(r11)
            androidx.compose.ui.unit.Density r11 = (androidx.compose.ui.unit.Density) r11
            androidx.compose.runtime.ProvidableCompositionLocal r12 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r12 = r0.consume(r12)
            androidx.compose.ui.unit.LayoutDirection r12 = (androidx.compose.ui.unit.LayoutDirection) r12
            androidx.compose.ui.node.ComposeUiNode$Companion r13 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r9 = r13.getConstructor()
            kotlin.jvm.functions.Function3 r3 = androidx.compose.ui.layout.LayoutKt.materializerOf(r17)
            int r10 = r10 << 9
            r10 = r10 & 7168(0x1c00, float:1.0045E-41)
            androidx.compose.runtime.Applier r1 = r0.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x00f0
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x00f0:
            r0.startReusableNode()
            boolean r1 = r0.getInserting()
            if (r1 == 0) goto L_0x00fd
            r0.createNode(r9)
            goto L_0x0100
        L_0x00fd:
            r0.useNode()
        L_0x0100:
            r0.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r9 = r13.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r8, r9)
            kotlin.jvm.functions.Function2 r8 = r13.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r11, r8)
            kotlin.jvm.functions.Function2 r8 = r13.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r12, r8)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            int r8 = r10 >> 3
            r8 = r8 & 112(0x70, float:1.57E-43)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r3.invoke(r1, r0, r8)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            int r1 = r10 >> 9
            r1 = r1 & 14
            r3 = -326682743(0xffffffffec873789, float:-1.307738E27)
            r0.startReplaceableGroup(r3)
            r1 = r1 & 11
            r3 = 2
            r1 = r1 ^ r3
            if (r1 != 0) goto L_0x0154
            boolean r1 = r0.getSkipping()
            if (r1 != 0) goto L_0x014f
            goto L_0x0154
        L_0x014f:
            r0.skipToGroupEnd()
            goto L_0x0208
        L_0x0154:
            androidx.compose.foundation.layout.RowScopeInstance r1 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            int r1 = r4 >> 6
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | 6
            r1 = r1 & 81
            r3 = 16
            r1 = r1 ^ r3
            if (r1 != 0) goto L_0x016f
            boolean r1 = r0.getSkipping()
            if (r1 != 0) goto L_0x016a
            goto L_0x016f
        L_0x016a:
            r0.skipToGroupEnd()
            goto L_0x0208
        L_0x016f:
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            java.lang.Object r1 = r0.consume(r1)
            r8 = r1
            android.view.View r8 = (android.view.View) r8
            java.lang.String r9 = "StepperDecrementQuantityIconTestTag"
            int r1 = r19.getValue()
            int r3 = r19.getMin()
            r4 = 1
            r16 = 0
            if (r1 == r3) goto L_0x0191
            boolean r1 = r20.isClickable()
            if (r1 == 0) goto L_0x0191
            r10 = r4
            goto L_0x0193
        L_0x0191:
            r10 = r16
        L_0x0193:
            r1 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r1)
            boolean r3 = r0.changed((java.lang.Object) r5)
            java.lang.Object r11 = r0.rememberedValue()
            if (r3 != 0) goto L_0x01ab
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r11 != r3) goto L_0x01b3
        L_0x01ab:
            com.designsystem.ds_stepper.StepperComposablesKt$StepperTappableForegroundLayer$1$1$1 r11 = new com.designsystem.ds_stepper.StepperComposablesKt$StepperTappableForegroundLayer$1$1$1
            r11.<init>(r5)
            r0.updateRememberedValue(r11)
        L_0x01b3:
            r0.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r13 = 56
            r12 = r0
            TappableArea(r8, r9, r10, r11, r12, r13)
            androidx.compose.runtime.ProvidableCompositionLocal r3 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            java.lang.Object r3 = r0.consume(r3)
            r8 = r3
            android.view.View r8 = (android.view.View) r8
            java.lang.String r9 = "StepperIncrementQuantityIconTestTag"
            int r3 = r19.getValue()
            int r10 = r19.getMax()
            if (r3 == r10) goto L_0x01dd
            boolean r3 = r20.isClickable()
            if (r3 == 0) goto L_0x01dd
            r10 = r4
            goto L_0x01df
        L_0x01dd:
            r10 = r16
        L_0x01df:
            r0.startReplaceableGroup(r1)
            boolean r1 = r0.changed((java.lang.Object) r6)
            java.lang.Object r3 = r0.rememberedValue()
            if (r1 != 0) goto L_0x01f4
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x01fc
        L_0x01f4:
            com.designsystem.ds_stepper.StepperComposablesKt$StepperTappableForegroundLayer$1$2$1 r3 = new com.designsystem.ds_stepper.StepperComposablesKt$StepperTappableForegroundLayer$1$2$1
            r3.<init>(r6)
            r0.updateRememberedValue(r3)
        L_0x01fc:
            r0.endReplaceableGroup()
            r11 = r3
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r13 = 56
            r12 = r0
            TappableArea(r8, r9, r10, r11, r12, r13)
        L_0x0208:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            goto L_0x0224
        L_0x021b:
            r1 = -1346061647(0xffffffffafc4bab1, float:-3.5784845E-10)
            r0.startReplaceableGroup(r1)
            r0.endReplaceableGroup()
        L_0x0224:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x022b
            goto L_0x0242
        L_0x022b:
            com.designsystem.ds_stepper.StepperComposablesKt$StepperTappableForegroundLayer$2 r9 = new com.designsystem.ds_stepper.StepperComposablesKt$StepperTappableForegroundLayer$2
            r0 = r9
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r7 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r8.updateScope(r9)
        L_0x0242:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_stepper.StepperComposablesKt.StepperTappableForegroundLayer(androidx.compose.ui.Modifier, boolean, com.designsystem.ds_stepper.StepperValues, com.designsystem.ds_stepper.MM2Properties, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    @Composable
    public static final void TappableArea(View view, String str, boolean z11, Function0<Unit> function0, Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(897691490);
        Modifier r02 = ClickableKt.m194clickableO2vRcR0$default(TestTagKt.testTag(SizeKt.m558size3ABfNKs(Modifier.Companion, Dp.m5478constructorimpl((float) 48)), str), InteractionSourceKt.MutableInteractionSource(), (Indication) null, z11, (String) null, (Role) null, new StepperComposablesKt$TappableArea$1(view, function0), 24, (Object) null);
        startRestartGroup.startReplaceableGroup(-1990474327);
        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(1376089335);
        Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        Function0<ComposeUiNode> constructor = companion.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(r02);
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
        Composer r62 = Updater.m2536constructorimpl(startRestartGroup);
        Updater.m2543setimpl(r62, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
        Updater.m2543setimpl(r62, density, companion.getSetDensity());
        Updater.m2543setimpl(r62, layoutDirection, companion.getSetLayoutDirection());
        startRestartGroup.enableReusing();
        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
        startRestartGroup.startReplaceableGroup(2058660585);
        startRestartGroup.startReplaceableGroup(-1253629305);
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        startRestartGroup.endReplaceableGroup();
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new StepperComposablesKt$TappableArea$3(view, str, z11, function0, i11));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.runtime.State<androidx.compose.ui.graphics.Color> animateBackgroundColor(androidx.compose.animation.core.Transition<java.lang.Boolean> r14, boolean r15, com.designsystem.ds_stepper.DSStepperStyle r16, com.designsystem.ds_stepper.MM2Properties r17, androidx.compose.runtime.Composer r18, int r19) {
        /*
            r8 = r18
            r0 = 1424541372(0x54e8c6bc, float:7.998133E12)
            r8.startReplaceableGroup(r0)
            com.designsystem.ds_stepper.StepperComposablesKt$animateBackgroundColor$1 r0 = com.designsystem.ds_stepper.StepperComposablesKt$animateBackgroundColor$1.INSTANCE
            java.lang.String r5 = "StepperBackgroundAnimationLabel"
            r1 = r19 & 14
            r1 = r1 | 384(0x180, float:5.38E-43)
            r2 = -1462136984(0xffffffffa8d98f68, float:-2.4154032E-14)
            r8.startReplaceableGroup(r2)
            java.lang.Object r2 = r14.getTargetState()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r3 = 1290032521(0x4ce45589, float:1.1971284E8)
            r8.startReplaceableGroup(r3)
            boolean r4 = r17.isEnabled()
            r6 = 1290032708(0x4ce45644, float:1.19714336E8)
            r7 = 1290032760(0x4ce45678, float:1.19714752E8)
            r9 = 0
            r10 = 1290032576(0x4ce455c0, float:1.1971328E8)
            if (r4 != 0) goto L_0x0047
            r8.startReplaceableGroup(r10)
            com.designsystem.ds_theme.DSTheme r2 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r2 = r2.getColors(r8, r9)
            long r11 = r2.m8761getDsNeutral10V20d7_KjU()
            r18.endReplaceableGroup()
            goto L_0x0066
        L_0x0047:
            if (r2 == 0) goto L_0x005c
            if (r15 != 0) goto L_0x005c
            boolean r2 = r17.isLoading()
            if (r2 != 0) goto L_0x005c
            r8.startReplaceableGroup(r6)
            r18.endReplaceableGroup()
            long r11 = r16.m8589getInteractiveColor0d7_KjU()
            goto L_0x0066
        L_0x005c:
            r8.startReplaceableGroup(r7)
            r18.endReplaceableGroup()
            long r11 = r16.m8587getBackgroundColor0d7_KjU()
        L_0x0066:
            r18.endReplaceableGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r2 = androidx.compose.ui.graphics.Color.m2923getColorSpaceimpl(r11)
            r4 = -3686930(0xffffffffffc7bdee, float:NaN)
            r8.startReplaceableGroup(r4)
            boolean r4 = r8.changed((java.lang.Object) r2)
            java.lang.Object r11 = r18.rememberedValue()
            if (r4 != 0) goto L_0x0085
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r11 != r4) goto L_0x0095
        L_0x0085:
            androidx.compose.ui.graphics.Color$Companion r4 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r4 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r4)
            java.lang.Object r2 = r4.invoke(r2)
            r11 = r2
            androidx.compose.animation.core.TwoWayConverter r11 = (androidx.compose.animation.core.TwoWayConverter) r11
            r8.updateRememberedValue(r11)
        L_0x0095:
            r18.endReplaceableGroup()
            r4 = r11
            androidx.compose.animation.core.TwoWayConverter r4 = (androidx.compose.animation.core.TwoWayConverter) r4
            r2 = r1 & 14
            r2 = r2 | 64
            int r1 = r1 << 3
            r11 = r1 & 896(0x380, float:1.256E-42)
            r2 = r2 | r11
            r11 = r1 & 7168(0x1c00, float:1.0045E-41)
            r2 = r2 | r11
            r11 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r11
            r1 = r1 | r2
            r2 = 1847721878(0x6e21ff96, float:1.2534018E28)
            r8.startReplaceableGroup(r2)
            java.lang.Object r2 = r14.getCurrentState()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r8.startReplaceableGroup(r3)
            boolean r12 = r17.isEnabled()
            if (r12 != 0) goto L_0x00d6
            r8.startReplaceableGroup(r10)
            com.designsystem.ds_theme.DSTheme r2 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r2 = r2.getColors(r8, r9)
            long r12 = r2.m8761getDsNeutral10V20d7_KjU()
            r18.endReplaceableGroup()
            goto L_0x00f5
        L_0x00d6:
            if (r2 == 0) goto L_0x00eb
            if (r15 != 0) goto L_0x00eb
            boolean r2 = r17.isLoading()
            if (r2 != 0) goto L_0x00eb
            r8.startReplaceableGroup(r6)
            r18.endReplaceableGroup()
            long r12 = r16.m8589getInteractiveColor0d7_KjU()
            goto L_0x00f5
        L_0x00eb:
            r8.startReplaceableGroup(r7)
            r18.endReplaceableGroup()
            long r12 = r16.m8587getBackgroundColor0d7_KjU()
        L_0x00f5:
            r18.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r2 = androidx.compose.ui.graphics.Color.m2909boximpl(r12)
            java.lang.Object r12 = r14.getTargetState()
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            r8.startReplaceableGroup(r3)
            boolean r3 = r17.isEnabled()
            if (r3 != 0) goto L_0x0120
            r8.startReplaceableGroup(r10)
            com.designsystem.ds_theme.DSTheme r3 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r3 = r3.getColors(r8, r9)
            long r6 = r3.m8761getDsNeutral10V20d7_KjU()
            r18.endReplaceableGroup()
            goto L_0x013f
        L_0x0120:
            if (r12 == 0) goto L_0x0135
            if (r15 != 0) goto L_0x0135
            boolean r3 = r17.isLoading()
            if (r3 != 0) goto L_0x0135
            r8.startReplaceableGroup(r6)
            r18.endReplaceableGroup()
            long r6 = r16.m8589getInteractiveColor0d7_KjU()
            goto L_0x013f
        L_0x0135:
            r8.startReplaceableGroup(r7)
            r18.endReplaceableGroup()
            long r6 = r16.m8587getBackgroundColor0d7_KjU()
        L_0x013f:
            r18.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r3 = androidx.compose.ui.graphics.Color.m2909boximpl(r6)
            androidx.compose.animation.core.Transition$Segment r6 = r14.getSegment()
            int r7 = r1 >> 3
            r7 = r7 & 112(0x70, float:1.57E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Object r0 = r0.invoke(r6, r8, r7)
            r6 = r0
            androidx.compose.animation.core.FiniteAnimationSpec r6 = (androidx.compose.animation.core.FiniteAnimationSpec) r6
            r0 = r1 & 14
            int r7 = r1 << 9
            r7 = r7 & r11
            r0 = r0 | r7
            int r1 = r1 << 6
            r7 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r7
            r7 = r0 | r1
            r0 = r14
            r1 = r2
            r2 = r3
            r3 = r6
            r6 = r18
            androidx.compose.runtime.State r0 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r0, r1, r2, r3, r4, r5, r6, r7)
            r18.endReplaceableGroup()
            r18.endReplaceableGroup()
            r18.endReplaceableGroup()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_stepper.StepperComposablesKt.animateBackgroundColor(androidx.compose.animation.core.Transition, boolean, com.designsystem.ds_stepper.DSStepperStyle, com.designsystem.ds_stepper.MM2Properties, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: androidx.compose.animation.core.TwoWayConverter} */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final androidx.compose.runtime.State<androidx.compose.ui.graphics.Color> animateFontColor(androidx.compose.animation.core.Transition<java.lang.Boolean> r9, com.designsystem.ds_stepper.DSStepperStyle r10, androidx.compose.runtime.Composer r11, int r12) {
        /*
            r0 = 878128545(0x34572da1, float:2.0040035E-7)
            r11.startReplaceableGroup(r0)
            com.designsystem.ds_stepper.StepperComposablesKt$animateFontColor$1 r0 = com.designsystem.ds_stepper.StepperComposablesKt$animateFontColor$1.INSTANCE
            java.lang.String r6 = "StepperFontColorAnimationLabel"
            r12 = r12 & 14
            r12 = r12 | 384(0x180, float:5.38E-43)
            r1 = -1462136984(0xffffffffa8d98f68, float:-2.4154032E-14)
            r11.startReplaceableGroup(r1)
            java.lang.Object r1 = r9.getTargetState()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r2 = 295449239(0x119c3297, float:2.4643639E-28)
            r11.startReplaceableGroup(r2)
            if (r1 == 0) goto L_0x002b
            long r3 = r10.m8592getTextColorAlternative0d7_KjU()
            goto L_0x002f
        L_0x002b:
            long r3 = r10.m8591getTextColor0d7_KjU()
        L_0x002f:
            r11.endReplaceableGroup()
            androidx.compose.ui.graphics.colorspace.ColorSpace r1 = androidx.compose.ui.graphics.Color.m2923getColorSpaceimpl(r3)
            r3 = -3686930(0xffffffffffc7bdee, float:NaN)
            r11.startReplaceableGroup(r3)
            boolean r3 = r11.changed((java.lang.Object) r1)
            java.lang.Object r4 = r11.rememberedValue()
            if (r3 != 0) goto L_0x004e
            androidx.compose.runtime.Composer$Companion r3 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r3 = r3.getEmpty()
            if (r4 != r3) goto L_0x005e
        L_0x004e:
            androidx.compose.ui.graphics.Color$Companion r3 = androidx.compose.ui.graphics.Color.Companion
            kotlin.jvm.functions.Function1 r3 = androidx.compose.animation.ColorVectorConverterKt.getVectorConverter(r3)
            java.lang.Object r1 = r3.invoke(r1)
            r4 = r1
            androidx.compose.animation.core.TwoWayConverter r4 = (androidx.compose.animation.core.TwoWayConverter) r4
            r11.updateRememberedValue(r4)
        L_0x005e:
            r11.endReplaceableGroup()
            r5 = r4
            androidx.compose.animation.core.TwoWayConverter r5 = (androidx.compose.animation.core.TwoWayConverter) r5
            r1 = r12 & 14
            r1 = r1 | 64
            int r12 = r12 << 3
            r3 = r12 & 896(0x380, float:1.256E-42)
            r1 = r1 | r3
            r3 = r12 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r3
            r3 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r3
            r12 = r12 | r1
            r1 = 1847721878(0x6e21ff96, float:1.2534018E28)
            r11.startReplaceableGroup(r1)
            java.lang.Object r1 = r9.getCurrentState()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r11.startReplaceableGroup(r2)
            if (r1 == 0) goto L_0x008f
            long r7 = r10.m8592getTextColorAlternative0d7_KjU()
            goto L_0x0093
        L_0x008f:
            long r7 = r10.m8591getTextColor0d7_KjU()
        L_0x0093:
            r11.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r4 = androidx.compose.ui.graphics.Color.m2909boximpl(r7)
            java.lang.Object r1 = r9.getTargetState()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r11.startReplaceableGroup(r2)
            if (r1 == 0) goto L_0x00ae
            long r1 = r10.m8592getTextColorAlternative0d7_KjU()
            goto L_0x00b2
        L_0x00ae:
            long r1 = r10.m8591getTextColor0d7_KjU()
        L_0x00b2:
            r11.endReplaceableGroup()
            androidx.compose.ui.graphics.Color r10 = androidx.compose.ui.graphics.Color.m2909boximpl(r1)
            androidx.compose.animation.core.Transition$Segment r1 = r9.getSegment()
            int r2 = r12 >> 3
            r2 = r2 & 112(0x70, float:1.57E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r0.invoke(r1, r11, r2)
            androidx.compose.animation.core.FiniteAnimationSpec r0 = (androidx.compose.animation.core.FiniteAnimationSpec) r0
            r1 = r12 & 14
            int r2 = r12 << 9
            r2 = r2 & r3
            r1 = r1 | r2
            int r12 = r12 << 6
            r2 = 458752(0x70000, float:6.42848E-40)
            r12 = r12 & r2
            r8 = r1 | r12
            r1 = r9
            r2 = r4
            r3 = r10
            r4 = r0
            r7 = r11
            androidx.compose.runtime.State r9 = androidx.compose.animation.core.TransitionKt.createTransitionAnimation(r1, r2, r3, r4, r5, r6, r7, r8)
            r11.endReplaceableGroup()
            r11.endReplaceableGroup()
            r11.endReplaceableGroup()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_stepper.StepperComposablesKt.animateFontColor(androidx.compose.animation.core.Transition, com.designsystem.ds_stepper.DSStepperStyle, androidx.compose.runtime.Composer, int):androidx.compose.runtime.State");
    }

    private static final int getDecrementIcon(boolean z11) {
        if (z11) {
            return R.drawable.ds_bin;
        }
        return R.drawable.ds_minus;
    }
}
