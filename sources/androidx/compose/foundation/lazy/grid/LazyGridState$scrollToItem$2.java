package androidx.compose.foundation.lazy.grid;

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
@DebugMetadata(c = "androidx.compose.foundation.lazy.grid.LazyGridState$scrollToItem$2", f = "LazyGridState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class LazyGridState$scrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f2963h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LazyGridState f2964i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f2965j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f2966k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyGridState$scrollToItem$2(LazyGridState lazyGridState, int i11, int i12, Continuation<? super LazyGridState$scrollToItem$2> continuation) {
        super(2, continuation);
        this.f2964i = lazyGridState;
        this.f2965j = i11;
        this.f2966k = i12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LazyGridState$scrollToItem$2(this.f2964i, this.f2965j, this.f2966k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull ScrollScope scrollScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LazyGridState$scrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f2963h == 0) {
            ResultKt.throwOnFailure(obj);
            this.f2964i.snapToItemIndexInternal$foundation_release(this.f2965j, this.f2966k);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
