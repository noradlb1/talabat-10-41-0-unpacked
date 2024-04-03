package com.talabat.home;

import com.designsystem.ds_bottom_sheet_v2.DSBottomSheet;
import com.talabat.core.navigation.domain.Navigator;
import com.talabat.core.navigation.domain.screen.itemreplacement.ItemReplacementScreen;
import com.talabat.fluid.homescreen.domain.tracking.events.replacementbottomsheet.ItemReplacementBottomSheetTracker;
import com.talabat.fluid.homescreen.domain.usecase.business.ShowItemReplacementBottomSheetUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class HomeScreenActivity$createFooter$1$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ItemReplacementBottomSheetTracker f60875g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo f60876h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ HomeScreenActivity f60877i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DSBottomSheet f60878j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeScreenActivity$createFooter$1$1$1(ItemReplacementBottomSheetTracker itemReplacementBottomSheetTracker, ShowItemReplacementBottomSheetUseCase.ItemReplacementInfo itemReplacementInfo, HomeScreenActivity homeScreenActivity, DSBottomSheet dSBottomSheet) {
        super(0);
        this.f60875g = itemReplacementBottomSheetTracker;
        this.f60876h = itemReplacementInfo;
        this.f60877i = homeScreenActivity;
        this.f60878j = dSBottomSheet;
    }

    public final void invoke() {
        this.f60875g.trackClickChooseReplacementButton(this.f60876h.getChainId(), this.f60877i.getEventNavigationOrigin(), this.f60877i.getScreenName());
        this.f60878j.dismiss();
        Navigator.DefaultImpls.navigateTo$default(this.f60877i.getNavigator(), this.f60877i, new ItemReplacementScreen(new ItemReplacementScreen.ItemReplacementData(this.f60876h.getOrderId(), ItemReplacementScreen.EVENT_ORIGIN_BOTTOM_SHEET)), (Function1) null, 4, (Object) null);
    }
}
