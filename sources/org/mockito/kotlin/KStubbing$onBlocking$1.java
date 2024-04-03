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
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a&\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005\"\u0004\b\u0001\u0010\u0002\"\u0006\b\u0002\u0010\u0004 \u0001*\u00020\u0006H@¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Lorg/mockito/stubbing/OngoingStubbing;", "R", "kotlin.jvm.PlatformType", "T", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "org.mockito.kotlin.KStubbing$onBlocking$1", f = "KStubbing.kt", i = {0}, l = {82}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"})
public final class KStubbing$onBlocking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OngoingStubbing<R>>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f63281h;

    /* renamed from: i  reason: collision with root package name */
    public int f63282i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ KStubbing f63283j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2 f63284k;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KStubbing$onBlocking$1(KStubbing kStubbing, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.f63283j = kStubbing;
        this.f63284k = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        KStubbing$onBlocking$1 kStubbing$onBlocking$1 = new KStubbing$onBlocking$1(this.f63283j, this.f63284k, continuation);
        kStubbing$onBlocking$1.p$ = (CoroutineScope) obj;
        return kStubbing$onBlocking$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((KStubbing$onBlocking$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f63282i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = this.p$;
            Function2 function2 = this.f63284k;
            Object mock = this.f63283j.getMock();
            this.f63281h = coroutineScope;
            this.f63282i = 1;
            obj = function2.invoke(mock, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            CoroutineScope coroutineScope2 = (CoroutineScope) this.f63281h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Mockito.when(obj);
    }
}
