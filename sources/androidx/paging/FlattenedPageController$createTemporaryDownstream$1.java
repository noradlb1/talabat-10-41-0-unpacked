package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002H@"}, d2 = {"", "T", "Lkotlin/coroutines/Continuation;", "Landroidx/paging/TemporaryDownstream;", "continuation", "createTemporaryDownstream"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.FlattenedPageController", f = "CachedPageEventFlow.kt", i = {0, 0, 1, 1, 1}, l = {310, 188}, m = "createTemporaryDownstream", n = {"this", "$this$withLock$iv", "$this$withLock$iv", "snap", "index$iv"}, s = {"L$0", "L$1", "L$0", "L$2", "I$0"})
public final class FlattenedPageController$createTemporaryDownstream$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f36552h;

    /* renamed from: i  reason: collision with root package name */
    public int f36553i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ FlattenedPageController f36554j;

    /* renamed from: k  reason: collision with root package name */
    public Object f36555k;

    /* renamed from: l  reason: collision with root package name */
    public Object f36556l;

    /* renamed from: m  reason: collision with root package name */
    public Object f36557m;

    /* renamed from: n  reason: collision with root package name */
    public Object f36558n;

    /* renamed from: o  reason: collision with root package name */
    public int f36559o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlattenedPageController$createTemporaryDownstream$1(FlattenedPageController flattenedPageController, Continuation continuation) {
        super(continuation);
        this.f36554j = flattenedPageController;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f36552h = obj;
        this.f36553i |= Integer.MIN_VALUE;
        return this.f36554j.createTemporaryDownstream(this);
    }
}
