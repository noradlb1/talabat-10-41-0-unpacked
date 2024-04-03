package com.talabat.talabatcommon.feature.ramadan.header;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/ramadan/header/UserLocation;", "", "lat", "", "lng", "(DD)V", "getLat", "()D", "setLat", "(D)V", "getLng", "setLng", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserLocation {
    private double lat;
    private double lng;

    public UserLocation(double d11, double d12) {
        this.lat = d11;
        this.lng = d12;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLng() {
        return this.lng;
    }

    public final void setLat(double d11) {
        this.lat = d11;
    }

    public final void setLng(double d11) {
        this.lng = d11;
    }
}
