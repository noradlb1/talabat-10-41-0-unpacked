package androidx.lifecycle;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", i = {}, l = {187}, m = "invokeSuspend", n = {}, s = {})
public final class BlockRunner$cancel$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f35971h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ BlockRunner f35972i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BlockRunner$cancel$1(BlockRunner blockRunner, Continuation continuation) {
        super(2, continuation);
        this.f35972i = blockRunner;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new BlockRunner$cancel$1(this.f35972i, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((BlockRunner$cancel$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f35971h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            long access$getTimeoutInMs$p = this.f35972i.timeoutInMs;
            this.f35971h = 1;
            if (DelayKt.delay(access$getTimeoutInMs$p, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!this.f35972i.liveData.hasActiveObservers()) {
            Job access$getRunningJob$p = this.f35972i.runningJob;
            if (access$getRunningJob$p != null) {
                Job.DefaultImpls.cancel$default(access$getRunningJob$p, (CancellationException) null, 1, (Object) null);
            }
            this.f35972i.runningJob = null;
        }
        return Unit.INSTANCE;
    }
}
