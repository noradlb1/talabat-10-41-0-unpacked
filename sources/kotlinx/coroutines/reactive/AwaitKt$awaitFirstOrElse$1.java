package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.AwaitKt", f = "Await.kt", i = {0}, l = {56}, m = "awaitFirstOrElse", n = {"defaultValue"}, s = {"L$0"})
public final class AwaitKt$awaitFirstOrElse$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26203h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f26204i;

    /* renamed from: j  reason: collision with root package name */
    public int f26205j;

    public AwaitKt$awaitFirstOrElse$1(Continuation<? super AwaitKt$awaitFirstOrElse$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26204i = obj;
        this.f26205j |= Integer.MIN_VALUE;
        return AwaitKt.awaitFirstOrElse((Publisher) null, (Function0) null, this);
    }
}
