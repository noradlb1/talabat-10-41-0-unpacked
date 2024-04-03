package kotlinx.coroutines.rx2;

import io.reactivex.ObservableSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxAwaitKt", f = "RxAwait.kt", i = {0}, l = {174}, m = "awaitFirstOrElse", n = {"defaultValue"}, s = {"L$0"})
public final class RxAwaitKt$awaitFirstOrElse$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26279h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f26280i;

    /* renamed from: j  reason: collision with root package name */
    public int f26281j;

    public RxAwaitKt$awaitFirstOrElse$1(Continuation<? super RxAwaitKt$awaitFirstOrElse$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26280i = obj;
        this.f26281j |= Integer.MIN_VALUE;
        return RxAwaitKt.awaitFirstOrElse((ObservableSource) null, (Function0) null, this);
    }
}
