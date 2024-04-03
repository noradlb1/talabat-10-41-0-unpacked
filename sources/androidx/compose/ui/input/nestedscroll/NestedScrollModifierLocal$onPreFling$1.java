package androidx.compose.ui.input.nestedscroll;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal", f = "NestedScrollModifierLocal.kt", i = {0, 0, 1}, l = {88, 89}, m = "onPreFling-QWom1Mo", n = {"this", "available", "parentPreConsumed"}, s = {"L$0", "J$0", "J$0"})
public final class NestedScrollModifierLocal$onPreFling$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f9768h;

    /* renamed from: i  reason: collision with root package name */
    public long f9769i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f9770j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ NestedScrollModifierLocal f9771k;

    /* renamed from: l  reason: collision with root package name */
    public int f9772l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedScrollModifierLocal$onPreFling$1(NestedScrollModifierLocal nestedScrollModifierLocal, Continuation<? super NestedScrollModifierLocal$onPreFling$1> continuation) {
        super(continuation);
        this.f9771k = nestedScrollModifierLocal;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f9770j = obj;
        this.f9772l |= Integer.MIN_VALUE;
        return this.f9771k.m4208onPreFlingQWom1Mo(0, this);
    }
}
