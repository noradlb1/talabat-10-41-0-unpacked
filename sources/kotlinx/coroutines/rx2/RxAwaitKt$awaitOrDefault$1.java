package kotlinx.coroutines.rx2;

import io.reactivex.MaybeSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxAwaitKt", f = "RxAwait.kt", i = {0}, l = {108}, m = "awaitOrDefault", n = {"default"}, s = {"L$0"})
public final class RxAwaitKt$awaitOrDefault$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26286h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f26287i;

    /* renamed from: j  reason: collision with root package name */
    public int f26288j;

    public RxAwaitKt$awaitOrDefault$1(Continuation<? super RxAwaitKt$awaitOrDefault$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26287i = obj;
        this.f26288j |= Integer.MIN_VALUE;
        return RxAwaitKt.awaitOrDefault((MaybeSource) null, null, this);
    }
}
