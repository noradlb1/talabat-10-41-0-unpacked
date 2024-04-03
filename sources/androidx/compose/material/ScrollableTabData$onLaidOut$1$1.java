package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.ScrollState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.compose.material.ScrollableTabData$onLaidOut$1$1", f = "TabRow.kt", i = {}, l = {475}, m = "invokeSuspend", n = {}, s = {})
public final class ScrollableTabData$onLaidOut$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f5069h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ScrollableTabData f5070i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f5071j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollableTabData$onLaidOut$1$1(ScrollableTabData scrollableTabData, int i11, Continuation<? super ScrollableTabData$onLaidOut$1$1> continuation) {
        super(2, continuation);
        this.f5070i = scrollableTabData;
        this.f5071j = i11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ScrollableTabData$onLaidOut$1$1(this.f5070i, this.f5071j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ScrollableTabData$onLaidOut$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f5069h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ScrollState access$getScrollState$p = this.f5070i.scrollState;
            int i12 = this.f5071j;
            AnimationSpec access$getScrollableTabRowScrollSpec$p = TabRowKt.ScrollableTabRowScrollSpec;
            this.f5069h = 1;
            if (access$getScrollState$p.animateScrollTo(i12, access$getScrollableTabRowScrollSpec$p, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
