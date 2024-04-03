package androidx.paging;

import androidx.paging.SingleRunner;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H@"}, d2 = {"Lkotlinx/coroutines/Job;", "job", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "onFinish"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.SingleRunner$Holder", f = "SingleRunner.kt", i = {0, 0, 0}, l = {140}, m = "onFinish", n = {"this", "job", "$this$withLock$iv"}, s = {"L$0", "L$1", "L$2"})
public final class SingleRunner$Holder$onFinish$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37147h;

    /* renamed from: i  reason: collision with root package name */
    public int f37148i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SingleRunner.Holder f37149j;

    /* renamed from: k  reason: collision with root package name */
    public Object f37150k;

    /* renamed from: l  reason: collision with root package name */
    public Object f37151l;

    /* renamed from: m  reason: collision with root package name */
    public Object f37152m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleRunner$Holder$onFinish$1(SingleRunner.Holder holder, Continuation continuation) {
        super(continuation);
        this.f37149j = holder;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37147h = obj;
        this.f37148i |= Integer.MIN_VALUE;
        return this.f37149j.onFinish((Job) null, this);
    }
}
