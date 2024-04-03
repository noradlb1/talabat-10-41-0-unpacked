package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1", f = "Emitters.kt", i = {}, l = {42}, m = "emit", n = {}, s = {})
public final class FlowKt__EmittersKt$transform$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f25613h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FlowKt__EmittersKt$transform$1.AnonymousClass1<T> f25614i;

    /* renamed from: j  reason: collision with root package name */
    public int f25615j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__EmittersKt$transform$1$1$emit$1(FlowKt__EmittersKt$transform$1.AnonymousClass1<? super T> r12, Continuation<? super FlowKt__EmittersKt$transform$1$1$emit$1> continuation) {
        super(continuation);
        this.f25614i = r12;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f25613h = obj;
        this.f25615j |= Integer.MIN_VALUE;
        return this.f25614i.emit(null, this);
    }
}
