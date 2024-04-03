package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.StartedLazily$command$1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedLazily$command$1$1", f = "SharingStarted.kt", i = {}, l = {158}, m = "emit", n = {}, s = {})
public final class StartedLazily$command$1$1$emit$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f26051h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ StartedLazily$command$1.AnonymousClass1<T> f26052i;

    /* renamed from: j  reason: collision with root package name */
    public int f26053j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StartedLazily$command$1$1$emit$1(StartedLazily$command$1.AnonymousClass1<? super T> r12, Continuation<? super StartedLazily$command$1$1$emit$1> continuation) {
        super(continuation);
        this.f26052i = r12;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26051h = obj;
        this.f26053j |= Integer.MIN_VALUE;
        return this.f26052i.emit(0, (Continuation<? super Unit>) this);
    }
}
