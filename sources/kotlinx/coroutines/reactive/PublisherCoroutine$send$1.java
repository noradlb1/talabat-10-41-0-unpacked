package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.reactive.PublisherCoroutine", f = "Publish.kt", i = {0, 0}, l = {98}, m = "send", n = {"this", "element"}, s = {"L$0", "L$1"})
public final class PublisherCoroutine$send$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26256h;

    /* renamed from: i  reason: collision with root package name */
    public Object f26257i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f26258j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ PublisherCoroutine<T> f26259k;

    /* renamed from: l  reason: collision with root package name */
    public int f26260l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PublisherCoroutine$send$1(PublisherCoroutine<? super T> publisherCoroutine, Continuation<? super PublisherCoroutine$send$1> continuation) {
        super(continuation);
        this.f26259k = publisherCoroutine;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26258j = obj;
        this.f26260l |= Integer.MIN_VALUE;
        return this.f26259k.send(null, this);
    }
}
