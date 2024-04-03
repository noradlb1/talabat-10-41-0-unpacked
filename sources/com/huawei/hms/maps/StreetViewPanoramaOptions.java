package com.huawei.hms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.StreetViewPanoramaCamera;
import com.huawei.hms.maps.model.StreetViewSource;

@Deprecated
public final class StreetViewPanoramaOptions implements Parcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new Parcelable.Creator<StreetViewPanoramaOptions>() {
        /* renamed from: a */
        public StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
            return new StreetViewPanoramaOptions(parcel);
        }

        /* renamed from: a */
        public StreetViewPanoramaOptions[] newArray(int i11) {
            return new StreetViewPanoramaOptions[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private StreetViewPanoramaCamera f49346a;

    /* renamed from: b  reason: collision with root package name */
    private String f49347b;

    /* renamed from: c  reason: collision with root package name */
    private LatLng f49348c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f49349d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f49350e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f49351f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f49352g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f49353h;

    /* renamed from: i  reason: collision with root package name */
    private Boolean f49354i;

    /* renamed from: j  reason: collision with root package name */
    private StreetViewSource f49355j;

    public StreetViewPanoramaOptions() {
        Boolean bool = Boolean.TRUE;
        this.f49350e = bool;
        this.f49351f = bool;
        this.f49352g = bool;
        this.f49353h = bool;
    }

    public StreetViewPanoramaOptions(Parcel parcel) {
        Boolean bool = Boolean.TRUE;
        this.f49350e = bool;
        this.f49351f = bool;
        this.f49352g = bool;
        this.f49353h = bool;
    }

    public int describeContents() {
        return 0;
    }

    public Boolean getPanningGesturesEnabled() {
        return this.f49352g;
    }

    public String getPanoramaId() {
        return this.f49347b;
    }

    public LatLng getPosition() {
        return this.f49348c;
    }

    public Integer getRadius() {
        return this.f49349d;
    }

    public StreetViewSource getSource() {
        return this.f49355j;
    }

    public Boolean getStreetNamesEnabled() {
        return this.f49353h;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.f49346a;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.f49354i;
    }

    public Boolean getUserNavigationEnabled() {
        return this.f49350e;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.f49351f;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean z11) {
        this.f49352g = Boolean.valueOf(z11);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.f49346a = streetViewPanoramaCamera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String str) {
        this.f49347b = str;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng) {
        this.f49348c = latLng;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, StreetViewSource streetViewSource) {
        this.f49348c = latLng;
        this.f49355j = streetViewSource;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.f49348c = latLng;
        this.f49349d = num;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, Integer num, StreetViewSource streetViewSource) {
        this.f49348c = latLng;
        this.f49349d = num;
        this.f49355j = streetViewSource;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean z11) {
        this.f49353h = Boolean.valueOf(z11);
        return this;
    }

    public String toString() {
        return "";
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z11) {
        this.f49354i = Boolean.valueOf(z11);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean z11) {
        this.f49350e = Boolean.valueOf(z11);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i11) {
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean z11) {
        this.f49351f = Boolean.valueOf(z11);
        return this;
    }
}
