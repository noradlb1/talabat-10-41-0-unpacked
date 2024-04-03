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
@DebugMetadata(c = "androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine", f = "SuspendingPointerInputFilter.kt", i = {}, l = {600}, m = "withTimeoutOrNull", n = {}, s = {})
public final class SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f9809h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SuspendingPointerInputFilter.PointerEventHandlerCoroutine<R> f9810i;

    /* renamed from: j  reason: collision with root package name */
    public int f9811j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1(SuspendingPointerInputFilter.PointerEventHandlerCoroutine<R> pointerEventHandlerCoroutine, Continuation<? super SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeoutOrNull$1> continuation) {
        super(continuation);
        this.f9810i = pointerEventHandlerCoroutine;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f9809h = obj;
        this.f9811j |= Integer.MIN_VALUE;
        return this.f9810i.withTimeoutOrNull(0, (Function2) null, this);
    }
}
