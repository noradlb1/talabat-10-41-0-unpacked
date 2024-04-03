package com.talabat.fluid.homescreen.domain.usecase.business.impl;

import buisnessmodels.Customer;
import com.facebook.internal.NativeProtocol;
import com.talabat.fluid.homescreen.domain.tracking.HomeScreenTracker;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackShopClickedUseCase;
import datamodels.CustomerInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ.\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0011H\u0002J\u001c\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0011H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/TrackShopClickedUseCaseImpl;", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackShopClickedUseCase;", "homeScreenTracker", "Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;", "customerProvider", "Lkotlin/Function0;", "Lbuisnessmodels/Customer;", "locationDataFactory", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "(Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;Lkotlin/jvm/functions/Function0;Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;)V", "trackShopClicked", "", "userId", "", "locationData", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory$LocationData;", "params", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackShopClickedUseCaseImpl implements TrackShopClickedUseCase {
    @NotNull
    private final Function0<Customer> customerProvider;
    @NotNull
    private final HomeScreenTracker homeScreenTracker;
    @NotNull
    private final LocationDataFactory locationDataFactory;

    public TrackShopClickedUseCaseImpl(@NotNull HomeScreenTracker homeScreenTracker2, @NotNull Function0<? extends Customer> function0, @NotNull LocationDataFactory locationDataFactory2) {
        Intrinsics.checkNotNullParameter(homeScreenTracker2, "homeScreenTracker");
        Intrinsics.checkNotNullParameter(function0, "customerProvider");
        Intrinsics.checkNotNullParameter(locationDataFactory2, "locationDataFactory");
        this.homeScreenTracker = homeScreenTracker2;
        this.customerProvider = function0;
        this.locationDataFactory = locationDataFactory2;
    }

    public void trackShopClicked(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        Customer invoke = this.customerProvider.invoke();
        CustomerInfo customerInfo = invoke.getCustomerInfo();
        trackShopClicked(customerInfo != null ? customerInfo.encgid : null, this.locationDataFactory.createLocationData(invoke.getSelectedCustomerAddress()), map);
    }

    private final void trackShopClicked(String str, LocationDataFactory.LocationData locationData, Map<String, String> map) {
        HomeScreenTracker homeScreenTracker2 = this.homeScreenTracker;
        Map mutableMap = MapsKt__MapsKt.toMutableMap(map);
        mutableMap.put("shopClickOrigin", "home");
        mutableMap.put("eventOrigin", "vertical_launcher");
        Unit unit = Unit.INSTANCE;
        homeScreenTracker2.trackShopClicked(str, locationData, mutableMap);
    }
}
