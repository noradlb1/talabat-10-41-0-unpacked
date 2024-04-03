package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
public final class SafeCollector_commonKt$unsafeFlow$1$collect$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f26183h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SafeCollector_commonKt$unsafeFlow$1 f26184i;

    /* renamed from: j  reason: collision with root package name */
    public int f26185j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SafeCollector_commonKt$unsafeFlow$1$collect$1(SafeCollector_commonKt$unsafeFlow$1 safeCollector_commonKt$unsafeFlow$1, Continuation<? super SafeCollector_commonKt$unsafeFlow$1$collect$1> continuation) {
        super(continuation);
        this.f26184i = safeCollector_commonKt$unsafeFlow$1;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26183h = obj;
        this.f26185j |= Integer.MIN_VALUE;
        return this.f26184i.collect((FlowCollector) null, this);
    }
}
