package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import java.util.ArrayList;
import java.util.List;

public class CircleOptions implements Parcelable {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new Parcelable.Creator<CircleOptions>() {
        /* renamed from: a */
        public CircleOptions createFromParcel(Parcel parcel) {
            return new CircleOptions(parcel);
        }

        /* renamed from: a */
        public CircleOptions[] newArray(int i11) {
            return new CircleOptions[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private LatLng f49454a;

    /* renamed from: b  reason: collision with root package name */
    private int f49455b = 0;

    /* renamed from: c  reason: collision with root package name */
    private double f49456c;

    /* renamed from: d  reason: collision with root package name */
    private int f49457d = ViewCompat.MEASURED_STATE_MASK;

    /* renamed from: e  reason: collision with root package name */
    private List<PatternItem> f49458e;

    /* renamed from: f  reason: collision with root package name */
    private float f49459f = 10.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f49460g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f49461h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f49462i = true;

    public CircleOptions() {
    }

    public CircleOptions(Parcel parcel) {
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.f49454a = (LatLng) parcelReader.readParcelable(2, LatLng.CREATOR, null);
        this.f49455b = parcelReader.readInt(3, 0);
        this.f49456c = parcelReader.readDouble(4, 0.0d);
        this.f49457d = parcelReader.readInt(5, 0);
        this.f49458e = parcelReader.createTypedList(6, PatternItem.CREATOR, (ArrayList) null);
        this.f49459f = parcelReader.readFloat(7, 0.0f);
        this.f49460g = parcelReader.readFloat(8, 0.0f);
        this.f49461h = parcelReader.readBoolean(9, true);
        this.f49462i = parcelReader.readBoolean(10, true);
    }

    public CircleOptions center(LatLng latLng) {
        this.f49454a = latLng;
        return this;
    }

    public CircleOptions clickable(boolean z11) {
        this.f49461h = z11;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions fillColor(int i11) {
        this.f49455b = i11;
        return this;
    }

    public LatLng getCenter() {
        return this.f49454a;
    }

    public int getFillColor() {
        return this.f49455b;
    }

    public double getRadius() {
        return this.f49456c;
    }

    public int getStrokeColor() {
        return this.f49457d;
    }

    public List<PatternItem> getStrokePattern() {
        return this.f49458e;
    }

    public float getStrokeWidth() {
        return this.f49459f;
    }

    public float getZIndex() {
        return this.f49460g;
    }

    public boolean isClickable() {
        return this.f49461h;
    }

    public boolean isVisible() {
        return this.f49462i;
    }

    public CircleOptions radius(double d11) {
        this.f49456c = d11;
        return this;
    }

    public CircleOptions strokeColor(int i11) {
        this.f49457d = i11;
        return this;
    }

    public CircleOptions strokePattern(List<PatternItem> list) {
        this.f49458e = list;
        return this;
    }

    public CircleOptions strokeWidth(float f11) {
        this.f49459f = f11;
        return this;
    }

    public CircleOptions visible(boolean z11) {
        this.f49462i = z11;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeParcelable(2, this.f49454a, i11, false);
        parcelWrite.writeInt(3, this.f49455b);
        parcelWrite.writeDouble(4, this.f49456c);
        parcelWrite.writeInt(5, this.f49457d);
        parcelWrite.writeTypedList(6, this.f49458e, false);
        parcelWrite.writeFloat(7, this.f49459f);
        parcelWrite.writeFloat(8, this.f49460g);
        parcelWrite.writeBoolean(9, this.f49461h);
        parcelWrite.writeBoolean(10, this.f49462i);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }

    public CircleOptions zIndex(float f11) {
        this.f49460g = f11;
        return this;
    }
}
