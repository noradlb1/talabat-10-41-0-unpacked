package com.talabat.fluid.homescreen.domain.usecase.business.impl;

import buisnessmodels.Customer;
import com.facebook.internal.NativeProtocol;
import com.talabat.core.observabilityNew.domain.IObservabilityManager;
import com.talabat.fluid.homescreen.domain.tracking.HomeScreenTracker;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.fluid.homescreen.domain.usecase.business.TrackBannerSlideUseCase;
import com.talabat.homescreen.utils.HomeBannersTrackImpressionValidator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/fluid/homescreen/domain/usecase/business/impl/TrackBannerSlideUseCaseImpl;", "Lcom/talabat/fluid/homescreen/domain/usecase/business/TrackBannerSlideUseCase;", "homeScreenTracker", "Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;", "customerProvider", "Lkotlin/Function0;", "Lbuisnessmodels/Customer;", "locationDataFactory", "Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;", "impressionValidator", "Lcom/talabat/homescreen/utils/HomeBannersTrackImpressionValidator;", "observabilityManager", "Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;", "(Lcom/talabat/fluid/homescreen/domain/tracking/HomeScreenTracker;Lkotlin/jvm/functions/Function0;Lcom/talabat/fluid/homescreen/domain/tracking/LocationDataFactory;Lcom/talabat/homescreen/utils/HomeBannersTrackImpressionValidator;Lcom/talabat/core/observabilityNew/domain/IObservabilityManager;)V", "resetTracking", "", "trackBannerSlide", "bannerId", "", "params", "", "", "com_talabat_NewArchi_Homescreen_Homescreen"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TrackBannerSlideUseCaseImpl implements TrackBannerSlideUseCase {
    @NotNull
    private final Function0<Customer> customerProvider;
    @NotNull
    private final HomeScreenTracker homeScreenTracker;
    @NotNull
    private final HomeBannersTrackImpressionValidator impressionValidator;
    @NotNull
    private final LocationDataFactory locationDataFactory;
    @NotNull
    private final IObservabilityManager observabilityManager;

    public TrackBannerSlideUseCaseImpl(@NotNull HomeScreenTracker homeScreenTracker2, @NotNull Function0<? extends Customer> function0, @NotNull LocationDataFactory locationDataFactory2, @NotNull HomeBannersTrackImpressionValidator homeBannersTrackImpressionValidator, @NotNull IObservabilityManager iObservabilityManager) {
        Intrinsics.checkNotNullParameter(homeScreenTracker2, "homeScreenTracker");
        Intrinsics.checkNotNullParameter(function0, "customerProvider");
        Intrinsics.checkNotNullParameter(locationDataFactory2, "locationDataFactory");
        Intrinsics.checkNotNullParameter(homeBannersTrackImpressionValidator, "impressionValidator");
        Intrinsics.checkNotNullParameter(iObservabilityManager, "observabilityManager");
        this.homeScreenTracker = homeScreenTracker2;
        this.customerProvider = function0;
        this.locationDataFactory = locationDataFactory2;
        this.impressionValidator = homeBannersTrackImpressionValidator;
        this.observabilityManager = iObservabilityManager;
    }

    public void resetTracking() {
        this.impressionValidator.reset();
    }

    public void trackBannerSlide(int i11, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        if (this.impressionValidator.canTrackImpressionFor(String.valueOf(i11))) {
            this.homeScreenTracker.trackBannerLoad(this.locationDataFactory.createLocationData(this.customerProvider.invoke().getSelectedCustomerAddress()), map, this.observabilityManager);
            this.impressionValidator.didTrackImpressionFor(String.valueOf(i11));
        }
    }
}
