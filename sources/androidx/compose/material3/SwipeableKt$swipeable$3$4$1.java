package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.SwipeableKt$swipeable$3$4$1", f = "Swipeable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SwipeableKt$swipeable$3$4$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f8425h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ float f8426i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SwipeableState<T> f8427j;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.material3.SwipeableKt$swipeable$3$4$1$1", f = "Swipeable.kt", i = {}, l = {612}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.material3.SwipeableKt$swipeable$3$4$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f8428h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(swipeableState, f11, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f8428h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                SwipeableState<T> swipeableState = swipeableState;
                float f11 = f11;
                this.f8428h = 1;
                if (swipeableState.performFling$material3_release(f11, this) == coroutine_suspended) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeableKt$swipeable$3$4$1(SwipeableState<T> swipeableState, Continuation<? super SwipeableKt$swipeable$3$4$1> continuation) {
        super(3, continuation);
        this.f8427j = swipeableState;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((CoroutineScope) obj, ((Number) obj2).floatValue(), (Continuation<? super Unit>) (Continuation) obj3);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, float f11, @Nullable Continuation<? super Unit> continuation) {
        SwipeableKt$swipeable$3$4$1 swipeableKt$swipeable$3$4$1 = new SwipeableKt$swipeable$3$4$1(this.f8427j, continuation);
        swipeableKt$swipeable$3$4$1.L$0 = coroutineScope;
        swipeableKt$swipeable$3$4$1.f8426i = f11;
        return swipeableKt$swipeable$3$4$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f8425h == 0) {
            ResultKt.throwOnFailure(obj);
            final float f11 = this.f8426i;
            final SwipeableState<T> swipeableState = this.f8427j;
            Job unused2 = BuildersKt__Builders_commonKt.launch$default((CoroutineScope) this.L$0, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
