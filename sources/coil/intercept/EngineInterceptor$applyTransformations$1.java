package coil.intercept;

import coil.EventListener;
import coil.decode.Options;
import coil.fetch.DrawableResult;
import coil.request.ImageRequest;
import coil.size.Size;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", i = {0, 0, 0, 0, 0, 0}, l = {380}, m = "applyTransformations$coil_base_release", n = {"this", "result", "request", "size", "eventListener", "$this$foldIndices$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
public final class EngineInterceptor$applyTransformations$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f39718h;

    /* renamed from: i  reason: collision with root package name */
    public Object f39719i;

    /* renamed from: j  reason: collision with root package name */
    public Object f39720j;

    /* renamed from: k  reason: collision with root package name */
    public Object f39721k;

    /* renamed from: l  reason: collision with root package name */
    public Object f39722l;

    /* renamed from: m  reason: collision with root package name */
    public Object f39723m;

    /* renamed from: n  reason: collision with root package name */
    public int f39724n;

    /* renamed from: o  reason: collision with root package name */
    public int f39725o;

    /* renamed from: p  reason: collision with root package name */
    public /* synthetic */ Object f39726p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ EngineInterceptor f39727q;

    /* renamed from: r  reason: collision with root package name */
    public int f39728r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$applyTransformations$1(EngineInterceptor engineInterceptor, Continuation<? super EngineInterceptor$applyTransformations$1> continuation) {
        super(continuation);
        this.f39727q = engineInterceptor;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f39726p = obj;
        this.f39728r |= Integer.MIN_VALUE;
        return this.f39727q.applyTransformations$coil_base_release((DrawableResult) null, (ImageRequest) null, (Size) null, (Options) null, (EventListener) null, this);
    }
}
