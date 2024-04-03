package com.huawei.hms.maps.internal;

import android.location.Location;
import android.os.RemoteException;
import com.huawei.hms.maps.LocationSource;
import com.huawei.hms.maps.internal.ILocationSourceDelegate;
import com.huawei.hms.maps.utils.LogM;

public class maa extends ILocationSourceDelegate.Stub {

    /* renamed from: a  reason: collision with root package name */
    private LocationSource f49396a;

    /* renamed from: com.huawei.hms.maps.internal.maa$maa  reason: collision with other inner class name */
    public static class C0070maa implements LocationSource.OnLocationChangedListener {

        /* renamed from: a  reason: collision with root package name */
        IOnLocationChangeListener f49397a;

        public C0070maa(IOnLocationChangeListener iOnLocationChangeListener) {
            this.f49397a = iOnLocationChangeListener;
        }

        public void onLocationChanged(Location location) {
            try {
                this.f49397a.onLocationChange(location);
            } catch (RemoteException unused) {
                LogM.e("LocationSourceDelegate", "onLocationChanged RemoteException ");
            }
        }
    }

    public maa(LocationSource locationSource) {
        this.f49396a = locationSource;
    }

    public void activate(IOnLocationChangeListener iOnLocationChangeListener) {
        LogM.d("LocationSourceDelegate", "active");
        this.f49396a.activate(new C0070maa(iOnLocationChangeListener));
    }

    public void deactivate() {
        LogM.d("LocationSourceDelegate", "deactivate");
        this.f49396a.deactivate();
    }
}
