package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scrollToItem$2", f = "LazyStaggeredGridState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LazyStaggeredGridState$scrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f3172h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LazyStaggeredGridState f3173i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3174j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f3175k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyStaggeredGridState$scrollToItem$2(LazyStaggeredGridState lazyStaggeredGridState, int i11, int i12, Continuation<? super LazyStaggeredGridState$scrollToItem$2> continuation) {
        super(2, continuation);
        this.f3173i = lazyStaggeredGridState;
        this.f3174j = i11;
        this.f3175k = i12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        LazyStaggeredGridState$scrollToItem$2 lazyStaggeredGridState$scrollToItem$2 = new LazyStaggeredGridState$scrollToItem$2(this.f3173i, this.f3174j, this.f3175k, continuation);
        lazyStaggeredGridState$scrollToItem$2.L$0 = obj;
        return lazyStaggeredGridState$scrollToItem$2;
    }

    @Nullable
    public final Object invoke(@NotNull ScrollScope scrollScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LazyStaggeredGridState$scrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f3172h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f3173i.snapToItemInternal$foundation_release((ScrollScope) this.L$0, this.f3174j, this.f3175k);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
