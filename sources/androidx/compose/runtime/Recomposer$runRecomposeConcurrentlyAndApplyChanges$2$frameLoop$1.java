package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1", f = "Recomposer.kt", i = {}, l = {728}, m = "invokeSuspend", n = {}, s = {})
public final class Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f9209h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Recomposer f9210i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MonotonicFrameClock f9211j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ProduceFrameSignal f9212k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1(Recomposer recomposer, MonotonicFrameClock monotonicFrameClock, ProduceFrameSignal produceFrameSignal, Continuation<? super Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1> continuation) {
        super(2, continuation);
        this.f9210i = recomposer;
        this.f9211j = monotonicFrameClock;
        this.f9212k = produceFrameSignal;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1(this.f9210i, this.f9211j, this.f9212k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((Recomposer$runRecomposeConcurrentlyAndApplyChanges$2$frameLoop$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f9209h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Recomposer recomposer = this.f9210i;
            MonotonicFrameClock monotonicFrameClock = this.f9211j;
            ProduceFrameSignal produceFrameSignal = this.f9212k;
            this.f9209h = 1;
            if (recomposer.runFrameLoop(monotonicFrameClock, produceFrameSignal, this) == coroutine_suspended) {
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
