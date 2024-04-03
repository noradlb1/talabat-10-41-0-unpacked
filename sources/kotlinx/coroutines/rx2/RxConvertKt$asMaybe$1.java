package kotlinx.coroutines.rx2;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxConvertKt$asMaybe$1", f = "RxConvert.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
public final class RxConvertKt$asMaybe$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f26310h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Deferred<T> f26311i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxConvertKt$asMaybe$1(Deferred<? extends T> deferred, Continuation<? super RxConvertKt$asMaybe$1> continuation) {
        super(2, continuation);
        this.f26311i = deferred;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RxConvertKt$asMaybe$1(this.f26311i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super T> continuation) {
        return ((RxConvertKt$asMaybe$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26310h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Deferred<T> deferred = this.f26311i;
            this.f26310h = 1;
            obj = deferred.await(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
