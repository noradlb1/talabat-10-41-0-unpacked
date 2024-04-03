package com.deliveryhero.impression.compose;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ComposeImpressionTracker$lifecycleObserver$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.Event f30307g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ComposeImpressionTracker f30308h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeImpressionTracker$lifecycleObserver$1$1(Lifecycle.Event event, ComposeImpressionTracker composeImpressionTracker) {
        super(0);
        this.f30307g = event;
        this.f30308h = composeImpressionTracker;
    }

    public final void invoke() {
        Lifecycle.Event event = this.f30307g;
        if (event == Lifecycle.Event.ON_STOP) {
            this.f30308h.checkIfVisibleItemsCanBeTracked();
        } else if (event == Lifecycle.Event.ON_START) {
            ComposeImpressionTracker.d(this.f30308h, 0, 1, (Object) null);
        }
    }
}
