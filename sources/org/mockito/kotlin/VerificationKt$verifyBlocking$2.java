package org.mockito.kotlin;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "org.mockito.kotlin.VerificationKt$verifyBlocking$2", f = "Verification.kt", i = {0}, l = {64}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"})
public final class VerificationKt$verifyBlocking$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f63292h;

    /* renamed from: i  reason: collision with root package name */
    public int f63293i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2 f63294j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f63295k;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerificationKt$verifyBlocking$2(Function2 function2, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f63294j = function2;
        this.f63295k = obj;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        VerificationKt$verifyBlocking$2 verificationKt$verifyBlocking$2 = new VerificationKt$verifyBlocking$2(this.f63294j, this.f63295k, continuation);
        verificationKt$verifyBlocking$2.p$ = (CoroutineScope) obj;
        return verificationKt$verifyBlocking$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((VerificationKt$verifyBlocking$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f63293i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            Function2 function2 = this.f63294j;
            Object obj2 = this.f63295k;
            this.f63292h = coroutineScope;
            this.f63293i = 1;
            if (function2.invoke(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.f63292h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
