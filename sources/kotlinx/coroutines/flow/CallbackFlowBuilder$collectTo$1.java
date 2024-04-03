package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", i = {0}, l = {336}, m = "collectTo", n = {"scope"}, s = {"L$0"})
public final class CallbackFlowBuilder$collectTo$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f25412h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25413i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CallbackFlowBuilder<T> f25414j;

    /* renamed from: k  reason: collision with root package name */
    public int f25415k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CallbackFlowBuilder$collectTo$1(CallbackFlowBuilder<T> callbackFlowBuilder, Continuation<? super CallbackFlowBuilder$collectTo$1> continuation) {
        super(continuation);
        this.f25414j = callbackFlowBuilder;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25413i = obj;
        this.f25415k |= Integer.MIN_VALUE;
        return this.f25414j.c((ProducerScope) null, this);
    }
}
