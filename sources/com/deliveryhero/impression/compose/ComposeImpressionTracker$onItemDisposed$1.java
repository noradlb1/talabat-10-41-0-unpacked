package com.deliveryhero.impression.compose;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ComposeImpressionTracker$onItemDisposed$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposeImpressionTracker f30309g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f30310h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Integer f30311i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeImpressionTracker$onItemDisposed$1(ComposeImpressionTracker composeImpressionTracker, int i11, Integer num) {
        super(0);
        this.f30309g = composeImpressionTracker;
        this.f30310h = i11;
        this.f30311i = num;
    }

    public final void invoke() {
        ComposeImpressionTracker.c(this.f30309g, this.f30310h, this.f30311i, false, 4, (Object) null);
    }
}
