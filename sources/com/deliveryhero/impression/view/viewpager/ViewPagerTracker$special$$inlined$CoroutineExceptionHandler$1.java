package com.deliveryhero.impression.view.viewpager;

import com.deliveryhero.impression.view.ImpressionTrackerCallback;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ViewPagerTracker$special$$inlined$CoroutineExceptionHandler$1 extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewPagerTracker f30345b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewPagerTracker$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key key, ViewPagerTracker viewPagerTracker) {
        super(key);
        this.f30345b = viewPagerTracker;
    }

    public void handleException(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th2) {
        ImpressionTrackerCallback impressionTrackerCallback = this.f30345b.getImpressionTrackerCallback();
        if (impressionTrackerCallback != null) {
            impressionTrackerCallback.onError(this.f30345b, th2);
        }
    }
}
