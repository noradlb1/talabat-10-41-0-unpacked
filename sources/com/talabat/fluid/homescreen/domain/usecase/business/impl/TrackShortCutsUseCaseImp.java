package com.talabat.fluid.homescreen.domain.usecase.business.impl;

import buisnessmodels.Customer;
import com.facebook.internal.NativeProtocol;
import com.talabat.domain.address.Address;
import com.talabat.fluid.homescreen.domain.tracking.HomeScreenTracker;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackShortCutsUseCase;
import datamodels.CustomerInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010\u0019\u001a\u00020\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001d0\u001cj\u0002`\u001eH\u0016J \u0010\u001f\u001a\u00020\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001d0\u001cj\u0002`\u001eH\u0016J \u0010 \u001a\u00020\u001a2\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001d0\u001cj\u0002`\u001eH\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/TrackShortCutsUseCaseImp;", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackShortCutsUseCase;", "homeScreenTracker", "Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;", "customerProvider", "Lkotlin/Function0;", "Lbuisnessmodels/Customer;", "locationDataFactory", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "(Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;Lkotlin/jvm/functions/Function0;Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;)V", "address", "Lcom/talabat/domain/address/Address;", "getAddress", "()Lcom/talabat/domain/address/Address;", "customer", "getCustomer", "()Lbuisnessmodels/Customer;", "locationData", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory$LocationData;", "getLocationData", "()Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory$LocationData;", "userId", "", "getUserId", "()Ljava/lang/String;", "trackShortCutsClicked", "", "params", "", "", "Lcom/deliveryhero/fluid/template/data/TemplateMetadata;", "trackShortCutsLoad", "trackShortCutsSwiped", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackShortCutsUseCaseImp implements TrackShortCutsUseCase {
    @NotNull
    private final Function0<Customer> customerProvider;
    @NotNull
    private final HomeScreenTracker homeScreenTracker;
    @NotNull
    private final LocationDataFactory locationDataFactory;

    public TrackShortCutsUseCaseImp(@NotNull HomeScreenTracker homeScreenTracker2, @NotNull Function0<? extends Customer> function0, @NotNull LocationDataFactory locationDataFactory2) {
        Intrinsics.checkNotNullParameter(homeScreenTracker2, "homeScreenTracker");
        Intrinsics.checkNotNullParameter(function0, "customerProvider");
        Intrinsics.checkNotNullParameter(locationDataFactory2, "locationDataFactory");
        this.homeScreenTracker = homeScreenTracker2;
        this.customerProvider = function0;
        this.locationDataFactory = locationDataFactory2;
    }

    private final Address getAddress() {
        return getCustomer().getSelectedCustomerAddress();
    }

    private final Customer getCustomer() {
        return this.customerProvider.invoke();
    }

    private final LocationDataFactory.LocationData getLocationData() {
        return this.locationDataFactory.createLocationData(getAddress());
    }

    private final String getUserId() {
        CustomerInfo customerInfo = getCustomer().getCustomerInfo();
        if (customerInfo != null) {
            return customerInfo.encgid;
        }
        return null;
    }

    public void trackShortCutsClicked(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        HomeScreenTracker homeScreenTracker2 = this.homeScreenTracker;
        String userId = getUserId();
        LocationDataFactory.LocationData locationData = getLocationData();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        homeScreenTracker2.onShorCutsClicked(userId, locationData, linkedHashMap);
    }

    public void trackShortCutsLoad(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        HomeScreenTracker homeScreenTracker2 = this.homeScreenTracker;
        String userId = getUserId();
        LocationDataFactory.LocationData locationData = getLocationData();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        homeScreenTracker2.onShortCutsLoaded(userId, locationData, linkedHashMap);
    }

    public void trackShortCutsSwiped(@NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        HomeScreenTracker homeScreenTracker2 = this.homeScreenTracker;
        String userId = getUserId();
        LocationDataFactory.LocationData locationData = getLocationData();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(map.size()));
        for (Map.Entry entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), entry.getValue().toString());
        }
        homeScreenTracker2.onShorCutsSwiped(userId, locationData, linkedHashMap);
    }
}
