package com.talabat.fluid.homescreen.domain.usecase.business.impl;

import buisnessmodels.Customer;
import com.facebook.internal.NativeProtocol;
import com.talabat.fluid.homescreen.domain.tracking.HomeScreenTracker;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackHeroComponentClickedUseCase;
import datamodels.CustomerInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ.\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0011H\u0002J\u001c\u0010\u0012\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0011H\u0016J\u001c\u0010\u0013\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0011H\u0016J.\u0010\u0014\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0011H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/TrackHeroComponentClickedUseCaseImpl;", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroComponentClickedUseCase;", "homeScreenTracker", "Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;", "customerProvider", "Lkotlin/Function0;", "Lbuisnessmodels/Customer;", "locationDataFactory", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "(Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;Lkotlin/jvm/functions/Function0;Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;)V", "trackHeroBannerCick", "", "userId", "", "locationData", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory$LocationData;", "params", "", "trackHeroComponentClicked", "trackLoginComponentClicked", "trackShopClicked", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackHeroComponentClickedUseCaseImpl implements TrackHeroComponentClickedUseCase {
    @NotNull
    private final Function0<Customer> customerProvider;
    @NotNull
    private final HomeScreenTracker homeScreenTracker;
    @NotNull
    private final LocationDataFactory locationDataFactory;

    public TrackHeroComponentClickedUseCaseImpl(@NotNull HomeScreenTracker homeScreenTracker2, @NotNull Function0<? extends Customer> function0, @NotNull LocationDataFactory locationDataFactory2) {
        Intrinsics.checkNotNullParameter(homeScreenTracker2, "homeScreenTracker");
        Intrinsics.checkNotNullParameter(function0, "customerProvider");
        Intrinsics.checkNotNullParameter(locationDataFactory2, "locationDataFactory");
        this.homeScreenTracker = homeScreenTracker2;
        this.customerProvider = function0;
        this.locationDataFactory = locationDataFactory2;
    }

    private final void trackHeroBannerCick(String str, LocationDataFactory.LocationData locationData, Map<String, String> map) {
        this.homeScreenTracker.trackHeroBannerClick(str, locationData, map);
    }

    private final void trackShopClicked(String str, LocationDataFactory.LocationData locationData, Map<String, String> map) {
        HomeScreenTracker homeScreenTracker2 = this.homeScreenTracker;
        Map mutableMap = MapsKt__MapsKt.toMutableMap(map);
        mutableMap.put("shopClickOrigin", "home");
        mutableMap.put("eventOrigin", "hero_banner");
        Unit unit = Unit.INSTANCE;
        homeScreenTracker2.trackShopClicked(str, locationData, mutableMap);
    }

    public void trackHeroComponentClicked(@NotNull Map<String, String> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        Customer invoke = this.customerProvider.invoke();
        CustomerInfo customerInfo = invoke.getCustomerInfo();
        if (customerInfo != null) {
            str = customerInfo.encgid;
        } else {
            str = null;
        }
        LocationDataFactory.LocationData createLocationData = this.locationDataFactory.createLocationData(invoke.getSelectedCustomerAddress());
        trackHeroBannerCick(str, createLocationData, map);
        trackShopClicked(str, createLocationData, map);
    }

    public void trackLoginComponentClicked(@NotNull Map<String, String> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        Customer invoke = this.customerProvider.invoke();
        CustomerInfo customerInfo = invoke.getCustomerInfo();
        if (customerInfo != null) {
            str = customerInfo.encgid;
        } else {
            str = null;
        }
        LocationDataFactory.LocationData createLocationData = this.locationDataFactory.createLocationData(invoke.getSelectedCustomerAddress());
        HomeScreenTracker homeScreenTracker2 = this.homeScreenTracker;
        Map mutableMap = MapsKt__MapsKt.toMutableMap(map);
        mutableMap.put("shopType", "N/A");
        Unit unit = Unit.INSTANCE;
        homeScreenTracker2.trackHeroBannerClick(str, createLocationData, mutableMap);
    }
}
