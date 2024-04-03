package androidx.paging;

import kotlin.Metadata;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@"}, d2 = {"", "T", "Lkotlin/collections/IndexedValue;", "Landroidx/paging/PageEvent;", "event", "Lkotlin/coroutines/Continuation;", "", "continuation", "send"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.TemporaryDownstream", f = "CachedPageEventFlow.kt", i = {}, l = {149}, m = "send", n = {}, s = {})
public final class TemporaryDownstream$send$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37170h;

    /* renamed from: i  reason: collision with root package name */
    public int f37171i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ TemporaryDownstream f37172j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TemporaryDownstream$send$1(TemporaryDownstream temporaryDownstream, Continuation continuation) {
        super(continuation);
        this.f37172j = temporaryDownstream;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37170h = obj;
        this.f37171i |= Integer.MIN_VALUE;
        return this.f37172j.send((IndexedValue) null, this);
    }
}
