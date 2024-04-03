package com.deliveryhero.impression.view.viewpager;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "com.deliveryhero.impression.view.viewpager.ViewPagerTracker$unregister$1", f = "ViewPagerTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ViewPagerTracker$unregister$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f30350h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ViewPagerTracker f30351i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewPagerTracker$unregister$1(ViewPagerTracker viewPagerTracker, Continuation<? super ViewPagerTracker$unregister$1> continuation) {
        super(2, continuation);
        this.f30351i = viewPagerTracker;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ViewPagerTracker$unregister$1 viewPagerTracker$unregister$1 = new ViewPagerTracker$unregister$1(this.f30351i, continuation);
        viewPagerTracker$unregister$1.L$0 = obj;
        return viewPagerTracker$unregister$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ViewPagerTracker$unregister$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Lifecycle lifecycle;
        Unit unit;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f30350h == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ViewPagerTracker viewPagerTracker = this.f30351i;
            try {
                Result.Companion companion = Result.Companion;
                ViewPager access$getViewPager$p = viewPagerTracker.viewPager;
                if (access$getViewPager$p == null) {
                    unit = null;
                } else {
                    access$getViewPager$p.removeOnPageChangeListener(viewPagerTracker);
                    unit = Unit.INSTANCE;
                }
                Result.m6329constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            LifecycleOwner lifecycleOwner = this.f30351i.getLifecycleOwner();
            if (!(lifecycleOwner == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
                lifecycle.removeObserver(this.f30351i.lifecycleObserver);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
