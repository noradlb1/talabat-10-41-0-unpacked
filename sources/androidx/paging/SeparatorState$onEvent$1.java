package androidx.paging;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0005H@"}, d2 = {"", "R", "T", "Landroidx/paging/PageEvent;", "event", "Lkotlin/coroutines/Continuation;", "continuation", "onEvent"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.SeparatorState", f = "Separators.kt", i = {0, 1}, l = {213, 215}, m = "onEvent", n = {"this", "this"}, s = {"L$0", "L$0"})
public final class SeparatorState$onEvent$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37090h;

    /* renamed from: i  reason: collision with root package name */
    public int f37091i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SeparatorState f37092j;

    /* renamed from: k  reason: collision with root package name */
    public Object f37093k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SeparatorState$onEvent$1(SeparatorState separatorState, Continuation continuation) {
        super(continuation);
        this.f37092j = separatorState;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37090h = obj;
        this.f37091i |= Integer.MIN_VALUE;
        return this.f37092j.onEvent((PageEvent) null, this);
    }
}
