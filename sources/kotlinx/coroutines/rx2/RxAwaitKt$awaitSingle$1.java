package kotlinx.coroutines.rx2;

import io.reactivex.MaybeSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxAwaitKt", f = "RxAwait.kt", i = {}, l = {64}, m = "awaitSingle", n = {}, s = {})
public final class RxAwaitKt$awaitSingle$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f26289h;

    /* renamed from: i  reason: collision with root package name */
    public int f26290i;

    public RxAwaitKt$awaitSingle$1(Continuation<? super RxAwaitKt$awaitSingle$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26289h = obj;
        this.f26290i |= Integer.MIN_VALUE;
        return RxAwaitKt.awaitSingle((MaybeSource) null, this);
    }
}
