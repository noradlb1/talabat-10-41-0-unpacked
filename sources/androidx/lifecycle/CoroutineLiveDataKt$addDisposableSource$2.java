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

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "Landroidx/lifecycle/EmittedSource;", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", f = "CoroutineLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutineLiveDataKt$addDisposableSource$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super EmittedSource>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f35999h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f36000i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ LiveData f36001j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutineLiveDataKt$addDisposableSource$2(MediatorLiveData mediatorLiveData, LiveData liveData, Continuation continuation) {
        super(2, continuation);
        this.f36000i = mediatorLiveData;
        this.f36001j = liveData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new CoroutineLiveDataKt$addDisposableSource$2(this.f36000i, this.f36001j, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CoroutineLiveDataKt$addDisposableSource$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f35999h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f36000i.addSource(this.f36001j, new Observer<T>(this) {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ CoroutineLiveDataKt$addDisposableSource$2 f36002a;

                {
                    this.f36002a = r1;
                }

                public final void onChanged(T t11) {
                    this.f36002a.f36000i.setValue(t11);
                }
            });
            return new EmittedSource(this.f36001j, this.f36000i);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
