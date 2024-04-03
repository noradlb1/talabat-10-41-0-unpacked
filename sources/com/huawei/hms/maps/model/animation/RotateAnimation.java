package com.huawei.hms.maps.model.animation;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.animation.Interpolator;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;

public class RotateAnimation extends Animation {
    public static final Parcelable.Creator<RotateAnimation> CREATOR = new Parcelable.Creator<RotateAnimation>() {
        /* renamed from: a */
        public RotateAnimation createFromParcel(Parcel parcel) {
            return new RotateAnimation(new ParcelReader(parcel));
        }

        /* renamed from: a */
        public RotateAnimation[] newArray(int i11) {
            return new RotateAnimation[0];
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private float f49582h;

    /* renamed from: i  reason: collision with root package name */
    private float f49583i;

    public RotateAnimation(float f11, float f12) {
        this.f49573a = 2;
        this.f49582h = f11;
        this.f49583i = f12;
    }

    public RotateAnimation(ParcelReader parcelReader) {
        super(parcelReader);
        this.f49582h = parcelReader.readFloat(8, 0.0f);
        this.f49583i = parcelReader.readFloat(9, 0.0f);
    }

    public void a(ParcelWrite parcelWrite, int i11) {
        parcelWrite.writeFloat(8, this.f49582h);
        parcelWrite.writeFloat(9, this.f49583i);
    }

    public float getFromDegree() {
        return this.f49582h;
    }

    public float getToDegree() {
        return this.f49583i;
    }

    public void setDuration(long j11) {
        this.f49577e = Math.max(j11, 0);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f49578f = interpolator;
    }
}
