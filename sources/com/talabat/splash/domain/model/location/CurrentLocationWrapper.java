package com.talabat.splash.domain.model.location;

import android.location.Location;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB!\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000eR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/talabat/splash/domain/model/location/CurrentLocationWrapper;", "", "()V", "locationSuccess", "", "location", "Landroid/location/Location;", "accuracy", "", "permissionStatus", "", "(ZLandroid/location/Location;FI)V", "isLocationFetchSuccess", "mCurrentLocation", "(ZLandroid/location/Location;Ljava/lang/Float;)V", "getAccuracy", "()Ljava/lang/Float;", "setAccuracy", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "()Z", "setLocationFetchSuccess", "(Z)V", "getMCurrentLocation", "()Landroid/location/Location;", "setMCurrentLocation", "(Landroid/location/Location;)V", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CurrentLocationWrapper {
    @Nullable
    private Float accuracy;
    private boolean isLocationFetchSuccess;
    @Nullable
    private Location mCurrentLocation;

    public CurrentLocationWrapper(boolean z11, @Nullable Location location, @Nullable Float f11) {
        this.isLocationFetchSuccess = z11;
        this.mCurrentLocation = location;
        this.accuracy = f11;
    }

    @Nullable
    public final Float getAccuracy() {
        return this.accuracy;
    }

    @Nullable
    public final Location getMCurrentLocation() {
        return this.mCurrentLocation;
    }

    public final boolean isLocationFetchSuccess() {
        return this.isLocationFetchSuccess;
    }

    public final void setAccuracy(@Nullable Float f11) {
        this.accuracy = f11;
    }

    public final void setLocationFetchSuccess(boolean z11) {
        this.isLocationFetchSuccess = z11;
    }

    public final void setMCurrentLocation(@Nullable Location location) {
        this.mCurrentLocation = location;
    }

    public CurrentLocationWrapper() {
        this(false, (Location) null, Float.valueOf(150.0f));
    }

    public CurrentLocationWrapper(boolean z11, @Nullable Location location, float f11, int i11) {
        this();
    }
}
