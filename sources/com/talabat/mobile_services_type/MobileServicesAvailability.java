package com.talabat.mobile_services_type;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/mobile_services_type/MobileServicesAvailability;", "", "apiAvailabilityProvider", "Lcom/talabat/mobile_services_type/ApiAvailabilityProvider;", "(Lcom/talabat/mobile_services_type/ApiAvailabilityProvider;)V", "isGooglePlayServicesAvailable", "", "applicationContext", "Landroid/content/Context;", "isHuaweiMobileServicesAvailable", "mobile_services_type_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MobileServicesAvailability {
    @NotNull
    private final ApiAvailabilityProvider apiAvailabilityProvider;

    public MobileServicesAvailability(@NotNull ApiAvailabilityProvider apiAvailabilityProvider2) {
        Intrinsics.checkNotNullParameter(apiAvailabilityProvider2, "apiAvailabilityProvider");
        this.apiAvailabilityProvider = apiAvailabilityProvider2;
    }

    public final boolean isGooglePlayServicesAvailable(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        if (this.apiAvailabilityProvider.getGoogleApiAvailability().isGooglePlayServicesAvailable(context) == 0) {
            return true;
        }
        return false;
    }

    public final boolean isHuaweiMobileServicesAvailable(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        if (this.apiAvailabilityProvider.getHuaweiApiAvailability().isHuaweiMobileServicesAvailable(context) == 0) {
            return true;
        }
        return false;
    }
}
