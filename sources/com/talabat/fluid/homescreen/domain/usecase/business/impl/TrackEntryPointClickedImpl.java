package com.talabat.fluid.homescreen.domain.usecase.business.impl;

import buisnessmodels.Customer;
import com.facebook.internal.NativeProtocol;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluid.homescreen.data.remote.component.FluidHomeComponentRequestParams;
import com.talabat.fluid.homescreen.data.remote.mapper.FluidHomeComponentRequestParamsProvider;
import com.talabat.fluid.homescreen.domain.tracking.HomeScreenTracker;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackEntryPointClicked;
import datamodels.CustomerInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u001c\u0010\u0013\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u000e\u0010\u0014\u001a\u00020\u0015*\u0004\u0018\u00010\u0012H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/TrackEntryPointClickedImpl;", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackEntryPointClicked;", "homeScreenTracker", "Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;", "customerProvider", "Lkotlin/Function0;", "Lbuisnessmodels/Customer;", "locationDataFactory", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "requestParamsProvider", "Lcom/talabat/fluid/homescreen/data/remote/mapper/FluidHomeComponentRequestParamsProvider;", "(Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;Lkotlin/jvm/functions/Function0;Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;Lcom/talabat/fluid/homescreen/data/remote/mapper/FluidHomeComponentRequestParamsProvider;)V", "observeNullOrEmptyValues", "", "params", "", "", "trackEntryPointClicked", "containsNullOrBlank", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackEntryPointClickedImpl implements TrackEntryPointClicked {
    @NotNull
    private final Function0<Customer> customerProvider;
    @NotNull
    private final HomeScreenTracker homeScreenTracker;
    @NotNull
    private final LocationDataFactory locationDataFactory;
    @NotNull
    private final IObservabilityManager observabilityManager;
    @NotNull
    private final FluidHomeComponentRequestParamsProvider requestParamsProvider;

    public TrackEntryPointClickedImpl(@NotNull HomeScreenTracker homeScreenTracker2, @NotNull Function0<? extends Customer> function0, @NotNull LocationDataFactory locationDataFactory2, @NotNull IObservabilityManager iObservabilityManager, @NotNull FluidHomeComponentRequestParamsProvider fluidHomeComponentRequestParamsProvider) {
        Intrinsics.checkNotNullParameter(homeScreenTracker2, "homeScreenTracker");
        Intrinsics.checkNotNullParameter(function0, "customerProvider");
        Intrinsics.checkNotNullParameter(locationDataFactory2, "locationDataFactory");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        Intrinsics.checkNotNullParameter(fluidHomeComponentRequestParamsProvider, "requestParamsProvider");
        this.homeScreenTracker = homeScreenTracker2;
        this.customerProvider = function0;
        this.locationDataFactory = locationDataFactory2;
        this.observabilityManager = iObservabilityManager;
        this.requestParamsProvider = fluidHomeComponentRequestParamsProvider;
    }

    private final boolean containsNullOrBlank(String str) {
        return (str == null || StringsKt__StringsJVMKt.isBlank(str)) || StringsKt__StringsJVMKt.equals(str, "null", true);
    }

    private final void observeNullOrEmptyValues(Map<String, String> map) {
        String str = map.get("shopName");
        String str2 = map.get("position");
        if (containsNullOrBlank(str) || containsNullOrBlank(str2)) {
            FluidHomeComponentRequestParams fluidHomeComponentRequestParams = this.requestParamsProvider.getFluidHomeComponentRequestParams();
            this.observabilityManager.trackUnExpectedScenario("HomeScreenEntryPointClickedEventNullParams", MapsKt__MapsKt.mapOf(TuplesKt.to("shopName", String.valueOf(str)), TuplesKt.to("shopPosition", String.valueOf(str2)), TuplesKt.to("externalExperiments", CollectionsKt___CollectionsKt.joinToString$default(fluidHomeComponentRequestParams.getExternalExperiments(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)), TuplesKt.to("deviceWidthInDP", fluidHomeComponentRequestParams.getDeviceWidthInDP()), TuplesKt.to("countryCode", fluidHomeComponentRequestParams.getCountryCode()), TuplesKt.to("latitude", fluidHomeComponentRequestParams.getLatitude()), TuplesKt.to("longitude", fluidHomeComponentRequestParams.getLongitude()), TuplesKt.to("areaId", fluidHomeComponentRequestParams.getAreaId()), TuplesKt.to("selectedLanguage", fluidHomeComponentRequestParams.getSelectedLanguage().getLanguageCode())));
        }
    }

    public void trackEntryPointClicked(@NotNull Map<String, String> map) {
        String str;
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        Customer invoke = this.customerProvider.invoke();
        CustomerInfo customerInfo = invoke.getCustomerInfo();
        if (customerInfo != null) {
            str = customerInfo.encgid;
        } else {
            str = null;
        }
        this.homeScreenTracker.trackEntryPointClicked(str, this.locationDataFactory.createLocationData(invoke.getSelectedCustomerAddress()), map);
        observeNullOrEmptyValues(map);
    }
}
