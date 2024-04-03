package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H@"}, d2 = {"T", "Lkotlin/Function0;", "", "block", "Lkotlin/coroutines/Continuation;", "continuation", "", "awaitClose"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.SimpleProducerScopeImpl", f = "SimpleChannelFlow.kt", i = {0}, l = {97}, m = "awaitClose", n = {"block"}, s = {"L$0"})
public final class SimpleProducerScopeImpl$awaitClose$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37141h;

    /* renamed from: i  reason: collision with root package name */
    public int f37142i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SimpleProducerScopeImpl f37143j;

    /* renamed from: k  reason: collision with root package name */
    public Object f37144k;

    /* renamed from: l  reason: collision with root package name */
    public Object f37145l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleProducerScopeImpl$awaitClose$1(SimpleProducerScopeImpl simpleProducerScopeImpl, Continuation continuation) {
        super(continuation);
        this.f37143j = simpleProducerScopeImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37141h = obj;
        this.f37142i |= Integer.MIN_VALUE;
        return this.f37143j.awaitClose((Function0<Unit>) null, this);
    }
}
