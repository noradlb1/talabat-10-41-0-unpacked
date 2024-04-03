package com.talabat.fluid.homescreen.domain.usecase.business.impl;

import buisnessmodels.Customer;
import com.facebook.internal.NativeProtocol;
import com.talabat.domain.address.Address;
import com.talabat.fluid.homescreen.domain.tracking.HomeScreenTracker;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackSecondaryBannerUseCases;
import com.talabat.homescreen.utils.HomeBannersTrackImpressionValidator;
import datamodels.CustomerInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u001c\u0010\u0012\u001a\u00020\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u001c\u0010\u0013\u001a\u00020\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/TrackSecondaryBannerUseCasesImpl;", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackSecondaryBannerUseCases;", "homeScreenTracker", "Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;", "customerProvider", "Lkotlin/Function0;", "Lbuisnessmodels/Customer;", "locationDataFactory", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "impressionValidator", "Lcom/talabat/homescreen/utils/HomeBannersTrackImpressionValidator;", "(Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;Lkotlin/jvm/functions/Function0;Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;Lcom/talabat/homescreen/utils/HomeBannersTrackImpressionValidator;)V", "resetTracking", "", "trackSecondaryBannerClicked", "params", "", "", "trackSecondaryBannerLoaded", "trackSecondaryBannerShown", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackSecondaryBannerUseCasesImpl implements TrackSecondaryBannerUseCases {
    @NotNull
    private final Function0<Customer> customerProvider;
    @NotNull
    private final HomeScreenTracker homeScreenTracker;
    @NotNull
    private final HomeBannersTrackImpressionValidator impressionValidator;
    @NotNull
    private final LocationDataFactory locationDataFactory;

    public TrackSecondaryBannerUseCasesImpl(@NotNull HomeScreenTracker homeScreenTracker2, @NotNull Function0<? extends Customer> function0, @NotNull LocationDataFactory locationDataFactory2, @NotNull HomeBannersTrackImpressionValidator homeBannersTrackImpressionValidator) {
        Intrinsics.checkNotNullParameter(homeScreenTracker2, "homeScreenTracker");
        Intrinsics.checkNotNullParameter(function0, "customerProvider");
        Intrinsics.checkNotNullParameter(locationDataFactory2, "locationDataFactory");
        Intrinsics.checkNotNullParameter(homeBannersTrackImpressionValidator, "impressionValidator");
        this.homeScreenTracker = homeScreenTracker2;
        this.customerProvider = function0;
        this.locationDataFactory = locationDataFactory2;
        this.impressionValidator = homeBannersTrackImpressionValidator;
    }

    public void resetTracking() {
        this.impressionValidator.reset();
    }

    public void trackSecondaryBannerClicked(@NotNull Map<String, String> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        Customer invoke = this.customerProvider.invoke();
        Address selectedCustomerAddress = invoke.getSelectedCustomerAddress();
        HomeScreenTracker homeScreenTracker2 = this.homeScreenTracker;
        CustomerInfo customerInfo = invoke.getCustomerInfo();
        if (customerInfo != null) {
            str = customerInfo.encgid;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        homeScreenTracker2.trackSecondaryBannerClicked(str, this.locationDataFactory.createLocationData(selectedCustomerAddress), map);
    }

    public void trackSecondaryBannerLoaded(@NotNull Map<String, String> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        Customer invoke = this.customerProvider.invoke();
        Address selectedCustomerAddress = invoke.getSelectedCustomerAddress();
        HomeScreenTracker homeScreenTracker2 = this.homeScreenTracker;
        CustomerInfo customerInfo = invoke.getCustomerInfo();
        if (customerInfo != null) {
            str = customerInfo.encgid;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        homeScreenTracker2.trackSecondaryBannerLoaded(str, this.locationDataFactory.createLocationData(selectedCustomerAddress), map);
    }

    public void trackSecondaryBannerShown(@NotNull Map<String, String> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        String str2 = map.get("bannerId");
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        }
        if (this.impressionValidator.canTrackImpressionFor(str2)) {
            Customer invoke = this.customerProvider.invoke();
            Address selectedCustomerAddress = invoke.getSelectedCustomerAddress();
            HomeScreenTracker homeScreenTracker2 = this.homeScreenTracker;
            CustomerInfo customerInfo = invoke.getCustomerInfo();
            if (customerInfo != null) {
                str = customerInfo.encgid;
            } else {
                str = null;
            }
            if (str != null) {
                str3 = str;
            }
            homeScreenTracker2.trackSecondaryBannerShown(str3, this.locationDataFactory.createLocationData(selectedCustomerAddress), map);
            this.impressionValidator.didTrackImpressionFor(str2);
        }
    }
}
