package com.designsystem.ds_progressive_offer;

import android.os.CountDownTimer;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.designsystem.ds_progress_bar.DSProgressBarKt;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import net.bytebuddy.jar.asm.Opcodes;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0003¢\u0006\u0002\u0010\t\u001a-\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0006H\u0003¢\u0006\u0002\u0010\u0013\u001aK\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003H\u0003¢\u0006\u0002\u0010\u001c\u001aS\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001b\u001a\u00020\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\f2\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00172\u0006\u0010\r\u001a\u00020\u0003H\u0001¢\u0006\u0002\u0010!\u001a!\u0010\"\u001a\u00020\u00172\u0006\u0010#\u001a\u00020\u00172\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010$\u001a,\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00172\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00010)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010)H\u0002¨\u0006+"}, d2 = {"CelebrationAnimation", "", "startAnimation", "", "headlineIconOpacity", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "celebrationIconScale", "(ZLandroidx/compose/animation/core/Animatable;Landroidx/compose/animation/core/Animatable;Landroidx/compose/runtime/Composer;I)V", "OfferDescriptor", "descriptor", "", "showTier", "opacity", "startCelebrationAnimation", "(Ljava/lang/String;ZFZLandroidx/compose/runtime/Composer;I)V", "OfferProgress", "indicatorProgress", "(FLandroidx/compose/runtime/Composer;I)V", "OfferTier", "showTimer", "durationInSeconds", "", "headline", "headlineIcon", "", "progress", "(ZJLjava/lang/String;Ljava/lang/Integer;FFZLandroidx/compose/runtime/Composer;II)V", "ProgressiveOfferSurface", "modifier", "Landroidx/compose/ui/Modifier;", "expirationTimestamp", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;FLjava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;ZLandroidx/compose/runtime/Composer;II)V", "calculateRemainingTime", "currentTime", "(JLjava/lang/Long;)J", "getCountDownTimer", "Landroid/os/CountDownTimer;", "remainingTime", "onTick", "Lkotlin/Function0;", "onFinish", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ProgressiveOfferComposablesKt {
    /* access modifiers changed from: private */
    @Composable
    public static final void CelebrationAnimation(boolean z11, Animatable<Float, AnimationVector1D> animatable, Animatable<Float, AnimationVector1D> animatable2, Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        Composer startRestartGroup = composer.startRestartGroup(155607654);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed(z11)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i12 = i15 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) animatable)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i12 |= i14;
        }
        if ((i11 & 896) == 0) {
            if (startRestartGroup.changed((Object) animatable2)) {
                i13 = 256;
            } else {
                i13 = 128;
            }
            i12 |= i13;
        }
        if (((i12 & 731) ^ Opcodes.I2C) != 0 || !startRestartGroup.getSkipping()) {
            EffectsKt.LaunchedEffect((Object) Boolean.valueOf(z11), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new ProgressiveOfferComposablesKt$CelebrationAnimation$1(z11, animatable, animatable2, (Continuation<? super ProgressiveOfferComposablesKt$CelebrationAnimation$1>) null), startRestartGroup, i12 & 14);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ProgressiveOfferComposablesKt$CelebrationAnimation$2(z11, animatable, animatable2, i11));
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v0, resolved type: kotlin.jvm.functions.Function1} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OfferDescriptor(java.lang.String r34, boolean r35, float r36, boolean r37, androidx.compose.runtime.Composer r38, int r39) {
        /*
            r2 = r35
            r3 = r36
            r4 = r37
            r5 = r39
            r0 = 131479969(0x7d639a1, float:3.2233012E-34)
            r1 = r38
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r5 & 14
            r6 = 2
            if (r1 != 0) goto L_0x0023
            r1 = r34
            boolean r7 = r0.changed((java.lang.Object) r1)
            if (r7 == 0) goto L_0x0020
            r7 = 4
            goto L_0x0021
        L_0x0020:
            r7 = r6
        L_0x0021:
            r7 = r7 | r5
            goto L_0x0026
        L_0x0023:
            r1 = r34
            r7 = r5
        L_0x0026:
            r8 = r5 & 112(0x70, float:1.57E-43)
            if (r8 != 0) goto L_0x0036
            boolean r8 = r0.changed((boolean) r2)
            if (r8 == 0) goto L_0x0033
            r8 = 32
            goto L_0x0035
        L_0x0033:
            r8 = 16
        L_0x0035:
            r7 = r7 | r8
        L_0x0036:
            r8 = r5 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x0046
            boolean r8 = r0.changed((float) r3)
            if (r8 == 0) goto L_0x0043
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0045
        L_0x0043:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0045:
            r7 = r7 | r8
        L_0x0046:
            r8 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x0056
            boolean r8 = r0.changed((boolean) r4)
            if (r8 == 0) goto L_0x0053
            r8 = 2048(0x800, float:2.87E-42)
            goto L_0x0055
        L_0x0053:
            r8 = 1024(0x400, float:1.435E-42)
        L_0x0055:
            r7 = r7 | r8
        L_0x0056:
            r15 = r7
            r7 = r15 & 5851(0x16db, float:8.199E-42)
            r7 = r7 ^ 1170(0x492, float:1.64E-42)
            if (r7 != 0) goto L_0x0069
            boolean r7 = r0.getSkipping()
            if (r7 != 0) goto L_0x0064
            goto L_0x0069
        L_0x0064:
            r0.skipToGroupEnd()
            goto L_0x0381
        L_0x0069:
            r7 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r7)
            java.lang.Object r8 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r16 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r9 = r16.getEmpty()
            r10 = 0
            r14 = 0
            if (r8 != r9) goto L_0x0086
            r8 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.animation.core.Animatable r8 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r8, r10, r6, r14)
            r0.updateRememberedValue(r8)
        L_0x0086:
            r0.endReplaceableGroup()
            r13 = r8
            androidx.compose.animation.core.Animatable r13 = (androidx.compose.animation.core.Animatable) r13
            r0.startReplaceableGroup(r7)
            java.lang.Object r8 = r0.rememberedValue()
            java.lang.Object r9 = r16.getEmpty()
            if (r8 != r9) goto L_0x00a0
            androidx.compose.animation.core.Animatable r8 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r10, r10, r6, r14)
            r0.updateRememberedValue(r8)
        L_0x00a0:
            r0.endReplaceableGroup()
            r12 = r8
            androidx.compose.animation.core.Animatable r12 = (androidx.compose.animation.core.Animatable) r12
            r0.startReplaceableGroup(r7)
            java.lang.Object r7 = r0.rememberedValue()
            java.lang.Object r8 = r16.getEmpty()
            if (r7 != r8) goto L_0x00c0
            androidx.compose.ui.Alignment$Companion r7 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r7 = r7.getTop()
            androidx.compose.runtime.MutableState r7 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r7, r14, r6, r14)
            r0.updateRememberedValue(r7)
        L_0x00c0:
            r0.endReplaceableGroup()
            r11 = r7
            androidx.compose.runtime.MutableState r11 = (androidx.compose.runtime.MutableState) r11
            androidx.compose.ui.Modifier$Companion r9 = androidx.compose.ui.Modifier.Companion
            r18 = 0
            com.designsystem.ds_theme.DSTheme r10 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r8 = 0
            com.designsystem.ds_theme.DSDimens r6 = r10.getDimens(r0, r8)
            float r19 = r6.m8846getDsXxsD9Ej5fM()
            r20 = 0
            r21 = 0
            r22 = 13
            r23 = 0
            r17 = r9
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r17, r18, r19, r20, r21, r22, r23)
            r7 = -1989997546(0xffffffff89630c16, float:-2.7329814E-33)
            r0.startReplaceableGroup(r7)
            androidx.compose.foundation.layout.Arrangement r7 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r7 = r7.getStart()
            androidx.compose.ui.Alignment$Companion r17 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r14 = r17.getTop()
            androidx.compose.ui.layout.MeasurePolicy r7 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r7, r14, r0, r8)
            r14 = 1376089335(0x520574f7, float:1.43298249E11)
            r0.startReplaceableGroup(r14)
            androidx.compose.runtime.ProvidableCompositionLocal r14 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r14 = r0.consume(r14)
            androidx.compose.ui.unit.Density r14 = (androidx.compose.ui.unit.Density) r14
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            androidx.compose.ui.node.ComposeUiNode$Companion r20 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r1 = r20.getConstructor()
            kotlin.jvm.functions.Function3 r6 = androidx.compose.ui.layout.LayoutKt.materializerOf(r6)
            androidx.compose.runtime.Applier r5 = r0.getApplier()
            boolean r5 = r5 instanceof androidx.compose.runtime.Applier
            if (r5 != 0) goto L_0x0128
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0128:
            r0.startReusableNode()
            boolean r5 = r0.getInserting()
            if (r5 == 0) goto L_0x0135
            r0.createNode(r1)
            goto L_0x0138
        L_0x0135:
            r0.useNode()
        L_0x0138:
            r0.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r5 = r20.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r7, r5)
            kotlin.jvm.functions.Function2 r5 = r20.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r14, r5)
            kotlin.jvm.functions.Function2 r5 = r20.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r8, r5)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            r5 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
            r6.invoke(r1, r0, r7)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r5 = -326682743(0xffffffffec873789, float:-1.307738E27)
            r0.startReplaceableGroup(r5)
            androidx.compose.foundation.layout.RowScopeInstance r5 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            if (r2 != 0) goto L_0x02d2
            r6 = -973925669(0xffffffffc5f312db, float:-7778.357)
            r0.startReplaceableGroup(r6)
            androidx.compose.ui.Alignment$Vertical r6 = m8515OfferDescriptor$lambda29(r11)
            androidx.compose.ui.Modifier r5 = r5.align(r9, r6)
            r6 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r0.startReplaceableGroup(r6)
            androidx.compose.ui.Alignment r6 = r17.getTopStart()
            r7 = 0
            androidx.compose.ui.layout.MeasurePolicy r6 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r6, r7, r0, r7)
            r7 = 1376089335(0x520574f7, float:1.43298249E11)
            r0.startReplaceableGroup(r7)
            androidx.compose.runtime.ProvidableCompositionLocal r7 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r7 = r0.consume(r7)
            androidx.compose.ui.unit.Density r7 = (androidx.compose.ui.unit.Density) r7
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.ui.unit.LayoutDirection r8 = (androidx.compose.ui.unit.LayoutDirection) r8
            kotlin.jvm.functions.Function0 r14 = r20.getConstructor()
            kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r5)
            androidx.compose.runtime.Applier r1 = r0.getApplier()
            boolean r1 = r1 instanceof androidx.compose.runtime.Applier
            if (r1 != 0) goto L_0x01c1
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x01c1:
            r0.startReusableNode()
            boolean r1 = r0.getInserting()
            if (r1 == 0) goto L_0x01ce
            r0.createNode(r14)
            goto L_0x01d1
        L_0x01ce:
            r0.useNode()
        L_0x01d1:
            r0.disableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r14 = r20.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r6, r14)
            kotlin.jvm.functions.Function2 r6 = r20.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r7, r6)
            kotlin.jvm.functions.Function2 r6 = r20.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r1, r8, r6)
            r0.enableReusing()
            androidx.compose.runtime.Composer r1 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r1 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r1)
            r6 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r5.invoke(r1, r0, r7)
            r1 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r1)
            r1 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r0.startReplaceableGroup(r1)
            androidx.compose.foundation.layout.BoxScopeInstance r1 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r1 = com.designsystem.marshmallow.R.drawable.ds_promo_filled
            androidx.compose.ui.graphics.painter.Painter r1 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r1, r0, r6)
            java.lang.Object r5 = r13.getValue()
            java.lang.Number r5 = (java.lang.Number) r5
            float r5 = r5.floatValue()
            androidx.compose.ui.Modifier r20 = androidx.compose.ui.draw.AlphaKt.alpha(r9, r5)
            r21 = 0
            r22 = 0
            com.designsystem.ds_theme.DSDimens r5 = r10.getDimens(r0, r6)
            float r23 = r5.m8848getDsXxxsD9Ej5fM()
            r24 = 0
            r25 = 11
            r26 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r20, r21, r22, r23, r24, r25, r26)
            r8 = 0
            com.designsystem.ds_theme.DSDimens r6 = r10.getDimens(r0, r8)
            float r6 = r6.m8842getDsSD9Ej5fM()
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.m558size3ABfNKs(r5, r6)
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferDescriptor$1$1$1 r6 = com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferDescriptor$1$1$1.INSTANCE
            r14 = 1
            r7 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r5, r8, r6, r14, r7)
            com.designsystem.ds_theme.DSColors r6 = r10.getColors(r0, r8)
            long r18 = r6.m8798getDsPromo1000d7_KjU()
            r20 = 56
            r21 = 0
            r6 = r1
            r1 = 0
            r7 = r1
            r1 = r8
            r8 = r5
            r5 = r9
            r17 = r15
            r15 = r10
            r9 = r18
            r30 = r11
            r11 = r0
            r31 = r12
            r12 = r20
            r32 = r13
            r13 = r21
            androidx.compose.material.IconKt.m1278Iconww6aTOc((androidx.compose.ui.graphics.painter.Painter) r6, (java.lang.String) r7, (androidx.compose.ui.Modifier) r8, (long) r9, (androidx.compose.runtime.Composer) r11, (int) r12, (int) r13)
            int r6 = com.designsystem.marshmallow.R.drawable.ds_celebration
            androidx.compose.ui.graphics.painter.Painter r6 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r6, r0, r1)
            r7 = 0
            java.lang.Object r8 = r31.getValue()
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            androidx.compose.ui.Modifier r18 = androidx.compose.ui.draw.ScaleKt.scale(r5, r8)
            r19 = 0
            r20 = 0
            com.designsystem.ds_theme.DSDimens r8 = r15.getDimens(r0, r1)
            float r21 = r8.m8848getDsXxxsD9Ej5fM()
            r23 = 11
            r24 = 0
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r18, r19, r20, r21, r22, r23, r24)
            com.designsystem.ds_theme.DSDimens r9 = r15.getDimens(r0, r1)
            float r9 = r9.m8842getDsSD9Ej5fM()
            androidx.compose.ui.Modifier r8 = androidx.compose.foundation.layout.SizeKt.m558size3ABfNKs(r8, r9)
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferDescriptor$1$1$2 r9 = com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferDescriptor$1$1$2.INSTANCE
            r10 = 0
            androidx.compose.ui.Modifier r8 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r8, r1, r9, r14, r10)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r14 = 56
            r18 = 120(0x78, float:1.68E-43)
            r13 = r0
            r4 = r15
            r33 = r17
            r15 = r18
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r6, (java.lang.String) r7, (androidx.compose.ui.Modifier) r8, (androidx.compose.ui.Alignment) r9, (androidx.compose.ui.layout.ContentScale) r10, (float) r11, (androidx.compose.ui.graphics.ColorFilter) r12, (androidx.compose.runtime.Composer) r13, (int) r14, (int) r15)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            goto L_0x02e6
        L_0x02d2:
            r5 = r9
            r4 = r10
            r30 = r11
            r31 = r12
            r32 = r13
            r33 = r15
            r1 = 0
            r6 = -973924553(0xffffffffc5f31737, float:-7778.902)
            r0.startReplaceableGroup(r6)
            r0.endReplaceableGroup()
        L_0x02e6:
            androidx.compose.ui.Modifier r7 = androidx.compose.ui.draw.AlphaKt.alpha(r5, r3)
            com.designsystem.ds_theme.DSTypography r5 = r4.getTypography(r0, r1)
            androidx.compose.ui.text.TextStyle r25 = r5.getDsBody1Compact()
            com.designsystem.ds_theme.DSColors r1 = r4.getColors(r0, r1)
            long r8 = r1.m8798getDsPromo1000d7_KjU()
            androidx.compose.ui.text.style.TextOverflow$Companion r1 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r21 = r1.m5403getEllipsisgIe3tQ8()
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r4 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r22 = 0
            r23 = 2
            r1 = -3686930(0xffffffffffc7bdee, float:NaN)
            r0.startReplaceableGroup(r1)
            r1 = r30
            boolean r6 = r0.changed((java.lang.Object) r1)
            java.lang.Object r15 = r0.rememberedValue()
            if (r6 != 0) goto L_0x0329
            java.lang.Object r6 = r16.getEmpty()
            if (r15 != r6) goto L_0x0331
        L_0x0329:
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferDescriptor$1$2$1 r15 = new com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferDescriptor$1$2$1
            r15.<init>(r1)
            r0.updateRememberedValue(r15)
        L_0x0331:
            r0.endReplaceableGroup()
            r24 = r15
            kotlin.jvm.functions.Function1 r24 = (kotlin.jvm.functions.Function1) r24
            r27 = r33 & 14
            r28 = 3136(0xc40, float:4.394E-42)
            r29 = 6136(0x17f8, float:8.598E-42)
            r6 = r34
            r15 = r4
            r26 = r0
            androidx.compose.material.TextKt.m1461TextfLXpl1I(r6, r7, r8, r10, r12, r13, r14, r15, r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            if (r2 != 0) goto L_0x0367
            r1 = -973924026(0xffffffffc5f31946, float:-7779.159)
            r0.startReplaceableGroup(r1)
            int r1 = r33 >> 9
            r1 = r1 & 14
            int r4 = androidx.compose.animation.core.Animatable.$stable
            int r5 = r4 << 3
            r1 = r1 | r5
            int r4 = r4 << 6
            r1 = r1 | r4
            r4 = r37
            r5 = r31
            r8 = r32
            CelebrationAnimation(r4, r8, r5, r0, r1)
            r0.endReplaceableGroup()
            goto L_0x0372
        L_0x0367:
            r4 = r37
            r1 = -973923848(0xffffffffc5f319f8, float:-7779.246)
            r0.startReplaceableGroup(r1)
            r0.endReplaceableGroup()
        L_0x0372:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
        L_0x0381:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x0388
            goto L_0x039b
        L_0x0388:
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferDescriptor$2 r7 = new com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferDescriptor$2
            r0 = r7
            r1 = r34
            r2 = r35
            r3 = r36
            r4 = r37
            r5 = r39
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x039b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt.OfferDescriptor(java.lang.String, boolean, float, boolean, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: OfferDescriptor$lambda-29  reason: not valid java name */
    private static final Alignment.Vertical m8515OfferDescriptor$lambda29(MutableState<Alignment.Vertical> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: OfferDescriptor$lambda-30  reason: not valid java name */
    public static final void m8516OfferDescriptor$lambda30(MutableState<Alignment.Vertical> mutableState, Alignment.Vertical vertical) {
        mutableState.setValue(vertical);
    }

    /* access modifiers changed from: private */
    @Composable
    public static final void OfferProgress(float f11, Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(1200885357);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed(f11)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            startRestartGroup.startReplaceableGroup(-3687241);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), (SnapshotMutationPolicy) null, 2, (Object) null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            MutableState mutableState = (MutableState) rememberedValue;
            int i14 = i12 & 14;
            DSProgressBarKt.m8514DSProgressBargKt5lHk((Modifier) null, m8519OfferProgress$lambda43(AnimateAsStateKt.animateFloatAsState(f11, AnimationSpecKt.tween$default(500, 0, EasingKt.getLinearEasing(), 2, (Object) null), 0.0f, (Function1<? super Float, Unit>) null, startRestartGroup, i14, 12)), Color.m2909boximpl(DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8798getDsPromo1000d7_KjU()), startRestartGroup, 0, 1);
            Float valueOf = Float.valueOf(f11);
            Float valueOf2 = Float.valueOf(f11);
            startRestartGroup.startReplaceableGroup(-3686552);
            boolean changed = startRestartGroup.changed((Object) valueOf2) | startRestartGroup.changed((Object) mutableState);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new ProgressiveOfferComposablesKt$OfferProgress$1$1(f11, mutableState, (Continuation<? super ProgressiveOfferComposablesKt$OfferProgress$1$1>) null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect((Object) valueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) (Function2) rememberedValue2, startRestartGroup, i14);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ProgressiveOfferComposablesKt$OfferProgress$2(f11, i11));
        }
    }

    /* renamed from: OfferProgress$lambda-41  reason: not valid java name */
    private static final float m8517OfferProgress$lambda41(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: OfferProgress$lambda-42  reason: not valid java name */
    public static final void m8518OfferProgress$lambda42(MutableState<Float> mutableState, float f11) {
        mutableState.setValue(Float.valueOf(f11));
    }

    /* renamed from: OfferProgress$lambda-43  reason: not valid java name */
    private static final float m8519OfferProgress$lambda43(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0409  */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c1  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void OfferTier(boolean r36, long r37, java.lang.String r39, @androidx.annotation.DrawableRes java.lang.Integer r40, float r41, float r42, boolean r43, androidx.compose.runtime.Composer r44, int r45, int r46) {
        /*
            r1 = r36
            r2 = r37
            r4 = r39
            r6 = r41
            r8 = r43
            r9 = r45
            r0 = -105961758(0xfffffffff9af26e2, float:-1.1368007E35)
            r5 = r44
            androidx.compose.runtime.Composer r0 = r5.startRestartGroup(r0)
            r5 = r46 & 1
            r7 = 2
            if (r5 == 0) goto L_0x001d
            r5 = r9 | 6
            goto L_0x002d
        L_0x001d:
            r5 = r9 & 14
            if (r5 != 0) goto L_0x002c
            boolean r5 = r0.changed((boolean) r1)
            if (r5 == 0) goto L_0x0029
            r5 = 4
            goto L_0x002a
        L_0x0029:
            r5 = r7
        L_0x002a:
            r5 = r5 | r9
            goto L_0x002d
        L_0x002c:
            r5 = r9
        L_0x002d:
            r10 = r46 & 2
            if (r10 == 0) goto L_0x0034
            r5 = r5 | 48
            goto L_0x0044
        L_0x0034:
            r10 = r9 & 112(0x70, float:1.57E-43)
            if (r10 != 0) goto L_0x0044
            boolean r10 = r0.changed((long) r2)
            if (r10 == 0) goto L_0x0041
            r10 = 32
            goto L_0x0043
        L_0x0041:
            r10 = 16
        L_0x0043:
            r5 = r5 | r10
        L_0x0044:
            r10 = r46 & 4
            if (r10 == 0) goto L_0x004b
            r5 = r5 | 384(0x180, float:5.38E-43)
            goto L_0x005b
        L_0x004b:
            r10 = r9 & 896(0x380, float:1.256E-42)
            if (r10 != 0) goto L_0x005b
            boolean r10 = r0.changed((java.lang.Object) r4)
            if (r10 == 0) goto L_0x0058
            r10 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r10 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r5 = r5 | r10
        L_0x005b:
            r10 = r46 & 8
            if (r10 == 0) goto L_0x0062
            r5 = r5 | 3072(0xc00, float:4.305E-42)
            goto L_0x0075
        L_0x0062:
            r11 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r11 != 0) goto L_0x0075
            r11 = r40
            boolean r12 = r0.changed((java.lang.Object) r11)
            if (r12 == 0) goto L_0x0071
            r12 = 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x0071:
            r12 = 1024(0x400, float:1.435E-42)
        L_0x0073:
            r5 = r5 | r12
            goto L_0x0077
        L_0x0075:
            r11 = r40
        L_0x0077:
            r12 = r46 & 16
            if (r12 == 0) goto L_0x007e
            r5 = r5 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0090
        L_0x007e:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r9
            if (r12 != 0) goto L_0x0090
            boolean r12 = r0.changed((float) r6)
            if (r12 == 0) goto L_0x008d
            r12 = 16384(0x4000, float:2.2959E-41)
            goto L_0x008f
        L_0x008d:
            r12 = 8192(0x2000, float:1.14794E-41)
        L_0x008f:
            r5 = r5 | r12
        L_0x0090:
            r12 = r46 & 64
            if (r12 == 0) goto L_0x0098
            r12 = 1572864(0x180000, float:2.204052E-39)
        L_0x0096:
            r5 = r5 | r12
            goto L_0x00a9
        L_0x0098:
            r12 = 3670016(0x380000, float:5.142788E-39)
            r12 = r12 & r9
            if (r12 != 0) goto L_0x00a9
            boolean r12 = r0.changed((boolean) r8)
            if (r12 == 0) goto L_0x00a6
            r12 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x0096
        L_0x00a6:
            r12 = 524288(0x80000, float:7.34684E-40)
            goto L_0x0096
        L_0x00a9:
            r12 = 2668251(0x28b6db, float:3.739016E-39)
            r12 = r12 & r5
            r13 = 533650(0x82492, float:7.47803E-40)
            r12 = r12 ^ r13
            if (r12 != 0) goto L_0x00c1
            boolean r12 = r0.getSkipping()
            if (r12 != 0) goto L_0x00ba
            goto L_0x00c1
        L_0x00ba:
            r0.skipToGroupEnd()
            r9 = r8
            r5 = r11
            goto L_0x0402
        L_0x00c1:
            r15 = 0
            if (r10 == 0) goto L_0x00c7
            r34 = r15
            goto L_0x00c9
        L_0x00c7:
            r34 = r11
        L_0x00c9:
            r10 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r10)
            java.lang.Object r11 = r0.rememberedValue()
            androidx.compose.runtime.Composer$Companion r12 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r13 = r12.getEmpty()
            if (r11 != r13) goto L_0x00ef
            if (r34 != 0) goto L_0x00e0
            int r11 = com.designsystem.marshmallow.R.drawable.ds_gem
            goto L_0x00e4
        L_0x00e0:
            int r11 = r34.intValue()
        L_0x00e4:
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            androidx.compose.runtime.MutableState r11 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r11, r15, r7, r15)
            r0.updateRememberedValue(r11)
        L_0x00ef:
            r0.endReplaceableGroup()
            androidx.compose.runtime.MutableState r11 = (androidx.compose.runtime.MutableState) r11
            r0.startReplaceableGroup(r10)
            java.lang.Object r13 = r0.rememberedValue()
            java.lang.Object r14 = r12.getEmpty()
            r10 = 0
            if (r13 != r14) goto L_0x010b
            r13 = 1065353216(0x3f800000, float:1.0)
            androidx.compose.animation.core.Animatable r13 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r13, r10, r7, r15)
            r0.updateRememberedValue(r13)
        L_0x010b:
            r0.endReplaceableGroup()
            r14 = r13
            androidx.compose.animation.core.Animatable r14 = (androidx.compose.animation.core.Animatable) r14
            r13 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r0.startReplaceableGroup(r13)
            java.lang.Object r13 = r0.rememberedValue()
            java.lang.Object r12 = r12.getEmpty()
            if (r13 != r12) goto L_0x0128
            androidx.compose.animation.core.Animatable r13 = androidx.compose.animation.core.AnimatableKt.Animatable$default(r10, r10, r7, r15)
            r0.updateRememberedValue(r13)
        L_0x0128:
            r0.endReplaceableGroup()
            r7 = r13
            androidx.compose.animation.core.Animatable r7 = (androidx.compose.animation.core.Animatable) r7
            androidx.compose.ui.Modifier$Companion r13 = androidx.compose.ui.Modifier.Companion
            r17 = 0
            r18 = 0
            r19 = 0
            com.designsystem.ds_theme.DSTheme r12 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r10 = 0
            com.designsystem.ds_theme.DSDimens r16 = r12.getDimens(r0, r10)
            float r20 = r16.m8846getDsXxsD9Ej5fM()
            r21 = 7
            r22 = 0
            r16 = r13
            androidx.compose.ui.Modifier r16 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r16, r17, r18, r19, r20, r21, r22)
            androidx.compose.ui.Alignment$Companion r17 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r15 = r17.getCenterVertically()
            r10 = -1989997546(0xffffffff89630c16, float:-2.7329814E-33)
            r0.startReplaceableGroup(r10)
            androidx.compose.foundation.layout.Arrangement r10 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r10 = r10.getStart()
            r9 = 0
            androidx.compose.ui.layout.MeasurePolicy r10 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r10, r15, r0, r9)
            r9 = 1376089335(0x520574f7, float:1.43298249E11)
            r0.startReplaceableGroup(r9)
            androidx.compose.runtime.ProvidableCompositionLocal r15 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r15 = r0.consume(r15)
            androidx.compose.ui.unit.Density r15 = (androidx.compose.ui.unit.Density) r15
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            androidx.compose.ui.node.ComposeUiNode$Companion r19 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r8 = r19.getConstructor()
            r35 = r5
            kotlin.jvm.functions.Function3 r5 = androidx.compose.ui.layout.LayoutKt.materializerOf(r16)
            androidx.compose.runtime.Applier r2 = r0.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x0193
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0193:
            r0.startReusableNode()
            boolean r2 = r0.getInserting()
            if (r2 == 0) goto L_0x01a0
            r0.createNode(r8)
            goto L_0x01a3
        L_0x01a0:
            r0.useNode()
        L_0x01a3:
            r0.disableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r3 = r19.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r2, r10, r3)
            kotlin.jvm.functions.Function2 r3 = r19.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r2, r15, r3)
            kotlin.jvm.functions.Function2 r3 = r19.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r2, r9, r3)
            r0.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r2)
            r3 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            r5.invoke(r2, r0, r8)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            r3 = -326682743(0xffffffffec873789, float:-1.307738E27)
            r0.startReplaceableGroup(r3)
            androidx.compose.foundation.layout.RowScopeInstance r3 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            r5 = -1990474327(0xffffffff895bc5a9, float:-2.6454105E-33)
            r0.startReplaceableGroup(r5)
            androidx.compose.ui.Alignment r5 = r17.getTopStart()
            r8 = 0
            androidx.compose.ui.layout.MeasurePolicy r5 = androidx.compose.foundation.layout.BoxKt.rememberBoxMeasurePolicy(r5, r8, r0, r8)
            r8 = 1376089335(0x520574f7, float:1.43298249E11)
            r0.startReplaceableGroup(r8)
            androidx.compose.runtime.ProvidableCompositionLocal r8 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r8 = r0.consume(r8)
            androidx.compose.ui.unit.Density r8 = (androidx.compose.ui.unit.Density) r8
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.ui.unit.LayoutDirection r9 = (androidx.compose.ui.unit.LayoutDirection) r9
            kotlin.jvm.functions.Function0 r10 = r19.getConstructor()
            kotlin.jvm.functions.Function3 r15 = androidx.compose.ui.layout.LayoutKt.materializerOf(r13)
            androidx.compose.runtime.Applier r2 = r0.getApplier()
            boolean r2 = r2 instanceof androidx.compose.runtime.Applier
            if (r2 != 0) goto L_0x021c
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x021c:
            r0.startReusableNode()
            boolean r2 = r0.getInserting()
            if (r2 == 0) goto L_0x0229
            r0.createNode(r10)
            goto L_0x022c
        L_0x0229:
            r0.useNode()
        L_0x022c:
            r0.disableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r10 = r19.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r2, r5, r10)
            kotlin.jvm.functions.Function2 r5 = r19.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r2, r8, r5)
            kotlin.jvm.functions.Function2 r5 = r19.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r2, r9, r5)
            r0.enableReusing()
            androidx.compose.runtime.Composer r2 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r2 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r2)
            r5 = 0
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
            r15.invoke(r2, r0, r8)
            r2 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r2)
            r2 = -1253629305(0xffffffffb5472287, float:-7.418352E-7)
            r0.startReplaceableGroup(r2)
            androidx.compose.foundation.layout.BoxScopeInstance r2 = androidx.compose.foundation.layout.BoxScopeInstance.INSTANCE
            int r2 = m8520OfferTier$lambda35(r11)
            androidx.compose.ui.graphics.painter.Painter r10 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r2, r0, r5)
            r11 = 0
            java.lang.Object r2 = r14.getValue()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.draw.AlphaKt.alpha(r13, r2)
            com.designsystem.ds_theme.DSDimens r8 = r12.getDimens(r0, r5)
            float r8 = r8.m8840getDsLD9Ej5fM()
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.SizeKt.m558size3ABfNKs(r2, r8)
            java.lang.String r8 = "ProgressiveOfferHeadlineIconTestTag"
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.platform.TestTagKt.testTag(r2, r8)
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferTier$1$1$1 r8 = com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferTier$1$1$1.INSTANCE
            r9 = 1
            r15 = 0
            androidx.compose.ui.Modifier r2 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r2, r5, r8, r9, r15)
            r8 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 56
            r20 = 120(0x78, float:1.68E-43)
            r9 = r12
            r12 = r2
            r2 = r13
            r13 = r8
            r8 = r14
            r14 = r16
            r15 = r17
            r16 = r18
            r17 = r0
            r18 = r19
            r19 = r20
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r10, (java.lang.String) r11, (androidx.compose.ui.Modifier) r12, (androidx.compose.ui.Alignment) r13, (androidx.compose.ui.layout.ContentScale) r14, (float) r15, (androidx.compose.ui.graphics.ColorFilter) r16, (androidx.compose.runtime.Composer) r17, (int) r18, (int) r19)
            int r10 = com.designsystem.marshmallow.R.drawable.ds_celebration
            androidx.compose.ui.graphics.painter.Painter r10 = androidx.compose.ui.res.PainterResources_androidKt.painterResource(r10, r0, r5)
            java.lang.Object r12 = r7.getValue()
            java.lang.Number r12 = (java.lang.Number) r12
            float r12 = r12.floatValue()
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.draw.ScaleKt.scale(r2, r12)
            com.designsystem.ds_theme.DSDimens r13 = r9.getDimens(r0, r5)
            float r13 = r13.m8840getDsLD9Ej5fM()
            androidx.compose.ui.Modifier r12 = androidx.compose.foundation.layout.SizeKt.m558size3ABfNKs(r12, r13)
            java.lang.String r13 = "ProgressiveOfferCelebrationIconTestTag"
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.platform.TestTagKt.testTag(r12, r13)
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferTier$1$1$2 r13 = com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferTier$1$1$2.INSTANCE
            r14 = 0
            r15 = 1
            androidx.compose.ui.Modifier r12 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r12, r5, r13, r15, r14)
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r18 = 56
            r19 = 120(0x78, float:1.68E-43)
            androidx.compose.foundation.ImageKt.Image((androidx.compose.ui.graphics.painter.Painter) r10, (java.lang.String) r11, (androidx.compose.ui.Modifier) r12, (androidx.compose.ui.Alignment) r13, (androidx.compose.ui.layout.ContentScale) r14, (float) r15, (androidx.compose.ui.graphics.ColorFilter) r16, (androidx.compose.runtime.Composer) r17, (int) r18, (int) r19)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r18 = 1065353216(0x3f800000, float:1.0)
            r19 = 0
            r20 = 2
            r21 = 0
            r16 = r3
            r17 = r2
            androidx.compose.ui.Modifier r10 = p.e.a(r16, r17, r18, r19, r20, r21)
            com.designsystem.ds_theme.DSDimens r3 = r9.getDimens(r0, r5)
            float r11 = r3.m8848getDsXxxsD9Ej5fM()
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 14
            r16 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r10, r11, r12, r13, r14, r15, r16)
            java.lang.String r10 = "ProgressiveOfferHeadlineTestTag"
            androidx.compose.ui.Modifier r3 = androidx.compose.ui.platform.TestTagKt.testTag(r3, r10)
            androidx.compose.ui.Modifier r11 = androidx.compose.ui.draw.AlphaKt.alpha(r3, r6)
            if (r4 == 0) goto L_0x0333
            r10 = r4
            goto L_0x0336
        L_0x0333:
            java.lang.String r3 = ""
            r10 = r3
        L_0x0336:
            com.designsystem.ds_theme.DSTypography r3 = r9.getTypography(r0, r5)
            androidx.compose.ui.text.TextStyle r29 = r3.getDsSubheading2()
            com.designsystem.ds_theme.DSColors r3 = r9.getColors(r0, r5)
            long r12 = r3.m8760getDsNeutral1000d7_KjU()
            androidx.compose.ui.text.style.TextOverflow$Companion r3 = androidx.compose.ui.text.style.TextOverflow.Companion
            int r25 = r3.m5403getEllipsisgIe3tQ8()
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 1
            r28 = 0
            r31 = 0
            r32 = 3136(0xc40, float:4.394E-42)
            r33 = 22520(0x57f8, float:3.1557E-41)
            r30 = r0
            androidx.compose.material.TextKt.m1461TextfLXpl1I(r10, r11, r12, r14, r16, r17, r18, r19, r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            if (r1 == 0) goto L_0x03d7
            r3 = -211826031(0xfffffffff35fca91, float:-1.7730572E31)
            r0.startReplaceableGroup(r3)
            r3 = 1000(0x3e8, float:1.401E-42)
            long r10 = (long) r3
            long r10 = r37 / r10
            java.lang.String r3 = android.text.format.DateUtils.formatElapsedTime(r10)
            r10 = r3
            com.designsystem.ds_theme.DSDimens r11 = r9.getDimens(r0, r5)
            float r17 = r11.m8844getDsXsD9Ej5fM()
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 14
            r22 = 0
            r16 = r2
            androidx.compose.ui.Modifier r2 = androidx.compose.foundation.layout.PaddingKt.m490paddingqDBjuR0$default(r16, r17, r18, r19, r20, r21, r22)
            java.lang.String r11 = "ProgressiveOfferTimerTestTag"
            androidx.compose.ui.Modifier r11 = androidx.compose.ui.platform.TestTagKt.testTag(r2, r11)
            com.designsystem.ds_theme.DSTypography r2 = r9.getTypography(r0, r5)
            androidx.compose.ui.text.TextStyle r29 = r2.getDsSubheading2()
            com.designsystem.ds_theme.DSColors r2 = r9.getColors(r0, r5)
            long r12 = r2.m8760getDsNeutral1000d7_KjU()
            java.lang.String r2 = "formattedTime"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r31 = 0
            r32 = 64
            r33 = 32760(0x7ff8, float:4.5907E-41)
            r30 = r0
            androidx.compose.material.TextKt.m1461TextfLXpl1I(r10, r11, r12, r14, r16, r17, r18, r19, r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32, r33)
            r0.endReplaceableGroup()
            goto L_0x03e0
        L_0x03d7:
            r2 = -211825589(0xfffffffff35fcc4b, float:-1.7731106E31)
            r0.startReplaceableGroup(r2)
            r0.endReplaceableGroup()
        L_0x03e0:
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            int r2 = r35 >> 18
            r2 = r2 & 14
            int r3 = androidx.compose.animation.core.Animatable.$stable
            int r5 = r3 << 3
            r2 = r2 | r5
            int r3 = r3 << 6
            r2 = r2 | r3
            r9 = r43
            CelebrationAnimation(r9, r8, r7, r0, r2)
            r5 = r34
        L_0x0402:
            androidx.compose.runtime.ScopeUpdateScope r11 = r0.endRestartGroup()
            if (r11 != 0) goto L_0x0409
            goto L_0x0422
        L_0x0409:
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferTier$2 r12 = new com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$OfferTier$2
            r0 = r12
            r1 = r36
            r2 = r37
            r4 = r39
            r6 = r41
            r7 = r42
            r8 = r43
            r9 = r45
            r10 = r46
            r0.<init>(r1, r2, r4, r5, r6, r7, r8, r9, r10)
            r11.updateScope(r12)
        L_0x0422:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt.OfferTier(boolean, long, java.lang.String, java.lang.Integer, float, float, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: OfferTier$lambda-35  reason: not valid java name */
    private static final int m8520OfferTier$lambda35(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: kotlin.jvm.functions.Function0} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v69, resolved type: com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$3$1} */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0354, code lost:
        if (r0 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L_0x0356;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0387  */
    /* JADX WARNING: Removed duplicated region for block: B:150:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00ee  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ProgressiveOfferSurface(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r27, @org.jetbrains.annotations.Nullable java.lang.String r28, float r29, @org.jetbrains.annotations.Nullable java.lang.String r30, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r31, @org.jetbrains.annotations.Nullable java.lang.Long r32, boolean r33, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r34, int r35, int r36) {
        /*
            r11 = r27
            r12 = r28
            r13 = r33
            r14 = r35
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -282714341(0xffffffffef261f1b, float:-5.1412116E28)
            r1 = r34
            androidx.compose.runtime.Composer r15 = r1.startRestartGroup(r0)
            r0 = r36 & 1
            r16 = 4
            if (r0 == 0) goto L_0x001f
            r0 = r14 | 6
            goto L_0x0030
        L_0x001f:
            r0 = r14 & 14
            if (r0 != 0) goto L_0x002f
            boolean r0 = r15.changed((java.lang.Object) r11)
            if (r0 == 0) goto L_0x002c
            r0 = r16
            goto L_0x002d
        L_0x002c:
            r0 = 2
        L_0x002d:
            r0 = r0 | r14
            goto L_0x0030
        L_0x002f:
            r0 = r14
        L_0x0030:
            r1 = r36 & 2
            if (r1 == 0) goto L_0x0037
            r0 = r0 | 48
            goto L_0x0047
        L_0x0037:
            r1 = r14 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0047
            boolean r1 = r15.changed((java.lang.Object) r12)
            if (r1 == 0) goto L_0x0044
            r1 = 32
            goto L_0x0046
        L_0x0044:
            r1 = 16
        L_0x0046:
            r0 = r0 | r1
        L_0x0047:
            r1 = r36 & 4
            if (r1 == 0) goto L_0x0050
            r0 = r0 | 384(0x180, float:5.38E-43)
            r9 = r29
            goto L_0x0062
        L_0x0050:
            r1 = r14 & 896(0x380, float:1.256E-42)
            r9 = r29
            if (r1 != 0) goto L_0x0062
            boolean r1 = r15.changed((float) r9)
            if (r1 == 0) goto L_0x005f
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r1 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r0 = r0 | r1
        L_0x0062:
            r1 = r36 & 8
            if (r1 == 0) goto L_0x0069
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007c
        L_0x0069:
            r2 = r14 & 7168(0x1c00, float:1.0045E-41)
            if (r2 != 0) goto L_0x007c
            r2 = r30
            boolean r3 = r15.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0078
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x007a
        L_0x0078:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x007a:
            r0 = r0 | r3
            goto L_0x007e
        L_0x007c:
            r2 = r30
        L_0x007e:
            r3 = r36 & 16
            if (r3 == 0) goto L_0x0085
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009a
        L_0x0085:
            r4 = 57344(0xe000, float:8.0356E-41)
            r4 = r4 & r14
            if (r4 != 0) goto L_0x009a
            r4 = r31
            boolean r5 = r15.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0096
            r5 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0098
        L_0x0096:
            r5 = 8192(0x2000, float:1.14794E-41)
        L_0x0098:
            r0 = r0 | r5
            goto L_0x009c
        L_0x009a:
            r4 = r31
        L_0x009c:
            r5 = r36 & 32
            if (r5 == 0) goto L_0x00a4
            r6 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r6
            goto L_0x00b8
        L_0x00a4:
            r6 = 458752(0x70000, float:6.42848E-40)
            r6 = r6 & r14
            if (r6 != 0) goto L_0x00b8
            r6 = r32
            boolean r7 = r15.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x00b4
            r7 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b4:
            r7 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r0 = r0 | r7
            goto L_0x00ba
        L_0x00b8:
            r6 = r32
        L_0x00ba:
            r7 = r36 & 64
            if (r7 == 0) goto L_0x00c2
            r7 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c0:
            r0 = r0 | r7
            goto L_0x00d3
        L_0x00c2:
            r7 = 3670016(0x380000, float:5.142788E-39)
            r7 = r7 & r14
            if (r7 != 0) goto L_0x00d3
            boolean r7 = r15.changed((boolean) r13)
            if (r7 == 0) goto L_0x00d0
            r7 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c0
        L_0x00d0:
            r7 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c0
        L_0x00d3:
            r17 = r0
            r0 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r17 & r0
            r7 = 599186(0x92492, float:8.39638E-40)
            r0 = r0 ^ r7
            if (r0 != 0) goto L_0x00ee
            boolean r0 = r15.getSkipping()
            if (r0 != 0) goto L_0x00e7
            goto L_0x00ee
        L_0x00e7:
            r15.skipToGroupEnd()
            r5 = r4
            r4 = r2
            goto L_0x0380
        L_0x00ee:
            if (r1 == 0) goto L_0x00f2
            r8 = 0
            goto L_0x00f3
        L_0x00f2:
            r8 = r2
        L_0x00f3:
            if (r3 == 0) goto L_0x00f8
            r18 = 0
            goto L_0x00fa
        L_0x00f8:
            r18 = r4
        L_0x00fa:
            if (r5 == 0) goto L_0x00fe
            r7 = 0
            goto L_0x00ff
        L_0x00fe:
            r7 = r6
        L_0x00ff:
            androidx.compose.runtime.ProvidableCompositionLocal r1 = com.designsystem.composition.LocalCurrentTimeKt.getLocalCalendar()
            java.lang.Object r1 = r15.consume(r1)
            java.util.Calendar r1 = (java.util.Calendar) r1
            long r1 = r1.getTimeInMillis()
            long r5 = calculateRemainingTime(r1, r7)
            r4 = 0
            java.lang.Object[] r1 = new java.lang.Object[r4]
            r2 = 0
            r3 = 0
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$offerExpired$2 r19 = com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$offerExpired$2.INSTANCE
            r20 = 8
            r21 = 6
            r0 = r4
            r4 = r19
            r30 = r5
            r5 = r15
            r6 = r20
            r19 = r7
            r7 = r21
            java.lang.Object r1 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            r7 = r1
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Long r4 = java.lang.Long.valueOf(r30)
            r6 = -3686930(0xffffffffffc7bdee, float:NaN)
            r15.startReplaceableGroup(r6)
            boolean r4 = r15.changed((java.lang.Object) r4)
            java.lang.Object r5 = r15.rememberedValue()
            if (r4 != 0) goto L_0x0151
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r4.getEmpty()
            if (r5 != r4) goto L_0x014e
            goto L_0x0151
        L_0x014e:
            r10 = r30
            goto L_0x015b
        L_0x0151:
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$time$2$1 r5 = new com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$time$2$1
            r10 = r30
            r5.<init>(r10)
            r15.updateRememberedValue(r5)
        L_0x015b:
            r15.endReplaceableGroup()
            r4 = r5
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            r21 = 8
            r22 = 6
            r5 = r15
            r0 = r6
            r6 = r21
            r23 = r7
            r7 = r22
            java.lang.Object r1 = androidx.compose.runtime.saveable.RememberSaveableKt.rememberSaveable((java.lang.Object[]) r1, r2, (java.lang.String) r3, r4, (androidx.compose.runtime.Composer) r5, (int) r6, (int) r7)
            r7 = r1
            androidx.compose.runtime.MutableState r7 = (androidx.compose.runtime.MutableState) r7
            r15.startReplaceableGroup(r0)
            boolean r1 = r15.changed((java.lang.Object) r7)
            java.lang.Object r2 = r15.rememberedValue()
            if (r1 != 0) goto L_0x0189
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r2 != r1) goto L_0x0191
        L_0x0189:
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$countDownTimer$1$1 r2 = new com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$countDownTimer$1$1
            r2.<init>(r7)
            r15.updateRememberedValue(r2)
        L_0x0191:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            r1 = -3686552(0xffffffffffc7bf68, float:NaN)
            r15.startReplaceableGroup(r1)
            boolean r1 = r15.changed((java.lang.Object) r7)
            r6 = r23
            boolean r3 = r15.changed((java.lang.Object) r6)
            r1 = r1 | r3
            java.lang.Object r3 = r15.rememberedValue()
            if (r1 != 0) goto L_0x01b5
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r3 != r1) goto L_0x01bd
        L_0x01b5:
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$countDownTimer$2$1 r3 = new com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$countDownTimer$2$1
            r3.<init>(r7, r6)
            r15.updateRememberedValue(r3)
        L_0x01bd:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            android.os.CountDownTimer r1 = getCountDownTimer(r10, r2, r3)
            r2 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r15.startReplaceableGroup(r2)
            java.lang.Object r3 = r15.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r4.getEmpty()
            if (r3 != r5) goto L_0x01e1
            r5 = 2
            r10 = 0
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r10, r10, r5, r10)
            r15.updateRememberedValue(r3)
        L_0x01e1:
            r15.endReplaceableGroup()
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            android.os.CountDownTimer r5 = m8535ProgressiveOfferSurface$lambda8(r3)
            if (r5 != 0) goto L_0x01fd
            if (r13 == 0) goto L_0x01fd
            if (r19 == 0) goto L_0x01fd
            m8536ProgressiveOfferSurface$lambda9(r3, r1)
            android.os.CountDownTimer r1 = m8535ProgressiveOfferSurface$lambda8(r3)
            if (r1 != 0) goto L_0x01fa
            goto L_0x01fd
        L_0x01fa:
            r1.start()
        L_0x01fd:
            androidx.compose.runtime.ProvidableCompositionLocal r1 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()
            java.lang.Object r1 = r15.consume(r1)
            androidx.lifecycle.LifecycleOwner r1 = (androidx.lifecycle.LifecycleOwner) r1
            androidx.lifecycle.Lifecycle r1 = r1.getLifecycle()
            r15.startReplaceableGroup(r0)
            boolean r0 = r15.changed((java.lang.Object) r3)
            java.lang.Object r5 = r15.rememberedValue()
            if (r0 != 0) goto L_0x021e
            java.lang.Object r0 = r4.getEmpty()
            if (r5 != r0) goto L_0x0226
        L_0x021e:
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$1$1 r5 = new com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$1$1
            r5.<init>(r3)
            r15.updateRememberedValue(r5)
        L_0x0226:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            f6.a r0 = new f6.a
            r0.<init>(r5)
            r1.addObserver(r0)
            r15.startReplaceableGroup(r2)
            java.lang.Object r0 = r15.rememberedValue()
            java.lang.Object r1 = r4.getEmpty()
            if (r0 != r1) goto L_0x024b
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            r1 = 2
            r3 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r3, r1, r3)
            r15.updateRememberedValue(r0)
        L_0x024b:
            r15.endReplaceableGroup()
            r11 = r0
            androidx.compose.runtime.MutableState r11 = (androidx.compose.runtime.MutableState) r11
            r15.startReplaceableGroup(r2)
            java.lang.Object r0 = r15.rememberedValue()
            java.lang.Object r1 = r4.getEmpty()
            if (r0 != r1) goto L_0x026e
            r0 = 1065353216(0x3f800000, float:1.0)
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
            r1 = 0
            r10 = 2
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r1, r10, r1)
            r15.updateRememberedValue(r0)
            goto L_0x0270
        L_0x026e:
            r1 = 0
            r10 = 2
        L_0x0270:
            r15.endReplaceableGroup()
            r20 = r0
            androidx.compose.runtime.MutableState r20 = (androidx.compose.runtime.MutableState) r20
            r15.startReplaceableGroup(r2)
            java.lang.Object r0 = r15.rememberedValue()
            java.lang.Object r3 = r4.getEmpty()
            if (r0 != r3) goto L_0x028b
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r12, r1, r10, r1)
            r15.updateRememberedValue(r0)
        L_0x028b:
            r15.endReplaceableGroup()
            r21 = r0
            androidx.compose.runtime.MutableState r21 = (androidx.compose.runtime.MutableState) r21
            r15.startReplaceableGroup(r2)
            java.lang.Object r0 = r15.rememberedValue()
            java.lang.Object r2 = r4.getEmpty()
            if (r0 != r2) goto L_0x02a6
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r8, r1, r10, r1)
            r15.updateRememberedValue(r0)
        L_0x02a6:
            r15.endReplaceableGroup()
            r22 = r0
            androidx.compose.runtime.MutableState r22 = (androidx.compose.runtime.MutableState) r22
            float r0 = m8526ProgressiveOfferSurface$lambda16(r20)
            r2 = 150(0x96, float:2.1E-43)
            androidx.compose.animation.core.Easing r3 = androidx.compose.animation.core.EasingKt.getLinearEasing()
            r5 = 0
            androidx.compose.animation.core.TweenSpec r2 = androidx.compose.animation.core.AnimationSpecKt.tween$default(r2, r5, r3, r10, r1)
            r3 = 0
            r4 = 0
            r23 = 0
            r24 = 12
            r1 = r0
            r0 = r5
            r5 = r15
            r25 = r6
            r6 = r23
            r23 = r7
            r7 = r24
            androidx.compose.runtime.State r24 = androidx.compose.animation.core.AnimateAsStateKt.animateFloatAsState(r1, r2, r3, r4, r5, r6, r7)
            boolean r1 = m8521ProgressiveOfferSurface$lambda0(r25)
            r7 = 6
            r6 = 1
            if (r1 != 0) goto L_0x0310
            r1 = -282712723(0xffffffffef26256d, float:-5.1419757E28)
            r15.startReplaceableGroup(r1)
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$2 r5 = new com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$2
            r25 = r0
            r0 = r5
            r1 = r27
            r2 = r33
            r3 = r19
            r4 = r18
            r13 = r5
            r5 = r29
            r14 = r6
            r6 = r17
            r7 = r23
            r26 = r8
            r8 = r22
            r9 = r24
            r23 = r10
            r10 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = -819890377(0xffffffffcf217737, float:-2.70894464E9)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r15, r0, r14, r13)
            r8 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r15, r8)
            r15.endReplaceableGroup()
            goto L_0x0321
        L_0x0310:
            r25 = r0
            r14 = r6
            r26 = r8
            r23 = r10
            r8 = r7
            r0 = -282711699(0xffffffffef26296d, float:-5.142459E28)
            r15.startReplaceableGroup(r0)
            r15.endReplaceableGroup()
        L_0x0321:
            java.lang.Object[] r0 = new java.lang.Object[r8]
            r0[r25] = r11
            r0[r14] = r20
            r0[r23] = r21
            r1 = 3
            r0[r1] = r12
            r0[r16] = r22
            r1 = 5
            r9 = r26
            r0[r1] = r9
            r1 = -3685570(0xffffffffffc7c33e, float:NaN)
            r15.startReplaceableGroup(r1)
            r4 = r25
        L_0x033b:
            if (r4 >= r8) goto L_0x0348
            r1 = r0[r4]
            int r4 = r4 + 1
            boolean r1 = r15.changed((java.lang.Object) r1)
            r25 = r25 | r1
            goto L_0x033b
        L_0x0348:
            java.lang.Object r0 = r15.rememberedValue()
            if (r25 != 0) goto L_0x0356
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x036a
        L_0x0356:
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$3$1 r10 = new com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$3$1
            r7 = 0
            r0 = r10
            r1 = r28
            r2 = r9
            r3 = r11
            r4 = r20
            r5 = r21
            r6 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r15.updateRememberedValue(r10)
        L_0x036a:
            r15.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r0 = (kotlin.jvm.functions.Function2) r0
            int r1 = r17 >> 3
            r1 = r1 & 14
            int r2 = r17 >> 6
            r2 = r2 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            androidx.compose.runtime.EffectsKt.LaunchedEffect(r12, r9, r0, r15, r1)
            r4 = r9
            r5 = r18
            r6 = r19
        L_0x0380:
            androidx.compose.runtime.ScopeUpdateScope r10 = r15.endRestartGroup()
            if (r10 != 0) goto L_0x0387
            goto L_0x039c
        L_0x0387:
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$4 r11 = new com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt$ProgressiveOfferSurface$4
            r0 = r11
            r1 = r27
            r2 = r28
            r3 = r29
            r7 = r33
            r8 = r35
            r9 = r36
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r10.updateScope(r11)
        L_0x039c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt.ProgressiveOfferSurface(androidx.compose.ui.Modifier, java.lang.String, float, java.lang.String, java.lang.Integer, java.lang.Long, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: ProgressiveOfferSurface$lambda-0  reason: not valid java name */
    private static final boolean m8521ProgressiveOfferSurface$lambda0(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ProgressiveOfferSurface$lambda-1  reason: not valid java name */
    public static final void m8522ProgressiveOfferSurface$lambda1(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }

    /* access modifiers changed from: private */
    /* renamed from: ProgressiveOfferSurface$lambda-11  reason: not valid java name */
    public static final void m8523ProgressiveOfferSurface$lambda11(Function2 function2, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "p0");
        Intrinsics.checkNotNullParameter(event, "p1");
        function2.invoke(lifecycleOwner, event);
    }

    /* access modifiers changed from: private */
    /* renamed from: ProgressiveOfferSurface$lambda-13  reason: not valid java name */
    public static final boolean m8524ProgressiveOfferSurface$lambda13(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ProgressiveOfferSurface$lambda-14  reason: not valid java name */
    public static final void m8525ProgressiveOfferSurface$lambda14(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }

    /* renamed from: ProgressiveOfferSurface$lambda-16  reason: not valid java name */
    private static final float m8526ProgressiveOfferSurface$lambda16(MutableState<Float> mutableState) {
        return mutableState.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ProgressiveOfferSurface$lambda-17  reason: not valid java name */
    public static final void m8527ProgressiveOfferSurface$lambda17(MutableState<Float> mutableState, float f11) {
        mutableState.setValue(Float.valueOf(f11));
    }

    /* access modifiers changed from: private */
    /* renamed from: ProgressiveOfferSurface$lambda-19  reason: not valid java name */
    public static final String m8528ProgressiveOfferSurface$lambda19(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ProgressiveOfferSurface$lambda-20  reason: not valid java name */
    public static final void m8529ProgressiveOfferSurface$lambda20(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: ProgressiveOfferSurface$lambda-22  reason: not valid java name */
    public static final String m8530ProgressiveOfferSurface$lambda22(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ProgressiveOfferSurface$lambda-23  reason: not valid java name */
    public static final void m8531ProgressiveOfferSurface$lambda23(MutableState<String> mutableState, String str) {
        mutableState.setValue(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: ProgressiveOfferSurface$lambda-24  reason: not valid java name */
    public static final float m8532ProgressiveOfferSurface$lambda24(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ProgressiveOfferSurface$lambda-3  reason: not valid java name */
    public static final long m8533ProgressiveOfferSurface$lambda3(MutableState<Long> mutableState) {
        return mutableState.getValue().longValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: ProgressiveOfferSurface$lambda-4  reason: not valid java name */
    public static final void m8534ProgressiveOfferSurface$lambda4(MutableState<Long> mutableState, long j11) {
        mutableState.setValue(Long.valueOf(j11));
    }

    /* access modifiers changed from: private */
    /* renamed from: ProgressiveOfferSurface$lambda-8  reason: not valid java name */
    public static final CountDownTimer m8535ProgressiveOfferSurface$lambda8(MutableState<CountDownTimer> mutableState) {
        return mutableState.getValue();
    }

    /* renamed from: ProgressiveOfferSurface$lambda-9  reason: not valid java name */
    private static final void m8536ProgressiveOfferSurface$lambda9(MutableState<CountDownTimer> mutableState, CountDownTimer countDownTimer) {
        mutableState.setValue(countDownTimer);
    }

    private static final long calculateRemainingTime(long j11, Long l11) {
        long longValue = l11 == null ? 0 : l11.longValue();
        if (j11 >= longValue) {
            return 0;
        }
        return longValue - j11;
    }

    private static final CountDownTimer getCountDownTimer(long j11, Function0<Unit> function0, Function0<Unit> function02) {
        return new ProgressiveOfferComposablesKt$getCountDownTimer$1(function0, function02, j11, 1000);
    }
}
