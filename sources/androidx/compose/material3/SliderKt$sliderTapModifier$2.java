package androidx.compose.material3;

import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SliderKt$sliderTapModifier$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f8187g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DraggableState f8188h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8189i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f8190j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f8191k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f8192l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ State<Float> f8193m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ State<Function0<Unit>> f8194n;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SliderKt$sliderTapModifier$2$1", f = "Slider.kt", i = {}, l = {1129}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.SliderKt$sliderTapModifier$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f8195h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(z11, i12, mutableState, state, coroutineScope, draggableState, state2, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f8195h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                final boolean z11 = z11;
                final int i12 = i12;
                final MutableState<Float> mutableState = mutableState;
                final State<Float> state = state;
                AnonymousClass1 r62 = new Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    private /* synthetic */ Object L$0;

                    /* renamed from: h  reason: collision with root package name */
                    public int f8203h;

                    /* renamed from: i  reason: collision with root package name */
                    public /* synthetic */ long f8204i;

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return m1823invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m2686unboximpl(), (Continuation) obj3);
                    }

                    @Nullable
                    /* renamed from: invoke-d-4ec7I  reason: not valid java name */
                    public final Object m1823invoked4ec7I(@NotNull PressGestureScope pressGestureScope, long j11, @Nullable Continuation<? super Unit> continuation) {
                        AnonymousClass1 r02 = 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public SliderKt$sliderTapModifier$2(boolean z11, DraggableState draggableState, MutableInteractionSource mutableInteractionSource, int i11, boolean z12, MutableState<Float> mutableState, State<Float> state, State<? extends Function0<Unit>> state2) {
                            super(3);
                            this.f8187g = z11;
                            this.f8188h = draggableState;
                            this.f8189i = mutableInteractionSource;
                            this.f8190j = i11;
                            this.f8191k = z12;
                            this.f8192l = mutableState;
                            this.f8193m = state;
                            this.f8194n = state2;
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                        }

                        @NotNull
                        @Composable
                        public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
                            Intrinsics.checkNotNullParameter(modifier, "$this$composed");
                            composer.startReplaceableGroup(2040469710);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2040469710, i11, -1, "androidx.compose.material3.sliderTapModifier.<anonymous> (Slider.kt:1124)");
                            }
                            if (this.f8187g) {
                                composer.startReplaceableGroup(773894976);
                                composer.startReplaceableGroup(-492369756);
                                Object rememberedValue = composer.rememberedValue();
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                                    composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                                    rememberedValue = compositionScopedCoroutineScopeCanceller;
                                }
                                composer.endReplaceableGroup();
                                final CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
                                composer.endReplaceableGroup();
                                Object[] objArr = {this.f8188h, this.f8189i, Integer.valueOf(this.f8190j), Boolean.valueOf(this.f8191k)};
                                final boolean z11 = this.f8191k;
                                final int i12 = this.f8190j;
                                final MutableState<Float> mutableState = this.f8192l;
                                final State<Float> state = this.f8193m;
                                final DraggableState draggableState = this.f8188h;
                                final State<Function0<Unit>> state2 = this.f8194n;
                                modifier = SuspendingPointerInputFilterKt.pointerInput(modifier, objArr, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null));
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            composer.endReplaceableGroup();
                            return modifier;
                        }
                    }
