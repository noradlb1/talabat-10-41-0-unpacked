package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "Landroidx/datastore/core/SingleProcessDataStore$Message;", "msg", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", i = {}, l = {239, 242}, m = "invokeSuspend", n = {}, s = {})
public final class SingleProcessDataStore$actor$3 extends SuspendLambda implements Function2<SingleProcessDataStore.Message<T>, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f35635h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f35636i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f35637j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$actor$3(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$actor$3> continuation) {
        super(2, continuation);
        this.f35637j = singleProcessDataStore;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SingleProcessDataStore$actor$3 singleProcessDataStore$actor$3 = new SingleProcessDataStore$actor$3(this.f35637j, continuation);
        singleProcessDataStore$actor$3.f35636i = obj;
        return singleProcessDataStore$actor$3;
    }

    @Nullable
    public final Object invoke(@NotNull SingleProcessDataStore.Message<T> message, @Nullable Continuation<? super Unit> continuation) {
        return ((SingleProcessDataStore$actor$3) create(message, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f35635h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            SingleProcessDataStore.Message message = (SingleProcessDataStore.Message) this.f35636i;
            if (message instanceof SingleProcessDataStore.Message.Read) {
                this.f35635h = 1;
                if (this.f35637j.handleRead((SingleProcessDataStore.Message.Read) message, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (message instanceof SingleProcessDataStore.Message.Update) {
                this.f35635h = 2;
                if (this.f35637j.handleUpdate((SingleProcessDataStore.Message.Update) message, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1 || i11 == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
