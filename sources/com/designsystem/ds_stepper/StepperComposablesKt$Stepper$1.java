package com.designsystem.ds_stepper;

import android.view.View;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import com.designsystem.extensions.ViewExtensionsKt;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
public final class StepperComposablesKt$Stepper$1 extends Lambda implements Function2<Composer, Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Modifier f32852g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f32853h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Alignment.Horizontal f32854i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MM2Properties f32855j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ DSStepperStyle f32856k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ StepperValues f32857l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f32858m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ int f32859n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ State<Color> f32860o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f32861p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ State<Color> f32862q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ boolean f32863r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ CoroutineScope f32864s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ MutableState<Job> f32865t;

    /* renamed from: u  reason: collision with root package name */
    public final /* synthetic */ Function1<Integer, Unit> f32866u;

    /* renamed from: v  reason: collision with root package name */
    public final /* synthetic */ View f32867v;

    /* renamed from: w  reason: collision with root package name */
    public final /* synthetic */ MutableState<Integer> f32868w;

    /* renamed from: x  reason: collision with root package name */
    public final /* synthetic */ int f32869x;

    /* renamed from: y  reason: collision with root package name */
    public final /* synthetic */ int f32870y;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StepperComposablesKt$Stepper$1(Modifier modifier, int i11, Alignment.Horizontal horizontal, MM2Properties mM2Properties, DSStepperStyle dSStepperStyle, StepperValues stepperValues, boolean z11, int i12, State<Color> state, MutableState<Boolean> mutableState, State<Color> state2, boolean z12, CoroutineScope coroutineScope, MutableState<Job> mutableState2, Function1<? super Integer, Unit> function1, View view, MutableState<Integer> mutableState3, int i13, int i14) {
        super(2);
        this.f32852g = modifier;
        this.f32853h = i11;
        this.f32854i = horizontal;
        this.f32855j = mM2Properties;
        this.f32856k = dSStepperStyle;
        this.f32857l = stepperValues;
        this.f32858m = z11;
        this.f32859n = i12;
        this.f32860o = state;
        this.f32861p = mutableState;
        this.f32862q = state2;
        this.f32863r = z12;
        this.f32864s = coroutineScope;
        this.f32865t = mutableState2;
        this.f32866u = function1;
        this.f32867v = view;
        this.f32868w = mutableState3;
        this.f32869x = i13;
        this.f32870y = i14;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        if (((i11 & 11) ^ 2) != 0 || !composer.getSkipping()) {
            Modifier modifier = this.f32852g;
            final Alignment.Horizontal horizontal = this.f32854i;
            final MM2Properties mM2Properties = this.f32855j;
            final DSStepperStyle dSStepperStyle = this.f32856k;
            final StepperValues stepperValues = this.f32857l;
            final boolean z11 = this.f32858m;
            final int i12 = this.f32853h;
            final int i13 = this.f32859n;
            final State<Color> state = this.f32860o;
            final MutableState<Boolean> mutableState = this.f32861p;
            final State<Color> state2 = this.f32862q;
            final boolean z12 = this.f32863r;
            final CoroutineScope coroutineScope = this.f32864s;
            final MutableState<Job> mutableState2 = this.f32865t;
            final Function1<Integer, Unit> function1 = this.f32866u;
            final View view = this.f32867v;
            final MutableState<Integer> mutableState3 = this.f32868w;
            final int i14 = this.f32869x;
            final int i15 = this.f32870y;
            AnonymousClass1 r52 = new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((BoxWithConstraintsScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@NotNull BoxWithConstraintsScope boxWithConstraintsScope, @Nullable Composer composer, int i11) {
                    int i12;
                    BoxWithConstraintsScope boxWithConstraintsScope2 = boxWithConstraintsScope;
                    Composer composer2 = composer;
                    Intrinsics.checkNotNullParameter(boxWithConstraintsScope2, "$this$BoxWithConstraints");
                    if ((i11 & 14) == 0) {
                        i12 = i11 | (composer2.changed((Object) boxWithConstraintsScope2) ? 4 : 2);
                    } else {
                        i12 = i11;
                    }
                    if (((i12 & 91) ^ 18) != 0 || !composer.getSkipping()) {
                        StepperComposablesKt.m8594DummyStepperWidthi1RSzL4(boxWithConstraintsScope.m436getMaxWidthD9Ej5fM(), boxWithConstraintsScope.m438getMinWidthD9Ej5fM(), composer2, 0);
                        Alignment.Horizontal horizontal = horizontal;
                        MM2Properties mM2Properties = mM2Properties;
                        DSStepperStyle dSStepperStyle = dSStepperStyle;
                        long r52 = StepperComposablesKt.m8603Stepper$lambda9(state);
                        boolean z11 = StepperComposablesKt.m8599Stepper$lambda4(mutableState) && !mM2Properties.isLoading();
                        StepperValues stepperValues = stepperValues;
                        long r92 = StepperComposablesKt.m8597Stepper$lambda10(state2);
                        boolean z12 = z11;
                        final boolean z13 = z12;
                        final CoroutineScope coroutineScope = coroutineScope;
                        final MutableState<Job> mutableState = mutableState2;
                        boolean z14 = z12;
                        final MutableState<Boolean> mutableState2 = mutableState;
                        AnonymousClass1 r12 = new Function0<Unit>() {
                            public final void invoke() {
                                StepperComposablesKt.Stepper$collapseComponentWithDelay(z13, coroutineScope, mutableState, mutableState2);
                                StepperComposablesKt.m8600Stepper$lambda5(mutableState2, false);
                            }
                        };
                        Function1<Integer, Unit> function1 = function1;
                        View view = view;
                        StepperValues stepperValues2 = stepperValues;
                        final Function1<Integer, Unit> function12 = function1;
                        final View view2 = view;
                        final MutableState<Integer> mutableState3 = mutableState3;
                        final boolean z15 = z12;
                        final CoroutineScope coroutineScope2 = coroutineScope;
                        final MutableState<Job> mutableState4 = mutableState2;
                        final MutableState<Boolean> mutableState5 = mutableState;
                        AnonymousClass2 r18 = new Function0<Unit>() {
                            public final void invoke() {
                                MutableState<Integer> mutableState = mutableState3;
                                StepperComposablesKt.m8598Stepper$lambda2(mutableState, StepperComposablesKt.m8596Stepper$lambda1(mutableState) + 1);
                                Function1<Integer, Unit> function1 = function12;
                                if (function1 != null) {
                                    function1.invoke(Integer.valueOf(StepperComposablesKt.m8596Stepper$lambda1(mutableState3)));
                                }
                                StepperComposablesKt.Stepper$collapseComponentWithDelay(z15, coroutineScope2, mutableState4, mutableState5);
                                StepperComposablesKt.m8600Stepper$lambda5(mutableState5, false);
                                ViewExtensionsKt.performSelectionFeedback(view2);
                            }
                        };
                        int i13 = i12;
                        StepperComposablesKt.m8605StepperStaticIconsBackgroundLayerDTdxfFs(boxWithConstraintsScope, horizontal, mM2Properties, dSStepperStyle, r52, z11, stepperValues2, r92, z14, r12, r18, composer, (i12 & 14) | ((i13 >> 15) & 112) | ((i13 << 9) & 7168) | ((i13 << 9) & 234881024), 0);
                        Modifier matchParentSize = boxWithConstraintsScope.matchParentSize(Modifier.Companion);
                        boolean z16 = StepperComposablesKt.m8599Stepper$lambda4(mutableState) && !mM2Properties.isLoading();
                        StepperValues stepperValues3 = stepperValues;
                        MM2Properties mM2Properties2 = mM2Properties;
                        final boolean z17 = z11;
                        final int i14 = i14;
                        final Function1<Integer, Unit> function13 = function1;
                        final boolean z18 = z12;
                        final CoroutineScope coroutineScope3 = coroutineScope;
                        final MutableState<Job> mutableState6 = mutableState2;
                        final MutableState<Boolean> mutableState7 = mutableState;
                        final MutableState<Integer> mutableState8 = mutableState3;
                        AnonymousClass3 r53 = new Function0<Unit>() {
                            public final void invoke() {
                                StepperComposablesKt.Stepper$collapseComponentWithDelay(z18, coroutineScope3, mutableState6, mutableState7);
                                if (z17) {
                                    StepperComposablesKt.m8598Stepper$lambda2(mutableState8, i14);
                                    Function1<Integer, Unit> function1 = function13;
                                    if (function1 != null) {
                                        function1.invoke(Integer.valueOf(StepperComposablesKt.m8596Stepper$lambda1(mutableState8)));
                                    }
                                } else if (StepperComposablesKt.m8596Stepper$lambda1(mutableState8) > i14) {
                                    MutableState<Integer> mutableState = mutableState8;
                                    StepperComposablesKt.m8598Stepper$lambda2(mutableState, StepperComposablesKt.m8596Stepper$lambda1(mutableState) - 1);
                                    Function1<Integer, Unit> function12 = function13;
                                    if (function12 != null) {
                                        function12.invoke(Integer.valueOf(StepperComposablesKt.m8596Stepper$lambda1(mutableState8)));
                                    }
                                }
                            }
                        };
                        int i15 = i15;
                        Function1<Integer, Unit> function14 = function1;
                        final int i16 = i15;
                        final Function1<Integer, Unit> function15 = function14;
                        final boolean z19 = z12;
                        final CoroutineScope coroutineScope4 = coroutineScope;
                        final MutableState<Job> mutableState9 = mutableState2;
                        final MutableState<Boolean> mutableState10 = mutableState;
                        final MutableState<Integer> mutableState11 = mutableState3;
                        StepperComposablesKt.StepperTappableForegroundLayer(matchParentSize, z16, stepperValues3, mM2Properties2, r53, new Function0<Unit>() {
                            public final void invoke() {
                                StepperComposablesKt.Stepper$collapseComponentWithDelay(z19, coroutineScope4, mutableState9, mutableState10);
                                if (StepperComposablesKt.m8596Stepper$lambda1(mutableState11) < i16) {
                                    MutableState<Integer> mutableState = mutableState11;
                                    StepperComposablesKt.m8598Stepper$lambda2(mutableState, StepperComposablesKt.m8596Stepper$lambda1(mutableState) + 1);
                                    Function1<Integer, Unit> function1 = function15;
                                    if (function1 != null) {
                                        function1.invoke(Integer.valueOf(StepperComposablesKt.m8596Stepper$lambda1(mutableState11)));
                                    }
                                }
                            }
                        }, composer, 0);
                        return;
                    }
                    composer.skipToGroupEnd();
                }
            };
            Composer composer2 = composer;
            BoxWithConstraintsKt.BoxWithConstraints(modifier, (Alignment) null, false, ComposableLambdaKt.composableLambda(composer2, -819890903, true, r52), composer2, (this.f32853h & 14) | KfsConstant.KFS_RSA_KEY_LEN_3072, 6);
            return;
        }
        composer.skipToGroupEnd();
    }
}
