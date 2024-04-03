package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2", f = "Scrollable.kt", i = {}, l = {459}, m = "invokeSuspend", n = {}, s = {})
public final class ScrollingLogic$doFlingAnimation$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f2201h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2202i;

    /* renamed from: j  reason: collision with root package name */
    public long f2203j;

    /* renamed from: k  reason: collision with root package name */
    public int f2204k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ ScrollingLogic f2205l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f2206m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ long f2207n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$doFlingAnimation$2(ScrollingLogic scrollingLogic, Ref.LongRef longRef, long j11, Continuation<? super ScrollingLogic$doFlingAnimation$2> continuation) {
        super(2, continuation);
        this.f2205l = scrollingLogic;
        this.f2206m = longRef;
        this.f2207n = j11;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(this.f2205l, this.f2206m, this.f2207n, continuation);
        scrollingLogic$doFlingAnimation$2.L$0 = obj;
        return scrollingLogic$doFlingAnimation$2;
    }

    @Nullable
    public final Object invoke(@NotNull ScrollScope scrollScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ScrollingLogic$doFlingAnimation$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ScrollingLogic scrollingLogic;
        ScrollingLogic scrollingLogic2;
        Ref.LongRef longRef;
        long j11;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2204k;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ScrollingLogic$doFlingAnimation$2$scope$1 scrollingLogic$doFlingAnimation$2$scope$1 = new ScrollingLogic$doFlingAnimation$2$scope$1(this.f2205l, new ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1(this.f2205l, (ScrollScope) this.L$0));
            scrollingLogic2 = this.f2205l;
            Ref.LongRef longRef2 = this.f2206m;
            long j12 = this.f2207n;
            FlingBehavior flingBehavior = scrollingLogic2.getFlingBehavior();
            long j13 = longRef2.element;
            float reverseIfNeeded = scrollingLogic2.reverseIfNeeded(scrollingLogic2.m354toFloatTH1AsA0(j12));
            this.L$0 = scrollingLogic2;
            this.f2201h = scrollingLogic2;
            this.f2202i = longRef2;
            this.f2203j = j13;
            this.f2204k = 1;
            obj = flingBehavior.performFling(scrollingLogic$doFlingAnimation$2$scope$1, reverseIfNeeded, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            longRef = longRef2;
            scrollingLogic = scrollingLogic2;
            j11 = j13;
        } else if (i11 == 1) {
            j11 = this.f2203j;
            longRef = (Ref.LongRef) this.f2202i;
            scrollingLogic2 = (ScrollingLogic) this.f2201h;
            scrollingLogic = (ScrollingLogic) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        longRef.element = scrollingLogic2.m357updateQWom1Mo(j11, scrollingLogic.reverseIfNeeded(((Number) obj).floatValue()));
        return Unit.INSTANCE;
    }
}
