package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0003\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0001 \u0000H@"}, d2 = {"R", "T", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherCoroutine$registerSelectClause2$clause$1", f = "Publish.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
public final class PublisherCoroutine$registerSelectClause2$clause$1 extends SuspendLambda implements Function1<Continuation<? super R>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f26252h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PublisherCoroutine<T> f26253i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ T f26254j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<SendChannel<? super T>, Continuation<? super R>, Object> f26255k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublisherCoroutine$registerSelectClause2$clause$1(PublisherCoroutine<? super T> publisherCoroutine, T t11, Function2<? super SendChannel<? super T>, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super PublisherCoroutine$registerSelectClause2$clause$1> continuation) {
        super(1, continuation);
        this.f26253i = publisherCoroutine;
        this.f26254j = t11;
        this.f26255k = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull Continuation<?> continuation) {
        return new PublisherCoroutine$registerSelectClause2$clause$1(this.f26253i, this.f26254j, this.f26255k, continuation);
    }

    @Nullable
    public final Object invoke(@Nullable Continuation<? super R> continuation) {
        return ((PublisherCoroutine$registerSelectClause2$clause$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26252h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Throwable access$doLockedNext = this.f26253i.doLockedNext(this.f26254j);
            if (access$doLockedNext == null) {
                Function2<SendChannel<? super T>, Continuation<? super R>, Object> function2 = this.f26255k;
                PublisherCoroutine<T> publisherCoroutine = this.f26253i;
                this.f26252h = 1;
                obj = function2.invoke(publisherCoroutine, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw access$doLockedNext;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
