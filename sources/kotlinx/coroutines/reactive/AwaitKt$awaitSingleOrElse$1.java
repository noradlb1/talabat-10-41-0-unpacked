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
@DebugMetadata(c = "kotlinx.coroutines.reactive.AwaitKt", f = "Await.kt", i = {0}, l = {170}, m = "awaitSingleOrElse", n = {"defaultValue"}, s = {"L$0"})
public final class AwaitKt$awaitSingleOrElse$1<T> extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26217h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f26218i;

    /* renamed from: j  reason: collision with root package name */
    public int f26219j;

    public AwaitKt$awaitSingleOrElse$1(Continuation<? super AwaitKt$awaitSingleOrElse$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26218i = obj;
        this.f26219j |= Integer.MIN_VALUE;
        return AwaitKt.awaitSingleOrElse((Publisher) null, (Function0) null, this);
    }
}
