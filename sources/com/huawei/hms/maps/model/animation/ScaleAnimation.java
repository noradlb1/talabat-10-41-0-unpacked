package com.huawei.hms.maps.model.animation;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.animation.Interpolator;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;

public class ScaleAnimation extends Animation {
    public static final Parcelable.Creator<ScaleAnimation> CREATOR = new Parcelable.Creator<ScaleAnimation>() {
        /* renamed from: a */
        public ScaleAnimation createFromParcel(Parcel parcel) {
            return new ScaleAnimation(new ParcelReader(parcel));
        }

        /* renamed from: a */
        public ScaleAnimation[] newArray(int i11) {
            return new ScaleAnimation[0];
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private float f49584h;

    /* renamed from: i  reason: collision with root package name */
    private float f49585i;

    /* renamed from: j  reason: collision with root package name */
    private float f49586j;

    /* renamed from: k  reason: collision with root package name */
    private float f49587k;

    public ScaleAnimation(float f11, float f12, float f13, float f14) {
        this.f49573a = 3;
        this.f49574b = 1;
        this.f49584h = Math.max(f11, 0.0f);
        this.f49585i = Math.max(f12, 0.0f);
        this.f49586j = Math.max(f13, 0.0f);
        this.f49587k = Math.max(f14, 0.0f);
    }

    public ScaleAnimation(ParcelReader parcelReader) {
        super(parcelReader);
        this.f49584h = parcelReader.readFloat(8, 0.0f);
        this.f49585i = parcelReader.readFloat(9, 0.0f);
        this.f49586j = parcelReader.readFloat(10, 0.0f);
        this.f49587k = parcelReader.readFloat(11, 0.0f);
    }

    public void a(ParcelWrite parcelWrite, int i11) {
        parcelWrite.writeFloat(8, this.f49584h);
        parcelWrite.writeFloat(9, this.f49585i);
        parcelWrite.writeFloat(10, this.f49586j);
        parcelWrite.writeFloat(11, this.f49587k);
    }

    public float getFromX() {
        return this.f49584h;
    }

    public float getFromY() {
        return this.f49586j;
    }

    public float getToX() {
        return this.f49585i;
    }

    public float getToY() {
        return this.f49587k;
    }

    public void setDuration(long j11) {
        this.f49577e = Math.max(j11, 0);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f49578f = interpolator;
    }
}
