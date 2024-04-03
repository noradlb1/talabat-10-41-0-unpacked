package com.huawei.hms.maps.model.animation;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.animation.Interpolator;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;

public class AlphaAnimation extends Animation {
    public static final Parcelable.Creator<AlphaAnimation> CREATOR = new Parcelable.Creator<AlphaAnimation>() {
        /* renamed from: a */
        public AlphaAnimation createFromParcel(Parcel parcel) {
            return new AlphaAnimation(new ParcelReader(parcel));
        }

        /* renamed from: a */
        public AlphaAnimation[] newArray(int i11) {
            return new AlphaAnimation[0];
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private float f49571h;

    /* renamed from: i  reason: collision with root package name */
    private float f49572i;

    public AlphaAnimation(float f11, float f12) {
        this.f49573a = 1;
        this.f49571h = Math.min(Math.max(f11, 0.0f), 1.0f);
        this.f49572i = Math.min(Math.max(f12, 0.0f), 1.0f);
    }

    public AlphaAnimation(ParcelReader parcelReader) {
        super(parcelReader);
        this.f49571h = parcelReader.readFloat(8, 0.0f);
        this.f49572i = parcelReader.readFloat(9, 0.0f);
    }

    public void a(ParcelWrite parcelWrite, int i11) {
        parcelWrite.writeFloat(8, this.f49571h);
        parcelWrite.writeFloat(9, this.f49572i);
    }

    public float getFromAlpha() {
        return this.f49571h;
    }

    public float getToAlpha() {
        return this.f49572i;
    }

    public void setDuration(long j11) {
        this.f49577e = Math.max(j11, 0);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f49578f = interpolator;
    }
}
