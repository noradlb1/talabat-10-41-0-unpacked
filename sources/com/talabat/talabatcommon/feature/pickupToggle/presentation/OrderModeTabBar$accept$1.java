package com.talabat.talabatcommon.feature.pickupToggle.presentation;

import android.content.Context;
import android.os.Bundle;
import com.talabat.core.deeplink.domain.DeepLinkNavigator;
import com.talabat.core.fwfprojectskeys.domain.projects.vendorlist.VendorListFeatureFlagsKeys;
import com.talabat.core.navigation.domain.screen.restaurant.FoodListFlutterScreen;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.talabatcommon.feature.pickupToggle.events.OrderModeClickEvent;
import com.talabat.talabatcommon.views.tabBarWithTag.TabItemModel;
import com.talabat.talabatnavigation.Navigator;
import com.talabat.talabatnavigation.base.NavigatorModel;
import com.talabat.talabatnavigation.pickup.PickupNavigatorActions;
import com.talabat.talabatnavigation.sdsquad.SdSquadActions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/talabatcommon/views/tabBarWithTag/TabItemModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OrderModeTabBar$accept$1 extends Lambda implements Function1<TabItemModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OrderModeTabBar f61557g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Context f61558h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderModeTabBar$accept$1(OrderModeTabBar orderModeTabBar, Context context) {
        super(1);
        this.f61557g = orderModeTabBar;
        this.f61558h = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((TabItemModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull TabItemModel tabItemModel) {
        Intrinsics.checkNotNullParameter(tabItemModel, "it");
        this.f61557g.tracker.track(new OrderModeClickEvent(this.f61557g.pickupClicked(tabItemModel.getId())));
        SharedPreferencesManager.getInstance().saveFavVerical(GlobalConstants.VerticalTypes.RESTAURANT, 0);
        if (tabItemModel.getId() != 0) {
            Navigator.Companion.navigate(this.f61558h, new NavigatorModel(tabItemModel.getId() == 1 ? PickupNavigatorActions.ACTION_NEW_PICKUP_MODULE : SdSquadActions.ACTION_SDSQUAD_LISTING_SCREEN, (Bundle) null, AnonymousClass2.INSTANCE, 2, (DefaultConstructorMarker) null));
        } else if (this.f61557g.featureFlag.getFeatureFlag(VendorListFeatureFlagsKeys.VENDORLIST_DEEP_LINK_NAVIGATION_HOF, false)) {
            DeepLinkNavigator.DefaultImpls.navigateTo$default(this.f61557g.deeplinkNavigator, this.f61558h, "talabat://?s=/food-list-organic", (Function0) null, 4, (Object) null);
        } else {
            com.talabat.core.navigation.domain.Navigator access$getNavigator$p = this.f61557g.navigator;
            Context context = this.f61558h;
            Double latitudeDouble = GlobalDataModel.LATLONGFORAPI.getLatitudeDouble();
            Intrinsics.checkNotNullExpressionValue(latitudeDouble, "getLatitudeDouble()");
            double doubleValue = latitudeDouble.doubleValue();
            Double longitudeDouble = GlobalDataModel.LATLONGFORAPI.getLongitudeDouble();
            Intrinsics.checkNotNullExpressionValue(longitudeDouble, "getLongitudeDouble()");
            double doubleValue2 = longitudeDouble.doubleValue();
            String valueOf = String.valueOf(GlobalDataModel.SelectedAreaId);
            String valueOf2 = String.valueOf(GlobalDataModel.SelectedCityId);
            int access$getCountryId$p = this.f61557g.countryId;
            String str = GlobalDataModel.SelectedAreaName;
            Intrinsics.checkNotNullExpressionValue(str, "SelectedAreaName");
            access$getNavigator$p.navigateTo(context, new FoodListFlutterScreen(new FoodListFlutterScreen.FoodListFlutterData(doubleValue, doubleValue2, valueOf, valueOf2, access$getCountryId$p, str)), AnonymousClass1.INSTANCE);
        }
    }
}
