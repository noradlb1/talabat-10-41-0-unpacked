package androidx.slidingpanelayout.widget;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1", f = "FoldingFeatureObserver.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
public final class FoldingFeatureObserver$registerLayoutStateChangeCallback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f37594h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ FoldingFeatureObserver f37595i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Activity f37596j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FoldingFeatureObserver$registerLayoutStateChangeCallback$1(FoldingFeatureObserver foldingFeatureObserver, Activity activity, Continuation<? super FoldingFeatureObserver$registerLayoutStateChangeCallback$1> continuation) {
        super(2, continuation);
        this.f37595i = foldingFeatureObserver;
        this.f37596j = activity;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this.f37595i, this.f37596j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FoldingFeatureObserver$registerLayoutStateChangeCallback$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f37594h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow distinctUntilChanged = FlowKt.distinctUntilChanged(new FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1(this.f37595i.windowInfoTracker.windowLayoutInfo(this.f37596j), this.f37595i));
            FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1 foldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1 = new FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1(this.f37595i);
            this.f37594h = 1;
            if (distinctUntilChanged.collect(foldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
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
