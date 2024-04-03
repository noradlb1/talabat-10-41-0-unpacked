package com.huawei.hms.maps.model.animation;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.animation.Interpolator;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import com.huawei.hms.maps.model.LatLng;

public class TranslateAnimation extends Animation {
    public static final Parcelable.Creator<TranslateAnimation> CREATOR = new Parcelable.Creator<TranslateAnimation>() {
        /* renamed from: a */
        public TranslateAnimation createFromParcel(Parcel parcel) {
            return new TranslateAnimation(new ParcelReader(parcel));
        }

        /* renamed from: a */
        public TranslateAnimation[] newArray(int i11) {
            return new TranslateAnimation[0];
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private LatLng f49588h;

    public TranslateAnimation(ParcelReader parcelReader) {
        super(parcelReader);
        this.f49588h = (LatLng) parcelReader.readParcelable(8, LatLng.CREATOR, null);
    }

    public TranslateAnimation(LatLng latLng) {
        this.f49573a = 4;
        this.f49588h = latLng;
    }

    public void a(ParcelWrite parcelWrite, int i11) {
        parcelWrite.writeParcelable(8, this.f49588h, i11, false);
    }

    public LatLng getTarget() {
        return this.f49588h;
    }

    public void setDuration(long j11) {
        this.f49577e = j11;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f49578f = interpolator;
    }
}
