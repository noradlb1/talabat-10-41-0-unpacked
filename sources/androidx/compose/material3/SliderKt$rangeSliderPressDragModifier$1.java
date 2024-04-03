package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1", f = "Slider.kt", i = {}, l = {1202}, m = "invokeSuspend", n = {}, s = {})
public final class SliderKt$rangeSliderPressDragModifier$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f8129h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8130i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f8131j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ State<Float> f8132k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ State<Float> f8133l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ State<Function2<Boolean, Float, Unit>> f8134m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ boolean f8135n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ float f8136o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ State<Function1<Boolean, Unit>> f8137p;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1", f = "Slider.kt", i = {}, l = {1203}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.SliderKt$rangeSliderPressDragModifier$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f8138h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(pointerInputScope, z11, f11, rangeSliderLogic2, state, state2, state3, state4, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f8138h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                PointerInputScope pointerInputScope = pointerInputScope;
                final boolean z11 = z11;
                final float f11 = f11;
                final RangeSliderLogic rangeSliderLogic = rangeSliderLogic2;
                final State<Float> state = state;
                final State<Function1<Boolean, Unit>> state2 = state2;
                final State<Float> state3 = state3;
                final State<Function2<Boolean, Float, Unit>> state4 = state4;
                AnonymousClass1 r32 = new Function2<PointerInputScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    private /* synthetic */ Object L$0;

                    /* renamed from: h  reason: collision with root package name */
                    public int f8147h;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        AnonymousClass1 r02 = 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public SliderKt$rangeSliderPressDragModifier$1(MutableInteractionSource mutableInteractionSource, MutableInteractionSource mutableInteractionSource2, State<Float> state, State<Float> state2, State<? extends Function2<? super Boolean, ? super Float, Unit>> state3, boolean z11, float f11, State<? extends Function1<? super Boolean, Unit>> state4, Continuation<? super SliderKt$rangeSliderPressDragModifier$1> continuation) {
                            super(2, continuation);
                            this.f8130i = mutableInteractionSource;
                            this.f8131j = mutableInteractionSource2;
                            this.f8132k = state;
                            this.f8133l = state2;
                            this.f8134m = state3;
                            this.f8135n = z11;
                            this.f8136o = f11;
                            this.f8137p = state4;
                        }

                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            SliderKt$rangeSliderPressDragModifier$1 sliderKt$rangeSliderPressDragModifier$1 = new SliderKt$rangeSliderPressDragModifier$1(this.f8130i, this.f8131j, this.f8132k, this.f8133l, this.f8134m, this.f8135n, this.f8136o, this.f8137p, continuation);
                            sliderKt$rangeSliderPressDragModifier$1.L$0 = obj;
                            return sliderKt$rangeSliderPressDragModifier$1;
                        }

                        @Nullable
                        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((SliderKt$rangeSliderPressDragModifier$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i11 = this.f8129h;
                            if (i11 == 0) {
                                ResultKt.throwOnFailure(obj);
                                final PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                                RangeSliderLogic rangeSliderLogic = new RangeSliderLogic(this.f8130i, this.f8131j, this.f8132k, this.f8133l, this.f8134m);
                                final boolean z11 = this.f8135n;
                                final float f11 = this.f8136o;
                                final State<Float> state = this.f8132k;
                                final State<Function1<Boolean, Unit>> state2 = this.f8137p;
                                final State<Float> state3 = this.f8133l;
                                final State<Function2<Boolean, Float, Unit>> state4 = this.f8134m;
                                final RangeSliderLogic rangeSliderLogic2 = rangeSliderLogic;
                                AnonymousClass1 r32 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
                                this.f8129h = 1;
                                if (CoroutineScopeKt.coroutineScope(r32, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i11 == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
