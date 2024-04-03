package androidx.compose.foundation;

import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class MagnifierKt$magnifier$4 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<Density, Offset> f1728g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<Density, Offset> f1729h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ float f1730i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function1<DpSize, Unit> f1731j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PlatformMagnifierFactory f1732k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MagnifierStyle f1733l;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.MagnifierKt$magnifier$4$1", f = "Magnifier.kt", i = {0}, l = {365}, m = "invokeSuspend", n = {"magnifier"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.MagnifierKt$magnifier$4$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f1734h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r12 = new AnonymousClass1(platformMagnifierFactory, magnifierStyle3, view, density, f13, mutableSharedFlow2, rememberUpdatedState4, state4, state5, state6, mutableState3, state7, continuation);
            r12.L$0 = obj;
            return r12;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: androidx.compose.foundation.PlatformMagnifier} */
        /* JADX WARNING: Multi-variable type inference failed */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r20) {
            /*
                r19 = this;
                r1 = r19
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r1.f1734h
                r3 = 1
                if (r2 == 0) goto L_0x0022
                if (r2 != r3) goto L_0x001a
                java.lang.Object r0 = r1.L$0
                r2 = r0
                androidx.compose.foundation.PlatformMagnifier r2 = (androidx.compose.foundation.PlatformMagnifier) r2
                kotlin.ResultKt.throwOnFailure(r20)     // Catch:{ all -> 0x0017 }
                goto L_0x0095
            L_0x0017:
                r0 = move-exception
                goto L_0x009d
            L_0x001a:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x0022:
                kotlin.ResultKt.throwOnFailure(r20)
                java.lang.Object r2 = r1.L$0
                kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
                androidx.compose.foundation.PlatformMagnifierFactory r4 = r5
                androidx.compose.foundation.MagnifierStyle r5 = r6
                android.view.View r6 = r7
                androidx.compose.ui.unit.Density r7 = r8
                float r8 = r9
                androidx.compose.foundation.PlatformMagnifier r4 = r4.create(r5, r6, r7, r8)
                kotlin.jvm.internal.Ref$LongRef r5 = new kotlin.jvm.internal.Ref$LongRef
                r5.<init>()
                long r6 = r4.m255getSizeYbymL2g()
                androidx.compose.ui.unit.Density r8 = r8
                androidx.compose.runtime.State<kotlin.jvm.functions.Function1<androidx.compose.ui.unit.DpSize, kotlin.Unit>> r9 = r11
                kotlin.jvm.functions.Function1 r9 = androidx.compose.foundation.MagnifierKt$magnifier$4.m243invoke$lambda6(r9)
                if (r9 == 0) goto L_0x0059
                long r10 = androidx.compose.ui.unit.IntSizeKt.m5648toSizeozmzZPI(r6)
                long r10 = r8.m5445toDpSizekrfVVM(r10)
                androidx.compose.ui.unit.DpSize r8 = androidx.compose.ui.unit.DpSize.m5564boximpl(r10)
                r9.invoke(r8)
            L_0x0059:
                r5.element = r6
                kotlinx.coroutines.flow.MutableSharedFlow<kotlin.Unit> r6 = r10
                androidx.compose.foundation.MagnifierKt$magnifier$4$1$1 r7 = new androidx.compose.foundation.MagnifierKt$magnifier$4$1$1
                r8 = 0
                r7.<init>(r4, r8)
                kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.onEach(r6, r7)
                kotlinx.coroutines.flow.FlowKt.launchIn(r6, r2)
                androidx.compose.foundation.MagnifierKt$magnifier$4$1$2 r2 = new androidx.compose.foundation.MagnifierKt$magnifier$4$1$2     // Catch:{ all -> 0x009b }
                androidx.compose.ui.unit.Density r11 = r8     // Catch:{ all -> 0x009b }
                androidx.compose.runtime.State<java.lang.Boolean> r12 = r12     // Catch:{ all -> 0x009b }
                androidx.compose.runtime.State<androidx.compose.ui.geometry.Offset> r13 = r13     // Catch:{ all -> 0x009b }
                androidx.compose.runtime.State<kotlin.jvm.functions.Function1<androidx.compose.ui.unit.Density, androidx.compose.ui.geometry.Offset>> r14 = r14     // Catch:{ all -> 0x009b }
                androidx.compose.runtime.MutableState<androidx.compose.ui.geometry.Offset> r15 = r15     // Catch:{ all -> 0x009b }
                androidx.compose.runtime.State<java.lang.Float> r6 = r16     // Catch:{ all -> 0x009b }
                androidx.compose.runtime.State<kotlin.jvm.functions.Function1<androidx.compose.ui.unit.DpSize, kotlin.Unit>> r7 = r11     // Catch:{ all -> 0x009b }
                r9 = r2
                r10 = r4
                r16 = r6
                r17 = r5
                r18 = r7
                r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x009b }
                kotlinx.coroutines.flow.Flow r2 = androidx.compose.runtime.SnapshotStateKt.snapshotFlow(r2)     // Catch:{ all -> 0x009b }
                r1.L$0 = r4     // Catch:{ all -> 0x009b }
                r1.f1734h = r3     // Catch:{ all -> 0x009b }
                java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.collect(r2, r1)     // Catch:{ all -> 0x009b }
                if (r2 != r0) goto L_0x0094
                return r0
            L_0x0094:
                r2 = r4
            L_0x0095:
                r2.dismiss()
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x009b:
                r0 = move-exception
                r2 = r4
            L_0x009d:
                r2.dismiss()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MagnifierKt$magnifier$4.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MagnifierKt$magnifier$4(Function1<? super Density, Offset> function1, Function1<? super Density, Offset> function12, float f11, Function1<? super DpSize, Unit> function13, PlatformMagnifierFactory platformMagnifierFactory, MagnifierStyle magnifierStyle) {
        super(3);
        this.f1728g = function1;
        this.f1729h = function12;
        this.f1730i = f11;
        this.f1731j = function13;
        this.f1732k = platformMagnifierFactory;
        this.f1733l = magnifierStyle;
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final long m237invoke$lambda1(MutableState<Offset> mutableState) {
        return mutableState.getValue().m2686unboximpl();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-10  reason: not valid java name */
    public static final boolean m238invoke$lambda10(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m239invoke$lambda2(MutableState<Offset> mutableState, long j11) {
        mutableState.setValue(Offset.m2665boximpl(j11));
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3  reason: not valid java name */
    public static final Function1<Density, Offset> m240invoke$lambda3(State<? extends Function1<? super Density, Offset>> state) {
        return (Function1) state.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-4  reason: not valid java name */
    public static final Function1<Density, Offset> m241invoke$lambda4(State<? extends Function1<? super Density, Offset>> state) {
        return (Function1) state.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-5  reason: not valid java name */
    public static final float m242invoke$lambda5(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-6  reason: not valid java name */
    public static final Function1<DpSize, Unit> m243invoke$lambda6(State<? extends Function1<? super DpSize, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-8  reason: not valid java name */
    public static final long m244invoke$lambda8(State<Offset> state) {
        return state.getValue().m2686unboximpl();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer2.startReplaceableGroup(-454877003);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-454877003, i11, -1, "androidx.compose.foundation.magnifier.<anonymous> (Magnifier.kt:272)");
        }
        final View view = (View) composer2.consume(AndroidCompositionLocals_androidKt.getLocalView());
        final Density density = (Density) composer2.consume(CompositionLocalsKt.getLocalDensity());
        composer2.startReplaceableGroup(-492369756);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (rememberedValue == companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m2665boximpl(Offset.Companion.m2691getUnspecifiedF1C5BW0()), (SnapshotMutationPolicy) null, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        State<T> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(this.f1728g, composer2, 0);
        State<T> rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(this.f1729h, composer2, 0);
        State rememberUpdatedState3 = SnapshotStateKt.rememberUpdatedState(Float.valueOf(this.f1730i), composer2, 0);
        final State<T> rememberUpdatedState4 = SnapshotStateKt.rememberUpdatedState(this.f1731j, composer2, 0);
        composer2.startReplaceableGroup(-492369756);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion.getEmpty()) {
            rememberedValue2 = SnapshotStateKt.derivedStateOf(new MagnifierKt$magnifier$4$sourceCenterInRoot$2$1(density, rememberUpdatedState, mutableState));
            composer2.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceableGroup();
        State state = (State) rememberedValue2;
        composer2.startReplaceableGroup(-492369756);
        Object rememberedValue3 = composer.rememberedValue();
        if (rememberedValue3 == companion.getEmpty()) {
            rememberedValue3 = SnapshotStateKt.derivedStateOf(new MagnifierKt$magnifier$4$isMagnifierShown$2$1(state));
            composer2.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceableGroup();
        State state2 = (State) rememberedValue3;
        composer2.startReplaceableGroup(-492369756);
        Object rememberedValue4 = composer.rememberedValue();
        if (rememberedValue4 == companion.getEmpty()) {
            rememberedValue4 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, (Object) null);
            composer2.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceableGroup();
        final MutableSharedFlow mutableSharedFlow = (MutableSharedFlow) rememberedValue4;
        float f11 = this.f1732k.getCanUpdateZoom() ? 0.0f : this.f1730i;
        MagnifierStyle magnifierStyle = this.f1733l;
        Object[] objArr = {view, density, Float.valueOf(f11), magnifierStyle, Boolean.valueOf(Intrinsics.areEqual((Object) magnifierStyle, (Object) MagnifierStyle.Companion.getTextDefault()))};
        final PlatformMagnifierFactory platformMagnifierFactory = this.f1732k;
        MagnifierStyle magnifierStyle2 = this.f1733l;
        float f12 = this.f1730i;
        AnonymousClass1 r02 = r42;
        final MagnifierStyle magnifierStyle3 = magnifierStyle2;
        Object[] objArr2 = objArr;
        final float f13 = f12;
        final MutableSharedFlow mutableSharedFlow2 = mutableSharedFlow;
        State state3 = state;
        final State state4 = state2;
        final State state5 = state3;
        MutableState mutableState2 = mutableState;
        final State<T> state6 = rememberUpdatedState2;
        final MutableState mutableState3 = mutableState2;
        final State state7 = rememberUpdatedState3;
        AnonymousClass1 r42 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
        EffectsKt.LaunchedEffect(objArr2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) r02, composer2, 72);
        composer2.startReplaceableGroup(1157296644);
        MutableState mutableState4 = mutableState2;
        boolean changed = composer2.changed((Object) mutableState4);
        Object rememberedValue5 = composer.rememberedValue();
        if (changed || rememberedValue5 == companion.getEmpty()) {
            rememberedValue5 = new MagnifierKt$magnifier$4$2$1(mutableState4);
            composer2.updateRememberedValue(rememberedValue5);
        }
        composer.endReplaceableGroup();
        Modifier drawBehind = DrawModifierKt.drawBehind(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, (Function1) rememberedValue5), new Function1<DrawScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull DrawScope drawScope) {
                Intrinsics.checkNotNullParameter(drawScope, "$this$drawBehind");
                mutableSharedFlow.tryEmit(Unit.INSTANCE);
            }
        });
        composer2.startReplaceableGroup(1157296644);
        State state8 = state3;
        boolean changed2 = composer2.changed((Object) state8);
        Object rememberedValue6 = composer.rememberedValue();
        if (changed2 || rememberedValue6 == companion.getEmpty()) {
            rememberedValue6 = new MagnifierKt$magnifier$4$4$1(state8);
            composer2.updateRememberedValue(rememberedValue6);
        }
        composer.endReplaceableGroup();
        Modifier semantics$default = SemanticsModifierKt.semantics$default(drawBehind, false, (Function1) rememberedValue6, 1, (Object) null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return semantics$default;
    }
}
