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
@DebugMetadata(c = "com.deliveryhero.impression.view.viewpager.ViewPagerTracker$register$1", f = "ViewPagerTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ViewPagerTracker$register$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f30348h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ViewPagerTracker f30349i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewPagerTracker$register$1(ViewPagerTracker viewPagerTracker, Continuation<? super ViewPagerTracker$register$1> continuation) {
        super(2, continuation);
        this.f30349i = viewPagerTracker;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ViewPagerTracker$register$1 viewPagerTracker$register$1 = new ViewPagerTracker$register$1(this.f30349i, continuation);
        viewPagerTracker$register$1.L$0 = obj;
        return viewPagerTracker$register$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ViewPagerTracker$register$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        Unit unit;
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f30348h == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            ViewPagerTracker viewPagerTracker = this.f30349i;
            try {
                Result.Companion companion = Result.Companion;
                ViewPager access$getViewPager$p = viewPagerTracker.viewPager;
                if (access$getViewPager$p == null) {
                    unit = null;
                } else {
                    access$getViewPager$p.addOnPageChangeListener(viewPagerTracker);
                    unit = Unit.INSTANCE;
                }
                Result.m6329constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            if (!(this.f30349i.getParentPosition() != null || (lifecycleOwner = this.f30349i.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
                lifecycle.addObserver(this.f30349i.lifecycleObserver);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
