package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.Transition$animateTo$1$1", f = "Transition.kt", i = {0}, l = {434}, m = "invokeSuspend", n = {"$this$LaunchedEffect"}, s = {"L$0"})
public final class Transition$animateTo$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f1404h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Transition<S> f1405i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Transition$animateTo$1$1(Transition<S> transition, Continuation<? super Transition$animateTo$1$1> continuation) {
        super(2, continuation);
        this.f1405i = transition;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Transition$animateTo$1$1 transition$animateTo$1$1 = new Transition$animateTo$1$1(this.f1405i, continuation);
        transition$animateTo$1$1.L$0 = obj;
        return transition$animateTo$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((Transition$animateTo$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        CoroutineScope coroutineScope;
        AnonymousClass1 r42;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1404h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
        } else if (i11 == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        do {
            final float durationScale = SuspendAnimationKt.getDurationScale(coroutineScope.getCoroutineContext());
            final Transition<S> transition = this.f1405i;
            r42 = new Function1<Long, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke(((Number) obj).longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j11) {
                    if (!transition.isSeeking()) {
                        transition.onFrame$animation_core_release(j11 / 1, durationScale);
                    }
                }
            };
            this.L$0 = coroutineScope;
            this.f1404h = 1;
        } while (MonotonicFrameClockKt.withFrameNanos(r42, this) != coroutine_suspended);
        return coroutine_suspended;
    }
}
