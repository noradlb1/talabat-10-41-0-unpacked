package com.talabat.home;

import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.talabat.fluid.homescreen.domain.tracking.events.replacementbottomsheet.ItemReplacementBottomSheetTracker;
import com.talabat.fluid.homescreen.domain.usecase.business.ShowItemReplacementBottomSheetUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity$createNavigationBar$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DSBottomSheet f60879g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ItemReplacementBottomSheetTracker f60880h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo f60881i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f60882j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenActivity$createNavigationBar$1$1(DSBottomSheet dSBottomSheet, ItemReplacementBottomSheetTracker itemReplacementBottomSheetTracker, ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo itemReplacementInfo, HomeScreenActivity homeScreenActivity) {
        super(0);
        this.f60879g = dSBottomSheet;
        this.f60880h = itemReplacementBottomSheetTracker;
        this.f60881i = itemReplacementInfo;
        this.f60882j = homeScreenActivity;
    }

    public final void invoke() {
        this.f60879g.dismiss();
        this.f60880h.trackClosingBottomSheet(this.f60881i.getChainId(), this.f60882j.getEventNavigationOrigin(), this.f60882j.getScreenName());
    }
}
