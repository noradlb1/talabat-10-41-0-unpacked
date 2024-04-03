package com.talabat.fluid.homescreen.domain.usecase.business.impl;

import buisnessmodels.Customer;
import com.facebook.internal.NativeProtocol;
import com.talabat.domain.address.Address;
import com.talabat.fluid.homescreen.domain.tracking.HomeScreenTracker;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackHeroComponentLoadUseCase;
import datamodels.CustomerInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u0010H\u0016J \u0010\u0011\u001a\u00020\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rj\u0002`\u0010H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/TrackHeroComponentLoadUseCaseImpl;", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackHeroComponentLoadUseCase;", "homeScreenTracker", "Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;", "customerProvider", "Lkotlin/Function0;", "Lbuisnessmodels/Customer;", "locationDataFactory", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "(Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;Lkotlin/jvm/functions/Function0;Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;)V", "trackHeroComponentLoad", "", "params", "", "", "", "Lcom/deliveryhero/fluid/template/data/TemplateMetadata;", "trackLoginComponentLoad", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackHeroComponentLoadUseCaseImpl implements TrackHeroComponentLoadUseCase {
    @NotNull
    private final Function0<Customer> customerProvider;
    @NotNull
    private final HomeScreenTracker homeScreenTracker;
    @NotNull
    private final LocationDataFactory locationDataFactory;

    public TrackHeroComponentLoadUseCaseImpl(@NotNull HomeScreenTracker homeScreenTracker2, @NotNull Function0<? extends Customer> function0, @NotNull LocationDataFactory locationDataFactory2) {
        Intrinsics.checkNotNullParameter(homeScreenTracker2, "homeScreenTracker");
        Intrinsics.checkNotNullParameter(function0, "customerProvider");
        Intrinsics.checkNotNullParameter(locationDataFactory2, "locationDataFactory");
        this.homeScreenTracker = homeScreenTracker2;
        this.customerProvider = function0;
        this.locationDataFactory = locationDataFactory2;
    }

    public void trackHeroComponentLoad(@NotNull Map<String, ? extends Object> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        Customer invoke = this.customerProvider.invoke();
        CustomerInfo customerInfo = invoke.getCustomerInfo();
        if (customerInfo != null) {
            str = customerInfo.encgid;
        } else {
            str = null;
        }
        Address selectedCustomerAddress = invoke.getSelectedCustomerAddress();
        HomeScreenTracker homeScreenTracker2 = this.homeScreenTracker;
        LocationDataFactory.LocationData createLocationData = this.locationDataFactory.createLocationData(selectedCustomerAddress);
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        homeScreenTracker2.trackHeroBannerLoad(str, createLocationData, linkedHashMap);
    }

    public void trackLoginComponentLoad(@NotNull Map<String, ? extends Object> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        Customer invoke = this.customerProvider.invoke();
        CustomerInfo customerInfo = invoke.getCustomerInfo();
        if (customerInfo != null) {
            str = customerInfo.encgid;
        } else {
            str = null;
        }
        Address selectedCustomerAddress = invoke.getSelectedCustomerAddress();
        HomeScreenTracker homeScreenTracker2 = this.homeScreenTracker;
        LocationDataFactory.LocationData createLocationData = this.locationDataFactory.createLocationData(selectedCustomerAddress);
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        Map mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        mutableMap.put("shopType", "N/A");
        Unit unit = Unit.INSTANCE;
        homeScreenTracker2.trackHeroBannerLoad(str, createLocationData, mutableMap);
    }
}
