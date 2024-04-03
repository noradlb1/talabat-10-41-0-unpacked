package com.talabat.feature.pickup.presentation;

import com.talabat.feature.pickup.data.events.valuePropBanner.ValuePropBannerShown;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "pageNum", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PickupViewModel$pageLoadedSuccess$1 extends Lambda implements Function1<Integer, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PickupViewModel f58666g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PickupViewModel$pageLoadedSuccess$1(PickupViewModel pickupViewModel) {
        super(1);
        this.f58666g = pickupViewModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i11) {
        this.f58666g.getValuePropBannerLiveData().postValue(this.f58666g.valuePropBanner());
        if (this.f58666g.shouldShowValuePropBanner()) {
            this.f58666g.tracker.track(ValuePropBannerShown.INSTANCE);
        }
        this.f58666g.getSwimlanesLiveData().postValue(this.f58666g.isCuisineFilterSelected() ? CollectionsKt__CollectionsKt.emptyList() : this.f58666g.swimlanesViewCache);
        if (i11 == 1) {
            this.f58666g.getScrollToTopLiveData().postValue(Boolean.TRUE);
        }
    }
}
