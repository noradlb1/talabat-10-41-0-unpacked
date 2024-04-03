package com.huawei.hms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.ViewCompat;
import com.huawei.hms.common.parcel.ParcelReader;
import com.huawei.hms.common.parcel.ParcelWrite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PolygonOptions implements Parcelable {
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new Parcelable.Creator<PolygonOptions>() {
        /* renamed from: a */
        public PolygonOptions createFromParcel(Parcel parcel) {
            return new PolygonOptions(parcel);
        }

        /* renamed from: a */
        public PolygonOptions[] newArray(int i11) {
            return new PolygonOptions[i11];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final List<LatLng> f49533a;

    /* renamed from: b  reason: collision with root package name */
    private final List<List<LatLng>> f49534b;

    /* renamed from: c  reason: collision with root package name */
    private float f49535c;

    /* renamed from: d  reason: collision with root package name */
    private int f49536d;

    /* renamed from: e  reason: collision with root package name */
    private int f49537e;

    /* renamed from: f  reason: collision with root package name */
    private float f49538f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f49539g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f49540h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f49541i;

    /* renamed from: j  reason: collision with root package name */
    private int f49542j;

    /* renamed from: k  reason: collision with root package name */
    private List<PatternItem> f49543k;

    public PolygonOptions() {
        this.f49535c = 10.0f;
        this.f49536d = ViewCompat.MEASURED_STATE_MASK;
        this.f49537e = 0;
        this.f49538f = 0.0f;
        this.f49539g = true;
        this.f49540h = false;
        this.f49541i = false;
        this.f49542j = 0;
        this.f49543k = null;
        this.f49533a = new ArrayList();
        this.f49534b = new ArrayList();
        this.f49543k = new ArrayList();
    }

    public PolygonOptions(Parcel parcel) {
        this.f49535c = 10.0f;
        this.f49536d = ViewCompat.MEASURED_STATE_MASK;
        this.f49537e = 0;
        this.f49538f = 0.0f;
        this.f49539g = true;
        this.f49540h = false;
        this.f49541i = false;
        this.f49542j = 0;
        this.f49543k = null;
        ParcelReader parcelReader = new ParcelReader(parcel);
        this.f49533a = parcelReader.createTypedList(2, LatLng.CREATOR, new ArrayList());
        ArrayList arrayList = new ArrayList();
        parcelReader.readList(3, arrayList, LatLng.class.getClassLoader());
        this.f49534b = arrayList;
        this.f49535c = parcelReader.readFloat(4, 0.0f);
        this.f49536d = parcelReader.readInt(5, 0);
        this.f49537e = parcelReader.readInt(6, 0);
        this.f49538f = parcelReader.readFloat(7, 0.0f);
        this.f49539g = parcelReader.readBoolean(8, true);
        this.f49540h = parcelReader.readBoolean(9, true);
        this.f49541i = parcelReader.readBoolean(10, true);
        this.f49542j = parcelReader.readInt(11, 0);
        this.f49543k = parcelReader.createTypedList(12, PatternItem.CREATOR, (ArrayList) null);
    }

    public PolygonOptions add(LatLng latLng) {
        this.f49533a.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.f49533a.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f49533a.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : iterable) {
            arrayList.add(add);
        }
        this.f49534b.add(arrayList);
        return this;
    }

    public PolygonOptions clickable(boolean z11) {
        this.f49541i = z11;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public PolygonOptions fillColor(int i11) {
        this.f49537e = i11;
        return this;
    }

    public PolygonOptions geodesic(boolean z11) {
        this.f49540h = z11;
        return this;
    }

    public int getFillColor() {
        return this.f49537e;
    }

    public List<List<LatLng>> getHoles() {
        return this.f49534b;
    }

    public List<LatLng> getPoints() {
        return this.f49533a;
    }

    public int getStrokeColor() {
        return this.f49536d;
    }

    public int getStrokeJointType() {
        return this.f49542j;
    }

    public List<PatternItem> getStrokePattern() {
        return this.f49543k;
    }

    public float getStrokeWidth() {
        return this.f49535c;
    }

    public float getZIndex() {
        return this.f49538f;
    }

    public boolean isClickable() {
        return this.f49541i;
    }

    public boolean isGeodesic() {
        return this.f49540h;
    }

    public boolean isVisible() {
        return this.f49539g;
    }

    public PolygonOptions strokeColor(int i11) {
        this.f49536d = i11;
        return this;
    }

    public PolygonOptions strokeJointType(int i11) {
        this.f49542j = i11;
        return this;
    }

    public PolygonOptions strokePattern(List<PatternItem> list) {
        this.f49543k = list;
        return this;
    }

    public PolygonOptions strokeWidth(float f11) {
        this.f49535c = f11;
        return this;
    }

    public PolygonOptions visible(boolean z11) {
        this.f49539g = z11;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i11) {
        ParcelWrite parcelWrite = new ParcelWrite(parcel);
        int beginObjectHeader = parcelWrite.beginObjectHeader();
        parcelWrite.writeTypedList(2, this.f49533a, false);
        parcelWrite.writeList(3, this.f49534b, false);
        parcelWrite.writeFloat(4, this.f49535c);
        parcelWrite.writeInt(5, this.f49536d);
        parcelWrite.writeInt(6, this.f49537e);
        parcelWrite.writeFloat(7, this.f49538f);
        parcelWrite.writeBoolean(8, this.f49539g);
        parcelWrite.writeBoolean(9, this.f49540h);
        parcelWrite.writeBoolean(10, this.f49541i);
        parcelWrite.writeInt(11, this.f49542j);
        parcelWrite.writeTypedList(12, this.f49543k, false);
        parcelWrite.finishObjectHeader(beginObjectHeader);
    }

    public PolygonOptions zIndex(float f11) {
        this.f49538f = f11;
        return this;
    }
}
