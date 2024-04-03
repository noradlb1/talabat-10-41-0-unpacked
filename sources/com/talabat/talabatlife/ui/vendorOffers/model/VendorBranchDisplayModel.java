package com.talabat.talabatlife.ui.vendorOffers.model;

import com.talabat.talabatcommon.extentions.DoubleKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/talabat/talabatlife/ui/vendorOffers/model/VendorBranchDisplayModel;", "", "()V", "address", "", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "distanceInMeters", "", "getDistanceInMeters", "()D", "setDistanceInMeters", "(D)V", "id", "", "getId", "()I", "setId", "(I)V", "latitude", "getLatitude", "setLatitude", "longitude", "getLongitude", "setLongitude", "name", "getName", "setName", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorBranchDisplayModel {
    @NotNull
    private String address;
    private double distanceInMeters;

    /* renamed from: id  reason: collision with root package name */
    private int f12105id = IntKt.orZero(IntCompanionObject.INSTANCE);
    private double latitude;
    private double longitude;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private String f12106name;

    public VendorBranchDisplayModel() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.f12106name = StringUtils.empty(stringCompanionObject);
        this.address = StringUtils.empty(stringCompanionObject);
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        this.latitude = DoubleKt.orZero(doubleCompanionObject);
        this.longitude = DoubleKt.orZero(doubleCompanionObject);
        this.distanceInMeters = DoubleKt.orZero(doubleCompanionObject);
    }

    @NotNull
    public final String getAddress() {
        return this.address;
    }

    public final double getDistanceInMeters() {
        return this.distanceInMeters;
    }

    public final int getId() {
        return this.f12105id;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @NotNull
    public final String getName() {
        return this.f12106name;
    }

    public final void setAddress(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.address = str;
    }

    public final void setDistanceInMeters(double d11) {
        this.distanceInMeters = d11;
    }

    public final void setId(int i11) {
        this.f12105id = i11;
    }

    public final void setLatitude(double d11) {
        this.latitude = d11;
    }

    public final void setLongitude(double d11) {
        this.longitude = d11;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f12106name = str;
    }
}
