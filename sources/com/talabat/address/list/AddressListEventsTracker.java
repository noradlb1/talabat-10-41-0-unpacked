package com.talabat.address.list;

import com.talabat.configuration.ConfigurationLocalRepository;
import com.talabat.core.tracking.domain.TalabatTracker;
import com.talabat.domain.location.GeoCoordinate;
import com.talabat.fluid.homescreen.domain.tracking.LocationDataFactory;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/address/list/AddressListEventsTracker;", "Lcom/talabat/address/list/AddressListEventsListener;", "talabatTracker", "Lcom/talabat/core/tracking/domain/TalabatTracker;", "configurationLocalRepository", "Lcom/talabat/configuration/ConfigurationLocalRepository;", "geoCoordinate", "Lkotlin/Function0;", "Lcom/talabat/domain/location/GeoCoordinate;", "(Lcom/talabat/core/tracking/domain/TalabatTracker;Lcom/talabat/configuration/ConfigurationLocalRepository;Lkotlin/jvm/functions/Function0;)V", "onAddAddressButtonClicked", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressListEventsTracker implements AddressListEventsListener {
    @NotNull
    private final ConfigurationLocalRepository configurationLocalRepository;
    @NotNull
    private final Function0<GeoCoordinate> geoCoordinate;
    @NotNull
    private final TalabatTracker talabatTracker;

    public AddressListEventsTracker(@NotNull TalabatTracker talabatTracker2, @NotNull ConfigurationLocalRepository configurationLocalRepository2, @NotNull Function0<GeoCoordinate> function0) {
        Intrinsics.checkNotNullParameter(talabatTracker2, "talabatTracker");
        Intrinsics.checkNotNullParameter(configurationLocalRepository2, "configurationLocalRepository");
        Intrinsics.checkNotNullParameter(function0, "geoCoordinate");
        this.talabatTracker = talabatTracker2;
        this.configurationLocalRepository = configurationLocalRepository2;
        this.geoCoordinate = function0;
    }

    public void onAddAddressButtonClicked() {
        try {
            this.talabatTracker.track(new AddAddressClickedEvent(this.configurationLocalRepository.selectedCountry(), this.geoCoordinate.invoke(), (LocationDataFactory) null, (Function0) null, 12, (DefaultConstructorMarker) null));
        } catch (Throwable th2) {
            LogManager.logException(th2);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AddressListEventsTracker(TalabatTracker talabatTracker2, ConfigurationLocalRepository configurationLocalRepository2, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(talabatTracker2, configurationLocalRepository2, (i11 & 4) != 0 ? AnonymousClass1.INSTANCE : function0);
    }
}
