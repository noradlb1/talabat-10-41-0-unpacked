package com.talabat.homescreen.orderstatus.domain.usecase.business.impl;

import buisnessmodels.Customer;
import com.talabat.domain.address.Address;
import com.talabat.fluid.homescreen.domain.tracking.HomeScreenTracker;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.homescreen.orderstatus.domain.usecase.business.TrackOrderStatusLoadUseCase;
import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/homescreen/orderstatus/domain/usecase/business/impl/TrackOrderStatusLoadUseCaseImpl;", "Lcom/talabat/homescreen/orderstatus/domain/usecase/business/TrackOrderStatusLoadUseCase;", "homeScreenTracker", "Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;", "customerProvider", "Lkotlin/Function0;", "Lbuisnessmodels/Customer;", "locationDataFactory", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "(Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;Lkotlin/jvm/functions/Function0;Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;)V", "trackOrderStatusLoad", "", "transactionId", "", "chainId", "chainName", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackOrderStatusLoadUseCaseImpl implements TrackOrderStatusLoadUseCase {
    @NotNull
    private final Function0<Customer> customerProvider;
    @NotNull
    private final HomeScreenTracker homeScreenTracker;
    @NotNull
    private final LocationDataFactory locationDataFactory;

    public TrackOrderStatusLoadUseCaseImpl(@NotNull HomeScreenTracker homeScreenTracker2, @NotNull Function0<? extends Customer> function0, @NotNull LocationDataFactory locationDataFactory2) {
        Intrinsics.checkNotNullParameter(homeScreenTracker2, "homeScreenTracker");
        Intrinsics.checkNotNullParameter(function0, "customerProvider");
        Intrinsics.checkNotNullParameter(locationDataFactory2, "locationDataFactory");
        this.homeScreenTracker = homeScreenTracker2;
        this.customerProvider = function0;
        this.locationDataFactory = locationDataFactory2;
    }

    public void trackOrderStatusLoad(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        String str4;
        Intrinsics.checkNotNullParameter(str, "transactionId");
        Intrinsics.checkNotNullParameter(str2, "chainId");
        Intrinsics.checkNotNullParameter(str3, "chainName");
        Customer invoke = this.customerProvider.invoke();
        Address selectedCustomerAddress = invoke.getSelectedCustomerAddress();
        HomeScreenTracker homeScreenTracker2 = this.homeScreenTracker;
        CustomerInfo customerInfo = invoke.getCustomerInfo();
        if (customerInfo != null) {
            str4 = customerInfo.encgid;
        } else {
            str4 = null;
        }
        homeScreenTracker2.trackOrderStatusWidgetShown(str4, this.locationDataFactory.createLocationData(selectedCustomerAddress), TuplesKt.to(str2, str3), str);
    }
}
