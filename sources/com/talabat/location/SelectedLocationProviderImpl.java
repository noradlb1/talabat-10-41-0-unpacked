package com.talabat.location;

import buisnessmodels.ICustomer;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.domain.address.Address;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.location.UserLocation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.mvp.homemap.HomeMapTemp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/location/SelectedLocationProviderImpl;", "Lcom/talabat/location/SelectedLocationProvider;", "customer", "Lbuisnessmodels/ICustomer;", "(Lbuisnessmodels/ICustomer;)V", "getLocationFromCustomer", "Lcom/talabat/location/UserLocation;", "getLocationFromGlobalModel", "getSelectedUserLocation", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SelectedLocationProviderImpl implements SelectedLocationProvider {
    @NotNull
    private final ICustomer customer;

    public SelectedLocationProviderImpl(@NotNull ICustomer iCustomer) {
        Intrinsics.checkNotNullParameter(iCustomer, "customer");
        this.customer = iCustomer;
    }

    private final UserLocation getLocationFromCustomer() {
        Address selectedCustomerAddress;
        if (this.customer.isLoggedIn() && (selectedCustomerAddress = this.customer.getSelectedCustomerAddress()) != null) {
            return new UserLocation.WithAddress(selectedCustomerAddress);
        }
        return null;
    }

    private final UserLocation getLocationFromGlobalModel() {
        boolean z11;
        boolean z12;
        String str;
        LatLng homeMapSavedLatLng;
        boolean z13;
        boolean z14;
        Integer valueOf = Integer.valueOf(GlobalDataModel.SelectedAreaId);
        boolean z15 = false;
        if (valueOf.intValue() != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            valueOf = null;
        }
        if (valueOf != null) {
            int intValue = valueOf.intValue();
            String str2 = GlobalDataModel.SelectedAreaName;
            if (str2 != null) {
                if (str2.length() > 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    str = str2;
                } else {
                    str = null;
                }
                if (str == null || (homeMapSavedLatLng = HomeMapTemp.INSTANCE.getHomeMapSavedLatLng()) == null) {
                    return null;
                }
                Double valueOf2 = Double.valueOf(homeMapSavedLatLng.latitude);
                if (valueOf2.doubleValue() == 0.0d) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (!(!z13)) {
                    valueOf2 = null;
                }
                if (valueOf2 != null) {
                    double doubleValue = valueOf2.doubleValue();
                    Double valueOf3 = Double.valueOf(homeMapSavedLatLng.longitude);
                    if (valueOf3.doubleValue() == 0.0d) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (!(!z14)) {
                        valueOf3 = null;
                    }
                    if (valueOf3 != null) {
                        double doubleValue2 = valueOf3.doubleValue();
                        Integer valueOf4 = Integer.valueOf(GlobalDataModel.SelectedCityId);
                        if (valueOf4.intValue() != 0) {
                            z15 = true;
                        }
                        if (!z15) {
                            valueOf4 = null;
                        }
                        if (valueOf4 != null) {
                            return new UserLocation.WithoutAddress(intValue, str, doubleValue, doubleValue2, valueOf4.intValue());
                        }
                    }
                }
            }
        }
        return null;
    }

    @Nullable
    public UserLocation getSelectedUserLocation() {
        UserLocation locationFromCustomer = getLocationFromCustomer();
        return locationFromCustomer == null ? getLocationFromGlobalModel() : locationFromCustomer;
    }
}
