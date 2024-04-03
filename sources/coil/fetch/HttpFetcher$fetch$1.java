package coil.fetch;

import coil.bitmap.BitmapPool;
import coil.decode.Options;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "coil.fetch.HttpFetcher", f = "HttpFetcher.kt", i = {0, 0, 0}, l = {125}, m = "fetch$suspendImpl", n = {"this", "url", "$this$await$iv"}, s = {"L$0", "L$1", "L$2"})
public final class HttpFetcher$fetch$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f39712h;

    /* renamed from: i  reason: collision with root package name */
    public Object f39713i;

    /* renamed from: j  reason: collision with root package name */
    public Object f39714j;

    /* renamed from: k  reason: collision with root package name */
    public /* synthetic */ Object f39715k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ HttpFetcher<T> f39716l;

    /* renamed from: m  reason: collision with root package name */
    public int f39717m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpFetcher$fetch$1(HttpFetcher<T> httpFetcher, Continuation<? super HttpFetcher$fetch$1> continuation) {
        super(continuation);
        this.f39716l = httpFetcher;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f39715k = obj;
        this.f39717m |= Integer.MIN_VALUE;
        return HttpFetcher.a(this.f39716l, (BitmapPool) null, (Object) null, (Size) null, (Options) null, this);
    }
}
