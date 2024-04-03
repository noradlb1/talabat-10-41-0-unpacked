package com.designsystem.ds_stepper;

import android.annotation.SuppressLint;
import android.view.View;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_counter.CounterComposablesKt;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\u001a[\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001aS\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"MM1StepperCounter", "", "scope", "Landroidx/compose/foundation/layout/BoxScope;", "isCollapsed", "", "value", "", "fontColor", "Landroidx/compose/ui/graphics/Color;", "onTap", "Lkotlin/Function0;", "MM1StepperCounter-ww6aTOc", "(Landroidx/compose/foundation/layout/BoxScope;ZIJLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "MM2StepperCounter", "labelColor", "backgroundColor", "style", "Lcom/designsystem/ds_stepper/DSStepperStyle;", "isEnabled", "MM2StepperCounter-vRFhKjU", "(Landroidx/compose/foundation/layout/BoxScope;ZIJJLcom/designsystem/ds_stepper/DSStepperStyle;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "StepperCounter", "mm2Properties", "Lcom/designsystem/ds_stepper/MM2Properties;", "StepperCounter-Y0xEhic", "(ZIJJLcom/designsystem/ds_stepper/DSStepperStyle;Lcom/designsystem/ds_stepper/MM2Properties;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class StepperCounterComposablesKt {
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: kotlin.jvm.functions.Function1} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v13, resolved type: kotlin.jvm.functions.Function1} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"MissingPermission"})
    @androidx.compose.runtime.Composable
    /* renamed from: MM1StepperCounter-ww6aTOc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8617MM1StepperCounterww6aTOc(androidx.compose.foundation.layout.BoxScope r18, boolean r19, int r20, long r21, kotlin.jvm.functions.Function0<kotlin.Unit> r23, androidx.compose.runtime.Composer r24, int r25) {
        /*
            r1 = r18
            r3 = r20
            r4 = r21
            r6 = r23
            r7 = r25
            r0 = -1358843044(0xffffffffaf01b35c, float:-1.1796203E-10)
            r2 = r24
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r7 & 14
            if (r2 != 0) goto L_0x0022
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x001f
            r2 = 4
            goto L_0x0020
        L_0x001f:
            r2 = 2
        L_0x0020:
            r2 = r2 | r7
            goto L_0x0023
        L_0x0022:
            r2 = r7
        L_0x0023:
            r8 = r7 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0036
            r8 = r19
            boolean r9 = r0.changed((boolean) r8)
            if (r9 == 0) goto L_0x0032
            r9 = 32
            goto L_0x0034
        L_0x0032:
            r9 = 16
        L_0x0034:
            r2 = r2 | r9
            goto L_0x0038
        L_0x0036:
            r8 = r19
        L_0x0038:
            r9 = r7 & 896(0x380, float:1.256E-42)
            if (r9 != 0) goto L_0x0048
            boolean r9 = r0.changed((int) r3)
            if (r9 == 0) goto L_0x0045
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x0047
        L_0x0045:
            r9 = 128(0x80, float:1.794E-43)
        L_0x0047:
            r2 = r2 | r9
        L_0x0048:
            r9 = r7 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0058
            boolean r9 = r0.changed((long) r4)
            if (r9 == 0) goto L_0x0055
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x0057
        L_0x0055:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x0057:
            r2 = r2 | r9
        L_0x0058:
            r9 = 57344(0xe000, float:8.0356E-41)
            r9 = r9 & r7
            if (r9 != 0) goto L_0x006a
            boolean r9 = r0.changed((java.lang.Object) r6)
            if (r9 == 0) goto L_0x0067
            r9 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0069
        L_0x0067:
            r9 = 8192(0x2000, float:1.14794E-41)
        L_0x0069:
            r2 = r2 | r9
        L_0x006a:
            r9 = 46811(0xb6db, float:6.5596E-41)
            r2 = r2 & r9
            r2 = r2 ^ 9362(0x2492, float:1.3119E-41)
            if (r2 != 0) goto L_0x007e
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x0079
            goto L_0x007e
        L_0x0079:
            r0.skipToGroupEnd()
            goto L_0x0123
        L_0x007e:
            androidx.compose.runtime.ProvidableCompositionLocal r2 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalView()
            java.lang.Object r2 = r0.consume(r2)
            android.view.View r2 = (android.view.View) r2
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            androidx.compose.ui.Alignment$Companion r10 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment r10 = r10.getCenter()
            androidx.compose.ui.Modifier r9 = r1.align(r9, r10)
            com.designsystem.ds_theme.DSTheme r10 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r11 = 0
            com.designsystem.ds_theme.DSDimens r10 = r10.getDimens(r0, r11)
            float r10 = r10.m8845getDsXxlD9Ej5fM()
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.layout.SizeKt.m544height3ABfNKs(r9, r10)
            java.lang.String r10 = "StepperCounterMM1TestTag"
            androidx.compose.ui.Modifier r9 = androidx.compose.ui.platform.TestTagKt.testTag(r9, r10)
            androidx.compose.foundation.interaction.MutableInteractionSource r10 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11 = 0
            r13 = 0
            r14 = 0
            com.designsystem.ds_stepper.StepperCounterComposablesKt$MM1StepperCounter$1$1 r15 = new com.designsystem.ds_stepper.StepperCounterComposablesKt$MM1StepperCounter$1$1
            r15.<init>(r2, r6)
            r16 = 24
            r17 = 0
            r12 = r19
            androidx.compose.ui.Modifier r9 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r20)
            r10 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r10)
            boolean r2 = r0.changed((java.lang.Object) r2)
            java.lang.Object r10 = r0.rememberedValue()
            if (r2 != 0) goto L_0x00db
            androidx.compose.runtime.Composer$Companion r2 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r2 = r2.getEmpty()
            if (r10 != r2) goto L_0x00e3
        L_0x00db:
            com.designsystem.ds_stepper.StepperCounterComposablesKt$MM1StepperCounter$1$2$1 r10 = new com.designsystem.ds_stepper.StepperCounterComposablesKt$MM1StepperCounter$1$2$1
            r10.<init>(r3)
            r0.updateRememberedValue(r10)
        L_0x00e3:
            r0.endReplaceableGroup()
            r2 = r10
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            java.lang.Integer r10 = java.lang.Integer.valueOf(r20)
            androidx.compose.ui.graphics.Color r11 = androidx.compose.ui.graphics.Color.m2909boximpl(r21)
            r12 = -3686552(0xffffffffffc7bf68, float:NaN)
            r0.startReplaceableGroup(r12)
            boolean r10 = r0.changed((java.lang.Object) r10)
            boolean r11 = r0.changed((java.lang.Object) r11)
            r10 = r10 | r11
            java.lang.Object r11 = r0.rememberedValue()
            if (r10 != 0) goto L_0x010e
            androidx.compose.runtime.Composer$Companion r10 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r10 = r10.getEmpty()
            if (r11 != r10) goto L_0x0116
        L_0x010e:
            com.designsystem.ds_stepper.StepperCounterComposablesKt$MM1StepperCounter$1$3$1 r11 = new com.designsystem.ds_stepper.StepperCounterComposablesKt$MM1StepperCounter$1$3$1
            r11.<init>(r3, r4)
            r0.updateRememberedValue(r11)
        L_0x0116:
            r0.endReplaceableGroup()
            r10 = r11
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            r12 = 0
            r13 = 0
            r8 = r2
            r11 = r0
            androidx.compose.ui.viewinterop.AndroidView_androidKt.AndroidView(r8, r9, r10, r11, r12, r13)
        L_0x0123:
            androidx.compose.runtime.ScopeUpdateScope r8 = r0.endRestartGroup()
            if (r8 != 0) goto L_0x012a
            goto L_0x013f
        L_0x012a:
            com.designsystem.ds_stepper.StepperCounterComposablesKt$MM1StepperCounter$2 r9 = new com.designsystem.ds_stepper.StepperCounterComposablesKt$MM1StepperCounter$2
            r0 = r9
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r6 = r23
            r7 = r25
            r0.<init>(r1, r2, r3, r4, r6, r7)
            r8.updateScope(r9)
        L_0x013f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_stepper.StepperCounterComposablesKt.m8617MM1StepperCounterww6aTOc(androidx.compose.foundation.layout.BoxScope, boolean, int, long, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    /* access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    @Composable
    /* renamed from: MM2StepperCounter-vRFhKjU  reason: not valid java name */
    public static final void m8618MM2StepperCountervRFhKjU(BoxScope boxScope, boolean z11, int i11, long j11, long j12, DSStepperStyle dSStepperStyle, boolean z12, Function0<Unit> function0, Composer composer, int i12) {
        int i13;
        boolean z13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        int i22;
        BoxScope boxScope2 = boxScope;
        boolean z14 = z11;
        boolean z15 = z12;
        Function0<Unit> function02 = function0;
        int i23 = i12;
        Composer startRestartGroup = composer.startRestartGroup(-1869376252);
        if ((i23 & 14) == 0) {
            if (startRestartGroup.changed((Object) boxScope2)) {
                i22 = 4;
            } else {
                i22 = 2;
            }
            i13 = i22 | i23;
        } else {
            i13 = i23;
        }
        if ((i23 & 112) == 0) {
            if (startRestartGroup.changed(z14)) {
                i21 = 32;
            } else {
                i21 = 16;
            }
            i13 |= i21;
        }
        if ((i23 & 896) == 0) {
            if (startRestartGroup.changed(i11)) {
                i19 = 256;
            } else {
                i19 = 128;
            }
            i13 |= i19;
        } else {
            int i24 = i11;
        }
        if ((i23 & 7168) == 0) {
            if (startRestartGroup.changed(j11)) {
                i18 = 2048;
            } else {
                i18 = 1024;
            }
            i13 |= i18;
        } else {
            long j13 = j11;
        }
        if ((57344 & i23) == 0) {
            if (startRestartGroup.changed(j12)) {
                i17 = 16384;
            } else {
                i17 = 8192;
            }
            i13 |= i17;
        } else {
            long j14 = j12;
        }
        DSStepperStyle dSStepperStyle2 = dSStepperStyle;
        if ((458752 & i23) == 0) {
            if (startRestartGroup.changed((Object) dSStepperStyle2)) {
                i16 = 131072;
            } else {
                i16 = 65536;
            }
            i13 |= i16;
        }
        if ((3670016 & i23) == 0) {
            if (startRestartGroup.changed(z15)) {
                i15 = 1048576;
            } else {
                i15 = 524288;
            }
            i13 |= i15;
        }
        if ((29360128 & i23) == 0) {
            if (startRestartGroup.changed((Object) function02)) {
                i14 = 8388608;
            } else {
                i14 = 4194304;
            }
            i13 |= i14;
        }
        if (((23967451 & i13) ^ 4793490) != 0 || !startRestartGroup.getSkipping()) {
            View view = (View) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
            Modifier testTag = TestTagKt.testTag(boxScope2.align(Modifier.Companion, Alignment.Companion.getCenter()), StepperCounter.StepperCounterMM2TestTag);
            if (!z15 || !z14) {
                z13 = false;
            } else {
                z13 = true;
            }
            Modifier r12 = ClickableKt.m194clickableO2vRcR0$default(testTag, InteractionSourceKt.MutableInteractionSource(), (Indication) null, z13, (String) null, (Role) null, new StepperCounterComposablesKt$MM2StepperCounter$1$1(view, function02), 24, (Object) null);
            DSTheme dSTheme = DSTheme.INSTANCE;
            int i25 = i13 >> 3;
            CounterComposablesKt.m8319CounterComposablesT9BRK9s(r12, i11, j11, j12, dSTheme.getDimens(startRestartGroup, 0).m8847getDsXxxlD9Ej5fM(), dSTheme.getDimens(startRestartGroup, 0).m8845getDsXxlD9Ej5fM(), dSStepperStyle.getTextStyle(), (Shape) null, startRestartGroup, (i25 & 112) | (i25 & 896) | (i25 & 7168), 128);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new StepperCounterComposablesKt$MM2StepperCounter$2(boxScope, z11, i11, j11, j12, dSStepperStyle, z12, function0, i12));
        }
    }

    @SuppressLint({"MissingPermission"})
    @Composable
    /* renamed from: StepperCounter-Y0xEhic  reason: not valid java name */
    public static final void m8619StepperCounterY0xEhic(boolean z11, int i11, long j11, long j12, @NotNull DSStepperStyle dSStepperStyle, @NotNull MM2Properties mM2Properties, @NotNull Function0<Unit> function0, @Nullable Composer composer, int i12) {
        int i13;
        Composer composer2;
        Modifier modifier;
        long j13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i21;
        boolean z12 = z11;
        DSStepperStyle dSStepperStyle2 = dSStepperStyle;
        MM2Properties mM2Properties2 = mM2Properties;
        Function0<Unit> function02 = function0;
        int i22 = i12;
        Intrinsics.checkNotNullParameter(dSStepperStyle2, "style");
        Intrinsics.checkNotNullParameter(mM2Properties2, "mm2Properties");
        Intrinsics.checkNotNullParameter(function02, "onTap");
        Composer startRestartGroup = composer.startRestartGroup(-806833009);
        if ((i22 & 14) == 0) {
            if (startRestartGroup.changed(z12)) {
                i21 = 4;
            } else {
                i21 = 2;
            }
            i13 = i21 | i22;
        } else {
            i13 = i22;
        }
        int i23 = i11;
        if ((i22 & 112) == 0) {
            if (startRestartGroup.changed(i23)) {
                i19 = 32;
            } else {
                i19 = 16;
            }
            i13 |= i19;
        }
        long j14 = j11;
        if ((i22 & 896) == 0) {
            if (startRestartGroup.changed(j14)) {
                i18 = 256;
            } else {
                i18 = 128;
            }
            i13 |= i18;
        }
        long j15 = j12;
        if ((i22 & 7168) == 0) {
            if (startRestartGroup.changed(j15)) {
                i17 = 2048;
            } else {
                i17 = 1024;
            }
            i13 |= i17;
        }
        if ((i22 & 57344) == 0) {
            if (startRestartGroup.changed((Object) dSStepperStyle2)) {
                i16 = 16384;
            } else {
                i16 = 8192;
            }
            i13 |= i16;
        }
        if ((i22 & Opcodes.ASM7) == 0) {
            if (startRestartGroup.changed((Object) mM2Properties2)) {
                i15 = 131072;
            } else {
                i15 = 65536;
            }
            i13 |= i15;
        }
        if ((3670016 & i22) == 0) {
            if (startRestartGroup.changed((Object) function02)) {
                i14 = 1048576;
            } else {
                i14 = 524288;
            }
            i13 |= i14;
        }
        if (((2995931 & i13) ^ 599186) != 0 || !startRestartGroup.getSkipping()) {
            if (!z12) {
                startRestartGroup.startReplaceableGroup(-806832773);
                startRestartGroup.endReplaceableGroup();
                modifier = SizeKt.wrapContentWidth$default(Modifier.Companion, (Alignment.Horizontal) null, false, 3, (Object) null);
            } else {
                startRestartGroup.startReplaceableGroup(-806832724);
                modifier = SizeKt.m563width3ABfNKs(Modifier.Companion, DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8845getDsXxlD9Ej5fM());
                startRestartGroup.endReplaceableGroup();
            }
            if (!mM2Properties.isEnabled()) {
                startRestartGroup.startReplaceableGroup(-806832619);
                j13 = DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8762getDsNeutral200d7_KjU();
                startRestartGroup.endReplaceableGroup();
            } else {
                startRestartGroup.startReplaceableGroup(-806832571);
                startRestartGroup.endReplaceableGroup();
                j13 = j14;
            }
            startRestartGroup.startReplaceableGroup(-1990474327);
            MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(1376089335);
            Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(modifier);
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
            Composer r52 = Updater.m2536constructorimpl(startRestartGroup);
            Updater.m2543setimpl(r52, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m2543setimpl(r52, density, companion.getSetDensity());
            Updater.m2543setimpl(r52, layoutDirection, companion.getSetLayoutDirection());
            startRestartGroup.enableReusing();
            materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            startRestartGroup.startReplaceableGroup(-1253629305);
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (mM2Properties.isMM2()) {
                startRestartGroup.startReplaceableGroup(-401785151);
                int i24 = i13 << 3;
                Composer composer3 = startRestartGroup;
                m8618MM2StepperCountervRFhKjU(boxScopeInstance, z11, i11, j13, j12, dSStepperStyle, mM2Properties.isEnabled(), function0, startRestartGroup, (i24 & 112) | 6 | (i24 & 896) | (57344 & i24) | (458752 & i24) | (i24 & 29360128));
                composer3.endReplaceableGroup();
                composer2 = composer3;
            } else {
                composer2 = startRestartGroup;
                composer2.startReplaceableGroup(-401784779);
                int i25 = i13 << 3;
                m8617MM1StepperCounterww6aTOc(boxScopeInstance, z11, i11, j13, function0, composer2, (i25 & 896) | (i25 & 112) | 6 | ((i13 >> 6) & 57344));
                composer2.endReplaceableGroup();
            }
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
            composer2.endNode();
            composer2.endReplaceableGroup();
            composer2.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            StepperCounterComposablesKt$StepperCounter$2 stepperCounterComposablesKt$StepperCounter$2 = r0;
            StepperCounterComposablesKt$StepperCounter$2 stepperCounterComposablesKt$StepperCounter$22 = new StepperCounterComposablesKt$StepperCounter$2(z11, i11, j11, j12, dSStepperStyle, mM2Properties, function0, i12);
            endRestartGroup.updateScope(stepperCounterComposablesKt$StepperCounter$2);
        }
    }
}
