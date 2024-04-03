package androidx.compose.ui.input.pointer;

import androidx.compose.ui.input.pointer.SuspendingPointerInputFilter;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine", f = "SuspendingPointerInputFilter.kt", i = {0}, l = {628}, m = "withTimeout", n = {"job"}, s = {"L$0"})
public final class SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f9802h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f9803i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SuspendingPointerInputFilter.PointerEventHandlerCoroutine<R> f9804j;

    /* renamed from: k  reason: collision with root package name */
    public int f9805k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1(SuspendingPointerInputFilter.PointerEventHandlerCoroutine<R> pointerEventHandlerCoroutine, Continuation<? super SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$1> continuation) {
        super(continuation);
        this.f9804j = pointerEventHandlerCoroutine;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f9803i = obj;
        this.f9805k |= Integer.MIN_VALUE;
        return this.f9804j.withTimeout(0, (Function2) null, this);
    }
}
