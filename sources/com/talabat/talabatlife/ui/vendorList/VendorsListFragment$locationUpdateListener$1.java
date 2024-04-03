package com.talabat.talabatlife.ui.vendorList;

import android.location.Location;
import android.location.LocationListener;
import com.talabat.talabatcommon.extentions.DoubleKt;
import com.talabat.talabatcommon.helpers.LocationHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/talabat/talabatlife/ui/vendorList/VendorsListFragment$locationUpdateListener$1", "Landroid/location/LocationListener;", "onLocationChanged", "", "location", "Landroid/location/Location;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorsListFragment$locationUpdateListener$1 implements LocationListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f12090b;

    public VendorsListFragment$locationUpdateListener$1(VendorsListFragment vendorsListFragment) {
        this.f12090b = vendorsListFragment;
    }

    public void onLocationChanged(@NotNull Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        VendorsListFragment.access$getViewModel(this.f12090b).setUserLatitude(DoubleKt.orZero(Double.valueOf(location.getLatitude())));
        VendorsListFragment.access$getViewModel(this.f12090b).setUserLongitude(DoubleKt.orZero(Double.valueOf(location.getLongitude())));
        this.f12090b.setCurrentLocationText();
        VendorsListFragment.k(this.f12090b, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, 255, (Object) null);
        LocationHelper access$getLocationHelper$p = this.f12090b.locationHelper;
        if (access$getLocationHelper$p != null) {
            access$getLocationHelper$p.stopLocationListening();
        }
    }
}
