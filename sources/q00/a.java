package q00;

import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.android.HandlerContext;

public final /* synthetic */ class a implements DisposableHandle {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HandlerContext f28154b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Runnable f28155c;

    public /* synthetic */ a(HandlerContext handlerContext, Runnable runnable) {
        this.f28154b = handlerContext;
        this.f28155c = runnable;
    }

    public final void dispose() {
        HandlerContext.m7786invokeOnTimeout$lambda3(this.f28154b, this.f28155c);
    }
}
