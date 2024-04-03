package coil;

import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "coil.RealImageLoader", f = "RealImageLoader.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6}, l = {286, 175, 294, 296, 311, 328, 339}, m = "executeMain", n = {"this", "request", "eventListener", "targetDelegate", "requestDelegate", "type", "this", "request", "eventListener", "targetDelegate", "requestDelegate", "cached", "type", "this", "request", "eventListener", "targetDelegate", "requestDelegate", "this", "request", "eventListener", "targetDelegate", "requestDelegate", "this", "request", "eventListener", "targetDelegate", "requestDelegate", "result", "this_$iv", "result$iv", "request$iv", "metadata$iv", "this", "request", "eventListener", "targetDelegate", "requestDelegate", "result", "result$iv", "request$iv", "eventListener", "requestDelegate", "result", "request$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3"})
public final class RealImageLoader$executeMain$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f39680h;

    /* renamed from: i  reason: collision with root package name */
    public Object f39681i;

    /* renamed from: j  reason: collision with root package name */
    public Object f39682j;

    /* renamed from: k  reason: collision with root package name */
    public Object f39683k;

    /* renamed from: l  reason: collision with root package name */
    public Object f39684l;

    /* renamed from: m  reason: collision with root package name */
    public Object f39685m;

    /* renamed from: n  reason: collision with root package name */
    public Object f39686n;

    /* renamed from: o  reason: collision with root package name */
    public Object f39687o;

    /* renamed from: p  reason: collision with root package name */
    public Object f39688p;

    /* renamed from: q  reason: collision with root package name */
    public Object f39689q;

    /* renamed from: r  reason: collision with root package name */
    public int f39690r;

    /* renamed from: s  reason: collision with root package name */
    public /* synthetic */ Object f39691s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ RealImageLoader f39692t;

    /* renamed from: u  reason: collision with root package name */
    public int f39693u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RealImageLoader$executeMain$1(RealImageLoader realImageLoader, Continuation<? super RealImageLoader$executeMain$1> continuation) {
        super(continuation);
        this.f39692t = realImageLoader;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f39691s = obj;
        this.f39693u |= Integer.MIN_VALUE;
        return this.f39692t.executeMain((ImageRequest) null, 0, this);
    }
}
