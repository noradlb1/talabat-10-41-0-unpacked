package androidx.lifecycle;

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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "androidx.lifecycle.LiveDataScopeImpl$emit$2", f = "CoroutineLiveData.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
public final class LiveDataScopeImpl$emit$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36062h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LiveDataScopeImpl f36063i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f36064j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveDataScopeImpl$emit$2(LiveDataScopeImpl liveDataScopeImpl, Object obj, Continuation continuation) {
        super(2, continuation);
        this.f36063i = liveDataScopeImpl;
        this.f36064j = obj;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new LiveDataScopeImpl$emit$2(this.f36063i, this.f36064j, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((LiveDataScopeImpl$emit$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36062h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineLiveData target$lifecycle_livedata_ktx_release = this.f36063i.getTarget$lifecycle_livedata_ktx_release();
            this.f36062h = 1;
            if (target$lifecycle_livedata_ktx_release.clearSource$lifecycle_livedata_ktx_release(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f36063i.getTarget$lifecycle_livedata_ktx_release().setValue(this.f36064j);
        return Unit.INSTANCE;
    }
}
