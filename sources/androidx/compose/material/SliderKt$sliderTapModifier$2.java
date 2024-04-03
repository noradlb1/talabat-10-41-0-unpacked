package androidx.compose.material;

import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$sliderTapModifier$2 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ boolean f5327g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ DraggableState f5328h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f5329i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ float f5330j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f5331k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableState<Float> f5332l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ State<Float> f5333m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ State<Function1<Float, Unit>> f5334n;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material.SliderKt$sliderTapModifier$2$1", f = "Slider.kt", i = {}, l = {882}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material.SliderKt$sliderTapModifier$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f5335h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(z11, f11, mutableState, state, coroutineScope, draggableState, state2, continuation);
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
            int i11 = this.f5335h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                final boolean z11 = z11;
                final float f11 = f11;
                final MutableState<Float> mutableState = mutableState;
                final State<Float> state = state;
                AnonymousClass1 r62 = new Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    private /* synthetic */ Object L$0;

                    /* renamed from: h  reason: collision with root package name */
                    public int f5343h;

                    /* renamed from: i  reason: collision with root package name */
                    public /* synthetic */ long f5344i;

                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return m1362invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m2686unboximpl(), (Continuation) obj3);
                    }

                    @Nullable
                    /* renamed from: invoke-d-4ec7I  reason: not valid java name */
                    public final Object m1362invoked4ec7I(@NotNull PressGestureScope pressGestureScope, long j11, @Nullable Continuation<? super Unit> continuation) {
                        AnonymousClass1 r02 = 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public SliderKt$sliderTapModifier$2(boolean z11, DraggableState draggableState, MutableInteractionSource mutableInteractionSource, float f11, boolean z12, MutableState<Float> mutableState, State<Float> state, State<? extends Function1<? super Float, Unit>> state2) {
                            super(3);
                            this.f5327g = z11;
                            this.f5328h = draggableState;
                            this.f5329i = mutableInteractionSource;
                            this.f5330j = f11;
                            this.f5331k = z12;
                            this.f5332l = mutableState;
                            this.f5333m = state;
                            this.f5334n = state2;
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                        }

                        @NotNull
                        @Composable
                        public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
                            Intrinsics.checkNotNullParameter(modifier, "$this$composed");
                            composer.startReplaceableGroup(1945228890);
                            if (this.f5327g) {
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
                                Object[] objArr = {this.f5328h, this.f5329i, Float.valueOf(this.f5330j), Boolean.valueOf(this.f5331k)};
                                final boolean z11 = this.f5331k;
                                final float f11 = this.f5330j;
                                final MutableState<Float> mutableState = this.f5332l;
                                final State<Float> state = this.f5333m;
                                final DraggableState draggableState = this.f5328h;
                                final State<Function1<Float, Unit>> state2 = this.f5334n;
                                modifier = SuspendingPointerInputFilterKt.pointerInput(modifier, objArr, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) new AnonymousClass1((Continuation<? super AnonymousClass1>) null));
                            }
                            composer.endReplaceableGroup();
                            return modifier;
                        }
                    }
