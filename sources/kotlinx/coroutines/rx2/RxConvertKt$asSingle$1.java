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

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H@"}, d2 = {"", "T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxConvertKt$asSingle$1", f = "RxConvert.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
public final class RxConvertKt$asSingle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f26319h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Deferred<T> f26320i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxConvertKt$asSingle$1(Deferred<? extends T> deferred, Continuation<? super RxConvertKt$asSingle$1> continuation) {
        super(2, continuation);
        this.f26320i = deferred;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RxConvertKt$asSingle$1(this.f26320i, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super T> continuation) {
        return ((RxConvertKt$asSingle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26319h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Deferred<T> deferred = this.f26320i;
            this.f26319h = 1;
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
