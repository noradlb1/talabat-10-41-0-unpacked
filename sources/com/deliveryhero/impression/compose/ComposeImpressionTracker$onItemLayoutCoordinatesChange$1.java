package com.deliveryhero.impression.compose;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class ComposeImpressionTracker$onItemLayoutCoordinatesChange$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ComposeImpressionTracker f30312g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ long f30313h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Rect f30314i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Rect f30315j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ int f30316k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Integer f30317l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeImpressionTracker$onItemLayoutCoordinatesChange$1(ComposeImpressionTracker composeImpressionTracker, long j11, Rect rect, Rect rect2, int i11, Integer num) {
        super(0);
        this.f30312g = composeImpressionTracker;
        this.f30313h = j11;
        this.f30314i = rect;
        this.f30315j = rect2;
        this.f30316k = i11;
        this.f30317l = num;
    }

    public final void invoke() {
        if (this.f30312g.isVisibilitySufficient(this.f30312g.visibleAreaDetector.m8232calculateVisibleAreaaZF9jCo(this.f30313h, this.f30314i, this.f30315j), this.f30316k, this.f30317l)) {
            this.f30312g.getVisibleItems().addIfNotExists(this.f30316k, this.f30317l, this.f30312g.currentTime.invoke());
        } else {
            ComposeImpressionTracker.c(this.f30312g, this.f30316k, this.f30317l, false, 4, (Object) null);
        }
    }
}
