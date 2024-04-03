package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "E", "<anonymous parameter 0>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OnUndeliveredElementKt$bindCancellationFun$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<E, Unit> f26197g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ E f26198h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f26199i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OnUndeliveredElementKt$bindCancellationFun$1(Function1<? super E, Unit> function1, E e11, CoroutineContext coroutineContext) {
        super(1);
        this.f26197g = function1;
        this.f26198h = e11;
        this.f26199i = coroutineContext;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        OnUndeliveredElementKt.callUndeliveredElement(this.f26197g, this.f26198h, this.f26199i);
    }
}
