package com.designsystem.ds_stepper;

import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperComposablesKt$StepperStaticIconsBackgroundLayer$1$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f32941g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32942h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f32943i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ BoxWithConstraintsScope f32944j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ StepperValues f32945k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ DSStepperStyle f32946l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ long f32947m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ MM2Properties f32948n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ boolean f32949o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32950p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f32951q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f32952r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperComposablesKt$StepperStaticIconsBackgroundLayer$1$1$1(long j11, int i11, boolean z11, BoxWithConstraintsScope boxWithConstraintsScope, StepperValues stepperValues, DSStepperStyle dSStepperStyle, long j12, MM2Properties mM2Properties, boolean z12, Function0<Unit> function0, Function0<Unit> function02, int i12) {
        super(2);
        this.f32941g = j11;
        this.f32942h = i11;
        this.f32943i = z11;
        this.f32944j = boxWithConstraintsScope;
        this.f32945k = stepperValues;
        this.f32946l = dSStepperStyle;
        this.f32947m = j12;
        this.f32948n = mM2Properties;
        this.f32949o = z12;
        this.f32950p = function0;
        this.f32951q = function02;
        this.f32952r = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            long j11 = this.f32941g;
            final boolean z11 = this.f32943i;
            final BoxWithConstraintsScope boxWithConstraintsScope = this.f32944j;
            final StepperValues stepperValues = this.f32945k;
            final DSStepperStyle dSStepperStyle = this.f32946l;
            final long j12 = this.f32947m;
            MM2Properties mM2Properties = this.f32948n;
            boolean z12 = this.f32949o;
            int i12 = this.f32942h;
            Function0<Unit> function0 = this.f32950p;
            Function0<Unit> function02 = this.f32951q;
            int i13 = this.f32952r;
            MM2Properties mM2Properties2 = mM2Properties;
            final long j13 = j11;
            AnonymousClass1 r02 = r4;
            final MM2Properties mM2Properties3 = mM2Properties2;
            long j14 = j11;
            final boolean z13 = z12;
            final int i14 = i12;
            final Function0<Unit> function03 = function0;
            final Function0<Unit> function04 = function02;
            final int i15 = i13;
            AnonymousClass1 r42 = new Function2<Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i11) {
                    Composer composer2 = composer;
                    if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
                        Modifier animateContentSize$default = AnimationModifierKt.animateContentSize$default(SizeKt.m544height3ABfNKs(Modifier.Companion, DSTheme.INSTANCE.getDimens(composer2, 0).m8845getDsXxlD9Ej5fM()), AnimationSpecKt.tween$default(150, 0, (Easing) null, 6, (Object) null), (Function2) null, 2, (Object) null);
                        boolean z11 = z11;
                        BoxWithConstraintsScope boxWithConstraintsScope = boxWithConstraintsScope;
                        StepperValues stepperValues = stepperValues;
                        DSStepperStyle dSStepperStyle = dSStepperStyle;
                        long j11 = j12;
                        long j12 = j13;
                        MM2Properties mM2Properties = mM2Properties3;
                        boolean z12 = z13;
                        int i12 = i14;
                        Function0<Unit> function0 = function03;
                        Function0<Unit> function02 = function04;
                        int i13 = i15;
                        composer2.startReplaceableGroup(-1990474327);
                        Function0<Unit> function03 = function0;
                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer2, 0);
                        composer2.startReplaceableGroup(1376089335);
                        Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
                        int i14 = i13;
                        LayoutDirection layoutDirection = (LayoutDirection) composer2.consume(CompositionLocalsKt.getLocalLayoutDirection());
                        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
                        boolean z13 = z12;
                        Function0<ComposeUiNode> constructor = companion.getConstructor();
                        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(animateContentSize$default);
                        MM2Properties mM2Properties2 = mM2Properties;
                        if (!(composer.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer.startReusableNode();
                        if (composer.getInserting()) {
                            composer2.createNode(constructor);
                        } else {
                            composer.useNode();
                        }
                        composer.disableReusing();
                        Composer r13 = Updater.m2536constructorimpl(composer);
                        Updater.m2543setimpl(r13, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                        Updater.m2543setimpl(r13, density, companion.getSetDensity());
                        Updater.m2543setimpl(r13, layoutDirection, companion.getSetLayoutDirection());
                        composer.enableReusing();
                        materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(composer)), composer2, 0);
                        composer2.startReplaceableGroup(2058660585);
                        composer2.startReplaceableGroup(-1253629305);
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        if (!z11) {
                            composer2.startReplaceableGroup(1906504951);
                            StepperComposablesKt.m8595ExpandedStepperBackgroundjB83MbM(boxWithConstraintsScope, stepperValues, dSStepperStyle, j11, j12, mM2Properties2, z13, composer, (3670016 & (i12 >> 6)) | (458752 & (i12 << 9)) | (i12 & 14) | ((i12 >> 15) & 112) | ((i12 >> 3) & 896) | ((i12 >> 12) & 7168) | (57344 & i12));
                            composer.endReplaceableGroup();
                        } else {
                            composer2.startReplaceableGroup(1906505442);
                            long j13 = j12;
                            MM2Properties mM2Properties3 = mM2Properties2;
                            StepperComposablesKt.m8593CollapsedStepperBackgroundY0xEhic(stepperValues, dSStepperStyle, j11, j13, mM2Properties3, function03, function02, composer, (3670016 & (i14 << 18)) | (458752 & (i12 >> 12)) | ((i12 >> 18) & 14) | ((i12 >> 6) & 112) | ((i12 >> 15) & 896) | ((i12 >> 3) & 7168) | ((i12 << 6) & 57344));
                            composer.endReplaceableGroup();
                        }
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        composer.endNode();
                        composer.endReplaceableGroup();
                        composer.endReplaceableGroup();
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            };
            Composer composer2 = composer;
            SurfaceKt.m1384SurfaceFjzlyU((Modifier) null, (Shape) null, j14, 0, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(composer2, -819902776, true, r02), composer2, ((this.f32942h >> 6) & 896) | 1572864, 59);
            return;
        }
        composer.skipToGroupEnd();
    }
}
