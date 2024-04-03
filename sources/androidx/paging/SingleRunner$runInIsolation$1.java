package androidx.paging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H@"}, d2 = {"", "priority", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "", "block", "continuation", "runInIsolation"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.SingleRunner", f = "SingleRunner.kt", i = {0}, l = {49}, m = "runInIsolation", n = {"this"}, s = {"L$0"})
public final class SingleRunner$runInIsolation$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f37160h;

    /* renamed from: i  reason: collision with root package name */
    public int f37161i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SingleRunner f37162j;

    /* renamed from: k  reason: collision with root package name */
    public Object f37163k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleRunner$runInIsolation$1(SingleRunner singleRunner, Continuation continuation) {
        super(continuation);
        this.f37162j = singleRunner;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f37160h = obj;
        this.f37161i |= Integer.MIN_VALUE;
        return this.f37162j.runInIsolation(0, (Function1<? super Continuation<? super Unit>, ? extends Object>) null, this);
    }
}
