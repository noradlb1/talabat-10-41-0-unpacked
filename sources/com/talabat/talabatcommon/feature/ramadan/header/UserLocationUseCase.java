package com.talabat.talabatcommon.feature.ramadan.header;

import buisnessmodels.Customer;
import com.google.android.gms.maps.model.LatLng;
import com.talabat.domain.address.Address;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0010H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/feature/ramadan/header/UserLocationUseCase;", "", "customer", "Lbuisnessmodels/Customer;", "homeMapSavedLatLng", "Lcom/google/android/gms/maps/model/LatLng;", "(Lbuisnessmodels/Customer;Lcom/google/android/gms/maps/model/LatLng;)V", "getCustomer", "()Lbuisnessmodels/Customer;", "setCustomer", "(Lbuisnessmodels/Customer;)V", "getHomeMapSavedLatLng", "()Lcom/google/android/gms/maps/model/LatLng;", "setHomeMapSavedLatLng", "(Lcom/google/android/gms/maps/model/LatLng;)V", "invoke", "Lcom/talabat/talabatcommon/feature/ramadan/header/UserLocation;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserLocationUseCase {
    @NotNull
    private Customer customer;
    @Nullable
    private LatLng homeMapSavedLatLng;

    public UserLocationUseCase() {
        this((Customer) null, (LatLng) null, 3, (DefaultConstructorMarker) null);
    }

    public UserLocationUseCase(@NotNull Customer customer2, @Nullable LatLng latLng) {
        Intrinsics.checkNotNullParameter(customer2, "customer");
        this.customer = customer2;
        this.homeMapSavedLatLng = latLng;
    }

    @NotNull
    public final Customer getCustomer() {
        return this.customer;
    }

    @Nullable
    public final LatLng getHomeMapSavedLatLng() {
        return this.homeMapSavedLatLng;
    }

    @NotNull
    public final UserLocation invoke() {
        double d11;
        double d12;
        Customer customer2 = this.customer;
        if (customer2 == null || !customer2.isLoggedIn() || this.customer.getSelectedCustomerAddress() == null) {
            LatLng latLng = this.homeMapSavedLatLng;
            if (latLng != null) {
                Intrinsics.checkNotNull(latLng);
                d12 = latLng.latitude;
                LatLng latLng2 = this.homeMapSavedLatLng;
                Intrinsics.checkNotNull(latLng2);
                d11 = latLng2.longitude;
                return new UserLocation(d12, d11);
            }
        } else {
            Address selectedCustomerAddress = this.customer.getSelectedCustomerAddress();
            if (selectedCustomerAddress != null) {
                d12 = selectedCustomerAddress.latitude;
                d11 = selectedCustomerAddress.longitude;
                return new UserLocation(d12, d11);
            }
        }
        d12 = 0.0d;
        d11 = 0.0d;
        return new UserLocation(d12, d11);
    }

    public final void setCustomer(@NotNull Customer customer2) {
        Intrinsics.checkNotNullParameter(customer2, "<set-?>");
        this.customer = customer2;
    }

    public final void setHomeMapSavedLatLng(@Nullable LatLng latLng) {
        this.homeMapSavedLatLng = latLng;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ UserLocationUseCase(buisnessmodels.Customer r1, com.google.android.gms.maps.model.LatLng r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L_0x000d
            buisnessmodels.Customer r1 = buisnessmodels.Customer.getInstance()
            java.lang.String r4 = "getInstance()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
        L_0x000d:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0017
            library.talabat.mvp.homemap.HomeMapTemp r2 = library.talabat.mvp.homemap.HomeMapTemp.INSTANCE
            com.google.android.gms.maps.model.LatLng r2 = r2.getHomeMapSavedLatLng()
        L_0x0017:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatcommon.feature.ramadan.header.UserLocationUseCase.<init>(buisnessmodels.Customer, com.google.android.gms.maps.model.LatLng, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
