package androidx.paging;

import androidx.paging.SingleRunner;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H@"}, d2 = {"", "priority", "Lkotlinx/coroutines/Job;", "job", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "tryEnqueue"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.SingleRunner$Holder", f = "SingleRunner.kt", i = {0, 0, 0, 1, 1, 1}, l = {129, 100}, m = "tryEnqueue", n = {"this", "job", "priority", "this", "job", "priority"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"})
public final class SingleRunner$Holder$tryEnqueue$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37153h;

    /* renamed from: i  reason: collision with root package name */
    public int f37154i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SingleRunner.Holder f37155j;

    /* renamed from: k  reason: collision with root package name */
    public Object f37156k;

    /* renamed from: l  reason: collision with root package name */
    public Object f37157l;

    /* renamed from: m  reason: collision with root package name */
    public Object f37158m;

    /* renamed from: n  reason: collision with root package name */
    public int f37159n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleRunner$Holder$tryEnqueue$1(SingleRunner.Holder holder, Continuation continuation) {
        super(continuation);
        this.f37155j = holder;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37153h = obj;
        this.f37154i |= Integer.MIN_VALUE;
        return this.f37155j.tryEnqueue(0, (Job) null, this);
    }
}
