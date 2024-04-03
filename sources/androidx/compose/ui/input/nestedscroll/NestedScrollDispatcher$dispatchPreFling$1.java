package androidx.compose.ui.input.nestedscroll;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher", f = "NestedScrollModifier.kt", i = {}, l = {202}, m = "dispatchPreFling-QWom1Mo", n = {}, s = {})
public final class NestedScrollDispatcher$dispatchPreFling$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public /* synthetic */ Object f9754h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ NestedScrollDispatcher f9755i;

    /* renamed from: j  reason: collision with root package name */
    public int f9756j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NestedScrollDispatcher$dispatchPreFling$1(NestedScrollDispatcher nestedScrollDispatcher, Continuation<? super NestedScrollDispatcher$dispatchPreFling$1> continuation) {
        super(continuation);
        this.f9755i = nestedScrollDispatcher;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f9754h = obj;
        this.f9756j |= Integer.MIN_VALUE;
        return this.f9755i.m4204dispatchPreFlingQWom1Mo(0, this);
    }
}
